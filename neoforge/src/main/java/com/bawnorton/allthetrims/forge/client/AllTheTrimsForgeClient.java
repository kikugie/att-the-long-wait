package com.bawnorton.allthetrims.forge.client;

import com.bawnorton.allthetrims.AllTheTrims;
import com.bawnorton.allthetrims.client.AllTheTrimsClient;
import com.bawnorton.allthetrims.client.implementation.YACLImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod.EventBusSubscriber(modid = AllTheTrims.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AllTheTrimsForgeClient {
    public static void init(FMLClientSetupEvent event) {
        AllTheTrimsClient.init();
        ModLoadingContext.get()
                         .registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, screen) -> YACLImpl.getScreen(screen)));
    }
}
