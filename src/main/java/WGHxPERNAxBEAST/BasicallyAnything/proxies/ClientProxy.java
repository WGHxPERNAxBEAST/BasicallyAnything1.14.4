package WGHxPERNAxBEAST.BasicallyAnything.proxies;

import WGHxPERNAxBEAST.BasicallyAnything.lists.BlockList;
import WGHxPERNAxBEAST.BasicallyAnything.tile_entities.GeneratorBlockScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ScreenManager.registerFactory(BlockList.GENERATORBLOCK_CONTAINER, GeneratorBlockScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}