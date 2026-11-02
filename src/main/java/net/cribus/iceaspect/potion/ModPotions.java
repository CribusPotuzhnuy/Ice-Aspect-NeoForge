package net.cribus.iceaspect.potion;

import com.sun.jna.platform.win32.OaIdl;
import net.cribus.iceaspect.IceAspect;
import net.cribus.iceaspect.effect.FreezingEffect;
import net.cribus.iceaspect.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, IceAspect.MOD_ID);

    public static final Holder<Potion> FREEZING_POTION = POTIONS.register("freezing_potion",
            () -> new Potion("freezing_potion", new MobEffectInstance(ModEffects.FREEZING_EFFECT, 900, 0)));



    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
