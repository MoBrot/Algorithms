package de.mobro.algorithm.gui;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;
import de.mobro.algorithm.visualitiation.MainManager;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(int x, int y) {

        this.setSize(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Algorithms");
        this.setLocationRelativeTo(null);

        int settingsWidth = 350;
        int visualPanelWidth = x - settingsWidth;

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        VisualPanel visualPanel = new VisualPanel(visualPanelWidth, y);
        SettingsPanel settingsPanel = new SettingsPanel(settingsWidth, y, new MainManager(visualPanel));

        pane.setLeftComponent(visualPanel);
        pane.setRightComponent(settingsPanel);

        pane.setDividerLocation(visualPanelWidth);
        pane.setDividerSize(0);

        this.add(pane);

        this.setVisible(true);
    }
}

