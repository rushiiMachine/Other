package tk.diamondbuildz.mod.character.client;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tk.diamondbuildz.mod.character.reference.ModMaterials;
import net.minecraft.client.renderer.GlStateManager;

import javax.annotation.Nonnull;
import java.awt.*;

import static net.minecraft.client.renderer.GlStateManager.FogMode.*;
import static net.minecraftforge.fml.relauncher.Side.CLIENT;
import static tk.diamondbuildz.mod.character.reference.Reference.FLUID_MODEL_PATH;
import static tk.diamondbuildz.mod.character.reference.Reference.MOD_ID;

/**
 * Subscribe to events that should be handled on the PHYSICAL CLIENT in this class
 *
 * @author Diamond
 */
@EventBusSubscriber(modid = MOD_ID, value = CLIENT)
public final class ClientEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DEFAULT_VARIANT = "normal";

    private static final Color COLOR_MOLTEN_GLASS = new Color(251, 143, 70);

    /**
     * Cycle through all block and items already registered, if ModId of the entry matches to my ModId, calls
     * {@link ClientEventSubscriber#registerItemBlockModel(Block)}
     * or
     * {@link ClientEventSubscriber#registerItemModel(Item)}
     */
    @SubscribeEvent
    public static void onRegisterModelsEvent(@Nonnull final ModelRegistryEvent event) {
        ForgeRegistries.BLOCKS.getValuesCollection().stream()
                .filter(block -> block.getRegistryName().getNamespace().equals(MOD_ID))
                .forEach(ClientEventSubscriber::registerItemBlockModel);

        ForgeRegistries.ITEMS.getValuesCollection().stream()
                .filter(block -> block.getRegistryName().getNamespace().equals(MOD_ID))
                .forEach(ClientEventSubscriber::registerItemModel);

        LOGGER.debug("Registered models");
    }

    private static void registerItemModel(final Item item) {
        Preconditions.checkNotNull(item, "Item cannot be null!");
        final ResourceLocation registryName = item.getRegistryName();
        Preconditions.checkNotNull(registryName, "Item Registry Name cannot be null!");
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(registryName, DEFAULT_VARIANT));
    }

    private static void registerItemBlockModel(final Block block) {
        Preconditions.checkNotNull(block, "Block cannot be null!");
        final ResourceLocation registryName = block.getRegistryName();
        Preconditions.checkNotNull(registryName, "Block Registry Name cannot be null!");
        if (block instanceof IFluidBlock) registerFluidModel((IFluidBlock) block);
        else
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(registryName, DEFAULT_VARIANT));
    }

    private static void registerFluidModel(IFluidBlock fluidBlock) {
        Item item = Item.getItemFromBlock((Block) fluidBlock);
        ModelBakery.registerItemVariants(item);
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(FLUID_MODEL_PATH, fluidBlock.getFluid().getName());
        ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);
        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
            @Nonnull
            @Override
            protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState p_178132_1_) {
                return modelResourceLocation;
            }
        });
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onFogDensityEvent(EntityViewRenderEvent.FogDensity event) {
        if (event.getEntity().isInsideOfMaterial(ModMaterials.MOLTEN_GLASS)) {
            GlStateManager.setFog(EXP);
            event.setDensity(1F);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onFogColorsEvent(EntityViewRenderEvent.FogColors event) {
        if (event.getEntity().isInsideOfMaterial(ModMaterials.MOLTEN_GLASS)) {
            event.setRed(COLOR_MOLTEN_GLASS.getRed() / 255F);
            event.setGreen(COLOR_MOLTEN_GLASS.getGreen() / 255F);
            event.setBlue(COLOR_MOLTEN_GLASS.getBlue() / 255F);
        }
    }
}