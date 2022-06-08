package de.mobro.algorithm.gui.panel;

import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;

public class VisualPanel extends JPanel {

    private final  MainManager manager;

    public VisualPanel(MainManager manager, int x, int y) {

        this.manager = manager;

        this.setBackground(Color.BLACK);

        this.setSize(x, y);
        this.setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);



    }
}
