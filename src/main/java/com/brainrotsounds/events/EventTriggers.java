package com.brainrotsounds.events;

import com.brainrotsounds.BrainrotSoundsConfig;
import com.brainrotsounds.player.LoggedInState;
import com.brainrotsounds.sound.Sound;
import com.brainrotsounds.sound.SoundEngine;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.ChatMessageType;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ActorDeath;
import net.runelite.client.eventbus.Subscribe;
import javax.inject.Inject;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

@Slf4j
public class EventTriggers {
    private static final String ACTOR_DEATH_MESSAGE = "FAHHHHH";

    @Inject
        private Client client;

    @Inject
        private BrainrotSoundsConfig config;

    @Inject
        private SoundEngine soundEngine;

    @Inject
    private ScheduledExecutorService executor;

    @Inject
        private LoggedInState loggedInState;

    @Subscribe
    public void onPlayerDeath(ActorDeath event)
    {
        if (event.getActor() != client.getLocalPlayer())
            return;

        if (config.announceDeath()){
            playerDeath();
        }
    }
    private void playerDeath() {
        soundEngine.playClip(Sound.PLAYER_DEATH, executor);
    }
}