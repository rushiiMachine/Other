package tk.diamondbuildz.mod.character.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry.ItemStackHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static tk.diamondbuildz.mod.character.reference.Reference.MOD_ID;

/**
 * All the creative tabs of our mod
 * <p>
 * Modified by Cadiboo and Diamond made by jabelar
 *
 * @author Diamond
 * @author jabelar
 * @author Cadiboo -- https://github.com/Cadiboo/Example-Mod
 */

public final class ModCreativeTabs {

    public static final String TAB_ICON_ITEM_REGISTRY_NAME = MOD_ID + ":" + "glass_shard_black";

    @ItemStackHolder(value = TAB_ICON_ITEM_REGISTRY_NAME)
    public static final ItemStack TAB_ICON_ITEMSTACK = null;

    /**
     * instantiate creative tabs
     */
    public static final CustomCreativeTab CREATIVE_TAB = new CustomCreativeTab("character_mod", true) {
        @Override
        public ItemStack createIcon() {
            return TAB_ICON_ITEMSTACK;
        }
    };

    /**
     * This class is used for an extra tab in the creative inventory. Many mods like to group their special items and block in a dedicated tab although it is also perfectly acceptable to put them in the vanilla tabs where it makes sense.
     */
    public abstract static class CustomCreativeTab extends CreativeTabs {

        private final boolean hasSearchBar;

        public CustomCreativeTab(final String name, final boolean hasSearchBar) {
            super(name);
            this.hasSearchBar = hasSearchBar;
        }

        /**
         * gets the {@link ItemStack} to display for the tab's icon
         */
        @SideOnly(Side.CLIENT)
        @Override
        abstract public ItemStack createIcon();

        @Override
        public String getBackgroundImageName() {
            if (this.hasSearchBar) {
                return "item_search.png";
            } else {
                return super.getBackgroundImageName();
            }
        }

        /**
         * Useful for adding extra items such as full variants of energy related items
         */
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(final NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
        }

        @Override
        public boolean hasSearchBar() {
            return this.hasSearchBar;
        }

    }

}