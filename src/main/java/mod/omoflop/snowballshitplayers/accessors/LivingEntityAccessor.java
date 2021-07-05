package mod.omoflop.snowballshitplayers.accessors;


import net.minecraft.entity.damage.DamageSource;

public interface LivingEntityAccessor {
    int getTimeUntilRegen();
    void setTimeUntilRegen(int timeUntilRegen);
}
