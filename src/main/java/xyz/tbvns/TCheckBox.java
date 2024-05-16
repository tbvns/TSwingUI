package xyz.tbvns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TCheckBox extends JLabel {
    JLabel tick = new JLabel("✓");
    JLabel text;
    boolean selected = false;
    Color backgroundColor;
    public TCheckBox(String text, Color backgroundColor, Color tickColor, Color labelColor) {
        this.backgroundColor = backgroundColor;

        tick.setBounds(3, 2, 12, 12);
        tick.setForeground(tickColor);
        add(tick);

        this.text = new JLabel(text);
        this.text.setBounds(18, -7, 100, 30);
        this.text.setForeground(labelColor);
        add(this.text);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = !selected;
                tick.setVisible(selected);
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
        g.setColor(backgroundColor);
        g.fillRoundRect(0, 0, 15, 15, 15, 15);
        super.paint(g);
    }
}
