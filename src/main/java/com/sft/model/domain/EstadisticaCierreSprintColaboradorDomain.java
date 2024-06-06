/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model.domain;

import com.jmoordb.core.annotation.Domain;
import com.sft.model.EstadisticaCierreColaborador;
import com.sft.model.Sprint;
import com.sft.model.UserView;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Domain(commentary = "Se usa para calular las estadisticas por colaborador")
public class EstadisticaCierreSprintColaboradorDomain {
    
    private UserView userView;
    private Sprint sprint;
    private EstadisticaCierreColaborador estadisticaCierreColaborador;

    public EstadisticaCierreSprintColaboradorDomain() {
    }

    public EstadisticaCierreSprintColaboradorDomain(UserView userView, Sprint sprint, EstadisticaCierreColaborador estadisticaCierreColaborador) {
        this.userView = userView;
        this.sprint = sprint;
        this.estadisticaCierreColaborador = estadisticaCierreColaborador;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public EstadisticaCierreColaborador getEstadisticaCierreColaborador() {
        return estadisticaCierreColaborador;
    }

    public void setEstadisticaCierreColaborador(EstadisticaCierreColaborador estadisticaCierreColaborador) {
        this.estadisticaCierreColaborador = estadisticaCierreColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.userView);
        hash = 67 * hash + Objects.hashCode(this.sprint);
        hash = 67 * hash + Objects.hashCode(this.estadisticaCierreColaborador);
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
        final EstadisticaCierreSprintColaboradorDomain other = (EstadisticaCierreSprintColaboradorDomain) obj;
        if (!Objects.equals(this.userView, other.userView)) {
            return false;
        }
        if (!Objects.equals(this.sprint, other.sprint)) {
            return false;
        }
        return Objects.equals(this.estadisticaCierreColaborador, other.estadisticaCierreColaborador);
    }

    @Override
    public String toString() {
        return "EstadisticaCierreSprintColaboradorDomain{" + "userView=" + userView + ", sprint=" + sprint + ", estadisticaCierreColaborador=" + estadisticaCierreColaborador + '}';
    }
    
    
}
