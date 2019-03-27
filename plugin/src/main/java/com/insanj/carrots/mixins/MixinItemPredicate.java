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
import net.minecraft.text.TextComponent;

@Mixin(ItemPredicate.class)
public class MixinItemPredicate extends ItemPredicate {
 // @Inject(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/GlStateManager;alphaFunc(IF)V"), method = "render")
// "Lnet/minecraft/predicate/item/ItemPredicate;test(Lbaz)Z
 // @Inject(method = "test", at = @At("HEAD"), cancellable = false)

  @Override
  public boolean test(ItemStack stack) {//}, CallbackInfoReturnable ci) {
    //System.out.println(stack.getDisplayName().getText());
    // ci.setReturnValue(true);
    if (stack.getDisplayName().getText().equals("Carrot Arrow")) {
      return true;
    } else {
      return super.test(stack);
    }
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
