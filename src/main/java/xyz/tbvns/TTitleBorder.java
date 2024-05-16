package xyz.tbvns;

import javax.swing.border.Border;
import java.awt.*;

public class TTitleBorder implements Border {
    Color backGround, titleColor, topBar;
    String title;
    int BorderRadius;
    public TTitleBorder(String title, Color backGround, Color topBar, Color titleColor, int BorderRadius) {
        this.titleColor = titleColor;
        this.backGround = backGround;
        this.title = title;
        this.BorderRadius = BorderRadius;
        this.topBar = topBar;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(backGround);
        g.fillRoundRect(0, 0, width - 1, height - 1, BorderRadius, BorderRadius);
        g.setColor(topBar);
        g.fillRoundRect(0, 0, width - 1, 20, BorderRadius, BorderRadius);
        g.setColor(titleColor);
        g.drawString(title, x + 4, y + 15);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(20, 2, 2, 2);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
