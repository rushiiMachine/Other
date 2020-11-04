package tk.diamondbuildz.mod.character.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class MoltenGlass extends Fluid {
    private static int mapColor = 0xFFFFFFFF;
    private static float overlayAlpha = 0.2F;
    private static SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
    private static SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
    private static Material material = Material.WATER;

    public MoltenGlass(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
    }

    @Override
    public int getColor() {
        return mapColor;
    }

    public MoltenGlass setColor(int parColor) {
        mapColor = parColor;
        return this;
    }

    public float getAlpha() {
        return overlayAlpha;
    }

    public MoltenGlass setAlpha(float parOverlayAlpha) {
        overlayAlpha = parOverlayAlpha;
        return this;
    }

    @Override
    public MoltenGlass setEmptySound(SoundEvent parSound) {
        emptySound = parSound;
        return this;
    }

    @Override
    public SoundEvent getEmptySound() {
        return emptySound;
    }

    @Override
    public MoltenGlass setFillSound(SoundEvent parSound) {
        fillSound = parSound;
        return this;
    }

    @Override
    public SoundEvent getFillSound() {
        return fillSound;
    }

    public MoltenGlass setMaterial(Material parMaterial) {
        material = parMaterial;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public boolean doesVaporize(FluidStack fluidStack) {
        if (block == null)
            return false;
        return block.getDefaultState().getMaterial() == getMaterial();
    }
}