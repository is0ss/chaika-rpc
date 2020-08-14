package isoss.chaika.rpc;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigWrapper {

    private static JsonObject config;

    static {
        config = new JsonObject();

        setDefault("applicationId", Constants.APPLICATION_ID);
        setDefault("largeImageKey", Constants.LARGE_IMAGE_KEY);
        setDefault("largeImageText", Constants.LARGE_IMAGE_TEXT);
        setDefault("smallImageKey", Constants.SMALL_IMAGE_KEY);
        setDefault("smallImageText", Constants.SMALL_IMAGE_TEXT);
        setDefault("details", Constants.DETAILS);

    }

    public static void load(Path file) {

        try(BufferedReader br = Files.newBufferedReader(file)) {
            StringBuilder sb = new StringBuilder();
            int character;

            while((character = br.read()) != -1) sb.append((char) character);

            config = JsonParser.parseString(sb.toString()).getAsJsonObject();

        } catch(IOException e) {
            e.printStackTrace();

        }

    }

    public static void write(Path configFile) {

        try(BufferedWriter bw = Files.newBufferedWriter(configFile)) {
            bw.write(config.toString());

        } catch(IOException e) {
            e.printStackTrace();

        }

    }

    public static String get(String property) {
        return config.get(property).getAsString();

    }

    public static void set(String property, String value) {
        config.addProperty(property, value);

    }

    public static void setDefault(String property, String value) {
        if(config.get(property) == null) config.addProperty(property, value);

    }

}