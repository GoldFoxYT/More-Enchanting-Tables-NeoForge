package net.goldfoxyt.met.mixin;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {

    @Shadow @Final private Container enchantSlots;

    /**
     * @author GoldFoxYT
     * @reason To put the custom enchanting tables in the stillValid method.
     */
    @Overwrite
    public boolean stillValid(Player player) {
        return this.enchantSlots.stillValid(player);
    }
}
