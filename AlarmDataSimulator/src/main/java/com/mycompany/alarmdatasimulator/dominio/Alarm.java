/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.dominio;

import java.util.Objects;

/**
 *
 * @author Tiago
 */
public class Alarm {
    
    private String name;
    private Float ocourrenceProbability;
    private Long duration;
    private Long error;

    public Alarm() {
    }   
    
    public Alarm(String name, Float ocourrenceProbability, Long duration, Long error) {
        this.name = name;
        this.ocourrenceProbability = ocourrenceProbability;
        this.duration = duration;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getOcourrenceProbability() {
        if(ocourrenceProbability < 0) return (float) 0;
        if(ocourrenceProbability > 100) return (float) 100;
        return ocourrenceProbability;
    }

    public void setOcourrenceProbability(Float ocourrenceProbability) {
        this.ocourrenceProbability = ocourrenceProbability;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getError() {
        return error;
    }

    public void setError(Long error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.ocourrenceProbability);
        hash = 59 * hash + Objects.hashCode(this.duration);
        hash = 59 * hash + Objects.hashCode(this.error);
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
        final Alarm other = (Alarm) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    } 
    
}
