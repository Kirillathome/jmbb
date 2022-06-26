package com.kirill.jmbb;

import net.minecraft.util.ActionResult;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmbbMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Just More Random Stuff");
	public static final String Mod_ID = "jmbb";


	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		ModParticles.registerModParticles();
		FireflySpawnEventCallback.EVENT.register((player, block) -> {
			player.world.spawnEntity(new FireflyEntity(ModEntites.FIREFLY, player.world));
			return ActionResult.SUCCESS;
		});
		ModEntites.registerModEntities();
	}
}
