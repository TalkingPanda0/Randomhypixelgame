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
			String game = RandomHypixelGame.gamesl[rand.nextInt(RandomHypixelGame.gamesl.length)];
			RandomHypixelGame.lastgame = game;
			String cmd = "/play " + game;
			Minecraft.getMinecraft().thePlayer.sendChatMessage(cmd);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aSent " + cmd));
		}
		if (RandomHypixelGame.del.isPressed())
        {
			Games.deleteGames(RandomHypixelGame.lastgame);
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aDeleted " + RandomHypixelGame.lastgame));
		}
		if (RandomHypixelGame.reload.isPressed())
        {
			Games.readGames();
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aReloaded games"));
		}


    }
}
