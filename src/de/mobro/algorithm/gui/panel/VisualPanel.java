package de.mobro.algorithm.gui.panel;

import de.mobro.algorithm.gui.visualitiation.Bar;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;

public class VisualPanel extends JPanel {

    public final Color defaultBarCOlor = new Color(3, 102, 250, 255);

    public VisualPanel(int x, int y) {

        this.setBackground(Color.BLACK);

        this.setSize(x, y);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;

        for (Bar bar : MainManager.bars)
            bar.draw(graphics2D);
        g.dispose();
    }
}
