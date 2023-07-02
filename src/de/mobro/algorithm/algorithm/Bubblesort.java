package de.mobro.algorithm.algorithm;

import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

public class Bubblesort implements Algorithm {

    @Override
    public Bar[] iterate(Bar[] array, MainManager manager) throws InterruptedException {

        for (int i = 0; i < array.length - 1; i++) {

            if(array[i].getValue() > array[i + 1].getValue())
                array = manager.swap(array, i, i + 1);

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
