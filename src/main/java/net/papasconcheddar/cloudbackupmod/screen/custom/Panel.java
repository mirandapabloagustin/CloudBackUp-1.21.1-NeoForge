package net.papasconcheddar.cloudbackupmod.screen.custom;

import com.google.common.graph.Network;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.searchtree.ResourceLocationSearchTree;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.papasconcheddar.cloudbackupmod.CloudBackupMod;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class Panel extends Screen {
    private static final ResourceLocation PANEL = ResourceLocation.fromNamespaceAndPath(CloudBackupMod.MODID, "textures/manu.png");
//    private final String question;

//    public Panel(String question) {
//        super(Component.literal(question));
//        this.question = question;
//    }

//    @Override
//    protected void init() {
//        int w = 180, h = 100;
//        int x = (width - w) / 2;
//        int y = (height - h) / 2;
//
//        addRenderableWidget(new EditBox(
//                this.font,
//                this.width / 2 - 100, // x position (centered)
//                this.height / 2 - 10, // y position
//                200, // width
//                20, // height
//                Component.literal("Text Field")
//        ));
//
//        addRenderableWidget(new StringWidget(
//                200, // width
//                20, // height
//                this.width / 2 - 100, // x position (centered)
//                this.height / 2 - 10, // y position
//                Component.literal("Text Field"),
//                this.font
//        ));
//
//        addRenderableWidget(Button.builder(Component.literal("Sí"), b -> {
//            onClose();
//        }).bounds(x + 20, y + 60, 60, 20).build());
//
//        addRenderableWidget(Button.builder(Component.literal("No"), b -> {
//            onClose();
//        }).bounds(x + 100, y + 60, 60, 20).build());
//    }
    private EditBox rutaInput;
    private Button guardarBtn, siBtn, onBtn, offBtn;
    private StringWidget rutaLabel, remotoLabel;

    private boolean remotoActivo = false;

    public Panel() {
        super(Component.literal("Cloud Backup Menu"));
    }

    @Override
    protected void init() {
        // --- Medidas base (proporcionales al tamaño de pantalla) ---
        int panelWidth = (int) (width * 0.5);     // 50% del ancho del viewport
        int panelHeight = (int) (height * 0.4);   // 40% del alto
        int startX = (width - panelWidth) / 2;    // centrado horizontal
        int startY = (height - panelHeight) / 2;  // centrado vertical

        int centerX = width / 2;

        int fieldWidth = (int) (panelWidth * 0.6);
        int fieldHeight = 20;
        int gap = 25; // separación vertical

        // --- 1️⃣ Etiqueta: "Ruta carpeta" ---
        rutaLabel = new StringWidget(
                fieldWidth, 20,
                centerX - fieldWidth / 2,
                startY + gap,
                Component.literal("Ruta carpeta:"),
                this.font
        );
        addRenderableWidget(rutaLabel);

        // --- 2️⃣ Input ruta ---
        rutaInput = new EditBox(
                this.font,
                centerX - fieldWidth / 2,
                startY + gap * 2,
                fieldWidth,
                fieldHeight,
                Component.literal("Ruta")
        );
        addRenderableWidget(rutaInput);

        // --- 3️⃣ Botones "Guardar" y "Sí" ---
        int btnW = 70;
        int btnH = 20;
        int btnY = startY + gap * 4;

        guardarBtn = Button.builder(Component.literal("Guardar"), b -> {
            // TODO: acción guardar
            Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("Guardado en: " + rutaInput.getValue())
            );
        }).bounds(centerX - btnW - 10, btnY, btnW, btnH).build();

        siBtn = Button.builder(Component.literal("Sí"), b -> {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Opción 'Sí' elegida"));
        }).bounds(centerX + 10, btnY, btnW, btnH).build();

        addRenderableWidget(guardarBtn);
        addRenderableWidget(siBtn);

        // --- 4️⃣ Etiqueta: "Vincular remoto" ---
        remotoLabel = new StringWidget(
                fieldWidth, 20,
                centerX - fieldWidth / 2,
                btnY + gap * 2,
                Component.literal("Vincular remoto:"),
                this.font
        );
        addRenderableWidget(remotoLabel);

        // --- 5️⃣ Switch ON / OFF ---
        onBtn = Button.builder(Component.literal("ON"), b -> {
            remotoActivo = true;
            updateSwitch();
        }).bounds(centerX - 50, btnY + gap * 3, 40, 20).build();

        offBtn = Button.builder(Component.literal("OFF"), b -> {
            remotoActivo = false;
            updateSwitch();
        }).bounds(centerX + 10, btnY + gap * 3, 40, 20).build();

        addRenderableWidget(onBtn);
        addRenderableWidget(offBtn);

        // Inicializar color del switch
        updateSwitch();
    }


    private void updateSwitch() {
        // Colores básicos del texto según estado
        onBtn.setMessage(Component.literal(remotoActivo ? "ON ✅" : "ON"));
        offBtn.setMessage(Component.literal(!remotoActivo ? "OFF ❌" : "OFF"));
    }


    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        // Fondo oscuro vanilla
        renderBackground(graphics, mouseX, mouseY, partialTicks);

        // Fondo gris clarito del panel
        int panelW = (int) (width * 0.5);
        int panelH = (int) (height * 0.4);
        int x = (width - panelW) / 2;
        int y = (height - panelH) / 2;

        int bgColor = 0xAA000000; // negro translúcido
        graphics.fill(x, y, x + panelW, y + panelH, bgColor);

        // Render normal (widgets)
        super.render(graphics, mouseX, mouseY, partialTicks);
    }



//    @Override
//    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, PANEL);
//
//        int x = (width - 176) / 2;
//        int y = (height - 166) / 2;
//
//        graphics.blit(PANEL, x, y, 0, 0, 176, 166);
//    }



    @Override public boolean isPauseScreen() { return false; }

}
