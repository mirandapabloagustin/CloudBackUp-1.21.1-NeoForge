package net.papasconcheddar.cloudbackupmod.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.papasconcheddar.cloudbackupmod.CloudBackupMod;
import net.papasconcheddar.cloudbackupmod.util.KeyBinding;

public class ModClientEvents {
    @EventBusSubscriber(
            modid = CloudBackupMod.MODID, //mod id
            value = Dist.CLIENT //servidor cliente
    )

    //Escucha si el cliente preciona y manda un mensaje
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.BACKUP_MENU_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a Key!"));
            }
        }

    }

    @EventBusSubscriber(
            modid = CloudBackupMod.MODID,
            value = Dist.CLIENT,
            bus = EventBusSubscriber.Bus.MOD
    )
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.BACKUP_MENU_KEY);
        }
    }

}