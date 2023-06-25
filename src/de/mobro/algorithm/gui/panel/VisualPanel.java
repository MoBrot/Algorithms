package de.mobro.algorithm.gui.panel;

import de.mobro.algorithm.visualitiation.Bar;

import javax.swing.*;
import java.awt.*;

public class VisualPanel extends JPanel {

    public final Color defaultBarCOlor = new Color(3, 102, 250, 255);

    public Bar[] lastDrawnBarArray = null;

    public VisualPanel(int width, int height) {

        this.setBackground(Color.BLACK);

        this.setSize(width, height);

        this.setLayout(null);
    }

    public void drawBarArray(Bar[] bars) {

        for (Bar bar : bars)
            bar.draw(((Graphics2D) this.getGraphics()));

        this.lastDrawnBarArray = bars;
    }
}
