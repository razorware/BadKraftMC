package net.brutalcore.mod.models.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.network.ClientDummyContainerProvider;
import net.minecraft.container.BlockContext;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.container.StonecutterContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JewelersTable extends Block {
	private static final Component CONTAINER_NAME = new TranslatableComponent("container.jewelers", new Object[0]);
	
	public static final FabricBlockSettings JEWELERSTABLESETTINGS = FabricBlockSettings
			.of(Material.WOOD)
			.strength(2.5F, 1F)
			.sounds(BlockSoundGroup.WOOD);
	
	public JewelersTable(Block.Settings settings) {
		super(settings);
	}

	@Override
	public boolean activate(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
		playerEntity.openContainer(blockState.createContainerProvider(world, blockPos));
		playerEntity.incrementStat(Stats.INTERACT_WITH_STONECUTTER);
      
		return true;
	}

	public NameableContainerProvider createContainerProvider(BlockState blockState_1, World world_1, BlockPos blockPos_1) {
		return new ClientDummyContainerProvider((int_1, playerInventory_1, playerEntity_1) -> {
			return new StonecutterContainer(int_1, playerInventory_1, BlockContext.create(world_1, blockPos_1));
		}, CONTAINER_NAME);
	}
}
