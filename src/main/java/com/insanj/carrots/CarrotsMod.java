package com.insanj.carrots;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.insanj.carrots.items.*;

public class CarrotsMod implements ModInitializer {
  public static final String MOD_ID = "carrots";
  public static final Logger LOGGER = LogManager.getLogger("carrots");

  // custom item group (instead of the default ItemGroup.FOOD)
  public static final Identifier ITEM_GROUP_ID = new Identifier(MOD_ID, "general");
  public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(ITEM_GROUP_ID, () -> new ItemStack(Items.CARROT));

  // create static refs to each custom item, these will be used to build stacks & register globally
  public static final RoastedCarrotsItem ROASTED_CARROTS_ITEM = new RoastedCarrotsItem();
  public static final CarrotBundleItem CARROT_BUNDLE_ITEM = new CarrotBundleItem();
  public static final CarrotBundleMagentaItem CARROT_BUNDLE_MAGENTA_ITEM = new CarrotBundleMagentaItem();
  public static final CarrotBundleBlackItem CARROT_BUNDLE_BLACK_ITEM = new CarrotBundleBlackItem();
  public static final CarrotBundleBlueItem CARROT_BUNDLE_BLUE_ITEM = new CarrotBundleBlueItem();
  public static final CarrotBundleBrownItem CARROT_BUNDLE_BROWN_ITEM = new CarrotBundleBrownItem();
  public static final CarrotBundleCyanItem CARROT_BUNDLE_CYAN_ITEM = new CarrotBundleCyanItem();
  public static final CarrotBundleGrayItem CARROT_BUNDLE_GRAY_ITEM = new CarrotBundleGrayItem();
  public static final CarrotBundleGreenItem CARROT_BUNDLE_GREEN_ITEM = new CarrotBundleGreenItem();
  public static final CarrotBundleLightBlueItem CARROT_BUNDLE_LIGHT_BLUE_ITEM = new CarrotBundleLightBlueItem();
  public static final CarrotBundleLightGrayItem CARROT_BUNDLE_LIGHT_GRAY_ITEM = new CarrotBundleLightGrayItem();
  public static final CarrotBundleLimeItem CARROT_BUNDLE_LIME_ITEM = new CarrotBundleLimeItem();
  public static final CarrotBundleOrangeItem CARROT_BUNDLE_ORANGE_ITEM = new CarrotBundleOrangeItem();
  public static final CarrotBundlePinkItem CARROT_BUNDLE_PINK_ITEM = new CarrotBundlePinkItem();
  public static final CarrotBundlePurpleItem CARROT_BUNDLE_PURPLE_ITEM = new CarrotBundlePurpleItem();
  public static final CarrotBundleRedItem CARROT_BUNDLE_RED_ITEM = new CarrotBundleRedItem();
  public static final CarrotBundleYellowItem CARROT_BUNDLE_YELLOW_ITEM = new CarrotBundleYellowItem();

  @Override
  public void onInitialize() {
    // register base items; roasted carrots & undyed carrot bundle
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCarrotsItem.ITEM_ID), ROASTED_CARROTS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleItem.ITEM_ID), CARROT_BUNDLE_ITEM);

    // register all the colors of the rainbow!
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleMagentaItem.ITEM_ID), CARROT_BUNDLE_MAGENTA_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleBlackItem.ITEM_ID), CARROT_BUNDLE_BLACK_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleBlueItem.ITEM_ID), CARROT_BUNDLE_BLUE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleBrownItem.ITEM_ID), CARROT_BUNDLE_BROWN_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleCyanItem.ITEM_ID), CARROT_BUNDLE_CYAN_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleGrayItem.ITEM_ID), CARROT_BUNDLE_GRAY_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleGreenItem.ITEM_ID), CARROT_BUNDLE_GREEN_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleLightBlueItem.ITEM_ID), CARROT_BUNDLE_LIGHT_BLUE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleLightGrayItem.ITEM_ID), CARROT_BUNDLE_LIGHT_GRAY_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleLimeItem.ITEM_ID), CARROT_BUNDLE_LIME_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleOrangeItem.ITEM_ID), CARROT_BUNDLE_ORANGE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundlePinkItem.ITEM_ID), CARROT_BUNDLE_PINK_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundlePurpleItem.ITEM_ID), CARROT_BUNDLE_PURPLE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleRedItem.ITEM_ID), CARROT_BUNDLE_RED_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CarrotBundleYellowItem.ITEM_ID), CARROT_BUNDLE_YELLOW_ITEM);
  }
}