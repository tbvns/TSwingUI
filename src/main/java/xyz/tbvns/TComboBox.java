package xyz.tbvns;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TComboBox extends JComboBox {
    Color background, hovered, TextColor, SelectedTextColor, currentColor, clickColor;
    int CornerRadius;
    boolean isButtonHovered = false, isButtonPressed = false;
    TComboBoxUI boxUI;
    public TComboBox(String[] strings, Color background, Color hovered, Color TextColor, Color SelectedTextColor, Color clickColor, int CornerRadius) {
        super(strings);
        this.background = background;
        this.hovered = hovered;
        this.TextColor = TextColor;
        this.SelectedTextColor = SelectedTextColor;
        this.CornerRadius = CornerRadius;
        setRenderer(new TCellRenderer(background, hovered, TextColor, SelectedTextColor));
        boxUI = new TComboBoxUI(background, hovered, TextColor, SelectedTextColor, CornerRadius);
        setUI(boxUI);
        setForeground(TextColor);
        setBackground(new Color(0, 0, 0, 0));
        setIgnoreRepaint(true);

        currentColor = background;

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
                currentColor = (hovered);
                isButtonPressed = false;

                if (!isButtonHovered) {
                    currentColor = (background);
                }

                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                currentColor = (hovered);
                isButtonHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isButtonHovered = false;
                if (! isButtonPressed) {
                    currentColor = (background);
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
        g.fillRoundRect(0, 0, this.getWidth()-1, this.getHeight()-1, CornerRadius, CornerRadius);
        g.setColor(background);
        g.fillRoundRect(Width, Width, this.getWidth()-1 - Width * 2, this.getHeight()-1 - Width * 2, CornerRadius, CornerRadius);
        if (isPopupVisible()) {
            boxUI.button.setText("▲");
        } else {
            boxUI.button.setText("▼");
        }
        super.paint(g);
    }
}
