package talkingpanda.randomhypixelgame;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import java.util.Random;

public class KeyHandler {
	@SubscribeEvent
    public void onKeyPress(KeyInputEvent event)
    {
        if (RandomHypixelGame.start.isPressed())
        {
			Random rand = new Random();
			String cmd = "/play " +  RandomHypixelGame.gamesl[rand.nextInt(RandomHypixelGame.gamesl.length)];
			Minecraft.getMinecraft().thePlayer.sendChatMessage(cmd);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Sent " + cmd));
		}
    }
}
