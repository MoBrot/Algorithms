package de.mobro.algorithm.algorithm;

import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

public class CocktailShaker implements Algorithm {


    @Override
    public Bar[] iterate(Bar[] array, MainManager manager) throws InterruptedException {

        // To the right

        for (int i = 0; i < array.length - 1; i++) {

            Bar bar1 = array[i];
            Bar bar2 = array[i + 1];

            if(bar1.getValue() > bar2.getValue())
                array = manager.swap(array, bar1.getPosition(), bar2.getPosition());

            manager.visualizestep(array, bar1, bar2);

        }

        // To the left

        for (int i = array.length - 1; i > 0; i--) {

            Bar bar1 = array[i];
            Bar bar2 = array[i - 1];

            if(bar1.getValue() < bar2.getValue())
                array = manager.swap(array, bar1.getPosition(), bar2.getPosition());

            manager.visualizestep(array, bar1, bar2);
        }

        return array;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
