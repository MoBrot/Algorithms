package de.mobro.algorithm.gui;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame(int x, int y) {

        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Algorithms");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        int settingsWidth = 350;
        int visualPanelWidth = x - settingsWidth;

        VisualPanel visualPanel = new VisualPanel(visualPanelWidth, y);
        SettingsPanel settingsPanel = new SettingsPanel(visualPanelWidth, 0, settingsWidth, y, new MainManager(visualPanel));

        this.add(visualPanel);
        this.add(settingsPanel);

        this.setVisible(true);
    }
}

