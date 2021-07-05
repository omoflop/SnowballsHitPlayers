package mod.omoflop.snowballshitplayers.mixin;

import mod.omoflop.snowballshitplayers.accessors.LivingEntityAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowballEntity.class)
public class SnowballEntityMixin {

	@Inject(method = "onEntityHit", at = @At("HEAD"), cancellable = true)
	public void onEntityHitMixin(EntityHitResult entityHitResult, CallbackInfo ci) {
		Entity entity = entityHitResult.getEntity();
		if (entity.isPlayer()) {

			ThrownEntity projectile = ((ThrownItemEntity)(Object)this);
			LivingEntity livingEntity = (LivingEntity) entity;
			Entity self = ((Entity)(Object)this);

			DamageSource source = DamageSource.thrownProjectile(projectile, projectile.getOwner());
			if (!livingEntity.blockedByShield(source)) {
				livingEntity.damage(source, -1f);
				livingEntity.takeKnockback(0,self.getX() - livingEntity.getX(), self.getZ() - livingEntity.getZ());
				LivingEntityAccessor accessor = ((LivingEntityAccessor)livingEntity);
				accessor.setTimeUntilRegen(accessor.getTimeUntilRegen() > 10 ? 10 : accessor.getTimeUntilRegen());
			}
			ci.cancel();
		}
	}

}
