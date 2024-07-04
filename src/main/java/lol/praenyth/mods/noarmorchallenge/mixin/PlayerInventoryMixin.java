package lol.praenyth.mods.noarmorchallenge.mixin;

import lol.praenyth.mods.noarmorchallenge.NACDamageSources;
import lol.praenyth.mods.noarmorchallenge.NACGameRules;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerInventoryMixin {

    @Unique
    Player player = ((Player) (Object) this);

    @Shadow public abstract Inventory getInventory();

    @Shadow public abstract Iterable<ItemStack> getArmorSlots();

    @Inject(method = "tick", at = @At("HEAD"))
    private void destroyTotem(CallbackInfo ci) {

        for (ItemStack item : getInventory().items) {

            if (item.getItem().equals(Items.TOTEM_OF_UNDYING)) {

                getInventory().removeItem(item);

            }

        }

        if (getInventory().offhand.get(0).getItem().equals(Items.TOTEM_OF_UNDYING)) {

            getInventory().offhand.clear();

        }

    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void armorDamage(CallbackInfo ci) {

        float damage = 6;

        try {
            damage = player.level().getGameRules().getInt(NACGameRules.ARMOR_DAMAGE);
        } catch (Exception ignored) {}

        final float damage1 = damage;

        getArmorSlots().forEach((item) -> {
            if (item.getItem().canBeDepleted()) {
                player.hurt(NACDamageSources.armorDamageSource(), damage1);
            }
        });

    }

}
