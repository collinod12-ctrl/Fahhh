package com.brainrotsounds;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.OkHttpClient;

import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@PluginDescriptor(
	name = "brainrotsounds",
	description = "Creating modern comedic relief for Old School Runescape"
)
public class BrainrotSoundsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

    @Inject
	private BrainrotSoundsConfig config;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private OkHttpClient okHttpClient;

	@Inject
	private EventBus eventBus;


	@Override
	protected void startUp() throws Exception
	{
		log.debug("brainrotsounds started!");

	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("brainrotsounds stopped!");
	}

	@Provides
	BrainrotSoundsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BrainrotSoundsConfig.class);
	}
}
