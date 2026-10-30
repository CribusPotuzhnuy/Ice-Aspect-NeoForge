package net.cribus.iceaspect.effect;

import net.cribus.iceaspect.IceAspect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, IceAspect.MOD_ID);

    public static final Holder<MobEffect> FREEZING_EFFECT = MOB_EFFECTS.register("freezing",
            () -> new FreezingEffect(MobEffectCategory.HARMFUL, 0x80e5ef).addAttributeModifier(
                    Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(IceAspect.MOD_ID, "freezing"),
                    -0.50f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
