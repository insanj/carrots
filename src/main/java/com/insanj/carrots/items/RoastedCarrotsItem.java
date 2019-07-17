package com.insanj.carrots.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodComponent;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import com.insanj.carrots.CarrotsMod;
import com.insanj.carrots.util.CarrotsParticleUtil;

public class RoastedCarrotsItem extends Item {
  public static final String ITEM_ID = "roasted_carrots";
  public static final FoodComponent FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).snack().build();

  public RoastedCarrotsItem() {
    super(new Item.Settings().food(FOOD_COMPONENT).group(CarrotsMod.ITEM_GROUP));
  }

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
    // if server-side, produce status effects, else, produce heart effects
    if (!world.isClient) {
      // 1 water breathing effect
      StatusEffectInstance waterBreathing = new StatusEffectInstance(StatusEffect.byRawId(13), 80, 50, true, false);
      entity.addPotionEffect(waterBreathing);

      // 2 night vision effect
      StatusEffectInstance nightVision = new StatusEffectInstance(StatusEffect.byRawId(16), 80, 50, true, false);
      entity.addPotionEffect(nightVision);
    } else {
      Vec3d pos = entity.getPos();
      double upOffset = entity.getEyeHeight(entity.getPose());

      CarrotsParticleUtil.heart(pos.add(0, upOffset, 0));
      CarrotsParticleUtil.heart(pos.add(1, upOffset, 0));
      CarrotsParticleUtil.heart(pos.add(0, upOffset, 1));
      CarrotsParticleUtil.heart(pos.add(-1, upOffset, 0));
      CarrotsParticleUtil.heart(pos.add(0, upOffset, -1));
    }

    return super.finishUsing(stack, world, entity);
  }
}