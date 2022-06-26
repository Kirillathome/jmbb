package com.kirill.jmbb;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface FireflySpawnEventCallback {
	Event<FireflySpawnEventCallback> EVENT = EventFactory.createArrayBacked(FireflySpawnEventCallback.class,
			(listeners) -> (player, block) -> {
				for (FireflySpawnEventCallback listener : listeners) {
					ActionResult result = listener.interact(player, block);

					if(result != ActionResult.PASS) {
						return result;
					}
				}

				return ActionResult.PASS;
			});

	ActionResult interact(PlayerEntity player, Block block);
}
