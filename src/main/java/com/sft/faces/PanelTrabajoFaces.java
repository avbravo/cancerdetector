/* 
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;
// <editor-fold defaultstate="collapsed" desc=" imports">

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbCronometer;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.websocket.MessageWebSocket;
import com.jmoordb.core.util.JmoordbCoreUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.commons.emails.EmailSender;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.converter.services.IconoConverterServices;
import com.sft.converter.services.TipoTarjetaConverterServices;
import com.sft.faces.services.DashboardFacesServices;
import com.sft.faces.services.FacesServices;

import com.sft.model.ActionHistory;
import com.sft.model.Archivo;
import com.sft.model.Comentario;
import com.sft.model.Etiqueta;
import com.sft.model.Icono;
import com.sft.model.Impedimento;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.Tarea;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.model.domain.UserViewDomain;
import com.sft.services.ProyectoServices;
import com.sft.services.SprintServices;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.model.ResponsiveOption;
import com.sft.services.ColorManagement;
import com.sft.services.IconoServices;
import com.sft.services.TarjetaServices;
import com.sft.faces.services.TableroFacesServices;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.StreamedContent;

import org.primefaces.model.file.UploadedFile;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.services.ProyectoEstadisticaServices;
import com.sft.services.TipotarjetaServices;
import com.sft.websocket.fire.FacesWebSocket;
import com.sft.websocket.fire.WebSocketController;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Event;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import java.util.Comparator;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ReorderEvent;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class PanelTrabajoFaces implements Serializable, JmoordbCoreXHTMLUtil, TableroFacesServices, FacesWebSocket, FacesServices {

    // <editor-fold defaultstate="collapsed" desc="WebSocket">
    @Inject
    WebSocketController webSocketController;
    private Boolean dialogVisibleWebSocket = Boolean.FALSE;
    private Boolean dialogVisibleAddWebSocket = Boolean.FALSE;
    private List<UserView> userViewForWebSocketList = new ArrayList<>();
    private Integer contadorNotificacionesWebsocket = 0;
    private Long jmoordbCronometerOld = 0L;
    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="ConverterServices">

    @Inject
    TipoTarjetaConverterServices tipoTarjetaConverterServices;

    @Inject
    IconoConverterServices iconoConverterServices;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private String message = "";
    String perfil = "";
    private Boolean isProyectoForaneo = Boolean.FALSE;
    private Boolean isPropietario = Boolean.FALSE;
    private Boolean isColaborador = Boolean.FALSE;
    private Boolean showColumnaPendiente = Boolean.TRUE;
    private Boolean showColumnaProgreso = Boolean.TRUE;
    private Boolean showColumnaFinalizado = Boolean.TRUE;
    private Boolean isSprintVencido = Boolean.FALSE;
    private Boolean isComentarioPrivado = Boolean.FALSE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean isChangeInRowDatatableTarea = Boolean.FALSE;
    private Boolean isChangeInRowDatatableColaborador = Boolean.FALSE;
    private Boolean isChangeInRowDatatableImpedimento = Boolean.FALSE;
    private Boolean isChangeInRowDatatableComentario = Boolean.FALSE;
    private Boolean isChangeInRowDatatableEtiqueta = Boolean.FALSE;
    private Boolean isChangeInRowDatatableArchivo = Boolean.FALSE;
    private Boolean showColapsado = Boolean.FALSE;
    private Boolean showIcon = Boolean.FALSE;
    private Boolean showDetallesProyecto = Boolean.FALSE;
    private Boolean showMisTarjetas = Boolean.FALSE;
    private String orderBy = "lastModification";
    private String iconOrderBy = "pi pi pi-hourglass";
    private Boolean descending = Boolean.TRUE;
    private Integer indexDescending = -1;
    private String textToSearch = "";
    private Integer contadorSearch = 0;
    private List<Tarjeta> pendienteTarjetaListSearch = new ArrayList<>();
    private List<Tarjeta> progresoTarjetaListSearch = new ArrayList<>();
    private List<Tarjeta> finalizadoTarjetaListSearch = new ArrayList<>();

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private String callerLevel1 = "";

//    private DualListModel<UserView> userViewPickList;
    private Profile profileLogged = new Profile();
    private Sprint sprintSelected = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();
    private String dialogoActivo = "";
    private String fileRepositoryDirectory = "";
    private String inputTextTarea = "";
    private String inputTextComentario = "";
    private String inputTextEtiqueta = "";
    private String inputTextImpedimento = "";

    private UploadedFile file;
    private Boolean fileWasUploaded = false;
    private Boolean isFileImagen = Boolean.FALSE;

    private Tarjeta tarjetaSelected = new Tarjeta();
    private Tarjeta tarjetaClonarSelected = new Tarjeta();
    private Tarjeta tarjetaArchivarSelected = new Tarjeta();
    private Tarjeta tarjetaComentarioSelected = new Tarjeta();
    private Tarjeta tarjetaEditarSelected = new Tarjeta();
    private Tarjeta tarjetaViewSelected = new Tarjeta();
    private Tarjeta tarjetaColaboradorSelected = new Tarjeta();
    private Tarjeta tarjetaEtiquetaSelected = new Tarjeta();
    private Tarjeta tarjetaTareaSelected = new Tarjeta();
    private Tarjeta tarjetaImpedimentoSelected = new Tarjeta();
    private Tarjeta tarjetaArchivoSelected = new Tarjeta();
    private Tarjeta tarjetaDB = new Tarjeta();
    private Tarjeta tarjetaInlineSelected = new Tarjeta();

    private Tarjeta autoCompleteTarjeta = new Tarjeta();

    private ProyectoEstadistica proyectoEstadisticaResumen = new ProyectoEstadistica();

    private Icono iconoSelected = new Icono();

    private UserView userViewForaneo = new UserView();
    private List<UserViewDomain> userViewDomainList = new ArrayList<>();
    private List<UserViewDomain> userViewDomainForCreateList = new ArrayList<>();
    private List<Tarea> tareasOld = new ArrayList<>();
    private List<Impedimento> impedimentoOld = new ArrayList<>();
    private List<Proyecto> proyectoPorColaboradorList = new ArrayList<>();
    private List<Sprint> sprintPorColaboradorList = new ArrayList<>();
    private List<UserView> userViewSelectedList = new ArrayList<>();
    private List<Comentario> comentarioOldList = new ArrayList<>();
    private List<UserView> userViewSelectedOldList = new ArrayList<>();

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<ResponsiveOption> responsiveOptions;
    private List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();

    private List<Tarjeta> tarjetaListDataTable = new ArrayList<>();
    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    private List<Tarjeta> tarjetaFinalizadoList = new ArrayList<>();
    private List<Tarjeta> tarjetaPendienteInitialList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoInitialList = new ArrayList<>();

    private List<Tarjeta> tarjetaFinalizadoInitialList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;

    ColorManagement colorKnob = new ColorManagementImpl();

    private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;

    private StreamedContent fileDownload;
    private Archivo selectedMediaArchivo = new Archivo();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">

    public Sprint getSprintSelected() {
        if (sprintSelected == null) {
            sprintSelected = new Sprint();
        }
        return sprintSelected;
    }

    public Tarjeta getTarjetaSelected() {
        if (tarjetaSelected == null) {
            tarjetaSelected = new Tarjeta();
        }
        return tarjetaSelected;
    }

    public Proyecto getProyectoSelected() {
        if (proyectoSelected == null) {
            proyectoSelected = new Proyecto();
        }
        return proyectoSelected;
    }

    public Tarjeta getTarjetaClonarSelected() {
        if (tarjetaClonarSelected == null) {
            tarjetaClonarSelected = new Tarjeta();
        }
        return tarjetaClonarSelected;
    }

    public Tarjeta getTarjetaArchivarSelected() {
        if (tarjetaArchivarSelected == null) {
            tarjetaArchivarSelected = new Tarjeta();
        }
        return tarjetaArchivarSelected;
    }

    public Tarjeta getTarjetaArchivoSelected() {
        if (tarjetaArchivoSelected == null) {
            tarjetaArchivoSelected = new Tarjeta();
        }
        return tarjetaArchivoSelected;
    }

    public Tarjeta getTarjetaComentarioSelected() {
        if (tarjetaComentarioSelected == null) {
            tarjetaComentarioSelected = new Tarjeta();
        }
        return tarjetaComentarioSelected;
    }

    public Tarjeta getTarjetaEditarSelected() {
        if (tarjetaEditarSelected == null) {
            tarjetaEditarSelected = new Tarjeta();
        }
        return tarjetaEditarSelected;
    }

    public Tarjeta getTarjetaColaboradorSelected() {
        if (tarjetaColaboradorSelected == null) {
            tarjetaColaboradorSelected = new Tarjeta();
        }
        return tarjetaColaboradorSelected;
    }

    public Tarjeta getTarjetaEtiquetaSelected() {
        if (tarjetaEtiquetaSelected == null) {
            tarjetaEtiquetaSelected = new Tarjeta();
        }
        return tarjetaEtiquetaSelected;
    }

    public Tarjeta getTarjetaTareaSelected() {
        if (tarjetaTareaSelected == null) {
            tarjetaTareaSelected = new Tarjeta();
        }
        return tarjetaTareaSelected;
    }

    public Tarjeta getTarjetaImpedimentoSelected() {
        if (tarjetaImpedimentoSelected == null) {
            tarjetaImpedimentoSelected = new Tarjeta();
        }
        return tarjetaImpedimentoSelected;
    }

    public Tarjeta getTarjetaInlineSelected() {
        if (tarjetaInlineSelected == null) {
            tarjetaInlineSelected = new Tarjeta();
        }
        return tarjetaInlineSelected;
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
    DashboardFacesServices dashboardFacesServices;
    @Inject
    IconoServices iconoServices;

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
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "idapplicative")
    private Provider<Integer> idapplicative;

    @Inject
    @ConfigProperty(name = "applicativeURL")
    private Provider<String> applicativeURL;

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

    // Converter
    @Inject
    @ConfigProperty(name = "converter.max.number.of.elements")
    private Provider<Integer> converterMaxNumberOfElements;

    // #Websocket    
    @Inject
    @ConfigProperty(name = "websocket.minimums.seconds.for.update")
    private Provider<Integer> websocketMinimumsSecondsForUpdate;

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

    // TableroForm
    @Inject
    @ConfigProperty(name = "showMessagesOfActionInFormTablero", defaultValue = "false")
    private Provider<Boolean> showMessagesOfActionInFormTablero;
    // Row
    @Inject
    @ConfigProperty(name = "rowPage", defaultValue = "0")
    private Provider<Integer> rowPage;
    @Inject
    @ConfigProperty(name = "rowPageSmall", defaultValue = "0")
    private Provider<Integer> rowPageSmall;

    @Inject
    @ConfigProperty(name = "rowPageDialog", defaultValue = "0")
    private Provider<Integer> rowPageDialog;

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
            contadorNotificacionesWebsocket = 0;
            jmoordbCronometerOld = 0L;
            dialogVisibleWebSocket = Boolean.FALSE;
            dialogVisibleAddWebSocket = Boolean.FALSE;
            textToSearch = "";
            orderBy = "lastModification";
            descending = Boolean.FALSE;
            iconOrderBy = "pi pi pi-hourglass";

            indexDescending = -1;
            contadorSearch = 0;
            pendienteTarjetaListSearch = new ArrayList<>();
            progresoTarjetaListSearch = new ArrayList<>();
            finalizadoTarjetaListSearch = new ArrayList<>();
            proyectoPorColaboradorList = new ArrayList<>();
            haveSprintOpen = Boolean.FALSE;
            message = "";
            isPropietario = Boolean.FALSE;
            isColaborador = Boolean.FALSE;
            isProyectoForaneo = Boolean.FALSE;
            isOverlayPanelOpen = Boolean.FALSE;
            isButtonSavePressed = Boolean.TRUE;
            showDetallesProyecto = Boolean.FALSE;
            showMisTarjetas = Boolean.FALSE;
            userViewDomainForCreateList = new ArrayList<>();
            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");

            if (JmoordbCoreContext.get("DashboardFaces.callerLevel0") != null) {
                callerLevel0 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel0");

            }

            refresh();

            //Cargar el media type
            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
            loadIcono();

//            loadTipotarjetaByProyecto(proyectoSelected);
            //   userViewDomainForCreateList = loadUserForCreateTarjeta(proyectoSelected, userLogged);
            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="void preDestroy()">

    /**
     *
     */
    @PreDestroy
    public void preDestroy() {

        tipoTarjetaConverterServices.destroyed();
        iconoConverterServices.destroyed();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String refresh()">
    @Override
    public String refresh() {
        try {
            contadorNotificacionesWebsocket = 0;
            dialogVisibleWebSocket = Boolean.FALSE;

            dialogVisibleAddWebSocket = Boolean.FALSE;
            proyectoPorColaboradorList = new ArrayList<>();
            sprintPorColaboradorList = new ArrayList<>();
            textToSearch = "";
            tarjetaFinalizadoList = new ArrayList<>();
            tarjetaPendienteList = new ArrayList<>();
            tarjetaProgresoList = new ArrayList<>();
            tarjetaFinalizadoInitialList = new ArrayList<>();
            tarjetaPendienteInitialList = new ArrayList<>();
            tarjetaProgresoInitialList = new ArrayList<>();
            contadorSearch = 0;
            pendienteTarjetaListSearch = new ArrayList<>();
            progresoTarjetaListSearch = new ArrayList<>();
            finalizadoTarjetaListSearch = new ArrayList<>();

            if (loadProyectosDelColaborador()) {
                ConsoleUtil.test("\t tiene proyectos : "+proyectoPorColaboradorList.size());
                sprintPorColaboradorList = new ArrayList<>();
                proyectoPorColaboradorList.forEach(p -> {

                    loadOpenSprint(p);
                });

                if (sprintPorColaboradorList == null || sprintPorColaboradorList.isEmpty()) {
                    ConsoleUtil.test("\t**- no hay nada de sprintPorColaboradorList");
                } else {
                    ConsoleUtil.test("\t** Voy a buscar las tarjetas del colaborador....");
                    for (Sprint s : sprintPorColaboradorList) {

                        loadTarjetaPendiente(s);
                        loadTarjetaProgreso(s);
                        loadTarjetaFinalizado(s);
                    }

                }

            } else {

                message = rf.fromMessage("warning.notieneproyectosasignados");
            }

            if (tarjetaPendienteList == null || tarjetaPendienteList.isEmpty()) {

            } else {

                List<Tarjeta> sortedTarjeta = tarjetaPendienteList.stream()
                        .sorted(Comparator.comparing(Tarjeta::getLastModification).reversed())
                        .collect(Collectors.toList());
                
                tarjetaPendienteList = new ArrayList<>();
                tarjetaPendienteList = sortedTarjeta;

                for (Tarjeta t : tarjetaPendienteList) {
                    Tarjeta t1 = new Tarjeta();
                    JmoordbCoreUtil.copyBeans(t1, t);
                    tarjetaPendienteInitialList.add(t1);
                }
            }
            if (tarjetaProgresoList == null || tarjetaProgresoList.isEmpty()) {

            } else {
                  List<Tarjeta> sortedTarjeta = tarjetaProgresoList.stream()
                        .sorted(Comparator.comparing(Tarjeta::getLastModification).reversed())
                        .collect(Collectors.toList());
                
                tarjetaProgresoList = new ArrayList<>();
                tarjetaProgresoList = sortedTarjeta;
                for (Tarjeta t : tarjetaProgresoList) {
                    Tarjeta t1 = new Tarjeta();
                    JmoordbCoreUtil.copyBeans(t1, t);
                    tarjetaProgresoInitialList.add(t1);
                }
            }
            if (tarjetaFinalizadoList == null || tarjetaFinalizadoList.isEmpty()) {

            } else {
                  List<Tarjeta> sortedTarjeta = tarjetaFinalizadoList.stream()
                        .sorted(Comparator.comparing(Tarjeta::getLastModification).reversed())
                        .collect(Collectors.toList());
                
                tarjetaFinalizadoList = new ArrayList<>();
                tarjetaFinalizadoList = sortedTarjeta;
                
                for (Tarjeta t : tarjetaFinalizadoList) {
                    Tarjeta t1 = new Tarjeta();
                    JmoordbCoreUtil.copyBeans(t1, t);
                    tarjetaFinalizadoInitialList.add(t1);
                }
            }

            PrimeFaces.current().ajax().update("form");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadOpenSprint(Proyecto p)">
    /**
     * Carga los sprint abiertos por proyectos
     *
     * @param p
     * @return
     */
    private Boolean loadOpenSprint(Proyecto p) {
        Boolean result = Boolean.FALSE;
        try {

            dialogoActivo = "";
            /**
             * Cargo los Sprint
             */
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", p.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

            List<Sprint> sprintList = sprintServices.lookup(
                    filter,
                    sort,
                    page, size);
            if (!sprintList.isEmpty()) {
                for (Sprint s : sprintList) {

                    if (!sprintServices.isOpenSprintBetweenDateNow(s)) {
                        ConsoleUtil.test("\t\t [sprint ]"+s.getIdsprint() + " {isOpenSprintBetweenDataNow == false}");
                    } else {
ConsoleUtil.test("\t\t [sprint ]"+s.getIdsprint() + " {isOpenSprintBetweenDataNow == true}");
                        sprintPorColaboradorList.add(s);
                    }

                }

            }
            if (sprintPorColaboradorList == null || sprintPorColaboradorList.isEmpty()) {
                ConsoleUtil.test("\t\t** No tiene sprint abiertos en esas fechas");
            } else {
       ConsoleUtil.test("\t\t** SI tiene sprint abiertos en esas fechas");
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean loadProyectosDelColaborador()">

    /**
     * Carga los proyectos a los que pertenece el colaborador
     *
     * @return
     */
    private Boolean loadProyectosDelColaborador() {
        Boolean result = Boolean.FALSE;
        try {

            proyectoPorColaboradorList = new ArrayList<>();
            /**
             * Cargo los Proyectos del colaborador
             */
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyectoMiembro.user.iduser", userLogged.getIduser())
                    .append("active", Boolean.TRUE)
                    .append("estado", "iniciado");
            Document sort = new Document("proyecto.idproyecto", 1);

            List<Proyecto> list = proyectoServices.lookup(
                    filter,
                    sort,
                    page, size);
            if (!list.isEmpty()) {
                for (Proyecto p : list) {
                    for (ProyectoMiembro pm : p.getProyectoMiembro()) {

                        if (pm.getActive() && pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                            if (!proyectoPorColaboradorList.contains(p)) {
                                proyectoPorColaboradorList.add(p);
                            }

                        }
                    }
                }
                if (proyectoPorColaboradorList == null || proyectoPorColaboradorList.isEmpty()) {

                } else {
                    result = Boolean.TRUE;
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaPendiente(Sprint s)">
    private Boolean loadTarjetaPendiente(Sprint s) {
        Boolean result = Boolean.FALSE;
        List<Tarjeta> list = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document(orderBy, indexDescending);

            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", s.getProyectoView().getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", s.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"),
                    eq("userView.iduser", userLogged.getIduser()));

            list = tarjetaServices.lookup(filter, sortTarjeta, page, size,s.getProyectoView().getIdproyecto());

            if (list == null || list.isEmpty()) {

                return Boolean.FALSE;
            } else {

                list = tarjetaServices.validarFechaFinalSprintPlanTrabajo(list, s);

                tarjetaPendienteList.addAll(list);
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaProgreso(Sprint s)">
    private Boolean loadTarjetaProgreso(Sprint s) {
        Boolean result = Boolean.FALSE;
        List<Tarjeta> list = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
//            Document sortTarjeta = new Document("idtarjeta", -1);
            Document sortTarjeta = new Document(orderBy, indexDescending);
            /**
             * CargarTarjetas
             */

            Bson filter0 = eq("idproyecto", s.getProyectoView().getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", s.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "progreso"),
                    eq("userView.iduser", userLogged.getIduser()));

            list = tarjetaServices.lookup(filter, sortTarjeta, page, size,s.getProyectoView().getIdproyecto());
            if (list == null || list.isEmpty()) {
                return Boolean.FALSE;
            } else {
                list = tarjetaServices.validarFechaFinalSprintPlanTrabajo(list, s);
                tarjetaProgresoList.addAll(list);
                return Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaFinalizado(Sprint s)">

    private Boolean loadTarjetaFinalizado(Sprint s) {
        Boolean result = Boolean.FALSE;
        List<Tarjeta> list = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
//            Document sortTarjeta = new Document("idtarjeta", -1);
            Document sortTarjeta = new Document(orderBy, indexDescending);
            /**
             * CargarTarjetas
             */

            Bson filter0 = eq("idproyecto", s.getProyectoView().getIdproyecto());
            Bson filter = and(filter0, eq("idsprint", s.getIdsprint()), eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"),
                    eq("userView.iduser", userLogged.getIduser()));

            list = tarjetaServices.lookup(filter, sortTarjeta, page, size,s.getProyectoView().getIdproyecto());
            if (list == null || list.isEmpty()) {
                return Boolean.FALSE;
            } else {
                list = tarjetaServices.validarFechaFinalSprintPlanTrabajo(list, s);
                tarjetaFinalizadoList.addAll(list);
                return Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
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
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
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

    // <editor-fold defaultstate="collapsed" desc="List<Proyecto> loadProyecto()">
    public List<Proyecto> loadProyecto() {
        List<Proyecto> list = new ArrayList<>();
        try {
            list = proyectoClient.findAll();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="cargarProyectoEstadistica(List<Proyecto> proyectoList)">
    public void cargarProyectoEstadistica(List<Proyecto> proyectoList) {
        try {

            proyectoEstadisticaList = new ArrayList<>();
            if (proyectoList == null || proyectoList.isEmpty()) {

            } else {
                for (Proyecto p : proyectoList) {

                    proyectoEstadisticaList.add(calcularProyectoEstadistica(p));
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String color(Proyecto proyecto)">
    public String knobColor(Proyecto proyecto) {
        String result = "black";
        try {

            result = colorKnob.color(proyecto.getAvance());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String colorBarClassProyecto proyecto)">

    /**
     * Barras de cada tarjeta
     *
     * @param proyecto
     * @return
     */
    public String colorBarClass(Proyecto proyecto) {
        String result = "black";
        try {

            result = colorKnob.colorBarClassDashboard(proyecto.getAvance());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica calcularProyectoEstadistica(Proyecto proyecto)">
    public ProyectoEstadistica calcularProyectoEstadistica(Proyecto proyecto) {
        ProyectoEstadistica proyectoEstadistica = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());
        try {

            proyectoEstadistica = proyectoServices.calcularEstadistica(proyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoEstadistica;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica mostrarProyectoEstadistica(Proyecto proyecto) ">
    public ProyectoEstadistica mostrarProyectoEstadisticaInList(Proyecto proyecto) {
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

    // <editor-fold defaultstate="collapsed" desc="String goTablero(Proyecto proyecto)">
    public String goTablero(Proyecto proyecto) {
        try {
            proyectoSelected = proyecto;

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tablero.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String goSchedule()">

    public String goSchedule() {

        return goScheduleAction(proyectoSelected, sprintSelected);

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String goTimeLine(">

    public String goTimeLine() {

        return goTimeLineAction(proyectoSelected, sprintSelected);

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Integer  viewCantidadArchivo(Tarjeta tarjeta)">
    public Integer viewCantidadArchivo(Tarjeta tarjeta) {
        Integer result = 0;
        try {
            for (Archivo a : tarjeta.getArchivo()) {
                if (a.getActive()) {
                    result++;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Integer  diasPendientes(Tarjeta tarjeta) ">

    public Integer diasPendientes(Tarjeta tarjeta) {
        Integer result = 0;
        try {
//            result = DateUtil.diasEntreFechas(DateUtil.fechaActual(), tarjeta.getFechafinal());
            result = DateUtil.diasEntreFechas(tarjeta.getFechafinal(), DateUtil.fechaActual());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="String backPendiente(Tarjeta tarjeta)">
    public String backPendiente(Tarjeta tarjeta) {
        try {
            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                if (tarjeta.getForeaneo()) {
                    userViewForaneo = tarjeta.getUserView().get(0);
                }
                tarjetaProgresoList.remove(tarjeta);
                tarjeta.setColumna("pendiente");
                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("regresado a pendiente")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "backpendiente");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta regresada a pendiente")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                }
                tarjetaPendienteList.add(tarjeta);
                /*
                Ordena descendente la tarjeta
                 */

//                tarjetaPendienteList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaPendienteList);
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="String backProgreso(Tarjeta tarjeta)">
    public String backProgreso(Tarjeta tarjeta) {
        try {
            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                if (tarjeta.getForeaneo()) {
                    userViewForaneo = tarjeta.getUserView().get(0);
                }
                tarjetaFinalizadoList.remove(tarjeta);
                tarjeta.setColumna("progreso");
                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("regresado a progreso")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "backprogreso");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta regresado a progreso")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                }

                tarjetaProgresoList.add(tarjeta);
                /*
                Ordena descendente la tarjeta
                 */

//                tarjetaProgresoList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaProgresoList);
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String backPendienteFromFinalizado(Tarjeta tarjeta)">

    public String backPendienteFromFinalizado(Tarjeta tarjeta) {
        try {
            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                if (tarjeta.getForeaneo()) {
                    userViewForaneo = tarjeta.getUserView().get(0);
                }
                tarjetaFinalizadoList.remove(tarjeta);
                tarjeta.setColumna("pendiente");
                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("regresado a pendiente")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "backpendiente");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta regresada a pendiente")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                }

                tarjetaPendienteList.add(tarjeta);

                /*
                Ordena descendente la tarjeta
                 */
//                tarjetaPendienteList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaPendienteList);
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String nextProgreso(Tarjeta tarjeta)">

    public String nextProgreso(Tarjeta tarjeta) {
        try {

            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                if (tarjeta.getForeaneo()) {
                    userViewForaneo = tarjeta.getUserView().get(0);
                }

                tarjetaPendienteList.remove(tarjeta);
                tarjeta.setColumna("progreso");
                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("movido a progreso")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

                tarjetaProgresoList.add(tarjeta);

                /*
                Ordena descendente la tarjeta
                 */
                // tarjetaProgresoList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaProgresoList);
                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "nextprogreso");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta movida a progreso")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                    refresh();
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String nextFinalizadoFromPendiente(Tarjeta tarjeta)">

    public String nextFinalizadoFromPendiente(Tarjeta tarjeta) {
        try {

            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                if (tarjeta.getForeaneo()) {
                    userViewForaneo = tarjeta.getUserView().get(0);
                }

                tarjetaPendienteList.remove(tarjeta);
                tarjeta.setColumna("finalizado");
                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("movido a finalizado")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

                tarjetaFinalizadoList.add(tarjeta);
                /*
                Ordena descendente la tarjeta
                 */

                //   tarjetaFinalizadoList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaFinalizadoList);
                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "nextfinalizado");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta movida a finalizado")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                    refresh();
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="String nextFinalizadoTarjeta tarjeta)">
    public String nextFinalizado(Tarjeta tarjeta) {
        try {

            Boolean tieneTareasIncompletas = Boolean.FALSE;
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {

            } else {
                for (Tarea t : tarjeta.getTarea()) {
                    if (!t.getCompletado()) {

                        tieneTareasIncompletas = Boolean.TRUE;
                        break;
                    }
                }
            }

            if (tieneTareasIncompletas) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetatienetareaspendientes"));
                refresh();
                return "";
            }
            if (tarjeta.getForeaneo()) {
                userViewForaneo = tarjeta.getUserView().get(0);
            }
            Tarjeta tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDB.toString().equals(tarjeta.toString())) {
                FacesUtil.warningDialog(rf.fromMessage("warning.tarjetafuemodificadaporotrousuario"));
                refresh();
                return "";
            } else {
                tarjetaProgresoList.remove(tarjeta);
                tarjeta.setColumna("finalizado");
                tarjeta.setFechafinal(JmoordbCoreDateUtil.getFechaHoraActual());

                ActionHistory actionHistory = new ActionHistory.Builder()
                        .iduser(userLogged.getIduser())
                        .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                        .evento("movido a finalizado")
                        .clase(FacesUtil.nameOfClass())
                        .metodo(FacesUtil.nameOfMethod())
                        .build();

                tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
                if (!tarjetaServices.update(tarjeta)) {
                    FacesUtil.warningDialog(rf.fromMessage("warning.noseactualizolatarjeta"));
                    refresh();
                    return "";
                } else {
                    sendEmailTarjeta(tarjeta, "nextfinalizado");
                    /**
                     * Enviar WebSocket
                     */
                    MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                            .producer(FacesUtil.nameOfClass())
                            .action(FacesUtil.nameOfMethod())
                            .key("tarjeta")
                            .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                            .message("Tarjeta movida a finalizado")
                            .iduser(userLogged.getIduser())
                            .date(JmoordbCoreDateUtil.fechaHoraActual())
                            .build();
                    sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                }
                tarjetaFinalizadoList.add(tarjeta);
                /*
                Ordena descendente la tarjeta
                 */

//                tarjetaFinalizadoList = tarjetaServices.orderListForIdTarjetaReserve(tarjetaFinalizadoList);
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showDialog(String dialogo)">
    public String showDialog(String dialogo) {
        try {
            this.dialogoActivo = dialogo;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="save(Tarjeta tarjeta)">
    public void save(Tarjeta tarjeta) {
        try {

            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            if (proyectoSelected.getAgregarTarjetaDuplicada() == null || proyectoSelected.getAgregarTarjetaDuplicada()) {

                if (tarjetaServices.tarjetaExistInSprint(tarjeta.getTarjeta(), proyectoSelected.getIdproyecto(), sprintSelected.getIdsprint())) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existetarjetaconnombreigual"));

                    return;
                }
            }

            if (tarjeta.getFechafinal() == null || tarjeta.getFechafinal().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechafinal"));
                return;
            }
            if (tarjeta.getFechainicial() == null || tarjeta.getFechainicial().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechainicial"));
                return;
            }
            if (DateUtil.fechaMayor(tarjeta.getFechainicial(), tarjeta.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.fechainicialmayorfechafinal"));
                return;

            }

            // tarjeta.setFechainicial(JmoordbCoreDateUtil.fechaHoraActual());
            if (isProyectoForaneo) {
                tarjeta.setFechafinal(JmoordbCoreDateUtil.fechaHoraActual());
            }

            if (!isProyectoForaneo) {
                if (userViewDomainForCreateList == null || userViewDomainForCreateList.isEmpty()) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.seleccionecolaborador"));
                    return;
                }
            } else {
                /**
                 * Agrega el usuario logeado en el proyecto foraneo y al
                 * propietario
                 */
                var userViewForaneoForAdd = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());
                UserViewDomain u = new UserViewDomain(true, userViewForaneoForAdd);
                userViewDomainForCreateList.add(u);

                /**
                 * Agrega los propietarios del proyecto
                 */
                proyectoSelected.getProyectoMiembro().forEach(uv -> {
                    if (uv.getPropietario()) {
                        UserViewDomain u2 = new UserViewDomain(true, uv.getUserView());
                        userViewDomainForCreateList.add(u2);

                    }
                });

            }

            if (tarjeta.getEstimacion().equals("00:00")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nohayregistrosdetipotarjetas"));
                return;
            }

            if (!tarjetaServices.isEstimacionValida(tarjeta)) {
                return;
            }

            tarjeta.setTarjeta(deleteComillas(tarjeta.getTarjeta()));
            tarjeta.setDescripcion(deleteComillas(tarjeta.getDescripcion()));
            tarjeta.setBacklog(Boolean.FALSE);
            tarjeta.setArchivo(new ArrayList<>());
            tarjeta.setActive(Boolean.TRUE);
            tarjeta.setColumna("pendiente");
            tarjeta.setComentario(new ArrayList<>());

            tarjeta.setEtiqueta(new ArrayList<>());
            tarjeta.setIcono(iconoServices.findByIdicono(1L).get());

            tarjeta.setIdproyecto(proyectoSelected.getIdproyecto());
            tarjeta.setIdsprint(sprintSelected.getIdsprint());
            tarjeta.setImpedimento(new ArrayList<>());
            tarjeta.setTarea(new ArrayList<>());
            List<UserView> userViewList = new ArrayList<>();

            userViewDomainForCreateList.stream().filter(uvd -> (uvd.getSelected())).forEachOrdered(uvd -> {
                userViewList.add(new UserView(uvd.getUserView().getIduser(), uvd.getUserView().getName(), uvd.getUserView().getPhoto(), uvd.getUserView().getEmail(), userLogged.getRecibirNotificacion()));
            });
            if (userViewList == null || userViewList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.seleccionecolaborador"));
                return;
            }
            tarjeta.setUserView(userViewList);
            tarjeta.setForeaneo(isProyectoForaneo);

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("crear")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            tarjeta.setActionHistory(actionHistoryList);
             tarjeta.setLastModification(actionHistory.getFecha());
            Optional<Tarjeta> tarjetaSaved = tarjetaServices.save(tarjeta);
            if (!tarjetaSaved.isPresent()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.save"));

            } else {
                tarjeta.setIdtarjeta(tarjetaSaved.get().getIdtarjeta());
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.savetarjeta"));
                }

                sendEmailTarjeta(tarjeta, "crear");
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta creada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                closeOverlayPanel("PF('overlayPanelTarjetaAgregar').hide()");
                prepareNew();

                refreshCache(tarjeta, actionHistory.getEvento());
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="editar(Tarjeta tarjeta)">

    public void editar(Tarjeta tarjeta) {
        try {

            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");

            if (tarjeta.getFechafinal() == null || tarjeta.getFechafinal().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechafinal"));
                return;
            }
            if (tarjeta.getFechainicial() == null || tarjeta.getFechainicial().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechainicial"));
                return;
            }
            if (DateUtil.fechaMayor(tarjeta.getFechainicial(), tarjeta.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.fechainicialmayorfechafinal"));
                return;

            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();

            if (!tarjetaDBNow.equals(this.tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }

            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }
            if (!tarjetaServices.isEstimacionValida(tarjeta)) {
                return;
            }
            if (proyectoSelected.getAgregarTarjetaDuplicada() == null || proyectoSelected.getAgregarTarjetaDuplicada()) {

                Optional<Tarjeta> tarjetaOptional = tarjetaServices.tarjetaConIgualNombreInSprint(tarjeta.getTarjeta(), proyectoSelected.getIdproyecto(), sprintSelected.getIdsprint());
                if (tarjetaOptional.isPresent()) {

                    if (!tarjeta.getIdtarjeta().equals(tarjetaOptional.get().getIdtarjeta())) {

                        FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existetarjetaconnombreigual"));
                        return;
                    }

                }
            }
            if (tarjeta.getFechafinal() == null || tarjeta.getFechafinal().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.ingresefechafinal"));
                return;
            }
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
            tarjeta.setTarjeta(deleteComillas(tarjeta.getTarjeta()));
            tarjeta.setDescripcion(deleteComillas(tarjeta.getDescripcion()));
            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                sendEmailTarjeta(tarjeta, "editar");
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta editada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                closeOverlayPanel("PF('overlayPanelTarjetaEditar').hide()");

                refreshCache(tarjeta, actionHistory.getEvento());
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="addComentario(Tarjeta tarjeta)">

    public void addComentario(Tarjeta tarjeta) {
        try {

            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            if (!isChangeInRowDatatableComentario && isButtonSavePressed) {
                closeAddComentario(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));

                closeAddComentario(tarjeta);
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("comentario")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            List<Comentario> comentarioList = new ArrayList();
            if (tarjeta.getComentario() == null || tarjeta.getComentario().isEmpty()) {

            } else {
                comentarioList = tarjeta.getComentario();

                for (Comentario c : comentarioList) {
                    if (c.getComentario().equals("")) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.comentariovacio"));
                        return;
                    }
                    Integer count = 0;
                    count = tarjeta.getComentario().stream().filter(t1 -> (c.getComentario().equals(t1.getComentario()))).map(_item -> 1).reduce(count, Integer::sum);
                    if (count > 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.comentarioduplicado") + " " + c.getComentario());
                        return;
                    }
                }

            }

            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));
            } else {

                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                sendEmailTarjeta(tarjeta, "comentario");
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta se agrego un comentario")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                closeAddComentario(tarjeta);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void closeAddComentario(Tarjeta tarjeta)">

    public void closeAddComentario(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaComentario').hide()");

        refreshCache(tarjeta, "comentario");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeAddColaborador(Tarjeta tarjeta)">
    public void closeAddColaborador(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaColaboradorDataTable').hide()");
        refreshCache(tarjeta, "colaborador");
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="addEtiqueta(Tarjeta tarjeta)">

    public void addEtiqueta(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            if (!isChangeInRowDatatableEtiqueta && isButtonSavePressed) {
                closeAddEtiqueta(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                closeAddEtiqueta(tarjeta);
                return;

            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("agregar etiqueta")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
            List<Etiqueta> etiquetaList = new ArrayList();
            if (tarjeta.getEtiqueta() == null || tarjeta.getEtiqueta().isEmpty()) {

            } else {
                etiquetaList = tarjeta.getEtiqueta();

                for (Etiqueta e : etiquetaList) {
                    if (e.getEtiqueta().equals("")) {
                        FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.etiquetavacia"));
                        return;
                    }
                    Integer count = 0;
                    count = tarjeta.getEtiqueta().stream().filter(t1 -> (e.getEtiqueta().equals(t1.getEtiqueta()))).map(_item -> 1).reduce(count, Integer::sum);
                    if (count > 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.etiquetaduplicada") + " " + e.getEtiqueta());
                        return;
                    }
                }

            }

            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta con etiqueta agregada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                closeAddEtiqueta(tarjeta);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeAddEtiqueta(Tarjeta tarjeta)">
    public void closeAddEtiqueta(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaEtiqueta').hide()");
        refreshCache(tarjeta, "etiqueta");
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void addTarea(Tarjeta tarjeta)">

    public void addTarea(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            if (!isChangeInRowDatatableTarea && isButtonSavePressed) {
                closeAddTarea(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.errorDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));

                closeAddTarea(tarjeta);
                return;

            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("agregar tarea")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            List<Tarea> tareaList = new ArrayList();
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {

            } else {
                tareaList = tarjeta.getTarea();

                for (Tarea t : tareaList) {
                    if (t.getTarea().equals("")) {
                        FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.tareavacia"));
                        return;
                    }
                    Integer count = 0;
                    count = tarjeta.getTarea().stream().filter(t1 -> (t.getTarea().equals(t1.getTarea()))).map(_item -> 1).reduce(count, Integer::sum);
                    if (count > 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.tareaduplicada") + " " + t.getTarea());
                        return;
                    }
                }

            }
            /**
             * Verifica
             */
            if (tareasOld == null || tareasOld.isEmpty()) {

            } else {
                if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {

                } else {

                    Integer count = 0;
                    for (Tarea t : tarjeta.getTarea()) {

                        Optional<Tarea> tareaOptional = tareasOld.stream().filter(x -> x.getTarea().equals(t.getTarea())).findFirst();
                        if (tareaOptional.isPresent()) {

                            if (!tareaOptional.get().getCompletado().equals(t.getCompletado())) {

                                UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());

                                tarjeta.getTarea().get(count).setUserView(userView);
                            }
                        }
                        count++;
                    }
                }
            }
// tarjeta.setTarea(tarjetaServices.ordenarTareaPorOrden(tarjeta));
            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.update"));

            } else {

                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta con tarea agregada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                closeAddTarea(tarjeta);

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void closeAddTarea(Tarjeta tarjeta)">

    public void closeAddTarea(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaTarea').hide()");
        refreshCache(tarjeta, "tarea");
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void addImpedimento(Tarjeta tarjeta)">
    public void addImpedimento(Tarjeta tarjeta) {
        try {
            if (inputTextImpedimento == null || inputTextImpedimento.equals("")) {
            } else {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.presioneenterooclicbotonagregar"));
                return;
            }

            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");

            if (!isChangeInRowDatatableImpedimento && isButtonSavePressed) {
                closeAddImpedimento(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                closeAddImpedimento(tarjeta);
                return;

            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("agregar impedimento")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            List<Impedimento> impedimentoList = new ArrayList();
            if (tarjeta.getImpedimento() == null || tarjeta.getImpedimento().isEmpty()) {

            } else {
                impedimentoList = tarjeta.getImpedimento();

                for (Impedimento i : impedimentoList) {
                    if (i.getImpedimento().equals("")) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.impedimentovacio"));
                        return;
                    }
                    Integer count = 0;
                    count = tarjeta.getImpedimento().stream().filter(t1 -> (i.getImpedimento().equals(t1.getImpedimento()))).map(_item -> 1).reduce(count, Integer::sum);
                    if (count > 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.impedimentoduplicado") + " " + i.getImpedimento());
                        return;
                    }
                }

            }

            /**
             * Verifica impedimento
             */
            if (impedimentoOld == null || impedimentoOld.isEmpty()) {

            } else {
                if (tarjeta.getImpedimento() == null || tarjeta.getImpedimento().isEmpty()) {

                } else {
                    Integer count = 0;
                    for (Impedimento i : tarjeta.getImpedimento()) {

                        Optional<Impedimento> impedimentoOptional = impedimentoOld.stream().filter(x -> x.getImpedimento().equals(i.getImpedimento())).findFirst();
                        if (impedimentoOptional.isPresent()) {

                            if (!impedimentoOptional.get().getCompletado().equals(i.getCompletado())) {

                                UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());

                                tarjeta.getImpedimento().get(count).setUserView(userView);

                            }

                        }

                        count++;
                    }

                }
            }

            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta con impedimento agregado")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                closeAddImpedimento(tarjeta);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeAddImpedimento(Tarjeta tarjeta)">
    public void closeAddImpedimento(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaImpedimento').hide()");
        refreshCache(tarjeta, "impedimento");
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void addArchivo(Tarjeta tarjeta)">

    public void addArchivo(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            if (!isChangeInRowDatatableArchivo && isButtonSavePressed) {
                closeAddArchivo(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                closeAddArchivo(tarjeta);
                return;

            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }
            Boolean haveFile = false;

            if (file != null) {
                if (file.getFileName() == null) {

                } else {
                    if (!fileWasUploaded) {
                        FacesUtil.warningDialog(rf.fromCore("warning.advertencia"), rf.fromCore("warning.agregearchivoypresionebotonsubirarchivo"));
                        return;
                    }
                    haveFile = true;
                }

            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("archivo")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            List<Archivo> archivoList = new ArrayList();
            if (tarjeta.getArchivo() == null || tarjeta.getArchivo().isEmpty()) {

            } else {
                archivoList = tarjeta.getArchivo();

                for (Archivo a : archivoList) {
                    if (a.getPath().equals("")) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.archivovacio"));
                        return;
                    }
                    Integer count = 0;
                    count = tarjeta.getArchivo().stream().filter(t1 -> (a.getPath().equals(t1.getPath()))).map(_item -> 1).reduce(count, Integer::sum);
                    if (count > 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.archivoduplicado") + " " + a.getPath());
                        return;
                    }
                }

            }

            if (!tarjetaServices.update(tarjeta)) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.update"));
            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta con archivo agregado")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                sendEmailTarjeta(tarjeta, "subirarchivo");
                closeAddArchivo(tarjeta);

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeAddArchivo(Tarjeta tarjeta)">
    public void closeAddArchivo(Tarjeta tarjeta) {
        closeOverlayPanel("PF('overlayPanelTarjetaArchivo').hide()");
        refreshCache(tarjeta, "archivo");
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="clonar(Tarjeta tarjeta)">
    public void clonar(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;

            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            if (tarjetaServices.tarjetaExistInSprint(tarjeta.getTarjeta(), proyectoSelected.getIdproyecto(), sprintSelected.getIdsprint())) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.existetarjetaconnombreigual"));
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("tarjeta creada a partir de una clonación")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
             actionHistoryList.addAll(tarjeta.getActionHistory());
            actionHistoryList.add(actionHistory);

            tarjeta.setActionHistory(actionHistoryList);
 tarjeta.setLastModification(actionHistory.getFecha());
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {
            } else {
                /**
                 * Pasa las tareas asignando completado a FALSE
                 */
                List<Tarea> tareaList = new ArrayList<>();
                for (Tarea tarea : tarjeta.getTarea()) {
                    tarea.setCompletado(Boolean.FALSE);
                    if (tarea.getActive()) {
                        tareaList.add(tarea);
                    }
                }
                tarjeta.setTarea(tareaList);
            }
            this.tarjetaClonarSelected.setComentario(new ArrayList<>());
            this.tarjetaClonarSelected.setImpedimento(new ArrayList<>());
            this.tarjetaClonarSelected.setArchivo(new ArrayList<>());

            if (!tarjetaServices.save(tarjeta).isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.clone"));
            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta clonada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                if (showMessagesOfActionInFormTablero.get()) {

                    FacesUtil.successMessage(rf.fromMessage("info.clonetarjeta"));
                }

                closeOverlayPanel("PF('overlayPanelTarjetaClonar').hide()");
                refreshCache(tarjeta, "clonar");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="archivar(Tarjeta tarjeta)">

    public void archivar(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;

            }
            tarjeta.setActive(Boolean.FALSE);
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("archivar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
            if (!tarjetaServices.update(tarjeta)) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.archive"));
            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.archivartarjeta"));
                }

                sendEmailTarjeta(tarjeta, "archivar");
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta archivada")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.TRUE);
                closeOverlayPanel("PF('overlayPanelTarjetaArchivar').hide()");
                refreshCache(tarjeta, "archivar");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void changeColaborador(Tarjeta tarjeta)">
    public void changeColaborador(Tarjeta tarjeta) {
        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            if (!isChangeInRowDatatableColaborador && isButtonSavePressed) {

                closeAddColaborador(tarjeta);
                return;
            }
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                closeAddColaborador(tarjeta);
                return;

            }

            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }

            if (userViewDomainList == null || userViewDomainList.isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.debeseleccionaralmenosuncolaborador"));
                return;
            }

            /**
             * Quita los que no estan marcados
             */
            List<UserViewDomain> list = new ArrayList<>();
            for (UserViewDomain uvd : userViewDomainList) {
                if (uvd.getSelected()) {
                    list.add(uvd);
                }
            }
            userViewDomainList = new ArrayList<>();
            userViewDomainList.addAll(list);
            // Verifica si es una tarjeta creada por usuario foreano

            if (tarjeta.getForeaneo()) {

                Integer pos = -1;
                for (UserViewDomain uvd : userViewDomainList) {
                    if (userViewForaneo.getIduser().equals(uvd.getUserView().getIduser())) {
                        pos++;
                        break;
                    }
                }

                if (pos == -1) {
                    // "Removieron el usuario foraneo el sistema lo inserta nuevamente
                    userViewDomainList.add(0, new UserViewDomain(Boolean.TRUE, userViewForaneo));

                } else {
                    if (pos > 0) {
                        userViewDomainList.remove(new UserViewDomain(Boolean.TRUE, userViewForaneo));
                        userViewDomainList.add(0, new UserViewDomain(Boolean.TRUE, userViewForaneo));
                    }
                }

            }

            userViewSelectedList = new ArrayList<>();
            for (UserViewDomain uvd : userViewDomainList) {
                userViewSelectedList.add(uvd.getUserView());
            }

            if (userViewSelectedList.equals(tarjetaColaboradorSelected.getUserView())) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.mismoscolaboradores"));
                return;

            }
            tarjeta.setUserView(userViewSelectedList);
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("cambio de colaborador")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());
            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.cambiarcolaborador"));
                /**
                 * Envia email al colaborador si se asigno a
                 */

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.cambiarcolaboradortarjeta"));
                }

                sendEmailChangeColaborador(tarjeta);
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Tarjeta con cambio de colaborador")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);
                closeOverlayPanel("PF('overlayPanelTarjetaColaboradorDataTable').hide()");
                refreshCache(tarjeta, "colaborador");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareNew()">
    public String prepareNew() {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            dialogVisibleAddWebSocket = Boolean.TRUE;
            this.tarjetaDB = new Tarjeta();
            dialogoActivo = "add";
            message = "";

            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            tarjetaSelected = new Tarjeta();
            if (JmoordbCoreDateUtil.fechaMayor(sprintSelected.getFechainicial(), JmoordbCoreDateUtil.getFechaHoraActual())) {
                tarjetaSelected.setFechainicial(sprintSelected.getFechainicial());
            } else {
                tarjetaSelected.setFechainicial(JmoordbCoreDateUtil.getFechaHoraActual());
            }

            tarjetaSelected.setFechafinal(sprintSelected.getFechafinal());
            tarjetaSelected.setEstimacion("5:30");
            tarjetaSelected.setPrioridad(rf.fromMessage("selectonemenu.prioridadmedia"));
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareColaborador(Tarjeta tarjeta)">

    public String prepareColaborador(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);

            this.tarjetaColaboradorSelected = validarSiCambioEnPrepare(tarjeta);
            userViewSelectedList = tarjeta.getUserView();
            userViewSelectedOldList = tarjeta.getUserView();
            if (tarjeta.getForeaneo()) {
                userViewForaneo = tarjeta.getUserView().get(0);
            }
            this.tarjetaColaboradorSelected = tarjeta;
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
            isChangeInRowDatatableColaborador = Boolean.FALSE;

            /**
             * Carga la lista de userViewDomain
             */
            userViewDomainList = new ArrayList<>();
            Boolean found = Boolean.FALSE;
            for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                found = Boolean.FALSE;
                for (UserView uv : tarjetaColaboradorSelected.getUserView()) {
                    if (pm.getUserView().getIduser().equals(uv.getIduser())) {
                        found = Boolean.TRUE;
                        break;
                    }
                }
                UserViewDomain userViewDomain = new UserViewDomain(found, pm.getUserView());
                userViewDomainList.add(userViewDomain);
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareEditar(Tarjeta tarjeta)">

    public String prepareEditar(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);

            this.tarjetaEditarSelected = validarSiCambioEnPrepare(tarjeta);

            userViewSelectedList = tarjeta.getUserView();
            userViewSelectedOldList = tarjeta.getUserView();
            if (tarjeta.getForeaneo()) {
                userViewForaneo = tarjeta.getUserView().get(0);
            } else {
                userViewForaneo = new UserView();
            }

            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareView(Tarjeta tarjeta)">

    public String prepareView(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            this.tarjetaViewSelected = validarSiCambioEnPrepare(tarjeta);
            userViewSelectedList = tarjeta.getUserView();
            userViewSelectedOldList = tarjeta.getUserView();
            if (tarjeta.getForeaneo()) {
                userViewForaneo = tarjeta.getUserView().get(0);
            } else {
                userViewForaneo = new UserView();
            }
            //     this.tarjetaEditarSelected = tarjeta;

            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareTarea(Tarjeta tarjeta)">

    public String prepareTarea(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            inputTextTarea = "";
            isChangeInRowDatatableTarea = Boolean.FALSE;
            this.tarjetaTareaSelected = validarSiCambioEnPrepare(tarjeta);
//            tarjetaTareaSelected.setTarea(tarjetaServices.ordenarTareaPorOrden(tarjetaTareaSelected));
//            tarjetaTareaSelected.setTarea(tarjetaServices.ordenarTareaPorCompletadoDescendente(tarjetaTareaSelected));
            if (tarjetaTareaSelected.getTarea() == null || tarjetaTareaSelected.getTarea().isEmpty()) {

            } else {
                tarjetaTareaSelected.getTarea().forEach(t -> {
                    tareasOld.add(t);
                });
            }
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareImpedimento(Tarjeta tarjeta)">

    public String prepareImpedimento(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            inputTextImpedimento = "";
            isChangeInRowDatatableImpedimento = Boolean.FALSE;
            JmoordbCoreUtil.copyBeans(this.tarjetaImpedimentoSelected, validarSiCambioEnPrepare(tarjeta));

            tarjetaImpedimentoSelected.setImpedimento(tarjetaServices.ordenarImpedimentoDescendente(tarjetaImpedimentoSelected));
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
            if (tarjetaImpedimentoSelected.getTarea() == null || tarjetaImpedimentoSelected.getTarea().isEmpty()) {

            } else {
                tarjetaImpedimentoSelected.getImpedimento().forEach(i -> {
                    impedimentoOld.add(i);
                });
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareArchivo(Tarjeta tarjeta)">

    public String prepareArchivo(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            this.tarjetaArchivoSelected = validarSiCambioEnPrepare(tarjeta);
            isChangeInRowDatatableArchivo = Boolean.FALSE;
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareComentario(Tarjeta tarjeta)">
    public String prepareComentario(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            inputTextComentario = "";
            isChangeInRowDatatableComentario = Boolean.FALSE;
            this.tarjetaComentarioSelected = validarSiCambioEnPrepare(tarjeta);
            userViewSelectedList = tarjeta.getUserView();
            comentarioOldList = new ArrayList<>();
            if (tarjeta.getComentario() == null || tarjeta.getComentario().isEmpty()) {

            } else {
                for (Comentario c : tarjeta.getComentario()) {
                    Comentario comentario = new Comentario();
                    JmoordbCoreUtil.copyBeans(comentario, c);
                    comentarioOldList.add(comentario);
                }
            }

            if (tarjeta.getForeaneo()) {
                userViewForaneo = tarjeta.getUserView().get(0);
            } else {
                userViewForaneo = new UserView();
            }
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareEtiqueta(Tarjeta tarjeta)">

    public String prepareEtiqueta(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            inputTextEtiqueta = "";
            isChangeInRowDatatableEtiqueta = Boolean.FALSE;
            this.tarjetaEtiquetaSelected = validarSiCambioEnPrepare(tarjeta);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareClonar(Tarjeta tarjeta)">

    public String prepareClonar(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            this.tarjetaClonarSelected = validarSiCambioEnPrepare(tarjeta);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareArchivar(Tarjeta tarjeta)">

    public String prepareArchivar(Tarjeta tarjeta) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            sprintSelectedFromTarjeta(tarjeta);
            proyectoSelectedFromTarjeta(tarjeta);
            this.tarjetaArchivarSelected = validarSiCambioEnPrepare(tarjeta);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Comentario>  ordenarComentarioPorFechaDescendente(Tarjeta tarjeta)">
    public List<Comentario> ordenarComentarioPorFechaDescendente(Tarjeta tarjeta) {

        return tarjetaServices.ordenarComentarioPorFechaDescendente(tarjeta);
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Comentario>  ordenarTareaPorCompletadoDescendente(Tarjeta tarjeta)">

    public List<Tarea> ordenarTareaPorCompletadoDescendente(Tarjeta tarjeta) {

        return tarjetaServices.ordenarTareaPorCompletadoDescendente(tarjeta);
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" List<Impedimento> ordenarImpedimentoDescendente(Tarjeta tarjeta)">

    public List<Impedimento> ordenarImpedimentoDescendente(Tarjeta tarjeta) {

        return tarjetaServices.ordenarImpedimentoDescendente(tarjeta);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isMiembroAutorizedInTarjetaForaneaTarjeta tarjeta)">
    public Boolean isMiembroAutorizedInTarjetaForanea(Tarjeta tarjeta) {

        return tarjetaServices.isMiembroAutorizedInTarjetaForanea(tarjeta, userLogged, userViewForaneo);

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeOverlayPanel(String panel) ">
    private void closeOverlayPanel(String panel) {
        try {
            PrimeFaces.current().executeScript(panel);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void loadIcono()">
    private void loadIcono() {
        try {
            iconoConverterServices.add(iconoServices.findAll());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean renderedMenuButton(Tarjeta tarjeta)">
    public Boolean renderedMenuButton(Tarjeta tarjeta) {
        try {

            if (tarjeta == null) {
                return Boolean.FALSE;
            }
            if (tarjeta.getColumna().equals("pendiente")
                    || tarjeta.getColumna().equals("progreso")) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {

//               FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Boolean.FALSE;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView>  cargarUserViewComoColaboradores(Tarjeta tarjetaSelected)">
    private List<UserView> cargarUserViewComoColaboradores() {

        List<UserView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {
            if (proyectoSelected.getProyectoMiembro().size() >= tarjetaColaboradorSelected.getUserView().size()) {

                for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {

                    found = Boolean.FALSE;
                    for (UserView uv : userViewSelectedList) {
                        if (pm.getUserView().getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;

                            break;
                        }
                    }
                    if (!found) {

                        result.add(pm.getUserView());
                    }
                }

            }
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView>  cargarUserViewComoColaboradores(Tarjeta tarjetaSelected)">
    private List<UserView> cargarUserViewComoColaboradoresOld(Tarjeta tarjetaSelected) {

        List<UserView> result = new ArrayList<>();
        tarjetaSelected.getUserView();
        Boolean found = Boolean.FALSE;
        try {
            if (proyectoSelected.getProyectoMiembro().size() >= tarjetaSelected.getUserView().size()) {
                for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                    found = Boolean.FALSE;
                    for (UserView uv : tarjetaSelected.getUserView()) {
                        if (pm.getUserView().getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(pm.getUserView());
                    }
                }

            } else {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.colaboradorestarjetasnopertenecenalproyecto"));
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView> completeUserView(String query)">
    public List<UserView> completeUserView(String query) {
        List<UserView> result = new ArrayList<>();
        try {

            List<UserView> userViewList = cargarUserViewComoColaboradores();

            String queryLowerCase = query.toLowerCase();

            result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="  autocompleteSelectedEvent(SelectEvent event)">
    public void autocompleteSelectedEvent(SelectEvent<UserView> event) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="  autocompleteUnSelectedEvent(SelectEvent event)">

    public void autocompleteUnSelectedEvent(SelectEvent event) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void loadSchedule()">
    public void loadSchedule() {
        try {
            lazyEventModel = new LazyScheduleModel() {

                @Override
                public void loadEvents(LocalDateTime start, LocalDateTime end) {

                    tarjetaPendienteList.forEach((a) -> {
                        String userName = "";
                        for (UserView uv : a.getUserView()) {
                            userName += uv.getName() + " ";
                        }
                        DefaultScheduleEvent event = DefaultScheduleEvent.builder()
                                .title("(" + a.getTarjeta() + ") " + userName)
                                .startDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechainicial()))
                                .endDate(JmoordbCoreDateUtil.convertToLocalDateTimeViaInstant(a.getFechafinal()))
                                .description(a.getColumna() + "(" + a.getColumna().substring(0, 1) + ")")
                                .build();

                        addEvent(event);

                    });
                }

            };

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String visualizarMisTarjetas()">
    /**
     * Visualiza las columnas del tablero
     *
     * @return
     */
    public String visualizarMisTarjetas() {
        try {

            refresh();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String visualizarMisTarjetas()">

    /**
     * Visualiza las columnas del tablero
     *
     * @return
     */
    public String descendenteChange() {
        try {
            if (descending) {
                indexDescending = -1;
            } else {
                indexDescending = 1;
            }
            refresh();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String visualizarDetallesProyecto()">

    public String visualizarDetallesProyecto() {
        try {

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="showProyectoForaneo()">
    public Boolean showProyectoForaneo() {

        return isProyectoForaneo;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="renderedPrivadoMiembro()">
    public Boolean renderedComentarioPrivadoMiembro(Comentario comentario) {
        Boolean result = Boolean.FALSE;
        try {

            if (!comentario.getPrivado()) {
                result = Boolean.TRUE;
            } else {
                if (!isProyectoForaneo) {
                    result = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Integer tareasPendientes(Tarjeta tarjeta)">
    public Integer tareasPendientes(Tarjeta tarjeta) {
        Integer result = 0;
        try {
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {
                result = 0;
            } else {
                for (Tarea t : tarjeta.getTarea()) {
                    if (t.getCompletado()) {
                        result++;
                    }
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void agregarRowTarea()">
    public void agregarRowTarea() {
        try {

            if (inputTextTarea == null || inputTextTarea.equals("")) {
                inputTextTarea = "";
                FacesUtil.warningMessage(rf.fromMessage("warning.ingresetexto"));
                return;
            }
            UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());

            Tarea tarea = new Tarea(inputTextTarea, Boolean.FALSE, Boolean.TRUE, 0, userView);

            if (tarjetaTareaSelected.getTarea() == null || tarjetaTareaSelected.getTarea().isEmpty()) {
                tarjetaTareaSelected.getTarea().add(tarea);

            } else {
                if (!tareaFindFirst(tarjetaTareaSelected.getTarea(), "").isPresent()) {
                    tarjetaTareaSelected.getTarea().add(0, tarea);
                    // FacesUtil.warningMessage(rf.fromMessage("info.registroagregadoparaeditar"));
                } else {
                    FacesUtil.warningMessage(rf.fromMessage("info.registroidentico"));
                }

            }
            isButtonSavePressed = Boolean.FALSE;
            inputTextTarea = "";
            PrimeFaces.current().ajax().update("dataTableTarea");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void agregarRowComentario()">
    public void agregarRowComentario() {
        try {

            if (inputTextComentario == null || inputTextComentario.equals("")) {

                FacesUtil.warningMessage(rf.fromMessage("warning.ingresetexto"));
                return;
            }

            UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());
            Comentario comentario = new Comentario(inputTextComentario, Boolean.FALSE, JmoordbCoreDateUtil.fechaHoraActual(), Boolean.TRUE, userView);

            if (tarjetaComentarioSelected.getComentario() == null || tarjetaComentarioSelected.getComentario().isEmpty()) {
                tarjetaComentarioSelected.getComentario().add(comentario);

            } else {

                if (!comentarioFindFirst(tarjetaComentarioSelected.getComentario(), "").isPresent()) {
                    tarjetaComentarioSelected.getComentario().add(0, comentario);

                } else {
                    FacesUtil.warningMessage(rf.fromMessage("info.registroidentico"));
                }
            }
            isButtonSavePressed = Boolean.FALSE;
            inputTextComentario = "";
            PrimeFaces.current().ajax().update("dataTableComentario");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void agregarRowImpedimento()">
    public void agregarRowImpedimento() {
        try {

            if (inputTextImpedimento == null || inputTextImpedimento.equals("")) {
                inputTextImpedimento = "";
                FacesUtil.warningMessage(rf.fromMessage("warning.ingresetexto"));
                return;
            }
            UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());

            Impedimento impedimento = new Impedimento(inputTextImpedimento, JmoordbCoreDateUtil.fechaHoraActual(), Boolean.FALSE, userView, Boolean.TRUE);

            if (tarjetaImpedimentoSelected.getImpedimento() == null || tarjetaImpedimentoSelected.getImpedimento().isEmpty()) {
                tarjetaImpedimentoSelected.getImpedimento().add(impedimento);

            } else {
                Boolean found = Boolean.FALSE;
                for (Impedimento i : tarjetaImpedimentoSelected.getImpedimento()) {
                    if (i.getImpedimento().equals("")) {
                        found = Boolean.TRUE;
                        break;
                    }
                }
                if (!found) {

                    tarjetaImpedimentoSelected.getImpedimento().add(0, impedimento);

                }
            }
            isButtonSavePressed = Boolean.FALSE;
            inputTextImpedimento = "";
            PrimeFaces.current().ajax().update("dataTableImpedimento");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void agregarRowArchivo(Archivo archivo)">
    public void agregarRowArchivo(Archivo archivo) {
        try {

            if (tarjetaArchivoSelected.getArchivo() == null || tarjetaArchivoSelected.getArchivo().isEmpty()) {
                tarjetaArchivoSelected.getArchivo().add(archivo);

            } else {

                if (!archivoFindFirst(tarjetaArchivoSelected.getArchivo(), "").isPresent()) {
                    tarjetaArchivoSelected.getArchivo().add(0, archivo);
                    //  FacesUtil.successMessage(rf.fromMessage("info.registroagregadoparaeditar"));

                } else {
                    FacesUtil.warningMessage(rf.fromMessage("info.registroidentico"));
                }

            }
            isButtonSavePressed = Boolean.FALSE;
            //  FacesUtil.successMessage(rf.fromMessage("info.archivoagregadoparaeditar"));
            PrimeFaces.current().ajax().update("dataTableArchivo");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void agregarRowArchivo()">
    public void agregarRowArchivo() {
        try {
            Boolean haveFile = false;
            if (file != null) {
                if (file.getFileName() == null) {

                } else {
                    if (!fileWasUploaded) {
                        FacesUtil.warningDialog(rf.fromCore("warning.advertencia"), rf.fromCore("warning.agregearchivoypresionebotonsubirarchivo"));
                        return;
                    }
                    haveFile = true;
                }

            }

            Archivo archivo = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.TRUE);

            if (tarjetaArchivoSelected.getArchivo() == null || tarjetaArchivoSelected.getArchivo().isEmpty()) {
                tarjetaArchivoSelected.getArchivo().add(archivo);

            } else {

                if (!archivoFindFirst(tarjetaArchivoSelected.getArchivo(), "").isPresent()) {
                    tarjetaArchivoSelected.getArchivo().add(0, archivo);
                    // FacesUtil.successMessage(rf.fromMessage("info.registroagregadoparaeditar"));
                } else {
                    FacesUtil.warningMessage(rf.fromMessage("info.registroidentico"));
                }

            }
            isButtonSavePressed = Boolean.FALSE;

            PrimeFaces.current().ajax().update("dataTableArchivo");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void agregarRowEtiqueta()">
    public void agregarRowEtiqueta() {
        try {
            if (inputTextEtiqueta == null || inputTextEtiqueta.equals("")) {
                inputTextEtiqueta = "";
                FacesUtil.warningMessage(rf.fromMessage("warning.ingresetexto"));
                return;
            }
            Etiqueta etiqueta = new Etiqueta(inputTextEtiqueta, Boolean.TRUE, "primary");
            if (tarjetaEtiquetaSelected.getEtiqueta() == null || tarjetaEtiquetaSelected.getEtiqueta().isEmpty()) {
                tarjetaEtiquetaSelected.getEtiqueta().add(etiqueta);
            } else {

                if (!eqiquetaFindFirst(tarjetaEtiquetaSelected.getEtiqueta(), "").isPresent()) {
                    tarjetaEtiquetaSelected.getEtiqueta().add(0, etiqueta);

                } else {
                    FacesUtil.successMessage(rf.fromMessage("info.registroidentico"));
                }

            }
            isButtonSavePressed = Boolean.FALSE;

            PrimeFaces.current().ajax().update("dataTableEtiqueta");
            inputTextEtiqueta = "";
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowEditTarea(RowEditEvent<Tarea> event)">
    public void onRowEditTarea(RowEditEvent<Tarea> event) {
        FacesUtil.warningMessage(rf.fromCore("warning.recuerdepresionarbotonguardar"));

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowEditComentario(RowEditEvent<Comentario> event)">

    public void onRowEditComentario(RowEditEvent<Comentario> event) {
        FacesUtil.warningMessage(rf.fromCore("warning.recuerdepresionarbotonguardar"));

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowEditImpedimento(RowEditEvent<Impedimento> event)">

    public void onRowEditImpedimento(RowEditEvent<Impedimento> event) {
        FacesUtil.warningMessage(rf.fromCore("warning.recuerdepresionarbotonguardar"));

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowEditArchivo(RowEditEvent<Archivo> event) ">

    public void onRowEditArchivo(RowEditEvent<Archivo> event) {
        FacesUtil.warningMessage(rf.fromCore("warning.recuerdepresionarbotonguardar"));

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowEditEtiqueta(RowEditEvent<Etiqueta> event)">

    public void onRowEditEtiqueta(RowEditEvent<Etiqueta> event) {
        FacesUtil.warningMessage(rf.fromCore("warning.recuerdepresionarbotonguardar"));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void deleteTarea(Tarea tarea)">
    public void deleteTarea(Tarea tarea) {
        try {
            isButtonSavePressed = Boolean.FALSE;
            this.tarjetaTareaSelected.getTarea().remove(tarea);
            // ajaxDeleteEventDatatable(rf.fromMessage("info.tarearemovidarecuerdeguardar"), "form:dataTableTarea");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="deleteComentario(Comentario comentario)">
    public void deleteComentario(Comentario comentario) {
        try {
            this.tarjetaComentarioSelected.getComentario().remove(comentario);
            isButtonSavePressed = Boolean.FALSE;
            //  ajaxDeleteEventDatatable(rf.fromMessage("info.comentarioremovidorecuerdeguardar"), "form:dataTableComentario");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void deleteImpedimento(Impedimento impedimento)  ">
    public void deleteImpedimento(Impedimento impedimento) {
        try {
            this.tarjetaImpedimentoSelected.getImpedimento().remove(impedimento);
            isButtonSavePressed = Boolean.FALSE;
            // ajaxDeleteEventDatatable(rf.fromMessage("info.impedimentoremovidorecuerdeguardar"), "form:dataTableImpedimento");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void deleteArchivo(Archivo archivo)  ">
    public void deleteArchivo(Archivo archivo) {
        try {
            this.tarjetaArchivoSelected.getArchivo().remove(archivo);
            isButtonSavePressed = Boolean.FALSE;
            //      ajaxDeleteEventDatatable(rf.fromMessage("info.archivoremovidorecuerdeguardar"), "form:dataTableArchivo");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void deleteEtiqueta(Etiqueta etiqueta)">
    public void deleteEtiqueta(Etiqueta etiqueta) {
        try {
            this.tarjetaEtiquetaSelected.getEtiqueta().remove(etiqueta);
            isButtonSavePressed = Boolean.FALSE;
            //     ajaxDeleteEventDatatable(rf.fromMessage("info.etiquetaremovidarecuerdeguardar"), "form:dataTableEtiqueta");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Tarjeta validarSiCambioEnPrepare(Tarjeta tarjeta)">

    private Tarjeta validarSiCambioEnPrepare(Tarjeta tarjeta) {
        Tarjeta result = new Tarjeta();
        try {

            message = "";
            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            this.tarjetaDB = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (tarjetaDB.equals(tarjeta)) {

                result = tarjeta;
            } else {
                fueCambiadoPorOtroUsuario = Boolean.TRUE;
                message = rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero");
                result = tarjetaDB;

            }
            JmoordbCoreContext.put("tarjetaDB", tarjetaDB);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener(FileUploadEvent event)">
    public String fileUploadListener(FileUploadEvent event) {
        try {

            fileWasUploaded = false;
            isFileImagen = Boolean.FALSE;
            file = event.getFile();
            Archivo archivo = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
            if (file != null) {

                String description = file.getFileName().substring(0, file.getFileName().indexOf("."));
//                archivo.setDescripcion(file.getFileName());
                archivo.setDescripcion(description);
                String fileExt = FacesUtil.getFileExt(file);
                archivo.setExtension(fileExt);

                if (fileExt.equals(".gif")
                        || fileExt.equals(".jpg")
                        || fileExt.equals(".jpeg")
                        || fileExt.equals(".png")) {

                    if (!FacesUtil.checkImage(file)) {
                        FacesUtil.errorMessage(rf.fromCore("field.noimagen"));

                        return "";
                    } else {

                        isFileImagen = Boolean.TRUE;
                    }
                }

                fileWasUploaded = Boolean.TRUE;

                // isFileImagen = Boolean.TRUE;
                if (isFileImagen) {

                    archivo.setPath(FacesUtil.saveImage(file, archivo.getPath(), fileRepositoryDirectory));
                    if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                        archivo.setPath(archivo.getPath().replaceAll(FacesUtil.userHome(), ""));
                    } else {

                    }

                    agregarRowArchivo(archivo);

                } else {
                    //  archivo.setPath(FacesUtil.saveImage(file, archivo.getPath(), fileRepositoryDirectory));

                    createFile(file, archivo);

                    if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {

                        archivo.setPath(archivo.getPath().replaceAll(FacesUtil.userHome(), ""));

                    } else {

                    }

                    agregarRowArchivo(archivo);

                }

                if (fileWasUploaded) {

                    FacesUtil.successMessage(rf.fromMessage("info.archivosubido"));
                } else {

                }
            }
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void createFile(UploadedFile file) ">
    private void createFile(UploadedFile file, Archivo archivo) {
        try {

            archivo.setDescripcion(file.getFileName());

            String nombre = FacesUtil.generarNombre();

            if (FacesUtil.copyFile(nombre + FacesUtil.getFileExt(file), file.getInputStream(), fileRepositoryDirectory)) {

                String archivoPath = fileRepositoryDirectory + nombre + FacesUtil.getFileExt(file);

                archivo.setPath(archivoPath);

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="void onSelectItem(SelectEvent<String> event)">

    public void onSelectItem(SelectEvent<String> event) {
        final int i = 8;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public String goTarjetas()">
    public String goTarjetas() {
        try {

            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "tablero");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tarjetas.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public String goBacklog()">

    public String goBacklog() {
        try {

            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "tablero");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "backlog.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String goGraficaTotalesColumnasPorSprint() ">

    public String goGraficaTotalesColumnasPorSprint() {
        try {

            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "tablero");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "graficatotalescolumnasporsprint.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void onCellEditTarea(CellEditEvent event)">
    public void onCellEditTarea(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableTarea = Boolean.TRUE;
        }
        //    PrimeFaces.current().ajax().update("datatableTareaFooter");

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCellEditColaborador(CellEditEvent event)">
    public void onCellEditColaborador(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableColaborador = Boolean.TRUE;
        }

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCellEditComentario(CellEditEvent event)">

    public void onCellEditComentario(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableComentario = Boolean.TRUE;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCellEditImpedimento(CellEditEvent event)">

    public void onCellEditImpedimento(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableImpedimento = Boolean.TRUE;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCellEditEtiqueta(CellEditEvent event)">

    public void onCellEditEtiqueta(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableEtiqueta = Boolean.TRUE;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCellEditArchivoCellEditEvent event)">

    public void onCellEditArchivo(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableArchivo = Boolean.TRUE;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="updateNombreTarjetaInline(Tarjeta tarjeta)">
    public void updateNombreTarjetaInline(Tarjeta tarjeta) {

        try {

            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }
            validarSiCambioEnPrepare(tarjeta);
            if (fueCambiadoPorOtroUsuario) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero"));
                refresh();
                return;
            }

            /**
             * Comprueba si la tarjeta fue movida por otro usuario
             */
            if (!tarjeta.getColumna().equals(tarjetaDB.getColumna())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero"));
                refresh();
                return;
            }

            /**
             * Busca la tarjeta en la lista local
             */
            Boolean found = Boolean.FALSE;
            tarjetaInlineSelected = new Tarjeta();

            switch (tarjetaDB.getColumna()) {
                case "pendiente":
                    for (Tarjeta t : tarjetaPendienteInitialList) {
                        if (t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
                            found = Boolean.TRUE;
                            tarjetaInlineSelected = t;
                            break;
                        }
                    }
                    break;
                case "progreso":
                    for (Tarjeta t : tarjetaProgresoInitialList) {
                        if (t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
                            found = Boolean.TRUE;
                            tarjetaInlineSelected = t;
                            break;
                        }
                    }
                    break;
                case "finalizado":
                    for (Tarjeta t : tarjetaFinalizadoInitialList) {
                        if (t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
                            found = Boolean.TRUE;
                            tarjetaInlineSelected = t;
                            break;
                        }
                    }
                    break;
            }
            if (!found) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.tarjetafueremovidaporotrousuario"));
                return;
            }

            if (!tarjetaInlineSelected.getTarjeta().equals(tarjetaDB.getTarjeta())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero"));
                refresh();
                return;

            }
//           

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar nombre")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.updatetarjeta"));
                }

                sendEmailTarjeta(tarjeta, "editar");

                //  closeOverlayPanel("PF('overlayPanelTarjetaEditar').hide()");
                refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String showSeverityText(String severity)">
    public String showSeverityText(String severity) {
        String result = "";
        try {

            switch (severity) {
                case "":
                    result = rf.fromMessage("core['selectonemenu.none");
                    break;
                case "primary":
                    result = rf.fromMessage("core['selectonemenu.primary");
                    break;
                case "success":
                    result = rf.fromMessage("core['selectonemenu.success");
                    break;
                case "info":
                    result = rf.fromMessage("core['selectonemenu.info");
                    break;
                case "warning":
                    result = rf.fromMessage("core['selectonemenu.warning");
                    break;
                case "danger":
                    result = rf.fromMessage("core['selectonemenu.danger");
                    break;

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="showCommandButtonAgregarTarjeta()">
    public Boolean showCommandButtonAgregarTarjeta() {
        Boolean result = Boolean.FALSE;
        try {
            if (isPropietario) {
                result = Boolean.TRUE;
            } else {

                if (proyectoSelected.getColaboradorcreartarjeta() == null) {

                } else {
                    result = proyectoSelected.getColaboradorcreartarjeta();
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String colorTarjeta(Tarjeta tarjeta)">
    public String colorTarjeta(Tarjeta tarjeta) {
        return tarjetaServices.colorTarjeta(tarjeta);

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void sendEmailChangeColaborador(Tarjeta tarjeta)">
    public void sendEmailChangeColaborador(Tarjeta tarjeta) {
        try {

            List<String> emailList = new ArrayList<>();
            List<String> emailRemoveList = new ArrayList<>();

            /**
             *
             */
            Boolean found = Boolean.FALSE;
            /**
             * Recorre el old y busca los que se han removido
             */
            for (UserView uv : userViewSelectedOldList) {

                Optional<UserView> userFoundOptional = userViewSelectedList.stream().filter(x -> x.getIduser().equals(uv.getIduser())).findFirst();
                if (userFoundOptional.isPresent()) {
                    // ya se le envio
                } else {
                    if (uv.getEmail().equals(userLogged.getEmail())) {

                    } else {
                        emailRemoveList.add(uv.getEmail());
                    }

                }
            }
            /**
             * Busca en la lista nueva
             */
            for (UserView uv : userViewSelectedList) {

                Optional<UserView> userFoundOptional = userViewSelectedOldList.stream().filter(x -> x.getIduser().equals(uv.getIduser())).findFirst();
                if (userFoundOptional.isPresent()) {
                    // ya se le envio
                } else {
                    if (uv.getEmail().equals(userLogged.getEmail())) {

                    } else {
                        emailList.add(uv.getEmail());
                    }

                }
            }

            String tituloEmail = "";
            String mensajeEmail = "";
            if (emailList == null || emailList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("tarjeta.asignacion");

                mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>" + rf.fromMessage("email.enviadopor") + " " + userLogged.getName() + "<br>"
                        + rf.fromMessage("email.asignadoatarjeta") + "  " + tarjeta.getTarjeta() + "<br>"
                        + "<strong>" + rf.fromMessage("email.descripcion") + ":  " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                        + rf.fromMessage("email.idtarjeta") + " <strong>" + tarjeta.getIdtarjeta() + "</strong><br><br>"
                        + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }

            if (emailRemoveList == null || emailRemoveList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("tarjeta.remocion");
                mensajeEmail = rf.fromMessage("email.proyecto") + " <strong>" + ":  " + proyectoSelected.getProyecto() + "</strong> <br>" + rf.fromMessage("email.enviadopor") + "<strong>" + " " + userLogged.getName() + "</strong><br>"
                        + rf.fromMessage("email.removidodetarjeta") + ":  " + tarjeta.getTarjeta() + "<br>"
                        + rf.fromMessage("email.idtarjeta") + " <strong>" + tarjeta.getIdtarjeta() + "</strong><br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailRemoveList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void sendEmailTarjeta(Tarjeta tarjeta,String evento)">

    public void sendEmailTarjeta(Tarjeta tarjeta, String evento) {
        try {

            if (!tarjeta.getForeaneo()) {

//                return;
            }
            if (!proyectoSelectedFromTarjeta(tarjeta)) {
                return;
            }
            /*
            EL usuario foraneo siempre se almacena en al posición cero
             */
            List<Comentario> comentarioEmailList = new ArrayList<>();
            String comentarioResult = "";
            if (evento.equals("comentario")) {
                if (tarjeta.getComentario() == null || tarjeta.getComentario().isEmpty()) {
                    return;
                }
                if (comentarioOldList == null || comentarioOldList.isEmpty()) {
                    for (Comentario c : tarjeta.getComentario()) {
                        comentarioEmailList.add(c);
                    }
                } else {
                    tarjeta.getComentario().forEach(c -> {
                        Optional<Comentario> comentarioFoundOptional = comentarioOldList.stream().filter(x -> x.getComentario().equals(c.getComentario())).findFirst();
                        if (!comentarioFoundOptional.isPresent()) {
                            comentarioEmailList.add(c);
                        }
                    });
                }

                if (comentarioEmailList == null || comentarioEmailList.isEmpty()) {

                    return;
                }

                String br = "";
                for (Comentario c : comentarioEmailList) {
                    comentarioResult += br + c.getComentario();
                    br = "<br";
                }

            }

            List<String> emailList = new ArrayList<>();

            /**
             *
             */
            Boolean found = Boolean.FALSE;
            /**
             * Recorre el old y busca los que se han removido
             */

            /*
                Agrega el usuario foraneo
             */
            if (userViewForaneo == null || userViewForaneo.getIduser() == null) {

            } else {

                if (!userLogged.getIduser().equals(userViewForaneo.getIduser())) {
                    emailList.add(userViewForaneo.getEmail());

                }
            }

            if (emailList == null || emailList.isEmpty()) {

            }

            /**
             * Agrega los otros colaboradores de la tarjeta
             */
            for (UserView uv : tarjeta.getUserView()) {

                if (uv.getIduser().equals(userLogged.getIduser())) {

                } else {
                    //
                    Optional<String> userViewFoundOptional = emailList.stream().filter(x -> x.equals(uv.getEmail())).findFirst();

                    if (!userViewFoundOptional.isPresent()) {

                        emailList.add(uv.getEmail());

                    }
                }
            }
            if (emailList == null || emailList.isEmpty()) {
                for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                    UserView uv = pm.getUserView();
                    if (uv.getIduser().equals(userLogged.getIduser())) {
                    } else {
                        if (pm.getPropietario()) {
                            emailList.add(uv.getEmail());
                        }

                    }
                }
            } else {

                if (emailList.size() == 1) {
                    for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                        UserView uv = pm.getUserView();
                        if (uv.getIduser().equals(userLogged.getIduser())) {
                        } else {
                            if (pm.getPropietario()) {
                                emailList.add(uv.getEmail());
                            }

                        }
                    }
                }
            }

            String tituloEmail = "";
            String mensajeEmail = "";
            if (emailList == null || emailList.isEmpty()) {

                return;
            } else {

                List<String> list = new ArrayList<>();
                emailList.forEach(s -> {
                    if (s == null || s.equals("")) {
                    } else {
                        list.add(s);
                    }

                });

                emailList = list;
                switch (evento) {
                    case "crear":
                        if (userViewForaneo == null || userViewForaneo.getIduser() == null) {
                            tituloEmail = rf.fromMessage("email.titulotarjetacreada");
                        } else {
                            tituloEmail = rf.fromMessage("email.titulotarjetaforaneacreada");
                        }

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + "  " + proyectoSelected.getProyecto() + " <br>"
                                + rf.fromMessage("email.tarjeta") + ": " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + ": " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                                + rf.fromMessage("email.fuecreadapor") + " <strong>" + " " + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "editar":
                        tituloEmail = rf.fromMessage("email.titulotarjetaeditada");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + rf.fromMessage("email.tarjeta") + ": " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + ": " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                                + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + rf.fromMessage("email.fueeditadapor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "archivada":
                        tituloEmail = rf.fromMessage("email.titulotarjetaarchivar");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + rf.fromMessage("email.tarjeta") + ": " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + ": " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                                + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + rf.fromMessage("email.fuearchivadapor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "subirarchivo":
                        tituloEmail = rf.fromMessage("email.titulotarjetasubirarchivo");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + rf.fromMessage("email.tarjeta") + ": " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + ": " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                                + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + rf.fromMessage("email.fuesubidopor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "comentario":
                        tituloEmail = rf.fromMessage("email.titulotarjetacomentario");

                        mensajeEmail
                                = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + "<strong>" + rf.fromMessage("email.tarjeta") + "</strong>" + " " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + "</strong>" + ": " + tarjeta.getDescripcion() + "<br>"
                                + "<strong>" + rf.fromMessage("email.idtarjeta") + "</strong>" + " " + tarjeta.getIdtarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.comentario") + "</strong>" + " " + comentarioResult + "<br>"
                                + "<strong>" + rf.fromMessage("email.comentarioagregadopor") + "</strong>" + "" + userLogged.getName() + "<br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;

                    case "backpendiente":
                        tituloEmail = rf.fromMessage("email.titulotarjetaregresadapendiente");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + "<strong>" + rf.fromMessage("email.tarjeta") + "</strong>" + " " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + "</strong>" + ": " + tarjeta.getDescripcion() + "<br>"
                                + "<strong>" + rf.fromMessage("email.idtarjeta") + "</strong>" + " " + tarjeta.getIdtarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.realizadopor") + "</strong>" + " " + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "backprogreso":
                        tituloEmail = rf.fromMessage("email.titulotarjetaregresadaprogreso");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + "<strong>" + rf.fromMessage("email.tarjeta") + " " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + "</strong>" + ": " + tarjeta.getDescripcion() + "<br>"
                                + "<strong>" + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.realizadopor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "nextprogreso":
                        tituloEmail = rf.fromMessage("email.titulotarjetanextprogreso");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + "<strong>" + rf.fromMessage("email.tarjeta") + " " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + "</strong>" + ": " + tarjeta.getDescripcion() + "<br>"
                                + "<strong>" + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.realizadopor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;
                    case "nextfinalizado":
                        tituloEmail = rf.fromMessage("email.titulotarjetanextfinalizado");

                        mensajeEmail = "<strong>" + rf.fromMessage("email.proyecto") + ":</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                                + "<strong>" + rf.fromMessage("email.tarjeta") + " " + tarjeta.getTarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.descripcion") + "</strong>" + ": " + tarjeta.getDescripcion() + "<br>"
                                + "<strong>" + rf.fromMessage("email.idtarjeta") + " " + tarjeta.getIdtarjeta() + "<br>"
                                + "<strong>" + rf.fromMessage("email.realizadopor") + " <strong>" + userLogged.getName() + "</strong><br><br>"
                                + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";
                        break;

                }

                if (emailList == null || emailList.isEmpty()) {

                } else {
                    tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                    EmailSender emailSender = new EmailSender.Builder()
                            .header(tituloEmail)
                            .messages(mensajeEmail)
                            .pathFile("")
                            .nameFile("")
                            .emailList(emailList)
                            .build();

                    emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                }

                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean showCommandButtonProfile()">
    public Boolean showCommandButtonProfile() {
        var result = Boolean.FALSE;
        try {
            if (isPropietario || isColaborador) {
                result = Boolean.TRUE;
            } else {
                if (isProyectoForaneo && callerLevel0.equals("dashboard")) {

                } else {
                    result = Boolean.FALSE;
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void pasarABacklog(Tarjeta tarjeta)(Tarjeta tarjeta)">
    public void pasarABacklog(Tarjeta tarjeta) {
        try {
            var tarjetaBacklog = new Tarjeta();
            JmoordbCoreUtil.copyBeans(tarjetaBacklog, tarjeta);

            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjeta)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nombretarjeta"));
                return;
            }
            tarjeta.setFechafinal(JmoordbCoreDateUtil.getFechaHoraActual());
            tarjeta.setFechainicial(JmoordbCoreDateUtil.getFechaHoraActual());
            tarjeta.setIdsprint(0L);
            tarjeta.setColumna("pendiente");

            tarjeta.setBacklog(Boolean.TRUE);
            Optional<Tarjeta> tarjetaOptional = tarjetaServices.tarjetaConIgualNombreInSprint(tarjeta.getTarjeta(), proyectoSelected.getIdproyecto(), sprintSelected.getIdsprint());
            if (tarjetaOptional.isPresent()) {

                if (!tarjeta.getIdtarjeta().equals(tarjetaOptional.get().getIdtarjeta())) {

                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existetarjetaconnombreigual"));
                    // return;
                }

            }

            if (tarjeta.getFechafinal() == null || tarjeta.getFechafinal().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechafinal"));
                return;
            }
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("pasar a backlog desde tablero")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            tarjeta.getActionHistory().add(actionHistory);
tarjeta.setLastModification(actionHistory.getFecha());

            if (!tarjetaServices.update(tarjeta)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;

                sendEmailPasarABacklog(tarjeta);
                /**
                 * Enviar WebSocket
                 */
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("tarjeta")
                        .value(tarjeta.getIdtarjeta() != null ? tarjeta.getIdtarjeta().toString() : "")
                        .message("Pasar a backlog desde tablero")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, tarjeta, Boolean.TRUE, Boolean.FALSE);

                FacesUtil.successMessage(rf.fromMessage("info.tarjetajapasadabacklog"));

                refreshCache(tarjetaBacklog, "pasar a backlog desde tablero");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void sendEmailPasarAlTablero(Tarjeta tarjeta)">
    public void sendEmailPasarABacklog(Tarjeta tarjeta) {
        try {

            List<String> emailList = new ArrayList<>();

            /**
             *
             */
            Boolean found = Boolean.FALSE;
            /**
             * Recorre el old y busca los que se han removido
             */
            for (UserView uv : tarjeta.getUserView()) {
                if (!uv.getIduser().equals(userLogged.getIduser())) {
                    emailList.add(uv.getEmail());

                }

            }
            String tituloEmail = "";
            String mensajeEmail = "";
            if (emailList == null || emailList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("email.titulopasartarjetaalbacklog");

                mensajeEmail
                        = "<strong>" + rf.fromMessage("email.proyecto") + "</strong>" + " " + proyectoSelected.getProyecto() + " <br>"
                        + rf.fromMessage("email.enviadopor") + "<strong>" + userLogged.getName() + "><br>"
                        + "<strong>" + rf.fromMessage("email.tarjeta") + " " + tarjeta.getTarjeta() + "<br>"
                        + "<strong>" + rf.fromMessage("email.descripcion") + ": " + "</strong>" + tarjeta.getDescripcion() + "<br>"
                        + "<strong>" + rf.fromMessage("email.idtarjeta") + " <strong>" + " " + tarjeta.getIdtarjeta() + "<br>"
                        + "<strong>" + rf.fromMessage("email.tarjetapasadaalsprint") + " <strong>" + " " + sprintSelected.getSprint() + "<br><br>"
                        + "<strong>" + rf.fromMessage("email.visite") + "</strong>" + " <a href=\"" + applicativeURL.get() + "\">SFT</a>" + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void loadTipotarjetaByProyecto(Proyecto proyecto)">
    private void loadTipotarjetaByProyecto(Proyecto proyecto) {
        try {

            tipoTarjetaConverterServices.add(tipotarjetaServices.loadTipotarjetaByProyecto(proyecto)
            );

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String changeOrder(String order, String iconOrderBy">
    public String changeOrder(String order, String iconOrderBy) {
        try {
            this.orderBy = order;
            this.iconOrderBy = iconOrderBy;

            refresh();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String nameOfColaborador(Long iduser, Tarjeta tarjeta)">

    public String nameOfColaborador(Long iduser, Tarjeta tarjeta) {
        var result = "";
        try {
            for (UserView uv : tarjeta.getUserView()) {
                if (uv.getIduser().equals(iduser)) {
                    result = uv.getName();
                    break;

                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean tienePrivilegiosParaTarjeta(Tarjeta tarjeta)">
    public Boolean tienePrivilegiosParaTarjeta(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {
            result = esMiembroDeTarjeta(tarjeta, userLogged, isPropietario, isProyectoForaneo);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean tienePrivilegiosParaTarjetaComentarioArchivo(Tarjeta tarjeta)">

    public Boolean tienePrivilegiosParaTarjetaComentarioArchivo(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {
            result = esMiembroDeTarjetaComentarioArchivo(tarjeta, userLogged, isPropietario, isProyectoForaneo);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String convertirTarjetaDesdeTarea(Tarjeta tarjetaTareaSelected,Tarea tareaItem)">
    public String convertirTarjetaDesdeTarea(Tarjeta tarjeta, Tarea tareaItem) {

        try {
            proyectoSelectedFromTarjeta(tarjeta);
            sprintSelectedFromTarjeta(tarjeta);
            tarjetaDB = (Tarjeta) JmoordbCoreContext.get("tarjetaDB");
            Tarjeta tarjetaDBNow = tarjetaServices.findByIdtarjeta(tarjeta.getIdtarjeta(), tarjeta.getIdproyecto()).get();
            if (!tarjetaDBNow.equals(tarjetaDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return "";

            }
            tarjeta.setTarjeta(tareaItem.getTarea());
            tarjeta.setDescripcion(tareaItem.getTarea());
            if (tarjeta.getTarjeta() == null || tarjeta.getTarjeta().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.nombretarjeta"));
                return "";
            }

            if (tarjetaServices.tarjetaExistInSprint(tarjeta.getTarjeta(), proyectoSelected.getIdproyecto(), sprintSelected.getIdsprint())) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.existetarjetaconnombreigual"));
                return "";
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("tarjeta creada a partir de una tarea")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
             actionHistoryList.addAll(tarjeta.getActionHistory());
            actionHistoryList.add(actionHistory);

            tarjeta.setActionHistory(actionHistoryList);
 tarjeta.setLastModification(actionHistory.getFecha());
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {
            } else {
                /**
                 * Pasa las tareas asignando completado a FALSE
                 */
                List<Tarea> tareaList = new ArrayList<>();
                for (Tarea tarea : tarjeta.getTarea()) {
                    tarea.setCompletado(Boolean.FALSE);
                    if (tarea.getActive() && !tarea.getTarea().equals(tareaItem.getTarea())) {
                        tareaList.add(tarea);
                    }
                }
                tarjeta.setTarea(tareaList);
            }
            this.tarjetaClonarSelected.setComentario(new ArrayList<>());
            this.tarjetaClonarSelected.setImpedimento(new ArrayList<>());
            this.tarjetaClonarSelected.setArchivo(new ArrayList<>());

            if (!tarjetaServices.save(tarjeta).isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromMessage("warning.convertirtarjetafromtarea"));
            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                if (showMessagesOfActionInFormTablero.get()) {
                    FacesUtil.successMessage(rf.fromMessage("info.tarjetacreadafromtarea"));
                }

                refreshCache(tarjeta, "tarjeta creada a partir de una tarea");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> completeTarjeta(String query) ">
    public List<Tarjeta> completeTarjeta(String query) {
        List<Tarjeta> result = new ArrayList<>();
        try {
            result = completeTarjeta(query, tarjetaPendienteList, tarjetaProgresoList, tarjetaFinalizadoList);

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sugerirPrefijo(AjaxBehaviorEvent event)">
    public void sugerirTarjetas(AjaxBehaviorEvent event) {
        try {
            //    proyectoNewSelected.setPrefijo(proyectoServices.sugerirPrefijo(proyectoNewSelected));

            if (textToSearch == null || textToSearch.isEmpty()) {

                refreshCache(new Tarjeta(), "sugerir tarjeta");
            } else {

                if (contadorSearch.equals(0)) {

                    pendienteTarjetaListSearch = tarjetaPendienteList;
                    progresoTarjetaListSearch = tarjetaProgresoList;
                    finalizadoTarjetaListSearch = tarjetaFinalizadoList;
                } else {
                    tarjetaPendienteList = pendienteTarjetaListSearch;
                    tarjetaProgresoList = progresoTarjetaListSearch;
                    tarjetaFinalizadoList = finalizadoTarjetaListSearch;
                }
                contadorSearch++;
                tarjetaPendienteList = filterTarjeta(textToSearch, tarjetaPendienteList);
                tarjetaProgresoList = filterTarjeta(textToSearch, tarjetaProgresoList);
                tarjetaFinalizadoList = filterTarjeta(textToSearch, tarjetaFinalizadoList);

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showPrefijoFromTarjeta(Tarjeta tarjeta)">
    public String showPrefijoFromTarjeta(Tarjeta tarjeta) {
        var result = "";
        try {

            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    result = p.getPrefijo();
                    break;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String showNameProyectoFromTarjeta(Tarjeta tarjeta)">

    public String showNameProyectoFromTarjeta(Tarjeta tarjeta) {
        var result = "";
        try {

            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    result = p.getProyecto();
                    break;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean proyectoSelectedFromTarjeta(Tarjeta tarjeta)">

    public Boolean proyectoSelectedFromTarjeta(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {

            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    proyectoSelected = p;
                    result = Boolean.TRUE;
                    break;
                }
            }
            if (result) {
                loadUserViewDomainProyectoSelectedFromTarjeta(tarjeta);
                loadTipotarjetaByProyecto(proyectoSelected);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean loadUserViewDomainProyectoSelectedFromTarjeta(Tarjeta tarjeta)">

    public Boolean loadUserViewDomainProyectoSelectedFromTarjeta(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {

            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    proyectoSelected = p;
                    result = Boolean.TRUE;
                    break;
                }
            }
            if (result) {
                userViewDomainForCreateList = loadUserForCreateTarjeta(proyectoSelected, userLogged);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean sprintSelectedFromTarjeta(Tarjeta tarjeta)">

    public Boolean sprintSelectedFromTarjeta(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {

            for (Sprint s : sprintPorColaboradorList) {
                if (s.getIdsprint().equals(tarjeta.getIdsprint())) {
                    sprintSelected = s;
                    result = Boolean.TRUE;
                    break;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public String refreshFromWebsocket()">

    @Override
    public String refreshFromWebsocket() {
        try {
            /**
             * Leer los datos del Websocket
             */
            String event = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("event");

            String channel = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("channel");

            String message = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("message");

            MessageWebSocket mws = new MessageWebSocket();
            mws = mws.toMessageWebSocket(message);

            if (jmoordbCronometerOld.equals(0L)) {

                if (!dialogVisibleWebSocket) {
                    //Valida los datos del WebSocket
                    if (mws.getProducer().equals("DashboardFaces") && mws.getKey().equals("proyecto")
                            && mws.getValue().equals(proyectoSelected.getIdproyecto().toString())) {
                        validateChangeInProject();
                    }

                    refresh();
                    PrimeFaces.current().ajax().update("form");
                }
                jmoordbCronometerOld = JmoordbCronometer.nanoSecondsNow();
            } else {

                Long dif = JmoordbCronometer.diference(jmoordbCronometerOld, JmoordbCronometer.nanoSecondsNow());
                Long seconds = dif / 1000;
                contadorNotificacionesWebsocket++;
                if (seconds < websocketMinimumsSecondsForUpdate.get().longValue()) {

                } else {
                    if (!dialogVisibleWebSocket) {
                        //Valida los datos del WebSocket
                        if (mws.getProducer().equals("DashboardFaces") && mws.getKey().equals("proyecto")
                                && mws.getValue().equals(proyectoSelected.getIdproyecto().toString())) {
                            validateChangeInProject();
                        }
                        contadorNotificacionesWebsocket = 0;
                        refresh();
                        PrimeFaces.current().ajax().update("form");
                    }
                }

                jmoordbCronometerOld = JmoordbCronometer.nanoSecondsNow();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String updateForRemoteWebsocket()">

    @Override
    public String updateForRemoteWebsocket() {
        try {
            if (dialogVisibleAddWebSocket) {
                closeOverlayPanel("PF('overlayPanelTarjetaAgregar').show()");
            }
            if (!dialogVisibleWebSocket) {
                return ":form";
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onCompleteWebSocket()">
    public void onCompleteWebSocket() {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="sendMensajesWebsocket(Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent)">

    @Override
    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent) {
        try {
            /**
             * Se obtiene los usuarios del proyecto asociado a la tarjeta
             */
            userViewForWebSocketList = userViewForWebSocketListFromProjectOfTarjeta(tarjeta, proyectoPorColaboradorList, userLogged);

            List<UserView> result = filterUserViewListForWebSocket(userViewForWebSocketList, tarjeta, exclude, userLogged);

            webSocketController.sendMessageTableroMultiple(messageWebSocket.toJSON(), result);
            webSocketController.sendMessageBacklogMultiple(messageWebSocket.toJSON(), result);
            if (deleteEvent) {

                webSocketController.sendMessagePapeleraReciclajeMultiple(messageWebSocket.toJSON(), result);
            }
            webSocketController.sendMessagePanelTrabajoMultiple(messageWebSocket.toJSON(), result);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    @Override
    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Boolean exclude) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="String validateChangeInProject()">
    public String validateChangeInProject() {
        try {
            haveSprintOpen = Boolean.TRUE;
            isSprintVencido = Boolean.FALSE;

            Proyecto proyectoWebSocket = proyectoServices.findByIdproyecto(proyectoSelected.getIdproyecto()).get();
            if (proyectoSelected.equals(proyectoWebSocket)) {

            } else {

                JmoordbCoreUtil.copyBeans(proyectoSelected, proyectoWebSocket);
//userViewForWebSocketList = userViewFromProjectExclude(proyectoSelected, Boolean.FALSE, userLogged);
                JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
                String result = validarEstadoIniciadoYFechaProyecto(proyectoSelected, rf);
                if (!result.equals("")) {

                    haveSprintOpen = Boolean.FALSE;
                    isSprintVencido = Boolean.TRUE;
                    message = result;
                    FacesUtil.warningDialog(result);
                    PrimeFaces.current().ajax().update("form");

                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Boolean showAdvertencia(Tarjeta tarjeta)">

    public Boolean showAdvertencia(Tarjeta tarjeta) {
        Boolean result = Boolean.FALSE;
        try {
            var proyectoVar = new Proyecto();
            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    proyectoVar = p;
                    break;
                }
            }
            Integer diasPendientesVar = diasPendientes(tarjeta);

            if (diasPendientesVar < 0 && !tarjeta.getColumna().equals("finalizado")) {

                return Boolean.TRUE;
            }
            if (diasPendientesVar <= proyectoVar.getDiasAlertaVencimiento() && !tarjeta.getColumna().equals("finalizado")) {
                return Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    @Override
    public void onRowReorderTarea(ReorderEvent event) {
        try {
            int from = event.getFromIndex();
            int to = event.getToIndex();

            isChangeInRowDatatableTarea = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    @Override
    public void onRowReorderComentario(ReorderEvent event) {
        try {
            int from = event.getFromIndex();
            int to = event.getToIndex();

            isChangeInRowDatatableComentario = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    @Override
    public void onRowReorderImpedimento(ReorderEvent event) {
        try {
            int from = event.getFromIndex();
            int to = event.getToIndex();

            isChangeInRowDatatableImpedimento = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    @Override
    public void onRowReorderEtiqueta(ReorderEvent event) {
        try {
            int from = event.getFromIndex();
            int to = event.getToIndex();

            isChangeInRowDatatableEtiqueta = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    @Override
    public void onRowReorderArchivo(ReorderEvent event) {
        try {
            int from = event.getFromIndex();
            int to = event.getToIndex();

            isChangeInRowDatatableArchivo = Boolean.TRUE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Boolean tienePrivilegiosParaTarjeta(Tarjeta tarjeta)">
    public Boolean tienePrivilegiosVerTarjeta(Tarjeta tarjeta) {
        var result = Boolean.FALSE;
        try {
            result = puedeVerDetallesTarjeta(tarjeta, userLogged, isPropietario, isProyectoForaneo, userViewForWebSocketList);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" String refresh(Tarjeta tarjeta, String command)">
    @Override
    public String refreshCache(Tarjeta tarjeta, String command) {
        try {
            refresh();
//               if(tarjeta == null){
//                return "";
//            }
//            dialogVisibleWebSocket = Boolean.FALSE;
//            dialogVisibleAddWebSocket = Boolean.FALSE;
//            textToSearch = "";
//             contadorSearch = 0;
//            /**
//             * Esto se cambio por el webscoket debe ir en todos los controller
//             */
//
//            switch (command) {
//                case "crear":
//                    tarjetaPendienteList.add(0, tarjeta);
//                    tarjetaPendienteInitialList.add(0, tarjeta);
//                    break;
//                case "clonar":
//                case "tarjeta creada a partir de una tarea":
//                    if (tarjeta.getColumna().equals("pendiente")) {
//                        tarjetaPendienteList.add(0, tarjeta);
//                        tarjetaPendienteInitialList.add(0, tarjeta);
//                    } else {
//                        if (tarjeta.getColumna().equals("progreso")) {
//                            tarjetaProgresoList.add(0, tarjeta);
//                            tarjetaProgresoInitialList.add(0, tarjeta);
//                        } else {
//                            if (tarjeta.getColumna().equals("finalizado")) {
//                                tarjetaFinalizadoList.add(0, tarjeta);
//                                tarjetaFinalizadoInitialList.add(0, tarjeta);
//                            }
//                        }
//                    }
//                    break;
//                case "editar":
//                case "comentario":
//                case "etiqueta":
//                case "colaborador":
//                case "archivo":
//                case "tarea":
//                case "impedimento":
//
//                    if (tarjeta.getColumna().equals("pendiente")) {
//                        Integer position = tarjetaServices.positionOfTarjeta(tarjeta, tarjetaPendienteList);
//                        if (position != -1) {
//                            tarjetaPendienteList.set(position, tarjeta);
//                            tarjetaPendienteInitialList.set(position, tarjeta);
//                        }
//                    } else {
//                        if (tarjeta.getColumna().equals("progreso")) {
//                            Integer position = tarjetaServices.positionOfTarjeta(tarjeta, tarjetaProgresoList);
//                            if (position != -1) {
//                                tarjetaProgresoList.set(position, tarjeta);
//                                tarjetaProgresoInitialList.set(position, tarjeta);
//                            }
//                        } else {
//                            if (tarjeta.getColumna().equals("finalizado")) {
//                                Integer position = tarjetaServices.positionOfTarjeta(tarjeta, tarjetaFinalizadoList);
//                                if (position != -1) {
//                                    tarjetaFinalizadoList.set(position, tarjeta);
//                                    tarjetaFinalizadoInitialList.set(position, tarjeta);
//                                }
//                            }
//                        }
//                    }
//                    break;
//                case "archivar":
//                case "pasar a backlog desde tablero":
//                    case "pasar tarjeta al sprint":
//                    
//                    if (tarjeta.getColumna().equals("pendiente")) {
//                        List<Tarjeta> tarjetas = tarjetaPendienteList;
//                        tarjetaPendienteList = new ArrayList<>();
//                        tarjetaPendienteInitialList = new ArrayList<>();
//                        for (Tarjeta t : tarjetas) {
//                            if (!t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
//                                tarjetaPendienteList.add(t);
//                                tarjetaPendienteInitialList.add(t);
//                            }
//                        }
//                    } else {
//                        if (tarjeta.getColumna().equals("progreso")) {
//
//                            List<Tarjeta> tarjetas = tarjetaProgresoList;
//                            tarjetaProgresoList = new ArrayList<>();
//                            tarjetaProgresoInitialList = new ArrayList<>();
//                            for (Tarjeta t : tarjetas) {
//                                if (!t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
//
//                                    tarjetaProgresoList.add(t);
//
//                                    tarjetaProgresoInitialList.add(t);
//
//                                }
//                            }
//
//                        } else {
//                            if (tarjeta.getColumna().equals("finalizado")) {
//                                List<Tarjeta> tarjetas = tarjetaFinalizadoList;
//                                tarjetaFinalizadoList = new ArrayList<>();
//                                tarjetaFinalizadoInitialList = new ArrayList<>();
//                                for (Tarjeta t : tarjetas) {
//                                    if (!t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
//                                        tarjetaFinalizadoList.add(t);
//                                        tarjetaFinalizadoInitialList.add(t);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    break;
//                case "agregar plantilla":
//
//                    break;
//                case "view":
//                    break;
//                     case "sugerir tarjeta":
//                    tarjetaPendienteList = restablecerDesdeOld(tarjetaPendienteInitialList);
//                    tarjetaProgresoList = restablecerDesdeOld(tarjetaProgresoInitialList);
//                    tarjetaFinalizadoList = restablecerDesdeOld(tarjetaFinalizadoInitialList);
//                   
//                    
//                    break;
//            }
//
//            PrimeFaces.current().ajax().update("form");

//            JmoordbCronometer.endCronometer(FacesUtil.nameOfClassAndMethod(), "\t\t userLogged.getName()" + userLogged.getName());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="handleCloseDialogrefresh(CloseEvent event)">
    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        try {
            refresh();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="handleCloseDialogComentario(CloseEvent event)">
    @Override
    public void handleCloseDialogComentario(CloseEvent event) {
        try {
            if (isEditable) {
                addComentario(tarjetaComentarioSelected);
            } else {
                closeAddComentario(tarjetaComentarioSelected);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogTarea(CloseEvent event)">
    @Override
    public void handleCloseDialogTarea(CloseEvent event) {
        try {
            if (isEditable) {
                addTarea(tarjetaTareaSelected);
            } else {
                closeAddTarea(tarjetaTareaSelected);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogImpedimento(CloseEvent event)">

    @Override
    public void handleCloseDialogImpedimento(CloseEvent event) {
        try {
            if (isEditable) {
                addTarea(tarjetaImpedimentoSelected);
            } else {
                closeAddTarea(tarjetaImpedimentoSelected);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogEtiqueta(CloseEvent event)">

    @Override
    public void handleCloseDialogEtiqueta(CloseEvent event) {
        try {
            if (isEditable) {
                addTarea(tarjetaEtiquetaSelected);
            } else {
                closeAddTarea(tarjetaEtiquetaSelected);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogArchivo(CloseEvent event)">

    @Override
    public void handleCloseDialogArchivo(CloseEvent event) {
        try {
            if (isEditable) {
                addTarea(tarjetaArchivoSelected);
            } else {
                closeAddTarea(tarjetaArchivoSelected);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogColaborador(CloseEvent event)">

    @Override
    public void handleCloseDialogColaborador(CloseEvent event) {
        try {
            changeColaborador(tarjetaColaboradorSelected);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogEditar(CloseEvent event)">

    @Override
    public void handleCloseDialogEditar(CloseEvent event) {
        try {
            if (isEditable) {

                editar(tarjetaEditarSelected);
            } else {
                refreshCache(tarjetaEditarSelected, "editar");
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>
}
