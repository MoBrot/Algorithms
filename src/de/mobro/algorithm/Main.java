package de.mobro.algorithm;

import de.mobro.algorithm.gui.Frame;
import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        int x = 1250;
        int y = 750;

        MainManager manager = new MainManager();
        ActionListener actionListener = new ActionPerformed(manager);

        new Frame(x, y, manager, actionListener);

    }
}
