package oobians.mc;

import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretPassword implements ModInitializer {
	public static final String MOD_ID = "secret-password";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer server;
	public static final Map<ServerPlayer, LocalDateTime> PENDING_AUTHENTICATION = new LinkedHashMap<>();
	public static final int PASSWORD_ENTRY_TIME_LIMIT_SECONDS = 300; // 5 minutes

	@Override
	public void onInitialize() {

		LOGGER.info("secret-password loaded");
	}

	/**
	 * Boots unauthenticated players who don't enter their password within 60
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
			player.connection.disconnect(Component.literal("You took too long to enter your password!"));
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