package de.mobro.algorithm.gui.visualitiation;

import java.awt.*;
import java.util.Random;

public class Bar {

    private Color color;
    private final int width;

    private final int value;

    private final int height;

    public Bar(Color color, int width, int value, int pos, int defaultHeight, int frameSize, int topDistance, Random random) {

        this.color = color;
        this.width = width;
        this.value = value;

        int bottomStart = frameSize - defaultHeight;
        this.height = random.nextInt(bottomStart, topDistance);
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public int getWidth() {
        return width;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public int getPosition() {
        return MainManager.bars.indexOf(this);
    }

    public void draw(Graphics2D graphics2D) {

    }
}
