package mod.omoflop.snowballshitplayers.mixin;

import mod.omoflop.snowballshitplayers.SnowballsHitPlayers;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowballEntity.class)
public class SnowballEntityMixin {

	@Inject(method = "onEntityHit", at = @At("HEAD"), cancellable = true)
	public void onEntityHitMixin(EntityHitResult entityHitResult, CallbackInfo ci) {
		if (SnowballsHitPlayers.entityHitEvent(entityHitResult, (ThrownEntity) (Object) this)) ci.cancel();;
	}

}
