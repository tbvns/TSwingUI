package xyz.tbvns;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class RoundedButton extends AbstractButton {
    Color backgroundColor, hoverColor, clickColor, textColor = Color.BLACK;
    int borderRadius;
    boolean isButtonHovered = false;
    boolean isButtonPressed = false;
    JLabel label;

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        label.setBounds(0, 0, width, height);
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        label.setForeground(color);
    }

    public RoundedButton(String text, Color backgroundColor, Color hoverColor, Color clickColor, int borderRadius) {
        setText(text);
        setBackground(backgroundColor);
        this.backgroundColor = backgroundColor;
        this.hoverColor = hoverColor;
        this.clickColor = clickColor;
        this.borderRadius = borderRadius;

        label = new JLabel(text);
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setAlignmentY(CENTER_ALIGNMENT);
        add(label);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(clickColor);
                isButtonPressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverColor);
                isButtonPressed = false;

                if (!isButtonHovered) {
                    setBackground(backgroundColor);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                isButtonHovered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isButtonHovered = false;

                if (! isButtonPressed) {
                    setBackground(backgroundColor);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, borderRadius, borderRadius);
        super.paint(g);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}

class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}