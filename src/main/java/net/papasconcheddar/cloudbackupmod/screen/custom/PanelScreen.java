package net.papasconcheddar.cloudbackupmod.screen.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PanelScreen extends AbstractContainerScreen<PanelMenu>{

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("cloudbackupid", "textures/menu.png");

    public PanelScreen(PanelMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }


    public Component Panelcreen(){
        return Component.literal("PanelScreen");
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {

    }
}
