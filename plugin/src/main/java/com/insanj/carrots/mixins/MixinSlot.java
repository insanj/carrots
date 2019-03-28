package com.insanj.carrots.mixins;

import java.util.function.Predicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.BowItem;
import net.minecraft.item.BaseBowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.MaterialPredicate;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.container.Slot;

@Mixin(Slot.class)
public class MixinSlot {
  @Inject(method = "onCrafted", at = @At("HEAD"))
  public void onCrafted(ItemStack stack, int amount, CallbackInfo ci) {
    //if (stack.getDisplayName().getText().equals("Carrot Arrow")) {
    //  return true;
    //} else {
    //  return super.test(stack);
    //}
    System.out.println("onCrafted has been called!!!");
    // stack.setDisplayName(new TranslatableTextComponent("Carrot Arrow"));
  }
/*
  @Inject(method = "onTake", at = @At("HEAD"))
  public void onTake(int amount, CallbackInfo ci) {
    System.out.println("onTake has been called!!!");
  //  stack.setDisplayName(new TranslatableTextComponent("Carrot Arrow"));
  }
*/
/*
  @Inject(method = "getStack ", at = @At("HEAD"))
  public void getStack(CallbackInfoReturnable ci) {
    System.out.println("getStack has been called!!!");
   // stack.setDisplayName(new TranslatableTextComponent("Carrot Arrow"));
 }*/
/*
  @Inject(method = "onStackChanged", at = @At("HEAD"))
  public void onStackChanged(ItemStack originalItem, ItemStack changedItem, CallbackInfo ci) {
    System.out.println("onStackChanged has been called!!!");
  }*/

/*
@Mixin(BaseBowItem.class)
public class MixinBaseBowItem {
    @Inject(method = "getProjectilePredicate()Ljava/util/function/Predicate;", at = @At("HEAD"))
    public void getProjectilePredicate(CallbackInfoReturnable ci) {
      System.out.println("HELLO WORLD");
      Predicate pred = p -> true;
      ci.setReturnValue(pred);
    }
}
*/
}
