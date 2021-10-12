package mod.omoflop.snowballshitplayers.mixin;

import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class ItemsMixin {

    @ModifyArg(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=snowball")),
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 0))
    private static int changeGunpowderSettings(int i) {
        return 64;
    }

}
