package net.papasconcheddar.cloudbackupmod.screen.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.papasconcheddar.cloudbackupmod.screen.ModMenuTypes;


public class PanelMenu extends AbstractContainerMenu {
    private final Level level;

    public PanelMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public PanelMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.PANEL_MENU.get(), containerId);
        this.level = inv.player.level();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}