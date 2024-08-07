/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class GrupoTipoTarjeta {

    @Id(strategy = GenerationType.AUTO)
    private Long idgrupotipotarjeta;
    @Column
    private String grupoTipoTarjeta;

    @Column
    private Boolean active;

    @Embedded
    List<ActionHistory> actionHistory;

    public GrupoTipoTarjeta() {
    }

    public GrupoTipoTarjeta(Long idgrupotipotarjeta, String grupoTipoTarjeta, Boolean active, List<ActionHistory> actionHistory) {
        this.idgrupotipotarjeta = idgrupotipotarjeta;
        this.grupoTipoTarjeta = grupoTipoTarjeta;
        this.active = active;
        this.actionHistory = actionHistory;
    }

    public Long getIdgrupotipotarjeta() {
        return idgrupotipotarjeta;
    }

    public void setIdgrupotipotarjeta(Long idgrupotipotarjeta) {
        this.idgrupotipotarjeta = idgrupotipotarjeta;
    }

    public String getGrupoTipoTarjeta() {
        return grupoTipoTarjeta;
    }

    public void setGrupoTipoTarjeta(String grupoTipoTarjeta) {
        this.grupoTipoTarjeta = grupoTipoTarjeta;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idgrupotipotarjeta);
        hash = 29 * hash + Objects.hashCode(this.grupoTipoTarjeta);
        hash = 29 * hash + Objects.hashCode(this.active);
        hash = 29 * hash + Objects.hashCode(this.actionHistory);
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
        final GrupoTipoTarjeta other = (GrupoTipoTarjeta) obj;
        if (!Objects.equals(this.grupoTipoTarjeta, other.grupoTipoTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.idgrupotipotarjeta, other.idgrupotipotarjeta)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "GrupoTipoTarjeta{" + "idgrupotipotarjeta=" + idgrupotipotarjeta + ", grupoTipoTarjeta=" + grupoTipoTarjeta + ", active=" + active + ", actionHistory=" + actionHistory + '}';
    }

}
