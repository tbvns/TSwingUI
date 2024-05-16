package xyz.tbvns;

import javax.swing.*;
import java.awt.*;

public class TCheckBoxIcon implements Icon {
    Color background, text;
    boolean isActive = false;
    public TCheckBoxIcon(Color background, Color text) {
        this.background = background;
        this.text = text;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(background);
        g.fillRoundRect(0, 7, 15, 15, 15, 15);
        g.setColor(text);
        if (isActive) {
            g.drawString("✓", 3, 20);
        }
    }

    @Override
    public int getIconWidth() {
        return 15;
    }

    @Override
    public int getIconHeight() {
        return 15;
    }
}
