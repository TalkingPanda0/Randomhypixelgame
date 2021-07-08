package talkingpanda.randomhypixelgame;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.input.Keyboard;


@Mod(modid = RandomHypixelGame.MODID, version = RandomHypixelGame.VERSION ,clientSideOnly = true)
public class RandomHypixelGame
{
    public static final String MODID = "randomhypixelgame";
    public static final String VERSION = "1.0";
	public static KeyBinding start = new KeyBinding("key.randomhypixelgame.start", Keyboard.KEY_P, "key.randomhypixelgame.category");

		@EventHandler
    public void init(FMLInitializationEvent event)
    {
		ClientRegistry.registerKeyBinding(start);
		FMLCommonHandler.instance().bus().register(new KeyHandler());
    }

}
