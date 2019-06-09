package net.brutalcore.mod;

import net.brutalcore.mod.models.items.UncutDiamond;
import net.brutalcore.mod.models.items.UnrefinedGoldBar;
import net.brutalcore.mod.models.items.UnrefinedGoldOre;
import net.brutalcore.mod.models.items.UnrefinedIronBar;
import net.brutalcore.mod.models.items.UnrefinedIronOre;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Created by david on 5/27/2019.
 */
public class Items {
    //	Initialize items
	public static final Item JEWELERS_TABLE;	
	public static final Item UNCUT_DIAMOND;
	public static final Item UNREFINED_GOLD_ORE;
	public static final Item UNREFINED_GOLD_BAR;
    public static final Item UNREFINED_IRON_ORE;
    public static final Item UNREFINED_IRON_BAR;
    
    static {
    	JEWELERS_TABLE = registerBlock(Blocks.JEWELERS_TABLE, ItemGroup.DECORATIONS);
    	
    	UNCUT_DIAMOND = register("uncut_diamond", new UncutDiamond(new Item.Settings()
    			.itemGroup(ItemGroup.MISC)));
    	UNREFINED_GOLD_ORE = register("unrefined_gold_ore", new UnrefinedGoldOre(new Item.Settings()
    			.itemGroup(ItemGroup.MISC)));
    	UNREFINED_GOLD_BAR = register("unrefined_gold_bar", new UnrefinedGoldBar(new Item.Settings()
    			.itemGroup(ItemGroup.MISC)));
    	UNREFINED_IRON_ORE = register("unrefined_iron_ore", new UnrefinedIronOre(new Item.Settings()
                .itemGroup(ItemGroup.MISC)));
    	UNREFINED_IRON_BAR = register("unrefined_iron_bar", new UnrefinedIronBar(new Item.Settings()
        		.itemGroup(ItemGroup.MISC)));
    }

	private static Item registerBlock(Block block, ItemGroup itemGroup) {
		return register(new BlockItem(block, (new Item.Settings()).itemGroup(itemGroup)));
	}

	private static Item register(BlockItem blockItem) {
		return register((Block)blockItem.getBlock(), blockItem);
	}

	private static Item register(Block block, Item item) {
		return register(Registry.BLOCK.getId(block), item);
	}
	
	private static Item register(String name, Item item) {
		System.out.println("register item: " + name);
		
		return register(new Identifier("brutalcore", name), item);
	}

	private static Item register(Identifier identifier, Item item) {
		if (item instanceof BlockItem) {
			((BlockItem)item).registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
		}

		return (Item)Registry.register(Registry.ITEM, (Identifier)identifier, item);
	}

	public static void init() {
		//	if debug
		System.out.println("completed initializing items...");
	}
}
