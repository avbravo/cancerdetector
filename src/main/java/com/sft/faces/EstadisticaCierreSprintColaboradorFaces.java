/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.ReportUtils;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.faces.services.FacesServices;

import com.sft.model.ActionHistory;
import com.sft.model.EstadisticaCierre;
import com.sft.model.EstadisticaCierreColaborador;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
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
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import jakarta.annotation.PreDestroy;
import org.primefaces.event.CloseEvent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class EstadisticaCierreSprintColaboradorFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices , FacesServices{
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

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private Profile profileLogged = new Profile();

    private EstadisticaCierre estadisticaCierre = new EstadisticaCierre();
    private Sprint sprintSelected = new Sprint();
    private Sprint sprintDB = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();

    private List<ResponsiveOption> responsiveOptions;

    private List<Sprint> sprintList = new ArrayList<>();
    private List<Tarjeta> tarjetaList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;
    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;
    Integer totalRecords = 0;

    private List<Sprint> sprintDataTableList = new ArrayList<>();

    private List<Tarjeta> tarjetaSprintList = new ArrayList<>();

    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    List<Tarjeta> tarjetaPendienteBacklogList = new ArrayList<>();
    List<Tarjeta> tarjetaProgresoBacklogList = new ArrayList<>();
    List<Tarjeta> tarjetaFinalizadoBacklogList = new ArrayList<>();

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
     
     

  
     
     
     
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Sprint> sprintLazyDataModel;
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
    ProyectoViewServices proyectoViewServices;
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
            if (JmoordbCoreContext.get("DashboardFaces.proyectoSelected") == null) {

            } else {
                proyectoSelected = (Proyecto) JmoordbCoreContext.get("DashboardFaces.proyectoSelected");
            }
            if (JmoordbCoreContext.get("DashboardFaces.callerLevel0") != null) {
                callerLevel0 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel0");

            }

            if (JmoordbCoreContext.get("DashboardFaces.isEditable") != null) {
                isEditable = (Boolean) JmoordbCoreContext.get("DashboardFaces.isEditable");

            }
            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            findByIdProyecto();
            sprintDataTableList = sprintServices.lookup(paginator.getFilter(),
                    paginator.getSort(), paginator.getPage(), rowPageSmall.get());
            
            sprintDataTableList = sprintServices.lookup(paginator.getFilter(),
                    paginator.getSort(), 0, 0);
//
            this.sprintLazyDataModel = new LazyDataModel<Sprint>() {
                @Override
                public List<Sprint> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    switch (paginator.getName()) {
                        case "findByIdProyecto":

                            totalRecords = sprintServices.count(paginator.getFilter(),
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

                    List<Sprint> result = new ArrayList<>();
                    switch ((paginator.getName())) {
                        case "findByIdProyecto":

                            result = sprintServices.lookup(paginator.getFilter(),
                                    paginator.getSort(), paginator.getPage(), rowPageSmall.get());

                            break;
                        default:

                    }

                    sprintLazyDataModel.setRowCount(totalRecords);

                    PrimeFaces.current().executeScript("setDataTableWithPageStart()");
                    PrimeFaces.current().executeScript("widgetVardataTable.getPaginator().setPage(0);");
                    sprintList = result;

                    return result;
                }

                @Override
                public int count(Map<String, FilterMeta> map) {

                    return totalRecords;

                }
 @Override
                public String getRowKey(Sprint object) {
                    if (object == null || object.getIdsprint() == null) {
                        return "";
                    }
                    return object.getIdsprint().toString();
                }

                @Override
                public Sprint getRowData(String rowKey) {
                    for (Sprint t : sprintList) {
                        if (t != null) {
                            if (t.getIdsprint().equals(rowKey)) {
                                return t;
                            }
                        }
                    }
                    return null;
                }
//
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
        
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findByIdProyecto()">
    public String findByIdProyecto() {
        try {

            Bson filter = and(eq("proyecto.idproyecto", proyectoSelected.getIdproyecto()),
                    eq("open", Boolean.FALSE),
                    eq("active", Boolean.TRUE)
            );
            Document sort = new Document("idsprint", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idsprint", -1)))
                            .title("Todos")
                            .name("findByIdProyecto")
                            .build();

            /**
             * Limpiar los elementos
             */
            setFirstPageDataTable();
        } catch (Exception e) {
            // FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
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

 if(dataTable!= null){
    dataTable.setFirst(0);
}
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String go(Sprint sprint)">
    public String go2(Sprint sprint) {
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
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
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
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));
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
                    eq("columna", "pendiente"),
                    ne("idsprint", 0));

            tarjetaPendienteList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"),
                    ne("idsprint", 0));

            tarjetaProgresoList = tarjetaServices.lookup(filterProgreso, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

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
                    t.setFechafinal(sprintSelected.getFechafinal());

                    if (tarjetaServices.update(t)) {

                    } else {

                    }
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

    // <editor-fold defaultstate="collapsed" desc="void agregarRowSprint()">
    public void agregarRowSprint() {
        try {
            buttonNewPressed = Boolean.TRUE;
            showDialogContent = Boolean.FALSE;
            ishaveOpenSprint = haveOpenSprint();
            if (ishaveOpenSprint) {
                message = rf.fromCore("warning.tienesprintabiertosnosepuedencrearnuevoshastacerrarlos");

            } else {
                showDialogContent = Boolean.TRUE;
            }

            sprintSelected = new Sprint();
            sprintSelected.setSprint("sp-" + sprintServices.generateNumberForSprint(proyectoSelected));
            sprintSelected.setDescripcion("");

            if (sprintList == null || sprintList.isEmpty()) {
                sprintSelected.setFechainicial(JmoordbCoreDateUtil.fechaHoraActual());
                sprintSelected.setFechafinal(JmoordbCoreDateUtil.sumarDiaaFecha(JmoordbCoreDateUtil.fechaHoraActual(), 6));
            } else {
                sprintSelected.setFechainicial(JmoordbCoreDateUtil.sumarDiaaFecha(sprintList.get(0).getFechafinal(), 3));
                sprintSelected.setFechafinal(JmoordbCoreDateUtil.sumarDiaaFecha(sprintList.get(0).getFechafinal(), 9));
            }

            sprintSelected.setEstadisticaCierre(new EstadisticaCierre());
            List<EstadisticaCierreColaborador> estadisticaCierreColaboradors = new ArrayList<>();
            sprintSelected.setEstadisticaCierreColaborador(estadisticaCierreColaboradors);
            sprintSelected.setActive(Boolean.TRUE);
            sprintSelected.setOpen(Boolean.TRUE);
            sprintSelected.setProyectoView(proyectoViewServices.convertFromProyecto(proyectoSelected));

            isButtonSavePressed = Boolean.FALSE;

            tituloDialogo = rf.fromMessage("dialog.sprintagregar");
            PrimeFaces.current().ajax().update("outputPanelSprint");

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
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizotarjetasincronizeeltablero"));
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

            calcularTarjetasDelSprint(sprintSelected);
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

            estadisticaCierre.setAvance(FacesUtil.redondear(avance, 2));
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
    private Boolean calcularTarjetasDelSprint(Sprint sprint) {

        Boolean result = Boolean.FALSE;
        tarjetaPendienteBacklogList = new ArrayList<>();
        tarjetaProgresoBacklogList = new ArrayList<>();
        tarjetaFinalizadoBacklogList = new ArrayList<>();
        try {
            sprintSelected = sprint;
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1).append("prioridad", 1);
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());

            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"),
                    eq("idsprint", sprintSelected.getIdsprint()));

            tarjetaPendienteBacklogList = tarjetaServices.lookup(filter, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"),
                    eq("idsprint", sprintSelected.getIdsprint()));

            tarjetaProgresoBacklogList = tarjetaServices.lookup(filterProgreso, sortTarjeta, page, size,proyectoSelected.getIdproyecto());

            Bson filterFinalizado = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"),
                    eq("idsprint", sprintSelected.getIdsprint()));

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

            sprintList = new ArrayList<>();
            findByIdProyecto();
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

    // <editor-fold defaultstate="collapsed" desc="String prepareSprint(Sprint sprint)">
    public String prepareSprint(Sprint sprint) {
        try {
            sprintSelected = new Sprint();
            showDialogContent = Boolean.TRUE;
            sprintSelected = validarSiCambioSprint(sprint);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
            buttonNewPressed = Boolean.FALSE;
            tituloDialogo = rf.fromMessage("dialog.sprinteditar");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String prepareTarjetaSprint(Sprint sprint)">

    public String prepareTarjetaSprint(Sprint sprint) {
        try {

            Integer page = 0;
            Integer size = 0;
            Bson filter0 = eq("idproyecto", proyectoSelected.getIdproyecto());
            Bson filterFinalizado = and(filter0,
                    eq("idsprint", sprint.getIdsprint()),
                    eq("backlog", Boolean.FALSE),
                    eq("idsprint", sprint.getIdsprint()),
                    eq("active", Boolean.TRUE)
            );
            Document sortTarjeta = new Document("idtarjeta", 1).append("prioridad", 1);

            tarjetaSprintList = tarjetaServices.lookup(filterFinalizado, sortTarjeta, page, size,proyectoSelected.getIdproyecto());
            tituloDialogo = rf.fromMessage("dialog.tarjeta");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean countTarjetaSprint(Sprint sprint)">

    public Boolean countTarjetaSprint(Sprint sprint) {
        Boolean result = Boolean.FALSE;
        try {

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

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4);
//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titleestadisticacierresprintcolaboradorporproyecto"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.proyecto") + " : " + proyectoSelected.getProyecto(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.prefijo") + " : " + proyectoSelected.getPrefijo(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            /**
             * Si se desea imprimir el filtro
             */
//            String textoFiltro = paginator.getTitle();
//            document.add(
//                    ReportUtils.paragraph(
//                            textoFiltro, FontFactory.getFont("arial", 10, Font.BOLD), Element.ALIGN_CENTER));
            /**
             *
             */
            String date = showDate(currentDate) + " " + showHour(currentDate);

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.fecha") + " " + date, FontFactory.getFont("arial", 8, Font.BOLD), Element.ALIGN_RIGHT));
            document.add(new Paragraph("\n"));

//
//            
            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            //Carga los registros por paginacion
//            for (int i = 1; i <= totalPage; i++) {

            // pageActual = i;
//                List<Sprint> list = sprintServices.lookup(paginator.getFilter(),
//                        paginator.getSort(), pageActual, rowPageSmall.get());
//
//                if (list == null || list.isEmpty()) {
//
//                } else {
            sprintDataTableList.forEach(c -> {

                Paragraph p1 = new Paragraph(new Chunk(
                        rf.fromMessage("print.sprint") + ":" + c.getSprint(),
                        FontFactory.getFont(FontFactory.HELVETICA, 14)));

//                p1.add(new Phrase(
//                        "" +c.getSprint(),
//                        FontFactory.getFont(FontFactory.HELVETICA, 16)));
                document.add(p1);

                // Numero de columnas
                PdfPTable table = new PdfPTable(7);

                // Aqui indicamos el tamaño de cada columna
                table.setTotalWidth(new float[]{70, 60, 60, 60, 60, 60, 60});

                table.setLockedWidth(true);

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.sprint"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.pendiente"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.progreso"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.finalizado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.porcentajesimbol"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                c.getSprint(), FontFactory.getFont("arial", 9, Font.NORMAL)));

                table.addCell(
                        ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechainicial()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                table.addCell(
                        ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                table.addCell(
                        ReportUtils.PdfCell(c.getEstadisticaCierre().getPendiente().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                table.addCell(
                        ReportUtils.PdfCell(c.getEstadisticaCierre().getProgreso().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                table.addCell(
                        ReportUtils.PdfCell(c.getEstadisticaCierre().getFinalizado().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                Double avance = FacesUtil.redondear(c.getEstadisticaCierre().getAvance(), 2);

                table.addCell(
                        ReportUtils.PdfCell(String.valueOf(avance), FontFactory.getFont("arial", 10, Font.NORMAL)));

                document.add(table);
                /*
                Colaborador
                 */
                // Numero de columnas
                PdfPTable tableColaborador = new PdfPTable(5);

                // Aqui indicamos el tamaño de cada columna
                tableColaborador.setTotalWidth(new float[]{100, 60, 60, 60, 60});

                tableColaborador.setLockedWidth(true);

                tableColaborador.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.colaborador"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tableColaborador.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.pendiente"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                tableColaborador.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.progreso"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                tableColaborador.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.finalizado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tableColaborador.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.porcentajesimbol"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                for (EstadisticaCierreColaborador ecc : c.getEstadisticaCierreColaborador()) {
                    if (renderedShowColumn(ecc)) {

                        tableColaborador.addCell(
                                ReportUtils.PdfCell(
                                        showNombreColaborador(ecc.getIduser()), FontFactory.getFont("arial", 9, Font.NORMAL)));

                        tableColaborador.addCell(
                                ReportUtils.PdfCell(ecc.getPendiente().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        tableColaborador.addCell(
                                ReportUtils.PdfCell(ecc.getProgreso().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        tableColaborador.addCell(
                                ReportUtils.PdfCell(ecc.getFinalizado().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        Double avanceColaborador = FacesUtil.redondear(ecc.getAvance(), 2);

                        tableColaborador.addCell(
                                ReportUtils.PdfCell(String.valueOf(avanceColaborador), FontFactory.getFont("arial", 10, Font.NORMAL)));
                    }

                }
                document.add(tableColaborador);
            });
//                }
//            }

            //Reestablece la pagina actual
            //paginator.setPage(pageActual);
            //   document.add(table);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        document.close();

        ReportUtils.printPDF(baos);
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="printTarjetaBySprint(Sprint sprint)">
    public String printTarjetaBySprint(Sprint sprint) {

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlestarjetasporprint"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.proyecto") + " : " + proyectoSelected.getProyecto(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.prefijo") + " : " + proyectoSelected.getPrefijo(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.sprint") + " : " + sprint.getSprint(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.desde") + " : " + JmoordbCoreDateUtil.showDate(sprint.getFechainicial()) + " " + rf.fromMessage("print.hasta") + " : " + JmoordbCoreDateUtil.showDate(sprint.getFechafinal()), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            /**
             * Si se desea imprimir el filtro
             */
//            String textoFiltro = paginator.getTitle();
//            document.add(
//                    ReportUtils.paragraph(
//                            textoFiltro, FontFactory.getFont("arial", 10, Font.BOLD), Element.ALIGN_CENTER));
            /**
             *
             */
            String date = showDate(currentDate) + " " + showHour(currentDate);

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.fecha") + " " + date, FontFactory.getFont("arial", 8, Font.BOLD), Element.ALIGN_RIGHT));
            document.add(new Paragraph("\n"));

            // Numero de columnas
            PdfPTable table = new PdfPTable(7);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{65, 120, 120, 65, 65, 65, 65});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.idtarjeta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.tarjeta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.colaborador"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.columna"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.prioridad"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
//            table.addCell(
//                    ReportUtils.PdfCell(
//                            rf.fromMessage("print.active"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            prepareTarjetaSprint(sprint);

            //Invoca todos los registros con paginacion para imprimir
//            //Carga los registros por paginacion
//            for (int i = 1; i <= totalPage; i++) {
//                pageActual = i;
//                
//              List<Sprint>    list = sprintServices.lookup(paginator.getFilter(),
//                                    paginator.getSort(),  pageActual, rowPageSmall.get());
//                           
            prepareTarjetaSprint(sprint);

            if (tarjetaSprintList == null || tarjetaSprintList.isEmpty()) {

            } else {
                tarjetaSprintList.forEach(c -> {

                    table.addCell(
                            ReportUtils.PdfCell(
                                    c.getIdtarjeta().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                    table.addCell(
                            ReportUtils.PdfCell(
                                    c.getTarjeta(), FontFactory.getFont("arial", 9, Font.NORMAL)));

                    String colaboradores = "";
                    Integer count = 0;
                    String separator = "";
                    for (UserView uv : c.getUserView()) {
                        if (count > 0) {
                            separator = " ,";
                        }
                        count++;
                        colaboradores += separator + uv.getName();
                    }

                    table.addCell(
                            ReportUtils.PdfCell(colaboradores, FontFactory.getFont("arial", 10, Font.NORMAL)));

                    table.addCell(
                            ReportUtils.PdfCell(c.getColumna(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    table.addCell(
                            ReportUtils.PdfCell(c.getPrioridad(), FontFactory.getFont("arial", 10, Font.NORMAL)));

//                        table.addCell(
//                                ReportUtils.PdfCell(c.getActive() ? "si" : "no", FontFactory.getFont("arial", 10, Font.NORMAL)));
//                        
                    table.addCell(
                            ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechainicial()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    table.addCell(
                            ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                });
            }
//            }

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
    // <editor-fold defaultstate="collapsed" desc="String goGraficaTotalesColumnasPorSprint(Sprint sprint)">
    public String goGraficaTotalesColumnasPorSprint(Sprint sprint) {
        try {

            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprint);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
//            JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", Boolean.FALSE);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");

            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "sprint");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "graficatotalescolumnasporsprint.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public String goTarjetas(Sprint sprint)">
    public String goTarjetas(Sprint sprint) {
        try {
            sprintSelected = sprint;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            //JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "sprint");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "tarjetas.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public goCerrarSprint(Sprint sprint)>

    public String goCloseSprint(Sprint sprint) {
        try {
            sprintSelected = sprint;
            Boolean isPropietario = proyectoServices.isPropietario(proyectoSelected, userLogged.getIduser());
            Boolean isColaborador = proyectoServices.isColaborador(proyectoSelected, userLogged.getIduser());

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyectoSelected);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprintSelected);

            JmoordbCoreContext.put("DashboardFaces.isPropietario", isPropietario);
            JmoordbCoreContext.put("DashboardFaces.isColaborador", isColaborador);
            //JmoordbCoreContext.put("DashboardFaces.isProyectoForeano", isProyectoForaneo);
            JmoordbCoreContext.put("DashboardFaces.isEditable", isEditable);
            JmoordbCoreContext.put("DashboardFaces.metodoFiltrarTarjetas", "findByProyectoAndSprint()");
            JmoordbCoreContext.put("DashboardFaces.callerLevel1", "sprint");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "cerrarsprint.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showNombreColaborador()">
    public String showNombreColaborador(Long iduser) {
        String result = "NO ENCONTRADO";
        try {
            Boolean found = Boolean.FALSE;
            for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(iduser)) {
                    result = pm.getUserView().getName();
                    break;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean renderedShowColumn(EstadisticaCierreColaborador estadisticaCierreColaborador) ">
    public Boolean renderedShowColumn(EstadisticaCierreColaborador estadisticaCierreColaborador) {
        Boolean result = Boolean.FALSE;
        try {
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                if (estadisticaCierreColaborador.getIduser().equals(userLogged.getIduser())) {
                    result = Boolean.TRUE;
                }
            } else {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
