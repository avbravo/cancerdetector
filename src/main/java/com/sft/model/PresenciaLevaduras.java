/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.DocumentEmbeddable;
import com.jmoordb.core.annotation.Id;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@DocumentEmbeddable
public class PresenciaLevaduras {

  
    @Column
    private Boolean zero;

    @Column
    private Boolean one;

    @Column
    private Boolean twofour;

    @Column
    private Boolean fivetwentynine;

    @Column
    private Boolean greaterthan30;

    @Column
    private Boolean activo;

    @Column
    private Double valor;

    public PresenciaLevaduras() {
    }

    public PresenciaLevaduras(Boolean zero, Boolean one, Boolean twofour, Boolean fivetwentynine, Boolean greaterthan30, Boolean activo, Double valor) {
        this.zero = zero;
        this.one = one;
        this.twofour = twofour;
        this.fivetwentynine = fivetwentynine;
        this.greaterthan30 = greaterthan30;
        this.activo = activo;
        this.valor = valor;
    }

    public Boolean getZero() {
        return zero;
    }

    public void setZero(Boolean zero) {
        this.zero = zero;
    }

    public Boolean getOne() {
        return one;
    }

    public void setOne(Boolean one) {
        this.one = one;
    }

    public Boolean getTwofour() {
        return twofour;
    }

    public void setTwofour(Boolean twofour) {
        this.twofour = twofour;
    }

    public Boolean getFivetwentynine() {
        return fivetwentynine;
    }

    public void setFivetwentynine(Boolean fivetwentynine) {
        this.fivetwentynine = fivetwentynine;
    }

    public Boolean getGreaterthan30() {
        return greaterthan30;
    }

    public void setGreaterthan30(Boolean greaterthan30) {
        this.greaterthan30 = greaterthan30;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.zero);
        hash = 89 * hash + Objects.hashCode(this.one);
        hash = 89 * hash + Objects.hashCode(this.twofour);
        hash = 89 * hash + Objects.hashCode(this.fivetwentynine);
        hash = 89 * hash + Objects.hashCode(this.greaterthan30);
        hash = 89 * hash + Objects.hashCode(this.activo);
        hash = 89 * hash + Objects.hashCode(this.valor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PresenciaLevaduras other = (PresenciaLevaduras) obj;
        if (!Objects.equals(this.zero, other.zero)) {
            return false;
        }
        if (!Objects.equals(this.one, other.one)) {
            return false;
        }
        if (!Objects.equals(this.twofour, other.twofour)) {
            return false;
        }
        if (!Objects.equals(this.fivetwentynine, other.fivetwentynine)) {
            return false;
        }
        if (!Objects.equals(this.greaterthan30, other.greaterthan30)) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        return Objects.equals(this.valor, other.valor);
    }

    @Override
    public String toString() {
        return "PresenciaLeucocitos{" + "zero=" + zero + ", one=" + one + ", twofour=" + twofour + ", fivetwentynine=" + fivetwentynine + ", greaterthan30=" + greaterthan30 + ", activo=" + activo + ", valor=" + valor + '}';
    }

    
    
    
    
}
