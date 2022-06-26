package com.kirill.jmbb.mixin;

import com.kirill.jmbb.FireflySpawnEventCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class FireflySpawnerMixin {
	@Shadow
	protected abstract Block asBlock();

	@Inject(at = @At(value = "HEAD"), method = "onBreak", cancellable = true)
	private void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo ci) {
		ActionResult result = FireflySpawnEventCallback.EVENT.invoker().interact(player, this.asBlock());

		if (result == ActionResult.FAIL) {
			ci.cancel();

		}
	}
}
