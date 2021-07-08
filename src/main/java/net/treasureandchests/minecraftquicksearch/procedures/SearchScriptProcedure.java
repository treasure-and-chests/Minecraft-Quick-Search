package net.treasureandchests.minecraftquicksearch.procedures;

import net.treasureandchests.minecraftquicksearch.MinecraftquicksearchModElements;
import net.treasureandchests.minecraftquicksearch.MinecraftquicksearchMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.HashMap;

@MinecraftquicksearchModElements.ModElement.Tag
public class SearchScriptProcedure extends MinecraftquicksearchModElements.ModElement {
	public SearchScriptProcedure(MinecraftquicksearchModElements instance) {
		super(instance, 1);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftquicksearchMod.LOGGER.warn("Failed to load dependency x for procedure SearchScript!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftquicksearchMod.LOGGER.warn("Failed to load dependency y for procedure SearchScript!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftquicksearchMod.LOGGER.warn("Failed to load dependency z for procedure SearchScript!");
			return;
		}
		if (dependencies.get("text") == null) {
			if (!dependencies.containsKey("text"))
				MinecraftquicksearchMod.LOGGER.warn("Failed to load dependency text for procedure SearchScript!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftquicksearchMod.LOGGER.warn("Failed to load dependency world for procedure SearchScript!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String text = (String) dependencies.get("text");
		IWorld world = (IWorld) dependencies.get("world");
		double position = 0;
		double StringLength = 0;
		String NewSearch = "";
		String OutputString = "";
		if (((((text).substring((int) 0, (int) 8))).equals("!search "))) {
			StringLength = (double) ((text)).length();
			NewSearch = (String) ((text).substring((int) 8, (int) (StringLength)));
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
			StringLength = (double) ((NewSearch)).length();
			position = (double) 0;
			for (int index0 = 0; index0 < (int) (((NewSearch)).length()); index0++) {
				if (((((NewSearch).substring((int) (position), (int) ((position) + 1)))).equals(" "))) {
					OutputString = (String) (((OutputString)) + "" + ("+"));
				} else {
					OutputString = (String) (((OutputString)) + "" + (((NewSearch).substring((int) (position), (int) ((position) + 1)))));
				}
				position = (double) ((position) + 1);
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("tellraw @p [{\"text\":\"YouTube \",\"color\":\"red\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Search YouTube\",\"color\":\"red\",\"bold\":true}]},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.youtube.com/results?search_query=")
								+ "" + ((OutputString)) + ""
								+ ("\"}},{\"text\":\"Google \",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Search Google\",\"color\":\"blue\",\"bold\":true}]},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.google.com/search?q=")
								+ "" + ((OutputString)) + ""
								+ ("\"}},{\"text\":\"MC Wiki \",\"color\":\"green\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Search Minecraft Wiki\",\"color\":\"green\",\"bold\":true}]},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://minecraft.fandom.com/wiki/Special:Search?query=")
								+ "" + ((OutputString)) + ""
								+ ("\"}},{\"text\":\"Planet MC \",\"color\":\"yellow\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Search Planet Minecraft\",\"color\":\"yellow\",\"bold\":true}]},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.planetminecraft.com/resources/?keywords=")
								+ "" + ((OutputString)) + ""
								+ ("\"}},{\"text\":\"MC Forums\",\"color\":\"light_purple\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Search Minecraft Forums\",\"color\":\"light_purple\",\"bold\":true}]},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.minecraftforum.net/search?search=")
								+ "" + ((OutputString)) + "" + ("\"}}]")));
			}
		} else {
			MinecraftquicksearchMod.LOGGER.error("search.engine.substring.error.1");
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void onChat(ServerChatEvent event) {
		ServerPlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("text", event.getMessage());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
