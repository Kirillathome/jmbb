package com.kirill.jmbb;

import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModBlocks {

	public static final Block COBBLESTONE_BRICKS = registerBlock("cobblestone_bricks", new Block(QuiltBlockSettings.of(Material.METAL).strength(2.0f, 6.0f).requiresTool()), ItemGroup.BUILDING_BLOCKS);


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
