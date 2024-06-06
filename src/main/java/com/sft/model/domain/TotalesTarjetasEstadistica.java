/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model.domain;

import com.jmoordb.core.annotation.Domain;

/**
 *
 * @author avbravo
 */
@Domain(commentary = "Contiene totales de tarjetas generalmente para usar en el dashboard")
public class TotalesTarjetasEstadistica {
    private Long totalTarjetasBacklog;
    private Long totalTarjetasPendiente;
    private Long totalTarjetasProgreso;
    private Long totalTarjetasFinalizado;
    private Long iduser;

    public TotalesTarjetasEstadistica() {
    }

    
    
    
    public TotalesTarjetasEstadistica(Long totalTarjetasBacklog, Long totalTarjetasPendiente, Long totalTarjetasProgreso, Long totalTarjetasFinalizado, Long iduser) {
        this.totalTarjetasBacklog = totalTarjetasBacklog;
        this.totalTarjetasPendiente = totalTarjetasPendiente;
        this.totalTarjetasProgreso = totalTarjetasProgreso;
        this.totalTarjetasFinalizado = totalTarjetasFinalizado;
        this.iduser = iduser;
    }

    public Long getTotalTarjetasBacklog() {
        return totalTarjetasBacklog;
    }

    public void setTotalTarjetasBacklog(Long totalTarjetasBacklog) {
        this.totalTarjetasBacklog = totalTarjetasBacklog;
    }

    public Long getTotalTarjetasPendiente() {
        return totalTarjetasPendiente;
    }

    public void setTotalTarjetasPendiente(Long totalTarjetasPendiente) {
        this.totalTarjetasPendiente = totalTarjetasPendiente;
    }

    public Long getTotalTarjetasProgreso() {
        return totalTarjetasProgreso;
    }

    public void setTotalTarjetasProgreso(Long totalTarjetasProgreso) {
        this.totalTarjetasProgreso = totalTarjetasProgreso;
    }

    public Long getTotalTarjetasFinalizado() {
        return totalTarjetasFinalizado;
    }

    public void setTotalTarjetasFinalizado(Long totalTarjetasFinalizado) {
        this.totalTarjetasFinalizado = totalTarjetasFinalizado;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "TotalesTarjetas{" + "totalTarjetasBacklog=" + totalTarjetasBacklog + ", totalTarjetasPendiente=" + totalTarjetasPendiente + ", totalTarjetasProgreso=" + totalTarjetasProgreso + ", totalTarjetasFinalizado=" + totalTarjetasFinalizado + ", iduser=" + iduser + '}';
    }
    
    
    
    
    
}
