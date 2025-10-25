package net.papasconcheddar.cloudbackupmod.screen.custom;

import net.minecraft.client.gui.components.*;
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

        addRenderableWidget(new EditBox(
                this.font,
                this.width / 2 - 100, // x position (centered)
                this.height / 2 - 10, // y position
                200, // width
                20, // height
                Component.literal("Text Field")
        ));

        addRenderableWidget(new StringWidget(
                200, // width
                20, // height
                this.width / 2 - 100, // x position (centered)
                this.height / 2 - 10, // y position
                Component.literal("Text Field"),
                this.font
        ));

        addRenderableWidget(Button.builder(Component.literal("Sí"), b -> {
            onClose();
        }).bounds(x + 20, y + 60, 60, 20).build());

        addRenderableWidget(Button.builder(Component.literal("No"), b -> {
            onClose();
        }).bounds(x + 100, y + 60, 60, 20).build());
    }

}
