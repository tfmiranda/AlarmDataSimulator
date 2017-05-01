/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator;

import com.mycompany.alarmdatasimulator.dominio.Alarm;
import com.mycompany.alarmdatasimulator.simulation.SimulationExecutor;
import com.mycompany.alarmdatasimulator.dominio.CausalRelation;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * A generic occurrence industrial alarms simulator. Results from this code is applicable in database as CSV file.
 * @author Tiago F. Miramda
 */
public class Main {

    public static void main(String[] args) {
        Map<Alarm, Map<Alarm, CausalRelation>> relations = getRelations();       // Relations map
        SimulationExecutor exec = new SimulationExecutor(relations);

        DateTime init = new DateTime(2010, 5, 1, 1, 0, 0);  // Initial time simulation
        Duration duration = new Duration(init, init.plusMonths(3));              // Duration of simulation, in months
        String result = exec.simulate(init, duration);
        System.out.println(result);                                              // Print result as CSV pattern

    }

    /**
     * Generic industrial alarms scenario
      * @return
     */
    private static Map<Alarm, Map<Alarm, CausalRelation>> getRelations() {
        HashMap<Alarm, Map<Alarm, CausalRelation>> retorno = new HashMap<>();


        // Industrial alarms declaration (name, occurrence probability, occurrence duration (sec), duration error (sec))
        Alarm A = new Alarm("A", (float) 0.00010, (long) 2 * 60, (long) 10);
        Alarm B = new Alarm("B", (float) 0.00000, (long) 1 * 60, (long) 20);
        Alarm C = new Alarm("C", (float) 0.00025, (long) 2 * 60, (long) 30);
        Alarm D = new Alarm("D", (float) 0.00015, (long) 2 * 60, (long) 60);
        Alarm E = new Alarm("E", (float) 0.00015, (long) 1 * 60, (long) 30);
        Alarm F = new Alarm("F", (float) 0.00000, (long) 1 * 60, (long) 30);

        // For each alarm, causal relations declaration. (Causal relationship probability, causal delay (sec), delay error (sec))
        HashMap<Alarm, CausalRelation> mapA = new HashMap<>();
        mapA.put(B, new CausalRelation((float) 80, (long) 3 * 60, (long) 10));
        mapA.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapB = new HashMap<>();
        mapB.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapC = new HashMap<>();
        mapC.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(B, new CausalRelation((float) 80, (long) 3 * 60, (long) 5));
        mapC.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapD = new HashMap<>();
        mapD.put(A, new CausalRelation((float) 100, (long) 1 * 60, (long) 10));
        mapD.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapD.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapD.put(E, new CausalRelation((float) 70, (long) 2 * 60, (long) 5));
        mapD.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapE = new HashMap<>();
        mapE.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(F, new CausalRelation((float) 85, (long) 3 * 60, (long) 10));

        HashMap<Alarm, CausalRelation> mapF = new HashMap<>();
        mapF.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));

        retorno.put(A, mapA);
        retorno.put(B, mapB);
        retorno.put(C, mapC);
        retorno.put(D, mapD);
        retorno.put(E, mapE);

        return retorno;
    }

}
