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
public class Etiquetadoimagen {
    @Id(strategy = GenerationType.AUTO)
    private Long idetiquetadoimagen;
    
    @Column
    private String etiquetadoimagen;
    
    @Column
    private Boolean activo;    


    public Etiquetadoimagen() {
    }

    public Etiquetadoimagen(Long idetiquetadoimagen, String etiquetadoimagen, Boolean activo) {
        this.idetiquetadoimagen = idetiquetadoimagen;
        this.etiquetadoimagen = etiquetadoimagen;
        this.activo = activo;
    }

    public Long getIdetiquetadoimagen() {
        return idetiquetadoimagen;
    }

    public void setIdetiquetadoimagen(Long idetiquetadoimagen) {
        this.idetiquetadoimagen = idetiquetadoimagen;
    }

    public String getEtiquetadoimagen() {
        return etiquetadoimagen;
    }

    public void setEtiquetadoimagen(String etiquetadoimagen) {
        this.etiquetadoimagen = etiquetadoimagen;
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
        hash = 79 * hash + Objects.hashCode(this.idetiquetadoimagen);
        hash = 79 * hash + Objects.hashCode(this.etiquetadoimagen);
        hash = 79 * hash + Objects.hashCode(this.activo);
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
        final Etiquetadoimagen other = (Etiquetadoimagen) obj;
        if (!Objects.equals(this.etiquetadoimagen, other.etiquetadoimagen)) {
            return false;
        }
        if (!Objects.equals(this.idetiquetadoimagen, other.idetiquetadoimagen)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Etiquetadoimagen{" + "idetiquetadoimagen=" + idetiquetadoimagen + ", etiquetadoimagen=" + etiquetadoimagen + ", activo=" + activo + '}';
    }

   
    
    
}
