/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewEntity;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@ViewEntity(collection = "sprint")
public class SprintView {

   @Id(strategy = GenerationType.AUTO)
    private Long idsprint;
    @Column
    private String sprint;
    @Column
    private String descripcion;
      @Column
    private Date fechainicial;
    @Column
    private Date fechafinal;
 
    @Column
    private Boolean open;
    @Column
    private Boolean programado;
    @Column
    private Boolean active;


    public SprintView() {
    }

    public SprintView(Long idsprint, String sprint, String descripcion, Date fechainicial, Date fechafinal, Boolean open, Boolean programado, Boolean active) {
        this.idsprint = idsprint;
        this.sprint = sprint;
        this.descripcion = descripcion;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.open = open;
        this.programado = programado;
        this.active = active;
    }

    public Long getIdsprint() {
        return idsprint;
    }

    public void setIdsprint(Long idsprint) {
        this.idsprint = idsprint;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getProgramado() {
        return programado;
    }

    public void setProgramado(Boolean programado) {
        this.programado = programado;
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
        hash = 71 * hash + Objects.hashCode(this.idsprint);
        hash = 71 * hash + Objects.hashCode(this.sprint);
        hash = 71 * hash + Objects.hashCode(this.descripcion);
        hash = 71 * hash + Objects.hashCode(this.fechainicial);
        hash = 71 * hash + Objects.hashCode(this.fechafinal);
        hash = 71 * hash + Objects.hashCode(this.open);
        hash = 71 * hash + Objects.hashCode(this.programado);
        hash = 71 * hash + Objects.hashCode(this.active);
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
        final SprintView other = (SprintView) obj;
        if (!Objects.equals(this.sprint, other.sprint)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.idsprint, other.idsprint)) {
            return false;
        }
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        if (!Objects.equals(this.fechafinal, other.fechafinal)) {
            return false;
        }
        if (!Objects.equals(this.open, other.open)) {
            return false;
        }
        if (!Objects.equals(this.programado, other.programado)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

    @Override
    public String toString() {
        return "SprintView{" + "idsprint=" + idsprint + ", sprint=" + sprint + ", descripcion=" + descripcion + ", fechainicial=" + fechainicial + ", fechafinal=" + fechafinal + ", open=" + open + ", programado=" + programado + ", active=" + active + '}';
    }

    
    
    
    
}
