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

        Graphics2D graphics2D = ((Graphics2D) this.getGraphics());

        // Set the the pane screen to the backround color to overpaint the Drawn bar array
        graphics2D.setColor(this.getBackground());
        graphics2D.drawRect(0, 0, this.getWidth(), this.getHeight());

        for (Bar bar : bars)
            bar.draw(graphics2D);

        this.lastDrawnBarArray = bars;

        graphics2D.dispose();
    }
}
