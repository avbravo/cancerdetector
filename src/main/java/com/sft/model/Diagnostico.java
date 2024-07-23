/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Diagnostico {
       @Id(strategy = GenerationType.AUTO)
    private Long iddiagnostico;
    @Column
    private String diagnostico;
    @Column
    private Boolean activo;

    public Diagnostico() {
    }

    public Diagnostico(Long iddiagnostico, String diagnostico, Boolean activo) {
        this.iddiagnostico = iddiagnostico;
        this.diagnostico = diagnostico;
        this.activo = activo;
    }

    public Long getIddiagnostico() {
        return iddiagnostico;
    }

    public void setIddiagnostico(Long iddiagnostico) {
        this.iddiagnostico = iddiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.iddiagnostico);
        hash = 37 * hash + Objects.hashCode(this.diagnostico);
        hash = 37 * hash + Objects.hashCode(this.activo);
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
        final Diagnostico other = (Diagnostico) obj;
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        if (!Objects.equals(this.iddiagnostico, other.iddiagnostico)) {
            return false;
        }
        return Objects.equals(this.activo, other.activo);
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "iddiagnostico=" + iddiagnostico + ", diagnostico=" + diagnostico + ", activo=" + activo + '}';
    }

 
            
          
}
