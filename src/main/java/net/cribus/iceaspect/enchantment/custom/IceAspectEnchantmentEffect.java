package net.cribus.iceaspect.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.cribus.iceaspect.effect.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record IceAspectEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<IceAspectEnchantmentEffect> CODEC =
            MapCodec.unit(IceAspectEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (enchantmentLevel > 0 && entity instanceof LivingEntity livingEntity) {
            int duration = 80 + (enchantmentLevel * 60);

            livingEntity.addEffect(new MobEffectInstance(ModEffects.FREEZING_EFFECT, duration, 0, false, true, true));

            if (livingEntity.isOnFire()) {
                livingEntity.clearFire();
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
