package tk.diamondbuildz.mod.character;

import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tk.diamondbuildz.mod.character.reference.ModFluids;
import tk.diamondbuildz.mod.character.reference.Reference;
import tk.diamondbuildz.mod.character.util.IProxy;

import java.util.Random;

import static tk.diamondbuildz.mod.character.reference.Reference.*;

/**
 * Class that contains initialization methods and declares things for my Mod
 *
 * @author Diamond
 */
@Mod(
        modid = MOD_ID,
        name = MOD_NAME,
        version = VERSION,
        acceptedMinecraftVersions = ACCEPTED_VERSIONS,
        dependencies = DEPENDENCIES,
        certificateFingerprint = CERTIFICATE_FINGERPRINT
)
public class Main {

    public static final Logger CHARACTER_MOD_LOG = LogManager.getLogger(MOD_ID);
    private static final Logger LOGGER = LogManager.getLogger();

    @Mod.Instance(MOD_ID)
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    /**
     * Called before preInit
     */
    static {
        FluidRegistry.enableUniversalBucket();
    }

    /**
     * Run before anything else. <s>Read your config, create block, items, etc, and register them with the GameRegistry</s>
     *
     * @param event the event
     * @see ForgeModContainer#preInit(FMLPreInitializationEvent)
     */
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.logPhysicalSide(CHARACTER_MOD_LOG);
    }

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes, send FMLInterModComms messages to other mods.
     *
     * @param event the event
     */
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_BLACK);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_BLUE);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_BROWN);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_CLEAR);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_CYAN);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_GRAY);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_GREEN);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_LIGHT_BLUE);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_LIME);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_MAGENTA);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_ORANGE);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_PINK);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_PURPLE);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_RED);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_SILVER);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_WHITE);
        FluidRegistry.addBucketForFluid(ModFluids.FLUID_MOLTEN_GLASS_YELLOW);
    }

    /**
     * Mod compatibility, or anything which depends on other mods’ init phases being finished.
     *
     * @param event the event
     * @see ForgeModContainer#postInit(FMLPostInitializationEvent)
     */
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    /**
     * Do your invalid fingerprint handling here
     *
     * @param event the event
     * @see "https://tutorials.darkhax.net/tutorials/jar_signing/" and "https://mcforge.readthedocs.io/en/latest/concepts/jarsigning/"
     */
    @Mod.EventHandler
    public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
        CHARACTER_MOD_LOG.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported by Diamond! Releases are held https://github.com/DiamondMiner88/CharacterMod/releases");
    }

    /**
     * Makes a random number between the ranges
     *
     * @param min min int
     * @param max max int
     * @return random int
     */
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}