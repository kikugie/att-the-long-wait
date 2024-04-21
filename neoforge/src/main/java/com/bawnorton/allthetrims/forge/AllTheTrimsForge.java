package com.bawnorton.allthetrims.forge;

import com.bawnorton.allthetrims.AllTheTrims;
import com.bawnorton.allthetrims.forge.client.AllTheTrimsForgeClient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(AllTheTrims.MOD_ID)
public class AllTheTrimsForge {
    public AllTheTrimsForge(IEventBus bus) {
        AllTheTrims.init();
        bus.addListener(AllTheTrimsForgeClient::init);
    }
}
