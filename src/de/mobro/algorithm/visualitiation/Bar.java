package de.mobro.algorithm.visualitiation;

import java.awt.*;
import java.util.Random;

public class Bar {

    private Color color;
    private final int width;
    private final int height;
    private final MainManager manager;
    private final int defaultHeight;

    private final Bar[] parent;

    public Bar(Bar[] parent, Color color, int width, int defaultHeight, int topDistance, Random random, MainManager manager) {

        this.color = color;
        this.width = width;
        this.manager = manager;
        this.defaultHeight = defaultHeight;

        int difference = defaultHeight - topDistance;
        this.height = random.nextInt(20, difference);

        this.parent = parent;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public int getValue() {
        return height;
    }

    public void draw(Graphics2D graphics2D) {

        graphics2D.setColor(this.color);

        int arrayPosition = -1;
        for (int i = 0; i < parent.length - 1; i++) {

            if (parent[i] == this) {
                arrayPosition = i;
                break;
            }
        }

        int positionX = arrayPosition * this.width;

        graphics2D.fillRect(positionX, this.defaultHeight - this.height, this.width, this.height);

    }
}
