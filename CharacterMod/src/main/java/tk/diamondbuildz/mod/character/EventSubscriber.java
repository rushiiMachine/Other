package tk.diamondbuildz.mod.character;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import tk.diamondbuildz.mod.character.block.a.glass.*;
import tk.diamondbuildz.mod.character.blockbases.concrete.*;
import tk.diamondbuildz.mod.character.item.ItemBase;
import tk.diamondbuildz.mod.character.item.ItemChisel;
import tk.diamondbuildz.mod.character.item.ItemGlassCutter;
import tk.diamondbuildz.mod.character.item.ItemWithReturn;
import tk.diamondbuildz.mod.character.reference.Reference;
import tk.diamondbuildz.mod.character.util.ModUtil;

import javax.annotation.Nonnull;
import java.util.Arrays;

import static tk.diamondbuildz.mod.character.reference.ModBlocks.*;
import static tk.diamondbuildz.mod.character.reference.ModFluidBlocks.*;
import static tk.diamondbuildz.mod.character.reference.ModFluids.*;
import static tk.diamondbuildz.mod.character.reference.Reference.MOD_ID;

/**
 * Subscribe to events that should be handled on both PHYSICAL sides in this class
 *
 * @author Diamond
 */
@Mod.EventBusSubscriber(modid = MOD_ID)
public final class EventSubscriber {

    // Register Blocks
    @SubscribeEvent
    public static void onRegisterBlocksEvent(@Nonnull final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_BLACK);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_BLUE);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_BROWN);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_CLEAR);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_CYAN);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_GRAY);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_GREEN);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_LIGHT_BLUE);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_LIME);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_MAGENTA);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_ORANGE);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_PINK);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_PURPLE);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_RED);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_SILVER);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_WHITE);
        FluidRegistry.registerFluid(FLUID_MOLTEN_GLASS_YELLOW);

        for (String color : Reference.colors) {
            registry.registerAll(
                    setup(new ConcreteA(), "a_concrete_" + color),
                    setup(new ConcreteB(), "b_concrete_" + color),
                    setup(new ConcreteC(), "c_concrete_" + color),
                    setup(new ConcreteD(), "d_concrete_" + color),
                    setup(new ConcreteE(), "e_concrete_" + color),
                    setup(new ConcreteF(), "f_concrete_" + color),
                    setup(new ConcreteG(), "g_concrete_" + color),
                    setup(new ConcreteH(), "h_concrete_" + color),
                    setup(new ConcreteI(), "i_concrete_" + color),
                    setup(new ConcreteJ(), "j_concrete_" + color),
                    setup(new ConcreteK(), "k_concrete_" + color),
                    setup(new ConcreteL(), "l_concrete_" + color),
                    setup(new ConcreteM(), "m_concrete_" + color),
                    setup(new ConcreteN(), "n_concrete_" + color),
                    setup(new ConcreteO(), "o_concrete_" + color),
                    setup(new ConcreteP(), "p_concrete_" + color),
                    setup(new ConcreteQ(), "q_concrete_" + color),
                    setup(new ConcreteR(), "r_concrete_" + color),
                    setup(new ConcreteS(), "s_concrete_" + color),
                    setup(new ConcreteT(), "t_concrete_" + color),
                    setup(new ConcreteU(), "u_concrete_" + color),
                    setup(new ConcreteV(), "v_concrete_" + color),
                    setup(new ConcreteW(), "w_concrete_" + color),
                    setup(new ConcreteX(), "x_concrete_" + color),
                    setup(new ConcreteY(), "y_concrete_" + color),
                    setup(new ConcreteZ(), "z_concrete_" + color)
            );
        }
        registry.registerAll(
                setup(new AGlassBlack(), "a_glass_black"),
                setup(new AGlassBlue(), "a_glass_blue"),
                setup(new AGlassBrown(), "a_glass_brown"),
                setup(new AGlassClear(), "a_glass_clear"),
                setup(new AGlassCyan(), "a_glass_cyan"),
                setup(new AGlassGray(), "a_glass_gray"),
                setup(new AGlassGreen(), "a_glass_green"),
                setup(new AGlassLightBlue(), "a_glass_light_blue"),
                setup(new AGlassLime(), "a_glass_lime"),
                setup(new AGlassMagenta(), "a_glass_magenta"),
                setup(new AGlassOrange(), "a_glass_orange"),
                setup(new AGlassPink(), "a_glass_pink"),
                setup(new AGlassPurple(), "a_glass_purple"),
                setup(new AGlassRed(), "a_glass_red"),
                setup(new AGlassSilver(), "a_glass_silver"),
                setup(new AGlassWhite(), "a_glass_white"),
                setup(new AGlassYellow(), "a_glass_yellow"));

        registry.registerAll(
                setup(MOLTEN_GLASS_BLACK, "molten_glass_black"),
                setup(MOLTEN_GLASS_BLUE, "molten_glass_blue"),
                setup(MOLTEN_GLASS_BROWN, "molten_glass_brown"),
                setup(MOLTEN_GLASS_CLEAR, "molten_glass_clear"),
                setup(MOLTEN_GLASS_CYAN, "molten_glass_cyan"),
                setup(MOLTEN_GLASS_GRAY, "molten_glass_gray"),
                setup(MOLTEN_GLASS_GREEN, "molten_glass_green"),
                setup(MOLTEN_GLASS_LIGHT_BLUE, "molten_glass_light_blue"),
                setup(MOLTEN_GLASS_LIME, "molten_glass_lime"),
                setup(MOLTEN_GLASS_MAGENTA, "molten_glass_magenta"),
                setup(MOLTEN_GLASS_ORANGE, "molten_glass_orange"),
                setup(MOLTEN_GLASS_PINK, "molten_glass_pink"),
                setup(MOLTEN_GLASS_PURPLE, "molten_glass_purple"),
                setup(MOLTEN_GLASS_RED, "molten_glass_red"),
                setup(MOLTEN_GLASS_SILVER, "molten_glass_silver"),
                setup(MOLTEN_GLASS_WHITE, "molten_glass_white"),
                setup(MOLTEN_GLASS_YELLOW, "molten_glass_yellow")
        );

        Main.CHARACTER_MOD_LOG.debug("Registered block");
    }

    // Register Item Blocks
    @SubscribeEvent
    public static void onRegisterItemsEvent(@Nonnull final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // Item Blocks
        Arrays.stream(new Block[]{

                A_CONCRETE_BLACK,
                A_CONCRETE_BLUE,
                A_CONCRETE_BROWN,
                A_CONCRETE_CYAN,
                A_CONCRETE_GRAY,
                A_CONCRETE_GREEN,
                A_CONCRETE_LIGHT_BLUE,
                A_CONCRETE_LIME,
                A_CONCRETE_MAGENTA,
                A_CONCRETE_ORANGE,
                A_CONCRETE_PINK,
                A_CONCRETE_PURPLE,
                A_CONCRETE_RED,
                A_CONCRETE_SILVER,
                A_CONCRETE_WHITE,
                A_CONCRETE_YELLOW,

                B_CONCRETE_BLACK,
                B_CONCRETE_BLUE,
                B_CONCRETE_BROWN,
                B_CONCRETE_CYAN,
                B_CONCRETE_GRAY,
                B_CONCRETE_GREEN,
                B_CONCRETE_LIGHT_BLUE,
                B_CONCRETE_LIME,
                B_CONCRETE_MAGENTA,
                B_CONCRETE_ORANGE,
                B_CONCRETE_PINK,
                B_CONCRETE_PURPLE,
                B_CONCRETE_RED,
                B_CONCRETE_SILVER,
                B_CONCRETE_WHITE,
                B_CONCRETE_YELLOW,

                C_CONCRETE_BLACK,
                C_CONCRETE_BLUE,
                C_CONCRETE_BROWN,
                C_CONCRETE_CYAN,
                C_CONCRETE_GRAY,
                C_CONCRETE_GREEN,
                C_CONCRETE_LIGHT_BLUE,
                C_CONCRETE_LIME,
                C_CONCRETE_MAGENTA,
                C_CONCRETE_ORANGE,
                C_CONCRETE_PINK,
                C_CONCRETE_PURPLE,
                C_CONCRETE_RED,
                C_CONCRETE_SILVER,
                C_CONCRETE_WHITE,
                C_CONCRETE_YELLOW,

                D_CONCRETE_BLACK,
                D_CONCRETE_BLUE,
                D_CONCRETE_BROWN,
                D_CONCRETE_CYAN,
                D_CONCRETE_GRAY,
                D_CONCRETE_GREEN,
                D_CONCRETE_LIGHT_BLUE,
                D_CONCRETE_LIME,
                D_CONCRETE_MAGENTA,
                D_CONCRETE_ORANGE,
                D_CONCRETE_PINK,
                D_CONCRETE_PURPLE,
                D_CONCRETE_RED,
                D_CONCRETE_SILVER,
                D_CONCRETE_WHITE,
                D_CONCRETE_YELLOW,

                E_CONCRETE_BLACK,
                E_CONCRETE_BLUE,
                E_CONCRETE_BROWN,
                E_CONCRETE_CYAN,
                E_CONCRETE_GRAY,
                E_CONCRETE_GREEN,
                E_CONCRETE_LIGHT_BLUE,
                E_CONCRETE_LIME,
                E_CONCRETE_MAGENTA,
                E_CONCRETE_ORANGE,
                E_CONCRETE_PINK,
                E_CONCRETE_PURPLE,
                E_CONCRETE_RED,
                E_CONCRETE_SILVER,
                E_CONCRETE_WHITE,
                E_CONCRETE_YELLOW,

                F_CONCRETE_BLACK,
                F_CONCRETE_BLUE,
                F_CONCRETE_BROWN,
                F_CONCRETE_CYAN,
                F_CONCRETE_GRAY,
                F_CONCRETE_GREEN,
                F_CONCRETE_LIGHT_BLUE,
                F_CONCRETE_LIME,
                F_CONCRETE_MAGENTA,
                F_CONCRETE_ORANGE,
                F_CONCRETE_PINK,
                F_CONCRETE_PURPLE,
                F_CONCRETE_RED,
                F_CONCRETE_SILVER,
                F_CONCRETE_WHITE,
                F_CONCRETE_YELLOW,

                G_CONCRETE_BLACK,
                G_CONCRETE_BLUE,
                G_CONCRETE_BROWN,
                G_CONCRETE_CYAN,
                G_CONCRETE_GRAY,
                G_CONCRETE_GREEN,
                G_CONCRETE_LIGHT_BLUE,
                G_CONCRETE_LIME,
                G_CONCRETE_MAGENTA,
                G_CONCRETE_ORANGE,
                G_CONCRETE_PINK,
                G_CONCRETE_PURPLE,
                G_CONCRETE_RED,
                G_CONCRETE_SILVER,
                G_CONCRETE_WHITE,
                G_CONCRETE_YELLOW,

                H_CONCRETE_BLACK,
                H_CONCRETE_BLUE,
                H_CONCRETE_BROWN,
                H_CONCRETE_CYAN,
                H_CONCRETE_GRAY,
                H_CONCRETE_GREEN,
                H_CONCRETE_LIGHT_BLUE,
                H_CONCRETE_LIME,
                H_CONCRETE_MAGENTA,
                H_CONCRETE_ORANGE,
                H_CONCRETE_PINK,
                H_CONCRETE_PURPLE,
                H_CONCRETE_RED,
                H_CONCRETE_SILVER,
                H_CONCRETE_WHITE,
                H_CONCRETE_YELLOW,

                I_CONCRETE_BLACK,
                I_CONCRETE_BLUE,
                I_CONCRETE_BROWN,
                I_CONCRETE_CYAN,
                I_CONCRETE_GRAY,
                I_CONCRETE_GREEN,
                I_CONCRETE_LIGHT_BLUE,
                I_CONCRETE_LIME,
                I_CONCRETE_MAGENTA,
                I_CONCRETE_ORANGE,
                I_CONCRETE_PINK,
                I_CONCRETE_PURPLE,
                I_CONCRETE_RED,
                I_CONCRETE_SILVER,
                I_CONCRETE_WHITE,
                I_CONCRETE_YELLOW,

                J_CONCRETE_BLACK,
                J_CONCRETE_BLUE,
                J_CONCRETE_BROWN,
                J_CONCRETE_CYAN,
                J_CONCRETE_GRAY,
                J_CONCRETE_GREEN,
                J_CONCRETE_LIGHT_BLUE,
                J_CONCRETE_LIME,
                J_CONCRETE_MAGENTA,
                J_CONCRETE_ORANGE,
                J_CONCRETE_PINK,
                J_CONCRETE_PURPLE,
                J_CONCRETE_RED,
                J_CONCRETE_SILVER,
                J_CONCRETE_WHITE,
                J_CONCRETE_YELLOW,

                K_CONCRETE_BLACK,
                K_CONCRETE_BLUE,
                K_CONCRETE_BROWN,
                K_CONCRETE_CYAN,
                K_CONCRETE_GRAY,
                K_CONCRETE_GREEN,
                K_CONCRETE_LIGHT_BLUE,
                K_CONCRETE_LIME,
                K_CONCRETE_MAGENTA,
                K_CONCRETE_ORANGE,
                K_CONCRETE_PINK,
                K_CONCRETE_PURPLE,
                K_CONCRETE_RED,
                K_CONCRETE_SILVER,
                K_CONCRETE_WHITE,
                K_CONCRETE_YELLOW,

                L_CONCRETE_BLACK,
                L_CONCRETE_BLUE,
                L_CONCRETE_BROWN,
                L_CONCRETE_CYAN,
                L_CONCRETE_GRAY,
                L_CONCRETE_GREEN,
                L_CONCRETE_LIGHT_BLUE,
                L_CONCRETE_LIME,
                L_CONCRETE_MAGENTA,
                L_CONCRETE_ORANGE,
                L_CONCRETE_PINK,
                L_CONCRETE_PURPLE,
                L_CONCRETE_RED,
                L_CONCRETE_SILVER,
                L_CONCRETE_WHITE,
                L_CONCRETE_YELLOW,

                M_CONCRETE_BLACK,
                M_CONCRETE_BLUE,
                M_CONCRETE_BROWN,
                M_CONCRETE_CYAN,
                M_CONCRETE_GRAY,
                M_CONCRETE_GREEN,
                M_CONCRETE_LIGHT_BLUE,
                M_CONCRETE_LIME,
                M_CONCRETE_MAGENTA,
                M_CONCRETE_ORANGE,
                M_CONCRETE_PINK,
                M_CONCRETE_PURPLE,
                M_CONCRETE_RED,
                M_CONCRETE_SILVER,
                M_CONCRETE_WHITE,
                M_CONCRETE_YELLOW,

                N_CONCRETE_BLACK,
                N_CONCRETE_BLUE,
                N_CONCRETE_BROWN,
                N_CONCRETE_CYAN,
                N_CONCRETE_GRAY,
                N_CONCRETE_GREEN,
                N_CONCRETE_LIGHT_BLUE,
                N_CONCRETE_LIME,
                N_CONCRETE_MAGENTA,
                N_CONCRETE_ORANGE,
                N_CONCRETE_PINK,
                N_CONCRETE_PURPLE,
                N_CONCRETE_RED,
                N_CONCRETE_SILVER,
                N_CONCRETE_WHITE,
                N_CONCRETE_YELLOW,

                O_CONCRETE_BLACK,
                O_CONCRETE_BLUE,
                O_CONCRETE_BROWN,
                O_CONCRETE_CYAN,
                O_CONCRETE_GRAY,
                O_CONCRETE_GREEN,
                O_CONCRETE_LIGHT_BLUE,
                O_CONCRETE_LIME,
                O_CONCRETE_MAGENTA,
                O_CONCRETE_ORANGE,
                O_CONCRETE_PINK,
                O_CONCRETE_PURPLE,
                O_CONCRETE_RED,
                O_CONCRETE_SILVER,
                O_CONCRETE_WHITE,
                O_CONCRETE_YELLOW,

                P_CONCRETE_BLACK,
                P_CONCRETE_BLUE,
                P_CONCRETE_BROWN,
                P_CONCRETE_CYAN,
                P_CONCRETE_GRAY,
                P_CONCRETE_GREEN,
                P_CONCRETE_LIGHT_BLUE,
                P_CONCRETE_LIME,
                P_CONCRETE_MAGENTA,
                P_CONCRETE_ORANGE,
                P_CONCRETE_PINK,
                P_CONCRETE_PURPLE,
                P_CONCRETE_RED,
                P_CONCRETE_SILVER,
                P_CONCRETE_WHITE,
                P_CONCRETE_YELLOW,

                Q_CONCRETE_BLACK,
                Q_CONCRETE_BLUE,
                Q_CONCRETE_BROWN,
                Q_CONCRETE_CYAN,
                Q_CONCRETE_GRAY,
                Q_CONCRETE_GREEN,
                Q_CONCRETE_LIGHT_BLUE,
                Q_CONCRETE_LIME,
                Q_CONCRETE_MAGENTA,
                Q_CONCRETE_ORANGE,
                Q_CONCRETE_PINK,
                Q_CONCRETE_PURPLE,
                Q_CONCRETE_RED,
                Q_CONCRETE_SILVER,
                Q_CONCRETE_WHITE,
                Q_CONCRETE_YELLOW,

                R_CONCRETE_BLACK,
                R_CONCRETE_BLUE,
                R_CONCRETE_BROWN,
                R_CONCRETE_CYAN,
                R_CONCRETE_GRAY,
                R_CONCRETE_GREEN,
                R_CONCRETE_LIGHT_BLUE,
                R_CONCRETE_LIME,
                R_CONCRETE_MAGENTA,
                R_CONCRETE_ORANGE,
                R_CONCRETE_PINK,
                R_CONCRETE_PURPLE,
                R_CONCRETE_RED,
                R_CONCRETE_SILVER,
                R_CONCRETE_WHITE,
                R_CONCRETE_YELLOW,

                S_CONCRETE_BLACK,
                S_CONCRETE_BLUE,
                S_CONCRETE_BROWN,
                S_CONCRETE_CYAN,
                S_CONCRETE_GRAY,
                S_CONCRETE_GREEN,
                S_CONCRETE_LIGHT_BLUE,
                S_CONCRETE_LIME,
                S_CONCRETE_MAGENTA,
                S_CONCRETE_ORANGE,
                S_CONCRETE_PINK,
                S_CONCRETE_PURPLE,
                S_CONCRETE_RED,
                S_CONCRETE_SILVER,
                S_CONCRETE_WHITE,
                S_CONCRETE_YELLOW,

                T_CONCRETE_BLACK,
                T_CONCRETE_BLUE,
                T_CONCRETE_BROWN,
                T_CONCRETE_CYAN,
                T_CONCRETE_GRAY,
                T_CONCRETE_GREEN,
                T_CONCRETE_LIGHT_BLUE,
                T_CONCRETE_LIME,
                T_CONCRETE_MAGENTA,
                T_CONCRETE_ORANGE,
                T_CONCRETE_PINK,
                T_CONCRETE_PURPLE,
                T_CONCRETE_RED,
                T_CONCRETE_SILVER,
                T_CONCRETE_WHITE,
                T_CONCRETE_YELLOW,

                U_CONCRETE_BLACK,
                U_CONCRETE_BLUE,
                U_CONCRETE_BROWN,
                U_CONCRETE_CYAN,
                U_CONCRETE_GRAY,
                U_CONCRETE_GREEN,
                U_CONCRETE_LIGHT_BLUE,
                U_CONCRETE_LIME,
                U_CONCRETE_MAGENTA,
                U_CONCRETE_ORANGE,
                U_CONCRETE_PINK,
                U_CONCRETE_PURPLE,
                U_CONCRETE_RED,
                U_CONCRETE_SILVER,
                U_CONCRETE_WHITE,
                U_CONCRETE_YELLOW,

                V_CONCRETE_BLACK,
                V_CONCRETE_BLUE,
                V_CONCRETE_BROWN,
                V_CONCRETE_CYAN,
                V_CONCRETE_GRAY,
                V_CONCRETE_GREEN,
                V_CONCRETE_LIGHT_BLUE,
                V_CONCRETE_LIME,
                V_CONCRETE_MAGENTA,
                V_CONCRETE_ORANGE,
                V_CONCRETE_PINK,
                V_CONCRETE_PURPLE,
                V_CONCRETE_RED,
                V_CONCRETE_SILVER,
                V_CONCRETE_WHITE,
                V_CONCRETE_YELLOW,

                W_CONCRETE_BLACK,
                W_CONCRETE_BLUE,
                W_CONCRETE_BROWN,
                W_CONCRETE_CYAN,
                W_CONCRETE_GRAY,
                W_CONCRETE_GREEN,
                W_CONCRETE_LIGHT_BLUE,
                W_CONCRETE_LIME,
                W_CONCRETE_MAGENTA,
                W_CONCRETE_ORANGE,
                W_CONCRETE_PINK,
                W_CONCRETE_PURPLE,
                W_CONCRETE_RED,
                W_CONCRETE_SILVER,
                W_CONCRETE_WHITE,
                W_CONCRETE_YELLOW,

                X_CONCRETE_BLACK,
                X_CONCRETE_BLUE,
                X_CONCRETE_BROWN,
                X_CONCRETE_CYAN,
                X_CONCRETE_GRAY,
                X_CONCRETE_GREEN,
                X_CONCRETE_LIGHT_BLUE,
                X_CONCRETE_LIME,
                X_CONCRETE_MAGENTA,
                X_CONCRETE_ORANGE,
                X_CONCRETE_PINK,
                X_CONCRETE_PURPLE,
                X_CONCRETE_RED,
                X_CONCRETE_SILVER,
                X_CONCRETE_WHITE,
                X_CONCRETE_YELLOW,

                Y_CONCRETE_BLACK,
                Y_CONCRETE_BLUE,
                Y_CONCRETE_BROWN,
                Y_CONCRETE_CYAN,
                Y_CONCRETE_GRAY,
                Y_CONCRETE_GREEN,
                Y_CONCRETE_LIGHT_BLUE,
                Y_CONCRETE_LIME,
                Y_CONCRETE_MAGENTA,
                Y_CONCRETE_ORANGE,
                Y_CONCRETE_PINK,
                Y_CONCRETE_PURPLE,
                Y_CONCRETE_RED,
                Y_CONCRETE_SILVER,
                Y_CONCRETE_WHITE,
                Y_CONCRETE_YELLOW,

                Z_CONCRETE_BLACK,
                Z_CONCRETE_BLUE,
                Z_CONCRETE_BROWN,
                Z_CONCRETE_CYAN,
                Z_CONCRETE_GRAY,
                Z_CONCRETE_GREEN,
                Z_CONCRETE_LIGHT_BLUE,
                Z_CONCRETE_LIME,
                Z_CONCRETE_MAGENTA,
                Z_CONCRETE_ORANGE,
                Z_CONCRETE_PINK,
                Z_CONCRETE_PURPLE,
                Z_CONCRETE_RED,
                Z_CONCRETE_SILVER,
                Z_CONCRETE_WHITE,
                Z_CONCRETE_YELLOW,

                A_GLASS_BLACK,
                A_GLASS_BLUE,
                A_GLASS_BROWN,
                A_GLASS_CYAN,
                A_GLASS_CLEAR,
                A_GLASS_GRAY,
                A_GLASS_GREEN,
                A_GLASS_LIGHT_BLUE,
                A_GLASS_LIME,
                A_GLASS_MAGENTA,
                A_GLASS_ORANGE,
                A_GLASS_PINK,
                A_GLASS_PURPLE,
                A_GLASS_RED,
                A_GLASS_SILVER,
                A_GLASS_WHITE,
                A_GLASS_YELLOW,

        }).forEach(block -> {
            Preconditions.checkNotNull(block.getRegistryName(), "Registry name cannot be null!");
            registry.register(
                    ModUtil.setCreativeTab(
                            ModUtil.setRegistryNames(
                                    new ItemBlock(block),
                                    block.getRegistryName())
                    )
            );
        });

        // Register Items
        for (String color : Reference.colorsGlass) {
            event.getRegistry().registerAll(
                    setup(new ItemBase(), "glass_shard_" + color)
            );
        }
        for (String letter : Reference.aZ) {
            event.getRegistry().registerAll(
                    setup(new ItemWithReturn(), "mold_" + letter)
            );
        }
        event.getRegistry().registerAll(
                setup(new ItemChisel(1561), "chisel_diamond"),
                setup(new ItemChisel(999), "chisel_gold"),
                setup(new ItemChisel(260), "chisel_iron"),

                setup(new ItemGlassCutter(ToolMaterial.DIAMOND, 1561), "cutter_glass_diamond"),
                setup(new ItemGlassCutter(ToolMaterial.GOLD, 100), "cutter_glass_gold"),
                setup(new ItemGlassCutter(ToolMaterial.IRON, 260), "cutter_glass_iron")
        );
        Main.CHARACTER_MOD_LOG.debug("Registered items and item-blocks");
    }

    @Nonnull
    private static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final String name) {
        return setup(entry, new ResourceLocation(MOD_ID, name));
    }

    @Nonnull
    private static <T extends IForgeRegistryEntry> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        if (entry instanceof Block) {
            ((Block) entry).setTranslationKey(MOD_ID + "." + registryName.getPath());
        }
        if (entry instanceof Item) {
            ((Item) entry).setTranslationKey(MOD_ID + "." + registryName.getPath());
        }
        return entry;
    }
}