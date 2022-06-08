package de.mobro.algorithm.gui.panel;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {

    private final ActionListener actionListener;

    private final int x;
    private final int y;

    public SettingsPanel(int x, int y, ActionListener actionListener) {

        this.actionListener = actionListener;
        this.x = x;
        this.y = y;

        this.setBackground(Color.WHITE);

        this.setLayout(null);
        this.setSize(x, y);

        /*
        Add components
        ----------------------------------
         */

        this.add(getStart());
        this.add(getReset());
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

    public static JComboBox comboBox;

    public static JSlider speed;
    public static JSlider amount;

    public static JButton reset;
    public static JButton start;

    public static JLabel amountLabel;
    public static JLabel speedLabel;

    private JLabel split;
    private JLabel headline;


    public static JLabel counter;

    private JComboBox getComboBox() {

        String[] algorithmTypes = {
                "Bubblesort",
                "Quicksort",
                "ShellSort",

        };

        comboBox = new JComboBox(algorithmTypes);
        comboBox.addActionListener(actionListener);

        comboBox.setBounds(950, 345, 250, 40);

        return comboBox;

    }

    private JSlider getSpeedSlider(){

        speed =  new JSlider(1, 2000);

        speed.setOrientation(JSlider.HORIZONTAL);
        speed.setValue(250);

        speed.setBounds(950, 250, 250, 40);

        speed.addChangeListener((ChangeListener) actionListener);

        //speed.setBounds(x, y);

        return speed;

    }

    private JSlider getAmountSlider() {

        amount =  new JSlider(10, 512);

        amount.setOrientation(JSlider.HORIZONTAL);
        amount.setValue(20);

        amount.setBounds(950, 150, 250, 40);
        amount.setToolTipText("Bars: " + amount.getValue());

        amount.setPaintTicks(true);
        amount.setMinorTickSpacing(20);

        amount.setPaintTrack(true);
        amount.setMajorTickSpacing(100);

        amount.setPaintLabels(true);

        amount.addChangeListener((ChangeListener) actionListener);

        return amount;

    }

    private JButton getStart(){

        start = new JButton("Sort");

        start.addActionListener(actionListener);
        start.setBounds(950, 50, 75, 45);

        return start;

    }

    private JButton getReset() {

        reset = new JButton("Reset bars");

        reset.addActionListener(actionListener);
        reset.setBounds(1050, 50, 100, 45);

        return reset;

    }

    private JLabel getSpeedLabel(){

        speedLabel = new JLabel();

        speedLabel.setText("Delay: " + speed.getValue() + "ms");
        speedLabel.setBounds(1025, 220, 1000, 30);

        speedLabel.setFont(new Font("", Font.PLAIN, 20));

        return speedLabel;

    }

    private JLabel getAmountLabel(){

        amountLabel = new JLabel();

        amountLabel.setText("Bars: " + amount.getValue());
        amountLabel.setBounds(1025, 120, 100, 30);

        amountLabel.setFont(new Font("", Font.PLAIN, 20));

        return amountLabel;

    }

    private JLabel getSplitter() {

        split = new JLabel();

        split.setText("--------------------------------------");
        split.setBounds(1000, 400, 300, 10);

        return split;

    }

    private JLabel getHeadline(){

        headline = new JLabel();

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