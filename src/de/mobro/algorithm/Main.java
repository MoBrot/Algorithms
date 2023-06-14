package de.mobro.algorithm;

import de.mobro.algorithm.gui.Frame;
import de.mobro.algorithm.gui.visualitiation.MainManager;

public class Main {

    public static void main(String[] args) {

        int x = 1250;
        int y = 750;

        new Frame(x, y, new MainManager());

    }
}
