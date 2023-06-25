package de.mobro.algorithm.visualitiation;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;

import java.awt.*;
import java.util.ArrayList;
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

    public Bar[] swap(Bar[] barList, int index1, int index2) {

        Bar temp = barList[index1];
        barList[index1] = barList[index2];
        barList[index2] = temp;

        barList[index1].setColor(Color.GREEN);
        barList[index2].setColor(Color.GREEN);

        System.out.println("Sorted indexA: " + index1 + " indexB: " + index2);

        return barList;
    }

    public boolean isSorted(Bar[] bars) {

        for (int i = 0; i < bars.length; i++) {

            if(bars[i + 1] != null) {

                if (bars[i].getValue() < bars[i + 1].getValue())
                    return false;

            } else
                return true;
        }

        return false;
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
            }
        });

        sortingThread.start();
    }

    public void stopSorting() {
        if(sortingThread != null)
            sortingThread.stop();
    }

    public void reset() {

        stopSorting();

        final Bar[] newBars = new Bar[getAmount()];

        int barAmount = getAmount();
        int barWidth = (getVisualPanel().getWidth() + 1) / getAmount();

        System.out.println(getVisualPanel().getWidth());

        for (int i = 0; i < barAmount; i++)
            newBars[i] = new Bar(newBars, getVisualPanel().defaultBarCOlor, barWidth, getVisualPanel().getHeight(), 20, random, this);

        getVisualPanel().drawBarArray(newBars);

        SettingsPanel.startButton.setText("Sort");
    }
}
