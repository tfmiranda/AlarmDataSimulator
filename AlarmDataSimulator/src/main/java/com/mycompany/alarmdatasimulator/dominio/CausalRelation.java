/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmdatasimulator.dominio;

/**
 *
 * @author Tiago
 */
public class CausalRelation {
    
    private Float probability;
    private Long lag;
    private Long erro;

    public CausalRelation(Float probability, Long lag, Long erro) {
        this.probability = probability;
        this.lag = lag;
        this.erro = erro;
    }

    public CausalRelation() {
    }

    public Float getProbability() {
        return probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public Long getLag() {
        return lag;
    }

    public void setLag(Long lag) {
        this.lag = lag;
    }

    public Long getErro() {
        return erro;
    }

    public void setErro(Long erro) {
        this.erro = erro;
    }
    
    
    
}
