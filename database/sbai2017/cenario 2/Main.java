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
        Map<Alarm, Map<Alarm, CausalRelation>> relations = getCenarioTeste2();   // Relations map
        SimulationExecutor exec = new SimulationExecutor(relations);

        DateTime init = new DateTime(2010, 5, 1, 1, 0, 0);                       // Initial time simulation
        Duration duration = new Duration(init, init.plusMonths(5));              // Duration of simulation, in months
        String result = exec.simulate(init, duration);
        System.out.println(result);                                              // Print result as CSV pattern

    }

    /**
     * Generic industrial alarms scenario
      * @return
     */
    private static Map<Alarm, Map<Alarm, CausalRelation>> getCenarioTeste2() {
        HashMap<Alarm, Map<Alarm, CausalRelation>> retorno = new HashMap<>();

        Alarm A = new Alarm("A", (float) 0.00025, (long) 2 * 60, (long) 10);
        Alarm B = new Alarm("B", (float) 0.00025, (long) 1 * 60, (long) 20);
        Alarm C = new Alarm("C", (float) 0.00000, (long) 2 * 60, (long) 30);
        Alarm D = new Alarm("D", (float) 0.00025, (long) 2 * 60, (long) 60);
        Alarm E = new Alarm("E", (float) 0.00025, (long) 1 * 60, (long) 30);
        Alarm F = new Alarm("F", (float) 0.00025, (long) 2 * 60, (long) 30);
        Alarm G = new Alarm("G", (float) 0.00000, (long) 1 * 60, (long) 30);

        HashMap<Alarm, CausalRelation> mapA = new HashMap<>();
        mapA.put(B, new CausalRelation((float) 80, (long) 15 * 60, (long) 10));
        mapA.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapA.put(G, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapB = new HashMap<>();
        mapB.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(C, new CausalRelation((float) 90, (long) 25 * 60, (long) 10));
        mapB.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapB.put(G, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapC = new HashMap<>();
        mapC.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapC.put(G, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapD = new HashMap<>();
        mapD.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapD.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapD.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapD.put(E, new CausalRelation((float) 80, (long) 15 * 60, (long) 10));
        mapD.put(F, new CausalRelation((float) 80, (long) 25 * 60, (long) 10));
        mapD.put(G, new CausalRelation((float) 0, (long) 0, (long) 0));

        HashMap<Alarm, CausalRelation> mapE = new HashMap<>();
        mapE.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapE.put(G, new CausalRelation((float) 90, (long) 35 * 60, (long) 10));

        HashMap<Alarm, CausalRelation> mapF = new HashMap<>();
        mapF.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapF.put(G, new CausalRelation((float) 90, (long) 40 * 60, (long) 10));

        HashMap<Alarm, CausalRelation> mapG = new HashMap<>();
        mapG.put(A, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapG.put(B, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapG.put(C, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapG.put(D, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapG.put(E, new CausalRelation((float) 0, (long) 0, (long) 0));
        mapG.put(F, new CausalRelation((float) 0, (long) 0, (long) 0));

        retorno.put(A, mapA);
        retorno.put(B, mapB);
        retorno.put(C, mapC);
        retorno.put(D, mapD);
        retorno.put(E, mapE);
        retorno.put(F, mapF);
        retorno.put(G, mapG);

        return retorno;
    }

}
