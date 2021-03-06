package com.palechip.hudpixelmod.games;

import net.hypixel.api.util.GameType;

import com.palechip.hudpixelmod.HudPixelConfig;
import com.palechip.hudpixelmod.components.CoinCounterComponent;
import com.palechip.hudpixelmod.components.KillstreakTracker;
import com.palechip.hudpixelmod.components.TimerComponent;

public class Quakecraft extends Game {

    protected Quakecraft() {
        super("Quake", "Quakecraft", START_MESSAGE_DEFAULT, END_MESSAGE_DEFAULT, GameType.QUAKECRAFT, HudPixelConfig.QUAKE_CATEGORY);
        if(HudPixelConfig.quakeTimeDisplay) {
            this.components.add(new TimerComponent());
        }
        if(HudPixelConfig.quakeCoinDisplay) {
            this.components.add(new CoinCounterComponent());
        }
        if(HudPixelConfig.quakeKillstreakTracker) {
            this.components.add(new KillstreakTracker());
        }
    }
}
