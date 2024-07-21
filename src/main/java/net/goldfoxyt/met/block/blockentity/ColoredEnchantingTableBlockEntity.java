package net.goldfoxyt.met.block.blockentity;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component.Serializer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ColoredEnchantingTableBlockEntity extends BlockEntity implements Nameable{
    public int time;
    public float flip;
    public float oFlip;
    public float flipT;
    public float flipA;
    public float open;
    public float oOpen;
    public float rot;
    public float oRot;
    public float tRot;
    private static final RandomSource RANDOM = RandomSource.create();
    @Nullable
    private Component name;

    public ColoredEnchantingTableBlockEntity(BlockPos pPos, BlockState pState) {
        super(ModBlockEntities.COLORED_ENCHANTING_TABLE.get(), pPos, pState);
    }

    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (this.hasCustomName()) {
            pTag.putString("CustomName", Serializer.toJson(this.name, pRegistries));
        }

    }

    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        if (pTag.contains("CustomName", 8)) {
            this.name = parseCustomNameSafe(pTag.getString("CustomName"), pRegistries);
        }

    }

    public static void bookAnimationTick(Level pLevel, BlockPos pPos, BlockState pState, ColoredEnchantingTableBlockEntity pEnchantingTable) {
        pEnchantingTable.oOpen = pEnchantingTable.open;
        pEnchantingTable.oRot = pEnchantingTable.rot;
        Player $$4 = pLevel.getNearestPlayer((double)pPos.getX() + 0.5, (double)pPos.getY() + 0.5, (double)pPos.getZ() + 0.5, 3.0, false);
        if ($$4 != null) {
            double $$5 = $$4.getX() - ((double)pPos.getX() + 0.5);
            double $$6 = $$4.getZ() - ((double)pPos.getZ() + 0.5);
            pEnchantingTable.tRot = (float)Mth.atan2($$6, $$5);
            pEnchantingTable.open += 0.1F;
            if (pEnchantingTable.open < 0.5F || RANDOM.nextInt(40) == 0) {
                float $$7 = pEnchantingTable.flipT;

                do {
                    pEnchantingTable.flipT += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
                } while($$7 == pEnchantingTable.flipT);
            }
        } else {
            pEnchantingTable.tRot += 0.02F;
            pEnchantingTable.open -= 0.1F;
        }

        while(pEnchantingTable.rot >= 3.1415927F) {
            pEnchantingTable.rot -= 6.2831855F;
        }

        while(pEnchantingTable.rot < -3.1415927F) {
            pEnchantingTable.rot += 6.2831855F;
        }

        while(pEnchantingTable.tRot >= 3.1415927F) {
            pEnchantingTable.tRot -= 6.2831855F;
        }

        while(pEnchantingTable.tRot < -3.1415927F) {
            pEnchantingTable.tRot += 6.2831855F;
        }

        float $$8;
        for($$8 = pEnchantingTable.tRot - pEnchantingTable.rot; $$8 >= 3.1415927F; $$8 -= 6.2831855F) {
        }

        while($$8 < -3.1415927F) {
            $$8 += 6.2831855F;
        }

        pEnchantingTable.rot += $$8 * 0.4F;
        pEnchantingTable.open = Mth.clamp(pEnchantingTable.open, 0.0F, 1.0F);
        ++pEnchantingTable.time;
        pEnchantingTable.oFlip = pEnchantingTable.flip;
        float $$9 = (pEnchantingTable.flipT - pEnchantingTable.flip) * 0.4F;
        float $$10 = 0.2F;
        $$9 = Mth.clamp($$9, -0.2F, 0.2F);
        pEnchantingTable.flipA += ($$9 - pEnchantingTable.flipA) * 0.9F;
        pEnchantingTable.flip += pEnchantingTable.flipA;
    }

    public Component getName() {
        return (Component)(this.name != null ? this.name : Component.translatable("container.enchant"));
    }

    public void setCustomName(@Nullable Component pCustomName) {
        this.name = pCustomName;
    }

    @Nullable
    public Component getCustomName() {
        return this.name;
    }

    protected void applyImplicitComponents(BlockEntity.DataComponentInput pComponentInput) {
        super.applyImplicitComponents(pComponentInput);
        this.name = (Component)pComponentInput.get(DataComponents.CUSTOM_NAME);
    }

    protected void collectImplicitComponents(DataComponentMap.Builder pComponents) {
        super.collectImplicitComponents(pComponents);
        pComponents.set(DataComponents.CUSTOM_NAME, this.name);
    }
    public void removeComponentsFromTag(CompoundTag pTag) {
        pTag.remove("CustomName");
    }
}
