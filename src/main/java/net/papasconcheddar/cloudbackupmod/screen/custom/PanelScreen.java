package net.papasconcheddar.cloudbackupmod.screen.custom;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.systems.RenderSystem;
import net.papasconcheddar.cloudbackupmod.CloudBackupMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PanelScreen extends AbstractContainerScreen<PanelMenu>{

    private static final ResourceLocation BG = new ResourceLocation("cloudbackupid", "textures/menu.png");


    public Component Panelcreen(){
        return Component.literal("PanelScreen");
    }






}
