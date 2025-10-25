package net.papasconcheddar.cloudbackupmod.screen.custom;

import com.google.common.graph.Network;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Panel extends Screen {

    public Panel(String question) {
        super(Component.literal(question));
    }

    @Override
    protected void init() {
        int w = 180, h = 100;
        int x = (width - w) / 2;
        int y = (height - h) / 2;

        addRenderableWidget(Button.builder(Component.literal("Sí"), b -> {

        }).bounds(x + 20, y + 60, 60, 20).build());

        addRenderableWidget(Button.builder(Component.literal("No"), b -> {

        }).bounds(x + 100, y + 60, 60, 20).build());
    }

}
