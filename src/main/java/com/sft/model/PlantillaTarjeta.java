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
public class PlantillaTarjeta {

   @Id(strategy = GenerationType.AUTO)
    private Long idplantillaterjeta;
    @Column
    private Long iduser;
    @Column
    private String plantilla;
    @Column
    private String descripcion;
    
    @Referenced(from = "grupoTipoTarjeta", localField = "idgrupotipotarjeta")
    private GrupoTipoTarjeta grupoTipoTarjeta;

    @Column
    private Boolean active;
    
    @Embedded
    private Tarjeta tarjeta;

    @Embedded
    List<ActionHistory> actionHistory;

    public PlantillaTarjeta() {
    }

    public PlantillaTarjeta(Long idplantillaterjeta, Long iduser, String plantilla, String descripcion, GrupoTipoTarjeta grupoTipoTarjeta, Boolean active, Tarjeta tarjeta, List<ActionHistory> actionHistory) {
        this.idplantillaterjeta = idplantillaterjeta;
        this.iduser = iduser;
        this.plantilla = plantilla;
        this.descripcion = descripcion;
        this.grupoTipoTarjeta = grupoTipoTarjeta;
        this.active = active;
        this.tarjeta = tarjeta;
        this.actionHistory = actionHistory;
    }

    public Long getIdplantillaterjeta() {
        return idplantillaterjeta;
    }

    public void setIdplantillaterjeta(Long idplantillaterjeta) {
        this.idplantillaterjeta = idplantillaterjeta;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
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
        hash = 97 * hash + Objects.hashCode(this.idplantillaterjeta);
        hash = 97 * hash + Objects.hashCode(this.iduser);
        hash = 97 * hash + Objects.hashCode(this.plantilla);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.grupoTipoTarjeta);
        hash = 97 * hash + Objects.hashCode(this.active);
        hash = 97 * hash + Objects.hashCode(this.tarjeta);
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
        final PlantillaTarjeta other = (PlantillaTarjeta) obj;
        if (!Objects.equals(this.plantilla, other.plantilla)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.idplantillaterjeta, other.idplantillaterjeta)) {
            return false;
        }
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        if (!Objects.equals(this.grupoTipoTarjeta, other.grupoTipoTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "PlantillaTarjeta{" + "idplantillaterjeta=" + idplantillaterjeta + ", iduser=" + iduser + ", plantilla=" + plantilla + ", descripcion=" + descripcion + ", grupoTipoTarjeta=" + grupoTipoTarjeta + ", active=" + active + ", tarjeta=" + tarjeta + ", actionHistory=" + actionHistory + '}';
    }

   
    
    
    
}
