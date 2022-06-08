package de.mobro.algorithm;

import de.mobro.algorithm.gui.panel.SettingsPanel;
import de.mobro.algorithm.gui.visualitiation.MainManager;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record ActionPerformed(MainManager manager) implements ActionListener, ChangeListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SettingsPanel.start) {



        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(e.getSource() == SettingsPanel.amount){

            SettingsPanel.amountLabel.setText("Bars: " + SettingsPanel.amount.getValue());

        }

        if(e.getSource() == SettingsPanel.speed){

            SettingsPanel.speedLabel.setText("Delay: " + SettingsPanel.speed.getValue() + "ms");

        }

    }
}
