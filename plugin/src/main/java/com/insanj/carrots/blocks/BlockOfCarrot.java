package com.insanj.carrots.blocks;

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
import net.minecraft.block.BlockState;
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
import net.minecraft.sortme.ItemScatterer;
import net.minecraft.sound.BlockSoundGroup;

import net.fabricmc.fabric.api.block.FabricBlockSettings;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.insanj.carrots.CarrotsMod;

public class BlockOfCarrot extends Block {
  public static final String ITEM_ID = "block_of_carrot";

	public BlockOfCarrot() {
    super(FabricBlockSettings.of(Material.PUMPKIN).sounds(BlockSoundGroup.CROP).hardness(1.0f).lightLevel(1).build());
	}

  @Override
  public void onBreak(World world, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity) {
    ItemStack stack = new ItemStack(CarrotsMod.BLOCK_OF_CARROT_ITEM);
    ItemScatterer.spawn(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), stack);
    super.onBreak(world, blockPos, blockState, playerEntity);
  }
}
