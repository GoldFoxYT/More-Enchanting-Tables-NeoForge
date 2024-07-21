package net.goldfoxyt.met.block;

import com.mojang.serialization.MapCodec;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

import net.goldfoxyt.met.block.blockentity.ColoredEnchantingTableBlockEntity;
import net.goldfoxyt.met.block.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColoredEnchantingTable extends BaseEntityBlock {
    public static final MapCodec<ColoredEnchantingTable> CODEC = simpleCodec(ColoredEnchantingTable::new);
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter((x) -> {
        return Math.abs(x.getX()) == 2 || Math.abs(x.getZ()) == 2;
    }).map(BlockPos::immutable).toList();

    public MapCodec<ColoredEnchantingTable> codec() {
        return CODEC;
    }

    public ColoredEnchantingTable(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public static boolean isValidBookShelf(Level pLevel, BlockPos pEnchantingTablePos, BlockPos pBookshelfPos) {
        return pLevel.getBlockState(pEnchantingTablePos.offset(pBookshelfPos)).getEnchantPowerBonus(pLevel, pEnchantingTablePos.offset(pBookshelfPos)) != 0.0F && pLevel.getBlockState(pEnchantingTablePos.offset(pBookshelfPos.getX() / 2, pBookshelfPos.getY(), pBookshelfPos.getZ() / 2)).is(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
    }

    protected boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        Iterator var5 = BOOKSHELF_OFFSETS.iterator();

        while(var5.hasNext()) {
            BlockPos blockpos = (BlockPos)var5.next();
            if (pRandom.nextInt(16) == 0 && isValidBookShelf(pLevel, pPos, blockpos)) {
                pLevel.addParticle(ParticleTypes.ENCHANT, (double)pPos.getX() + 0.5, (double)pPos.getY() + 2.0, (double)pPos.getZ() + 0.5, (double)((float)blockpos.getX() + pRandom.nextFloat()) - 0.5, (double)((float)blockpos.getY() - pRandom.nextFloat() - 1.0F), (double)((float)blockpos.getZ() + pRandom.nextFloat()) - 0.5);
            }
        }

    }

    protected RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ColoredEnchantingTableBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState blockState, BlockEntityType<T> type) {
        if (pLevel.isClientSide) {
            return createTickerHelper(type, ModBlockEntities.COLORED_ENCHANTING_TABLE.get(),
                    ColoredEnchantingTableBlockEntity::bookAnimationTick);
        }
        return null;
    }
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return InteractionResult.CONSUME;
        }
    }
    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof ColoredEnchantingTableBlockEntity) {
            Component component = ((Nameable)blockentity).getDisplayName();
            return new SimpleMenuProvider((p_328554_, p_332165_, p_330050_) -> {
                return new EnchantmentMenu(p_328554_, p_332165_, ContainerLevelAccess.create(pLevel, pPos));
            }, component);
        } else {
            return null;
        }
    }

    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType) {
        return false;
    }
}
