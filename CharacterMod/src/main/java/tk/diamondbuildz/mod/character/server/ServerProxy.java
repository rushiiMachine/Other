package tk.diamondbuildz.mod.character.server;

import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import tk.diamondbuildz.mod.character.Main;
import tk.diamondbuildz.mod.character.util.IProxy;

/**
 * The version of IProxy that gets injected into {@link Main#proxy} on a PHYSICAL/DEDICATED SERVER
 *
 * @author Cadiboo
 */
public final class ServerProxy implements IProxy {

    @Override
    public String localize(final String unlocalized) {
        return I18n.translateToLocal(unlocalized);
    }

    @Override
    public String localizeAndFormat(final String unlocalized, final Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    @Override
    public Side getPhysicalSide() {
        return Side.SERVER;
    }
}