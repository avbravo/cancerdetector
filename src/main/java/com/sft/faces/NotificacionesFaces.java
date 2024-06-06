/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.faces.services.DashboardFacesServices;
import com.sft.faces.services.FacesServices;
import com.sft.model.Area;

import com.sft.model.NotificacionProyecto;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.model.Timeline;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.services.NotificacionProyectoServices;
import com.sft.services.ProyectoEstadisticaServices;
import com.sft.services.ProyectoServices;
import com.sft.services.SprintServices;
import com.sft.services.TimelineServices;
import com.sft.services.UserViewServices;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.model.ResponsiveOption;
import com.sft.services.ColorManagement;
import com.sft.services.IconoServices;
import com.sft.services.ProyectoViewServices;
import com.sft.services.TarjetaServices;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.model.DepartamentView;
import com.sft.model.ProyectoMiembro;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.services.AreaServices;
import com.sft.services.DepartamentViewServices;
import com.sft.services.UserServices;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Event;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.model.file.UploadedFile;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class NotificacionesFaces implements Serializable, JmoordbCoreXHTMLUtil , FacesServices{

    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();

      private List<ResponsiveOption> responsiveOptions;
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;
    private Boolean fueCambiadoPorOtroUsuarioUser = Boolean.FALSE;
    private Boolean showDialogContent = Boolean.TRUE;
    private Boolean showDialogContentUser = Boolean.TRUE;
    private List<String> diasLaborableList;
    private String passwordRepetido = "";
    private String message = "";

    private Profile profileLogged = new Profile();

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";

    private Proyecto proyectoNewSelected = new Proyecto();
    private Proyecto proyectoEditarSelected = new Proyecto();
    private Proyecto proyectoClonarSelected = new Proyecto();
    private Proyecto proyectoSelected = new Proyecto();
    private Proyecto proyectoDB = new Proyecto();
    private ProyectoEstadistica proyectoEstadisticaResumen = new ProyectoEstadistica();
    private Sprint sprintSelected = new Sprint();
    private User userSelected = new User();

    private User userDB = new User();
    private List<UserView> userViewList = new ArrayList<>();
    private List<NotificacionProyecto> notificacionProyectoList = new ArrayList<>();
    private List<UserView> userViewPropietarioNewSelectedList = new ArrayList<>();
    private List<UserView> userViewColaboradorNewSelectedList = new ArrayList<>();
    private List<UserView> userViewPropietarioEditSelectedList = new ArrayList<>();
    private List<UserView> userViewColaboradorEditSelectedList = new ArrayList<>();

    private List<ProyectoMiembro> proyectoMiembroOldList = new ArrayList<>();

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<Proyecto> proyectoPublicoList = new ArrayList<>();
    private List<Timeline> timelineList = new ArrayList<>();

    private List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();
    private List<DepartamentView> departamentViewList = new ArrayList<>();
    private List<Area> areaList = new ArrayList<>();

    private List<Sprint> sprintOpenList = new ArrayList<>();
    private List<Sprint> sprintList = new ArrayList<>();

    private List<Profile> profileList = new ArrayList<>();

    private Boolean haveOpenSprintTemporal = Boolean.FALSE;
    /**
     * Password
     */
    Boolean alMenos9Caracteres = Boolean.FALSE;
    Boolean alMenosLetraMinuscula = Boolean.FALSE;
    Boolean alMenosLetraMayuscula = Boolean.FALSE;
    Boolean alMenosUnNumero = Boolean.FALSE;
    Boolean alMenosCaracterEspecial = Boolean.FALSE;

    private UploadedFile file;
    private Boolean fileWasUploaded = false;
    private Boolean isFileImagen = Boolean.FALSE;
    private String fileRepositoryDirectory = "";

    // </editor-fold>
    
       // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
    
 
   
     public Sprint getSprintSelected() {
          if(sprintSelected== null){         
               sprintSelected = new Sprint();
        }
        return sprintSelected;
    }
    
     public Proyecto getProyectoSelected() {
          if(proyectoSelected== null){         
               proyectoSelected = new Proyecto();
        }
        return proyectoSelected;
    }
     public Proyecto getProyectoNewSelected() {
          if(proyectoNewSelected== null){         
               proyectoNewSelected = new Proyecto();
        }
        return proyectoNewSelected;
    }
     public Proyecto getProyectoEditarSelected() {
          if(proyectoEditarSelected== null){         
               proyectoEditarSelected = new Proyecto();
        }
        return proyectoEditarSelected;
    }
     
     public Proyecto getProyectoClonarSelected () {
          if(proyectoClonarSelected == null){         
               proyectoClonarSelected  = new Proyecto();
        }
        return proyectoClonarSelected ;
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
    // <editor-fold defaultstate="collapsed" desc="@Event">
    @Inject
    Event<EmailSenderEvent> emailSenderEvent;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    AreaServices areaServices;
    @Inject
    ColorManagement colorManagement;
    @Inject
    DashboardFacesServices dashboardFacesServices;
    @Inject
    DepartamentViewServices departamentViewServices;
    @Inject
    IconoServices iconoServices;
    @Inject
    NotificacionProyectoServices notificacionProyectoServices;
    @Inject
    ProyectoServices proyectoServices;
    @Inject
    ProyectoEstadisticaServices proyectoEstadisticaServices;
    @Inject
    ProyectoViewServices proyectoViewServices;
    @Inject
    SprintServices sprintServices;

    @Inject
    TimelineServices timelineServices;

    @Inject
    TarjetaServices tarjetaServices;
    @Inject
    UserServices userServices;
    @Inject
    UserViewServices userViewServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SecretKey()">
    private String secretKey = "SCox1jmWrkma$*opne2Amwz";
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
    @ConfigProperty(name = "showEstadisticasProyectoDashboardPrincipal")
    private Provider<Boolean> showEstadisticasProyectoDashboardPrincipal;
    @Inject
    @ConfigProperty(name = "showNotificacionesDashboardPrincipal")
    private Provider<Boolean> showNotificacionesDashboardPrincipal;
    @Inject
    @ConfigProperty(name = "showMiembrosEquipoDashboardPrincipal")
    private Provider<Boolean> showMiembrosEquipoDashboardPrincipal;
    @Inject
    @ConfigProperty(name = "showTimelineDashboardPrincipal")
    private Provider<Boolean> showTimelineDashboardPrincipal;

    // #--Path Images
    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHome", defaultValue = "true")
    private Provider<Boolean> pathBaseLinuxAddUserHome;

    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeStoreInCollections", defaultValue = "false")
    private Provider<Boolean> pathBaseLinuxAddUserHomeStoreInCollections;

    @Inject
    @ConfigProperty(name = "pathLinux", defaultValue = " ")
    private Provider<String> pathLinux;

    @Inject
    @ConfigProperty(name = "pathWindows", defaultValue = " ")
    private Provider<String> pathWindows;

    @Inject
    @ConfigProperty(name = "pathLinuxFileRepository", defaultValue = " ")
    private Provider<String> pathLinuxFileRepository;

    @Inject
    @ConfigProperty(name = "pathWindowsFileRepository", defaultValue = " ")
    private Provider<String> pathWindowsFileRepository;

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

            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
            profileList = new ArrayList<>();
            diasLaborableList = new ArrayList<>();
            diasLaborableList.add(rf.fromMessage("field.lunes"));
            diasLaborableList.add(rf.fromMessage("field.martes"));
            diasLaborableList.add(rf.fromMessage("field.miercoles"));
            diasLaborableList.add(rf.fromMessage("field.jueves"));
            diasLaborableList.add(rf.fromMessage("field.viernes"));
            diasLaborableList.add(rf.fromMessage("field.sabado"));
            diasLaborableList.add(rf.fromMessage("field.domingo"));
            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());
            refresh();
//            loadIcono();

            //Cargar el media type
            saveToMediaContext(userLogged.getPhoto());
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
    // <editor-fold defaultstate="collapsed" desc="String refresh()">

    @Override
    public String refresh() {
        try {
            userViewList = new ArrayList<>();
            timelineList = new ArrayList<>();

           
            
          List<ProyectoSprintOpen>  proyectoSprintOpenList = proyectoServices.cargarProyectosPrivadosConSprintAbierto(userLogged); 
           List<ProyectoSprintOpen>  proyectoSprintOpenPublicoList = proyectoServices.cargarProyectosPublicosNoAsignadosConSprintAbierto(userLogged);
          
            proyectoList = new ArrayList<>();
            proyectoPublicoList = new ArrayList<>();
            if(proyectoSprintOpenList == null ||proyectoSprintOpenList.isEmpty()){
                
            }else{
                for(ProyectoSprintOpen p:proyectoSprintOpenList){
                    proyectoList.add(p.getProyecto());
                }
            }
            
            if(proyectoSprintOpenPublicoList == null ||proyectoSprintOpenPublicoList.isEmpty()){
                
            }else{
                for(ProyectoSprintOpen p:proyectoSprintOpenPublicoList){
                    proyectoPublicoList.add(p.getProyecto());
                }
            }
            
            
            sprintList = new ArrayList<>();
            sprintSelected = new Sprint();
            message = "";
            
                /**
                 * Cargar la lista de notificaciones
                 */
                notificacionProyectoList = notificacionProyectoServices.findByUserAndVisto(userLogged, false);
           
            PrimeFaces.current().ajax().update("form");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
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

     // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
