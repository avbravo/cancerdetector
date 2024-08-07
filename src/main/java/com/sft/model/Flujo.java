/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewReferenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Flujo {
    @Id(strategy = GenerationType.AUTO)
    private Long idflujo;
    @Column
    private String flujo;
    @Column
    private String descripcion;
    @Column
    private Date fechainicio;
    @Column
    private Date fechafin;
    
    @ViewReferenced(from = "tarjeta",localField = "idtarjeta")
    private List<Tarjeta> tarjeta;
    
    @ViewReferenced(from="user",localField ="iduser")
    private UserView userView;
    
    @ViewReferenced(from="proyecto", localField = "idproyecto")
    private ProyectoView proyectoView;

    
     @Embedded
    List<ActionHistory> actionHistory;
    
    @Column
    private Boolean active;
    
    public Flujo() {
    }

    public Flujo(Long idflujo, String flujo, String descripcion, Date fechainicio, Date fechafin, List<Tarjeta> tarjeta, UserView userView, ProyectoView proyectoView, List<ActionHistory> actionHistory, Boolean active) {
        this.idflujo = idflujo;
        this.flujo = flujo;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.tarjeta = tarjeta;
        this.userView = userView;
        this.proyectoView = proyectoView;
        this.actionHistory = actionHistory;
        this.active = active;
    }

    public Long getIdflujo() {
        return idflujo;
    }

    public void setIdflujo(Long idflujo) {
        this.idflujo = idflujo;
    }

    public String getFlujo() {
        return flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public List<Tarjeta> getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(List<Tarjeta> tarjeta) {
        this.tarjeta = tarjeta;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public ProyectoView getProyectoView() {
        return proyectoView;
    }

    public void setProyectoView(ProyectoView proyectoView) {
        this.proyectoView = proyectoView;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idflujo);
        hash = 89 * hash + Objects.hashCode(this.flujo);
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + Objects.hashCode(this.fechainicio);
        hash = 89 * hash + Objects.hashCode(this.fechafin);
        hash = 89 * hash + Objects.hashCode(this.tarjeta);
        hash = 89 * hash + Objects.hashCode(this.userView);
        hash = 89 * hash + Objects.hashCode(this.proyectoView);
        hash = 89 * hash + Objects.hashCode(this.actionHistory);
        hash = 89 * hash + Objects.hashCode(this.active);
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
        final Flujo other = (Flujo) obj;
        if (!Objects.equals(this.flujo, other.flujo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.idflujo, other.idflujo)) {
            return false;
        }
        if (!Objects.equals(this.fechainicio, other.fechainicio)) {
            return false;
        }
        if (!Objects.equals(this.fechafin, other.fechafin)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.userView, other.userView)) {
            return false;
        }
        if (!Objects.equals(this.proyectoView, other.proyectoView)) {
            return false;
        }
        if (!Objects.equals(this.actionHistory, other.actionHistory)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

    @Override
    public String toString() {
        return "Flujo{" + "idflujo=" + idflujo + ", flujo=" + flujo + ", descripcion=" + descripcion + ", fechainicio=" + fechainicio + ", fechafin=" + fechafin + ", tarjeta=" + tarjeta + ", userView=" + userView + ", proyectoView=" + proyectoView + ", actionHistory=" + actionHistory + ", active=" + active + '}';
    }

    
    
    
    
}
