package com.insanj.carrots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

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
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

import com.insanj.carrots.items.*;

public class CarrotsMod implements ModInitializer {
    public static final String MOD_ID = "carrots";
    public static final RoastedCarrotsItem ROASTED_CARROTS_ITEM = new RoastedCarrotsItem();
    public static final CarrotBundleItem CARROT_BUNDLE_ITEM = new CarrotBundleItem();
    public static final MagentaCarrotBundleItem MAGENTA_CARROT_BUNDLE_ITEM = new MagentaCarrotBundleItem();

    @Override
    public void onInitialize() {
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCarrotsItem.ITEM_ID), ROASTED_CARROTS_ITEM);
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleItem.ITEM_ID), CARROT_BUNDLE_ITEM);
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, MagentaCarrotBundleItem.ITEM_ID), MAGENTA_CARROT_BUNDLE_ITEM);
    }
}
