package oobians.mc.mixin;

import net.minecraft.server.MinecraftServer;
import oobians.mc.SecretPassword;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class ServerMixin {

	/**
	 * Mix this code into the MinecraftServer tick method.
	 * https://github.com/Jasonzyt/password-fabric/blob/main/src/main/java/com/jasonzyt/passwordfabric/mixin/MinecraftServerMixin.java
	 * 
	 * @param booleanSupplier_1
	 * @param ci
	 */
	@Inject(method = "tickServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;tickChildren(Ljava/util/function/BooleanSupplier;)V", shift = At.Shift.BEFORE, ordinal = 0))
	private void onTick(BooleanSupplier booleanSupplier_1, CallbackInfo ci) {
		SecretPassword.tick();
	}

	/**
	 * Provide the MinecraftServer instance to SecretPassword when the server is
	 * loaded.
	 * 
	 * @param info
	 */
	@Inject(at = @At("HEAD"), method = "loadLevel")
	private void init(CallbackInfo info) {
		SecretPassword.onServerLoaded((MinecraftServer) (Object) this);
	}
}