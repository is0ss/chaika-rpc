package isoss.chaika.rpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class ChaikaPresence {

    private DiscordRichPresence chaikaPresence;
    private long startTimestamp;

    public ChaikaPresence() {
        this.chaikaPresence = new DiscordRichPresence();

    }

    public void init() {
        DiscordRPC rpc = DiscordRPC.INSTANCE;

        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Chaika > all");

        rpc.Discord_Initialize(ConfigWrapper.get("applicationId"), handlers, true, "");

        this.startTimestamp = System.currentTimeMillis() / 1000;
        this.updatePresence();

        Thread callbackHandler = new Thread(() -> {

            while(true) {
                rpc.Discord_RunCallbacks();
                try { Thread.sleep(2000); } catch(InterruptedException e) {}

            }

        }, "ChaikaRPC-Callback-Handler");

        callbackHandler.setDaemon(true);
        callbackHandler.start();

    }

    public void updatePresence() {
        DiscordRPC rpc = DiscordRPC.INSTANCE;

        this.chaikaPresence.startTimestamp = startTimestamp;
        this.chaikaPresence.largeImageKey = ConfigWrapper.get("largeImageKey");
        this.chaikaPresence.largeImageText = ConfigWrapper.get("largeImageText");
        this.chaikaPresence.smallImageKey = ConfigWrapper.get("smallImageKey");
        this.chaikaPresence.smallImageText = ConfigWrapper.get("smallImageText");
        this.chaikaPresence.details = ConfigWrapper.get("details");

        rpc.Discord_UpdatePresence(chaikaPresence);

    }

    public DiscordRichPresence getPresence() {
        return chaikaPresence;

    }

}
