/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.Ignore;
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
public class Proyecto {

   @Id(strategy = GenerationType.AUTO)
    private Long idproyecto;
    @Column
    private String proyecto;
    @Column
    private String descripcion;
    @Referenced(from = "Icono", localField = "idicono")
    private Icono icono;
    @Column
    private String prefijo;

    @Column
    private Date fechafinal;
    @Column
    private Date fechainicial;
    @Column
    private Integer diasAlertaVencimiento;

    @ViewReferenced(from = "departament", localField = "iddepartament")
    List<DepartamentView> departamentView;

    @Referenced(from = "area", localField = "idarea")
    private List<Area> area;

    @Referenced(from = "grupoTipoTarjeta", localField = "idgrupotipotarjeta")
    private List<GrupoTipoTarjeta> grupoTipoTarjeta;

    @Embedded
    List<ProyectoMiembro> proyectoMiembro;

    @Column(commentary = "true indica que el colaborador puede crear tarjetas ")
    private Boolean colaboradorcreartarjeta;

    @Column(commentary = "true indica privado y false indica publico")
    private Boolean privado;

    @Column(commentary = "true indica que para un proyecto privado el colaborador puede ver todas las tarjetas")
    private Boolean showTarjetaPrivado;

    @Column(commentary = "true que puede ver todas las tarjetas en reserva . false indica que solo vera sus reservas")
    private Boolean showTodasReserva;

    @Column(commentary = "true permite crear tarjetas duplicadas en el tablero/backlog")
    private Boolean agregarTarjetaDuplicada;

    @ViewReferenced(from = "central", localField = "idcentral")
    private CentralView centralView;

    @Column
    private Double avance;

    @Column(commentary = "iniciado,detenido, finalizado")
    private String estado;

    @Column
    private Boolean active;

    @Column(commentary = "true cierra los sprint y genera nuevos de manera automatica ")
    private Boolean generarsprintautomaticamente;
    @Column(commentary = "semanal,quincenal, mensual, trimestral, semestral,anual")
    private String periocidiadsprint;

    @Embedded
    List<ActionHistory> actionHistory;

    public Proyecto() {
    }

    public Proyecto(Long idproyecto, String proyecto, String descripcion, Icono icono, String prefijo, Date fechafinal, Date fechainicial, Integer diasAlertaVencimiento, List<DepartamentView> departamentView, List<Area> area, List<GrupoTipoTarjeta> grupoTipoTarjeta, List<ProyectoMiembro> proyectoMiembro, Boolean colaboradorcreartarjeta, Boolean privado, Boolean showTarjetaPrivado, Boolean showTodasReserva, Boolean agregarTarjetaDuplicada, CentralView centralView, Double avance, String estado, Boolean active, Boolean generarsprintautomaticamente, String periocidiadsprint, List<ActionHistory> actionHistory) {
        this.idproyecto = idproyecto;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.icono = icono;
        this.prefijo = prefijo;
        this.fechafinal = fechafinal;
        this.fechainicial = fechainicial;
        this.diasAlertaVencimiento = diasAlertaVencimiento;
        this.departamentView = departamentView;
        this.area = area;
        this.grupoTipoTarjeta = grupoTipoTarjeta;
        this.proyectoMiembro = proyectoMiembro;
        this.colaboradorcreartarjeta = colaboradorcreartarjeta;
        this.privado = privado;
        this.showTarjetaPrivado = showTarjetaPrivado;
        this.showTodasReserva = showTodasReserva;
        this.agregarTarjetaDuplicada = agregarTarjetaDuplicada;
        this.centralView = centralView;
        this.avance = avance;
        this.estado = estado;
        this.active = active;
        this.generarsprintautomaticamente = generarsprintautomaticamente;
        this.periocidiadsprint = periocidiadsprint;
        this.actionHistory = actionHistory;
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

    public Icono getIcono() {
        return icono;
    }

    public void setIcono(Icono icono) {
        this.icono = icono;
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

    public List<DepartamentView> getDepartamentView() {
        return departamentView;
    }

    public void setDepartamentView(List<DepartamentView> departamentView) {
        this.departamentView = departamentView;
    }

    public List<Area> getArea() {
        return area;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    public List<GrupoTipoTarjeta> getGrupoTipoTarjeta() {
        return grupoTipoTarjeta;
    }

    public void setGrupoTipoTarjeta(List<GrupoTipoTarjeta> grupoTipoTarjeta) {
        this.grupoTipoTarjeta = grupoTipoTarjeta;
    }

    public List<ProyectoMiembro> getProyectoMiembro() {
        return proyectoMiembro;
    }

    public void setProyectoMiembro(List<ProyectoMiembro> proyectoMiembro) {
        this.proyectoMiembro = proyectoMiembro;
    }

    public Boolean getColaboradorcreartarjeta() {
        return colaboradorcreartarjeta;
    }

    public void setColaboradorcreartarjeta(Boolean colaboradorcreartarjeta) {
        this.colaboradorcreartarjeta = colaboradorcreartarjeta;
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

    public CentralView getCentralView() {
        return centralView;
    }

    public void setCentralView(CentralView centralView) {
        this.centralView = centralView;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    public Integer getDiasAlertaVencimiento() {
        return diasAlertaVencimiento;
    }

    public void setDiasAlertaVencimiento(Integer diasAlertaVencimiento) {
        this.diasAlertaVencimiento = diasAlertaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idproyecto);
        hash = 73 * hash + Objects.hashCode(this.proyecto);
        hash = 73 * hash + Objects.hashCode(this.descripcion);
        hash = 73 * hash + Objects.hashCode(this.icono);
        hash = 73 * hash + Objects.hashCode(this.prefijo);
        hash = 73 * hash + Objects.hashCode(this.fechafinal);
        hash = 73 * hash + Objects.hashCode(this.fechainicial);
        hash = 73 * hash + Objects.hashCode(this.diasAlertaVencimiento);
        hash = 73 * hash + Objects.hashCode(this.departamentView);
        hash = 73 * hash + Objects.hashCode(this.area);
        hash = 73 * hash + Objects.hashCode(this.grupoTipoTarjeta);
        hash = 73 * hash + Objects.hashCode(this.proyectoMiembro);
        hash = 73 * hash + Objects.hashCode(this.colaboradorcreartarjeta);
        hash = 73 * hash + Objects.hashCode(this.privado);
        hash = 73 * hash + Objects.hashCode(this.showTarjetaPrivado);
        hash = 73 * hash + Objects.hashCode(this.showTodasReserva);
        hash = 73 * hash + Objects.hashCode(this.agregarTarjetaDuplicada);
        hash = 73 * hash + Objects.hashCode(this.centralView);
        hash = 73 * hash + Objects.hashCode(this.avance);
        hash = 73 * hash + Objects.hashCode(this.estado);
        hash = 73 * hash + Objects.hashCode(this.active);
        hash = 73 * hash + Objects.hashCode(this.generarsprintautomaticamente);
        hash = 73 * hash + Objects.hashCode(this.periocidiadsprint);
        hash = 73 * hash + Objects.hashCode(this.actionHistory);
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
        final Proyecto other = (Proyecto) obj;
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
        if (!Objects.equals(this.icono, other.icono)) {
            return false;
        }
        if (!Objects.equals(this.fechafinal, other.fechafinal)) {
            return false;
        }
        if (!Objects.equals(this.fechainicial, other.fechainicial)) {
            return false;
        }
        if (!Objects.equals(this.diasAlertaVencimiento, other.diasAlertaVencimiento)) {
            return false;
        }
        if (!Objects.equals(this.departamentView, other.departamentView)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.grupoTipoTarjeta, other.grupoTipoTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.proyectoMiembro, other.proyectoMiembro)) {
            return false;
        }
        if (!Objects.equals(this.colaboradorcreartarjeta, other.colaboradorcreartarjeta)) {
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
        if (!Objects.equals(this.centralView, other.centralView)) {
            return false;
        }
        if (!Objects.equals(this.avance, other.avance)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.generarsprintautomaticamente, other.generarsprintautomaticamente)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idproyecto=" + idproyecto + ", proyecto=" + proyecto + ", descripcion=" + descripcion + ", icono=" + icono + ", prefijo=" + prefijo + ", fechafinal=" + fechafinal + ", fechainicial=" + fechainicial + ", diasAlertaVencimiento=" + diasAlertaVencimiento + ", departamentView=" + departamentView + ", area=" + area + ", grupoTipoTarjeta=" + grupoTipoTarjeta + ", proyectoMiembro=" + proyectoMiembro + ", colaboradorcreartarjeta=" + colaboradorcreartarjeta + ", privado=" + privado + ", showTarjetaPrivado=" + showTarjetaPrivado + ", showTodasReserva=" + showTodasReserva + ", agregarTarjetaDuplicada=" + agregarTarjetaDuplicada + ", centralView=" + centralView + ", avance=" + avance + ", estado=" + estado + ", active=" + active + ", generarsprintautomaticamente=" + generarsprintautomaticamente + ", periocidiadsprint=" + periocidiadsprint + ", actionHistory=" + actionHistory + '}';
    }

    
    
    
}
