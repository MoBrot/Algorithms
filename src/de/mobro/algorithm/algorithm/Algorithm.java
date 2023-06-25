package de.mobro.algorithm.algorithm;

import de.mobro.algorithm.visualitiation.Bar;
import de.mobro.algorithm.visualitiation.MainManager;

public interface Algorithm {

    Bar[] iterate(Bar[] array, MainManager manager) throws InterruptedException;

}
