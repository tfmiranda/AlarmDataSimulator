/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.simulation;

import com.mycompany.alarmdatasimulator.dominio.Alarm;
import com.mycompany.alarmdatasimulator.dominio.CausalRelation;

import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 *
 * @author Tiago
 */
public class SimulationCore {

    private DateTime initial;
    private Duration period;
    private OcourrenceTable table;

    public SimulationCore(DateTime initial, Duration period) {
        this.initial = initial;
        this.period = period;
        this.table = new OcourrenceTable();
    }

    public boolean simulate(Map<Alarm, Map<Alarm, CausalRelation>> relations) {
        for (Map.Entry<Alarm, Map<Alarm, CausalRelation>> entry : relations.entrySet()) {
            Alarm alarm = entry.getKey();
            Map<Alarm, CausalRelation> relation = entry.getValue();
            Float probability = alarm.getOcourrenceProbability();
            Long duration = alarm.getDuration();
            Long erro = alarm.getError();
            for (int i = 0; i < period.getStandardSeconds(); i++) {
                Float pvalue = (float) random(100, 0);
                if (probability >= pvalue) {
                    double p = random(2, 1);
                    Long realDuration = duration + Math.round(p * erro);
                    DateTime initOcourr = initial.plusSeconds(i);
                    registrarOcourrence(alarm.getName(), initOcourr, realDuration);

                    for (Map.Entry<Alarm, CausalRelation> entry1 : relation.entrySet()) {
                        Alarm alarm1 = entry1.getKey();
                        CausalRelation causal = entry1.getValue();
                        Float causalProbability = causal.getProbability();
                        Long duration1 = alarm1.getDuration();
                        Long erro1 = alarm1.getError();
                        pvalue = (float) random(100, 0);
                        if (causalProbability >= pvalue) {
                            Long lag = causal.getLag();
                            Long lagErro = causal.getErro();
                            p = random(2, 1);
                            Long realLag = lag + Math.round(p * lagErro);
                            p = random(2, 1);
                            realDuration = duration1 + Math.round(p * erro1);
                            registrarOcourrence(alarm1.getName(), initOcourr.plusSeconds(realLag.intValue()), realDuration);
                        }
                    }
                    i = i + realDuration.intValue();                    
                }
            }
        }
        return true;
    }

    private void registrarOcourrence(String name, DateTime init, Long duration) {
        String format = "dd-MM-yyyy HH:mm:ss.SSS";
        String initStr = init.toString(format);
        String endStr = init.plusSeconds(duration.intValue()).toString(format);
        String durationStr = duration.toString();
        table.addOcourrence(name, initStr, endStr, durationStr);
    }

    private double random(double scale, double base) {
        double p = Math.random();
        return (p * scale) - base;
    }

    public String result() {
        StringBuilder builder = new StringBuilder();
        String separator = ";";
        table.begin();
        while (table.hasNext()) {
            try {
                OcourrenceRow element = table.next();
                builder.append(element.register(separator));
                builder.append("\n");
            } catch (IllegalAccessException ex) {
                System.out.println("A element of ocourrence table was lost");
            }
        }
        return builder.toString();
    }

}
