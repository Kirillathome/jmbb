package com.kirill.jmbb.mixin;

import com.kirill.jmbb.ModParticles;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(OverworldBiomeCreator.class)
public abstract class FireflySpawnerMixin {
	@Shadow
	private static void addBasicFeatures(GenerationSettings.Builder generationSettings) {
		DefaultBiomeFeatures.addLandCarvers(generationSettings);
		DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
		DefaultBiomeFeatures.addDungeons(generationSettings);
		DefaultBiomeFeatures.addUndergroundVariety(generationSettings);
		DefaultBiomeFeatures.addSprings(generationSettings);
		DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
	}

	@Shadow
	protected static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	/**
	 * @author Kirillathome
	 * @reason Fireflies
	 */
	@Overwrite
	public static Biome createSwamp() {
		SpawnSettings.Builder builder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(builder);
		DefaultBiomeFeatures.addBatsAndMonsters(builder);
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 10, 2, 5));
		GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addFossils(builder2);
		addBasicFeatures(builder2);
		DefaultBiomeFeatures.addDefaultOres(builder2);
		DefaultBiomeFeatures.addClayDisk(builder2);
		DefaultBiomeFeatures.addSwampFeatures(builder2);
		DefaultBiomeFeatures.addDefaultMushrooms(builder2);
		DefaultBiomeFeatures.addSwampVegetation(builder2);
		builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
		MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SWAMP);
		return new Biome.Builder()
				.precipitation(Biome.Precipitation.RAIN)
				.temperature(0.8F)
				.downfall(0.9F)
				.effects(
						new BiomeEffects.Builder()
								.particleConfig(new BiomeParticleConfig(ModParticles.FIREFLY, 0.008f))
								.waterColor(6388580)
								.waterFogColor(2302743)
								.fogColor(12638463)
								.skyColor(getSkyColor(0.8F))
								.foliageColor(6975545)
								.grassColorModifier(BiomeEffects.GrassColorModifier.SWAMP)
								.moodSound(BiomeMoodSound.CAVE)
								.music(musicSound)
								.build()
				)
				.spawnSettings(builder.build())
				.generationSettings(builder2.build())
				.build();
	}
	/**
	 * @author Kirillathome
	 * @reason Fireflies
	 */
	@Overwrite
	public static Biome method_43232() {
		SpawnSettings.Builder builder = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addBatsAndMonsters(builder);
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 10, 2, 5));
		builder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
		GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
		DefaultBiomeFeatures.addFossils(builder2);
		addBasicFeatures(builder2);
		DefaultBiomeFeatures.addDefaultOres(builder2);
		DefaultBiomeFeatures.addGrassAndClayDisks(builder2);
		DefaultBiomeFeatures.addMangroveSwampFeatures(builder2);
		builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
		MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SWAMP);
		return new Biome.Builder()
				.precipitation(Biome.Precipitation.RAIN)
				.temperature(0.8F)
				.downfall(0.9F)
				.effects(
						new BiomeEffects.Builder()
								.particleConfig(new BiomeParticleConfig(ModParticles.FIREFLY, 0.008f))
								.waterColor(3832426)
								.waterFogColor(5077600)
								.fogColor(12638463)
								.skyColor(getSkyColor(0.8F))
								.foliageColor(9285927)
								.grassColorModifier(BiomeEffects.GrassColorModifier.SWAMP)
								.moodSound(BiomeMoodSound.CAVE)
								.music(musicSound)
								.build()
				)
				.spawnSettings(builder.build())
				.generationSettings(builder2.build())
				.build();
	}
}
