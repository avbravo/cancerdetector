/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Referenced;
import com.jmoordb.core.annotation.ViewEntity;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@ViewEntity(collection = "proyecto")
public class ProyectoView {
     
     @Id(strategy = GenerationType.AUTO)
    private Long idproyecto;
    @Column
    private String proyecto;
    @Column
    private String descripcion;

    @Column
    private String prefijo;

    @Column
    private Date fechafinal;
    @Column
    private Date fechainicial;

    @Referenced(from = "Icono", localField = "idicono")
    private Icono icono;

    @Column
    private Double avance;

    @Column
    private String estado;

    @Column(commentary = "true cierra los sprint y genera nuevos de manera automatica ")
    private Boolean generarsprintautomaticamente;
    @Column(commentary = "semanal,quincenal, mensual, trimestral, semestral,anual")
    private String periocidiadsprint;


    @Column(commentary = "true indica que el colaborador puede crear tarjetas ")
    private Boolean colaboradorcreartarjeta;
    @Column
    private Boolean active;

    @Column(commentary = "true indica privado y false indica publico")
    private Boolean privado;

    @Column(commentary = "true indica que para un proyecto privado el colaborador puede ver todas las tarjetas")
    private Boolean showTarjetaPrivado;
    
      @Column(commentary = "true que puede ver todas las tarjetas en reserva . false indica que solo vera sus reservas")
    private Boolean showTodasReserva;
    
          @Column(commentary = "true permite crear tarjetas duplicadas en el tablero/backlog")
    private Boolean agregarTarjetaDuplicada;

      @Column
    private Integer diasAlertaVencimiento;  
      
    public ProyectoView() {
    }

    public ProyectoView(Long idproyecto, String proyecto, String descripcion, String prefijo, Date fechafinal, Date fechainicial, Icono icono, Double avance, String estado, Boolean generarsprintautomaticamente, String periocidiadsprint, Boolean colaboradorcreartarjeta, Boolean active, Boolean privado, Boolean showTarjetaPrivado, Boolean showTodasReserva, Boolean agregarTarjetaDuplicada, Integer diasAlertaVencimiento) {
        this.idproyecto = idproyecto;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.prefijo = prefijo;
        this.fechafinal = fechafinal;
        this.fechainicial = fechainicial;
        this.icono = icono;
        this.avance = avance;
        this.estado = estado;
        this.generarsprintautomaticamente = generarsprintautomaticamente;
        this.periocidiadsprint = periocidiadsprint;
        this.colaboradorcreartarjeta = colaboradorcreartarjeta;
        this.active = active;
        this.privado = privado;
        this.showTarjetaPrivado = showTarjetaPrivado;
        this.showTodasReserva = showTodasReserva;
        this.agregarTarjetaDuplicada = agregarTarjetaDuplicada;
        this.diasAlertaVencimiento = diasAlertaVencimiento;
    }

    public Long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Long idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Icono getIcono() {
        return icono;
    }

    public void setIcono(Icono icono) {
        this.icono = icono;
    }

    public Double getAvance() {
        return avance;
    }

    public void setAvance(Double avance) {
        this.avance = avance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getGenerarsprintautomaticamente() {
        return generarsprintautomaticamente;
    }

    public void setGenerarsprintautomaticamente(Boolean generarsprintautomaticamente) {
        this.generarsprintautomaticamente = generarsprintautomaticamente;
    }

    public String getPeriocidiadsprint() {
        return periocidiadsprint;
    }

    public void setPeriocidiadsprint(String periocidiadsprint) {
        this.periocidiadsprint = periocidiadsprint;
    }

    public Boolean getColaboradorcreartarjeta() {
        return colaboradorcreartarjeta;
    }

    public void setColaboradorcreartarjeta(Boolean colaboradorcreartarjeta) {
        this.colaboradorcreartarjeta = colaboradorcreartarjeta;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    public Boolean getShowTarjetaPrivado() {
        return showTarjetaPrivado;
    }

    public void setShowTarjetaPrivado(Boolean showTarjetaPrivado) {
        this.showTarjetaPrivado = showTarjetaPrivado;
    }

    public Boolean getShowTodasReserva() {
        return showTodasReserva;
    }

    public void setShowTodasReserva(Boolean showTodasReserva) {
        this.showTodasReserva = showTodasReserva;
    }

    public Boolean getAgregarTarjetaDuplicada() {
        return agregarTarjetaDuplicada;
    }

    public void setAgregarTarjetaDuplicada(Boolean agregarTarjetaDuplicada) {
        this.agregarTarjetaDuplicada = agregarTarjetaDuplicada;
    }

    public Integer getDiasAlertaVencimiento() {
        return diasAlertaVencimiento;
    }

    public void setDiasAlertaVencimiento(Integer diasAlertaVencimiento) {
        this.diasAlertaVencimiento = diasAlertaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idproyecto);
        hash = 97 * hash + Objects.hashCode(this.proyecto);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.prefijo);
        hash = 97 * hash + Objects.hashCode(this.fechafinal);
        hash = 97 * hash + Objects.hashCode(this.fechainicial);
        hash = 97 * hash + Objects.hashCode(this.icono);
        hash = 97 * hash + Objects.hashCode(this.avance);
        hash = 97 * hash + Objects.hashCode(this.estado);
        hash = 97 * hash + Objects.hashCode(this.generarsprintautomaticamente);
        hash = 97 * hash + Objects.hashCode(this.periocidiadsprint);
        hash = 97 * hash + Objects.hashCode(this.colaboradorcreartarjeta);
        hash = 97 * hash + Objects.hashCode(this.active);
        hash = 97 * hash + Objects.hashCode(this.privado);
        hash = 97 * hash + Objects.hashCode(this.showTarjetaPrivado);
        hash = 97 * hash + Objects.hashCode(this.showTodasReserva);
        hash = 97 * hash + Objects.hashCode(this.agregarTarjetaDuplicada);
        hash = 97 * hash + Objects.hashCode(this.diasAlertaVencimiento);
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
        final ProyectoView other = (ProyectoView) obj;
        if (!Objects.equals(this.proyecto, other.proyecto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.prefijo, other.prefijo)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.periocidiadsprint, other.periocidiadsprint)) {
            return false;
        }
        if (!Objects.equals(this.idproyecto, other.idproyecto)) {
            return false;
        }
        if (!Objects.equals(this.fechafinal, other.fechafinal)) {
            return false;
        }
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        if (!Objects.equals(this.icono, other.icono)) {
            return false;
        }
        if (!Objects.equals(this.avance, other.avance)) {
            return false;
        }
        if (!Objects.equals(this.generarsprintautomaticamente, other.generarsprintautomaticamente)) {
            return false;
        }
        if (!Objects.equals(this.colaboradorcreartarjeta, other.colaboradorcreartarjeta)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.privado, other.privado)) {
            return false;
        }
        if (!Objects.equals(this.showTarjetaPrivado, other.showTarjetaPrivado)) {
            return false;
        }
        if (!Objects.equals(this.showTodasReserva, other.showTodasReserva)) {
            return false;
        }
        if (!Objects.equals(this.agregarTarjetaDuplicada, other.agregarTarjetaDuplicada)) {
            return false;
        }
        return Objects.equals(this.diasAlertaVencimiento, other.diasAlertaVencimiento);
    }

    @Override
    public String toString() {
        return "ProyectoView{" + "idproyecto=" + idproyecto + ", proyecto=" + proyecto + ", descripcion=" + descripcion + ", prefijo=" + prefijo + ", fechafinal=" + fechafinal + ", fechainicial=" + fechainicial + ", icono=" + icono + ", avance=" + avance + ", estado=" + estado + ", generarsprintautomaticamente=" + generarsprintautomaticamente + ", periocidiadsprint=" + periocidiadsprint + ", colaboradorcreartarjeta=" + colaboradorcreartarjeta + ", active=" + active + ", privado=" + privado + ", showTarjetaPrivado=" + showTarjetaPrivado + ", showTodasReserva=" + showTodasReserva + ", agregarTarjetaDuplicada=" + agregarTarjetaDuplicada + ", diasAlertaVencimiento=" + diasAlertaVencimiento + '}';
    }

   
   
    

}
