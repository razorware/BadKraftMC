package net.brutalcore.mod;

import net.brutalcore.mod.models.blocks.JewelersTable;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Created by david on 6/7/2019.
 */
public class Blocks {	
	
    //	Initialize blocks
	public static final Block JEWELERS_TABLE;

	static {
		JEWELERS_TABLE = register("jewelers_table", new JewelersTable(JewelersTable.JEWELERSTABLESETTINGS.build()));
	}
	
	private static Block register(String name, Block block) {
		System.out.println("register block: " + name);
		
		return (Block)Registry.register(Registry.BLOCK, new Identifier("brutalcore", name), block);
	}

	public static void init() {
		//	if debug
		System.out.println("completed initializing blocks...");
	}
	
}
