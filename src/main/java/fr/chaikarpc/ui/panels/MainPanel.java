package fr.chaikarpc.ui.panels;

import fr.chaikarpc.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(){
        setLayout(new GridBagLayout());

        //Add Title
        JLabel textLabel = new JLabel("Bienvenue sur Chaika Discord RPC !");
        textLabel.setFont(new Font("Verdana", 0, 50));
        textLabel.setForeground(Utils.colorForeground);
        textLabel.setBackground(Utils.colorBackground);
        textLabel.setSize(550, 150);
        add(textLabel);

    }

}
