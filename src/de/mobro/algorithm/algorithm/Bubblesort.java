package de.mobro.algorithm.algorithm;

import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

import java.util.Arrays;

public class Bubblesort implements Algorithm {

    @Override
    public Bar[] iterate(Bar[] array, MainManager manager) {

        for (int i = 0; i < array.length - 1; i++) {

            Bar bar1 = array[i];
            Bar bar2 = array[i + 1];

            manager.for2Bars(bar1, bar2, Bar::clarify);

            if(bar1.getValue() > bar2.getValue())
                array = manager.swap(array, i, i + 1);

            manager.getVisualPanel().drawBarArray(array);

            try {

                Thread.sleep(manager.getSpeed());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            manager.for2Bars(bar1, bar2, Bar::normalize);
        }

        return array;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
