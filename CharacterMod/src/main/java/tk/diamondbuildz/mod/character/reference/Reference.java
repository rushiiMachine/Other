package tk.diamondbuildz.mod.character.reference;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fluids.Fluid;
import tk.diamondbuildz.mod.character.Main;

import java.util.HashSet;
import java.util.Set;

/**
 * Global variables that are needed in my Mod
 *
 * @author Diamond
 */
public class Reference {
    public static final String MOD_NAME = "Diamond's Character Mod";

    public static final String MOD_ID = "character_mod";

    /**
     * The fully qualified name of the version of IProxy that gets injected into {@link Main#proxy} on a PHYSICAL CLIENT
     */
    public static final String CLIENT_PROXY_CLASS = "tk.diamondbuildz.mod.character.client.ClientProxy";

    /**
     * The fully qualified name of the version of IProxy that gets injected into {@link Main#proxy} on a PHYSICAL/DEDICATED SERVER
     */
    public static final String SERVER_PROXY_CLASS = "tk.diamondbuildz.mod.character.server.ServerProxy";

    /**
     * @see "https://maven.apache.org/enforcer/enforcer-rules/versionRanges.html"
     */
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    /**
     * @see "https://maven.apache.org/enforcer/enforcer-rules/versionRanges.html"
     */
    public static final String DEPENDENCIES =
            "required-after:minecraft;" +
                    "required-after:forge@[14.23.5.2768,);";

    /**
     * "@VERSION@" is replaced by build.gradle with the actual version
     *
     * @see <a href= "https://mcforge.readthedocs.io/en/latest/conventions/versioning/">Forge Versioning Docs</a>
     */
    public static final String VERSION = "@VERSION@";

    /**
     * "@FINGERPRINT@" is replaced by build.gradle with the actual fingerprint
     *
     * @see "https://tutorials.darkhax.net/tutorials/jar_signing/"
     */
    public static final String CERTIFICATE_FINGERPRINT = "@FINGERPRINT@";

    /**
     * Bounding Boxes for Blocks
     * <p>
     * [LETTER]_N(NORTH)S(SOUTH)
     * [LETTER]_E(EAST)W(WEST)
     */
    // A
    public static final AxisAlignedBB A_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB A_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // B
    public static final AxisAlignedBB B_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 12, 0.0625 * 12, 0.0625 * 9);
    public static final AxisAlignedBB B_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 12, 0.0625 * 12);
    // C
    public static final AxisAlignedBB C_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 12, 0.0625 * 9);
    public static final AxisAlignedBB C_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 12, 0.0625 * 13);
    // D
    public static final AxisAlignedBB D_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 12, 0.0625 * 12, 0.0625 * 9);
    public static final AxisAlignedBB D_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 12, 0.0625 * 12);
    // E
    public static final AxisAlignedBB E_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB E_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // F
    public static final AxisAlignedBB F_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB F_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // G
    public static final AxisAlignedBB G_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB G_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // H
    public static final AxisAlignedBB H_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB H_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // I
    public static final AxisAlignedBB I_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB I_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // J
    public static final AxisAlignedBB J_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB J_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // K
    public static final AxisAlignedBB K_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB K_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // L
    public static final AxisAlignedBB L_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB L_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // M
    public static final AxisAlignedBB M_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB M_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // N
    public static final AxisAlignedBB N_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB N_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // O
    public static final AxisAlignedBB O_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB O_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // P
    public static final AxisAlignedBB P_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB P_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // Q
    public static final AxisAlignedBB Q_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB Q_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // R
    public static final AxisAlignedBB R_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB R_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // S
    public static final AxisAlignedBB S_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB S_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // T
    public static final AxisAlignedBB T_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB T_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // U
    public static final AxisAlignedBB U_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB U_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // V
    public static final AxisAlignedBB V_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB V_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // W
    public static final AxisAlignedBB W_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB W_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // X
    public static final AxisAlignedBB X_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB X_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // Y
    public static final AxisAlignedBB Y_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB Y_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);
    // Z
    public static final AxisAlignedBB Z_NS = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 7, 0.0625 * 13, 0.0625 * 13, 0.0625 * 9);
    public static final AxisAlignedBB Z_EW = new AxisAlignedBB(0.0625 * 7, 0, 0.0625 * 3, 0.0625 * 9, 0.0625 * 13, 0.0625 * 13);

    // Resource Prefix
    private static final String RESOURCE_PREFIX = MOD_ID + ":";

    // Fluid Model Path
    public static final String FLUID_MODEL_PATH = RESOURCE_PREFIX + "fluid";

    // Add fluids to Set to register later
    public static Set<Fluid> fluids = new HashSet<>();

    /**
     * Register block by iterating these colors and different letters of the alphabet
     * {@link tk.diamondbuildz.mod.character.EventSubscriber}
     */
    public static final String[] colors = new String[]{
            "black",
            "blue",
            "brown",
            "cyan",
            "gray",
            "green",
            "light_blue",
            "lime",
            "magenta",
            "orange",
            "pink",
            "purple",
            "red",
            "silver",
            "white",
            "yellow"
    };
    public static final String[] colorsGlass = new String[]{
            "black",
            "blue",
            "brown",
            "clear",
            "cyan",
            "gray",
            "green",
            "light_blue",
            "lime",
            "magenta",
            "orange",
            "pink",
            "purple",
            "red",
            "silver",
            "white",
            "yellow"
    };
    public static final String[] aZ = new String[]{
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z"
    };
}