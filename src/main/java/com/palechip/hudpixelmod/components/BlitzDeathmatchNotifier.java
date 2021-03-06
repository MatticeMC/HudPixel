package com.palechip.hudpixelmod.components;

import net.minecraft.util.EnumChatFormatting;

public class BlitzDeathmatchNotifier implements IComponent {
    private static final String DISPLAY_STRING = "DEATHMATCH STARTING SOON";
    private static final int ANIMATION_TIME = 5; // in MC-Ticks
    private static final int DISPLAY_TIME = 140; // = 7s

    private boolean isDisplaying;
    private int ticksLeft;
    private String renderingString;


    public BlitzDeathmatchNotifier() {
    }

    @Override
    public void setupNewGame() {
        this.ticksLeft = 0;
        this.isDisplaying = false;
    }

    @Override
    public void onGameStart() {
    }

    @Override
    public void onGameEnd() {
        this.ticksLeft = 0;
        this.isDisplaying = false;
    }

    @Override
    public void onTickUpdate() {
        if(this.isDisplaying) {
            // count down the ticks
            this.ticksLeft--;
            if(this.ticksLeft <= 0) {
                this.isDisplaying = false;
                this.ticksLeft = 0;
            }

            // update the color
            switch((this.ticksLeft / ANIMATION_TIME) % 4) {
            case 0:
                this.renderingString = EnumChatFormatting.LIGHT_PURPLE + DISPLAY_STRING;
                break;
            case 1:
                this.renderingString = EnumChatFormatting.YELLOW + DISPLAY_STRING;
                break;
            case 2:
                this.renderingString = EnumChatFormatting.GREEN + DISPLAY_STRING;
                break;
            case 3:
                this.renderingString = EnumChatFormatting.RED + DISPLAY_STRING;
                break;
            }

        }
    }

    @Override
    public void onChatMessage(String textMessage, String formattedMessage) {
        if(textMessage.contains("Deathmatch in 45 seconds!") || textMessage.contains("Deathmatch begins in 1 minute!")) {
            this.isDisplaying = true;
            this.ticksLeft = DISPLAY_TIME;
        }
    }

    @Override
    public String getRenderingString() {
        if(this.isDisplaying) {
            return this.renderingString;
        } else {
            return "";
        }
    }

}
