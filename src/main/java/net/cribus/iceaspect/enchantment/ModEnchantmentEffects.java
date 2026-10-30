package net.cribus.iceaspect.enchantment;

import com.mojang.serialization.MapCodec;
import net.cribus.iceaspect.IceAspect;
import net.cribus.iceaspect.enchantment.custom.IceAspectEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, IceAspect.MOD_ID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> ICE_ASPECT =
            ENTITY_ENCHANTMENT_EFFECTS.register("ice_aspect", () -> IceAspectEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
