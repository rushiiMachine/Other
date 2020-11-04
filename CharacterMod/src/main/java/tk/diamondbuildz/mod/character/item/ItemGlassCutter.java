package tk.diamondbuildz.mod.character.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import tk.diamondbuildz.mod.character.util.ModUtil;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * {@link ItemTool} "Glass Cutter"
 * Can only harvest blocks with GLASS as their material
 * Is left on crafting table after crafting completed with 1 Damage taken
 *
 * @author Diamond
 */
public class ItemGlassCutter extends ItemTool {
    /**
     * Blocks that this tool is effective on and can be mined faster
     * Block constructors add themselves to the Set
     */
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.STAINED_GLASS, Blocks.STAINED_GLASS_PANE, Blocks.GLASS_PANE);

    public ItemGlassCutter(@Nonnull ToolMaterial material, int maxDamage) {
        super(6.0F, -2.0F, material, EFFECTIVE_ON);
        ModUtil.setCreativeTab(this);
        this.setMaxDamage(maxDamage);
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        boolean TF = false;
        Material material = blockIn.getMaterial();
        if (material == Material.GLASS) {
            TF = true;
        }
        return TF;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.GLASS ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack stackFi = ItemStack.EMPTY;

        // Duplicate ItemStack
        ItemStack rStack = new ItemStack(stack.getItem(), 1, stack.getItemDamage() + 1, stack.getTagCompound());

        //if (rStack.getItemDamage() < rStack.getMaxDamage()) stackFi = rStack;

        return rStack;
    }
}