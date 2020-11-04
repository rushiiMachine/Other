package tk.diamondbuildz.mod.character.client;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import tk.diamondbuildz.mod.character.Main;
import tk.diamondbuildz.mod.character.util.IProxy;

/**
 * The version of IProxy that gets injected into {@link Main#proxy} on a PHYSICAL CLIENT
 * <p>
 * Edited by Diamond made by Cadiboo
 *
 * @author Diamond
 * @author Cadiboo -- https://github.com/Cadiboo/Example-Mod
 */
public final class ClientProxy implements IProxy {

    @Override
    public String localize(final String unlocalized) {
        return this.localizeAndFormat(unlocalized);
    }

    @Override
    public String localizeAndFormat(final String unlocalized, final Object... args) {
        return I18n.format(unlocalized, args);
    }

    @Override
    public Side getPhysicalSide() {
        return Side.CLIENT;
    }
}