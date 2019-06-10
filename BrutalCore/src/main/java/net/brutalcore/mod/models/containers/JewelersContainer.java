package net.brutalcore.mod.models.containers;

import net.minecraft.container.BlockContext;
import net.minecraft.container.Container;
import net.minecraft.container.ContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

public class JewelersContainer extends Container {
	private BlockContext blockContext;
	private PlayerInventory playerInventory;

	public BlockContext getBlockContext() {
		return blockContext;
	}

	public void setBlockContext(BlockContext blockContext) {
		this.blockContext = blockContext;
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

	public JewelersContainer(int id, PlayerInventory playerInventory, BlockContext blockContext) {
		super(ContainerType.STONECUTTER, id);
		
		this.setBlockContext(blockContext);
		this.setPlayerInventory(playerInventory);
	}

	@Override
	public boolean canUse(PlayerEntity playerEntity) {
		return true;
	}

}
