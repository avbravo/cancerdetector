/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;
// <editor-fold defaultstate="collapsed" desc="imports">

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbCronometer;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.avbravo.jmoordbutils.websocket.MessageWebSocket;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.JmoordbCoreUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;
import com.sft.commons.emails.EmailSender;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.converter.services.AreaConverterServices;
import com.sft.converter.services.DepartamentViewConverterServices;
import com.sft.converter.services.GrupoTipoTarjetaConverterServices;
import com.sft.converter.services.IconoConverterServices;
import com.sft.converter.services.UserViewConverterServices;
import com.sft.faces.services.DashboardFacesServices;
import com.sft.faces.services.FacesServices;
import com.sft.model.ActionHistory;
import com.sft.model.Area;

import com.sft.model.NotificacionProyecto;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoView;
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
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.model.DepartamentView;
import com.sft.model.GrupoTipoTarjeta;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.SprintOpen;
import com.sft.model.Tarjeta;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.model.domain.TotalesTarjetasEstadistica;
import com.sft.services.AreaServices;
import com.sft.services.DepartamentViewServices;
import com.sft.services.GrupoTipoTarjetaServices;
import com.sft.services.UserServices;
import com.sft.websocket.fire.FacesWebSocket;
import com.sft.websocket.fire.WebSocketController;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Event;
import jakarta.faces.event.AjaxBehaviorEvent;
import java.util.Map;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.primefaces.PrimeFaces;
import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CloseEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.file.UploadedFile;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class DashboardFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, FacesWebSocket, FacesServices {
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
    AreaConverterServices areaConverterServices;

    @Inject
    DepartamentViewConverterServices departamentViewConverterServices;

    @Inject
    GrupoTipoTarjetaConverterServices grupoTipoTarjetaConverterServices;

    @Inject
    IconoConverterServices iconoConverterServices;
    @Inject
    UserViewConverterServices userViewConverterServices;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Tarjeta> tarjetaLazyDataModel;
    private LazyDataModel<Tarjeta> autocompleteByTarjetaLazyDataModel;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private TotalesTarjetasEstadistica totalesTarjetasEstadistica = new TotalesTarjetasEstadistica();

    private Long totalOpenParaArchivarProyecto = 0L;
    private Long totalColumnaPendienteParaArchivarProyecto = 0L;
    private Long totalColumnaProgresoArchivarProyecto = 0L;
    private Long totalOpenParaEliminarProyecto = 0L;
    private Long totalColumnaPendienteParaEliminarProyecto = 0L;
    private Long totalColumnaProgresoEliminarProyecto = 0L;

    private List<ResponsiveOption> responsiveOptions;
    private Boolean showDetallesProyecto = Boolean.FALSE;
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
    private Proyecto proyectoArchivarSelected = new Proyecto();
    private Proyecto proyectoEliminarSelected = new Proyecto();
    private Proyecto proyectoClonarSelected = new Proyecto();
    private Proyecto proyectoSelected = new Proyecto();
    private Proyecto proyectoDB = new Proyecto();
    private SprintOpen sprintOpenSelected = new SprintOpen();
    private ProyectoEstadistica proyectoEstadisticaResumen = new ProyectoEstadistica();
//    private Sprint sprintSelected = new Sprint();
    private User userSelected = new User();

    private User userDB = new User();
    private List<UserView> userViewList = new ArrayList<>();
    private List<NotificacionProyecto> notificacionProyectoList = new ArrayList<>();
    private List<UserView> userViewPropietarioNewSelectedList = new ArrayList<>();
    private List<UserView> userViewColaboradorNewSelectedList = new ArrayList<>();
    private List<UserView> userViewPropietarioEditSelectedList = new ArrayList<>();
    private List<UserView> userViewColaboradorEditSelectedList = new ArrayList<>();

    private List<ProyectoMiembro> proyectoMiembroOldList = new ArrayList<>();

    private List<ProyectoSprintOpen> proyectoSprintOpenList = new ArrayList<>();
    private List<ProyectoSprintOpen> proyectoSprintOpenForaneoList = new ArrayList<>();
    private List<Timeline> timelineList = new ArrayList<>();

    private List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();
    private List<DepartamentView> departamentViewList = new ArrayList<>();
    private List<Area> areaList = new ArrayList<>();
    private List<GrupoTipoTarjeta> grupoTipoTarjetaList = new ArrayList<>();

    private List<Profile> profileList = new ArrayList<>();
//    private List<Tarjeta> tarjetaViewDashboard = new ArrayList<>();

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
    Integer totalRecords = 0;
    private Boolean isRowPageSmall = Boolean.TRUE;
    private DataTable dataTable;
    private AutoComplete autoComplete;
    private List<Tarjeta> tarjetaList = new ArrayList<>();
    private String textToSearch = "";
    private String textDescripcionToSearch = "";
    private Boolean includeUser = Boolean.FALSE;
    private Boolean includePrioridad = Boolean.FALSE;
    private Boolean includeColumna = Boolean.FALSE;
    private Boolean includeProject = Boolean.FALSE;
    private Boolean includeDeposito = Boolean.FALSE;
    private Boolean includeRango = Boolean.FALSE;
    private String filterText = "";
    private String depositoSelected = "";
    private String columnaSelected = "";
    private Tarjeta tarjetaSelected = new Tarjeta();
    private Proyecto proyectoAutocompleteSelected = new Proyecto();
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="paginator ">
    Paginator paginator = new Paginator();
    Paginator paginatorOld = new Paginator();

    Pagination paginationAutocompleteTartjeta = new Pagination();

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
//    public Sprint getSprintSelected() {
//        if (sprintSelected == null) {
//            sprintSelected = new Sprint();
//        }
//        return sprintSelected;
//    }
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

    public Proyecto getProyectoNewSelected() {
        if (proyectoNewSelected == null) {
            proyectoNewSelected = new Proyecto();
        }
        return proyectoNewSelected;
    }

    public Proyecto getProyectoEditarSelected() {
        if (proyectoEditarSelected == null) {
            proyectoEditarSelected = new Proyecto();
        }
        return proyectoEditarSelected;
    }

    public Proyecto getProyectoArchivarSelected() {
        if (proyectoArchivarSelected == null) {
            proyectoArchivarSelected = new Proyecto();
        }
        return proyectoArchivarSelected;
    }

    public Proyecto getProyectoClonarSelected() {
        if (proyectoClonarSelected == null) {
            proyectoClonarSelected = new Proyecto();
        }
        return proyectoClonarSelected;
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
    GrupoTipoTarjetaServices grupoTipoTarjetaServices;
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
            JmoordbCronometer.startCronometer(FacesUtil.nameOfClassAndMethod());
            totalesTarjetasEstadistica = new TotalesTarjetasEstadistica(0L, 0L, 0L, 0L, 0L);
            includeUser = Boolean.TRUE;
            includeColumna = Boolean.TRUE;
            includeProject = Boolean.FALSE;
            message = "";
            columnaSelected = rf.fromMessage("selectonemenu.pendienteValue");
            depositoSelected = "";
            filterText = "";
            /**
             * WebSocket
             */
            contadorNotificacionesWebsocket = 0;
            jmoordbCronometerOld = 0L;
            dialogVisibleWebSocket = Boolean.FALSE;
            dialogVisibleAddWebSocket = Boolean.FALSE;

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
            loadIcono();

            //Cargar el media type
            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            findByTarjetas();
            this.tarjetaLazyDataModel = new LazyDataModel<Tarjeta>() {
                @Override
                public List<Tarjeta> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    if (includeProject) {

                        if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                            totalRecords = tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
                        } else {
                            if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {

                                totalRecords = tarjetaServices.searchCountLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
                            } else {

                                totalRecords = tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
                            }
                        }
                    } else {
                        totalRecords = 0;
                        for (ProyectoSprintOpen pos : proyectoSprintOpenList) {
                            if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                                totalRecords += tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto()).intValue();
                            } else {
                                if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {

                                    totalRecords += tarjetaServices.searchCountLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto()).intValue();
                                } else {

                                    totalRecords += tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto()).intValue();
                                }
                            }
                        }
                    }

                    List<Paginator> list = new ArrayList<>();
                    if (!isRowPageSmall) {

                        /**
                         * Utiliza rowPage
                         */
                        list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);

                    } else {

                        /**
                         * Utiliza rowPageWithOverlayPanel para el OverlayPanel
                         */
                        list = processLazyDataModel(paginator, paginatorOld, offset, rowPageSmall.get(), totalRecords, sortBy);

                    }
//

                    paginator = list.get(0);
                    paginatorOld = list.get(1);
                    Pagination pagination = new Pagination();
                    if (!isRowPageSmall) {

                        paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));
                        pagination = new Pagination(paginator.getPage(), rowPage.get());
                    } else {

                        paginator.setNumberOfPage(numberOfPages(totalRecords, rowPageSmall.get()));
                        pagination = new Pagination(paginator.getPage(), rowPageSmall.get());
                    }

                    List<Tarjeta> result = new ArrayList<>();
                    if (includeProject) {
                        if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                            result = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
                        } else {
                            if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {
                                result = tarjetaServices.searchLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
                            } else {
                                result = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
                            }
                        }
                    } else {
                        for (ProyectoSprintOpen pos : proyectoSprintOpenList) {

                            if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                                List<Tarjeta> t = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto());
                                if (t == null || t.isEmpty()) {

                                } else {
                                    result.addAll(t);
                                }

                            } else {
                                if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {
                                    List<Tarjeta> t = tarjetaServices.searchLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto());
                                    if (t == null || t.isEmpty()) {

                                    } else {
                                        result.addAll(t);
                                    }
                                } else {

                                    List<Tarjeta> t = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), pos.getProyecto().getIdproyecto());
                                    if (t == null || t.isEmpty()) {

                                    } else {
                                        result.addAll(t);
                                    }
                                }
                            }
                        }
                    }
                    tarjetaLazyDataModel.setRowCount(totalRecords);

                    PrimeFaces.current().executeScript("setDataTableWithPageStart()");
                    PrimeFaces.current().executeScript("widgetVardataTable.getPaginator().setPage(0);");
                    tarjetaList = result;

                    return result;
                }

                @Override
                public int count(Map<String, FilterMeta> map) {

                    return totalRecords;

                }

                @Override
                public String getRowKey(Tarjeta object) {
                    if (object == null || object.getIdtarjeta() == null) {
                        return "";
                    }
                    return object.getIdtarjeta().toString();
                }

                @Override
                public Tarjeta getRowData(String rowKey) {
                    for (Tarjeta t : tarjetaList) {
                        if (t != null) {
                            if (t.getIdtarjeta().equals(rowKey)) {
                                return t;
                            }
                        }
                    }
                    return null;
                }

            };

            JmoordbCronometer.endCronometer(FacesUtil.nameOfClassAndMethod(), "\t\t userLogged.getName()" + userLogged.getName());

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
        areaConverterServices.destroyed();
        departamentViewConverterServices.destroyed();
        grupoTipoTarjetaConverterServices.destroyed();
        iconoConverterServices.destroyed();
        userViewConverterServices.destroyed();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String refresh()">

    @Override
    public String refresh() {
        try {
            tarjetaList = new ArrayList<>();
            textToSearch = "";
            textDescripcionToSearch = "";
            contadorNotificacionesWebsocket = 0;
            dialogVisibleWebSocket = Boolean.FALSE;
            dialogVisibleAddWebSocket = Boolean.FALSE;
            userViewList = new ArrayList<>();
            timelineList = new ArrayList<>();
//
//            proyectoSprintOpenList = proyectoServices.cargarProyectosPrivadosConSprintAbierto(userLogged);
//            proyectoSprintOpenForaneoList = proyectoServices.cargarProyectosPublicosNoAsignadosConSprintAbierto(userLogged);

//            sprintSelected = new Sprint();
            message = "";
//            if (showMiembrosEquipoDashboardPrincipal.get()) {
//                if (proyectoSprintOpenList == null || proyectoSprintOpenList.isEmpty()) {
//                } else {
//                    userViewList = userViewServices.generateUserViewAllListSprintOpen(proyectoSprintOpenList, userViewList);
//                }
//            }

//            if (showEstadisticasProyectoDashboardPrincipal.get()) {
//                proyectoEstadisticaList = proyectoServices.cargarProyectoEstadisticaSprintOpen(proyectoSprintOpenList);
//
//                totalesTarjetasEstadistica = tarjetaServices.calcularTotalesTarjetasEstadistica(userLogged.getIduser(), proyectoSprintOpenList);
//            }

//            if (showNotificacionesDashboardPrincipal.get()) {
//                /**
//                 * Cargar la lista de notificaciones
//                 */
//                notificacionProyectoList = notificacionProyectoServices.findByUserAndVisto(userLogged, false);
//            }
//
//            if (showTimelineDashboardPrincipal.get()) {
//                /**
//                 * Carga el timeline el ultimo evento de cada proyecto
//                 */
//                timelineList = timelineServices.findByProyectoAndActiveSprintOpen(proyectoSprintOpenList, Boolean.TRUE);
//
//            }

            PrimeFaces.current().ajax().update("form");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean showEstadistica()">
    public Boolean showEstadistica() {
        Boolean result = Boolean.TRUE;
        try {

            if (showEstadisticasProyectoDashboardPrincipal == null) {

            } else {

                return showEstadisticasProyectoDashboardPrincipal.get();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean showNotificacion()">

    public Boolean showNotificaciones() {
        Boolean result = Boolean.TRUE;
        try {

            if (showNotificacionesDashboardPrincipal == null) {

            } else {

                return showNotificacionesDashboardPrincipal.get();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean showMiembrosEquipo()">

    public Boolean showMiembrosEquipo() {
        Boolean result = Boolean.TRUE;
        try {

            if (showMiembrosEquipoDashboardPrincipal == null) {

            } else {

                return showMiembrosEquipoDashboardPrincipal.get();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean showTimeline()">

    public Boolean showTimeline() {
        Boolean result = Boolean.TRUE;
        try {

            if (showTimelineDashboardPrincipal == null) {

            } else {

                return showTimelineDashboardPrincipal.get();
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

    // <editor-fold defaultstate="collapsed" desc="String knobColor(Proyecto proyecto)">
    public String knobColor(Proyecto proyecto) {
        String result = "black";
        try {

            result = colorManagement.color(proyecto.getAvance());
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

            result = colorManagement.colorBarClassDashboard(proyecto.getAvance());
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
    public String colorTimeLineDashboard(ProyectoView proyectoView) {
        String result = "h-full bg-orange-500";
        try {

            result = colorManagement.colorTimeLineDashboard(proyectoView.getAvance());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica showProyectoEstadisticaInList(Proyecto proyecto) ">
    /**
     * Muestra las estadisticas para los overlay que se cargaron al inicio.
     *
     * @param proyecto
     * @return
     */
    public ProyectoEstadistica showProyectoEstadisticaInList(Proyecto proyecto) {

        ProyectoEstadistica proyectoEstadistica = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());
        try {

            proyectoEstadistica = proyectoEstadisticaServices.showProyectoEstadisticaInList(proyecto, proyectoEstadisticaList);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoEstadistica;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String go(Proyecto proyecto,String path, Boolean isProyectoForaneo,  Boolean isEditable)">
    /**
     *
     * @param proyecto
     * @param path
     * @param isProyectoForaneo
     * @param editable
     * @return
     */
    public String go(Proyecto proyecto, String path, Boolean isProyectoForaneo, Boolean isEditable) {
        try {

            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyecto, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyecto, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "dashboard");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "dashboard");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String go(Proyecto proyecto,String path, Boolean isProyectoForaneo,  Boolean isEditable)">

    /**
     *
     * @param proyecto
     * @param path
     * @param isProyectoForaneo
     * @param editable
     * @return
     */
    public String goPanelTrabajo() {
        try {

            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "dashboard");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "dashboard");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "paneltrabajo.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSprint(Proyecto proyecto)">
    public Boolean haveOpenSprint(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {

            if (proyecto == null) {
                return result;
            }
            result = sprintServices.haveOpenSprint(proyecto);

            haveOpenSprintTemporal = result;

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSprintAndDateIsLessOrEqualsAndEstadoIniciado(Proyecto proyecto, String estado)">

    public Boolean haveOpenSprintAndDateIsLessOrEqualsAndEstadoIniciado(Proyecto proyecto, String estado) {
        var result = Boolean.FALSE;
        try {

            if (proyecto == null) {
                return result;
            }

            result = sprintServices.haveOpenSprintAndDateIsLessOrEquals(proyecto);
            if (result && proyecto.getEstado().equals(estado)) {

                result = Boolean.TRUE;
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareResumen(Proyecto proyecto)">
    public String prepareResumen(Proyecto proyecto) {
        try {
            dialogVisibleWebSocket = Boolean.TRUE;
            proyectoEstadisticaResumen = proyectoEstadisticaServices.calcularEstadistica(proyecto);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareMiResumen(Proyecto proyecto)">

    public String prepareMiResumen(Proyecto proyecto) {
        try {
            dialogVisibleWebSocket = Boolean.TRUE;
            proyectoEstadisticaResumen = proyectoEstadisticaServices.calcularMisEstadistica(proyecto, userLogged);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Integer showMiResumenPendienteAddProgreso(Proyecto proyecto)">

    public Integer showMiResumenPendienteAddProgreso(Proyecto proyecto) {
        Integer result = 0;
        try {

            ProyectoEstadistica proyectoEstadisticaResumen = proyectoEstadisticaServices.calcularMisEstadistica(proyecto, userLogged);
            if (proyectoEstadisticaResumen == null) {

            } else {
                result = proyectoEstadisticaResumen.getTotalTarjetasPendiente() + proyectoEstadisticaResumen.getTotalTarjetasProgreso();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="dataOfProyectoEstadistica(Proyecto proyecto)">

    public ProyectoEstadistica dataOfProyectoEstadistica(Proyecto proyecto) {
        ProyectoEstadistica result = new ProyectoEstadistica(0, 0, 0, 0, 0, 0L);
        try {

            ProyectoEstadistica proyectoEstadisticaResumen = proyectoEstadisticaServices.calcularMisEstadistica(proyecto, userLogged);
            if (proyectoEstadisticaResumen == null) {

            } else {
                result = proyectoEstadisticaResumen;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;

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

    // <editor-fold defaultstate="collapsed" desc="List<UserView> completeUserViewColaboradorNew(String query)">
    public List<UserView> completeUserViewColaboradorNew(String query) {

        List<UserView> result = new ArrayList<>();
        try {
            query = query.trim();

            result = dashboardFacesServices.loadUserViewHowColaboradoresNewOrEdit(query, userViewColaboradorNewSelectedList);

            userViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get()))
            );
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView> completeUserViewColaboradorEdit(String query)">
    public List<UserView> completeUserViewColaboradorEdit(String query) {

        List<UserView> result = new ArrayList<>();
        try {
            query = query.trim();

            result = dashboardFacesServices.loadUserViewHowColaboradoresNewOrEdit(query, userViewColaboradorEditSelectedList);
            userViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get()))
            );

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<UserView> completeUserViewPropietarioNew(String query)">

    public List<UserView> completeUserViewPropietarioNew(String query) {

        List<UserView> result = new ArrayList<>();
        try {
            query = query.trim();
            result = dashboardFacesServices.loadUserViewHowPropietarioNewOrEdit(query, userViewPropietarioNewSelectedList);

            userViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get()))
            );

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<UserView> completeUserViewPropietarioEdit(String query)">

    public List<UserView> completeUserViewPropietarioEdit(String query) {

        List<UserView> result = new ArrayList<>();
        try {
            query = query.trim();

            result = dashboardFacesServices.loadUserViewHowPropietarioNewOrEdit(query, userViewPropietarioEditSelectedList);
            userViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get()))
            );
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
    // <editor-fold defaultstate="collapsed" desc="  autocompleteSelectedEvent(SelectEvent event)">

    public void autocompleteGrupoTipoTarjetaSelectedEvent(SelectEvent<GrupoTipoTarjeta> event) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void autocompleteUnselectListener(UnselectEvent event)">
    public void autocompleteUnselectListener(UnselectEvent event) {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> completeDepartamentView(String query)">
    public List<DepartamentView> completeDepartamentView(String query) {

        List<DepartamentView> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarDepartamentView(query);

            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Departament> cargarDepartament(String query)">
    private List<DepartamentView> cargarDepartamentView(String query) {

        List<DepartamentView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

            List<DepartamentView> list = departamentViewServices.likeByDepartament(query);

            if (proyectoNewSelected.getDepartamentView().isEmpty()) {

                return list;
            } else {

                for (DepartamentView dvDB : list) {
                    found = Boolean.FALSE;
                    for (DepartamentView dv : proyectoNewSelected.getDepartamentView()) {

                        if (dvDB.getIddepartament().equals(dv.getIddepartament())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(dvDB);
                    }
                }

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> completeDepartamentViewEditar(String query)">

    public List<DepartamentView> completeDepartamentViewEditar(String query) {

        List<DepartamentView> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarDepartamentViewEditar(query);
            departamentViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get())));
            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Departament> cargarDepartament(String query)">
    private List<DepartamentView> cargarDepartamentViewEditar(String query) {

        List<DepartamentView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

            List<DepartamentView> list = departamentViewServices.likeByDepartament(query);

            if (departamentViewList.isEmpty()) {

                return list;
            } else {

                for (DepartamentView dvDB : list) {
                    found = Boolean.FALSE;
                    for (DepartamentView dv : departamentViewList) {

                        if (dvDB.getIddepartament().equals(dv.getIddepartament())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(dvDB);
                    }
                }

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Area> cargarArea(String query)">
    private List<Area> cargarArea(String query) {
        List<Area> result = new ArrayList<>();
        Boolean found = Boolean.FALSE;
        try {
            List<Area> list = areaServices.likeByArea(query);
            if (proyectoNewSelected.getArea().isEmpty()) {
                return list;
            } else {
                for (Area aDB : list) {
                    found = Boolean.FALSE;
                    for (Area dv : proyectoNewSelected.getArea()) {
                        if (aDB.getIdarea().equals(dv.getIdarea())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(aDB);
                    }
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Area> cargarAreaEdit(String query)">

    private List<Area> cargarAreaEditar(String query) {
        List<Area> result = new ArrayList<>();
        Boolean found = Boolean.FALSE;
        try {
            List<Area> list = areaServices.likeByArea(query);
            if (areaList.isEmpty()) {
                return list;
            } else {
                for (Area aDB : list) {
                    found = Boolean.FALSE;
                    for (Area dv : areaList) {
                        if (aDB.getIdarea().equals(dv.getIdarea())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(aDB);
                    }
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> cargarGrupoTipoTarjeta(String query)">

    private List<GrupoTipoTarjeta> cargarGrupoTipoTarjetaEditar(String query) {
        List<GrupoTipoTarjeta> result = new ArrayList<>();
        Boolean found = Boolean.FALSE;
        try {
            List<GrupoTipoTarjeta> list = grupoTipoTarjetaServices.likeByGrupoTipoTarjeta(query);
            if (grupoTipoTarjetaList.isEmpty()) {
                return list;
            } else {
                for (GrupoTipoTarjeta aDB : list) {
                    found = Boolean.FALSE;
                    for (GrupoTipoTarjeta dv : grupoTipoTarjetaList) {
                        if (aDB.getIdgrupotipotarjeta().equals(dv.getIdgrupotipotarjeta())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(aDB);
                    }
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Area> completeArea(String query)">
    public List<Area> completeArea(String query) {

        List<Area> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarArea(query);

            areaConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get())));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> completeGrupoTipoTarjeta(String query)">

    public List<GrupoTipoTarjeta> completeGrupoTipoTarjeta(String query) {

        List<GrupoTipoTarjeta> result = new ArrayList<>();
        try {
            query = query.trim();

            result = cargarGrupoTipoTarjeta(query);
            grupoTipoTarjetaConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get())));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> cargarGrupoTipoTarjeta(String query)">
    private List<GrupoTipoTarjeta> cargarGrupoTipoTarjeta(String query) {
        List<GrupoTipoTarjeta> result = new ArrayList<>();
        Boolean found = Boolean.FALSE;
        try {
            List<GrupoTipoTarjeta> list = grupoTipoTarjetaServices.likeByGrupoTipoTarjeta(query);
            if (proyectoNewSelected.getGrupoTipoTarjeta() == null || proyectoNewSelected.getGrupoTipoTarjeta().isEmpty()) {
                return list;
            } else {
                for (GrupoTipoTarjeta aDB : list) {
                    found = Boolean.FALSE;
                    for (GrupoTipoTarjeta dv : proyectoNewSelected.getGrupoTipoTarjeta()) {
                        if (aDB.getIdgrupotipotarjeta().equals(dv.getIdgrupotipotarjeta())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(aDB);
                    }
                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Area> completeAreaEditar(String query)">
    public List<Area> completeAreaEditar(String query) {

        List<Area> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarAreaEditar(query);

            areaConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get())));

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> completeGrupoTipoTarjetaEditar(String query)">

    public List<GrupoTipoTarjeta> completeGrupoTipoTarjetaEditar(String query) {
        List<GrupoTipoTarjeta> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarGrupoTipoTarjeta(query);

            grupoTipoTarjetaConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get())));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void closeOverlayPanel(String panel) ">
    public void closeOverlayPanel(String panel) {
        try {
            PrimeFaces.current().executeScript(panel);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sugerirPrefijo(AjaxBehaviorEvent event)">
    public void sugerirPrefijo(AjaxBehaviorEvent event) {
        try {
            proyectoNewSelected.setPrefijo(proyectoServices.sugerirPrefijo(proyectoNewSelected));

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="sugerirPrefijoEditar(AjaxBehaviorEvent event)">

    public void sugerirPrefijoEditar(AjaxBehaviorEvent event) {
        try {
            proyectoEditarSelected.setPrefijo(proyectoServices.sugerirPrefijo(proyectoEditarSelected));

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="sugerirPrefijoClonar(AjaxBehaviorEvent event)">

    public void sugerirPrefijoClonar(AjaxBehaviorEvent event) {
        try {
            proyectoClonarSelected.setPrefijo(proyectoServices.sugerirPrefijo(proyectoClonarSelected));

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="genererNumeroPrefijo">

    public void genererNumeroPrefijo() {
        try {

            if (proyectoNewSelected.getPrefijo() == null || proyectoNewSelected.getPrefijo().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresenumeroprefijo"));
                return;
            } else {
                proyectoNewSelected.setPrefijo(proyectoServices.genererNumeroPrefijo(proyectoNewSelected, rf));

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void genererNumeroPrefijoEditar()">

    public void genererNumeroPrefijoEditar() {
        try {

            if (proyectoEditarSelected.getPrefijo() == null || proyectoEditarSelected.getPrefijo().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresenumeroprefijo"));
                return;
            } else {
                proyectoEditarSelected.setPrefijo(proyectoServices.genererNumeroPrefijo(proyectoEditarSelected, rf));

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void genererNumeroPrefijoClonar(">

    public void genererNumeroPrefijoClonar() {
        try {

            if (proyectoClonarSelected.getPrefijo() == null || proyectoClonarSelected.getPrefijo().equals("")) {
                //  FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresenumeroprefijo"));
                return;
            } else {
                proyectoClonarSelected.setPrefijo(proyectoServices.genererNumeroPrefijo(proyectoClonarSelected, rf));

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

            this.proyectoDB = new Proyecto();

            message = "";

            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            proyectoNewSelected = new Proyecto();
            departamentViewList = new ArrayList<>();
            areaList = new ArrayList<>();

            Bson filter = eq("active", Boolean.TRUE);
            Document sort = new Document("idarea", 1);

            List<Area> list = areaServices.lookup(filter, sort, 1, 1);
            if (list == null || list.isEmpty()) {

            } else {
                areaList.add(list.get(0));
            }
            proyectoNewSelected.setArea(areaList);

            proyectoNewSelected.setDepartamentView(departamentViewList);

            if (iconoConverterServices.getIconos() == null || iconoConverterServices.getIconos().isEmpty()) {

            } else {
                proyectoNewSelected.setIcono(iconoConverterServices.getIconos().get(0));
            }
            proyectoNewSelected.setFechainicial(JmoordbCoreDateUtil.insertHoursMinutesSecondsToDate(JmoordbCoreDateUtil.getFechaHoraActual(), 8, 0, 0));

            proyectoNewSelected.setFechafinal(JmoordbCoreDateUtil.insertHoursMinutesSecondsToDate(JmoordbCoreDateUtil.ultimaFechaAnio(), 23, 59, 0));
            proyectoNewSelected.setActive(Boolean.TRUE);
            proyectoNewSelected.setAvance(0.0);
            proyectoNewSelected.setEstado("iniciado");
            proyectoNewSelected.setDiasAlertaVencimiento(2);
            proyectoNewSelected.setGrupoTipoTarjeta(new ArrayList<>());
            proyectoNewSelected.setPrivado(Boolean.TRUE);
            proyectoNewSelected.setAgregarTarjetaDuplicada(Boolean.TRUE);
            proyectoNewSelected.setColaboradorcreartarjeta(Boolean.TRUE);
            proyectoNewSelected.setShowTarjetaPrivado(Boolean.TRUE);
            proyectoNewSelected.setShowTodasReserva(Boolean.TRUE);

            proyectoNewSelected.setCentralView(userLogged.getCentralView());
            proyectoNewSelected.setGenerarsprintautomaticamente(Boolean.TRUE);
            departamentViewList = new ArrayList<>();
            departamentViewList.add(profileLogged.getDepartamentView());
            proyectoNewSelected.setDepartamentView(departamentViewList);

            userViewColaboradorNewSelectedList = new ArrayList<>();
            userViewPropietarioNewSelectedList = new ArrayList<>();
            UserView userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());
            userViewPropietarioNewSelectedList.add(userView);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareEditar(Proyecto proyecto)">

    public String prepareEditar(Proyecto proyecto) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            this.proyectoEditarSelected = new Proyecto();
            this.proyectoEditarSelected = validarSiCambioEnPrepare(proyecto);

//            JmoordbCoreUtil.copyBeans(this.proyectoEditarSelected, proyecto);
            grupoTipoTarjetaList = new ArrayList<>();
            proyectoMiembroOldList = proyectoEditarSelected.getProyectoMiembro();
            departamentViewList = new ArrayList<>();
            departamentViewList.addAll(proyectoEditarSelected.getDepartamentView());
            areaList = new ArrayList<>();
            areaList.addAll(proyectoEditarSelected.getArea());
            if (proyectoEditarSelected.getGrupoTipoTarjeta() == null) {

            } else {
                grupoTipoTarjetaList = proyectoEditarSelected.getGrupoTipoTarjeta();
            }

            /**
             * Carga el propietario y colaborador
             */
            userViewColaboradorEditSelectedList = new ArrayList<>();
            userViewPropietarioEditSelectedList = new ArrayList<>();
            if (proyectoEditarSelected.getProyectoMiembro() == null || proyectoEditarSelected.getProyectoMiembro().isEmpty()) {
                //

            } else {
                for (ProyectoMiembro pm : proyectoEditarSelected.getProyectoMiembro()) {
                    if (pm.getActive()) {
                        if (pm.getPropietario()) {
                            userViewPropietarioEditSelectedList.add(pm.getUserView());
                        } else {
                            userViewColaboradorEditSelectedList.add(pm.getUserView());
                        }
                    }
                }

            }

            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareArchivar(Proyecto proyecto)">

    public String prepareArchivar(Proyecto proyecto) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            this.proyectoArchivarSelected = new Proyecto();
            this.proyectoArchivarSelected = validarSiCambioEnPrepare(proyecto);

            totalOpenParaArchivarProyecto = sprintServices.totalSprintOpen(proyecto, Boolean.TRUE);
            totalColumnaPendienteParaArchivarProyecto = tarjetaServices.totalPorColumna(proyecto, "pendiente", Boolean.FALSE);
            totalColumnaProgresoArchivarProyecto = tarjetaServices.totalPorColumna(proyecto, "progreso", Boolean.FALSE);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareEliminar(Proyecto proyecto)">

    public String prepareEliminar(Proyecto proyecto) {
        try {

            dialogVisibleWebSocket = Boolean.TRUE;
            this.proyectoEliminarSelected = new Proyecto();
            this.proyectoEliminarSelected = validarSiCambioEnPrepare(proyecto);

            totalOpenParaEliminarProyecto = sprintServices.totalSprintOpen(proyecto, Boolean.TRUE);
            totalColumnaPendienteParaEliminarProyecto = tarjetaServices.totalPorColumna(proyecto, "pendiente", Boolean.FALSE);
            totalColumnaProgresoEliminarProyecto = tarjetaServices.totalPorColumna(proyecto, "progreso", Boolean.FALSE);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareClonar(Proyecto proyecto)">

    public String prepareClonar(Proyecto proyecto) {
        try {
            dialogVisibleWebSocket = Boolean.TRUE;
            validarSiCambioEnPrepare(proyecto);
            JmoordbCoreUtil.copyBeans(this.proyectoClonarSelected, proyecto);

            Integer index = proyectoClonarSelected.getPrefijo().indexOf("-");

            if (index < 0) {

            } else {
                String prefijoNew = proyectoClonarSelected.getPrefijo().substring(0, index + 1);
                proyectoClonarSelected.setPrefijo(prefijoNew);
            }
            genererNumeroPrefijoClonar();

            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="save(Proyecto proyecto)">
    public void save(Proyecto proyecto) {
        try {

            List<ProyectoMiembro> proyectoMiembroList = new ArrayList<>();

            departamentViewList = proyecto.getDepartamentView();
            areaList = proyecto.getArea();

            if (!proyectoServices.isValidProyecto(proyecto, departamentViewList, areaList, userViewPropietarioNewSelectedList, rf)) {
                return;
            }

            for (UserView uv : userViewPropietarioNewSelectedList) {
                ProyectoMiembro proyectoMiembro = new ProyectoMiembro(Boolean.TRUE, uv, Boolean.TRUE);
                proyectoMiembroList.add(proyectoMiembro);

            }
            /**
             * Un proyecto puede que tenga un solo propietario sin colaboradores
             */
            if (userViewColaboradorNewSelectedList == null || userViewColaboradorNewSelectedList.isEmpty()) {

            } else {
                for (UserView uv : userViewColaboradorNewSelectedList) {
                    ProyectoMiembro proyectoMiembro = new ProyectoMiembro(Boolean.FALSE, uv, Boolean.TRUE);
                    proyectoMiembroList.add(proyectoMiembro);

                }
            }
            proyecto.setProyectoMiembro(proyectoMiembroList);

            if (proyecto.getProyectoMiembro() == null || proyecto.getProyectoMiembro().isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.miembroproyecto"));
                return;
            }

            proyecto.setDepartamentView(departamentViewList);

            proyecto.setArea(areaList);

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("crear")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            proyecto.setActionHistory(actionHistoryList);

            if (proyectoServices.nombreProyectoExiste(proyecto.getProyecto())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconnombreigual"));
                return;
            }

            if (proyectoServices.prefijoExiste(proyecto.getPrefijo())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconprefijoigual"));
                return;
            }

            if (!proyectoServices.save(proyecto).isPresent()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.save"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                FacesUtil.successMessage(rf.fromMessage("info.saveproyecto"));
                sendEmailCreateProject(proyecto);

                /**
                 * WebSocket
                 */
                userViewForWebSocketList = userViewFromProjectExclude(proyecto, Boolean.FALSE, userLogged);

                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyecto.getIdproyecto() != null ? proyecto.getIdproyecto().toString() : "")
                        .message("Guardar proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);
                closeOverlayPanel("PF('overlayPanelProyectoAgregar').hide()");

                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    public void closeProjectDialog() {
        try {
            dialogVisibleAddWebSocket = Boolean.FALSE;
            closeOverlayPanel("PF('overlayPanelProyectoAgregar').hide()");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="editar(Proyecto proyecto)">
    public void editar(Proyecto proyecto) {
        try {
            if (!proyectoServices.isValidProyecto(proyecto, departamentViewList, areaList, userViewPropietarioEditSelectedList, rf)) {
                return;
            }

            Proyecto proyectoDBNow = proyectoServices.findByIdproyecto(proyecto.getIdproyecto()).get();
            if (!proyectoDBNow.equals(proyectoDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                refresh();
                return;
            }

            Optional<Proyecto> proyectoOptional = proyectoServices.proyectoConIgualNombre(proyecto.getProyecto());

            if (proyectoOptional.isPresent()) {

                if (!proyecto.getIdproyecto().equals(proyectoOptional.get().getIdproyecto())) {

                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconnombreigual"));
                    return;
                }

            }
            Optional<Proyecto> proyectoPrefijoOptional = proyectoServices.proyectoConIgualPrefijo(proyecto.getPrefijo());

            if (proyectoOptional.isPresent()) {

                if (!proyecto.getIdproyecto().equals(proyectoOptional.get().getIdproyecto())) {

                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconprefijoigual"));
                    return;
                }

            }

            List<ProyectoMiembro> proyectoMiembroList = new ArrayList<>();
            for (UserView uv : userViewPropietarioEditSelectedList) {
                ProyectoMiembro proyectoMiembro = new ProyectoMiembro(Boolean.TRUE, uv, Boolean.TRUE);
                proyectoMiembroList.add(proyectoMiembro);

            }
            /**
             * Un proyecto puede que tenga un solo propietario sin colaboradores
             */
            if (userViewColaboradorEditSelectedList == null || userViewColaboradorEditSelectedList.isEmpty()) {

            } else {
                for (UserView uv : userViewColaboradorEditSelectedList) {
                    ProyectoMiembro proyectoMiembro = new ProyectoMiembro(Boolean.FALSE, uv, Boolean.TRUE);
                    proyectoMiembroList.add(proyectoMiembro);

                }
            }
            proyecto.setProyectoMiembro(proyectoMiembroList);

            if (proyecto.getProyectoMiembro() == null || proyecto.getProyectoMiembro().isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.miembroproyecto"));
                return;
            }

            proyecto.setDepartamentView(departamentViewList);
            proyecto.setGrupoTipoTarjeta(grupoTipoTarjetaList);
            proyecto.setArea(areaList);

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            proyecto.getActionHistory().add(actionHistory);

            if (!proyectoServices.update(proyecto)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                FacesUtil.successMessage(rf.fromMessage("info.updateproyecto"));
                sendEmailEditProject(proyecto);
                /**
                 * WebSocket
                 */

//                userViewForWebSocketList = userViewFromProjectExclude(proyecto, Boolean.FALSE, userLogged);
                userViewForWebSocketList = userViewFromProjectExcludeIncludeOldUser(proyecto, proyectoMiembroOldList, Boolean.FALSE, userLogged);

                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyecto.getIdproyecto() != null ? proyecto.getIdproyecto().toString() : "")
                        .message("Editar proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);

                closeOverlayPanel("PF('overlayPanelProyectoEditar').hide()");
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="archivar(Proyecto proyecto)">

    public void archivar(Proyecto proyecto) {
        try {

            Proyecto proyectoDBNow = proyectoServices.findByIdproyecto(proyecto.getIdproyecto()).get();
            if (!proyectoDBNow.equals(proyectoDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }

            /**
             * Cuando se pasa a finalizado verificar que no tenga tareas
             * pendientes
             */
            proyecto.setEstado(rf.fromMessage("selectonemenu.finalizadovalue"));

            if (sprintServices.totalSprintOpen(proyecto, Boolean.TRUE) > 0L) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.proyectotienesprintabiertos"));
                refresh();
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            proyecto.getActionHistory().add(actionHistory);

            if (!proyectoServices.update(proyecto)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                FacesUtil.successMessage(rf.fromMessage("info.updateproyecto"));
                sendEmailEditProject(proyecto);
                /**
                 * WebSocket
                 */
                userViewForWebSocketList = userViewFromProjectExclude(proyecto, Boolean.FALSE, userLogged);
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyecto.getIdproyecto() != null ? proyecto.getIdproyecto().toString() : "")
                        .message("Archivar proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);

                closeOverlayPanel("PF('overlayPanelProyectoArchivar').hide()");
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="eliminar(Proyecto proyecto)">

    public void eliminar(Proyecto proyecto) {
        try {

            Proyecto proyectoDBNow = proyectoServices.findByIdproyecto(proyecto.getIdproyecto()).get();
            if (!proyectoDBNow.equals(proyectoDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }

            /**
             * Cuando se pasa a finalizado verificar que no tenga tareas
             * pendientes
             */
            proyecto.setEstado(rf.fromMessage("selectonemenu.eliminadovalue"));

            if (sprintServices.totalSprintOpen(proyecto, Boolean.TRUE) > 0L) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.proyectotienesprintabiertos"));
                refresh();
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            proyecto.getActionHistory().add(actionHistory);

            if (!proyectoServices.update(proyecto)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                FacesUtil.successMessage(rf.fromMessage("info.updateproyecto"));
                sendEmailEditProject(proyecto);
                /**
                 * WebSocket
                 */
                userViewForWebSocketList = userViewFromProjectExclude(proyecto, Boolean.FALSE, userLogged);
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyecto.getIdproyecto() != null ? proyecto.getIdproyecto().toString() : "")
                        .message("Archivar proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);

                closeOverlayPanel("PF('overlayPanelProyectoArchivar').hide()");
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="clonar(Proyecto proyecto)">
    public void clonar(Proyecto proyecto) {
        try {
            Proyecto proyectoDBNow = proyectoServices.findByIdproyecto(proyecto.getIdproyecto()).get();
            if (!proyectoDBNow.equals(proyectoDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;

            }
            if (proyecto.getProyecto() == null || proyecto.getProyecto().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nombreproyecto"));
                return;
            }
            if (proyecto.getPrefijo() == null || proyecto.getPrefijo().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.prefijoproyecto"));
                return;
            }

            if (proyectoServices.nombreProyectoExiste(proyecto.getProyecto())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconnombreigual"));
                return;
            }

            if (proyectoServices.prefijoExiste(proyecto.getPrefijo())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeproyectoconprefijoigual"));
                return;
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("proyecto creada a partir de una clonación")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.addAll(proyecto.getActionHistory());
            actionHistoryList.add(actionHistory);

            proyecto.setActionHistory(actionHistoryList);

            if (!proyectoServices.save(proyecto).isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.clone"));
            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                /**
                 * WebSocket
                 */
                userViewForWebSocketList = userViewFromProjectExclude(proyecto, Boolean.FALSE, userLogged);
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyecto.getIdproyecto() != null ? proyecto.getIdproyecto().toString() : "")
                        .message("Clonar proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);

                FacesUtil.successMessage(rf.fromMessage("info.cloneproyecto"));
                closeOverlayPanel("PF('overlayPanelProyectoClonar').hide()");
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Proyecto validarSiCambioEnPrepare(Proyecto proyecto)" >
    private Proyecto validarSiCambioEnPrepare(Proyecto proyecto) {
        Proyecto result = new Proyecto();
        try {
            message = "";
            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            this.proyectoDB = proyectoServices.findByIdproyecto(proyecto.getIdproyecto()).get();
            if (proyectoDB.equals(proyecto)) {

                result = proyecto;
            } else {

                fueCambiadoPorOtroUsuario = Boolean.TRUE;
                message = rf.fromMessage("warning.otrousuarioactualizoproyectosincronizeeltablero");
                result = proyectoDB;
                refresh();

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isPropietarioDelProyecto(Proyecto proyecto)">
    public Boolean isPropietarioDelProyecto(Proyecto proyecto) {
        return proyectoServices.isPropietarioDelProyecto(proyecto, userLogged);
    }
// </editor-fold>

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    // <editor-fold defaultstate="collapsed" desc="String colorProyecto(Proyecto proyecto, Boolean foraneo)">
    public String colorProyecto(Proyecto proyecto, Boolean foraneo) {

        return proyectoServices.colorProyecto(proyecto, foraneo);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void sendEmailCreateProject(Proyecto proyecto)>
    public void sendEmailCreateProject(Proyecto proyecto) {
        try {

            List<String> emailColaboradorList = new ArrayList<>();
            List<String> emailPropietarioList = new ArrayList<>();

            /**
             *
             */
            Boolean found = Boolean.FALSE;
            /**
             * Recorre el old y busca los que se han removido
             */

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {

                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    // ya se le envio
                } else {
                    if (pm.getPropietario()) {
                        emailPropietarioList.add(pm.getUserView().getEmail());
                    } else {
                        emailColaboradorList.add(pm.getUserView().getEmail());
                    }

                }
            }

            String tituloEmail = "";
            String mensajeEmail = "";

            if (emailColaboradorList == null || emailColaboradorList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("emailtitulo.proyectocreado");

                mensajeEmail
                        = "<strong>" + rf.fromMessage("email.proyecto") + "</strong>" + " " + proyecto.getProyecto() + " <br>"
                        + "<strong>" + rf.fromMessage("email.enviadopor") + "</strong>" + " " + userLogged.getName() + "<br>"
                        + "<strong>" + rf.fromMessage("email.evento") + "</strong>" + " " + rf.fromMessage("email.asignadoaproyectocomocolaborador") + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailColaboradorList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }
            if (emailPropietarioList == null || emailPropietarioList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("emailtitulo.proyectocreado");

                mensajeEmail
                        = "<strong>" + rf.fromMessage("email.proyecto") + "</strong>" + " " + proyecto.getProyecto() + " <br>"
                        + "<strong>" + rf.fromMessage("email.enviadopor") + "</strong>" + " " + userLogged.getName() + "<br>"
                        + "<strong>" + rf.fromMessage("email.evento") + "</strong>" + " " + rf.fromMessage("email.asignadoaproyectocomopropietario") + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");

                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailPropietarioList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void sendEmailCreateProject(Proyecto proyecto)">

    public void sendEmailEditProject(Proyecto proyecto) {
        try {

            if (proyectoMiembroOldList == null || proyectoMiembroOldList.isEmpty()) {
                return;
            }

            if (proyecto.getProyectoMiembro() == null || proyecto.getProyectoMiembro().isEmpty()) {
                return;
            }
            List<ProyectoMiembro> pmAgregadoList = new ArrayList<>();
            List<ProyectoMiembro> pmRemovidoList = new ArrayList<>();

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                Optional<ProyectoMiembro> proyectoMiembroOptional = proyectoMiembroOldList.stream().filter(x -> x.getUserView().getIduser().equals(pm.getUserView().getIduser())).findFirst();
                if (proyectoMiembroOptional.isPresent()) {
                    // ya se le envio
                } else {
                    if (!pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                        pmAgregadoList.add(pm);

                    }

                }
            }
            for (ProyectoMiembro pm : proyectoMiembroOldList) {
                Optional<ProyectoMiembro> proyectoMiembroOptional = proyecto.getProyectoMiembro().stream().filter(x -> x.getUserView().getIduser().equals(pm.getUserView().getIduser())).findFirst();
                if (proyectoMiembroOptional.isPresent()) {
                    // ya se le envio
                } else {
                    if (!pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                        pmRemovidoList.add(pm);

                    }

                }
            }

            List<String> emailAgregadoList = new ArrayList<>();

            List<String> emailRemovidoList = new ArrayList<>();

            /**
             *
             */
            Boolean found = Boolean.FALSE;
            /**
             * Recorre el old y busca los que se han removido
             */

            for (ProyectoMiembro pm : pmAgregadoList) {

                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    // ya se le envio
                } else {
                    emailAgregadoList.add(pm.getUserView().getEmail());

                }
            }
            for (ProyectoMiembro pm : pmRemovidoList) {

                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    // ya se le envio
                } else {
                    emailRemovidoList.add(pm.getUserView().getEmail());

                }
            }

            String tituloEmail = "";
            String mensajeEmail = "";

            if (emailAgregadoList == null || emailAgregadoList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("emailtitulo.proyectoeditado");

                mensajeEmail
                        = "<strong>" + rf.fromMessage("email.proyecto") + "</strong>" + " " + proyecto.getProyecto() + " <br>"
                        + "<strong>" + rf.fromMessage("email.enviadopor") + "</strong>" + " " + userLogged.getName() + "<br>"
                        + "<strong>" + rf.fromMessage("email.evento") + "</strong>" + " " + rf.fromMessage("email.asignadoaproyectocomomiembro") + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailAgregadoList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }
            if (emailRemovidoList == null || emailRemovidoList.isEmpty()) {

            } else {

                tituloEmail = rf.fromMessage("emailtitulo.proyectoeditado");

                mensajeEmail
                        = "<strong>" + rf.fromMessage("email.proyecto") + "</strong>" + " " + proyecto.getProyecto() + " <br>"
                        + "<strong>" + rf.fromMessage("email.enviadopor") + "</strong>" + " " + userLogged.getName() + "<br>"
                        + "<strong>" + rf.fromMessage("email.evento") + "</strong>" + " " + rf.fromMessage("email.removidodelproyecto") + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");

                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailRemovidoList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
                // FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
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
                closeOverlayPanel("PF('overlayPanelProyectoAgregar').show()");
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
    // <editor-fold defaultstate="collapsed" desc="void sendMensajesWebsocket(Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent))">

    @Override
    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareSprintOpen(SprintOpen sprintOpen)">
    public String prepareSprintOpen(SprintOpen sprintOpen) {
        try {
            dialogVisibleWebSocket = Boolean.TRUE;
            sprintOpenSelected = sprintOpen;
//          sprintOpenSelected = verifySprintOpen(proyecto,isPrivate);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>

    @Override
    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Boolean exclude) {
        try {
            List<UserView> result = filterUserViewListForWebSocket(userViewForWebSocketList, exclude, userLogged);

            webSocketController.sendMessageProyectoMultiple(messageWebSocket.toJSON(), result);

            webSocketController.sendMessageTableroMultiple(messageWebSocket.toJSON(), result);
            webSocketController.sendMessageSprintMultiple(messageWebSocket.toJSON(), result);
            webSocketController.sendMessagePapeleraReciclajeMultiple(messageWebSocket.toJSON(), result);
            webSocketController.sendMessageBacklogMultiple(messageWebSocket.toJSON(), result);
            webSocketController.sendMessagePanelTrabajoMultiple(messageWebSocket.toJSON(), result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Boolean validDateProject(Proyecto proyecto)">
    public Boolean validDateProject(Proyecto proyecto) {
        Boolean result = Boolean.TRUE;
        try {
            String resultV = validarEstadoIniciadoYFechaProyecto(proyecto, rf, Boolean.TRUE);

            if (!resultV.equals("")) {
                result = Boolean.FALSE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public String goPapeleraReciclaje(ProyectoSprintOpen proyectoSprintOpen)">
    public String goPapeleraReciclaje(ProyectoSprintOpen proyectoSprintOpen) {
        try {

            Boolean isPropietario = proyectoServices.isPropietario(proyectoSprintOpen.getProyecto(), userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSprintOpen.getProyecto(), userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSprintOpen.getProyecto());
            Optional<Sprint> sprintOptional = sprintServices.findByIdsprint(proyectoSprintOpen.getSprintOpen().getIdpsrint());
            if (!sprintOptional.isPresent()) {
                return "";
            }

            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintOptional.get());
            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", Boolean.FALSE);
            JmoordbCoreContext.put("DashboardFaces.isEditable", Boolean.TRUE);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "dashboard");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "papelerareciclaje.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">
    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>  

    public ProyectoEstadistica estadisticaProyectoData(Proyecto proyecto) {
        ProyectoEstadistica result = new ProyectoEstadistica();
        try {
            for (ProyectoEstadistica pe : proyectoEstadisticaList) {
                if (pe.getIdproyecto().equals(proyecto.getIdproyecto())) {
                    return pe;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // <editor-fold defaultstate="collapsed" desc="String visualizarDetallesProyecto()">

    public String visualizarDetallesProyecto() {
        try {

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="method">
    public String showTarjetas(String columna) {
//        tarjetaViewDashboard = new ArrayList<>();
        try {
            //Aqui falta colocar las tarjetas
            includeColumna = Boolean.TRUE;
            includeDeposito = Boolean.FALSE;
            includeProject = Boolean.FALSE;
            switch (columna) {
                case "pendiente":
                    columnaSelected = rf.fromMessage("selectonemenu.pendienteValue");
                    break;
                case "progreso":
                    columnaSelected = rf.fromMessage("selectonemenu.progresoValue");
                    break;
                case "finalizado":
                    columnaSelected = rf.fromMessage("selectonemenu.finalizadoValue");
                    break;
                case "backlog":
                    includeColumna = Boolean.FALSE;
                    includeDeposito = Boolean.TRUE;
                    depositoSelected = rf.fromMessage("selectonemenu.depositoreservaValue");
                    break;
            }

            findByTarjetas();
            setFirstPageDataTable();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String showTarjetasWithProject(String columna)">
    public String showTarjetasWithProject(String columna, Proyecto proyecto) {
//        tarjetaViewDashboard = new ArrayList<>();
        try {
            //Aqui falta colocar las tarjetas
            includeColumna = Boolean.TRUE;
            includeDeposito = Boolean.FALSE;
            includeProject = Boolean.TRUE;
            proyectoAutocompleteSelected = proyecto;
            switch (columna) {
                case "pendiente":
                    columnaSelected = rf.fromMessage("selectonemenu.pendienteValue");
                    break;
                case "progreso":
                    columnaSelected = rf.fromMessage("selectonemenu.progresoValue");
                    break;
                case "finalizado":
                    columnaSelected = rf.fromMessage("selectonemenu.finalizadoValue");
                    break;
                case "backlog":
                    includeColumna = Boolean.FALSE;
                    includeDeposito = Boolean.TRUE;
                    depositoSelected = rf.fromMessage("selectonemenu.depositoreservaValue");
                    break;
            }

            findByTarjetas();
            setFirstPageDataTable();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setFirstPageDataTable()">
    public void setFirstPageDataTable() {

        if (dataTable != null) {
            dataTable.setFirst(0);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String findByTarjetas()">
    public String findByTarjetas() {
        try {
            filterText = "";

            Bson filter = and(
                    eq("active", Boolean.TRUE)
            );
            if (includeUser) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
                filterText += " [" + rf.fromMessage("filtro.user") + "] = " + userLogged.getName();
            } else {
                var userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());

                Bson filterUser = eq("userView.iduser", userView.getIduser());
                for (UserView uv : userViewList) {
                    if (userView.getIduser().equals(uv.getIduser())) {

                    } else {
                        filterUser = or(filterUser,
                                eq("userView.iduser", uv.getIduser()));
                    }

                }
                filter = and(filter, filterUser);

            }
            if (includeProject) {
                filter = and(filter, eq("idproyecto", proyectoAutocompleteSelected.getIdproyecto()));
                filterText += " [" + rf.fromMessage("filtro.proyecto") + "] = " + proyectoAutocompleteSelected.getProyecto();
            }
            if (includeColumna) {
                filterText += " [" + rf.fromMessage("filtro.columna") + "] = " + columnaSelected;
                filter = and(filter,
                        eq("columna", columnaSelected));
            }
            if (includeDeposito) {
                filterText += " [" + rf.fromMessage("filtro.deposito") + "] = " + depositoSelected;
                var backlog = Boolean.TRUE;
                if (depositoSelected.equals(rf.fromMessage("selectonemenu.depositotableroValue"))) {
                    backlog = Boolean.FALSE;
                }
                filter = and(filter,
                        eq("backlog", backlog));
            } else {
                filter = and(filter,
                        eq("backlog", Boolean.FALSE));
            }

            Document sort = new Document("idtarjeta", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(sort))
                            .title(filterText)
                            .name("findByTarjetas")
                            .build();

            /**
             * Limpiar los elementos
             */
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Boolean showBacklog(Proyecto proyecto)">
    public Boolean showBacklog(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;

        try {
            if (validDateProject(proyecto)) {
               
                if (profileLogged.getRole().getIdrole().equals(7)) {
                    if (proyecto.getShowTodasReserva()) {
                        result = Boolean.TRUE;
                    }
                } else {
                    result = Boolean.TRUE;
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
     
        return result;
    }

// </editor-fold>  
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean isProjectDetenido(Proyecto proyecto)">
    public Boolean isProjectDetenido(Proyecto proyecto){
        Boolean result = Boolean.FALSE;
        try {
           
            if(proyecto.getEstado().equals(rf.fromMessage("selectonemenu.detenidovalue"))){
                result = Boolean.TRUE;
            }
           
        } catch (Exception e) {
               FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
}
