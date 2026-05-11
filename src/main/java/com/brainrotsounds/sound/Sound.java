package com.brainrotsounds.sound;

import lombok.Getter;

import java.util.Random;

@Getter
public enum Sound {
    PLAYER_DEATH("Fahhh.wav"),
     ;

    private final String resourceName;

    Sound(String resNam) {
        this(resNam, false);
    }

    Sound(String resNam, boolean streamTroll) {
        resourceName = resNam;
    }

    private static final Random random = new Random();
}