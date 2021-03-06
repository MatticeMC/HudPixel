package com.palechip.hudpixelmod.components;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraft.util.EnumChatFormatting;

public class WallsKillCounter implements IComponent {
    
    private static final String KILL_DISPLAY = EnumChatFormatting.AQUA + "Kills: " + EnumChatFormatting.RED;
    private static final String ASSISTS_DISPLAY = EnumChatFormatting.AQUA +  "" + EnumChatFormatting.ITALIC +"Assists: " + EnumChatFormatting.DARK_GRAY;
    public static enum KillType {Normal, Assists};
    
    private KillType trackedType;
    private int kills;

    public WallsKillCounter(KillType trackedType) {
        this.trackedType = trackedType;
    }

    @Override
    public void setupNewGame() {
        this.kills = 0;
    }

    @Override
    public void onGameStart() {
    }

    @Override
    public void onGameEnd() {
    }

    @Override
    public void onTickUpdate() {
    }

    @Override
    public void onChatMessage(String textMessage, String formattedMessage) {
        switch (this.trackedType) {
        case Normal:
            // I hope killed by includes all possible deaths
            // known common messages:
            // was killed by
            // was shot and killed by
            if(textMessage.contains("killed by " + FMLClientHandler.instance().getClient().getSession().getUsername())) {
                this.kills++;
            }
            break;
        case Assists:
            // Assists are displayed using the coin message
            if(textMessage.contains("ASSIST") && textMessage.startsWith("+") && textMessage.toLowerCase().contains("coins") && !textMessage.toLowerCase().contains("for being generous :)")) {
                this.kills++;
            }
            break;
        }
    }

    @Override
    public String getRenderingString() {
        switch (trackedType) {
        case Normal:
            return KILL_DISPLAY + this.kills;
        case Assists:
            return ASSISTS_DISPLAY + this.kills;
        }
        return "";
    }

}
