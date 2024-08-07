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
public class Tipotarjeta {
@Id(strategy = GenerationType.AUTO)
private Long idtipotarjeta;
@Column
private String tipotarjeta;

@Referenced(from = "grupoTipoTarjeta", localField = "idgrupotipotarjeta")
private GrupoTipoTarjeta grupoTipoTarjeta;


@Column
private Boolean active;

@Embedded
List<ActionHistory> actionHistory;
    public Tipotarjeta() {
    }

    public Long getIdtipotarjeta() {
        return idtipotarjeta;
    }

    public void setIdtipotarjeta(Long idtipotarjeta) {
        this.idtipotarjeta = idtipotarjeta;
    }

    public String getTipotarjeta() {
        return tipotarjeta;
    }

    public void setTipotarjeta(String tipotarjeta) {
        this.tipotarjeta = tipotarjeta;
    }

    public GrupoTipoTarjeta getGrupoTipoTarjeta() {
        return grupoTipoTarjeta;
    }

    public void setGrupoTipoTarjeta(GrupoTipoTarjeta grupoTipoTarjeta) {
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idtipotarjeta);
        hash = 97 * hash + Objects.hashCode(this.tipotarjeta);
        hash = 97 * hash + Objects.hashCode(this.grupoTipoTarjeta);
        hash = 97 * hash + Objects.hashCode(this.active);
        hash = 97 * hash + Objects.hashCode(this.actionHistory);
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
        final Tipotarjeta other = (Tipotarjeta) obj;
        if (!Objects.equals(this.tipotarjeta, other.tipotarjeta)) {
            return false;
        }
        if (!Objects.equals(this.idtipotarjeta, other.idtipotarjeta)) {
            return false;
        }
        if (!Objects.equals(this.grupoTipoTarjeta, other.grupoTipoTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "Tipotarjeta{" + "idtipotarjeta=" + idtipotarjeta + ", tipotarjeta=" + tipotarjeta + ", grupoTipoTarjeta=" + grupoTipoTarjeta + ", active=" + active + ", actionHistory=" + actionHistory + '}';
    }


}
