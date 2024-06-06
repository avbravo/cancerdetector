/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.ConsoleUtil;
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
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.or;
import com.sft.converter.services.ProyectoConverterServices;
import com.sft.converter.services.UserViewConverterServices;
import com.sft.faces.services.FacesServices;

import com.sft.model.EstadisticaCierre;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
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
import com.sft.model.Archivo;
import com.sft.model.DepartamentView;
import com.sft.model.Organigram;
import com.sft.model.OrganigramDepartament;
import com.sft.model.ProyectoView;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.services.OrganigramServices;
import com.sft.services.UserViewServices;
import jakarta.annotation.PreDestroy;
import jakarta.faces.event.AjaxBehaviorEvent;
import java.io.InputStream;
import org.primefaces.component.autocomplete.AutoComplete;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class BuscadorTarjetasFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices, FacesServices {
// <editor-fold defaultstate="collapsed" desc="ConverterServices">

    @Inject
    ProyectoConverterServices proyectoConverterServices;

    @Inject
    UserViewConverterServices userViewConverterServices;

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
    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private String callerLevel1 = "";
    private String filterText = "";
    private String textToSearch = "";
    private String textDescripcionToSearch = "";

    private Boolean includeProject = Boolean.TRUE;
    private Boolean includeUser = Boolean.FALSE;
    private Boolean includePrioridad = Boolean.FALSE;
    private Boolean includeColumna = Boolean.FALSE;
    private Boolean includeDeposito = Boolean.FALSE;
    private Boolean includeRango = Boolean.FALSE;

    private Boolean isPropietario = Boolean.FALSE;
    private Boolean isColaborador = Boolean.FALSE;
    private String metodoFiltrarTarjetas = "";

    private String prioridadSelected = "";
    private String columnaSelected = "";
    private String depositoSelected = "";
    private List<Date> rangoFechaSelected = new ArrayList<>();
    private Proyecto proyectoAutocompleteSelected = new Proyecto();

    private Profile profileLogged = new Profile();
    private DepartamentView departamentViewSelected = new DepartamentView();
    private EstadisticaCierre estadisticaCierre = new EstadisticaCierre();
    private Sprint sprintSelected = new Sprint();
    private Tarjeta tarjetaSelected = new Tarjeta();
    private Tarjeta tarjetaLazyDataModelSelected = new Tarjeta();
    private Tarjeta tarjetaDescripcionSelected = new Tarjeta();
    private Sprint sprintDB = new Sprint();
    private Proyecto proyectoSelected = new Proyecto();
    private UserView userViewSelected = new UserView();

    private List<ResponsiveOption> responsiveOptions;

    private List<Sprint> sprintList = new ArrayList<>();
    private List<Tarjeta> tarjetaList = new ArrayList<>();
    private List<Tarjeta> tarjetaLazyDataModelList = new ArrayList<>();
//    private List<DepartamentView> departamentViewList = new ArrayList<>();
    private List<UserView> userViewList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;
    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;
    private AutoComplete autoComplete;
    Integer totalRecords = 0;
    Integer totalRecordsAutocompleteTarjeta = 0;

    /**
     * Descargar y visualizar imagenes
     */
    StreamedContent media = null;

    InputStream is = null;

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

    public DepartamentView getDepartamentViewSelected() {
        if (departamentViewSelected == null) {
            departamentViewSelected = new DepartamentView();
        }
        return departamentViewSelected;
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

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Tarjeta> tarjetaLazyDataModel;
    private LazyDataModel<Tarjeta> autocompleteByTarjetaLazyDataModel;
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
    OrganigramServices organigramServices;
    @Inject
    ProyectoServices proyectoServices;

    @Inject
    ProyectoViewServices proyectoViewServices;
    @Inject
    SprintServices sprintServices;

    @Inject
    TarjetaServices tarjetaServices;
    @Inject
    UserViewServices userViewServices;
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
            textToSearch = "";
            textDescripcionToSearch = "";

            haveSprintOpen = Boolean.FALSE;
            includeProject = Boolean.TRUE;
            includeUser = Boolean.FALSE;
            message = "";
            prioridadSelected = "";
            columnaSelected = "";
            depositoSelected = "";
            filterText = "";
            rangoFechaSelected = new ArrayList<>();
            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");

            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            JmoordbCoreUtil.copyBeans(departamentViewSelected, profileLogged.getDepartamentView());

            if (!profileLogged.getRole().getRole().equals("COLABORADOR")) {
                includeUser = Boolean.TRUE;

            }

            var userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());
            JmoordbCoreUtil.copyBeans(userViewSelected, userView);

//            loadDepartamentView();
            findByTarjetas();
            loadUserView();
            loadProyecto();

            this.tarjetaLazyDataModel = new LazyDataModel<Tarjeta>() {
                @Override
                public List<Tarjeta> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                        totalRecords = tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
                    } else {
                        if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {

                            totalRecords = tarjetaServices.searchCountLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
                        } else {

                            totalRecords = tarjetaServices.searchCountLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto()).intValue();
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

                    if (textDescripcionToSearch == null || textDescripcionToSearch.equals("")) {
                        result = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
                    } else {
                        if ((textToSearch == null || textToSearch.equals("")) && (textDescripcionToSearch != null || !textDescripcionToSearch.equals(""))) {
                            result = tarjetaServices.searchLikeByDescripcion(textDescripcionToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
                        } else {
                            result = tarjetaServices.searchLikeByTarjeta(textToSearch, paginator.getFilter(), paginator.getSort(), paginator.getPage(), rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());
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
    @Override
    public void preDestroy() {
        proyectoConverterServices.destroyed();
        userViewConverterServices.destroyed();

    }

    // <editor-fold defaultstate="collapsed" desc="String findByTarjetas()">
    public String findByTarjetas() {
        try {
            filterText = "";

            Bson filter = and(
                    eq("active", Boolean.TRUE)
            );
            if (includeUser) {
                filter = and(filter, eq("userView.iduser", userViewSelected.getIduser()));
                filterText += " [" + rf.fromMessage("filtro.user") + "] = " + userViewSelected.getName();
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
            if (includePrioridad) {
                filterText += " [" + rf.fromMessage("filtro.prioridad") + "] = " + prioridadSelected;
                filter = and(filter,
                        eq("prioridad", prioridadSelected));

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
            }
            if (includeRango) {

                if (rangoFechaSelected == null || rangoFechaSelected.size() == 0) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.seleccionerangofechas"));
                    //  return "";
                } else {
                    if (rangoFechaSelected.size() == 1) {
                        FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.seleccionefechafinalrango"));
                        //  return "";
                    } else {
                        filterText += " [" + rf.fromMessage("filtro.from") + "] = " + DateUtil.dateFormatToString(rangoFechaSelected.get(0), "dd/MM/yyyy") + rf.fromMessage("filtro.to") + " " + DateUtil.dateFormatToString(rangoFechaSelected.get(1), "dd/MM/yyyy");
                        filter = and(filter,
                                gte("fechainicial", JmoordbCoreDateUtil.dateToLocalDateTimeFirstHourOfDay(rangoFechaSelected.get(0))),
                                lte("fechainicial", JmoordbCoreDateUtil.dateToLocalDateTimeLastHourOfDay(rangoFechaSelected.get(1)))
                        );
                    }
                }

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

    // <editor-fold defaultstate="collapsed" desc="ProyectoView findProyectoViewByIdSprint(Long idSprint)">
    public ProyectoView findProyectoViewByIdSprint(Tarjeta tarjeta) {
        ProyectoView result = new ProyectoView();
        try {
            if (!tarjeta.getIdsprint().equals(0L)) {

                var sp = sprintServices.findByIdsprint(tarjeta.getIdsprint()).get();
                if (sp == null || sp.getIdsprint() == null) {

                    var proyecto = proyectoServices.findByIdproyecto(tarjeta.getIdproyecto()).get();
                    if (proyecto == null || proyecto.getIdproyecto() == null) {

                    } else {

                        result.setActive(proyecto.getActive());
                        result.setAvance(proyecto.getAvance());
                        result.setColaboradorcreartarjeta(proyecto.getColaboradorcreartarjeta());
                        result.setDescripcion(proyecto.getDescripcion());
                        result.setProyecto(proyecto.getProyecto());

                    }

                } else {

                    result = sp.getProyectoView();
                }

            } else {

                var proyecto = proyectoServices.findByIdproyecto(tarjeta.getIdproyecto()).get();
                if (proyecto == null || proyecto.getIdproyecto() == null) {

                } else {

                    result.setActive(proyecto.getActive());
                    result.setAvance(proyecto.getAvance());
                    result.setColaboradorcreartarjeta(proyecto.getColaboradorcreartarjeta());
                    result.setDescripcion(proyecto.getDescripcion());
                    result.setProyecto(proyecto.getProyecto());

                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
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
            PrimeFaces.current().ajax().update("outputPanelViewImage");
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

    // <editor-fold defaultstate="collapsed" desc="setFirstPageDataTable()">
    public void setFirstPageDataTable() {

        if (dataTable != null) {
            dataTable.setFirst(0);
        }
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

    // <editor-fold defaultstate="collapsed" desc="void closeOverlayPanel(String panel) ">
    private void closeOverlayPanel(String panel) {
        try {
            PrimeFaces.current().executeScript(panel);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String refresh()">
    @Override
    public String refresh() {
        try {
            textToSearch = "";
            textDescripcionToSearch = "";

            tarjetaList = new ArrayList<>();

            findByTarjetas();

            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String printTarjeta()">
    public String printTarjeta() {

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlestarjetas"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.filtro") + " : " + filterText, FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

//
//                document.add(
//                        ReportUtils.paragraph(
//                                rf.fromMessage("print.desde") + " : " + JmoordbCoreDateUtil.showDate(sprintSelected.getFechainicial()) + " " + rf.fromMessage("print.hasta") + " : " + JmoordbCoreDateUtil.showDate(sprintSelected.getFechafinal()), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
//
//            }
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
            PdfPTable table = new PdfPTable(8);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{65, 120, 120, 120, 65, 65, 65, 65});

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
                            rf.fromMessage("print.proyecto"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.columna"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.prioridad"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            
            
            //Carga los registros por paginacion
            for (int i = 1; i <= totalPage; i++) {

                pageActual = i;
    
                List<Tarjeta> list = tarjetaServices.lookup(paginator.getFilter(),
                        paginator.getSort(), pageActual, rowPageSmall.get(), proyectoAutocompleteSelected.getIdproyecto());

                if (list == null || list.isEmpty()) {
                   
                } else {
          
                    list.forEach(c -> {
                       
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
                                separator = ",";
                            }
                            count++;
                            colaboradores += separator + uv.getName();
                        }

                        table.addCell(
                                ReportUtils.PdfCell(colaboradores, FontFactory.getFont("arial", 9, Font.NORMAL)));
                        if (!c.getBacklog()) {
                            table.addCell(
                                    ReportUtils.PdfCell(findProyectoViewByIdSprint(c).getProyecto() + " /"
                                            + rf.fromMessage("print.sprint") + " " + c.getIdsprint(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        } else {
                            table.addCell(
                                    ReportUtils.PdfCell(findProyectoViewByIdSprint(c).getProyecto() + " /"
                                            + rf.fromMessage("print.reserva"), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        }

//                        table.addCell(
//                                ReportUtils.PdfCell(c.getActive() ? "si" : "no", FontFactory.getFont("arial", 10, Font.NORMAL)));
                        if (c.getBacklog()) {
                            table.addCell(
                                    ReportUtils.PdfCell("---", FontFactory.getFont("arial", 10, Font.NORMAL)));

                        } else {
                            table.addCell(
                                    ReportUtils.PdfCell(c.getColumna(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        }

                        table.addCell(
                                ReportUtils.PdfCell(c.getPrioridad(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechainicial()), FontFactory.getFont("arial", 10, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));

//                        table.addCell(
//                                ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 10, Font.NORMAL)));
//                        
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
    // <editor-fold defaultstate="collapsed" desc="String printByTarjeta(Tarjeta tarjeta) ">
    public String printByTarjeta(Tarjeta tarjeta) {

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlestarjetas"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.filtroportarjeta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            /**
             *
             */
            String date = showDate(currentDate) + " " + showHour(currentDate);

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.fecha") + " " + date, FontFactory.getFont("arial", 8, Font.BOLD), Element.ALIGN_RIGHT));
            document.add(new Paragraph("\n"));

            var c = tarjeta;
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.idtarjeta") + " " + c.getIdtarjeta(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.tarjeta") + " " + c.getTarjeta(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.descripcion") + " " + c.getDescripcion(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.estimacion") + " " + c.getEstimacion(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));

            if (c.getBacklog()) {
                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.backlog") + " " + rf.fromMessage("print.yes"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));

            }
            if (c.getForeaneo()) {
                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.foraneo") + " " + rf.fromMessage("print.yes"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_LEFT));

            }

         

            String colaboradores = "";
            Integer count = 0;
            String separator = "";
            for (UserView uv : c.getUserView()) {
                if (count > 0) {
                    separator = ",";
                }
                count++;
                colaboradores += separator + uv.getName();
            }
        
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.colaborador") + " " + colaboradores, FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.proyecto") + " " + findProyectoViewByIdSprint(c).getProyecto(), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

    
            if (c.getBacklog()) {
                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.reserva"), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            } else {
                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.sprint") + " " + c.getIdsprint(), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            }
            if (!c.getBacklog()) {
                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.columna") + " " + c.getColumna(), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            }
       
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.prioridad") + " " + c.getPrioridad(), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.desde") + " " + JmoordbCoreDateUtil.showDate(c.getFechainicial()), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.hasta") + " " + JmoordbCoreDateUtil.showDate(c.getFechafinal()), FontFactory.getFont("arial", 11, Font.NORMAL), Element.ALIGN_LEFT));

            /**
             * Tareas
             */
      
            if (c.getTarea().size() > 0) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.tareas"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_LEFT));
                PdfPTable table = new PdfPTable(2);

                // Aqui indicamos el tamaño de cada columna
                table.setTotalWidth(new float[]{150, 80});

                table.setLockedWidth(true);

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.tarea"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.completado"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tarjeta.getTarea().forEach(t -> {

                    table.addCell(
                            ReportUtils.PdfCell(t.getTarea(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                    table.addCell(
                            ReportUtils.PdfCell(t.getCompletado() ? rf.fromMessage("print.yes") : rf.fromMessage("print.no"), FontFactory.getFont("arial", 10, Font.NORMAL)));

                });

                document.add(table);

            }

        
            if (c.getImpedimento().size() > 0) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.impedimentos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_LEFT));
                PdfPTable tableImpedimiento = new PdfPTable(3);

                // Aqui indicamos el tamaño de cada columna
                tableImpedimiento.setTotalWidth(new float[]{150, 65, 100});

                tableImpedimiento.setLockedWidth(true);

                tableImpedimiento.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.impedimento"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tableImpedimiento.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.activo"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tableImpedimiento.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.fecha"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tarjeta.getImpedimento().forEach(t -> {
                    tableImpedimiento.addCell(
                            ReportUtils.PdfCell(t.getImpedimento(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    tableImpedimiento.addCell(
                            ReportUtils.PdfCell(t.getActive() ? rf.fromMessage("print.yes") : rf.fromMessage("print.no"), FontFactory.getFont("arial", 10, Font.NORMAL)));
                    tableImpedimiento.addCell(
                            ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(t.getFecha()), FontFactory.getFont("arial", 10, Font.NORMAL)));
                });

                document.add(tableImpedimiento);

            }
        
            if (c.getComentario().size() > 0) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.comentarios"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_LEFT));
                PdfPTable table = new PdfPTable(4);

                // Aqui indicamos el tamaño de cada columna
                table.setTotalWidth(new float[]{150, 150, 65, 100});

                table.setLockedWidth(true);

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.comentario"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.colaborador"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.activo"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.fecha"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                tarjeta.getComentario().forEach(t -> {
                    table.addCell(
                            ReportUtils.PdfCell(t.getComentario(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    table.addCell(
                            ReportUtils.PdfCell(t.getUserView().getName(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                    table.addCell(
                            ReportUtils.PdfCell(t.getActive() ? rf.fromMessage("print.yes") : rf.fromMessage("print.no"), FontFactory.getFont("arial", 10, Font.NORMAL)));
                    table.addCell(
                            ReportUtils.PdfCell(JmoordbCoreDateUtil.showDate(t.getFecha()), FontFactory.getFont("arial", 10, Font.NORMAL)));
                });

                document.add(table);

            }

            

            if (c.getEtiqueta().size() > 0) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.etiquetas"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_LEFT));
                PdfPTable table = new PdfPTable(1);

                // Aqui indicamos el tamaño de cada columna
                table.setTotalWidth(new float[]{150});
                table.setLockedWidth(true);
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.etiqueta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                tarjeta.getEtiqueta().forEach(t -> {

                    table.addCell(
                            ReportUtils.PdfCell(t.getEtiqueta(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                });

                document.add(table);

            }
            
            if (c.getArchivo().size() > 0) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.archivos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_LEFT));
                PdfPTable table = new PdfPTable(1);

                // Aqui indicamos el tamaño de cada columna
                table.setTotalWidth(new float[]{150});
                table.setLockedWidth(true);
                table.addCell(
                        ReportUtils.PdfCell(
                                rf.fromMessage("print.archivo"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
                tarjeta.getArchivo().forEach(t -> {

                    table.addCell(
                            ReportUtils.PdfCell(t.getDescripcion(), FontFactory.getFont("arial", 10, Font.NORMAL)));

                });

                
                document.add(table);

                
            }
            
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        document.close();

        ReportUtils.printPDF(baos);
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> completeTarjeta(String query)">
    public List<Tarjeta> completeTarjeta(String query) {

        List<Tarjeta> result = new ArrayList<>();
        try {
            query = query.trim();
            List<Tarjeta> list = tarjetaServices.likeByTarjeta(query, proyectoAutocompleteSelected.getIdproyecto());
            if (list == null || list.isEmpty()) {

            } else {
                for (Tarjeta t : list) {
                    if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                        var found = Boolean.FALSE;
                        for (UserView uv : t.getUserView()) {
                            if (uv.getIduser().equals(userLogged.getIduser())) {
                                found = Boolean.TRUE;
                                break;
                            }
                        }
                        if (found) {
                            result.add(t);
                        }

                    } else {
                        if (t.getIdproyecto().equals(proyectoAutocompleteSelected.getIdproyecto())) {
                            result.add(t);
                        }
                    }

                }
            }

            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> completeDescripcion(String query)">

    public List<Tarjeta> completeDescripcion(String query) {

        List<Tarjeta> result = new ArrayList<>();
        try {
            query = query.trim();
            List<Tarjeta> list = tarjetaServices.likeByDescripcion(query, proyectoAutocompleteSelected.getIdproyecto());
            if (list == null || list.isEmpty()) {

            } else {
                for (Tarjeta t : list) {
                    if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                        var found = Boolean.FALSE;
                        for (UserView uv : t.getUserView()) {
                            if (uv.getIduser().equals(userLogged.getIduser())) {
                                found = Boolean.TRUE;
                                break;
                            }
                        }
                        if (found) {
                            result.add(t);
                        }
                    } else {
                        if (t.getIdproyecto().equals(proyectoAutocompleteSelected.getIdproyecto())) {
                            result.add(t);
                        }
                    }

                }
            }

            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="  autocompleteSelectedEvent(SelectEvent event)">
    public void autocompleteSelectedEvent(SelectEvent<Tarjeta> event) {
        try {

            filterText = rf.fromMessage("filtro.tarjeta") + " = " + event.getObject().getTarjeta();

            if (proyectoAutocompleteSelected == null || proyectoAutocompleteSelected.getIdproyecto() == null) {

            } else {
                filterText += " /" + rf.fromMessage("filtro.proyecto") + " " + proyectoAutocompleteSelected.getProyecto();
            }

            Bson filter = and(
                    eq("active", Boolean.TRUE),
                    eq("idtarjeta", event.getObject().getIdtarjeta())
            );
            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            } else {
                filter = and(filter, eq("idproyecto", proyectoAutocompleteSelected.getIdproyecto()));
            }
            Document sort = new Document("idtarjeta", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idtarjeta", -1)))
                            .title(filterText)
                            .name("findByProyecto")
                            .build();

            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="  autocompleteDescripcionSelectedEvent(SelectEvent event)">

    public void autocompleteDescripcionSelectedEvent(SelectEvent<Tarjeta> event) {
        try {
            filterText = rf.fromMessage("filtro.descripcion") + " = " + event.getObject().getTarjeta();
            if (proyectoAutocompleteSelected == null || proyectoAutocompleteSelected.getIdproyecto() == null) {

            } else {
                filterText += " /" + rf.fromMessage("filtro.proyecto") + " " + proyectoAutocompleteSelected.getProyecto();
            }
            Bson filter = and(
                    eq("active", Boolean.TRUE),
                    eq("idtarjeta", event.getObject().getIdtarjeta())
            );
            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            } else {
                filter = and(filter, eq("idproyecto", proyectoAutocompleteSelected.getIdproyecto()));
            }
            Document sort = new Document("idtarjeta", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idtarjeta", -1)))
                            .title(filterText)
                            .name("findByProyecto")
                            .build();

            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void autocompleteUnselectListener(UnselectEvent event)">
    public void autocompleteUnselectListener(UnselectEvent event) {

    }
    // </editor-fold>

//    // <editor-fold defaultstate="collapsed" desc="String loadDepartamentView()">
//    public String loadDepartamentView() {
//        try {
//            departamentViewList = new ArrayList<>();
//            Bson filter = and(eq("departament.iddepartament", profileLogged.getDepartamentView().getIddepartament()),
//                    eq("active", Boolean.TRUE)
//            );
//            Document sort = new Document("idorganigram", -1);
//
//            List<Organigram> organigramList = organigramServices.lookup(filter,
//                    sort, 0, 0);
//
//            if (organigramList == null || organigramList.isEmpty()) {
//
//                departamentViewList.add(profileLogged.getDepartamentView());
//            } else {
//
//                departamentViewList.add(profileLogged.getDepartamentView());
//                Organigram o = organigramList.get(0);
//                if (o.getOrganigramDepartament() == null || o.getOrganigramDepartament().isEmpty()) {
//
//                } else {
//
//                    for (OrganigramDepartament od : o.getOrganigramDepartament()) {
//
//                        departamentViewList.add(od.getDepartamentView());
//                    }
//
//                }
//
//            }
//
//        } catch (Exception e) {
//
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return "";
//    }
//
//    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String loadProyecto() ">
    public String loadProyecto() {
        try {

            List<Proyecto> result = new ArrayList<>();
            Bson filter = and(
                    eq("proyectoMiembro.user.iduser", userLogged.getIduser()),
                    eq("active", Boolean.TRUE)
            );
            Document sort = new Document("proyecto", -1);
            result = proyectoServices.lookup(filter, sort, 0, 0);

            if (result == null || result.isEmpty()) {

            } else {

                JmoordbCoreUtil.copyBeans(proyectoAutocompleteSelected, result.get(0));

            }

            proyectoConverterServices.add(result);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectDepartament(SelectEvent event)">
    public void onItemSelectDepartament(SelectEvent event) {
        try {

            loadUserView();
            loadProyecto();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectProyecto(SelectEvent event)">

    public void onItemSelectProyecto(SelectEvent event) {
        try {

            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String loadUserView()">
    public String loadUserView() {
        try {
            userViewList = new ArrayList<>();
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                var userView = new UserView(userLogged.getIduser(), userLogged.getName(), userLogged.getPhoto(), userLogged.getEmail(), userLogged.getRecibirNotificacion());
                userViewList.add(userView);
            } else {
                Bson filter = and(eq("profile.departament.iddepartament", departamentViewSelected.getIddepartament()),
                        eq("profile.active", Boolean.TRUE),
                        eq("active", Boolean.TRUE)
                );
                Document sort = new Document("name", 1);

                List<UserView> list = userViewServices.lookup(filter,
                        sort, 0, 0);

                if (list == null || list.isEmpty()) {

                } else {

                    userViewList = list;

                }
            }
            userViewConverterServices.add(userViewList);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectUser(SelectEvent event)">
    public void onItemSelectUser(SelectEvent event) {
        try {
            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectPrioridad(SelectEvent event)">

    public void onItemSelectPrioridad(SelectEvent event) {
        try {
            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectColumna(SelectEvent event)">

    public void onItemSelectColumna(SelectEvent event) {
        try {
            findByTarjetas();
            setFirstPageDataTable();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onItemSelectDeposito(SelectEvent event)">

    public void onItemSelectDeposito(SelectEvent event) {
        try {
            findByTarjetas();
            setFirstPageDataTable();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    protected String getSortField(Map<String, SortMeta> sortBy) {

        if (sortBy != null && sortBy.isEmpty() == false) {
            SortMeta sortM = sortBy.entrySet().stream().findFirst().get().getValue();
            return sortM.getField().trim();

        }
        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> completeTarjetaPagination(String query, Pagination pagination)">
    public List<Tarjeta> completeTarjetaPagination(String query, Pagination pagination) {

        List<Tarjeta> result = new ArrayList<>();
        try {
            //set page se puede mover 
            paginationAutocompleteTartjeta.setPage(1);
            paginationAutocompleteTartjeta.setSize(rowPageSmall.get());

            query = query.trim();

            List<Tarjeta> list = tarjetaServices.searchLikeByTarjeta(query, this.paginator.getFilter(), this.paginator.getSort(), pagination.getPage(), pagination.getSize(), proyectoAutocompleteSelected.getIdproyecto());
            if (list == null || list.isEmpty()) {

            } else {
                result.addAll(list);
            }

            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sugerirTarjetas(AjaxBehaviorEvent event)">
    public void sugerirTarjetas(AjaxBehaviorEvent event) {
        List<Tarjeta> result = new ArrayList<>();
        try {
            textDescripcionToSearch = "";
            findByTarjetas();
            setFirstPageDataTable();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="sugerirTarjetasDescripcion(AjaxBehaviorEvent event)">

    public void sugerirTarjetasDescripcion(AjaxBehaviorEvent event) {

        List<Tarjeta> result = new ArrayList<>();
        try {
            textToSearch = "";
            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean loadMisTarjetas() ">
    private Boolean loadMisTarjetas() {
        Boolean result = Boolean.FALSE;
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void listenerCheckBoxProyecto(AjaxBehaviorEvent event) ">
    public void listenerCheckBox(AjaxBehaviorEvent event) {

        try {
            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="void onDateSelect(SelectEvent<Date> event)">
    public void onDateSelect(SelectEvent<Date> event) {
        try {
            findByTarjetas();
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
