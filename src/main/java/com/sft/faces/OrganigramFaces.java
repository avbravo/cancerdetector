/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

// <editor-fold defaultstate="collapsed" desc="import">
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
import com.sft.converter.services.CentralViewConverterServices;
import com.sft.converter.services.DepartamentViewConverterServices;
import com.sft.faces.services.FacesServices;

import com.sft.model.ActionHistory;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.Organigram;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.services.ProyectoServices;
import com.sft.services.ProyectoViewServices;
import com.sft.services.OrganigramServices;
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
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.faces.services.OrganigramFacesServices;
import com.sft.model.DepartamentView;
import com.sft.model.OrganigramDepartament;
import com.sft.model.UserView;
import com.sft.services.DepartamentViewServices;
import jakarta.annotation.PreDestroy;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class OrganigramFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, OrganigramFacesServices, FacesServices {
// <editor-fold defaultstate="collapsed" desc="ConverterServices">

    @Inject
    CentralViewConverterServices centralViewConverterServices;
    @Inject
    DepartamentViewConverterServices departamentViewConverterServices;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private String message = "";
    private String tituloDialogo = "";
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;

    private Boolean buttonNewPressed = Boolean.TRUE;
    private Boolean showDialogContent = Boolean.TRUE;

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private Profile profileLogged = new Profile();

    private Organigram organigramSelected = new Organigram();
    private Organigram organigramDB = new Organigram();
    private Proyecto proyectoSelected = new Proyecto();

    private List<ResponsiveOption> responsiveOptions;
    List<DepartamentView> departamentViewList = new ArrayList<>();
    List<DepartamentView> departamentViewSelectedList = new ArrayList<>();
    private DepartamentView departamentViewSelected = new DepartamentView();
    private List<Organigram> organigramList = new ArrayList<>();
    private List<Tarjeta> tarjetaList = new ArrayList<>();

    private Boolean haveOrganigramOpen = Boolean.FALSE;
    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;
    Integer totalRecords = 0;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
    public DepartamentView getDepartamentViewSelected() {
        if (departamentViewSelected == null) {
            departamentViewSelected = new DepartamentView();
        }
        return departamentViewSelected;
    }

    public Organigram getOrganigramSelected() {
        if (organigramSelected == null) {
            organigramSelected = new Organigram();
        }
        return organigramSelected;
    }

    public Proyecto getProyectoSelected() {
        if (proyectoSelected == null) {
            proyectoSelected = new Proyecto();
        }
        return proyectoSelected;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Organigram> organigramLazyDataModel;
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
    DepartamentViewServices departamentViewServices;
    @Inject
    ProyectoServices proyectoServices;

    @Inject
    ProyectoViewServices proyectoViewServices;
    @Inject
    OrganigramServices organigramServices;

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

    // Converter
    @Inject
    @ConfigProperty(name = "converter.max.number.of.elements")
    private Provider<Integer> converterMaxNumberOfElements;
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
            haveOrganigramOpen = Boolean.FALSE;
            message = "";

            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");

            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            findAll();
            loadDepartamentView();

            this.organigramLazyDataModel = new LazyDataModel<Organigram>() {
                @Override
                public List<Organigram> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    switch (paginator.getName()) {
                        case "findAll":

                            totalRecords = organigramServices.count(paginator.getFilter(),
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

                    List<Organigram> result = new ArrayList<>();
                    switch ((paginator.getName())) {
                        case "findAll":

                            result = organigramServices.lookup(paginator.getFilter(),
                                    paginator.getSort(), paginator.getPage(), rowPageSmall.get());

                            break;
                        default:

                    }

                    organigramLazyDataModel.setRowCount(totalRecords);

                    PrimeFaces.current().executeScript("setDataTableWithPageStart()");
                    PrimeFaces.current().executeScript("widgetVardataTable.getPaginator().setPage(0);");
                    organigramList = result;

                    return result;
                }

                @Override
                public int count(Map<String, FilterMeta> map) {

                    return totalRecords;

                }

                @Override
                public String getRowKey(Organigram object) {
                    if (object == null || object.getIdorganigram() == null) {
                        return "";
                    }
                    return object.getIdorganigram().toString();
                }

                @Override
                public Organigram getRowData(String rowKey) {
                    for (Organigram t : organigramList) {
                        if (t != null) {
                            if (t.getIdorganigram().equals(rowKey)) {
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
        centralViewConverterServices.destroyed();
        departamentViewConverterServices.destroyed();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAll()">
    public String findAll() {
        try {

            Bson filter = ne("organigram", "");

            Document sort = new Document("organigram", 1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idorganigram", -1)))
                            .title("Todos")
                            .name("findAll")
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

        if (dataTable != null) {
            dataTable.setFirst(0);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="save(Organigram organigram)">
    public void save(Organigram organigram) {
        try {

            organigramSelected = organigram;
            //organigramSelected.setOrganigram(organigramSelected.getOrganigram().trim());

            if (departamentViewSelected == null || departamentViewSelected.getIddepartament() == null) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.seleccionedepartament"));
                return;
            }
            organigramSelected.setDepartamentView(departamentViewSelected);

            organigramSelected.setActive(Boolean.TRUE);
            /**
             * Cambiar este por la lista de seleccionados
             *
             */
            List<OrganigramDepartament> organigramDepartamentList = new ArrayList<>();

            if (departamentViewSelectedList == null || departamentViewSelectedList.isEmpty()) {

            } else {
                for (DepartamentView dw : departamentViewSelectedList) {
                    OrganigramDepartament organigramDepartament = new OrganigramDepartament();
                    organigramDepartament.setDepartamentView(dw);
                    organigramDepartamentList.add(organigramDepartament);
                }

            }

            organigramSelected.setOrganigramDepartament(organigramDepartamentList);

            if (organigramServices.existsDepartamentView(departamentViewSelected)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.existeregistrodeldepartamento"));
                return;

            }
            /**
             *
             */

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("crear")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            organigramSelected.setActionHistory(actionHistoryList);

            Optional<Organigram> organigramOptional = organigramServices.save(organigramSelected);
            if (!organigramOptional.isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.save"));
            } else {
                organigramSelected = organigramOptional.get();
                JmoordbCoreContext.put("OrganigramFaces.organigramSelected", organigramSelected);
                //  FacesUtil.infoDialog(rf.fromCore("info.save"), rf.fromCore("info.save"));
                FacesUtil.successMessage(rf.fromCore("info.save"));

                /**
                 * Actualiza las tarjetas
                 */
                PrimeFaces.current().ajax().update("dataTable");

                closeOverlayPanel("PF('overlayPanelOrganigram').hide()");
                refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="edit(Organigram organigram)">

    public void edit(Organigram organigram) {
        try {
            Organigram organigramDBNow = organigramServices.findByIdorganigram(organigram.getIdorganigram()).get();
            if (!organigramDBNow.equals(organigramDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return;
            }
            organigramSelected = organigram;
            List<OrganigramDepartament> organigramDepartamentList = new ArrayList<>();
            if (departamentViewSelectedList == null || departamentViewSelectedList.isEmpty()) {

            } else {
                for (DepartamentView dv : departamentViewSelectedList) {
                    OrganigramDepartament od = new OrganigramDepartament();
                    od.setDepartamentView(dv);
                    organigramDepartamentList.add(od);
                }
            }
            organigramSelected.setOrganigramDepartament(organigramDepartamentList);

//            organigramSelected.setOrganigram(organigramSelected.getOrganigram().trim());
            /**
             *
             */
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
             actionHistoryList.addAll(organigram.getActionHistory());
            actionHistoryList.add(actionHistory);

            organigramSelected.setActionHistory(actionHistoryList);

            Boolean isUpdate = organigramServices.update(organigramSelected);
            if (!isUpdate) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));
            } else {

                FacesUtil.successMessage(rf.fromCore("info.update"));

                /**
                 * Actualiza las tarjetas
                 */
                //  organigramList.add(organigramSelected);
                //  PrimeFaces.current().ajax().update("dataTable");
                closeOverlayPanel("PF('overlayPanelOrganigram').hide()");
                //   refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return;
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

    // <editor-fold defaultstate="collapsed" desc="void agregarRowOrganigram()">
    public void agregarRowOrganigram() {
        try {
            buttonNewPressed = Boolean.TRUE;
            showDialogContent = Boolean.FALSE;
            showDialogContent = Boolean.TRUE;
            organigramSelected = new Organigram();
            departamentViewSelectedList = new ArrayList<>();
            isButtonSavePressed = Boolean.FALSE;
            tituloDialogo = rf.fromMessage("dialog.organigramagregar");
            PrimeFaces.current().ajax().update("outputPanelOrganigram");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String refresh()">
    @Override
    public String refresh() {
        try {

            organigramList = new ArrayList<>();
            findAll();
            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareOrganigram(Organigram organigram)">
    public String prepareOrganigram(Organigram organigram) {
        try {
            organigramSelected = new Organigram();
            showDialogContent = Boolean.TRUE;
            organigramSelected = validarSiCambioOrganigram(organigram);
            isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
            buttonNewPressed = Boolean.FALSE;
            departamentViewSelected = organigram.getDepartamentView();
            departamentViewSelectedList = new ArrayList<>();
            for (OrganigramDepartament od : organigram.getOrganigramDepartament()) {
                departamentViewSelectedList.add(od.getDepartamentView());
            }

            tituloDialogo = rf.fromMessage("dialog.organigrameditar");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Organigram validarSiCambioOrganigram(Organigram organigram)">
    private Organigram validarSiCambioOrganigram(Organigram organigram) {
        Organigram result = new Organigram();
        try {
            message = "";
            fueCambiadoPorOtroUsuario = Boolean.FALSE;
            this.organigramDB = organigramServices.findByIdorganigram(organigram.getIdorganigram()).get();
            if (organigramDB.equals(organigram)) {
                result = organigram;
            } else {
                fueCambiadoPorOtroUsuario = Boolean.TRUE;
                message = rf.fromMessage("warning.otrousuarioactualizoorganigramincronizeeltablero");
                result = organigramDB;
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
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titleorganigram"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            Date currentDate = new Date();

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
            PdfPTable table = new PdfPTable(4);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{60, 120, 150, 60});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.idorganigram"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.departament"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.subdepartament"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.active"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

//            
            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            //Carga los registros por paginacion
            for (int i = 1; i <= totalPage; i++) {

                pageActual = i;

                List<Organigram> list = organigramServices.lookup(paginator.getFilter(),
                        paginator.getSort(), pageActual, rowPageSmall.get());

                if (list == null || list.isEmpty()) {

                } else {
                    list.forEach(c -> {

                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getIdorganigram().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getDepartamentView().getDepartament(), FontFactory.getFont("arial", 9, Font.NORMAL)));

                        String subdepartamento = "";
                        String separador = "";
                        Integer count = 0;
                        if (c.getOrganigramDepartament() == null || c.getOrganigramDepartament().isEmpty()) {
                        } else {
                            for (OrganigramDepartament od : c.getOrganigramDepartament()) {
                                if (count > 0) {
                                    separador = ",";
                                    if (count.equals(c.getOrganigramDepartament().size() - 1)) {
                                        separador = "";
                                    }
                                }
                                subdepartamento += " " + od.getDepartamentView().getDepartament() + separador;
                                count++;
                            }
                        }
                        table.addCell(
                                ReportUtils.PdfCell(
                                        subdepartamento, FontFactory.getFont("arial", 9, Font.NORMAL)));

                        String activo = "";
                        if (c.getActive()) {
                            activo = "si";
                        } else {
                            activo = "no";
                        }
                        table.addCell(
                                ReportUtils.PdfCell(activo, FontFactory.getFont("arial", 10, Font.NORMAL)));

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
    // <editor-fold defaultstate="collapsed" desc="onItemSelect(SelectEvent event)">
    public void onItemSelect(SelectEvent event) {

//        FacesUtil.successMessage(((DepartamentView) event.getObject()).getDepartament());
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="loadDepartamentView()">

    public void loadDepartamentView() {
        try {
            Bson filter = and(eq("active", Boolean.TRUE),
                    eq("central.idcentral", userLogged.getCentralView().getIdcentral())
            );
            Document sort = new Document("departament", 1);
            departamentViewList = departamentViewServices.lookup(filter, sort, 0, 0);

            departamentViewConverterServices.add(departamentViewList);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> completeDepartamentView(String query)">
    public List<DepartamentView> completeDepartamentView(String query) {

        List<DepartamentView> result = new ArrayList<>();
        try {
            query = query.trim();

            result = departamentViewServices.loadDepartamentView(query, departamentViewSelectedList);
            result.remove(departamentViewSelected);

            departamentViewConverterServices.add(result.subList(0,
                    calcularConverterMaxNumberOfElements(result.size(), converterMaxNumberOfElements.get()))
            );
            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
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

    // <editor-fold defaultstate="collapsed" desc="void itemUnselectListener(UnselectEvent event)">
    public void autocompleteUnselectListener(UnselectEvent event) {

    }
    // </editor-fold>
     // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
