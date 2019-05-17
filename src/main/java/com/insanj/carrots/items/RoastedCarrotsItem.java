package com.insanj.carrots.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.FoodItemSettings;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import com.insanj.carrots.CarrotsMod;
import com.insanj.carrots.util.CarrotsParticleUtil;

public class RoastedCarrotsItem extends Item {
	public static final String ITEM_ID = "roasted_carrots";
	private static final FoodItemSetting FOOD_SETTING = (new FoodItemSetting.Builder()).hunger(6).saturationModifier(0.6F).eatenFast().build();

	public RoastedCarrotsItem() {
		super(new Item.Settings().food(FOOD_SETTING).itemGroup(ItemGroup.FOOD));
	}

	@Override
	public ItemStack onItemFinishedUsing(ItemStack stack, World world, LivingEntity entity) {
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

		return super.onItemFinishedUsing(stack, world, entity);
	}
}