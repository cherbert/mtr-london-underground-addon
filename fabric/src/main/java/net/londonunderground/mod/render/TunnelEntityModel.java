package net.londonunderground.mod.render;

import org.mtr.mapping.mapper.EntityExtension;
import org.mtr.mapping.mapper.EntityModelExtension;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mapping.mapper.ModelPartExtension;

import javax.annotation.Nonnull;

public class TunnelEntityModel extends EntityModelExtension<EntityExtension> {

	private final ModelPartExtension main;

	public TunnelEntityModel() {
		super(16, 16);
		main = createModelPart();
		main.setPivot(0, 24, 0);
		main.setTextureUVOffset(0, 0).addCuboid(0, -24, 0, 16, 16, 16, 0, false);
		buildModel();
	}

	@Override
	public void render(@Nonnull GraphicsHolder graphicsHolder, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(graphicsHolder, 0, 0, 0, packedLight, packedOverlay);
	}

	@Override
	public void setAngles2(@Nonnull EntityExtension entity, float v, float v1, float v2, float v3, float v4) {
	}
}
