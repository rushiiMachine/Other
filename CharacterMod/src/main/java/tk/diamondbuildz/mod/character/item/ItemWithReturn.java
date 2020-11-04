package tk.diamondbuildz.mod.character.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tk.diamondbuildz.mod.character.util.ModUtil;

import javax.annotation.Nonnull;

/**
 * Generic {@link Item}
 * Is left with on Crafting Table after crafting
 */
public class ItemWithReturn extends Item {

    public ItemWithReturn() {
        ModUtil.setCreativeTab(this);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return new ItemStack(stack.getItem(), 1);
    }
}