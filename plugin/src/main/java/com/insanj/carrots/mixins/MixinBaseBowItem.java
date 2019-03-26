package com.insanj.carrots.mixins;

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

@Mixin(BaseBowItem.class)
public class MixinBaseBowItem {
    @Inject(method = "method_8007()Z", at = @At("HEAD"))
    protected void method_8007(ItemStack stack, CallbackInfoReturnable ci) {
      System.out.println("HELLO WORLD");
      ci.setReturnValue(true);
    }
}
