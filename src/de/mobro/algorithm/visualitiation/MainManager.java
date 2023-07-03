package de.mobro.algorithm.visualitiation;

import de.mobro.algorithm.algorithm.*;
import de.mobro.algorithm.algorithm.algorithms.*;
import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;

import java.util.Random;

public class MainManager {

    private final Random random = new Random();

    private final VisualPanel visualPanel;
    public MainManager(VisualPanel visualPanel) {
        this.visualPanel = visualPanel;
    }

    private int speed = 1;
    private int amount = 200;

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public VisualPanel getVisualPanel() {
        return visualPanel;
    }

    private final Algorithm[] algorithms = {

            new Bubblesort(),
            new CocktailShaker(),
            new InsertionSort(),
            new QuickSort(),
            new SelectionSort(),

    };

    public Algorithm[] getAlgorithms() {
        return algorithms;
    }

    public Bar[] swap(Bar[] barList, int index1, int index2) {

        Bar atIndex1 = barList[index1];
        Bar atIndex2 = barList[index2];

        // For drawing
        atIndex1.setPosition(index2);
        atIndex2.setPosition(index1);

        // Swap in array
        barList[index2] = atIndex1;
        barList[index1] = atIndex2;

        return barList;
    }

    public boolean isSorted(Bar[] bars) {

        for (int i = 0; i < bars.length - 1; i++) {

            if(bars[i].getValue() > bars[i + 1].getValue())
                return false;
        }

        return true;
    }

    private Bar[] temp;
    private Thread sortingThread;
    public void sort() {

        temp = getVisualPanel().lastDrawnBarArray.clone();

        sortingThread = new Thread(() -> {

            while (true) {

                try {

                    temp = SettingsPanel.selectedAlgorithm.iterate(temp, this);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if(isSorted(temp))
                    return;
            }
        });

        sortingThread.start();
    }

    public void stopSorting() {

        if(sortingThread != null)
            sortingThread.stop();

        SettingsPanel.startButton.setText("Sort");
    }

    public void reset() {

        stopSorting();

        final Bar[] newBars = new Bar[getAmount()];

        int barAmount = getAmount();
        int barWidth = (int) ((float) getVisualPanel().getWidth() / getAmount());

        for (int i = 0; i < barAmount; i++)
            newBars[i] = new Bar(i, getVisualPanel().defaultBarColor, barWidth, getVisualPanel().getHeight(), 20, random, this);

        getVisualPanel().drawBarArray(newBars);
    }

    private final Bar[] iterateArray = new Bar[2];
    public void for2Bars(Bar bar1, Bar bar2, IterateInterface iterateInterface) {

        iterateArray[0] = bar1;
        iterateArray[1] = bar2;

        for (Bar bar : iterateArray)
            iterateInterface.iteration(bar);

    }

    public void visualizestep(Bar[] array, Bar bar1, Bar bar2) throws InterruptedException {

        // Clarify Color of selected bars
        this.for2Bars(bar1, bar2, Bar::clarify);

        // Draw current array
        this.getVisualPanel().drawBarArray(array);

        Thread.sleep(this.getSpeed());

        // Normalize Color of selected
        this.for2Bars(bar1, bar2, Bar::normalize);
    }
}
