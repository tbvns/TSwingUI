package xyz.tbvns;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TRoundedButton extends AbstractButton {
    Color backgroundColor, hoverColor, clickColor, textColor = Color.BLACK;
    int borderRadius;
    boolean isButtonHovered = false;
    boolean isButtonPressed = false;
    JLabel label;

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y + 3, width, height);
        label.setBounds(0, 0, width, height);
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        label.setForeground(color);
    }

    public TRoundedButton(String text, Color backgroundColor, Color hoverColor, Color clickColor, int borderRadius) {
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

        setHorizontalTextPosition(SwingConstants.RIGHT);

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
        if (enableShadow) {
            g.setColor(new Color(0, 0, 0, 52));
            g.fillRoundRect(0, 4, this.getWidth()-1, this.getHeight()-4, borderRadius, borderRadius);
        }
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-4, borderRadius, borderRadius);
        super.paint(g);
    }

    boolean enableShadow = false;
    public void setEnableShadow(boolean value) {
        enableShadow = value;
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
