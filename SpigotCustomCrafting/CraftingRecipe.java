package io.github.diamondminer88.modifiedvanilla.crafting;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.logging.Level;

public class CraftingRecipe {
    public ItemStack[] grid = new ItemStack[9];
    public ItemStack result;

    /**
     * Makes a recipe
     *
     * @param item_0 Top left slot
     * @param item_1 Top middle slot
     * @param item_2 Top right slot
     * @param item_3 Middle left slot
     * @param item_4 Center slot
     * @param item_5 Middle right slot
     * @param item_6 Bottom left slot
     * @param item_7 Bottom middle slot
     * @param item_8 Bottom right slot
     * @param result Result ItemStack
     */
    public CraftingRecipe(ItemStack item_0, ItemStack item_1, ItemStack item_2, ItemStack item_3, ItemStack item_4, ItemStack item_5, ItemStack item_6, ItemStack item_7, ItemStack item_8, ItemStack result) {
        grid[0] = item_0;
        grid[1] = item_1;
        grid[2] = item_2;
        grid[3] = item_3;
        grid[4] = item_4;
        grid[5] = item_5;
        grid[6] = item_6;
        grid[7] = item_7;
        grid[8] = item_8;
        this.result = result;
    }

    /**
     * Makes a recipe
     *
     * @param recipeGrid grid of ItemStacks
     * @param result     Result ItemStack
     */
    public CraftingRecipe(ItemStack[] recipeGrid, ItemStack result) {
        if (recipeGrid.length != 9) {
            Bukkit.getLogger().log(Level.SEVERE, "Error comparing grid");
        } else {
            this.grid = recipeGrid;
            this.result = result;
        }
    }

    public String toString() {
        return "Result: " + result.toString() + "\n"
                + "0: " + grid[0].toString() + " 1: " + grid[1].toString() + " 2: " + grid[2].toString() + "\n"
                + "3: " + grid[3].toString() + " 4: " + grid[4].toString() + " 5: " + grid[5].toString() + "\n"
                + "6: " + grid[6].toString() + " 7: " + grid[7].toString() + " 8: " + grid[8].toString();
    }

    /**
     * Returns true of the grid items match this recipe's items AND the grid's item amount for each slot is equal or more than this recipe's item's amount matching slot
     *
     * @param grid Crafting table grid (size: 9)
     */
    public boolean matches(ItemStack[] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (this.grid[i].getType().equals(grid[i].getType())) {
                if (this.grid[i].getAmount() > grid[i].getAmount()) return false;
            } else return false;
        }
        return true;
    }
}
