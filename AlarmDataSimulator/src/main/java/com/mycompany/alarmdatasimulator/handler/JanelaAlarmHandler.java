/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.handler;

import com.mycompany.alarmdatasimulator.dominio.Alarm;
import com.mycompany.alarmdatasimulator.view.JanelaAlarm;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class JanelaAlarmHandler {

    private final JanelaAlarm frame;
    private Alarm alarm;

    public JanelaAlarmHandler(JanelaAlarm frame) {
        this.frame = frame;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
        updateFields(alarm.getName(), alarm.getOcourrenceProbability(), alarm.getDuration(), alarm.getError());
    }

    private void updateFields(String name, Float ocourrence, Long duration, Long error) {
        if (!(name == null || ocourrence == null || duration == null || error == null)) {
            frame.getNameField().setText(name);
            frame.getOcourrenceField().setText(ocourrence.toString());
            frame.getDurationField().setText(duration.toString());
            frame.getErrorField().setText(error.toString());
        }
    }

    public boolean checkFields(String name, String ocourrence, String duration, String error) {
        String result = validateFields(name, ocourrence, duration, error);
        return result.equals("OK");
    }

    public void warningFields(String name, String ocourrence, String duration, String error) {
        String result = validateFields(name, ocourrence, duration, error);
        JOptionPane.showMessageDialog(frame, result, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private String validateFields(String name, String ocourrence, String duration, String error) {
        String retorno = "OK";
        Long durationValue = null, errorValue = null;
        Float ocourrenceValue;
        if (name == null || ocourrence == null || duration == null || error == null) {
            retorno = "Any field is null";
        }
        if (name != null) {
            if(name.isEmpty()) retorno = "Field name is empty";
        }
        if (ocourrence != null) {
            try {
                ocourrenceValue = Float.parseFloat(ocourrence);
                if (Float.isNaN(ocourrenceValue)) {
                    retorno = "Field ocourrence is NaN";
                }
                if (ocourrenceValue < 0 || ocourrenceValue > 100) {
                    retorno = "Field ocourrence is out of limits [0,100]";
                }
            } catch (NumberFormatException ex) {
                retorno = "Field ocourrence format exception";
            }
        }
        if (duration != null) {
            try {
                durationValue = Long.parseLong(duration);
                if (durationValue < 0) {
                    retorno = "Field duration is negative";
                }
            } catch (NumberFormatException ex) {
                retorno = "Field duration format exception";
            }
        }
        if (error != null) {
            try {
                errorValue = Long.parseLong(error);
                if (errorValue < 0) {
                    retorno = "Field error is negative";
                }
            } catch (NumberFormatException ex) {
                retorno = "Field error format exception";
            }
        }
        if (errorValue != null && durationValue != null) {
            if (errorValue > durationValue) {
                retorno = "Error value is greater than duration value";
            }
        }
        return retorno;
    }

    public void botaoOK(String name, String ocourrence, String duration, String error) {
        Alarm alarm = new Alarm();
        alarm.setName(name);
        alarm.setOcourrenceProbability(Float.parseFloat(ocourrence));
        alarm.setDuration(Long.parseLong(duration));
        alarm.setError(Long.parseLong(error));
        frame.sendNewAlarm(alarm);
        frame.dispose();
    }

    public Alarm getAlarm() {
        return this.alarm;
    }

}
