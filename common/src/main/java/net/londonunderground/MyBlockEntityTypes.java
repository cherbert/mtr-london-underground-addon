package net.londonunderground;

import mtr.RegistryObject;
import mtr.mappings.RegistryUtilities;
import net.londonunderground.blocks.*;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface MyBlockEntityTypes {

	RegistryObject<BlockEntityType<TunnelDarknessBlock.TileEntityTunnelDarkness>> DARK_TILE = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(TunnelDarknessBlock.TileEntityTunnelDarkness::new, MyBlocks.TUNNEL_DARKNESS.get()));
	RegistryObject<BlockEntityType<NorthernLinePIDS.TileEntityNorthernLinePIDS>> PIDS_NORTHERN_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(NorthernLinePIDS.TileEntityNorthernLinePIDS::new, MyBlocks.NORTHERN_PIDS.get()));
	RegistryObject<BlockEntityType<BlockTunnelSignal.TileEntityTunnelSignalLight1>> TUNNEL_BLOCK_2_SIGNAL = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockTunnelSignal.TileEntityTunnelSignalLight1::new, MyBlocks.TUNNEL_BLOCK_2_SIGNAL.get()));
	RegistryObject<BlockEntityType<BlockRoundel.TileEntityBlockRoundel>> BLOCK_ROUNDEL_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundel.TileEntityBlockRoundel::new, MyBlocks.BLOCK_ROUNDEL_1.get()));
	RegistryObject<BlockEntityType<BlockRoundelBig.TileEntityBlockRoundelBig>> BLOCK_ROUNDEL_BIG_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelBig.TileEntityBlockRoundelBig::new, MyBlocks.BLOCK_ROUNDEL_1_BIG.get()));
	RegistryObject<BlockEntityType<BlockRoundelBigEven.TileEntityBlockRoundelBigEven>> BLOCK_ROUNDEL_BIG_EVEN_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelBigEven.TileEntityBlockRoundelBigEven::new, MyBlocks.BLOCK_ROUNDEL_1_BIG_EVEN.get()));
	RegistryObject<BlockEntityType<BlockRoundel2.TileEntityBlockRoundel2>> BLOCK_ROUNDEL2_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundel2.TileEntityBlockRoundel2::new, MyBlocks.BLOCK_ROUNDEL_2.get()));

	RegistryObject<BlockEntityType<BlockRoundelStation.TileEntityBlockRoundelStation>> BLOCK_ROUNDEL_STATION_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelStation.TileEntityBlockRoundelStation::new, MyBlocks.BLOCK_ROUNDEL_STATION.get()));
	RegistryObject<BlockEntityType<BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB>> BLOCK_ROUNDEL_STATION_TYPE_B_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelStationTypeB.TileEntityBlockRoundelStationTypeB::new, MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_B.get()));
	RegistryObject<BlockEntityType<BlockRoundelStationTypeC.TileEntityBlockRoundelStationTypeC>> BLOCK_ROUNDEL_STATION_TYPE_C_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelStationTypeC.TileEntityBlockRoundelStationTypeC::new, MyBlocks.BLOCK_ROUNDEL_STATION_TYPE_C.get()));
	RegistryObject<BlockEntityType<BlockRoundelStationTop.TileEntityBlockRoundelStationTop>> BLOCK_ROUNDEL_STATION_TOP_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(BlockRoundelStationTop.TileEntityBlockRoundelStationTop::new, MyBlocks.BLOCK_ROUNDEL_STATION_TOP.get()));
	RegistryObject<BlockEntityType<MordenSign.TileEntityMordenSign>> MORDEN_SIGN_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(MordenSign.TileEntityMordenSign::new, MyBlocks.MORDEN_SIGN.get()));
	RegistryObject<BlockEntityType<ElizabethSign.TileEntityElizabethSign>> ELIZABETH_SIGN_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(ElizabethSign.TileEntityElizabethSign::new, MyBlocks.ELIZABETH_SIGN.get()));

	RegistryObject<BlockEntityType<SignRiver.TileEntitySignRiver>> SIGN_RIVER_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(SignRiver.TileEntitySignRiver::new, MyBlocks.SIGN_RIVER.get()));
	RegistryObject<BlockEntityType<SignOverground.TileEntitySignOverground>> SIGN_OVERGROUND_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(SignOverground.TileEntitySignOverground::new, MyBlocks.SIGN_OVERGROUND.get()));
	RegistryObject<BlockEntityType<SignDlr.TileEntitySignDlr>> SIGN_DLR_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(SignDlr.TileEntitySignDlr::new, MyBlocks.SIGN_DLR.get()));
	RegistryObject<BlockEntityType<SignTrams.TileEntitySignTrams>> SIGN_TRAMS_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(SignTrams.TileEntitySignTrams::new, MyBlocks.SIGN_TRAMS.get()));
	RegistryObject<BlockEntityType<SignPoppy.TileEntitySignPoppy>> SIGN_POPPY_TILE_ENTITY = new RegistryObject<>(()->RegistryUtilities.getBlockEntityType(SignPoppy.TileEntitySignPoppy::new, MyBlocks.SIGN_POPPY.get()));

}
