package de.mobro.algorithm.gui.visualitiation;

import java.awt.*;
import java.util.Random;

public class Bar {

    private Color color;
    private final int width;
    private final int height;
    private final MainManager manager;
    private final int defaultHeight;

    public Bar(Color color, int width, int defaultHeight, int topDistance, Random random, MainManager manager) {

        this.color = color;
        this.width = width;
        this.manager = manager;
        this.defaultHeight = defaultHeight;

        int difference = defaultHeight - topDistance;
        this.height = random.nextInt(20, difference);
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public int getValue() {
        return height;
    }

    public int getPosition() {
        return MainManager.bars.indexOf(this);
    }

    public void draw(Graphics2D graphics2D) {

        graphics2D.setColor(this.color);

        int positionX = getPosition() * this.width;

        graphics2D.fillRect(positionX, this.defaultHeight - this.height, this.width, this.height);

    }
}
