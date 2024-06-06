/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

// <editor-fold defaultstate="collapsed" desc="imports">
import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbCronometer;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.ReportUtils;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.avbravo.jmoordbutils.websocket.MessageWebSocket;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.commons.emails.EmailSender;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.converter.services.IconoConverterServices;
import com.sft.converter.services.TipoTarjetaConverterServices;
import com.sft.faces.services.FacesServices;

import com.sft.model.ActionHistory;
import com.sft.model.DepartamentView;
import com.sft.model.EstadisticaCierre;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.services.ProyectoServices;
import com.sft.services.ProyectoViewServices;
import com.sft.services.SprintServices;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.ResponsiveOption;
import org.primefaces.model.SortMeta;
import com.sft.services.ColorManagement;
import com.sft.services.TarjetaServices;
import com.sft.faces.services.SprintFacesServices;
import com.sft.model.ProyectoMiembro;
import com.sft.model.UserView;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.services.IconoServices;
import com.sft.services.ProyectoEstadisticaServices;
import com.sft.websocket.fire.FacesWebSocket;
import com.sft.websocket.fire.WebSocketController;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Event;
import jakarta.faces.context.FacesContext;
import org.primefaces.event.CloseEvent;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class MisProyectoFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices, FacesWebSocket, FacesServices {
// <editor-fold defaultstate="collapsed" desc="ConverterServices">

    @Inject
    TipoTarjetaConverterServices tipoTarjetaConverterServices;

    @Inject
    IconoConverterServices iconoConverterServices;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="WebSocket">
    @Inject
    WebSocketController webSocketController;
    private Boolean dialogVisibleWebSocket = Boolean.FALSE;
    private Boolean dialogVisibleAddWebSocket = Boolean.FALSE;
    private List<UserView> userViewForWebSocketList = new ArrayList<>();
    private Integer contadorNotificacionesWebsocket = 0;
    private Long jmoordbCronometerOld = 0L;

    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private String message = "";
    private String tituloDialogo = "";
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;
    private Boolean ishaveOpenSprint = Boolean.FALSE;
    private Boolean buttonNewPressed = Boolean.TRUE;
    private Boolean showDialogContent = Boolean.TRUE;
    private Boolean haveOpenSprintTemporal = Boolean.FALSE;

    private Profile profileLogged = new Profile();

    private EstadisticaCierre estadisticaCierre = new EstadisticaCierre();
    private Sprint sprintSelected = new Sprint();
    private Sprint sprintDB = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();
    private Proyecto proyectoClonarSelected = new Proyecto();
    private Proyecto proyectoDB = new Proyecto();
    private Proyecto proyectoReabrir = new Proyecto();
    private List<ResponsiveOption> responsiveOptions;

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<Sprint> sprintList = new ArrayList<>();
    private List<Tarjeta> tarjetaList = new ArrayList<>();
    private List<Sprint> sprintDataTableList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;
    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;

    Integer totalRecords = 0;

    private List<Tarjeta> tarjetaSprintList = new ArrayList<>();

    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    private ProyectoEstadistica proyectoEstadisticaResumen = new ProyectoEstadistica();

    List<Tarjeta> tarjetaPendienteBacklogList = new ArrayList<>();
    List<Tarjeta> tarjetaProgresoBacklogList = new ArrayList<>();
    List<Tarjeta> tarjetaFinalizadoBacklogList = new ArrayList<>();
    private List<ProyectoMiembro> proyectoMiembroOldList = new ArrayList<>();
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Event">
    @Inject
    Event<EmailSenderEvent> emailSenderEvent;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Proyecto> proyectoLazyDataModel;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="paginator ">
    Paginator paginator = new Paginator();
    Paginator paginatorOld = new Paginator();

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
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
    ProyectoServices proyectoServices;
    @Inject
    IconoServices iconoServices;
    @Inject
    ProyectoViewServices proyectoViewServices;
    @Inject
    SprintServices sprintServices;

    @Inject
    TarjetaServices tarjetaServices;
    @Inject
    ProyectoEstadisticaServices proyectoEstadisticaServices;
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

    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeStoreInCollections", defaultValue = "false")
    private Provider<Boolean> pathBaseLinuxAddUserHomeStoreInCollections;
    
    // #Websocket    
    @Inject
    @ConfigProperty(name = "websocket.minimums.seconds.for.update")
    private Provider<Integer> websocketMinimumsSecondsForUpdate;
    // </editor-fold>
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

            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");

            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            loadIcono();
            findAll();

            this.proyectoLazyDataModel = new LazyDataModel<Proyecto>() {
                @Override
                public List<Proyecto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    switch (paginator.getName()) {
                        case "findAll":

                            totalRecords = proyectoServices.count(paginator.getFilter(),
                                    paginator.getSort(), 0, 0).intValue();
                            break;

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

                    List<Proyecto> result = new ArrayList<>();
                    switch ((paginator.getName())) {
                        case "findAll":

                            result = proyectoServices.lookup(paginator.getFilter(),
                                    paginator.getSort(), paginator.getPage(), rowPageSmall.get());

                            break;
                        default:

                    }

                    proyectoLazyDataModel.setRowCount(totalRecords);

                    PrimeFaces.current().executeScript("setDataTableWithPageStart()");
                    PrimeFaces.current().executeScript("widgetVardataTable.getPaginator().setPage(0);");
                    proyectoList = result;

                    return result;
                }

                @Override
                public int count(Map<String, FilterMeta> map) {

                    return totalRecords;

                }

                @Override
                public String getRowKey(Proyecto object) {
                    if (object == null || object.getIdproyecto() == null) {
                        return "";
                    }
                    return object.getIdproyecto().toString();
                }

                @Override
                public Proyecto getRowData(String rowKey) {
                    for (Proyecto t : proyectoList) {
                        if (t != null) {
                            if (t.getIdproyecto().equals(rowKey)) {
                                return t;
                            }
                        }
                    }
                    return null;
                }

            };

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void preDestroy()">
    @PreDestroy
    @Override
    public void preDestroy() {
        tipoTarjetaConverterServices.destroyed();
        iconoConverterServices.destroyed();

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findByIdProyecto()">
    public String findAll() {
        try {

            Bson filter = eq("active", Boolean.TRUE);
            /**
             * Filtra por roles
             */
//            if(profileLogged.getRole().getRole().equals("COLABORADOR") || profileLogged.getRole().getRole().equals("JEFE-UNIDAD")){
            filter = and(filter, eq("proyectoMiembro.user.iduser", userLogged.getIduser()));
//            }

            Document sort = new Document("idproyecto", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idproyecto", -1)))
                            .title("Todos")
                            .name("findAll")
                            .build();

            /**
             * Limpiar los elementos
             */
            setFirstPageDataTable();

        } catch (Exception e) {
            //  FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
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
    // <editor-fold defaultstate="collapsed" desc="setFirstPageDataTable()">
    public void setFirstPageDataTable() {

        if (dataTable != null) {
            dataTable.setFirst(0);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String go(Sprint sprint)">
    public String go(Sprint sprint) {
        try {
            sprintSelected = sprint;

            JmoordbCoreContext.put("SprintFaces.sprintSelected", sprintSelected);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tablero.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSprint()">
    /**
     * Muesta el commandButton save solo si no hay Sprint abiertos.
     *
     * @return
     */
    public Boolean haveOpenSprint() {
        Boolean result = Boolean.FALSE;
        try {
            if (sprintServices.haveOpenSprint(proyectoSelected)) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="saveSprint(Sprint sprint)">
    public void saveSprint(Sprint sprint) {
        try {

            sprintSelected = sprint;
            sprintSelected.setSprint(sprintSelected.getSprint().trim());
            ishaveOpenSprint = haveOpenSprint();
            if (ishaveOpenSprint) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.tienesprintabiertosnosepuedencrearnuevoshastacerrarlos"));
                return;
            }

            if (DateUtil.fechaMayor(sprintSelected.getFechainicial(), sprintSelected.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechainicialmayorfechafinal"));
                return;
            }
            if (!DateUtil.dateBetweenExcludeTime(sprintSelected.getFechainicial(), proyectoSelected.getFechainicial(), proyectoSelected.getFechafinal())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechainicialnoestarangofechasproyecto"));
                return;
            }

            if (!DateUtil.dateBetweenExcludeTime(sprintSelected.getFechafinal(), proyectoSelected.getFechainicial(), proyectoSelected.getFechafinal())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechafinalnoestarangofechasproyecto"));
                return;
            }

            if (sprintServices.existsBySprintAndProject(proyectoSelected, sprintSelected)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.exitsotherdocumentwiththisname"));
                return;

            }
            /**
             *
             */
            if (sprintServices.exitsBetweenDates(proyectoSelected, sprintSelected.getFechainicial(), sprintSelected.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.existesprintenesasfechas"));
                return;

            }

            sprintSelected.setSprint(sprintSelected.getSprint().trim());

            sprintSelected.setEstadisticaCierre(new EstadisticaCierre());
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("crear")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            sprintSelected.setActionHistory(actionHistoryList);

            Optional<Sprint> sprintOptional = sprintServices.save(sprintSelected);
            if (!sprintOptional.isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.save"));
            } else {
                sprintSelected = sprintOptional.get();
                JmoordbCoreContext.put("SprintFaces.sprintSelected", sprintSelected);
                //  FacesUtil.infoDialog(rf.fromCore("info.save"), rf.fromCore("info.save"));
                FacesUtil.successMessage(rf.fromCore("info.save"));

                sacarTarjetasDelBacklog();

                /**
                 * Actualiza las tarjetas
                 */
                PrimeFaces.current().ajax().update("dataTable");

                closeOverlayPanel("PF('overlayPanelSprint').hide()");
                refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="editSprint(Sprint sprint)">

    public void editSprint(Sprint sprint) {
        try {
            Sprint sprintDBNow = sprintServices.findByIdsprint(sprint.getIdsprint()).get();
            if (!sprintDBNow.equals(sprintDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }
            sprintSelected = sprint;
            sprintSelected.setSprint(sprintSelected.getSprint().trim());
            ishaveOpenSprint = haveOpenSprint();

            if (DateUtil.fechaMayor(sprintSelected.getFechainicial(), sprintSelected.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechainicialmayorfechafinal"));
                return;
            }
            if (!DateUtil.dateBetweenExcludeTime(sprintSelected.getFechainicial(), proyectoSelected.getFechainicial(), proyectoSelected.getFechafinal())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechainicialnoestarangofechasproyecto"));
                return;
            }

            if (!DateUtil.dateBetweenExcludeTime(sprintSelected.getFechafinal(), proyectoSelected.getFechainicial(), proyectoSelected.getFechafinal())) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechafinalnoestarangofechasproyecto"));
                return;
            }

            /**
             *
             */
            if (sprintServices.exitsBetweenDatesExcludeSprint(proyectoSelected, sprintSelected.getFechainicial(), sprintSelected.getFechafinal(), sprintSelected)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.existesprintenesasfechas"));
                return;

            }

            sprintSelected.setEstadisticaCierre(new EstadisticaCierre());
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
             actionHistoryList.addAll(sprint.getActionHistory());
            actionHistoryList.add(actionHistory);

            sprintSelected.setActionHistory(actionHistoryList);

            Boolean isUpdate = sprintServices.update(sprintSelected);
            if (!isUpdate) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.update"));
            } else {

                JmoordbCoreContext.put("SprintFaces.sprintSelected", sprintSelected);
//                FacesUtil.infoDialog(rf.fromCore("info.update"), rf.fromCore("info.update"));
                FacesUtil.successMessage(rf.fromCore("info.update"));

                /**
                 * Actualiza las tarjetas
                 */
                //  sprintList.add(sprintSelected);
                //  PrimeFaces.current().ajax().update("dataTable");
                closeOverlayPanel("PF('overlayPanelSprint').hide()");
                refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadTarjetaPendienteProgreso()">
    private Boolean sacarTarjetasDelBacklog() {
        Boolean result = Boolean.FALSE;
        tarjetaPendienteList = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1).append("prioridad", 1);
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"));

            tarjetaPendienteList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"));

            tarjetaProgresoList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            actualizarTarjeta(tarjetaPendienteList, Boolean.FALSE);
            actualizarTarjeta(tarjetaProgresoList, Boolean.FALSE);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void actualizarTarjeta(List<Tarjeta> list,, Boolean isBacklog">

    public void actualizarTarjeta(List<Tarjeta> list, Boolean isBacklog) {
        try {
            if (list == null || list.isEmpty()) {

            } else {
                for (Tarjeta t : list) {
                    t.setBacklog(isBacklog);
                    t.setIdsprint(sprintSelected.getIdsprint());

                    ActionHistory actionHistory = new ActionHistory.Builder()
                            .iduser(userLogged.getIduser())
                            .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                            .evento("editar")
                            .clase(FacesUtil.nameOfClass())
                            .metodo(FacesUtil.nameOfMethod())
                            .build();

                    t.getActionHistory().add(actionHistory);

                    tarjetaServices.update(t);
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
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

    // <editor-fold defaultstate="collapsed" desc="void closeSprint(Sprint sprint)">
    public void closeSprint(Sprint sprint) {
        try {
            sprintSelected = new Sprint();
            Sprint sprintDBNow = sprintServices.findByIdsprint(sprint.getIdsprint()).get();

            if (sprintDBNow == null || !sprintDBNow.getActive() || !sprintDBNow.getOpen()) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero"));
                return;
            }
            sprintSelected = sprint;

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("cerrar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            sprintSelected.getActionHistory().add(actionHistory);
            sprintSelected.setOpen(Boolean.FALSE);
            estadisticaCierre = new EstadisticaCierre("", 0, 0, 0, 0.0, JmoordbCoreDateUtil.fechaHoraActual());
            calcularTarjetasDelSprint();
            estadisticaCierre.setPendiente(tarjetaPendienteBacklogList.size());
            estadisticaCierre.setProgreso(tarjetaProgresoBacklogList.size());
            estadisticaCierre.setFinalizado(tarjetaFinalizadoBacklogList.size());

            Integer total = estadisticaCierre.getPendiente() + estadisticaCierre.getProgreso() + estadisticaCierre.getFinalizado();
            Double avance = 0.0;
            if (total == 0) {
                avance = 0.0;
            } else {
                avance = (Double) (estadisticaCierre.getFinalizado() * 100.00) / total;
            }

            estadisticaCierre.setAvance(avance);
            sprintSelected.setEstadisticaCierre(estadisticaCierre);
            if (!sprintServices.update(sprintSelected)) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.save"));
            } else {

                pasarTarjetasAlBacklog();

                JmoordbCoreContext.put("SprintFaces.sprintSelected", sprintSelected);
                FacesUtil.infoDialog(rf.fromCore("info.save"), rf.fromCore("info.sprincerrado"));

            }
            refresh();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean calcularTarjetasDelSprint()">
    private Boolean calcularTarjetasDelSprint() {
        Boolean result = Boolean.FALSE;
        tarjetaPendienteBacklogList = new ArrayList<>();
        tarjetaProgresoBacklogList = new ArrayList<>();
        tarjetaFinalizadoBacklogList = new ArrayList<>();
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1).append("prioridad", 1);
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"));

            tarjetaPendienteBacklogList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"));

            tarjetaProgresoBacklogList = tarjetaServices.lookup(filterProgreso, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterFinalizado = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"));

            tarjetaFinalizadoBacklogList = tarjetaServices.lookup(filterFinalizado, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            result = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean pasarTarjetasAlBacklog()">

    private Boolean pasarTarjetasAlBacklog() {
        Boolean result = Boolean.FALSE;

        try {

            actualizarTarjeta(tarjetaPendienteBacklogList, Boolean.TRUE);
            actualizarTarjeta(tarjetaProgresoBacklogList, Boolean.TRUE);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String refresh()">
    @Override
    public String refresh() {
        try {
            contadorNotificacionesWebsocket=0;
dialogVisibleWebSocket= Boolean.FALSE;
            sprintList = new ArrayList<>();
            findAll();
            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadOpenSprint()">
    private Boolean loadOpenSprint() {
        Boolean result = Boolean.FALSE;
        try {

            /**
             * Cargo los Sprint
             */
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyectoSelected.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

            sprintList = sprintServices.lookup(
                    filter,
                    sort,
                    page, size);
            if (!sprintList.isEmpty()) {

                if (sprintList.size() > 1) {
                    FacesUtil.warningDialog(rf.fromMessage("waring.sprintopenmayoruno"));

                    message = rf.fromMessage("waring.sprintopenmayoruno");
                } else {

                    result = Boolean.TRUE;
                }
            }
            // else {
//                FacesUtil.warningDialog(rf.fromMessage("warning.nohaysprintopen"));
//                message = rf.fromMessage("warning.nohaysprintopen");
//            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareSprint(Proyecto proyecto)">
    public String prepareSprint(Proyecto proyecto) {
        try {
            sprintDataTableList = new ArrayList<>();
            Integer page = 0;
            Integer size = 0;
            Bson filter0 = eq("proyecto.idproyecto", proyecto.getIdproyecto());
            Bson filterFinalizado = and(filter0,
                    eq("active", Boolean.TRUE)
            );
            Document sortTarjeta = new Document("idsprint", -1);

            sprintDataTableList = sprintServices.lookup(filterFinalizado, sortTarjeta, page, size);
            tituloDialogo = rf.fromMessage("dialog.sprint");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean countTarjetaSprint(Proyecto proyecto)">

    public Boolean countTarjetaSprint(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {
            Sprint sprint = new Sprint();
            Integer page = 0;
            Integer size = 0;
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filterFinalizado = and(filter0,
                    eq("idsprint", sprint.getIdsprint()),
                    eq("idsprint", sprint.getIdsprint()),
                    eq("active", Boolean.TRUE)
            );
            Document sortTarjeta = new Document("idtarjeta", 1).append("prioridad", 1);

            Long count = tarjetaServices.count(filterFinalizado, sortTarjeta, page, size, proyectoSelected.getIdproyecto());
            if (count > 0) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Sprint validarSiCambioSprint(Sprint sprint)">
    private Sprint validarSiCambioSprint(Sprint sprint) {
        Sprint result = new Sprint();
        try {
            message = "";
            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            this.sprintDB = sprintServices.findByIdsprint(sprint.getIdsprint()).get();
            if (sprintDB.equals(sprint)) {
                result = sprint;
            } else {
                fueCambiadoPorOtroUsuario = Boolean.TRUE;
                message = rf.fromMessage("warning.otrousuarioactualizosprintincronizeeltablero");
                result = sprintDB;
                showDialogContent = Boolean.FALSE;

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String printAll()">
    public String printAll() {

        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlesproyectos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();
            /**
             *
             */
            String date = showDate(currentDate) + " " + showHour(currentDate);

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.fecha") + " " + date, FontFactory.getFont("arial", 8, Font.BOLD), Element.ALIGN_RIGHT));
            document.add(new Paragraph("\n"));

            // Numero de columnas
            PdfPTable table = new PdfPTable(8);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{60, 125, 70, 45, 48, 125, 55, 55});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.idproyecto"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.proyecto"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.prefijo"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
//            table.addCell(
//                    ReportUtils.PdfCell(
//                            rf.fromMessage("print.active"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.privado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.estado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.deparamento"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

//            
            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            //Carga los registros por paginacion
            for (int i = 1; i <= totalPage; i++) {

                pageActual = i;

                List<Proyecto> list = proyectoServices.lookup(paginator.getFilter(),
                        paginator.getSort(), pageActual, rowPageSmall.get());

                if (list == null || list.isEmpty()) {

                } else {
                    list.forEach(c -> {

                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getIdproyecto().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getProyecto(), FontFactory.getFont("arial", 9, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(c.getPrefijo(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        String privado = rf.fromMessage("privado.yes");
                        if (!c.getPrivado()) {
                            privado = rf.fromMessage("privado.no");
                        }
                        table.addCell(
                                ReportUtils.PdfCell(privado, FontFactory.getFont("arial", 10, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(c.getEstado(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        String departamento = "";
                        Boolean first = Boolean.TRUE;
                        for (DepartamentView dp : c.getDepartamentView()) {
                            if (first) {
                                departamento += dp.getDepartament();
                                first = Boolean.FALSE;
                            } else {
                                departamento += "/ " + dp.getDepartament();
                            }

                        }
                        table.addCell(
                                ReportUtils.PdfCell(departamento, FontFactory.getFont("arial", 10, Font.NORMAL)));

//                        table.addCell(
//                                ReportUtils.PdfCell(c.getActive() ? "si" : "no", FontFactory.getFont("arial", 10, Font.NORMAL)));
//                        
                        table.addCell(
                                ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechainicial()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    });
                }
            }

            //Reestablece la pagina actual
            //paginator.setPage(pageActual);
            document.add(table);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        document.close();

        ReportUtils.printPDF(baos);
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String printByProyecto(Proyecto proyecto)">
    public String printByProyecto(Proyecto proyecto) {

        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlesproyectos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();
            /**
             *
             */
            String date = showDate(currentDate) + " " + showHour(currentDate);

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.fecha") + " " + date, FontFactory.getFont("arial", 8, Font.BOLD), Element.ALIGN_RIGHT));
            document.add(new Paragraph("\n"));

            // Numero de columnas
            PdfPTable table = new PdfPTable(8);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{60, 125, 70, 45, 48, 125, 55, 55});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.idproyecto"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.proyecto"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.prefijo"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
//            table.addCell(
//                    ReportUtils.PdfCell(
//                            rf.fromMessage("print.active"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.privado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.estado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.deparamento"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

//            
            table.addCell(
                    ReportUtils.PdfCell(
                            proyecto.getIdproyecto().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
            table.addCell(
                    ReportUtils.PdfCell(
                            proyecto.getProyecto(), FontFactory.getFont("arial", 9, Font.NORMAL)));

            table.addCell(
                    ReportUtils.PdfCell(proyecto.getPrefijo(), FontFactory.getFont("arial", 10, Font.NORMAL)));

            String privado = rf.fromMessage("privado.yes");
            if (!proyecto.getPrivado()) {
                privado = rf.fromMessage("privado.no");
            }
            table.addCell(
                    ReportUtils.PdfCell(privado, FontFactory.getFont("arial", 10, Font.NORMAL)));

            table.addCell(
                    ReportUtils.PdfCell(proyecto.getEstado(), FontFactory.getFont("arial", 10, Font.NORMAL)));

            String departamento = "";
            Boolean first = Boolean.TRUE;
            for (DepartamentView dp : proyecto.getDepartamentView()) {
                if (first) {
                    departamento += dp.getDepartament();
                    first = Boolean.FALSE;
                } else {
                    departamento += "/ " + dp.getDepartament();
                }

            }
            table.addCell(
                    ReportUtils.PdfCell(departamento, FontFactory.getFont("arial", 10, Font.NORMAL)));

            table.addCell(
                    ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(proyecto.getFechainicial()), FontFactory.getFont("arial", 10, Font.NORMAL)));

            table.addCell(
                    ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(proyecto.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));

            document.add(table);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        document.close();

        ReportUtils.printPDF(baos);
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareResumen(Proyecto proyecto)">
    public String prepareResumen(Proyecto proyecto) {
        try {

            proyectoEstadisticaResumen = proyectoEstadisticaServices.calcularEstadistica(proyecto);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareProyectoReabrir(Proyecto proyecto)">

    public String prepareProyectoReabrir(Proyecto proyecto) {
        try {
            dialogVisibleWebSocket= Boolean.TRUE;
            JmoordbCoreUtil.copyBeans(proyectoReabrir, proyecto);
            proyectoMiembroOldList = proyectoReabrir.getProyectoMiembro();
             validarSiCambioEnPrepare(proyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String reabrirProyecto()">

    public String reabrirProyecto() {
        try {

            Proyecto proyectoDBNow = proyectoServices.findByIdproyecto(proyectoReabrir.getIdproyecto()).get();
            if (!proyectoDBNow.equals(proyectoDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.update"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return "";
            }

            /**
             * Cuando se pasa a finalizado verificar que no tenga tareas
             * pendientes
             */
            proyectoReabrir.setEstado(rf.fromMessage("selectonemenu.iniciadovalue"));

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("reabrir proyecto")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();

            proyectoReabrir.getActionHistory().add(actionHistory);

            if (!proyectoServices.update(proyectoReabrir)) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));

            } else {
                isOverlayPanelOpen = Boolean.FALSE;
                isButtonSavePressed = Boolean.FALSE;
                FacesUtil.successMessage(rf.fromMessage("info.updateproyecto"));
                sendEmailEditProject(proyectoReabrir);
                /**
                 * WebSocket
                 */
                userViewForWebSocketList = userViewFromProjectExclude(proyectoReabrir, Boolean.FALSE, userLogged);
                MessageWebSocket messageWebSocket = new MessageWebSocket.Builder()
                        .producer(FacesUtil.nameOfClass())
                        .action(FacesUtil.nameOfMethod())
                        .key("proyecto")
                        .value(proyectoReabrir.getIdproyecto() != null ? proyectoReabrir.getIdproyecto().toString() : "")
                        .message("Reabrir proyecto")
                        .iduser(userLogged.getIduser())
                        .date(JmoordbCoreDateUtil.fechaHoraActual())
                        .build();
                sendMensajesWebsocket(messageWebSocket, Boolean.TRUE);

                closeOverlayPanel("PF('overlayPanelProyectoReabrir').hide()");
                refresh();
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String cerrarDialogo()">
    public String cerrarDialogo() {
        try {

            closeOverlayPanel("PF('overlayPanelProyectoReabrir').hide()");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String esPropietarioProyecto(Proyecto proyecto)">
    public Boolean esPropietarioProyecto(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {
            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(userLogged.getIduser()) && pm.getPropietario()) {
                    result = Boolean.TRUE;
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSprint(Proyecto proyecto)">
    public Boolean haveOpenSprint(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {

            result = sprintServices.haveOpenSprint(proyecto);
            haveOpenSprintTemporal = result;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSprintAndDateIsLessOrEquals(Proyecto proyecto)">
    public Boolean haveOpenSprintAndDateIsLessOrEquals(Proyecto proyecto) {
        var result = Boolean.FALSE;
        try {

            result = sprintServices.haveOpenSprintAndDateIsLessOrEquals(proyecto);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String goTablero(Proyecto proyecto,String path, Boolean isProyectoForaneo, Boolean isEditable)">
    public String goTablero(Proyecto proyecto, Boolean isProyectoForaneo, Boolean isEditable) {
        try {
            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyecto, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyecto, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tablero.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String goTarjetas(Proyecto proyecto)">
    public String goTarjetas(Proyecto proyecto) {
        try {
            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);

            JmoordbCoreContext.put("DashboardFaces.isEditable", false);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyecto()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tarjetas.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String goTarjetasForaneas(Proyecto proyecto)">
    public String goTarjetasForaneas(Proyecto proyecto) {
        try {
            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);

            JmoordbCoreContext.put("DashboardFaces.isEditable", false);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyecto()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tarjetasforaneas.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String goTarjetasImpedimentos(Proyecto proyecto)">

    public String goTarjetasImpedimentos(Proyecto proyecto) {
        try {
            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);

            JmoordbCoreContext.put("DashboardFaces.isEditable", false);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyecto()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tarjetasimpedimentos.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String goSprint(Sprint sprint, String path, Boolean isProyectoForaneo, Boolean isEditable)">
    /**
     *
     * @param proyecto
     * @param path
     * @param isProyectoForaneo
     * @param editable
     * @return
     */
    public String goSprint(Proyecto proyecto, String path, Boolean isProyectoForaneo, Boolean isEditable) {
        try {
            proyectoSelected = proyecto;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareClonar(Proyecto proyecto)">
    public String prepareClonar(Proyecto proyecto) {
        try {

            validarSiCambioEnPrepare(proyecto);
            JmoordbCoreUtil.copyBeans(this.proyectoClonarSelected, proyecto);

            Integer index = proyectoClonarSelected.getPrefijo().indexOf("-");

            if (index < 0) {

            } else {
                String prefijoNew = proyectoClonarSelected.getPrefijo().substring(0, index + 1);
                proyectoClonarSelected.setPrefijo(prefijoNew);
            }
            genererNumeroPrefijoClonar();
            proyectoClonarSelected.setEstado("iniciado");

            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
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

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void genererNumeroPrefijoClonar(">
    public void genererNumeroPrefijoClonar() {
        try {

            if (proyectoClonarSelected.getPrefijo() == null || proyectoClonarSelected.getPrefijo().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresenumeroprefijo"));
                return;
            } else {
                proyectoClonarSelected.setPrefijo(proyectoServices.genererNumeroPrefijo(proyectoClonarSelected, rf));

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
                FacesUtil.successMessage(rf.fromMessage("info.cloneproyecto"));
                closeOverlayPanel("PF('overlayPanelProyectoClonar').hide()");
                refresh();
            }
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
            JmoordbCoreContext.put("DashboardFaces.callerLevel0", "proyecto");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "proyecto");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
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

    // <editor-fold defaultstate="collapsed" desc="void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Boolean exclude)">

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

    @Override
    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold> 

}
