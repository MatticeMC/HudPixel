// HypixelAPI (c) 2014
// Code based on https://github.com/HypixelDev/PublicAPI/commit/0180d6af7c7cb477978c24ba384452e93f30a7b4
// This is a temporary copyright header which will be replaced when a official header is added.

package net.hypixel.api.reply;

import com.google.gson.JsonObject;

@SuppressWarnings("unused")
public class PlayerReply extends AbstractReply {
    private JsonObject player;

    public JsonObject getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "PlayerReply{" +
                "player=" + player +
                ",super=" + super.toString() + "}";
    }
}
