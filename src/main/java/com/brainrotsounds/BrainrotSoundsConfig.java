package com.brainrotsounds;

import com.brainrotsounds.sound.Sound;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(BrainrotSoundsConfig.GROUP)
public interface BrainrotSoundsConfig extends Config
{
	String GROUP = "brainrotsounds";

	@ConfigItem(
			keyName = "announceDeath",
			name = "When you die",
			description = "Should you hear the infamous 'FAHHH' tiktok sound when you die?",
			section = SECTION_GENERAL_ANNOUNCEMENT_SETTINGS,
			position = 1
	)
	default boolean announceDeath() {
		return true;
	}

	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "Hello";
	}

	@ConfigSection(
			name = "General Announcement Settings",
			description = "Settings for other details when various brainrot sounds play.",
			position = 1
	)

	String SECTION_GENERAL_ANNOUNCEMENT_SETTINGS = "General Announcement Settings";

	@ConfigItem(
			keyName = "announcementVolume",
			name = "Announcement volume",
			description = "Adjust how loud the audio announcements are played!",
			section = SECTION_GENERAL_ANNOUNCEMENT_SETTINGS,
			position = 2
	)
	default int announcementVolume() {
		return 100;
	}
}
