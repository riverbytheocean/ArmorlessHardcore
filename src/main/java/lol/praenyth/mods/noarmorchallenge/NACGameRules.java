package lol.praenyth.mods.noarmorchallenge;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.Category;

public class NACGameRules {

    public static final GameRules.Key<GameRules.BooleanValue> PVP =
            GameRuleRegistry.register("noarmorchallenge.pvp", Category.MISC, GameRuleFactory.createBooleanRule(false));

    public static final GameRules.Key<GameRules.IntegerValue> ARMOR_DAMAGE =
            GameRuleRegistry.register("noarmorchallenge.armor_damage", Category.MISC, GameRuleFactory.createIntRule(6));

    public static void registerNACGameRules() {}

}
