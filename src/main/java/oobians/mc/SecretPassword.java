package oobians.mc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class SecretPassword implements ModInitializer {
	public static final String MOD_ID = "secret-password";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer server;
	public static final Map<ServerPlayer, LocalDateTime> PENDING_AUTHENTICATION = new LinkedHashMap<>();
	public static final int PASSWORD_ENTRY_TIME_LIMIT_SECONDS = 300; // 5 minutes
	public static final Path PASSWORD_FILE = Path.of("password.hash");
	public static String hashedPassword = null;

	/**
	 * Loads the hashed password for verification
	 */
	@Override
	public void onInitialize() {
		try {
			hashedPassword = Files.readString(PASSWORD_FILE).trim();
		} catch (Exception e) {
			LOGGER.error("Error while creating password.hash file:", e);
			throw new RuntimeException("Failed to read password.hash file", e);
		}
		LOGGER.info("Server's secret password loaded");

		LOGGER.info("SecretPassword initialized successfully.");
	}

	public static void onPlayerLogIn(ServerPlayer player) {
		PENDING_AUTHENTICATION.put(player, LocalDateTime.now());
		player.sendSystemMessage(Component
				.literal("Welcome! Please enter the server password using /password <server_password> to play!"));
	}

	public static void onPlayerLogOut(ServerPlayer player) {
		PENDING_AUTHENTICATION.remove(player);
	}

	public static void onPlayerAuthenticated(ServerPlayer player) {
		PENDING_AUTHENTICATION.remove(player);
		LOGGER.info("Player " + player.getName().getString() + " has authenticated successfully.");
		player.sendSystemMessage(Component.literal("Login Successful"));
	}

	public static void cancelAction(ServerPlayer player, CallbackInfo ci) {
		if (!PENDING_AUTHENTICATION.containsKey(player)) {
			return;
		}
		player.sendSystemMessage(Component.literal("You must enter the password before playing!"));
		ci.cancel();
	}

	/**
	 * Boots unauthenticated players who don't enter their password within 300
	 * seconds.
	 */
	public static void tick() {
		Set<ServerPlayer> playersToRemove = new HashSet<>();
		for (Entry<ServerPlayer, LocalDateTime> entry : PENDING_AUTHENTICATION.entrySet()) {
			ServerPlayer player = entry.getKey();
			LocalDateTime deadline = entry.getValue().plusSeconds(PASSWORD_ENTRY_TIME_LIMIT_SECONDS);
			if (!LocalDateTime.now().isAfter(deadline)) {
				break;
			}
			LOGGER.info(
					"Kicking player " + player.getName().getString() + " for failing to enter password in time.");
			player.connection.disconnect(Component.literal("You took too long to enter the password!"));
			playersToRemove.add(player);
		}
		for (ServerPlayer player : playersToRemove) {
			PENDING_AUTHENTICATION.remove(player);
		}
	}

	public static void onServerLoaded(MinecraftServer minecraftServer) {
		server = minecraftServer;
	}
}