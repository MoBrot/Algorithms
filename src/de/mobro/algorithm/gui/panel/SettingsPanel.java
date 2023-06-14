package de.mobro.algorithm.gui.panel;

import de.mobro.algorithm.gui.algorithm.Algorithm;
import de.mobro.algorithm.gui.algorithm.Bubblesort;
import de.mobro.algorithm.gui.visualitiation.Bar;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private final MainManager manager;

    private final Bubblesort bubbleSort = new Bubblesort();


    public SettingsPanel(int x, int y, MainManager manager) {

        this.manager = manager;

        this.setBackground(Color.WHITE);

        this.setLayout(null);
        this.setSize(x, y);

        /*
        Add components
        ----------------------------------
         */

        this.add(getStartButton());
        this.add(getResetButton());
        this.add(getAmountSlider());
        this.add(getSpeedSlider());
        this.add(getComboBox());

        this.add(getSpeedLabel());
        this.add(getAmountLabel());

        this.add(getSplitter());
        this.add(getHeadline());

        //----------------------------------

        this.setVisible(true);

    }

    private JComboBox comboBox;

    private final JSlider speedSlider =  new JSlider(1, 2000);
    private final JSlider amountSlider = new JSlider(10, 512);;

    private final JButton resetButton = new JButton("Reset bars");;
    private final JButton startButton = new JButton("Sort");

    private final JLabel amountLabel = new JLabel();
    private final JLabel speedLabel = new JLabel();

    private final JLabel split = new JLabel();
    private final JLabel headline = new JLabel();


    public static JLabel counter;

    public static Algorithm selectedAlgorithm;

    private JComboBox getComboBox() {

        Algorithm[] algorithms = {

                bubbleSort

        };

        selectedAlgorithm = algorithms[0];

        comboBox = new JComboBox(algorithms);

        comboBox.addActionListener(e -> {
            selectedAlgorithm = (Algorithm) comboBox.getSelectedItem();
        });

        comboBox.setBounds(950, 345, 250, 40);

        return comboBox;

    }

    private JSlider getSpeedSlider(){

        speedSlider.setOrientation(JSlider.HORIZONTAL);
        speedSlider.setValue(250);

        speedSlider.setBounds(950, 250, 250, 40);

        speedSlider.addChangeListener(e -> {

            if(e.getSource() == this.speedSlider)
                this.speedLabel.setText("Delay: " + this.speedSlider.getValue() + "ms");

        });

        return speedSlider;
    }

    private JSlider getAmountSlider() {

        amountSlider.setOrientation(JSlider.HORIZONTAL);
        amountSlider.setValue(20);

        amountSlider.setBounds(950, 150, 250, 40);
        amountSlider.setToolTipText("Bars: " + amountSlider.getValue());

        amountSlider.setPaintTicks(true);
        amountSlider.setMinorTickSpacing(20);

        amountSlider.setPaintTrack(true);
        amountSlider.setMajorTickSpacing(100);

        amountSlider.setPaintLabels(true);

        amountSlider.addChangeListener(e -> {

            if(e.getSource() == this.amountSlider)
                amountLabel.setText("Bars: " + this.amountSlider.getValue());

        });

        return amountSlider;

    }

    private JButton getStartButton() {

        startButton.addActionListener(e -> {

            // Toggle sort / stop sorting
            if(startButton.getText().equalsIgnoreCase("sort")) {

                manager.sort();
                startButton.setText("Stop");

            } else {
                startButton.setText("Sort");
                manager.stopSorting();
            }
        });

        startButton.setBounds(950, 50, 75, 45);

        return startButton;

    }

    private JButton getResetButton() {

        resetButton.addActionListener(e -> {

            manager.stopSorting();



        });
        resetButton.setBounds(1050, 50, 100, 45);

        return resetButton;

    }

    private JLabel getSpeedLabel(){

        speedLabel.setText("Delay: " + speedSlider.getValue() + "ms");
        speedLabel.setBounds(1025, 220, 1000, 30);

        speedLabel.setFont(new Font("", Font.PLAIN, 20));

        return speedLabel;

    }

    private JLabel getAmountLabel(){

        amountLabel.setText("Bars: " + amountSlider.getValue());
        amountLabel.setBounds(1025, 120, 100, 30);

        amountLabel.setFont(new Font("", Font.PLAIN, 20));

        return amountLabel;

    }

    private JLabel getSplitter() {

        split.setText("--------------------------------------");
        split.setBounds(1000, 400, 300, 10);

        return split;

    }

    private JLabel getHeadline(){

        headline.setText("Results: ");
        headline.setFont(new Font("", Font.BOLD, 15));

        headline.setBounds(950, 445, 100, 20);

        return headline;

    }

    private JLabel getCounter(){

        counter = new JLabel();

        counter.setText("- Steps");
        //counter.setBounds();

        return counter;

    }
}