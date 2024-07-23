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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Entity
public class Analisis {

     
    @Id(strategy = GenerationType.OBJECTID)
    private ObjectId _id;

    @Column()
    private Date fecha;

    @Column
    private Double nhc;


    @Embedded
    private User user;

    @Column
    private Long numeromuestra;

    @Column
    private Double edad;

    @Embedded
    private Motivo motivo;

    @Embedded
    private Coordenadas coordenadas;
    
    @Embedded
    private Diagnostico diagnostico;

    @Embedded
    private List<Pcrits> pcrits;

    @Column
    private Double ctpcrpositiva;

    @Embedded
    private List<Etiquetadoimagen> etiquetadoimagen;
 
    @Embedded
    private PresenciaLeucocitos presenciaLeucocitos;
    
    @Embedded
    private PresenciaEpitales presenciaEpitales;
    
    @Embedded
    private PresenciaLevaduras presenciaLevaduras;
    
    
    @Column
    private Integer escalanuggetobservador;
    
    @Embedded
    private List<Resultadocultivo> resultadocultivo;
    

    
    @Embedded
    private List<Archivo> archivo;
    @Column
    private Boolean imagen11cultivo;
    
    
    @Column(commentary = "Buena, Regular,Mala")
    private String calidadtincion;
    
    @Column(commentary = "No pedido, Negativo, Contaminada, Positivo")
    private String cultivoorina;
    @Column
    private Boolean imagencondiscrepancia;
    
    @Column
    private String recuentocrecimientoplacahongos;
    
    
    

    public Analisis() {
    }

    public Analisis(ObjectId _id, Date fecha, Double nhc, User user, Long numeromuestra, Double edad, Motivo motivo, Coordenadas coordenadas, Diagnostico diagnostico, List<Pcrits> pcrits, Double ctpcrpositiva, List<Etiquetadoimagen> etiquetadoimagen, PresenciaLeucocitos presenciaLeucocitos, PresenciaEpitales presenciaEpitales, PresenciaLevaduras presenciaLevaduras, Integer escalanuggetobservador, List<Resultadocultivo> resultadocultivo, List<Archivo> archivo, Boolean imagen11cultivo, String calidadtincion, String cultivoorina, Boolean imagencondiscrepancia, String recuentocrecimientoplacahongos) {
        this._id = _id;
        this.fecha = fecha;
        this.nhc = nhc;
        this.user = user;
        this.numeromuestra = numeromuestra;
        this.edad = edad;
        this.motivo = motivo;
        this.coordenadas = coordenadas;
        this.diagnostico = diagnostico;
        this.pcrits = pcrits;
        this.ctpcrpositiva = ctpcrpositiva;
        this.etiquetadoimagen = etiquetadoimagen;
        this.presenciaLeucocitos = presenciaLeucocitos;
        this.presenciaEpitales = presenciaEpitales;
        this.presenciaLevaduras = presenciaLevaduras;
        this.escalanuggetobservador = escalanuggetobservador;
        this.resultadocultivo = resultadocultivo;
        this.archivo = archivo;
        this.imagen11cultivo = imagen11cultivo;
        this.calidadtincion = calidadtincion;
        this.cultivoorina = cultivoorina;
        this.imagencondiscrepancia = imagencondiscrepancia;
        this.recuentocrecimientoplacahongos = recuentocrecimientoplacahongos;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getNhc() {
        return nhc;
    }

    public void setNhc(Double nhc) {
        this.nhc = nhc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getNumeromuestra() {
        return numeromuestra;
    }

    public void setNumeromuestra(Long numeromuestra) {
        this.numeromuestra = numeromuestra;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<Pcrits> getPcrits() {
        return pcrits;
    }

    public void setPcrits(List<Pcrits> pcrits) {
        this.pcrits = pcrits;
    }

    public Double getCtpcrpositiva() {
        return ctpcrpositiva;
    }

    public void setCtpcrpositiva(Double ctpcrpositiva) {
        this.ctpcrpositiva = ctpcrpositiva;
    }

    public List<Etiquetadoimagen> getEtiquetadoimagen() {
        return etiquetadoimagen;
    }

    public void setEtiquetadoimagen(List<Etiquetadoimagen> etiquetadoimagen) {
        this.etiquetadoimagen = etiquetadoimagen;
    }

    public PresenciaLeucocitos getPresenciaLeucocitos() {
        return presenciaLeucocitos;
    }

    public void setPresenciaLeucocitos(PresenciaLeucocitos presenciaLeucocitos) {
        this.presenciaLeucocitos = presenciaLeucocitos;
    }

    public PresenciaEpitales getPresenciaEpitales() {
        return presenciaEpitales;
    }

    public void setPresenciaEpitales(PresenciaEpitales presenciaEpitales) {
        this.presenciaEpitales = presenciaEpitales;
    }

    public PresenciaLevaduras getPresenciaLevaduras() {
        return presenciaLevaduras;
    }

    public void setPresenciaLevaduras(PresenciaLevaduras presenciaLevaduras) {
        this.presenciaLevaduras = presenciaLevaduras;
    }

    public Integer getEscalanuggetobservador() {
        return escalanuggetobservador;
    }

    public void setEscalanuggetobservador(Integer escalanuggetobservador) {
        this.escalanuggetobservador = escalanuggetobservador;
    }

    public List<Resultadocultivo> getResultadocultivo() {
        return resultadocultivo;
    }

    public void setResultadocultivo(List<Resultadocultivo> resultadocultivo) {
        this.resultadocultivo = resultadocultivo;
    }

    public List<Archivo> getArchivo() {
        return archivo;
    }

    public void setArchivo(List<Archivo> archivo) {
        this.archivo = archivo;
    }

    public Boolean getImagen11cultivo() {
        return imagen11cultivo;
    }

    public void setImagen11cultivo(Boolean imagen11cultivo) {
        this.imagen11cultivo = imagen11cultivo;
    }

    public String getCalidadtincion() {
        return calidadtincion;
    }

    public void setCalidadtincion(String calidadtincion) {
        this.calidadtincion = calidadtincion;
    }

    public String getCultivoorina() {
        return cultivoorina;
    }

    public void setCultivoorina(String cultivoorina) {
        this.cultivoorina = cultivoorina;
    }

    public Boolean getImagencondiscrepancia() {
        return imagencondiscrepancia;
    }

    public void setImagencondiscrepancia(Boolean imagencondiscrepancia) {
        this.imagencondiscrepancia = imagencondiscrepancia;
    }

    public String getRecuentocrecimientoplacahongos() {
        return recuentocrecimientoplacahongos;
    }

    public void setRecuentocrecimientoplacahongos(String recuentocrecimientoplacahongos) {
        this.recuentocrecimientoplacahongos = recuentocrecimientoplacahongos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this._id);
        hash = 67 * hash + Objects.hashCode(this.fecha);
        hash = 67 * hash + Objects.hashCode(this.nhc);
        hash = 67 * hash + Objects.hashCode(this.user);
        hash = 67 * hash + Objects.hashCode(this.numeromuestra);
        hash = 67 * hash + Objects.hashCode(this.edad);
        hash = 67 * hash + Objects.hashCode(this.motivo);
        hash = 67 * hash + Objects.hashCode(this.coordenadas);
        hash = 67 * hash + Objects.hashCode(this.diagnostico);
        hash = 67 * hash + Objects.hashCode(this.pcrits);
        hash = 67 * hash + Objects.hashCode(this.ctpcrpositiva);
        hash = 67 * hash + Objects.hashCode(this.etiquetadoimagen);
        hash = 67 * hash + Objects.hashCode(this.presenciaLeucocitos);
        hash = 67 * hash + Objects.hashCode(this.presenciaEpitales);
        hash = 67 * hash + Objects.hashCode(this.presenciaLevaduras);
        hash = 67 * hash + Objects.hashCode(this.escalanuggetobservador);
        hash = 67 * hash + Objects.hashCode(this.resultadocultivo);
        hash = 67 * hash + Objects.hashCode(this.archivo);
        hash = 67 * hash + Objects.hashCode(this.imagen11cultivo);
        hash = 67 * hash + Objects.hashCode(this.calidadtincion);
        hash = 67 * hash + Objects.hashCode(this.cultivoorina);
        hash = 67 * hash + Objects.hashCode(this.imagencondiscrepancia);
        hash = 67 * hash + Objects.hashCode(this.recuentocrecimientoplacahongos);
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
        final Analisis other = (Analisis) obj;
        if (!Objects.equals(this.calidadtincion, other.calidadtincion)) {
            return false;
        }
        if (!Objects.equals(this.cultivoorina, other.cultivoorina)) {
            return false;
        }
        if (!Objects.equals(this.recuentocrecimientoplacahongos, other.recuentocrecimientoplacahongos)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.nhc, other.nhc)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.numeromuestra, other.numeromuestra)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.coordenadas, other.coordenadas)) {
            return false;
        }
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        if (!Objects.equals(this.pcrits, other.pcrits)) {
            return false;
        }
        if (!Objects.equals(this.ctpcrpositiva, other.ctpcrpositiva)) {
            return false;
        }
        if (!Objects.equals(this.etiquetadoimagen, other.etiquetadoimagen)) {
            return false;
        }
        if (!Objects.equals(this.presenciaLeucocitos, other.presenciaLeucocitos)) {
            return false;
        }
        if (!Objects.equals(this.presenciaEpitales, other.presenciaEpitales)) {
            return false;
        }
        if (!Objects.equals(this.presenciaLevaduras, other.presenciaLevaduras)) {
            return false;
        }
        if (!Objects.equals(this.escalanuggetobservador, other.escalanuggetobservador)) {
            return false;
        }
        if (!Objects.equals(this.resultadocultivo, other.resultadocultivo)) {
            return false;
        }
        if (!Objects.equals(this.archivo, other.archivo)) {
            return false;
        }
        if (!Objects.equals(this.imagen11cultivo, other.imagen11cultivo)) {
            return false;
        }
        return Objects.equals(this.imagencondiscrepancia, other.imagencondiscrepancia);
    }

    @Override
    public String toString() {
        return "Analisis{" + "_id=" + _id + ", fecha=" + fecha + ", nhc=" + nhc + ", user=" + user + ", numeromuestra=" + numeromuestra + ", edad=" + edad + ", motivo=" + motivo + ", coordenadas=" + coordenadas + ", diagnostico=" + diagnostico + ", pcrits=" + pcrits + ", ctpcrpositiva=" + ctpcrpositiva + ", etiquetadoimagen=" + etiquetadoimagen + ", presenciaLeucocitos=" + presenciaLeucocitos + ", presenciaEpitales=" + presenciaEpitales + ", presenciaLevaduras=" + presenciaLevaduras + ", escalanuggetobservador=" + escalanuggetobservador + ", resultadocultivo=" + resultadocultivo + ", archivo=" + archivo + ", imagen11cultivo=" + imagen11cultivo + ", calidadtincion=" + calidadtincion + ", cultivoorina=" + cultivoorina + ", imagencondiscrepancia=" + imagencondiscrepancia + ", recuentocrecimientoplacahongos=" + recuentocrecimientoplacahongos + '}';
    }

    
    
    
    
}
