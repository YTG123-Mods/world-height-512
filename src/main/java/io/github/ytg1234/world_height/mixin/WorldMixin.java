package io.github.ytg1234.world_height.mixin;

import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Level.class)
public abstract class WorldMixin {
    @ModifyConstant(method = "getSectionsCount()I", constant = @Constant(intValue = 16, ordinal = 0))
    private int makeHeight512(int orig) {
        return 32;
    }
}
