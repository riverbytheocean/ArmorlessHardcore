package lol.praenyth.mods.noarmorchallenge.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemEntity.class, priority = 1)
public abstract class ItemEntityMixin {

    @Shadow public abstract ItemStack getItem();

    @Shadow private int pickupDelay;

    @Shadow public abstract void setNeverPickUp();

    @Inject(method = "tick", at = @At("HEAD"))
    private void preventPickup(CallbackInfo ci) {

        if (getItem().getItem().equals(Items.TOTEM_OF_UNDYING) && pickupDelay != 32767) {

            setNeverPickUp();

        }

    }

}
