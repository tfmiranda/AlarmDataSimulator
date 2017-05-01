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
public class SimulationExecutor {

    private Map<Alarm, Map<Alarm, CausalRelation>> relations;
    private SimulationCore core;

    public SimulationExecutor(Map<Alarm, Map<Alarm, CausalRelation>> relations) {
        this.relations = relations;
    }
 
    public Map<Alarm, Map<Alarm, CausalRelation>> getRelations() {
        return relations;
    }

    public void setRelations(Map<Alarm, Map<Alarm, CausalRelation>> relations) {
        this.relations = relations;
    }

    public String simulate(DateTime init, Duration duration) {
        if (relations == null) {
            throw new NullPointerException();
        }
        core = new SimulationCore(init, duration);
        boolean success = core.simulate(relations);
        if (success) {
            return core.result();
        } else {
            return "Fail to simulate";
        }
    }

}
