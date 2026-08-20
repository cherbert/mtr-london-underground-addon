/*
 * London Underground PIDS - JCM PIDS script
 *
 * Row 1        lead train, always shown
 * Row 2        second train, replaced by STAND BACK once the lead train is due
 * Row 3        third train, cycling with the second while STAND BACK shows
 * Clock        centred below the rows, with seconds
 */
include(Resources.id("jsblock:scripts/pids_util.js"));

// ---------------------------------------------------------------- tuning ----
const FONT_NS       = "londonunderground";
const FONT_PATH     = "london-underground-regular";
const FONT          = FONT_NS + ":" + FONT_PATH;

// RenderNorthernLinePIDS builds this with the TWO-argument Identifier
// constructor, and that demonstrably works. Resources.id() parses a combined
// string instead, which may or may not split the namespace. Prefer the
// two-argument form to match the Java, falling back if the class is not
// reachable from script.
function makeFontId() {
    try {
        importClass(org.mtr.mapping.holder.Identifier);
        return new Identifier(FONT_NS, FONT_PATH);
    } catch (e) {
        return Resources.id(FONT);
    }
}
const FONT_ID       = makeFontId();
const COLOR         = 0xFFB000;   // dot-matrix amber
// Left/right inset for all row text, in the corrected 150x60 canvas.
const SIDE_PADDING  = 4;
// Vertical offset of the first row. Raise to push the whole stack down.
const TOP_PADDING   = 17;
// Distance between rows, independent of TOP_PADDING so that moving the stack
// down does not squash the rows together.
const ROW_PITCH     = 11;
const ROW_COUNT     = 3;
const ETA_WIDTH     = 30;
// Row text scale. 1.725 came from JCM's PIDS 1A, whose canvas differs from
// ours - it overran the panel badly. Lower this to shrink the arrival rows.
const TEXT_SCALE    = 1.0;

// "due" starts showing when the train is this close.
const DUE_AT_MS     = 60000;
// STAND BACK begins this long after "due" first appears, so with the values
// above it fires at 30s out. Change this one number to retime the warning.
const AFTER_DUE_MS  = 30000;
const APPROACH_MS   = DUE_AT_MS - AFTER_DUE_MS;

const WIPE_MS       = 1400;       // time for the cursor to cross the row
const WIPE_LTR      = false;      // false = cursor travels right-to-left
const CURSOR_W      = 4;
// Approximate glyph advance, used to work out how many characters the cursor
// has passed. There is no measureText in the script API, so this is estimated;
// raise it if the erase runs ahead of the square, lower it if it lags behind.
const CHAR_W        = 5;
// Warning flash. One full on/off cycle takes FLASH_MS * 2.
const FLASH_MS      = 500;
const ROW3_CYCLE_MS = 3000;       // dwell per train on row 3
const ROW3_SCROLL_MS = 450;       // slide duration between the two trains
// Roll travel, set to one full text height so the outgoing entry clears the
// band as the incoming one enters. Shorter values make the two overlap, which
// reads as blur rather than a roll. The lower mask must be at least this tall.
const ROW3_SCROLL_DIST = 9;
// Height of a row's text box, matching the value passed to size().
const ROW_TEXT_H    = 9;
// Roll masks. A flat black texture from JCM, tinted, used as a solid fill.
const MASK_TEXTURE  = "jsblock:textures/block/pids/black.png";
// | 0 forces the signed 32-bit value. Written plain, 0xFF000000 is 4278190080,
// which overflows Java's signed int and Rhino refuses to convert it - every
// mask draw then throws and silently does nothing.
const MASK_COLOR    = 0xFF000000 | 0;
const MASK_PAD      = 2;
// Explicit layering. The roll masks sit above row 3 so they can clip it, but
// below everything else, so they cannot touch rows 1-2 or the clock.
// IMPORTANT: zOrder is not an abstract sort key. JCM applies it as
// translate(0, 0, zOrder * 0.0002), so every step physically lifts the draw off
// the panel. Only the ORDER matters, so these are kept adjacent - large values
// leave the text visibly floating above the model.
const ROW3_Z        = 0;     // outgoing row 3 entry
const ROW3_BACK_Z   = 1;     // opaque backing carried by the incoming entry
const ROW3_IN_Z     = 2;     // incoming row 3 entry
const MASK_Z        = 3;     // static mask hiding anything above the band
const ROW_Z         = 4;     // rows 1 and 2
// The flash mask hides part of row 2, so unlike the roll masks it has to sit
// ABOVE the rows - at MASK_Z the warning text would draw over its own mask.
const FLASH_MASK_Z  = 5;
// Horizontal mask inset. Now 0: the canvas matches the model, so no fudge.
const MASK_INSET    = SIDE_PADDING;
// Bottom of the model's lit screen area, in canvas pixels. Masks may reach this
// far but no further, or they paint over the model's border. Lower it if black
// bleeds onto the border; raise it if row 3 scrolls into view below the mask.
const DISPLAY_BOTTOM = 60;
// Extra width each side of the STAND BACK mask. Raise if letter edges still
// show through when it flashes off, lower if it starts covering the *** or -.
const FLASH_MASK_BLEED = 2;
// The clock sits below row 3 and within reach of the lower roll mask, so it
// has to outrank it.
const CLOCK_Z       = 6;

// Clock. Kept separate from the rows because it needs its own scale and must
// not be stretched - stretchXY() fills the box and mangles the glyphs.
const CLOCK_SCALE   = 1.0;
const CLOCK_WIDTH   = 46;
const CLOCK_BOTTOM  = 12;         // distance from the bottom edge; raise to move up
const CLOCK_X_SHIFT = 0;          // horizontal nudge from centre; negative = left
const CLOCK_BOLD    = true;       // synthetic bold: redraws the glyph offset
// true = real-world clock; false = Minecraft's in-game time of day.
const CLOCK_REALTIME = true;

// Only the middle segment blinks; the surrounding text stays lit throughout.
const WARN_PREFIX   = "*** ";
const WARN_FLASH    = "STAND BACK";
const WARN_SUFFIX   = " - TRAIN APPROACHING ***";
const WARN_FULL     = WARN_PREFIX + WARN_FLASH + WARN_SUFFIX;
// A custom message is an explicit choice by whoever configured the block, so it
// wins over the STAND BACK warning. Set false to give the warning precedence
// instead, on the grounds that it is a safety message.
const CUSTOM_MSG_OVERRIDES_WARNING = true;

// ------------------------------------------------------------- diagnostics --
// Set true to dump the script scope to the log on next reload.
const DEBUG_PROBE   = false;

// Draws a 1px outline at the exact canvas edges, (0,0) to (width,height). One
// look shows where the canvas actually sits relative to the Background element
// - which every mask bound depends on, and which has so far been inferred
// rather than measured. Set false once we have the answer.
const DEBUG_BOUNDS  = false;
// A white texture so color() can tint it: tinting the black mask texture is
// pointless, since black multiplied by anything stays black.
const DEBUG_TEXTURE = "minecraft:textures/misc/white.png";
const DEBUG_COLOR   = 0xFFFF0000 | 0;   // red, unmistakable against the amber

// One-shot probe: reports which globals this script context actually exposes.
// This is how we settle where in-game time comes from. Delete once resolved.
// Enumerating the real scope beats guessing names: the classes in the jar are
// exposed to scripts under different identifiers (TimingJS -> Timing, and the
// tracker classes are not exposed as globals at all).
function globalScope() {
    try { return (function () { return this; })(); } catch (e) { return null; }
}

function members(obj) {
    let out = [];
    try { for (let k in obj) out.push(k); } catch (e) { return "<not enumerable: " + e + ">"; }
    return out.sort().join(", ");
}

function log(msg) {
    try { if (typeof console !== "undefined" && console.log) { console.log("[LU-PIDS] " + msg); return; } } catch (e) {}
    try { if (typeof ConsoleJS !== "undefined" && ConsoleJS.log) { ConsoleJS.log("[LU-PIDS] " + msg); return; } } catch (e) {}
    try { if (typeof print === "function") { print("[LU-PIDS] " + msg); } } catch (e) {}
}

function probe(ctx, pids) {
    log("---- globals ----");
    let g = globalScope();
    log("  " + (g ? members(g) : "<global scope unreachable>"));

    // Route to in-game time. MinecraftClient should expose the world, and
    // the world knows its time of day.
    log("---- MinecraftClient ----");
    log("  " + (typeof MinecraftClient !== "undefined" ? members(MinecraftClient) : "<absent>"));
    try {
        let w = MinecraftClient.getInstance().getWorldMapped();
        log("  world = " + w);
        log("  world members = " + members(w));
    } catch (e) {
        log("  world lookup threw: " + e);
    }
    log("---- MTRClientData ----");
    log("  " + (typeof MTRClientData !== "undefined" ? members(MTRClientData) : "<absent>"));

    // Font diagnosis: if this does not stringify to the londonunderground
    // namespace, the identifier is the reason the font falls back.
    log("---- font id ----");
    try {
        log("  ns='" + FONT_ID.getNamespace() + "' path='" + FONT_ID.getPath() + "'");
    } catch (e) {
        log("  getNamespace/getPath threw: " + e);
    }
    log("---- end probe ----");
}

// ------------------------------------------------------------------ utils --
function pad2(n) {
    return Math.floor(n).toString().padStart(2, "0");
}

// In-game clock with seconds. PIDSUtil.formatTime() gives HH:MM only, so this
// derives seconds the same way that helper derives minutes.
function formatInGameClock(inGameTime) {
    let t = inGameTime + 6000;
    let hrs = (t / 1000) % 24;
    let mins = (hrs - Math.floor(hrs)) * 60;
    let secs = (mins - Math.floor(mins)) * 60;
    return pad2(hrs) + ":" + pad2(mins % 60) + ":" + pad2(secs % 60);
}

// Real-world fallback, used only if in-game time cannot be read.
function formatRealClock() {
    let d = new Date();
    return pad2(d.getHours()) + ":" + pad2(d.getMinutes()) + ":" + pad2(d.getSeconds());
}

// In-game time of day. The MinecraftClient global is already the wrapper
// instance - there is no getInstance() on it.
function inGameDayTime() {
    try {
        let t = MinecraftClient.worldDayTime;
        if (typeof t === "function") t = MinecraftClient.worldDayTime();
        return t;
    } catch (e) {
        return null;
    }
}

function clockText() {
    if (CLOCK_REALTIME) return formatRealClock();
    let t = inGameDayTime();
    if (t === null || t === undefined) return formatRealClock();
    return formatInGameClock(t);
}

// Milliseconds until this train arrives.
function msUntil(arrival) {
    if (arrival == null) return Number.MAX_VALUE;
    if (arrival.arrived()) return 0;
    return arrival.arrivalTime() - Date.now();
}

function etaText(arrival) {
    if (arrival == null) return "";
    let ms = msUntil(arrival);
    if (ms <= DUE_AT_MS) return "due";
    let mins = Math.floor(ms / 60000);
    return mins + (mins === 1 ? " min" : " mins");
}

// Row 3 is drawn from more than one place and, mid-slide, twice in a frame.
// The draw names are suffixed so the two simultaneous rows stay distinct.
let row3DrawSeq = 0;
function drawRow3(ctx, pids, arrival, y, textW, z) {
    if (arrival == null) return;
    let zz = (z === undefined) ? ROW3_Z : z;
    let tag = "R3-" + (row3DrawSeq++ % 2);
    drawText(ctx, tag + " Dest", rowLabel(pids, arrival), SIDE_PADDING, y, textW - ETA_WIDTH, false, false, zz);
    drawText(ctx, tag + " ETA", etaText(arrival), pids.width - SIDE_PADDING, y, ETA_WIDTH, true, false, zz);
}

// Paints a solid rectangle in PIDS space. Texture inherits pos/size/draw from
// PIDSDrawCall, and a flat black texture tinted by color() gives a fill. Used
// to hide row 3's overflow so the slide reads as a roll through a window
// rather than content shoving its neighbours around.
// Diagnostic only: a visible rectangle, drawn above everything.
let debugSeq = 0;
function drawDebugRect(ctx, x, y, w, h) {
    try {
        Texture.create("Bounds" + (debugSeq++ % 4))
            .texture(DEBUG_TEXTURE)
            .color(DEBUG_COLOR)
            .zOrder(CLOCK_Z)
            .pos(x, y)
            .size(w, h)
            .draw(ctx);
    } catch (e) {
        log("BOUNDS FAILED: " + e);
    }
}

let maskFailureLogged = false;
let maskSeq = 0;
function drawMask(ctx, x, y, w, h, z) {
    if (h <= 0 || w <= 0) return;
    try {
        Texture.create("Mask" + (maskSeq++ % 4))
            .texture(MASK_TEXTURE)
            .color(MASK_COLOR)
            .zOrder(z === undefined ? MASK_Z : z)
            .pos(x, y)
            .size(w, h)
            .draw(ctx);
    } catch (e) {
        // Cosmetic, so never take the display down - but say so once, otherwise
        // a rejected draw call looks identical to no masking at all.
        if (!maskFailureLogged) {
            maskFailureLogged = true;
            log("MASK FAILED: " + e);
        }
    }
}

// Row 3, including the roll between arrivals 2 and 3 while the warning is up.
function renderRow3Band(ctx, state, pids, now, approaching, second, third, textW, rowH) {
    let y = TOP_PADDING + (rowH * 2);

    // A custom message takes the row outright - no arrivals, no roll.
    let msg = customMessage(pids, 2);
    if (msg !== "") {
        drawText(ctx, "R3 Custom", msg, SIDE_PADDING, y, textW, false, false, ROW3_Z);
        return;
    }

    if (!approaching || second == null) {
        drawRow3(ctx, pids, third, y, textW);
        return;
    }
    if (third == null) {
        drawRow3(ctx, pids, second, y, textW);
        return;
    }

    // Anchored to the END of the wipe, not to approachSince. Two animations
    // kicking off together read as noise, so row 3 holds on arrival 2 until the
    // square has finished clearing row 2, then begins its cycle.
    let sinceWipeEnd = now - state.approachSince - WIPE_MS;
    if (sinceWipeEnd < 0) {
        drawRow3(ctx, pids, second, y, textW);
        return;
    }

    let cyclePos = sinceWipeEnd % (ROW3_CYCLE_MS * 2);
    let onSecond = cyclePos < ROW3_CYCLE_MS;
    let intoPhase = cyclePos % ROW3_CYCLE_MS;

    let current = onSecond ? second : third;
    let previous = onSecond ? third : second;

    if (ROW3_SCROLL_DIST <= 0 || intoPhase >= ROW3_SCROLL_MS) {
        drawRow3(ctx, pids, current, y, textW);
        return;
    }

    // A two-way roll: both entries travel up together, one text-height apart,
    // so the outgoing one leaves through the top as the new one arrives from
    // the bottom.
    //
    // The band needs clipping on both sides, and the two sides are handled
    // differently:
    //
    //   below - the incoming entry starts beneath the band, past the bottom of
    //           the Background, where the protruding casing occludes it. The
    //           model does that clipping for free.
    //
    //   above - the outgoing entry rises into ROW 2's space, which is well
    //           inside the panel, so the casing cannot help: without a mask it
    //           simply rides up over the line above. The mask sits at MASK_Z,
    //           below ROW_Z, so it hides row 3's overflow without touching
    //           row 2 itself.
    let p = intoPhase / ROW3_SCROLL_MS;
    drawRow3(ctx, pids, previous, y - (ROW_TEXT_H * p), textW, ROW3_Z);
    drawRow3(ctx, pids, current, y + (ROW_TEXT_H * (1 - p)), textW, ROW3_Z);
    drawMask(ctx, MASK_INSET, y - ROW_TEXT_H, pids.width - (MASK_INSET * 2), ROW_TEXT_H, MASK_Z);
}

// "Hide platform number" in the block's config screen drops the leading platform
// name, leaving just the destination.
function rowLabel(pids, arrival) {
    if (arrival == null) return "";
    let dest = TextUtil.cycleString(arrival.destination()).trim();
    if (pids.isPlatformNumberHidden()) return dest;
    let plat = arrival.platformName();
    return (plat ? plat + " " : "") + dest;
}

// Per-row custom message from the config screen. Returns "" when unset.
// Passed through cycleString so "A|B" alternates, matching JCM's own presets.
function customMessage(pids, row) {
    let msg = pids.getCustomMessage(row);
    if (msg == null || msg == "") return "";
    return TextUtil.cycleString(msg);
}

// The clock draws on its own terms: centred, aspect preserved, no synthetic
// bold. Minecraft's bold redraws the glyph one pixel over, which on a
// dot-matrix face reads as a smear rather than a heavier weight.
function drawClock(ctx, pids, str) {
    let t = Text.create("Clock")
        .text(str)
        .scale(CLOCK_SCALE)
        .size(CLOCK_WIDTH, 9)
        .scaleXY()
        .centerAlign()
        .zOrder(CLOCK_Z)
        .font(FONT_ID)
        .color(COLOR)
        .pos((pids.width / 2) + CLOCK_X_SHIFT, pids.height - CLOCK_BOTTOM);
    if (CLOCK_BOLD) t = t.bold();
    t.draw(ctx);
}

// z defaults to ROW_Z so rows 1-2 and the warning sit above the roll masks
// without every call site having to say so. Row 3 passes ROW3_Z explicitly.
function drawText(ctx, name, str, x, y, width, rightAligned, bold, z) {
    let t = Text.create(name)
        .text(str)
        .scale(TEXT_SCALE)
        .size(width / TEXT_SCALE, 9)
        .stretchXY()
        .zOrder(z === undefined ? ROW_Z : z)
        .font(FONT_ID)
        .color(COLOR)
        .pos(x, y);
    if (rightAligned) t = t.rightAlign();
    if (bold) t = t.bold();
    t.draw(ctx);
}

// Cursor block.
// NOTE: QuadDrawCall.corner1..4 take a ScriptVector3f, and I have not confirmed
// how to construct one from script, so this uses a filled glyph in the vanilla
// font instead - guaranteed present, and close enough to tune against.
function drawCursor(ctx, x, y) {
    Text.create("Wipe Cursor")
        .text("█")
        .scale(TEXT_SCALE)
        .size(CURSOR_W, 9)
        .stretchXY()
        .fontMC()
        .color(COLOR)
        .pos(x, y)
        .draw(ctx);
}

// ----------------------------------------------------------------- script --
function create(ctx, state, pids) {
    state.probed = false;
    state.approachSince = 0;
    state.wasApproaching = false;
}

function render(ctx, state, pids) {
    if (DEBUG_PROBE && !state.probed) { state.probed = true; probe(ctx, pids); }

    const rowH = ROW_PITCH;
    const textW = pids.width - (SIDE_PADDING * 2);
    const now = Date.now();

    const lead = pids.arrivals().get(0);
    const second = pids.arrivals().get(1);
    const third = pids.arrivals().get(2);

    // Warning starts once the lead train is inside APPROACH_MS, i.e. a set
    // interval after row 1 begins reading "due".
    const approaching = lead != null && msUntil(lead) <= APPROACH_MS;
    if (approaching && !state.wasApproaching) state.approachSince = now;
    state.wasApproaching = approaching;

    const sinceApproach = now - state.approachSince;
    const wiping = approaching && sinceApproach < WIPE_MS;
    const wipeProgress = wiping ? (sinceApproach / WIPE_MS) : 1;

    // --- row 3 first ------------------------------------------------------
    // Drawn before the rows above it on purpose: the roll masks paint over the
    // strips either side of row 3, so anything drawn after them stays on top
    // and cannot be clipped by them.
    if (!pids.isRowHidden(2)) {
        renderRow3Band(ctx, state, pids, now, approaching, second, third, textW, rowH);
    }

    // --- row 1: custom message, else the lead train ------------------------
    if (!pids.isRowHidden(0)) {
        let y = TOP_PADDING;
        let msg = customMessage(pids, 0);
        if (msg !== "") {
            drawText(ctx, "R1 Custom", msg, SIDE_PADDING, y, textW, false);
        } else if (lead != null) {
            drawText(ctx, "R1 Dest", rowLabel(pids, lead), SIDE_PADDING, y, textW - ETA_WIDTH, false);
            drawText(ctx, "R1 ETA", etaText(lead), pids.width - SIDE_PADDING, y, ETA_WIDTH, true);
        }
    }

    // --- row 2: second train, wiped away, then the warning ----------------
    let row2Msg = customMessage(pids, 1);
    // A custom message on row 2 competes with the warning. The warning wins by
    // default, since it is the point of the preset; flip the constant to let a
    // configured message take precedence instead.
    let row2ShowsMsg = row2Msg !== "" && (!approaching || CUSTOM_MSG_OVERRIDES_WARNING);
    if (!pids.isRowHidden(1)) {
        let y = TOP_PADDING + rowH;
        if (row2ShowsMsg) {
            drawText(ctx, "R2 Custom", row2Msg, SIDE_PADDING, y, textW, false);
        } else if (!approaching) {
            if (second != null) {
                drawText(ctx, "R2 Dest", rowLabel(pids, second), SIDE_PADDING, y, textW - ETA_WIDTH, false);
                drawText(ctx, "R2 ETA", etaText(second), pids.width - SIDE_PADDING, y, ETA_WIDTH, true);
            }
        } else if (wiping) {
            // The square erases the row as it travels, a character at a time.
            //
            // The box passed to drawText stays at its full width throughout:
            // stretchXY() shrinks text that overflows its box, so narrowing the
            // box is what squeezed the glyphs before. Shortening the string
            // inside a fixed box erases cleanly instead.
            let cx = WIPE_LTR
                ? SIDE_PADDING + (textW * wipeProgress)
                : pids.width - SIDE_PADDING - (textW * wipeProgress);

            if (second != null) {
                let label = rowLabel(pids, second);
                let eta = etaText(second);
                let destBox = textW - ETA_WIDTH;
                // The ETA is right-aligned, so find where it actually starts.
                let etaLeft = pids.width - SIDE_PADDING - (eta.length * CHAR_W);

                if (WIPE_LTR) {
                    // Eaten from the left: drop leading characters and shift the
                    // remainder right so the surviving text stays put.
                    let gone = Math.floor((cx - SIDE_PADDING) / CHAR_W);
                    if (gone < label.length) {
                        let keptFrom = Math.max(0, gone);
                        drawText(ctx, "R2 Dest", label.substring(keptFrom),
                                 SIDE_PADDING + (keptFrom * CHAR_W), y, destBox, false);
                    }
                    let etaGone = Math.floor((cx - etaLeft) / CHAR_W);
                    if (etaGone < eta.length) {
                        let etaFrom = Math.max(0, etaGone);
                        drawText(ctx, "R2 ETA", eta.substring(etaFrom),
                                 etaLeft + (etaFrom * CHAR_W), y, ETA_WIDTH, false);
                    }
                } else {
                    // Eaten from the right: keep the leading characters only.
                    let keep = Math.floor((cx - SIDE_PADDING) / CHAR_W);
                    if (keep > 0) {
                        drawText(ctx, "R2 Dest", label.substring(0, Math.min(keep, label.length)),
                                 SIDE_PADDING, y, destBox, false);
                    }
                    let etaKeep = Math.floor((cx - etaLeft) / CHAR_W);
                    if (etaKeep > 0) {
                        drawText(ctx, "R2 ETA", eta.substring(0, Math.min(etaKeep, eta.length)),
                                 etaLeft, y, ETA_WIDTH, false);
                    }
                }
            }
            drawCursor(ctx, cx, y);
        } else {
            // Always draw the identical full string, then mask the middle when
            // unlit. Substituting spaces changed the string's drawn width, so
            // stretchXY() picked a different fit scale and the surrounding text
            // visibly resized between flashes.
            let sinceWipe = sinceApproach - WIPE_MS;
            let lit = Math.floor(sinceWipe / FLASH_MS) % 2 === 0;
            drawText(ctx, "R2 Warning", WARN_FULL, SIDE_PADDING, y, textW, false);
            if (!lit) {
                // Character-proportional estimate of where the middle sits
                // within the fitted line.
                let startFrac = WARN_PREFIX.length / WARN_FULL.length;
                let endFrac = (WARN_PREFIX.length + WARN_FLASH.length) / WARN_FULL.length;
                // Widened either side: the proportional estimate lands a little
                // narrow, leaving slivers of the first and last letter showing.
                // The bleed falls in the spaces around the phrase, so it does
                // not eat the punctuation on either side.
                drawMask(ctx,
                         SIDE_PADDING + (startFrac * textW) - FLASH_MASK_BLEED,
                         y - 1,
                         ((endFrac - startFrac) * textW) + (FLASH_MASK_BLEED * 2),
                         ROW_TEXT_H + 2,
                         FLASH_MASK_Z);
            }
        }
    }

    // --- clock ------------------------------------------------------------
    // TODO: switch to formatInGameClock() once the probe reveals the in-game
    // time source. Real time stands in, and matches once Time & Wind is on.
    drawClock(ctx, pids, clockText());

    // --- canvas bounds diagnostic -----------------------------------------
    if (DEBUG_BOUNDS) {
        drawDebugRect(ctx, 0, 0, pids.width, 1);                  // top
        drawDebugRect(ctx, 0, pids.height - 1, pids.width, 1);    // bottom
        drawDebugRect(ctx, 0, 0, 1, pids.height);                 // left
        drawDebugRect(ctx, pids.width - 1, 0, 1, pids.height);    // right
    }
}

function dispose(ctx, state, pids) {
}
