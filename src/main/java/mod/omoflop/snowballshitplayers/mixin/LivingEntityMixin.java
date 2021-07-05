package mod.omoflop.snowballshitplayers.mixin;

import mod.omoflop.snowballshitplayers.accessors.LivingEntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements LivingEntityAccessor {

    @Override
    public int getTimeUntilRegen() {
        return ((Entity)(Object)this).timeUntilRegen;
    }

    @Override
    public void setTimeUntilRegen(int timeUntilRegen) {
        ((Entity)(Object)this).timeUntilRegen = timeUntilRegen;
    }
}
