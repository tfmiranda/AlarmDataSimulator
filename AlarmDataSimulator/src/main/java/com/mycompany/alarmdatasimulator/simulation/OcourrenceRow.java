/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.simulation;

import java.util.Objects;

/**
 *
 * @author Tiago
 */
public class OcourrenceRow {
    
    private String name;
    private String init;
    private String end;
    private String duration;

    public OcourrenceRow() {
    }

    public OcourrenceRow(String name, String init, String end, String duration) {
        this.name = name;
        this.init = init;
        this.end = end;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String register(String sep){
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(sep);
        builder.append(init).append(sep);
        builder.append(end).append(sep);
        builder.append(duration);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.init);
        hash = 89 * hash + Objects.hashCode(this.end);
        hash = 89 * hash + Objects.hashCode(this.duration);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OcourrenceRow other = (OcourrenceRow) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.init, other.init)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        return true;
    }
    
    
    
}
