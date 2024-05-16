package xyz.tbvns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TTextField extends JTextField {
    Color backgroundColor, hoverColor, clickColor, textColor = Color.BLACK, currentColor;
    int borderRadius;
    boolean isButtonHovered = false;
    boolean isButtonPressed = false;
    public TTextField(String text, Color backgroundColor, Color hoverColor, Color clickColor, int RoundedRadius) {
            setText(text);

            this.backgroundColor = backgroundColor;
            this.hoverColor = hoverColor;
            this.clickColor = clickColor;
            this.borderRadius = RoundedRadius;

            currentColor = backgroundColor;

            setHorizontalAlignment(SwingConstants.CENTER);

            setBorder(null);
            setBackground(new Color(0, 0, 0, 0));

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    currentColor = (clickColor);
                    isButtonPressed = true;
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    currentColor = (hoverColor);
                    isButtonPressed = false;

                    if (!isButtonHovered) {
                        currentColor = (backgroundColor);
                    }

                    repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    currentColor = (hoverColor);
                    isButtonHovered = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isButtonHovered = false;
                    if (! isButtonPressed) {
                        currentColor = (backgroundColor);
                        repaint();
                    }
                }
            });
    }
    int Width = 0;
    public void createRoundedBorder(int Width) {
       this.Width = Width;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(currentColor);
        g.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, borderRadius, borderRadius);
        g.setColor(backgroundColor);
        g.fillRoundRect(Width, Width, this.getWidth()-1 - Width * 2, this.getHeight()-1 - Width * 2, borderRadius, borderRadius);
        super.paint(g);
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(color);
    }
}
