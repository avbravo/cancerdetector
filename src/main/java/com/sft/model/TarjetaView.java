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
@ViewEntity(collection = "tarjeta")
public class TarjetaView {

    @Id(strategy = GenerationType.AUTO)
    private Long idtarjeta;
    @Column
    private String tarjeta;
    @Column
    private String descripcion;

  
    @Column
    private Date fechainicial;
    @Column
    private Date fechafinal;

    @Column
    private String prioridad;

    @Column
    private String estimacion;
      @Column
    private Boolean active;
    

    @Column
    private String columna;
    
    @Column(commentary = "true cuando la crea un colaborador que no pertenece al proyecto y es un proyecto publico")
    private Boolean foreaneo;
    


    public TarjetaView() {
    }

    public TarjetaView(Long idtarjeta, String tarjeta, String descripcion, Date fechainicial, Date fechafinal, String prioridad, String estimacion, Boolean active, String columna, Boolean foreaneo) {
        this.idtarjeta = idtarjeta;
        this.tarjeta = tarjeta;
        this.descripcion = descripcion;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.prioridad = prioridad;
        this.estimacion = estimacion;
        this.active = active;
        this.columna = columna;
        this.foreaneo = foreaneo;
    }

    public Long getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(Long idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
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

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstimacion() {
        return estimacion;
    }

    public void setEstimacion(String estimacion) {
        this.estimacion = estimacion;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public Boolean getForeaneo() {
        return foreaneo;
    }

    public void setForeaneo(Boolean foreaneo) {
        this.foreaneo = foreaneo;
    }

    @Override
    public String toString() {
        return "TarjetaView{" + "idtarjeta=" + idtarjeta + ", tarjeta=" + tarjeta + ", descripcion=" + descripcion + ", fechainicial=" + fechainicial + ", fechafinal=" + fechafinal + ", prioridad=" + prioridad + ", estimacion=" + estimacion + ", active=" + active + ", columna=" + columna + ", foreaneo=" + foreaneo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idtarjeta);
        hash = 29 * hash + Objects.hashCode(this.tarjeta);
        hash = 29 * hash + Objects.hashCode(this.descripcion);
        hash = 29 * hash + Objects.hashCode(this.fechainicial);
        hash = 29 * hash + Objects.hashCode(this.fechafinal);
        hash = 29 * hash + Objects.hashCode(this.prioridad);
        hash = 29 * hash + Objects.hashCode(this.estimacion);
        hash = 29 * hash + Objects.hashCode(this.active);
        hash = 29 * hash + Objects.hashCode(this.columna);
        hash = 29 * hash + Objects.hashCode(this.foreaneo);
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
        final TarjetaView other = (TarjetaView) obj;
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.prioridad, other.prioridad)) {
            return false;
        }
        if (!Objects.equals(this.estimacion, other.estimacion)) {
            return false;
        }
        if (!Objects.equals(this.columna, other.columna)) {
            return false;
        }
        if (!Objects.equals(this.idtarjeta, other.idtarjeta)) {
            return false;
        }
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        if (!Objects.equals(this.fechafinal, other.fechafinal)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.foreaneo, other.foreaneo);
    }

  
  
    
    
    
    }
