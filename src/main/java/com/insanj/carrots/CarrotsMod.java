package com.insanj.carrots;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.insanj.carrots.items.*;

public class CarrotsMod implements ModInitializer {
  public static final String MOD_ID = "carrots";
  public static final Logger LOGGER = LogManager.getLogger("carrots");

  public static final CarrotBundleItem CARROT_BUNDLE_ITEM = new CarrotBundleItem();
  public static final MagentaCarrotBundleItem MAGENTA_CARROT_BUNDLE_ITEM = new MagentaCarrotBundleItem();
  public static final RoastedCarrotsItem ROASTED_CARROTS_ITEM = new RoastedCarrotsItem();

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleItem.ITEM_ID), CARROT_BUNDLE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, MagentaCarrotBundleItem.ITEM_ID), MAGENTA_CARROT_BUNDLE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCarrotsItem.ITEM_ID), ROASTED_CARROTS_ITEM);
  }
}