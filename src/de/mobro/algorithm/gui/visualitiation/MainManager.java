package de.mobro.algorithm.gui.visualitiation;

import de.mobro.algorithm.gui.panel.SettingsPanel;

import java.util.ArrayList;

public class MainManager {

    public static final ArrayList<Bar> bars = new ArrayList<>();

    private int speed = 1;
    private int amount = 10;

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

    public void swap(Bar bar1, Bar bar2) {

        int index1 = bars.indexOf(bar1);
        int index2 = bars.indexOf(bar2);

        bars.set(index1, bar2);
        bars.set(index2, bar1);
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

            while (!this.isSorted() || sortingThread != null) {

                temp = SettingsPanel.selectedAlgorithm.iterate(temp);

            }

            sortingThread.stop();
        });

        sortingThread.start();
    }

    public void stopSorting() {
        sortingThread.stop();
    }
}
