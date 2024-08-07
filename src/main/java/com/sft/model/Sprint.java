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
public class Sprint {

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
    
    @Column(commentary = "")
    private Boolean programado;

    @ViewReferenced(from = "proyecto", localField = "idproyecto")
    private ProyectoView proyectoView;
    
    @Embedded
    private EstadisticaCierre estadisticaCierre;
    @Embedded
    private List<EstadisticaCierreColaborador> estadisticaCierreColaborador;
    
       @Embedded
List<ActionHistory> actionHistory;
    
    @Column
    private Boolean active;
  
    public Sprint() {
    }

    public Sprint(Long idsprint, String sprint, String descripcion, Date fechainicial, Date fechafinal, Boolean open, Boolean programado, ProyectoView proyectoView, EstadisticaCierre estadisticaCierre, List<EstadisticaCierreColaborador> estadisticaCierreColaborador, List<ActionHistory> actionHistory, Boolean active) {
        this.idsprint = idsprint;
        this.sprint = sprint;
        this.descripcion = descripcion;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.open = open;
        this.programado = programado;
        this.proyectoView = proyectoView;
        this.estadisticaCierre = estadisticaCierre;
        this.estadisticaCierreColaborador = estadisticaCierreColaborador;
        this.actionHistory = actionHistory;
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

    public ProyectoView getProyectoView() {
        return proyectoView;
    }

    public void setProyectoView(ProyectoView proyectoView) {
        this.proyectoView = proyectoView;
    }

    public EstadisticaCierre getEstadisticaCierre() {
        return estadisticaCierre;
    }

    public void setEstadisticaCierre(EstadisticaCierre estadisticaCierre) {
        this.estadisticaCierre = estadisticaCierre;
    }

    public List<EstadisticaCierreColaborador> getEstadisticaCierreColaborador() {
        return estadisticaCierreColaborador;
    }

    public void setEstadisticaCierreColaborador(List<EstadisticaCierreColaborador> estadisticaCierreColaborador) {
        this.estadisticaCierreColaborador = estadisticaCierreColaborador;
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
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idsprint);
        hash = 37 * hash + Objects.hashCode(this.sprint);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.fechainicial);
        hash = 37 * hash + Objects.hashCode(this.fechafinal);
        hash = 37 * hash + Objects.hashCode(this.open);
        hash = 37 * hash + Objects.hashCode(this.programado);
        hash = 37 * hash + Objects.hashCode(this.proyectoView);
        hash = 37 * hash + Objects.hashCode(this.estadisticaCierre);
        hash = 37 * hash + Objects.hashCode(this.estadisticaCierreColaborador);
        hash = 37 * hash + Objects.hashCode(this.actionHistory);
        hash = 37 * hash + Objects.hashCode(this.active);
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
        final Sprint other = (Sprint) obj;
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
        if (!Objects.equals(this.proyectoView, other.proyectoView)) {
            return false;
        }
        if (!Objects.equals(this.estadisticaCierre, other.estadisticaCierre)) {
            return false;
        }
        if (!Objects.equals(this.estadisticaCierreColaborador, other.estadisticaCierreColaborador)) {
            return false;
        }
        if (!Objects.equals(this.actionHistory, other.actionHistory)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }

    @Override
    public String toString() {
        return "Sprint{" + "idsprint=" + idsprint + ", sprint=" + sprint + ", descripcion=" + descripcion + ", fechainicial=" + fechainicial + ", fechafinal=" + fechafinal + ", open=" + open + ", programado=" + programado + ", proyectoView=" + proyectoView + ", estadisticaCierre=" + estadisticaCierre + ", estadisticaCierreColaborador=" + estadisticaCierreColaborador + ", actionHistory=" + actionHistory + ", active=" + active + '}';
    }

    

}
