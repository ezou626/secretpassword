package oobians.mc.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import oobians.mc.SecretPassword;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Cancel various player actions if they haven't authenticated yet.
 */
@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @Shadow
    public ServerPlayer player;

    @Inject(method = "onDisconnect", at = @At("HEAD"))
    private void onPlayerDisconnect(Component reason, CallbackInfo ci) {
        SecretPassword.onPlayerLogOut(player);
    }

    // --- AUTO-GENERATED: Cancel all serverbound actions except password relevant
    // ones ---
    @Inject(method = "handleAnimate", at = @At("HEAD"), cancellable = true)
    private void onAnimate(ServerboundSwingPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChatAck", at = @At("HEAD"), cancellable = true)
    private void onChatAck(ServerboundChatAckPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleClientCommand", at = @At("HEAD"), cancellable = true)
    private void onClientCommand(ServerboundClientCommandPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleContainerButtonClick", at = @At("HEAD"), cancellable = true)
    private void onContainerButtonClick(ServerboundContainerButtonClickPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePlaceRecipe", at = @At("HEAD"), cancellable = true)
    private void onPlaceRecipe(ServerboundPlaceRecipePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleContainerClose", at = @At("HEAD"), cancellable = true)
    private void onContainerClose(ServerboundContainerClosePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePlayerAbilities", at = @At("HEAD"), cancellable = true)
    private void onPlayerAbilities(ServerboundPlayerAbilitiesPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePlayerAction", at = @At("HEAD"), cancellable = true)
    private void onPlayerAction(ServerboundPlayerActionPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePlayerCommand", at = @At("HEAD"), cancellable = true)
    private void onPlayerCommand(ServerboundPlayerCommandPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePlayerInput", at = @At("HEAD"), cancellable = true)
    private void onPlayerInput(ServerboundPlayerInputPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSignUpdate", at = @At("HEAD"), cancellable = true)
    private void onSignUpdate(ServerboundSignUpdatePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleTeleportToEntityPacket", at = @At("HEAD"), cancellable = true)
    private void onTeleportToEntity(ServerboundTeleportToEntityPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePaddleBoat", at = @At("HEAD"), cancellable = true)
    private void onPaddleBoat(ServerboundPaddleBoatPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleMoveVehicle", at = @At("HEAD"), cancellable = true)
    private void onMoveVehicle(ServerboundMoveVehiclePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleAcceptTeleportPacket", at = @At("HEAD"), cancellable = true)
    private void onAcceptTeleport(ServerboundAcceptTeleportationPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleAcceptPlayerLoad", at = @At("HEAD"), cancellable = true)
    private void onAcceptPlayerLoad(ServerboundPlayerLoadedPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleRecipeBookSeenRecipePacket", at = @At("HEAD"), cancellable = true)
    private void onRecipeBookSeenRecipe(ServerboundRecipeBookSeenRecipePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleBundleItemSelectedPacket", at = @At("HEAD"), cancellable = true)
    private void onBundleItemSelected(ServerboundSelectBundleItemPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleRecipeBookChangeSettingsPacket", at = @At("HEAD"), cancellable = true)
    private void onRecipeBookChangeSettings(ServerboundRecipeBookChangeSettingsPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSeenAdvancements", at = @At("HEAD"), cancellable = true)
    private void onSeenAdvancements(ServerboundSeenAdvancementsPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleCustomCommandSuggestions", at = @At("HEAD"), cancellable = true)
    private void onCustomCommandSuggestions(ServerboundCommandSuggestionPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetCommandBlock", at = @At("HEAD"), cancellable = true)
    private void onSetCommandBlock(ServerboundSetCommandBlockPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetCommandMinecart", at = @At("HEAD"), cancellable = true)
    private void onSetCommandMinecart(ServerboundSetCommandMinecartPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePickItemFromBlock", at = @At("HEAD"), cancellable = true)
    private void onPickItemFromBlock(ServerboundPickItemFromBlockPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handlePickItemFromEntity", at = @At("HEAD"), cancellable = true)
    private void onPickItemFromEntity(ServerboundPickItemFromEntityPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleRenameItem", at = @At("HEAD"), cancellable = true)
    private void onRenameItem(ServerboundRenameItemPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetBeaconPacket", at = @At("HEAD"), cancellable = true)
    private void onSetBeacon(ServerboundSetBeaconPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetStructureBlock", at = @At("HEAD"), cancellable = true)
    private void onSetStructureBlock(ServerboundSetStructureBlockPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetTestBlock", at = @At("HEAD"), cancellable = true)
    private void onSetTestBlock(ServerboundSetTestBlockPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleTestInstanceBlockAction", at = @At("HEAD"), cancellable = true)
    private void onTestInstanceBlockAction(ServerboundTestInstanceBlockActionPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSelectTrade", at = @At("HEAD"), cancellable = true)
    private void onSelectTrade(ServerboundSelectTradePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleEditBook", at = @At("HEAD"), cancellable = true)
    private void onEditBook(ServerboundEditBookPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleEntityTagQuery", at = @At("HEAD"), cancellable = true)
    private void onEntityTagQuery(ServerboundEntityTagQueryPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleContainerSlotStateChanged", at = @At("HEAD"), cancellable = true)
    private void onContainerSlotStateChanged(ServerboundContainerSlotStateChangedPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleBlockEntityTagQuery", at = @At("HEAD"), cancellable = true)
    private void onBlockEntityTagQuery(ServerboundBlockEntityTagQueryPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetJigsawBlock", at = @At("HEAD"), cancellable = true)
    private void onSetJigsawBlock(ServerboundSetJigsawBlockPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleJigsawGenerate", at = @At("HEAD"), cancellable = true)
    private void onJigsawGenerate(ServerboundJigsawGeneratePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChangeDifficulty", at = @At("HEAD"), cancellable = true)
    private void onChangeDifficulty(ServerboundChangeDifficultyPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChangeGameMode", at = @At("HEAD"), cancellable = true)
    private void onChangeGameMode(ServerboundChangeGameModePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleLockDifficulty", at = @At("HEAD"), cancellable = true)
    private void onLockDifficulty(ServerboundLockDifficultyPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChatSessionUpdate", at = @At("HEAD"), cancellable = true)
    private void onChatSessionUpdate(ServerboundChatSessionUpdatePacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleConfigurationAcknowledged", at = @At("HEAD"), cancellable = true)
    private void onConfigurationAcknowledged(ServerboundConfigurationAcknowledgedPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChunkBatchReceived", at = @At("HEAD"), cancellable = true)
    private void onChunkBatchReceived(ServerboundChunkBatchReceivedPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleDebugSubscriptionRequest", at = @At("HEAD"), cancellable = true)
    private void onDebugSubscriptionRequest(ServerboundDebugSubscriptionRequestPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleClientTickEnd", at = @At("HEAD"), cancellable = true)
    private void onClientTickEnd(ServerboundClientTickEndPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChat(Lnet/minecraft/network/protocol/game/ServerboundChatPacket;)V", at = @At(value = "HEAD"), cancellable = true)
    private void onChatMessage(ServerboundChatPacket serverboundChatPacket, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetCarriedItem", at = @At("HEAD"), cancellable = true)
    private void onSelectSlot(ServerboundSetCarriedItemPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleUseItem", at = @At("HEAD"), cancellable = true)
    private void onUseItem(ServerboundUseItemPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleUseItemOn", at = @At("HEAD"), cancellable = true)
    private void onUseItemOn(ServerboundUseItemOnPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleContainerClick", at = @At("HEAD"), cancellable = true)
    private void onContainerClick(ServerboundContainerClickPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleSetCreativeModeSlot", at = @At("HEAD"), cancellable = true)
    private void onSetCreativeModeSlot(ServerboundSetCreativeModeSlotPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleInteract", at = @At("HEAD"), cancellable = true)
    private void onInteract(ServerboundInteractPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleMovePlayer", at = @At("HEAD"), cancellable = true)
    private void onMovePlayer(ServerboundMovePlayerPacket packet, CallbackInfo ci) {
        SecretPassword.cancelAction(player, ci);
    }

    @Inject(method = "handleChatCommand(Lnet/minecraft/network/protocol/game/ServerboundChatCommandPacket;)V", at = @At("HEAD"), cancellable = true)
    private void onChatCommand(ServerboundChatCommandPacket packet, CallbackInfo ci) {
        if (packet.command().startsWith("password ")) {
            return;
        }
        SecretPassword.cancelAction(player, ci);
    }
}