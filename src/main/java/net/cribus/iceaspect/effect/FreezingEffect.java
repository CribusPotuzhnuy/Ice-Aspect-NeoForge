package net.cribus.iceaspect.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezingEffect extends MobEffect {
    public FreezingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.isOnFire()) {
            // Remove the freezing effect
            livingEntity.removeEffect(ModEffects.FREEZING_EFFECT);
            livingEntity.setTicksFrozen(0);
            return false;
        }

        livingEntity.setTicksFrozen(Math.max(livingEntity.getTicksFrozen(), 300));

        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
