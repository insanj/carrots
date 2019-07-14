package com.insanj.carrots.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.insanj.carrots.CarrotsMod;

public class CarrotsParticleUtil {
  public static void heart(Vec3d pos) {
    try {
      double x = pos.getX(), y = pos.getY(), z = pos.getZ();
      WorldRenderer renderer = MinecraftClient.getInstance().worldRenderer;
      renderer.addParticle(ParticleTypes.HEART, true, true, x, y, z, 0, 2, 0);
    } catch (Exception e) {
      CarrotsMod.LOGGER.info(String.format("[%s]: addParticle heart exception: %s", CarrotsMod.MOD_ID, ExceptionUtils.getStackTrace(e)));
    }
  }

  public static void heart(BlockPos pos) {
    CarrotsParticleUtil.heart(new Vec3d(pos.getX(), pos.getY(), pos.getZ()));
  }
}