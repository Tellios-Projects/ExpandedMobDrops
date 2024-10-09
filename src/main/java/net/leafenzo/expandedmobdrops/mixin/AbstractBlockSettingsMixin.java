package net.leafenzo.expandedmobdrops.mixin;

import net.leafenzo.expandedmobdrops.block.HideBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.Settings.class)
public class AbstractBlockSettingsMixin {
    /**
     * Apply an offset to hide blocks in a checkerboard pattern on the block grid.
     * Prevents z-fighting.
     */
    @Inject(method = "method_49231", at = @At("HEAD"), cancellable = true)
    private static void onXyzOffset(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<Vec3d> cir) {
        Block block = state.getBlock();
        if (block instanceof HideBlock) {
            int x = pos.getX();
            int z = pos.getZ();
            boolean checkerboard = (x + z) % 2 == 0;
            Vec3d offset = checkerboard ? new Vec3d(0.0, 0.001, 0.0) : Vec3d.ZERO;
            cir.setReturnValue(offset);
        }
    }
}
