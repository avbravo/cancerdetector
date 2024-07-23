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
public class Motivo {
    @Id(strategy = GenerationType.AUTO)
    private Long idmotivo;
    
    @Column
    private String motivo;
    
    @Column
    private Boolean activo;    


    public Motivo() {
    }

    public Motivo(Long idmotivo, String motivo, Boolean activo) {
        this.idmotivo = idmotivo;
        this.motivo = motivo;
        this.activo = activo;
    }

    public Long getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Long idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.idmotivo);
        hash = 47 * hash + Objects.hashCode(this.motivo);
        hash = 47 * hash + Objects.hashCode(this.activo);
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
        final Motivo other = (Motivo) obj;
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.idmotivo, other.idmotivo)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Motivo{" + "idmotivo=" + idmotivo + ", motivo=" + motivo + ", activo=" + activo + '}';
    }

    
    
    
    
    
}
