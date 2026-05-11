package com.brainrotsounds;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class BrainrotSoundsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(BrainrotSoundsPlugin.class);
		RuneLite.main(args);
	}
}