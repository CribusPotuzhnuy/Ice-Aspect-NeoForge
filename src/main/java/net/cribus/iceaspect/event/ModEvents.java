package net.cribus.iceaspect.event;

import net.cribus.iceaspect.IceAspect;
import net.cribus.iceaspect.effect.ModEffects;
import net.cribus.iceaspect.potion.ModPotions;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = IceAspect.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDamage(LivingIncomingDamageEvent event) {
        var entity = event.getEntity();
        var source = event.getSource();
        if (entity.hasEffect(ModEffects.FREEZING_EFFECT) && source.is(DamageTypes.FREEZE)) {
            if (entity.isInPowderSnow) {
                return;
            }

            if (event.getAmount() == 1.5f) {
                return;
            }

            event.setAmount(1.5f);
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SNOWBALL, ModPotions.FREEZING_POTION);
    }
}
