package de.mobro.algorithm.visualitiation;

import java.awt.*;
import java.util.Random;

public class Bar {

    private Color color;
    private final int width;
    private final int height;
    private final int defaultHeight;
    private final MainManager manager;
    private int position;

    public Bar(int pos, Color color, int width, int defaultHeight, int topDistance, Random random, MainManager manager) {

        this.position = pos;

        this.color = color;
        this.width = width;
        this.defaultHeight = defaultHeight;

        int difference = defaultHeight - topDistance;
        this.height = random.nextInt(20, difference);

        this.manager = manager;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public int getValue() {
        return height;
    }

    public void clarify() {
        setColor(manager.getVisualPanel().highlitedBarColor);
    }

    public void normalize() {
        setColor(manager.getVisualPanel().defaultBarColor);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void draw(Graphics2D graphics2D) {

        graphics2D.setColor(this.color);

        int positionX = this.position * this.width;

        graphics2D.fillRect(positionX, this.defaultHeight - this.height, this.width, this.height);

    }

    @Override
    public String toString() {
        return "Value: " + getValue();
    }
}
