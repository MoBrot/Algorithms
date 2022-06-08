package de.mobro.algorithm.gui.visualitiation;

import java.awt.*;

public class Bar {

    private Color color;
    private final int size;

    public Bar(Color color, int size) {

        this.color = color;
        this.size = size;

    }

    public void setColor(Color newColor) {

        this.color = newColor;

    }

    public int getSize() {
        return size;
    }
}
