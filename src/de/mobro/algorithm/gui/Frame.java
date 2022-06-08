package de.mobro.algorithm.gui;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame(int x, int y, MainManager manager, ActionListener actionListener) {

        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setTitle("Algorithms");
        this.setLocationRelativeTo(null);

        VisualPanel visualPanel = new VisualPanel(manager, x - 350, y);
        SettingsPanel settingsPanel = new SettingsPanel(350, y, actionListener);

        this.add(visualPanel);
        this.add(settingsPanel);



        this.setVisible(true);

    }

}

