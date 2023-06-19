package de.mobro.algorithm.gui.visualitiation;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.panel.VisualPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainManager {

    public static ArrayList<Bar> bars = new ArrayList<>();
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

        barList[index1].setColor(Color.RED);
        barList[index2].setColor(Color.RED);

        try {

            Thread.sleep(getSpeed());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return barList;
    }

    public boolean isSorted() {

        for (int i = 0; i < bars.size(); i++) {
            if(bars.get(i + 1) != null) {

                if (bars.get(i).getValue() < bars.get(i + 1).getValue()) {
                    return false;
                }

            } else
                return true;
        }

        return false;
    }

    private Bar[] temp;

    private Thread sortingThread;
    public void sort() {

        temp = MainManager.bars.toArray(new Bar[0]);

        sortingThread = new Thread(() -> {


        });

        sortingThread.start();
    }

    public void stopSorting() {
        if(sortingThread != null)
            sortingThread.stop();
    }

    public void reset() {

        stopSorting();

        // TODO performanter

        final ArrayList<Bar> newBars = new ArrayList<>();

        int barAmount = getAmount();
        int barWidth = Math.round((float) getVisualPanel().getWidth() / getAmount());

        for (int i = 0; i < barAmount; i++)
            newBars.add(new Bar(getVisualPanel().defaultBarCOlor, barWidth, getVisualPanel().getHeight(), 20, random, this));

        bars = newBars;

        getVisualPanel().repaint();
    }

    public Random getRandom() {
        return random;
    }
}
