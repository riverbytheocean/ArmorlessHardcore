package lol.praenyth.mods.noarmorchallenge;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public class NACDamageSources {

    public static final Holder<DamageType> ARMOR_DAMAGE = Holder.direct(new DamageType("armor_damage", 0.0f));

    public static DamageSource armorDamageSource() {
        return new DamageSource(ARMOR_DAMAGE);
    }

}
