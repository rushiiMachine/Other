package tk.diamondbuildz.mod.character.blockbases;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import tk.diamondbuildz.mod.character.Main;
import tk.diamondbuildz.mod.character.reference.ModItems;
import tk.diamondbuildz.mod.character.reference.Reference;
import tk.diamondbuildz.mod.character.util.ModUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class BlockBaseGlassA extends Block {
    private static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    private int quantity;
    public EntityPlayer entityPlayer;

    public BlockBaseGlassA() {
        super(Material.GLASS);
        this.setHardness(0.3F);
        this.setSoundType(SoundType.GLASS);
        this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        ModUtil.setCreativeTab(this);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.byHorizontalIndex(meta);
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing facing = state.getValue(FACING);

        int facingbits = facing.getHorizontalIndex();
        return facingbits;
    }

    @Override
    @Nonnull
    public IBlockState getStateForPlacement(@Nullable World world, @Nullable BlockPos pos, @Nullable EnumFacing facing, float hitX, float hitY, float hitZ, int meta, @Nullable EntityLivingBase placer, EnumHand hand) {
        assert placer != null;
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        if (harvesters.get() != null) {
            entityPlayer = harvesters.get();
            Item MainHandHeldItem = entityPlayer.getHeldItemMainhand().getItem();
            if (MainHandHeldItem.equals(ModItems.CUTTER_GLASS_DIAMOND) || MainHandHeldItem.equals(ModItems.CUTTER_GLASS_IRON)) {
                this.quantity = 1;
            } else {
                this.quantity = Main.randomNumber(0, 3);
            }
        }
        return this.quantity;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = state.getValue(FACING);

        switch (enumfacing) {
            case SOUTH:
            default:
                return Reference.A_NS;
            case WEST:
                return Reference.A_EW;
            case NORTH:
                return Reference.A_NS;
            case EAST:
                return Reference.A_EW;
        }
    }
}