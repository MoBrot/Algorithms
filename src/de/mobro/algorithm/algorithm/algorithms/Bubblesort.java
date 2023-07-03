package de.mobro.algorithm.algorithm.algorithms;

import de.mobro.algorithm.algorithm.Algorithm;
import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

public class Bubblesort extends Algorithm {

    @Override
    public Bar[] iterate(Bar[] array, MainManager manager) throws InterruptedException {

        for (int i = 0; i < array.length - 1; i++) {

            Bar bar1 = array[i];
            Bar bar2 = array[i + 1];


            if(bar1.getValue() > bar2.getValue())
                array = manager.swap(array, bar1.getPosition(), bar2.getPosition());


            manager.visualizestep(array, bar1, bar2);
        }

        return array;
    }
}
