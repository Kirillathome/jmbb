package com.kirill.jmbb;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
	public static final DefaultParticleType FIREFLY = FabricParticleTypes.simple();



	public static void registerModParticles() {
		JmbbMod.LOGGER.info("Registering ModParticles for: " + JmbbMod.Mod_ID);

		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
			registry.register(new Identifier("jmbb", "particle/firefly"));
		}));

		ParticleFactoryRegistry.getInstance().register(ModParticles.FIREFLY, GlowParticle.GlowFactory::new);

		Registry.register(Registry.PARTICLE_TYPE, new Identifier("jmbb", "firefly"), FIREFLY);
	}
}
