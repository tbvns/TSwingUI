package xyz.tbvns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TCheckBox extends JLabel {
    TCheckBoxIcon icon;
    boolean selected = false;
    Color backgroundColor;
    public TCheckBox(String text, Color backgroundColor, Color tickColor, Color labelColor) {
        super(text);
        icon = new TCheckBoxIcon(backgroundColor, tickColor);
        this.backgroundColor = backgroundColor;
        setForeground(labelColor);
        setIcon(icon);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = !selected;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        icon.isActive = selected;
        super.paint(g);
    }
}
