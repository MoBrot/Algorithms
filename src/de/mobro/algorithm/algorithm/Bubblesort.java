package de.mobro.algorithm.algorithm;

import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

import java.awt.*;

public class Bubblesort implements Algorithm {

    @Override
    public Bar[] iterate(Bar[] array, MainManager manager) throws InterruptedException {

        System.out.println(array.length);

        for (int i = 0; i < array.length; i++) {

            array[i].setColor(Color.RED);

            Thread.sleep(manager.getSpeed());

            manager.getVisualPanel().drawBarArray(array);
        }

        return array;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
