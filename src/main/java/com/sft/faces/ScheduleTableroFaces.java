/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

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
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
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
import org.primefaces.PrimeFaces;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ResponsiveOption;
import org.primefaces.model.ScheduleModel;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import jakarta.annotation.PreDestroy;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.ScheduleEvent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
//public class ScheduleTableroFaces extends AbstractFaces implements Serializable, JmoordbCoreXHTMLUtil {
public class ScheduleTableroFaces  implements Serializable, JmoordbCoreXHTMLUtil, FacesServices {

    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private String message = "";
    private String perfil = "";
    private Boolean isPropietario = Boolean.FALSE;
    private Boolean isColaborador = Boolean.FALSE;
    private Boolean showSchedule = Boolean.FALSE;
    private ScheduleEvent<?> event = new DefaultScheduleEvent<>();

    private Profile profileLogged = new Profile();
    private Sprint sprintSelected = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();
    private String dialogoActivo = "";

    private Tarjeta tarjetaSelected = new Tarjeta();

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<ResponsiveOption> responsiveOptions;


    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    private List<Tarjeta> tarjetaFinalizadoList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;

    ColorManagement colorKnob = new ColorManagementImpl();

    private ScheduleModel lazyEventModel;
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

    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeStoreInCollections", defaultValue = "false")
    private Provider<Boolean> pathBaseLinuxAddUserHomeStoreInCollections;

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
            showSchedule = Boolean.FALSE;
            haveSprintOpen = Boolean.FALSE;
            message = "";
            isPropietario = Boolean.FALSE;
            isColaborador = Boolean.FALSE;

            
            //initAbstract();

           

           userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
           profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
            if (JmoordbCoreContext.get("DashboardFaces.proyectoSelected") == null) {

            } else {
                proyectoSelected = (Proyecto) JmoordbCoreContext.get("DashboardFaces.proyectoSelected");

                if (JmoordbCoreContext.get("DashboardFaces.sprintSelected") == null) {

                } else {
                    sprintSelected = (Sprint) JmoordbCoreContext.get("DashboardFaces.sprintSelected");
                }

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

              //refresh();
            }

            //    proyectoList = loadProyecto();
            //    cargarProyectoEstadistica(proyectoList);
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
    
// <editor-fold defaultstate="collapsed" desc="String saveToMediaContext(String pathOfFile, String... nameOfFile)">
    public String saveToMediaContext(String pathOfFile, String... nameOfFile) {
        try {
            String name = pathOfFile;

            if (nameOfFile.length != 0) {
                name = nameOfFile[0];
            }

            if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                pathOfFile = FacesUtil.userHome() + pathOfFile;

            }

            jmoordbCoreMediaContext.put("pathOfFile", pathOfFile);
            jmoordbCoreMediaContext.put("nameOfFile", name);
            jmoordbCoreMediaManager.init();
        } catch (Exception e) {

        }

        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String repairPathOfFile(String pathOfFile)">
    public String repairPathOfFile(String pathOfFile) {
        try {
            if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                pathOfFile = FacesUtil.userHome() + pathOfFile;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return pathOfFile;
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
          //  PrimeFaces.current().ajax().update(":form:schedule");
            
            loadSchedule();

            PrimeFaces.current().ajax().update(":form:schedule");
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
                
                result = Boolean.TRUE;
                haveSprintOpen = Boolean.TRUE;
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
            if (isPropietario) {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "pendiente"));

                
                tarjetaPendienteList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            } else {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "pendiente"),
                        eq("userView.iduser", userLogged.getIduser()));

                tarjetaPendienteList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            }

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

            if (isPropietario) {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "progreso"));

                tarjetaProgresoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            } else {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "progreso"),
                        eq("userView.iduser", userLogged.getIduser()));

                tarjetaProgresoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            }
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

            if (isPropietario) {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "finalizado"));

                tarjetaFinalizadoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            } else {
                Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
                Bson filter = and(filter0, eq("idsprint", sprintSelected.getIdsprint()), eq("active", Boolean.TRUE),
                        eq("columna", "finalizado"),
                        eq("userView.iduser", userLogged.getIduser()));

                tarjetaFinalizadoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void loadSchedule()">
    public void loadSchedule() {
        try {
            
            lazyEventModel = new LazyScheduleModel() {
                List<Tarjeta> list = new ArrayList<>();

                @Override
                public void loadEvents(LocalDateTime start, LocalDateTime end) {
                    
                    tarjetaPendienteList.forEach((a) -> {
                        
                        DefaultScheduleEvent event = DefaultScheduleEvent.builder()
                                .title(deleteComillas(a.getTarjeta()) + " / " + siglasColaboradores(a.getUserView()))
                                .startDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechainicial()))
                                .endDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechafinal()))
                                .description(deleteComillas(a.getDescripcion()))
                                .id(a.getIdtarjeta().toString())
                                 .backgroundColor("red")
                                .build();
 
                        addEvent(event);

                    });

                    tarjetaProgresoList.forEach((a) -> {

                        DefaultScheduleEvent event = DefaultScheduleEvent.builder()
                                .title(deleteComillas(a.getTarjeta()) + " / " + siglasColaboradores(a.getUserView()))
                                .startDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechainicial()))
                                .endDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechafinal()))
                                .description(deleteComillas(a.getDescripcion()))
                                .id(a.getIdtarjeta().toString())
                     .backgroundColor("orange")
                                .build();

                        addEvent(event);

                    });
                    tarjetaFinalizadoList.forEach((a) -> {

  
                        DefaultScheduleEvent event = DefaultScheduleEvent.builder()
                                .title(deleteComillas(a.getTarjeta()) + " / " + siglasColaboradores(a.getUserView()))
                                .startDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechainicial()))
                                .endDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechafinal()))
                                .description(deleteComillas(a.getDescripcion()))
                                .id(a.getIdtarjeta().toString())
                                .backgroundColor("green")
                               
                                .build();

                        addEvent(event);

                    });

                }

            };
            
        } catch (Exception e) {
            
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void onViewChange(SelectEvent<String> selectEvent) ">
    public void onViewChange(SelectEvent<String> selectEvent) {
        var view = selectEvent.getObject();
        FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + view);
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="String actionCommandButton()">
    public String actionCommandButton() {
        try {
            showSchedule = Boolean.TRUE;
            refresh();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void onEventSelect(SelectEvent<ScheduleEvent<?>> selectEvent)">
    public void onEventSelect(SelectEvent<ScheduleEvent<?>> selectEvent) {
        try {
            event = selectEvent.getObject();
         
            var title = event.getTitle();
  
            var id = event.getId();

       
            var l = Long.parseLong(id);



            tarjetaSelected = tarjetaServices.findByIdtarjeta(Long.parseLong(id), proyectoSelected.getIdproyecto()).get();
            if (tarjetaSelected == null || tarjetaSelected.getIdtarjeta() == null) {
             
            }
          
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
    // </editor-fold>

   

    // <editor-fold defaultstate="collapsed" desc="String siglasColaboradores(List<UserView> userViewList)">
    private String siglasColaboradores(List<UserView> userViewList) {
        String result = "";
        try {

            for (UserView uv : userViewList) {
                result += uv.getName().substring(0, 2) + " ";
            }
        } catch (Exception e) {
        }
        return result;
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="handleCloseDialogrefresh(CloseEvent event)">
    public void handleCloseDialogRefresh(CloseEvent event) {
        try {
           refresh();
          
        } catch (Exception e) {
              FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

}
