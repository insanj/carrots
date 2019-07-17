package com.insanj.carrots.items;

import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import com.insanj.carrots.CarrotsMod;
import com.insanj.carrots.util.CarrotsParticleUtil;

public class CarrotBundleItem extends Item {
  public static final String ITEM_ID = "carrot_bundle";

  public CarrotBundleItem() {
    super(new Item.Settings().group(CarrotsMod.ITEM_GROUP));
  }

  @Override
  public boolean useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
    // when right-clicking player with carrot bundle in had, feed the targeted entity & consume this item
    if (!(target instanceof PlayerEntity)) { // not interacting with player
      return false;
    }

    PlayerEntity targetPlayer = (PlayerEntity)target;
    HungerManager hungerManager = targetPlayer.getHungerManager();
    if (hungerManager.getFoodLevel() >= 20) { // already at max hunger
      return false;
    }

    World world = player.getEntityWorld();
    BlockPos pos = target.getBlockPos();
    if (world.getServer() == null) { // only render particles on client, do nothing else
      CarrotsParticleUtil.heart(pos);
      return true;
    }

    stack.decrement(1);
    player.swingHand(hand);
    player.addExhaustion(1.0F);
    hungerManager.add(6, 0.6F);

    world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1.0F, 1.0F);

    return true;
  }

  @Override
  public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext options) {
    // custom tooltip / description for item
    TranslatableText desc = new TranslatableText("item.carrots.carrot_bundle.tooltip");
    desc.setStyle(new Style().setColor(Formatting.RED));
    tooltip.add(desc);
  }
}