package fr.chaikarpc;

import fr.chaikarpc.ui.panels.ConfigPanel;
import fr.chaikarpc.ui.panels.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame {

    public static ChaikaPresence presence;

    public static Main main;
    public static MainPanel mainPanel;

    public ConfigPanel configPanel;

    public Main(){
        System.out.println("ROAD TO ADD CHAIKA'S EMOJI ON GITHUB !");

        presence = new ChaikaPresence();
        presence.init();

        setTitle("Chaika Discord RPC");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);

        setContentPane(mainPanel = new MainPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            setIconImage(ImageIO.read(Main.class.getResourceAsStream("/chaika.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Color backgroundColor = Color.decode("#24343C");
        getContentPane().setBackground(backgroundColor);

        setVisible(true);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setContentPane(configPanel = new ConfigPanel());
        getContentPane().setBackground(backgroundColor);

        repaint();
        revalidate();

    }

    public static void main(String[] args){
        main = new Main();

    }

}
