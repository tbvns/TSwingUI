package xyz.tbvns;

import javax.swing.*;
import java.awt.*;

public class TCellRenderer extends JLabel implements ListCellRenderer<Object> {
    Color background, hovered, TextColor, SelectedTextColor;

    public TCellRenderer(Color background, Color hovered, Color TextColor, Color SelectedTextColor) {
        this.background = background;
        this.hovered = hovered;
        this.TextColor = TextColor;
        this.SelectedTextColor = SelectedTextColor;
        setBackground(background);
    }



    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());

        setOpaque(true);

        Color background;
        Color foreground;

         if (isSelected) {
            background = hovered;
            foreground = TextColor;

        // unselected, and not the DnD drop location
        } else {
            background = this.background;
            foreground = this.SelectedTextColor;
        };

        setBackground(background);
        setForeground(foreground);
        return this;
    }
}
