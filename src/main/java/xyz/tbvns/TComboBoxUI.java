package xyz.tbvns;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class TComboBoxUI extends BasicComboBoxUI {
    Color background, hovered, TextColor, SelectedTextColor;
    int CornerRadius;
    public JButton button;
    public TComboBoxUI(Color background, Color hovered, Color TextColor, Color SelectedTextColor, int CornerRadius) {
        super();
        this.background = background;
        this.hovered = hovered;
        this.TextColor = TextColor;
        this.SelectedTextColor = SelectedTextColor;
        this.CornerRadius = CornerRadius;
    }

    @Override
    public void update(Graphics g, JComponent c) {
        paint(g, c);
    }

    @Override
    protected ListCellRenderer<Object> createRenderer() {
        return new TCellRenderer(background, hovered, TextColor, SelectedTextColor);
    }

    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton("▼");
        button.setBackground(new Color(0, 0, 0, 0));
        button.setBorder(null);
        button.setForeground(TextColor);
        button.setBounds(0, -5, button.getWidth(), button.getHeight());
        this.button = button;
        return button;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        hasFocus = comboBox.hasFocus();
        if ( !comboBox.isEditable() ) {
            Rectangle r = rectangleForCurrentValue();
            paintCurrentValueBackground(g,r,false);
            paintCurrentValue(g,r,false);
        }
        // Empty out the renderer pane, allowing renderers to be gc'ed.
        currentValuePane.removeAll();
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        Color t = g.getColor();
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRoundRect(bounds.x,bounds.y,bounds.width,bounds.height, 10, 10);
        g.setColor(t);
    }

    @Override
    public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        ListCellRenderer<Object> renderer = comboBox.getRenderer();
        Component c;

        if ( hasFocus && !isPopupVisible(comboBox) ) {
            c = renderer.getListCellRendererComponent( listBox,
                    comboBox.getSelectedItem(),
                    -1,
                    true,
                    false );
        }
        else {
            c = renderer.getListCellRendererComponent( listBox,
                    comboBox.getSelectedItem(),
                    -1,
                    false,
                    false );
            c.setBackground(UIManager.getColor("ComboBox.background"));
        }
        c.setFont(comboBox.getFont());
        if ( hasFocus && !isPopupVisible(comboBox) ) {
            c.setForeground(listBox.getSelectionForeground());
            c.setBackground(listBox.getSelectionBackground());
        }
        else {
            if ( comboBox.isEnabled() ) {
                c.setForeground(comboBox.getForeground());
                c.setBackground(comboBox.getBackground());
            }
            else {
                c.setForeground(TextColor);
                c.setBackground(background);
            }
        }

        // Fix for 4238829: should lay out the JPanel.
        boolean shouldValidate = false;
        if (c instanceof JPanel)  {
            shouldValidate = true;
        }

        int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;

        if (padding == null) {
            padding = new Insets(0, 0, 0, 0);
        }

        x = bounds.x + padding.left + 5;
        y = bounds.y + padding.top;
        w = bounds.width - (padding.left + padding.right);
        h = bounds.height - (padding.top + padding.bottom);

        currentValuePane.paintComponent(g,c,comboBox,x,y,w,h,shouldValidate);
    }
}
