package net.brutalcore.mod.models.blocks;

import net.brutalcore.mod.models.containers.JewelersContainer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.client.network.ClientDummyContainerProvider;
import net.minecraft.container.BlockContext;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sound.BlockSoundGroup;
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
		//playerEntity.incrementStat(Stats.INTERACT_WITH_STONECUTTER);
      
		return true;
	}

	public NameableContainerProvider createContainerProvider(BlockState blockState, World world, BlockPos blockPos) {
		return new ClientDummyContainerProvider((id, playerInventory, playerEntity) -> {
			return new JewelersContainer(id, playerInventory, BlockContext.create(world, blockPos));
		}, CONTAINER_NAME);
	}
}
