package xyz.tbvns;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world !");
        frame.setSize(500, 500);
        frame.setLayout(null);
        UIManager.put("Button.select", new Color(0, 0, 0, 0));

        TRoundedButton button = new TRoundedButton("test", new Color(40, 132, 254), new Color(63, 152, 241), new Color(123, 198, 255), 30);
        button.setTextColor(Color.WHITE);
        button.setEnableShadow(true);
        button.setPreferredSize(new Dimension(100, 30));

        TTextField field = new TTextField("Hello world", new Color(41, 41, 41), new Color(64, 145, 255), new Color(128, 207, 255), 10);
        field.setPreferredSize(new Dimension(100, 30));
        field.createRoundedBorder(2);
        field.setTextColor(Color.WHITE);

        TComboBox comboBox = new TComboBox(new String[]{"hello", "world"}, new Color(41, 41, 41), new Color(0, 186, 255), new Color(255, 255, 255), new Color(200, 200, 200), new Color(0, 235, 255), 10);
        comboBox.setPreferredSize(new Dimension(100, 30));
        comboBox.createRoundedBorder(2);

        JLabel checkBox = new TCheckBox("TCheckBox", new Color(41, 41, 41), Color.WHITE, Color.WHITE);
        checkBox.setPreferredSize(new Dimension(100, 30));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        panel.setBorder(new TTitleBorder("Test", new Color(0, 0, 0), new Color(40, 40, 40), Color.WHITE, 10));
        panel.add(comboBox);
        panel.add(checkBox);
        panel.add(button);
        panel.add(field);
        panel.setBounds(10, 10, 300, 300);

        frame.add(panel);

        frame.setVisible(true);
    }
}