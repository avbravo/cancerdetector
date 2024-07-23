/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Resultadocultivo{
    @Id(strategy = GenerationType.AUTO)
    private Long idresultadocultivo;
    
    @Column
    private String resultadocultivo;
    
    @Column
    private Boolean activo;    

    public Resultadocultivo() {
    }

    public Resultadocultivo(Long idresultadocultivo, String resultadocultivo, Boolean activo) {
        this.idresultadocultivo = idresultadocultivo;
        this.resultadocultivo = resultadocultivo;
        this.activo = activo;
    }

    public Long getIdresultadocultivo() {
        return idresultadocultivo;
    }

    public void setIdresultadocultivo(Long idresultadocultivo) {
        this.idresultadocultivo = idresultadocultivo;
    }

    public String getResultadocultivo() {
        return resultadocultivo;
    }

    public void setResultadocultivo(String resultadocultivo) {
        this.resultadocultivo = resultadocultivo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idresultadocultivo);
        hash = 29 * hash + Objects.hashCode(this.resultadocultivo);
        hash = 29 * hash + Objects.hashCode(this.activo);
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
        final Resultadocultivo other = (Resultadocultivo) obj;
        if (!Objects.equals(this.resultadocultivo, other.resultadocultivo)) {
            return false;
        }
        if (!Objects.equals(this.idresultadocultivo, other.idresultadocultivo)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Resultadocultivo{" + "idresultadocultivo=" + idresultadocultivo + ", resultadocultivo=" + resultadocultivo + ", activo=" + activo + '}';
    }


   
    
    
    
    
    
}
