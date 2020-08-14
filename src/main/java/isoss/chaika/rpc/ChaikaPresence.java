package isoss.chaika.rpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class ChaikaPresence {

    private DiscordRichPresence chaikaPresence;

    public void init() {
        DiscordRPC rpc = DiscordRPC.INSTANCE;

        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Chaika > all");

        rpc.Discord_Initialize(ConfigWrapper.get("applicationId"), handlers, true, "");

        this.chaikaPresence = new DiscordRichPresence();
        this.chaikaPresence.startTimestamp = System.currentTimeMillis() / 1000;
        this.chaikaPresence.largeImageKey = ConfigWrapper.get("largeImageKey");
        this.chaikaPresence.largeImageText = ConfigWrapper.get("largeImageText");
        this.chaikaPresence.smallImageKey = ConfigWrapper.get("smallImageKey");
        this.chaikaPresence.smallImageText = ConfigWrapper.get("smallImageText");
        this.chaikaPresence.details = ConfigWrapper.get("details");

        rpc.Discord_UpdatePresence(chaikaPresence);

        new Thread(() -> {

            while(!Thread.currentThread().isInterrupted()) {
                rpc.Discord_RunCallbacks();
                try { Thread.sleep(2000); } catch(InterruptedException e) {}

            }

        }, "ChaikaRPC-Callback-Handler").start();

    }

    public DiscordRichPresence getPresence() {
        return chaikaPresence;

    }

}
