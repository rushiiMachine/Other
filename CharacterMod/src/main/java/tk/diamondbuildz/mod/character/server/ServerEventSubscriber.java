package tk.diamondbuildz.mod.character.server;

import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.fml.relauncher.Side.SERVER;
import static tk.diamondbuildz.mod.character.reference.Reference.MOD_ID;

/**
 * Subscribe to events that should be handled on the PHYSICAL/DEDICATED SERVER in this class
 *
 * @author Diamond
 */
@Mod.EventBusSubscriber(modid = MOD_ID, value = SERVER)
public final class ServerEventSubscriber {
}