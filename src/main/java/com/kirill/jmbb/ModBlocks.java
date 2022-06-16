package com.kirill.jmbb;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {

	private static Block registerBlock(String name, Block block, ItemGroup group) {
		registerBlockItem(name, block, group);
		return Registry.register(Registry.BLOCK, new Identifier(JmbbMod.Mod_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup group) {
		return Registry.register(Registry.ITEM, new Identifier(JmbbMod.Mod_ID, name),
				new BlockItem(block, new QuiltItemSettings().group(group)));
	}

	public static void registerModBlocks() {
		JmbbMod.LOGGER.info("Registering ModBlocks for: " + JmbbMod.Mod_ID);
	}
}
