package lol.praenyth.mods.noarmorchallenge.mixin;

import lol.praenyth.mods.noarmorchallenge.NACGameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Player.class, priority = 1)
public class PlayerAttackMixin {

    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    private void preventAttacks(Entity entity, CallbackInfo ci) {

        if (!entity.level().getGameRules().getBoolean(NACGameRules.PVP)) {
            if (entity instanceof Player) {
                ci.cancel();
            }
        }
        
    }

}
