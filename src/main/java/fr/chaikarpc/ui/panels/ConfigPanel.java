package fr.chaikarpc.ui.panels;

import fr.chaikarpc.Main;
import fr.chaikarpc.utils.Utils;
import fr.chaikarpc.utils.ConfigWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

public class ConfigPanel extends JPanel {

    private static final JTextField applicationIDField = new JTextField();
    private static final JLabel applicationIDLabel = new JLabel("Application ID :");

    private static final JTextField applicationDetailsField = new JTextField();
    private static final JLabel applicationDetailsLabel = new JLabel("Détails :");

    private static final JTextField applicationLargeImageKeyField = new JTextField();
    private static final JLabel applicationLargeImageKeyLabel = new JLabel("Large Image Key :");

    private static final JTextField applicationLargeImageTextField = new JTextField();
    private static final JLabel applicationLargeImageTextLabel = new JLabel("Large Image Text :");

    private static final JTextField applicationSmallImageKeyField = new JTextField();
    private static final JLabel applicationSmallImageKeyLabel = new JLabel("Small Image Key :");

    private static final JTextField applicationSmallImageTextField = new JTextField();
    private static final JLabel applicationSmallImageTextLabel = new JLabel("Small Image Text :");

    private static final JButton enterButton = new JButton("Save");

    public ConfigPanel(){
        setLayout(null);

        String applicationId = ConfigWrapper.get("applicationId");
        String details = ConfigWrapper.get("details");
        String largeImageKey = ConfigWrapper.get("largeImageKey");
        String largeImageText = ConfigWrapper.get("largeImageText");
        String smallImageKey = ConfigWrapper.get("smallImageKey");
        String smallImageText = ConfigWrapper.get("smallImageText");

        Utils.createFieldAndLabel(applicationIDField, applicationId, 100, applicationIDLabel, 65);
        Utils.createFieldAndLabel(applicationDetailsField, details, 180, applicationDetailsLabel, 145);
        Utils.createFieldAndLabel(applicationLargeImageKeyField, largeImageKey, 260, applicationLargeImageKeyLabel, 225);
        Utils.createFieldAndLabel(applicationLargeImageTextField, largeImageText, 340, applicationLargeImageTextLabel, 305);
        Utils.createFieldAndLabel(applicationSmallImageKeyField, smallImageKey, 420, applicationSmallImageKeyLabel, 385);
        Utils.createFieldAndLabel(applicationSmallImageTextField, smallImageText, 500, applicationSmallImageTextLabel, 465);

        applicationIDField.setText(applicationId);
        applicationDetailsField.setText(details);
        applicationLargeImageKeyField.setText(largeImageKey);
        applicationLargeImageTextField.setText(largeImageText);
        applicationSmallImageKeyField.setText(smallImageKey);
        applicationSmallImageTextField.setText(smallImageText);

        enterButton.setBounds(1280 / 2 - 275 /2, 600, 275, 40);
        enterButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        enterButton.setForeground(Utils.colorForeground);
        enterButton.setBackground(Utils.colorBackground);

        ActionListener actionListener = event -> {
            ConfigWrapper.set("applicationId", applicationIDField.getText());
            ConfigWrapper.set("details", applicationDetailsField.getText());
            ConfigWrapper.set("largeImageKey", applicationLargeImageKeyField.getText());
            ConfigWrapper.set("largeImageText", applicationLargeImageTextField.getText());
            ConfigWrapper.set("smallImageKey", applicationSmallImageKeyField.getText());
            ConfigWrapper.set("smallImageText", applicationSmallImageTextField.getText());

            Main.presence.updatePresence();

            ConfigWrapper.write(Paths.get("config.json"));

            System.out.println("Config saved !");
        };

        enterButton.addActionListener(actionListener);

        add(applicationIDField);
        add(applicationIDLabel);
        add(applicationDetailsField);
        add(applicationDetailsLabel);
        add(applicationLargeImageKeyField);
        add(applicationLargeImageKeyLabel);
        add(applicationLargeImageKeyField);
        add(applicationLargeImageTextField);
        add(applicationLargeImageTextLabel);
        add(applicationSmallImageKeyField);
        add(applicationSmallImageKeyField);
        add(applicationSmallImageKeyLabel);
        add(applicationSmallImageTextField);
        add(applicationSmallImageTextLabel);
        add(enterButton);

    }

}
