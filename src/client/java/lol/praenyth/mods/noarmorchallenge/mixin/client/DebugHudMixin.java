package lol.praenyth.mods.noarmorchallenge.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(value = DebugScreenOverlay.class, priority = 1)
public abstract class DebugHudMixin {

    @Shadow protected abstract void renderLines(GuiGraphics guiGraphics, List<String> list, boolean bl);

    @Shadow private boolean renderProfilerChart;

    @Inject(
            method = "drawGameInformation",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)
    private void modifyDebugGameText(GuiGraphics guiGraphics, CallbackInfo ci) {

        List<String> list = new ArrayList<>();
        list.add("Play the game legitimately, nerd.");

        renderLines(guiGraphics, list, true);

        ci.cancel();

    }

    @Inject(
            method = "drawSystemInformation",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)
    private void modifyDebugSystemText(GuiGraphics guiGraphics, CallbackInfo ci) {

        List<String> list = new ArrayList<>();
        list.add("");

        renderLines(guiGraphics, list, true);

        ci.cancel();

    }

    @Inject(
            method = "toggleProfilerChart",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void preventProfilerChart(CallbackInfo ci) {
        renderProfilerChart = false;
        ci.cancel();
    }

}
