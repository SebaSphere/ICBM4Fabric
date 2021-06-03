package dev.sebastianb.icbm4fabric.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.sebastianb.icbm4fabric.Constants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class LaunchScreen extends HandledScreen<LaunchScreenHandler> {


    private static final Identifier TEXTURE = new Identifier(Constants.MOD_ID, "textures/gui/frog.png"); // placeholder


    public LaunchScreen(LaunchScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.addButton();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        super.render(matrices,mouseX,mouseY,delta);

    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        this.renderBackground(matrices);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    // doesn't seem to be displaying
    // TODO: I forgot what this does but update to 1.17? OH it's the button on it?
    private void addButton() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, 196, 200, 20, ScreenTexts.YES, (buttonWidget) -> {
            this.client.openScreen(null);
        }));
    }

    @Override
    public Text getTitle() {
        return LiteralText.EMPTY;
    }
}