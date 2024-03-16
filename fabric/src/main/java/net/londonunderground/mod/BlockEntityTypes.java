package net.londonunderground.mod;

import net.londonunderground.mod.blocks.*;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.registry.BlockEntityTypeRegistryObject;

@SuppressWarnings("unchecked")
public final class BlockEntityTypes {

	static {
		DARK_TILE = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "tunnel_darkness"), TunnelDarknessBlock.TileEntityTunnelDarkness::new, Blocks.TUNNEL_DARKNESS::get);
		PIDS_NORTHERN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "pids_northern"), NorthernLinePIDS.TileEntityNorthernLinePIDS::new, Blocks.NORTHERN_PIDS::get);
		TUNNEL_BLOCK_2_SIGNAL = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "tunnel_block_2_signal"), BlockTunnelSignal.TileEntityTunnelSignalLight1::new, Blocks.TUNNEL_BLOCK_2_SIGNAL::get);
		TUNNEL_A2_SIGNAL = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "tunnel_a2_signal"), TunnelA2Signal.TileEntityTunnelSignalLight1::new, Blocks.TUNNEL_A2_SIGNAL::get);
		BRITISH_RAIL_UNDERGROUND_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "british_rail_underground"), BritishRailUnderground.TileEntityBritishRailUnderground::new, Blocks.BRITISH_RAIL_UNDERGROUND::get);

		BLOCK_ROUNDEL_NLE_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_nle"), BlockRoundelNLE.TileEntityBlockRoundelNLE::new, Blocks.BLOCK_ROUNDEL_NLE::get);
		BLOCK_ROUNDEL_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_1"), BlockRoundel.TileEntityBlockRoundel::new, Blocks.BLOCK_ROUNDEL_1::get);
		BLOCK_ROUNDEL_BIG_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_1_big"), BlockRoundelBig.TileEntityBlockRoundelBig::new, Blocks.BLOCK_ROUNDEL_1_BIG::get);
		BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_1_big_even"), BlockRoundelBigEven.TileEntityBlockRoundelBigEven::new, Blocks.BLOCK_ROUNDEL_1_BIG_EVEN::get);

		BLOCK_ROUNDEL2_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_2"), BlockRoundel2.TileEntityBlockRoundel2::new, Blocks.BLOCK_ROUNDEL_2::get);
		BLOCK_ROUNDEL2_BIG_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_2_big"), BlockRoundel2Big.TileEntityBlockRoundel2Big::new, Blocks.BLOCK_ROUNDEL_2_BIG::get);
		BLOCK_ROUNDEL2_BIG_EVEN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_2_big_even"), BlockRoundel2BigEven.TileEntityBlockRoundel2BigEven::new, Blocks.BLOCK_ROUNDEL_2_BIG_EVEN::get);

		BLOCK_ROUNDEL3_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_3"), BlockRoundel3.TileEntityBlockRoundel3::new, Blocks.BLOCK_ROUNDEL_3::get);
		BLOCK_ROUNDEL3_BIG_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_3_big"), BlockRoundel3Big.TileEntityBlockRoundel3Big::new, Blocks.BLOCK_ROUNDEL_3_BIG::get);
		BLOCK_ROUNDEL3_BIG_EVEN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_3_big_even"), BlockRoundel3BigEven.TileEntityBlockRoundel3BigEven::new, Blocks.BLOCK_ROUNDEL_3_BIG_EVEN::get);

		BLOCK_ROUNDEL4_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_4"), BlockRoundel4.TileEntityBlockRoundel4::new, Blocks.BLOCK_ROUNDEL_4::get);
		BLOCK_ROUNDEL4_BIG_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_4_big"), BlockRoundel4Big.TileEntityBlockRoundel4Big::new, Blocks.BLOCK_ROUNDEL_4_BIG::get);
		BLOCK_ROUNDEL4_BIG_EVEN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_4_big_even"), BlockRoundel4BigEven.TileEntityBlockRoundel4BigEven::new, Blocks.BLOCK_ROUNDEL_4_BIG_EVEN::get);

		BLOCK_ROUNDEL5_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_5"), BlockRoundel5.TileEntityBlockRoundel5::new, Blocks.BLOCK_ROUNDEL_5::get);
		BLOCK_ROUNDEL5_BIG_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_5_big"), BlockRoundel5Big.TileEntityBlockRoundel5Big::new, Blocks.BLOCK_ROUNDEL_5_BIG::get);
		BLOCK_ROUNDEL5_BIG_EVEN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_5_big_even"), BlockRoundel5BigEven.TileEntityBlockRoundel5BigEven::new, Blocks.BLOCK_ROUNDEL_5_BIG_EVEN::get);

		BLOCK_ROUNDEL_STATION_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_station"), BlockRoundelStation.TileEntityBlockRoundelStation::new, Blocks.BLOCK_ROUNDEL_STATION::get);
		BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_station_type_b"), BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB::new, Blocks.BLOCK_ROUNDEL_STATION_TYPE_B::get);
		BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_station_type_c"), BlockRoundelStationTypeC.TileEntityBlockRoundelStationTypeC::new, Blocks.BLOCK_ROUNDEL_STATION_TYPE_C::get);
		BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "block_roundel_station_top"), BlockRoundelStationTop.TileEntityBlockRoundelStationTop::new, Blocks.BLOCK_ROUNDEL_STATION_TOP::get);
		MORDEN_SIGN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "morden_sign"), MordenSign.TileEntityMordenSign::new, Blocks.MORDEN_SIGN::get);
		METROPOLITAN_SIGN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "metropolitan_sign"), MetropolitanSign.TileEntityMetropolitanSign::new, Blocks.METROPOLITAN_SIGN::get);
		ELIZABETH_SIGN_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "elizabeth_sign"), ElizabethSign.TileEntityElizabethSign::new, Blocks.ELIZABETH_SIGN::get);

		SIGN_RIVER_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_river"), SignRiver.TileEntitySignRiver::new, Blocks.SIGN_RIVER::get);
		SIGN_OVERGROUND_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_overground"), SignOverground.TileEntitySignOverground::new, Blocks.SIGN_OVERGROUND::get);
		SIGN_DLR_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_dlr"), SignDlr.TileEntitySignDlr::new, Blocks.SIGN_DLR::get);
		SIGN_TRAMS_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_trams"), SignTrams.TileEntitySignTrams::new, Blocks.SIGN_TRAMS::get);
		SIGN_POPPY_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_poppy"), SignPoppy.TileEntitySignPoppy::new, Blocks.SIGN_POPPY::get);
		SIGN_METRO_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_metro"), SignMetro.TileEntitySignMetro::new, Blocks.SIGN_METRO::get);
		SIGN_LIZZY_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_lizzy"), SignLizzy.TileEntitySignLizzy::new, Blocks.SIGN_LIZZY::get);
		SIGN_UNDERGROUND_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_underground"), SignUnderground.TileEntitySignUnderground::new, Blocks.SIGN_UNDERGROUND::get);
		SIGN_PRIDE_TILE_ENTITY = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "sign_pride"), SignPride.TileEntitySignPride::new, Blocks.SIGN_PRIDE::get);

		NAME_PROJECTOR = Init.REGISTRY.registerBlockEntityType(new Identifier(Init.MOD_ID, "name_projector"), NameProjector.TileEntityNameProjector::new, Blocks.NAME_PROJECTOR::get);
	}

	public static final BlockEntityTypeRegistryObject<TunnelDarknessBlock.TileEntityTunnelDarkness> DARK_TILE;
	public static final BlockEntityTypeRegistryObject<NorthernLinePIDS.TileEntityNorthernLinePIDS> PIDS_NORTHERN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockTunnelSignal.TileEntityTunnelSignalLight1> TUNNEL_BLOCK_2_SIGNAL;
	public static final BlockEntityTypeRegistryObject<TunnelA2Signal.TileEntityTunnelSignalLight1> TUNNEL_A2_SIGNAL;
	public static final BlockEntityTypeRegistryObject<BritishRailUnderground.TileEntityBritishRailUnderground> BRITISH_RAIL_UNDERGROUND_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelNLE.TileEntityBlockRoundelNLE> BLOCK_ROUNDEL_NLE_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel.TileEntityBlockRoundel> BLOCK_ROUNDEL_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelBig.TileEntityBlockRoundelBig> BLOCK_ROUNDEL_BIG_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelBigEven.TileEntityBlockRoundelBigEven> BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel2.TileEntityBlockRoundel2> BLOCK_ROUNDEL2_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel2Big.TileEntityBlockRoundel2Big> BLOCK_ROUNDEL2_BIG_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel2BigEven.TileEntityBlockRoundel2BigEven> BLOCK_ROUNDEL2_BIG_EVEN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel3.TileEntityBlockRoundel3> BLOCK_ROUNDEL3_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel3Big.TileEntityBlockRoundel3Big> BLOCK_ROUNDEL3_BIG_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel3BigEven.TileEntityBlockRoundel3BigEven> BLOCK_ROUNDEL3_BIG_EVEN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel4.TileEntityBlockRoundel4> BLOCK_ROUNDEL4_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel4Big.TileEntityBlockRoundel4Big> BLOCK_ROUNDEL4_BIG_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel4BigEven.TileEntityBlockRoundel4BigEven> BLOCK_ROUNDEL4_BIG_EVEN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel5.TileEntityBlockRoundel5> BLOCK_ROUNDEL5_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel5Big.TileEntityBlockRoundel5Big> BLOCK_ROUNDEL5_BIG_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundel5BigEven.TileEntityBlockRoundel5BigEven> BLOCK_ROUNDEL5_BIG_EVEN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelStation.TileEntityBlockRoundelStation> BLOCK_ROUNDEL_STATION_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB> BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelStationTypeC.TileEntityBlockRoundelStationTypeC> BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<BlockRoundelStationTop.TileEntityBlockRoundelStationTop> BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<MordenSign.TileEntityMordenSign> MORDEN_SIGN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<MetropolitanSign.TileEntityMetropolitanSign> METROPOLITAN_SIGN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<ElizabethSign.TileEntityElizabethSign> ELIZABETH_SIGN_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignRiver.TileEntitySignRiver> SIGN_RIVER_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignOverground.TileEntitySignOverground> SIGN_OVERGROUND_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignDlr.TileEntitySignDlr> SIGN_DLR_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignTrams.TileEntitySignTrams> SIGN_TRAMS_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignPoppy.TileEntitySignPoppy> SIGN_POPPY_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignMetro.TileEntitySignMetro> SIGN_METRO_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignLizzy.TileEntitySignLizzy> SIGN_LIZZY_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignUnderground.TileEntitySignUnderground> SIGN_UNDERGROUND_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<SignPride.TileEntitySignPride> SIGN_PRIDE_TILE_ENTITY;
	public static final BlockEntityTypeRegistryObject<NameProjector.TileEntityNameProjector> NAME_PROJECTOR;

	public static void init() {
		Init.LOGGER.info("Registering MTR London Underground Addon block entity types");
	}
}
