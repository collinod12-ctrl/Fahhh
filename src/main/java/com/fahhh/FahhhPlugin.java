package com.fahhh;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.RuneLite;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.File;

@Slf4j
@PluginDescriptor(
	name = "Fahhh",
	description = "Died in osrs? FAHHH!"
)
public class FahhhPlugin extends Plugin
{
	@Inject
	private Client client;

    @Inject
	private FahhhConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Fahhh started!");
		File soundFile = new File(RuneLite.RUNELITE_DIR, "Fahhh.wav");
		AudioInputStream stream = AudioSystem.getAudioInputStream(soundFile);
        Clip deathSoundClip = AudioSystem.getClip();
		deathSoundClip.open(stream);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Fahhh stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Fahhh says " + config.greeting(), null);
		}
	}

	@Provides
	FahhhConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FahhhConfig.class);
	}
}
