package mod.omoflop.snowballshitplayers;

import mod.omoflop.snowballshitplayers.accessors.LivingEntityAccessor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.util.hit.EntityHitResult;

public class SnowballsHitPlayers implements ModInitializer {

	@Override
	public void onInitialize() {

	}

	public static boolean entityHitEvent(EntityHitResult entityHitResult, ThrownEntity projectile) {
		Entity entity = entityHitResult.getEntity();
		if (entity.isPlayer()) {

			LivingEntity livingEntity = (LivingEntity) entity;

			DamageSource source = DamageSource.thrownProjectile(projectile, projectile.getOwner());
			if (!livingEntity.blockedByShield(source)) {
				livingEntity.damage(source, -1f);
				livingEntity.takeKnockback(0,projectile.getX() - livingEntity.getX(), projectile.getZ() - livingEntity.getZ());
				LivingEntityAccessor accessor = ((LivingEntityAccessor)livingEntity);
				accessor.setTimeUntilRegen(accessor.getTimeUntilRegen() > 10 ? 10 : accessor.getTimeUntilRegen());
			}
			return true;
		}
		return false;
	}
}
