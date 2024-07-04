package lol.praenyth.mods.noarmorchallenge.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerTabOverlay.class, priority = 1)
public class PlayerListMixin {

    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void preventVisiblePlayerList(GuiGraphics guiGraphics, int i, Scoreboard scoreboard, Objective objective, CallbackInfo ci) {

        guiGraphics.drawString(minecraft.font, "", 0,0,0);
        ci.cancel();

    }

}
