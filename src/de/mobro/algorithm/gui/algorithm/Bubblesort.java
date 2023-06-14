package de.mobro.algorithm.gui.algorithm;

import de.mobro.algorithm.gui.visualitiation.Bar;

public class Bubblesort implements Algorithm {
    @Override
    public Bar[] iterate(Bar[] bars) {
        return bars;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
