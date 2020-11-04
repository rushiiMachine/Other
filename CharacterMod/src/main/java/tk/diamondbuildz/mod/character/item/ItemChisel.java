package tk.diamondbuildz.mod.character.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tk.diamondbuildz.mod.character.util.ModUtil;

public class ItemChisel extends Item {

    public ItemChisel(int maxDamage) {
        ModUtil.setCreativeTab(this);
        this.setMaxDamage(maxDamage);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack;
    }
}