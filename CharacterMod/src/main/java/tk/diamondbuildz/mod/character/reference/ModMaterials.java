package tk.diamondbuildz.mod.character.reference;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;

/**
 * Mod Materials Class
 *
 * @author Diamond
 */
public class ModMaterials {

    // Fluid Materials
    public static final Material MOLTEN_GLASS = new MaterialLiquid(MapColor.AIR) {
        @Override
        public boolean isOpaque() {
            return false;
        }
    };
}