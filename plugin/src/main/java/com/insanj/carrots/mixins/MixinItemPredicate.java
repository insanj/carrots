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



@Mixin(ItemPredicate.class)
public class MixinItemPredicate {
 // @Inject(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/GlStateManager;alphaFunc(IF)V"), method = "render")
// "Lnet/minecraft/predicate/item/ItemPredicate;test(Lbaz)Z
  @Inject(method = "test", at = @At("HEAD"), cancellable = false)
  private void test(ItemStack stack, CallbackInfoReturnable ci) {
    System.out.println("HELLO WORLD");
    // ci.setReturnValue(true);
    stack = new ItemStack(new ArrowItem(new ArrowItem.Settings()));
  }

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
