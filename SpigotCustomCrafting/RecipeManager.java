package io.github.diamondminer88.modifiedvanilla.crafting;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import io.github.diamondminer88.modifiedvanilla.block.BlockManager;
import io.github.diamondminer88.modifiedvanilla.block.CustomBlock;
import io.github.diamondminer88.modifiedvanilla.utils.ItemHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeManager {
    private static ItemStack air = new ItemStack(Material.AIR);
    private List<CraftingRecipe> crafting = new ArrayList<>();

    public RecipeManager(BlockManager manager) {
        CustomBlock cblockWorkbench = manager.getBlocks().get("CRAFTING_TABLE");
        ItemStack workbench = ItemHelper.setItemName(new ItemStack(cblockWorkbench.getMaterial()), cblockWorkbench.getName(), true);
        workbench = NBTEditor.set(workbench, "CRAFTING_TABLE", "ModifiedVanilla", "id");
        ShapedRecipe workbenchRecipe = new ShapedRecipe(workbench)
                .shape("LNL", "NON", "LNL")
                .setIngredient('L', Material.LAPIS_BLOCK)
                .setIngredient('N', Material.NETHERITE_INGOT)
                .setIngredient('O', Material.CRYING_OBSIDIAN);
        Bukkit.getServer().addRecipe(workbenchRecipe);

        crafting.addAll(Arrays.asList(
                // example
                new CraftingRecipe(
                        air, air, air,
                        air, new ItemStack(Material.ENDER_PEARL, 16), air,
                        air, air, air,
                        new ItemStack(Material.DIAMOND, 2)
                )
        ));
    }

    /**
     * Finds a matching recipe to the provided grid
     *
     * @param grid the crafting grid
     * @return null if no matching recipe else a {@link CraftingRecipe}
     */
    public CraftingRecipe getMatchingRecipe(ArrayList<ItemStack> grid) {
        for (CraftingRecipe recipe : crafting) {
            boolean matches = true;
            for (int i = 0; i < 9; i++) {
                ItemStack gridItem = grid.get(i) == null ? air : grid.get(i);
                ItemStack recipeItem = recipe.grid[i];
                if (!gridItem.getType().equals(recipeItem.getType())) matches = false;
                if (recipeItem.getAmount() > gridItem.getAmount()) matches = false;
            }
            if (matches) return recipe;
        }
        return null;
    }

}
