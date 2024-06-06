/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.faces.services.DashboardFacesServices;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.services.IconoServices;
import com.sft.services.PlantillaTarjetaServices;
import com.sft.services.ProyectoEstadisticaServices;
import com.sft.services.ProyectoServices;
import com.sft.services.SprintServices;
import com.sft.services.TarjetaServices;
import com.sft.services.TipotarjetaServices;
import jakarta.enterprise.event.Event;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class SetupFaces implements Serializable {

// <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Event">
    @Inject
    Event<EmailSenderEvent> emailSenderEvent;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    TarjetaServices TarjetaServices;

    @Inject
    DashboardFacesServices dashboardFacesServices;
    @Inject
    IconoServices iconoServices;

    @Inject
    PlantillaTarjetaServices plantillaTarjetaServices;
    @Inject
    ProyectoServices proyectoServices;

    @Inject
    ProyectoEstadisticaServices proyectoEstadisticaServices;

    @Inject
    SprintServices sprintServices;

    @Inject
    TarjetaServices tarjetaServices;
    @Inject
    TipotarjetaServices tipotarjetaServices;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String version1_0_b_40() ">
    public String version1_0_b_40() {
        try {
            ConsoleUtil.test("\t iniciando proceso....");
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("active", Boolean.TRUE);
            Document sort = new Document("idsprint", 1);
            Integer totalRecords = sprintServices.count(filter,
                    sort, 0, 0).intValue();

            for (int i = 1; i < totalRecords; i++) {
                List<Sprint> sprintList = sprintServices.lookup(
                        filter,
                        sort,
                        page, size);
                if (!sprintList.isEmpty()) {
                    for (Sprint s : sprintList) {
                        System.out.println("..... analizando #("+s.getIdsprint()+")");
                        s.setProgramado(Boolean.FALSE);
                        sprintServices.update(s);
                    }

                }
            }

            ConsoleUtil.test("\t finalizando proceso....");
            FacesUtil.successMessage(rf.fromMessage("info.procesofinalizado"));
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String version1_0_b_38() ">
    public String version1_0_b_38() {
        try {
            ConsoleUtil.test("\t iniciando proceso....");
            List<Tarjeta> list = TarjetaServices.findAll();

            Boolean changeTarea = Boolean.FALSE;
            Boolean changeImpedimento = Boolean.FALSE;
            for (Tarjeta t : list) {
                t.setLastModification(t.getActionHistory().getLast().getFecha());
                tarjetaServices.update(t);

            }
            ConsoleUtil.test("\t finalizando proceso....");
            FacesUtil.successMessage(rf.fromMessage("info.procesofinalizado"));
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";

    }
    // </editor-fold>
//    // <editor-fold defaultstate="collapsed" desc="String version1_0_b_26()">
//    public String version1_0_b_26() {
//        try {
//
//            List<Tarjeta> list = TarjetaServices.findAll();
//
//            Boolean changeTarea = Boolean.FALSE;
//            Boolean changeImpedimento = Boolean.FALSE;
//            for (Tarjeta t : list) {
//
//                changeTarea = Boolean.FALSE;
//
//                changeImpedimento = Boolean.FALSE;
//                ConsoleUtil.info("\t{ Procesando ....} " + t.getIdtarjeta());
//                Long iduser = t.getActionHistory().getLast().getIduser();
//                /**
//                 * -
//                 * Actualiza las tareas
//                 */
//                if (t.getTarea() == null || t.getTarea().isEmpty()) {
//
//                } else {
//
//                    for (UserView uv : t.getUserView()) {
//                        if (uv.getIduser().equals(iduser)) {
//                            Integer count = 0;
//                            for (Tarea tr : t.getTarea()) {
//                                tr.setOrden(count++);
//                                tr.setUserView(uv);
//                            }
//                            break;
//                        }
//
//                    }
//                    changeTarea = Boolean.TRUE;
//                    //  tarjetaServices.update(t);
//                }
//                /**
//                 * Actualiza los impedimentos
//                 *
//                 */
//                if (t.getImpedimento() == null || t.getImpedimento().isEmpty()) {
//
//                } else {
//
//                    for (UserView uv : t.getUserView()) {
//                        if (uv.getIduser().equals(iduser)) {
//                            Integer count = 0;
//                            for (Impedimento imp : t.getImpedimento()) {
//                                imp.setCompletado(Boolean.FALSE);
//                                imp.setUserView(uv);
//                            }
//                            break;
//                        }
//
//                    }
//                    changeImpedimento = Boolean.TRUE;
//                    /**
//                     * Actualiza los impedimentos
//                     *
//                     */
//                    // tarjetaServices.update(t);
//                }
//                if (changeTarea || changeImpedimento) {
//               
//                    tarjetaServices.update(t);
//                }
//            }
//            FacesUtil.successMessage(rf.fromMessage("info.procesofinalizado"));
//        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return "";
//
//    }
//    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String version1_0_b_34()">
//    public String version1_0_b_34() {
//        try {
//
//            /**
//             * Proyecto 8
//             */
//            Optional<Proyecto> proyecto = proyectoServices.findByIdproyecto(8L);
//            if(proyecto.isPresent()){
//                proyecto.get().setDiasAlertaVencimiento(2);
//                proyectoServices.update(proyecto.get());
//                
//            }
//            
//            /**
//             * Elimina proyecto 9
//             */
//            Optional<Proyecto> proyectoDelete = proyectoServices.findByIdproyecto(9L);
//           
//            
//           
//            FacesUtil.successMessage(rf.fromMessage("info.procesofinalizado"));
//        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return "";
//
//    }
    // </editor-fold>

}
