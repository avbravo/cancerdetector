/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.faces.services.FacesServices;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.services.ColorManagement;
import com.sft.services.IconoServices;
import com.sft.services.ProyectoServices;
import com.sft.services.SprintServices;
import com.sft.services.TarjetaServices;
import com.sft.services.implementation.ColorManagementImpl;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.model.ResponsiveOption;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import jakarta.annotation.PreDestroy;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.time.LocalDate;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class TimeLineTableroFaces implements Serializable, JmoordbCoreXHTMLUtil, FacesServices {

    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;

    private TimelineModel<String, ?> model;
    private TimelineModel<String, ?> modelBasic;
 

    
    private LocalDateTime start;
    private LocalDateTime end;

    private LocalDateTime min;
    private LocalDateTime max;

    private User userLogged = new User();
    private String message = "";
    String perfil = "";
    private Boolean isPropietario = Boolean.FALSE;
    private Boolean isColaborador = Boolean.FALSE;

    private Profile profileLogged = new Profile();
    private Sprint sprintSelected = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();
    private String dialogoActivo = "";

    private Tarjeta tarjetaSelected = new Tarjeta();

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<ResponsiveOption> responsiveOptions;
    private List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();

    private List<Tarjeta> tarjetaListDataTable = new ArrayList<>();
    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    private List<Tarjeta> tarjetaFinalizadoList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;

    ColorManagement colorKnob = new ColorManagementImpl();

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
    public Proyecto getProyectoSelected() {
        if (proyectoSelected == null) {

            proyectoSelected = new Proyecto();
        }

        return proyectoSelected;
    }

    public Sprint getSprintSelected() {
        if (sprintSelected == null) {

            sprintSelected = new Sprint();
        }

        return sprintSelected;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    IconoServices iconoServices;

    @Inject
    ProyectoServices proyectoServices;

    @Inject
    SprintServices sprintServices;

    @Inject
    TarjetaServices tarjetaServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "idapplicative")
    private Provider<Integer> idapplicative;
    @Inject
    @ConfigProperty(name = "loginStyle")
    private Provider<String> loginStyle;
    @Inject
    @ConfigProperty(name = "application.version")
    private Provider<String> applicationVersion;
    @Inject
    @ConfigProperty(name = "smallSizeOfTextForCut")
    private Provider<Integer> smallSizeOfTextForCut;
    @Inject
    @ConfigProperty(name = "mediumSizeOfTextForCut")
    private Provider<Integer> mediumSizeOfTextForCut;
    @Inject
    @ConfigProperty(name = "largeSizeOfTextForCut")
    private Provider<Integer> largeSizeOfTextForCut;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ProyectoRestClient proyectoClient;

    @Inject
    UserRestClient userClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        try {

            haveSprintOpen = Boolean.FALSE;
            message = "";
            isPropietario = Boolean.FALSE;
            isColaborador = Boolean.FALSE;

            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
            if (JmoordbCoreContext.get("DashboardFaces.proyectoSelected") == null) {

            } else {
                proyectoSelected = (Proyecto) JmoordbCoreContext.get("DashboardFaces.proyectoSelected");

                if (JmoordbCoreContext.get("DashboardFaces.isPropietario") != null) {

                    isPropietario = (Boolean) JmoordbCoreContext.get("DashboardFaces.isPropietario");
                }
                if (JmoordbCoreContext.get("DashboardFaces.isColaborador") != null) {
                    isColaborador = (Boolean) JmoordbCoreContext.get("DashboardFaces.isColaborador");
                }

                if (isPropietario) {
                    perfil = rf.fromMessage("label.propietario");
                } else {
                    perfil = rf.fromMessage("label.colaborador");
                }

                refresh();

            }

            //Cargar el media type
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="void preDestroy()">
    @PreDestroy
    @Override
    public void preDestroy() {
        
    }

    // </editor-fold>
    
    public TimelineModel<String, ?> getModel() {
        return model;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    // <editor-fold defaultstate="collapsed" desc="void drawTimeLine(">
    public void drawTimeLine() {
        try {
            start = JmoordbCoreDateUtil.convertirJavaDateToLocalDate(sprintSelected.getFechainicial()).atStartOfDay();
//            start = JmoordbCoreDateUtil.convertirJavaDateToLocalDate(proyectoSelected.getFechainicial()).atStartOfDay();
//            end = JmoordbCoreDateUtil.convertirJavaDateToLocalDate(proyectoSelected.getFechafinal()).atStartOfDay();;
            end = JmoordbCoreDateUtil.convertirJavaDateToLocalDate(sprintSelected.getFechafinal()).atStartOfDay();;
            model = new TimelineModel<>();
            List<Tarjeta> tarjetaTotalList = new ArrayList<>();
            if (tarjetaPendienteList == null || tarjetaPendienteList.isEmpty()) {
                
            } else {
                
                tarjetaTotalList.addAll(tarjetaPendienteList);
            }
            if (tarjetaProgresoList == null || tarjetaProgresoList.isEmpty()) {
                
            } else {
                
                tarjetaTotalList.addAll(tarjetaProgresoList);
            }
            if (tarjetaFinalizadoList == null || tarjetaFinalizadoList.isEmpty()) {
                
            } else {
                
                tarjetaTotalList.addAll(tarjetaFinalizadoList);
            }

            Boolean found = Boolean.FALSE;
            for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {

                if (tarjetaTotalList == null || tarjetaTotalList.isEmpty()) {

                } else {
                    for (Tarjeta t : tarjetaTotalList) {
                        String availability = "Unavailable";
                        if (t.getColumna().equals("pendiente")) {
                            availability = "Unavailable";
                        } else {
                            if (t.getColumna().equals("progreso")) {
                                availability = "Maybe";
                            } else {
                                if (t.getColumna().equals("finalizado")) {
                                    availability = "Available";
                                }
                            }
                        }

                        found = Boolean.FALSE;
                        for (UserView uv : t.getUserView()) {
                            if (uv.getIduser().equals(pm.getUserView().getIduser())) {
                                found = Boolean.TRUE;
                                break;
                            }
                        }

                        if (found) {

                            String shortName = cutText(t.getTarjeta(), largeSizeOfTextForCut.get());
                            shortName = deleteComillas(shortName);
                            TimelineEvent event = TimelineEvent.builder()
                                    .data(shortName)
                                    .startDate(JmoordbCoreDateUtil.convertirJavaDateToLocalDate(t.getFechainicial()))
                                    .endDate(JmoordbCoreDateUtil.convertirJavaDateToLocalDate(t.getFechafinal()))
                                    .editable(true)
                                    .group(pm.getUserView().getName())
                                    .styleClass(availability.toLowerCase())
                                    .build();
                          
                            model.add(event);
                            
                        } else {

                        }

                        // create an event with content, start / end dates, editable flag, group name and custom style class
                    }
                }

            }
            
        } catch (Exception e) {
            
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void drawTimeLineBasic()">

    public void drawTimeLineBasic() {
        try {
           
            modelBasic = new TimelineModel<>();
            List<Tarjeta> tarjetaTotalList = new ArrayList<>();
            if (tarjetaPendienteList == null || tarjetaPendienteList.isEmpty()) {
                
            } else {
                
                tarjetaTotalList.addAll(tarjetaPendienteList);
            }
            if (tarjetaProgresoList == null || tarjetaProgresoList.isEmpty()) {
   
            } else {
               
                tarjetaTotalList.addAll(tarjetaProgresoList);
            }
            if (tarjetaFinalizadoList == null || tarjetaFinalizadoList.isEmpty()) {
 
            } else {
  
                tarjetaTotalList.addAll(tarjetaFinalizadoList);
            }

            Boolean found = Boolean.FALSE;

            if (tarjetaTotalList == null || tarjetaTotalList.isEmpty()) {
                
            } else {
                Integer in=0;
             
                Integer c=0;
                for (Tarjeta t : tarjetaTotalList) {
                    String availability = "Unavailable";
                    if (t.getColumna().equals("pendiente")) {
                        availability = "Unavailable";
                    } else {
                        if (t.getColumna().equals("progreso")) {
                            availability = "Maybe";
                        } else {
                            if (t.getColumna().equals("finalizado")) {
                                availability = "Available";
                            }
                        }
                    }
                   
                    if(t.getTarjeta() == null){
                   
                    }
                    String shortName = cutText(t.getTarjeta(), largeSizeOfTextForCut.get());
                         shortName = deleteComillas(shortName);
                    
                    
                    modelBasic.add(TimelineEvent.<String>builder().data(shortName)
                            .startDate(JmoordbCoreDateUtil.convertirJavaDateToLocalDate(t.getFechainicial()))
                            .endDate(JmoordbCoreDateUtil.convertirJavaDateToLocalDate(t.getFechafinal()))
                            .styleClass(availability.toLowerCase())
                            .build());

   
//                   if(c==18){
//                        break;
//                    }
c++;
                }

            }
       
           
        } catch (Exception e) {
            
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String refresh()">

    @Override
    public String refresh() {
        try {

            tarjetaFinalizadoList = new ArrayList<>();
            tarjetaPendienteList = new ArrayList<>();
            tarjetaProgresoList = new ArrayList<>();
            if (loadOpenSprint()) {

                loadTarjetaPendiente();
                loadTarjetaProgreso();
                loadTarjetaFinalizado();

            }
            drawTimeLineBasic();
//            drawTimeLine();

            //     PrimeFaces.current().ajax().update("form");
        } catch (Exception e) {
            
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadOpenSprint()>
    private Boolean loadOpenSprint() {

        Boolean result = Boolean.FALSE;
        try {
            if (JmoordbCoreContext.get("DashboardFaces.sprintSelected") == null) {

            } else {
                sprintSelected = (Sprint) JmoordbCoreContext.get("DashboardFaces.sprintSelected");
                haveSprintOpen = Boolean.TRUE;
                result = Boolean.TRUE;

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjeaaPendiente()">
    private Boolean loadTarjetaPendiente() {

        Boolean result = Boolean.FALSE;
        tarjetaPendienteList = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            /**
             * CargarTarjetas
             */
//            if (isPropietario) {
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"));

            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            }

            tarjetaPendienteList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaProgreso()">
    private Boolean loadTarjetaProgreso() {
        Boolean result = Boolean.FALSE;
        tarjetaProgresoList = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            /**
             * CargarTarjetas
             */

//            if (isPropietario) {
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "progreso"));
            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            }
            tarjetaProgresoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaFinalizado()">

    private Boolean loadTarjetaFinalizado() {
        Boolean result = Boolean.FALSE;
        tarjetaFinalizadoList = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            /**
             * CargarTarjetas
             */

//            if (isPropietario) {
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"));
            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            }
            tarjetaFinalizadoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    public void onSelect(TimelineSelectEvent<String> e) {
        TimelineEvent<String> timelineEvent = e.getTimelineEvent();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected event:", timelineEvent.getData());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
