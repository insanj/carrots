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

import com.insanj.carrots.items.*;
import com.insanj.carrots.events.*;
import com.insanj.carrots.blocks.*;

public class CarrotsMod implements ModInitializer {
    public static final String MOD_ID = "insanj_carrots";
    public static final RoastedCarrotItem ROASTED_CARROT_ITEM = new RoastedCarrotItem();
    public static final CarrotBundleItem CARROT_BUNDLE_ITEM = new CarrotBundleItem();
    public static final CarrotArrowItem CARROT_ARROW_ITEM = new CarrotArrowItem();

    public static final BlockOfCarrot BLOCK_OF_CARROT = new BlockOfCarrot();
    public static final BlockItem BLOCK_OF_CARROT_ITEM = new BlockItem(BLOCK_OF_CARROT, new Item.Settings().itemGroup(ItemGroup.MISC));

    @Override
    public void onInitialize() {
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCarrotItem.ITEM_ID), ROASTED_CARROT_ITEM);
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleItem.ITEM_ID), CARROT_BUNDLE_ITEM);
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotArrowItem.ITEM_ID), CARROT_ARROW_ITEM);

      Registry.register(Registry.BLOCK,  new Identifier(MOD_ID, BlockOfCarrot.ITEM_ID), BLOCK_OF_CARROT);
      Registry.register(Registry.ITEM, new Identifier(MOD_ID, BlockOfCarrot.ITEM_ID), BLOCK_OF_CARROT_ITEM);

      // CarrotsEventHandler.registerEventHandlers();
    }
}
