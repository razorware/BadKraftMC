package net.brutalcore.mod.models.containers;

import net.minecraft.container.Container;
import net.minecraft.container.ContainerType;
import net.minecraft.entity.player.PlayerEntity;

public class JewelersContainer extends Container {

	protected JewelersContainer(int int_1) {
		super(ContainerType.STONECUTTER, int_1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canUse(PlayerEntity var1) {
		return true;
	}

}
