package lol.praenyth.mods.noarmorchallenge;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoArmorChallenge implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("noarmorchallenge");

	@Override
	public void onInitialize() {
		LOGGER.info("don't use this on public servers, you're definitely putting yourself at a disadvantage :3");

		NACGameRules.registerNACGameRules();
	}
}