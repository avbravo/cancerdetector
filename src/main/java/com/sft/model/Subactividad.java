/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Subactividad {

    @Id(strategy = GenerationType.AUTO)
    private Long idsubactividad;
    @Column
    private String codigo;
    @Column
    private String subactividad;
    @Column
    private Integer anio;
    @Column
    private Boolean active;

    @Referenced(from = "actividad", localField = "idactividad")
    Actividad actividad;

       @Embedded
List<ActionHistory> actionHistory;
    public Subactividad() {
    }

    public Subactividad(Long idsubactividad, String codigo, String subactividad, Integer anio, Boolean active, Actividad actividad, List<ActionHistory> actionHistory) {
        this.idsubactividad = idsubactividad;
        this.codigo = codigo;
        this.subactividad = subactividad;
        this.anio = anio;
        this.active = active;
        this.actividad = actividad;
        this.actionHistory = actionHistory;
    }

    public Long getIdsubactividad() {
        return idsubactividad;
    }

    public void setIdsubactividad(Long idsubactividad) {
        this.idsubactividad = idsubactividad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSubactividad() {
        return subactividad;
    }

    public void setSubactividad(String subactividad) {
        this.subactividad = subactividad;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subactividad{");
        sb.append("idsubactividad=").append(idsubactividad);
        sb.append(", codigo=").append(codigo);
        sb.append(", subactividad=").append(subactividad);
        sb.append(", anio=").append(anio);
        sb.append(", active=").append(active);
        sb.append(", actividad=").append(actividad);
        sb.append(", actionHistory=").append(actionHistory);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idsubactividad);
        hash = 73 * hash + Objects.hashCode(this.codigo);
        hash = 73 * hash + Objects.hashCode(this.subactividad);
        hash = 73 * hash + Objects.hashCode(this.anio);
        hash = 73 * hash + Objects.hashCode(this.active);
        hash = 73 * hash + Objects.hashCode(this.actividad);
        hash = 73 * hash + Objects.hashCode(this.actionHistory);
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
        final Subactividad other = (Subactividad) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.subactividad, other.subactividad)) {
            return false;
        }
        if (!Objects.equals(this.idsubactividad, other.idsubactividad)) {
            return false;
        }
        if (!Objects.equals(this.anio, other.anio)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

   
    
    

}
