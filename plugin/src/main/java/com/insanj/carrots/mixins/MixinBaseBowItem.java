package com.insanj.carrots.mixins;

import java.util.function.Predicate;
import java.lang.reflect.Constructor;

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

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.insanj.carrots.items.CarrotArrowItem;

@Mixin(BaseBowItem.class)
public class MixinBaseBowItem {
  /*
    @Inject(method = "getProjectilePredicate", at = @At("HEAD"), cancellable = true)
    private void getProjectilePredicate(CallbackInfoReturnable ci) {
      System.out.println("GET PROJECTILE PREDICATE TIME!!!");

      try {
        Class builderClass = Class.forName("net.minecraft.predicate.item.ItemPredicate$Builder");
        Constructor<ItemPredicate.Builder> builderConstructor = builderClass.getDeclaredConstructor(Object.class);
        builderConstructor.setAccessible(true);

        ItemPredicate.Builder builderInstance = builderConstructor.newInstance();
        ItemPredicate isCarrotArrow = builderInstance.item(new CarrotArrowItem()).build();
        ItemPredicate originalPredicate = (ItemPredicate) ci.getReturnValue();

        Predicate comboPredicate = itemStack -> itemStack instanceof ItemStack && isCarrotArrow.test((ItemStack)itemStack) && originalPredicate.test((ItemStack)itemStack);

        ci.setReturnValue(comboPredicate);
      } catch (Exception e) {
        System.out.println(String.format("MixinBaseBowItem getProjectilePredicate exception: %s", ExceptionUtils.getStackTrace(e)));
      }
    }
    */
}
