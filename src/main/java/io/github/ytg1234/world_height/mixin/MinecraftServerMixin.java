package io.github.ytg1234.world_height.mixin;

import net.minecraft.server.MinecraftServer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Shadow
    private int maxBuildHeight;

    @Redirect(method = "getMaxBuildHeight()I",
              at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/server/MinecraftServer;maxBuildHeight:I"))
    private int worldHeight512(MinecraftServer self) {
        return ((MinecraftServerMixin) (Object) self).getMaxBuildHeight2() == 256 ? 512 : ((MinecraftServerMixin) (Object) self).getMaxBuildHeight2();
    }

    @Unique
    public int getMaxBuildHeight2() {
        return maxBuildHeight;
    }
}
