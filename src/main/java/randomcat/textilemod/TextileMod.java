package randomcat.textilemod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import randomcat.textilemod.item.TextileItems;
import randomcat.textilemod.block.TextileBlocks;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class TextileMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "textilemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("TextileS initialized.");

		new TextileItems().itemsInit();
		new TextileBlocks().blockInit();
	}
	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}

