package lol.praenyth.mods.noarmorchallenge.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.world.entity.player.ChatVisiblity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChatComponent.class, priority = 1)
public class ChatComponentMixin {

    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void preventChatOpening(GuiGraphics guiGraphics, int i, int j, int k, CallbackInfo ci) {
        if (!minecraft.options.chatVisibility().get().equals(ChatVisiblity.HIDDEN)) {
            minecraft.options.chatVisibility().set(ChatVisiblity.HIDDEN);
            ci.cancel();
        }
    }

}
