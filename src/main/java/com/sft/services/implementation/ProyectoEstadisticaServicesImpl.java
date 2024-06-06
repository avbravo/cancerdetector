/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.model.Proyecto;
import com.sft.model.User;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.services.ProyectoEstadisticaServices;
import com.sft.services.SprintServices;
import com.sft.services.TarjetaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.ProyectoEstadisticaRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ProyectoEstadisticaServicesImpl implements ProyectoEstadisticaServices {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    
    @Inject
    SprintServices sprintServices;

    @Inject
    TarjetaServices tarjetaServices;

    @Inject
    ProyectoEstadisticaRestClient proyectoEstadisticaRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Double calcularAvance(ProyectoEstadistica proyectoEstadistica)">
    public Double calcularAvance(ProyectoEstadistica proyectoEstadistica) {
        Double result = 0.0;
        try {

            Double finalizadoCount = 0.0;
            Double noTerminadosCount = 0.0;
            Integer noTerminado = proyectoEstadistica.getTotalTarjetasPendiente()
                    + proyectoEstadistica.getTotalTarjetasProgreso()
                    + proyectoEstadistica.getTotalTarjetasBacklog();
            if (proyectoEstadistica.getTotalTarjetasFinalizado() != 0) {
                finalizadoCount = proyectoEstadistica.getTotalTarjetasFinalizado().doubleValue();
            }
            if (noTerminado != 0) {
                noTerminadosCount = noTerminado.doubleValue();
            }
            Double dividendo = (noTerminadosCount + finalizadoCount);
            if (dividendo > 0) {

                result = finalizadoCount / (noTerminadosCount + finalizadoCount);
                if (result < 0) {
                    result = 0.0;
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica showProyectoEstadisticaInList(Proyecto proyecto, List<ProyectoEstadistica> proyectoEstadisticaList ) ">
    @Override
    public ProyectoEstadistica showProyectoEstadisticaInList(Proyecto proyecto, List<ProyectoEstadistica> proyectoEstadisticaList) {
        ProyectoEstadistica proyectoEstadistica = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());
        try {
            if (proyectoEstadisticaList == null || proyectoEstadisticaList.isEmpty()) {
                return proyectoEstadistica;
            } else {
                Optional<ProyectoEstadistica> proyectoEstadisticaOptional = proyectoEstadisticaList.stream().filter(x -> x.getIdproyecto().equals(proyecto.getIdproyecto())).findFirst();
                if (proyectoEstadisticaOptional.isPresent()) {
                    return proyectoEstadisticaOptional.get();
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoEstadistica;
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica calcularEstadistica(Proyecto proyecto))">

    @Override
    public ProyectoEstadistica calcularEstadistica(Proyecto proyecto) {
        ProyectoEstadistica result = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());

        try {
           
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            Document sortSprint = new Document("idsprint", 1); 
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", proyecto.getIdproyecto());
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"),
                    ne("idsprint",0L));

            Long pendiente = tarjetaServices.count(filter, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"));

            Long progreso = tarjetaServices.count(filterProgreso, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterFinalizado = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"));

            Long finalizado = tarjetaServices.count(filterFinalizado, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterBacklog = and(filter0, eq("active", Boolean.TRUE),
                    eq("backlog", true),
                            eq("idsprint",0L));

            Long backlog = tarjetaServices.count(filterBacklog, sortTarjeta, page, size,proyecto.getIdproyecto());
            
            Bson filterSprint0 = eq("proyecto.idproyecto", proyecto.getIdproyecto());
            Bson filterSprint = and(filterSprint0 , eq("active", Boolean.TRUE));

            Long totalSprint = sprintServices.count(filterSprint, sortSprint, page, size);
            
            
            

            result.setTotalTarjetasPendiente(pendiente.intValue());
            result.setTotalTarjetasProgreso(progreso.intValue());
            result.setTotalTarjetasFinalizado(finalizado.intValue());
            result.setTotalTarjetasBacklog(backlog.intValue());
            result.setTotalSprint(totalSprint.intValue());
        } catch (Exception e) {
             
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica calcularMisEstadistica(Proyecto proyecto, User user)">

    @Override
    public ProyectoEstadistica calcularMisEstadistica(Proyecto proyecto, User user) {
        ProyectoEstadistica result = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());

        try {
           
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            Document sortSprint = new Document("idsprint", 1); 
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", proyecto.getIdproyecto());
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                      eq("userView.iduser", user.getIduser()),
                    eq("columna", "pendiente"),
                    ne("idsprint",0L));

            Long pendiente = tarjetaServices.count(filter, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                      eq("userView.iduser", user.getIduser()),
                    eq("columna", "progreso"));

            Long progreso = tarjetaServices.count(filterProgreso, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterFinalizado = and(filter0, eq("active", Boolean.TRUE),
                      eq("userView.iduser", user.getIduser()),
                    eq("columna", "finalizado"));

            Long finalizado = tarjetaServices.count(filterFinalizado, sortTarjeta, page, size,proyecto.getIdproyecto());

            Bson filterBacklog = and(filter0, eq("active", Boolean.TRUE),
                    eq("backlog", true),
                      eq("userView.iduser", user.getIduser()),
                            eq("idsprint",0L));

            Long backlog = tarjetaServices.count(filterBacklog, sortTarjeta, page, size,proyecto.getIdproyecto());
            
            Bson filterSprint0 = eq("proyecto.idproyecto", proyecto.getIdproyecto());
            Bson filterSprint = and(filterSprint0 ,
                  
                    eq("active", Boolean.TRUE));

            Long totalSprint = sprintServices.count(filterSprint, sortSprint, page, size);
            
            
            

            result.setTotalTarjetasPendiente(pendiente.intValue());
            result.setTotalTarjetasProgreso(progreso.intValue());
            result.setTotalTarjetasFinalizado(finalizado.intValue());
            result.setTotalTarjetasBacklog(backlog.intValue());
            result.setTotalSprint(totalSprint.intValue());
        } catch (Exception e) {
             
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
}
