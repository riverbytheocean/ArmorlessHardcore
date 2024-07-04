package lol.praenyth.mods.noarmorchallenge.mixin.client;

import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = Minecraft.class, priority = 1)
public class PerspectiveMixin {

    @Redirect(
            method = "handleKeybinds",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Options;setCameraType(Lnet/minecraft/client/CameraType;)V"
            )
    )
    private void preventPerspectiveChange(Options instance, CameraType cameraType) {
        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
    }

}
