package de.mobro.algorithm.gui.panel;

import de.mobro.algorithm.gui.algorithm.Algorithm;
import de.mobro.algorithm.gui.algorithm.Bubblesort;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SettingsPanel extends JPanel {

    private final MainManager manager;

    private final Bubblesort bubbleSort = new Bubblesort();

    private final int x = 35;

    public SettingsPanel(int x, int y, int width, int height, MainManager manager) {

        this.manager = manager;

        this.setBounds(x , y, width ,height);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

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

        this.add(getHeadline());

        //----------------------------------

        this.setVisible(true);

        manager.reset();

    }

    private JComboBox comboBox;

    private final JSlider speedSlider =  new JSlider(1, 2000);
    private final JSlider amountSlider = new JSlider(10, 512);;

    private final JButton resetButton = new JButton("Reset bars");;
    private final JButton startButton = new JButton("Sort");

    private final JLabel amountLabel = new JLabel();
    private final JLabel speedLabel = new JLabel();

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

        comboBox.setBounds(x, 345, 250, 40);

        return comboBox;

    }

    private final int sliderWidth = 250;
    private JSlider getSpeedSlider(){

        speedSlider.setOrientation(JSlider.HORIZONTAL);
        speedSlider.setValue(250);

        speedSlider.setBounds(x, 250, sliderWidth, 40);

        speedSlider.addChangeListener(e -> {

            if(e.getSource() == this.speedSlider)
                this.speedLabel.setText("Delay: " + this.speedSlider.getValue() + "ms");

            manager.setSpeed(speedSlider.getValue());

        });

        return speedSlider;
    }

    private JSlider getAmountSlider() {

        amountSlider.setOrientation(JSlider.HORIZONTAL);
        amountSlider.setValue(manager.getAmount());

        amountSlider.setBounds(x, 150, sliderWidth, 40);
        amountSlider.setToolTipText("Bars: " + amountSlider.getValue());

        amountSlider.setPaintTicks(true);
        amountSlider.setMinorTickSpacing(20);

        amountSlider.setPaintTrack(true);
        amountSlider.setMajorTickSpacing(100);

        amountSlider.setPaintLabels(true);

        amountSlider.addChangeListener(e -> {

            if(e.getSource() == this.amountSlider)
                amountLabel.setText("Bars: " + this.amountSlider.getValue());

            manager.setAmount(amountSlider.getValue());

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

        startButton.setBounds(x, 50, 75, 45);

        return startButton;

    }

    private JButton getResetButton() {

        resetButton.addActionListener(e -> {

            manager.reset();

        });
        resetButton.setBounds(x + 100, 50, 100, 45);

        return resetButton;

    }

    private JLabel getSpeedLabel(){

        speedLabel.setText("Delay: " + speedSlider.getValue() + "ms");
        speedLabel.setBounds(100, 220, 1000, 30);

        speedLabel.setFont(new Font("", Font.PLAIN, 20));

        return speedLabel;

    }

    private JLabel getAmountLabel(){

        amountLabel.setText("Bars: " + amountSlider.getValue());
        amountLabel.setBounds(100, 120, 100, 30);

        amountLabel.setFont(new Font("", Font.PLAIN, 20));

        return amountLabel;

    }

    private JLabel getHeadline(){

        headline.setText("Results: ");
        headline.setFont(new Font("", Font.BOLD, 15));

        headline.setBounds(x, 445, 100, 20);

        return headline;

    }

    private JLabel getCounter(){

        counter = new JLabel();

        counter.setText("- Steps");
        //counter.setBounds();

        return counter;

    }
}