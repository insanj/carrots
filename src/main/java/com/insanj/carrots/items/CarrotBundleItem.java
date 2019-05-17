package com.insanj.carrots.items;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.block.FabricBlockSettings;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.text.StringTextComponent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.FoodItemSettings;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.client.network.ClientPlayerEntity;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.insanj.carrots.CarrotsMod;

public class CarrotBundleItem extends Item {
	public static final String ITEM_ID = "carrot_bundle";
	private static final FoodItemSetting FOOD_SETTING = (new FoodItemSetting.Builder()).build();

	public CarrotBundleItem() {
		super(new Item.Settings().food(FOOD_SETTING).itemGroup(ItemGroup.FOOD));
	}

	@Override
	public boolean interactWithEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
		World world = player.getEntityWorld();
		if (world.getServer() == null) {
			System.out.println("not doing anything cause server");
			return false;
		}

		if (!(target instanceof PlayerEntity)) {
			return false;
		}

		PlayerEntity targetPlayer = (PlayerEntity)target;

		System.out.println("feeding time");

    stack.subtractAmount(1);

    player.swingHand(hand);
    player.addExhaustion(1.0F);

    HungerManager hungerManager = targetPlayer.getHungerManager();
    // hungerManager.setFoodLevel(hungerManager.getFoodLevel() + 4);
    // hungerManager.setSaturationLevelClient(hungerManager.getSaturationLevel());
    hungerManager.add(4, 0.6F);

    BlockPos pos = target.getBlockPos();
    world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1.0F, 1.0F);

		return true;
	}

	@Override
	public void buildTooltip(ItemStack stack, World world, List<TextComponent> tooltip, TooltipContext options) {
		CompoundTag tags = stack.getTag();

    TranslatableTextComponent desc = new TranslatableTextComponent("item.carrots.carrot_bundle.tooltip");
		desc.setStyle(new Style().setColor(TextFormat.RED));
		tooltip.add(desc);
	}
}
