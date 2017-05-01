/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.simulation;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Tiago
 */
public class OcourrenceTable {

    private Collection<OcourrenceRow> table;
    private int it;

    public OcourrenceTable() {
        table = new LinkedList<>();
        it = -1;
    }

    public void addOcourrence(String name, String init, String end, String duration) {
        OcourrenceRow ocourrence = new OcourrenceRow(name, init, end, duration);
        table.add(ocourrence);
    }

    public int size() {
        return table.size();
    }

    public void begin() {
        it = -1;
    }

    public boolean hasNext() {
        int nextIt = it + 1;
        return nextIt >= 0 && nextIt < table.size();
    }

    public OcourrenceRow next() throws IllegalAccessException {
        it = it + 1;
        Object row = table.toArray()[it];
        if (row instanceof OcourrenceRow) {
            return (OcourrenceRow) row;
        } else {
            throw new IllegalAccessException("Fail to get next element");
        }
    }

}
