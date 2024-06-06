/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Proyecto;
import com.sft.model.User;
import com.sft.model.domain.ProyectoEstadistica;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface ProyectoEstadisticaServices {

    public Double calcularAvance(ProyectoEstadistica proyectoEstadistica);

    public ProyectoEstadistica showProyectoEstadisticaInList(Proyecto proyecto, List<ProyectoEstadistica> proyectoEstadisticaList);

    public ProyectoEstadistica calcularEstadistica(Proyecto proyecto);

    public ProyectoEstadistica calcularMisEstadistica(Proyecto proyecto, User user);
}
