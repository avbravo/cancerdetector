/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model.domain;

import com.jmoordb.core.annotation.Domain;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Domain(commentary = "Se usa para calular los totales del proyecto")
public class ProyectoEstadistica {

    private Integer totalSprint;
    private Integer totalTarjetasBacklog;
    private Integer totalTarjetasPendiente;
    private Integer totalTarjetasProgreso;
    private Integer totalTarjetasFinalizado;
    private Long idproyecto;

    public ProyectoEstadistica() {
    }

    public ProyectoEstadistica(Integer totalSprint, Integer totalTarjetasBacklog, Integer totalTarjetasPendiente, Integer totalTarjetasProgreso, Integer totalTarjetasFinalizado, Long idproyecto) {
        this.totalSprint = totalSprint;
        this.totalTarjetasBacklog = totalTarjetasBacklog;
        this.totalTarjetasPendiente = totalTarjetasPendiente;
        this.totalTarjetasProgreso = totalTarjetasProgreso;
        this.totalTarjetasFinalizado = totalTarjetasFinalizado;
        this.idproyecto = idproyecto;
    }

    public Integer getTotalSprint() {
        return totalSprint;
    }

    public void setTotalSprint(Integer totalSprint) {
        this.totalSprint = totalSprint;
    }

    public Integer getTotalTarjetasBacklog() {
        return totalTarjetasBacklog;
    }

    public void setTotalTarjetasBacklog(Integer totalTarjetasBacklog) {
        this.totalTarjetasBacklog = totalTarjetasBacklog;
    }

    public Integer getTotalTarjetasPendiente() {
        return totalTarjetasPendiente;
    }

    public void setTotalTarjetasPendiente(Integer totalTarjetasPendiente) {
        this.totalTarjetasPendiente = totalTarjetasPendiente;
    }

    public Integer getTotalTarjetasProgreso() {
        return totalTarjetasProgreso;
    }

    public void setTotalTarjetasProgreso(Integer totalTarjetasProgreso) {
        this.totalTarjetasProgreso = totalTarjetasProgreso;
    }

    public Integer getTotalTarjetasFinalizado() {
        return totalTarjetasFinalizado;
    }

    public void setTotalTarjetasFinalizado(Integer totalTarjetasFinalizado) {
        this.totalTarjetasFinalizado = totalTarjetasFinalizado;
    }

    public Long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Long idproyecto) {
        this.idproyecto = idproyecto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProyectoEstadistica{");
        sb.append("totalSprint=").append(totalSprint);
        sb.append(", totalTarjetasBacklog=").append(totalTarjetasBacklog);
        sb.append(", totalTarjetasPendiente=").append(totalTarjetasPendiente);
        sb.append(", totalTarjetasProgreso=").append(totalTarjetasProgreso);
        sb.append(", totalTarjetasFinalizado=").append(totalTarjetasFinalizado);
        sb.append(", idproyecto=").append(idproyecto);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.totalSprint);
        hash = 67 * hash + Objects.hashCode(this.totalTarjetasBacklog);
        hash = 67 * hash + Objects.hashCode(this.totalTarjetasPendiente);
        hash = 67 * hash + Objects.hashCode(this.totalTarjetasProgreso);
        hash = 67 * hash + Objects.hashCode(this.totalTarjetasFinalizado);
        hash = 67 * hash + Objects.hashCode(this.idproyecto);
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
        final ProyectoEstadistica other = (ProyectoEstadistica) obj;
        if (!Objects.equals(this.totalSprint, other.totalSprint)) {
            return false;
        }
        if (!Objects.equals(this.totalTarjetasBacklog, other.totalTarjetasBacklog)) {
            return false;
        }
        if (!Objects.equals(this.totalTarjetasPendiente, other.totalTarjetasPendiente)) {
            return false;
        }
        if (!Objects.equals(this.totalTarjetasProgreso, other.totalTarjetasProgreso)) {
            return false;
        }
        if (!Objects.equals(this.totalTarjetasFinalizado, other.totalTarjetasFinalizado)) {
            return false;
        }
        return Objects.equals(this.idproyecto, other.idproyecto);
    }

}
