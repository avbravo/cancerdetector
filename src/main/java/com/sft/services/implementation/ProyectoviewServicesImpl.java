/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.ProyectoView;
import com.sft.model.UserView;
import com.sft.services.ProyectoViewServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.sft.restclient.SprintRestClient;
import com.sft.restclient.ProyectoEstadisticaRestClient;
import com.sft.restclient.ProyectoRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ProyectoviewServicesImpl implements ProyectoViewServices {

 // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ProyectoRestClient proyectoRestClient;
    @Inject
    SprintRestClient sprintRestClient;

    @Inject
    ProyectoEstadisticaRestClient proyectoEstadisticaClient;
// </editor-fold>

  // <editor-fold defaultstate="collapsed" desc="ProyectoView convertFromProyecto(Proyecto proyecto)">

    @Override
    public ProyectoView convertFromProyecto(Proyecto proyecto) {
        ProyectoView proyectoView = new ProyectoView();
        try {
            proyectoView.setActive(proyecto.getActive());
            proyectoView.setAvance(proyecto.getAvance());
            proyectoView.setDescripcion(proyecto.getDescripcion());
            proyectoView.setEstado(proyecto.getEstado());
            proyectoView.setFechafinal(proyecto.getFechafinal());
            proyectoView.setFechainicial(proyecto.getFechainicial());
            proyectoView.setIdproyecto(proyecto.getIdproyecto());
            proyectoView.setPrefijo(proyecto.getPrefijo());
            proyectoView.setProyecto(proyecto.getProyecto());
        } catch (Exception e) {
          FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoView;
    }
   // </editor-fold>


    
    
    
}
