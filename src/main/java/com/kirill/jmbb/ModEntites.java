package com.kirill.jmbb;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntites {

	public static final EntityType<FireflyEntity> FIREFLY = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("jmbb", "firefly"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, FireflyEntity::new).dimensions(EntityDimensions.fixed(5, 5)).build()
	);
	public static void registerModEntities() {
		JmbbMod.LOGGER.info("Registering Entities for:" + JmbbMod.Mod_ID);
		EntityRendererRegistry.register(ModEntites.FIREFLY, (context) -> new EmptyEntityRenderer<>(context));
	}
}
