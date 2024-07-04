package lol.praenyth.mods.noarmorchallenge.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
public class VillagerTickMixin {

    Villager villager = ((Villager) (Object) this);

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void deleteVillagers(CallbackInfo ci) {

        villager.remove(Entity.RemovalReason.DISCARDED);
        ci.cancel();

    }

}
