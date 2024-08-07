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
public class Pcrits {
    @Id(strategy = GenerationType.AUTO)
    private Long idpcrits;
    
    @Column
    private String pcrits;
    
    @Column
    private Boolean activo;    


    public Pcrits() {
    }

    public Pcrits(Long idpcrits, String pcrits, Boolean activo) {
        this.idpcrits = idpcrits;
        this.pcrits = pcrits;
        this.activo = activo;
    }

    public Long getIdpcrits() {
        return idpcrits;
    }

    public void setIdpcrits(Long idpcrits) {
        this.idpcrits = idpcrits;
    }

    public String getPcrits() {
        return pcrits;
    }

    public void setPcrits(String pcrits) {
        this.pcrits = pcrits;
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
        hash = 53 * hash + Objects.hashCode(this.idpcrits);
        hash = 53 * hash + Objects.hashCode(this.pcrits);
        hash = 53 * hash + Objects.hashCode(this.activo);
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
        final Pcrits other = (Pcrits) obj;
        if (!Objects.equals(this.pcrits, other.pcrits)) {
            return false;
        }
        if (!Objects.equals(this.idpcrits, other.idpcrits)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Pcrits{" + "idpcrits=" + idpcrits + ", pcrits=" + pcrits + ", activo=" + activo + '}';
    }

  
    
    
    
    
}
