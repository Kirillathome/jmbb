package com.kirill.jmbb;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.potion.Potions;
import net.minecraft.world.World;


public class FireflyEntity extends AreaEffectCloudEntity{

	public FireflyEntity(EntityType<? extends AreaEffectCloudEntity> entityType, World world) {
		super(entityType, world);
		this.noClip = true;
		this.setRadius(5.0F);
		this.setParticleType(ModParticles.FIREFLY);
		this.setPotion(Potions.NIGHT_VISION);
	}




}
