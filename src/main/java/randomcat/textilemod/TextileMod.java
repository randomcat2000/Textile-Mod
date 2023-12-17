package randomcat.textilemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.core.*;
import randomcat.textilemod.item.TextileItems;
import randomcat.textilemod.block.TextileBlocks;
import turniplabs.halplibe.helper.*;

public class TextileMod implements ModInitializer {
	public static final String MOD_ID = "textilemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("TextileS initialized.");

		new TextileItems().itemsInit();
		new TextileBlocks().blockInit();
	}
}

