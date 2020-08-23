package asthowen.chaika.ui.utils;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static Color colorBackground = Color.decode("#24343C");
    public static Color colorForeground = Color.decode("#99AAB5");

    public static void  createFieldAndLabel(JTextField textField, String text, int y, JLabel textLabel, int y2){
        //Create TextField
        textField.setBounds(1280 / 2 - 550 /2, y, 550, 40);
        textField.setFont(new Font("Verdana", 0, 30));
        textField.setForeground(colorForeground);
        textField.setBackground(colorBackground);
        textField.setText(text);

        //Create JLabel
        textLabel.setBounds(1280 / 2 - 550 /2, y2, 550, 40);
        textLabel.setFont(new Font("Verdana", 0, 20));
        textLabel.setForeground(colorForeground);
        textLabel.setBackground(colorBackground);

    }

}
