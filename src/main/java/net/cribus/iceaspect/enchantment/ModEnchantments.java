package net.cribus.iceaspect.enchantment;

import net.cribus.iceaspect.IceAspect;
import net.cribus.iceaspect.enchantment.custom.IceAspectEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> ICE_ASPECT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(IceAspect.MOD_ID, "ice_aspect"));

    public static final TagKey<Enchantment> ICE_ASPECT_CONFLICTS =
            TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(IceAspect.MOD_ID, "exclusive_set/ice_aspect_conflicts"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, ICE_ASPECT, Enchantment.enchantment(Enchantment.definition(
            items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                2,
                2,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(60, 20),
                4,
                EquipmentSlotGroup.MAINHAND)).exclusiveWith(enchantments.getOrThrow(ICE_ASPECT_CONFLICTS)).withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM, new IceAspectEnchantmentEffect()));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}
