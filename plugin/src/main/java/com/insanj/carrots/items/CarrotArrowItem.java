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
import net.minecraft.item.block.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.text.StringTextComponent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.command.ServerCommandManager;
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
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.SpectralArrowItem;
import net.minecraft.item.ArrowItem;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class CarrotArrowItem extends ArrowItem {
	public static final String ITEM_ID = "carrot_arrow";

	public CarrotArrowItem() {
		super(new ArrowItem.Settings().itemGroup(ItemGroup.COMBAT));
	}

	@Override
	public ProjectileEntity createEntityArrow(World world, ItemStack stack, LivingEntity livingShooter) {
		//SpectralArrowEntity entity = new SpectralArrowEntity(world, livingShooter);
		// entity.setDuration(80);
		ArrowEntity entity = new ArrowEntity(world, livingShooter);
		entity.setDamage(-3.0);
		return entity;
	}

	@Override
	public void buildTooltip(ItemStack stack, World world, List<TextComponent> tooltip, TooltipContext options) {
		CompoundTag tags = stack.getTag();

		TranslatableTextComponent desc = new TranslatableTextComponent("item.insanj_carrots.carrot_arrow.desc");
		desc.setStyle(new Style().setColor(TextFormat.RED));
		tooltip.add(desc);
	}
}
