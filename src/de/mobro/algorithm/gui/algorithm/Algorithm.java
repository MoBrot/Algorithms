package de.mobro.algorithm.gui.algorithm;

import de.mobro.algorithm.gui.visualitiation.Bar;
import de.mobro.algorithm.gui.visualitiation.MainManager;

public interface Algorithm {

    Bar[] iterate(Bar[] array, Bar current, Bar target, MainManager manager);

}
