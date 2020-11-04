package tk.diamondbuildz.mod.character.item;

import net.minecraft.item.Item;
import tk.diamondbuildz.mod.character.util.ModUtil;

/**
 * Generic Item without any modifications to it
 * Added to creative tab
 *
 * @author Diamond
 */
public class ItemBase extends Item {
    public ItemBase() {
        ModUtil.setCreativeTab(this);
    }
}