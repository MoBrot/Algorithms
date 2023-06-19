package de.mobro.algorithm.gui.algorithm;

import de.mobro.algorithm.gui.visualitiation.Bar;
import de.mobro.algorithm.gui.visualitiation.MainManager;

public class Bubblesort implements Algorithm {

    @Override
    public Bar[] iterate(Bar[] array, Bar current, Bar target, MainManager manager) {

        if(current.getValue() > target.getValue())
            array = manager.swap(array, current.getPosition(), target.getPosition());

        return array;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
