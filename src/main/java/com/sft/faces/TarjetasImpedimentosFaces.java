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
import static com.mongodb.client.model.Filters.or;
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
import com.sft.model.ProyectoView;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import jakarta.annotation.PreDestroy;
import java.io.InputStream;
import org.primefaces.event.CloseEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class TarjetasImpedimentosFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices, FacesServices {

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

    private Boolean isPropietario = Boolean.FALSE;
    private Boolean isColaborador = Boolean.FALSE;
    private String metodoFiltrarTarjetas = "";

    private Profile profileLogged = new Profile();

    private EstadisticaCierre estadisticaCierre = new EstadisticaCierre();
    private Sprint sprintSelected = new Sprint();
    private Tarjeta tarjetaSelected = new Tarjeta();
      private Proyecto proyectoSelected = new Proyecto();
    private Sprint sprintDB = new Sprint();
  

    private List<ResponsiveOption> responsiveOptions;

    private List<Sprint> sprintList = new ArrayList<>();
    private List<Tarjeta> tarjetaList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;
    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;
    Integer totalRecords = 0;

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
          if(sprintSelected== null){         
               sprintSelected = new Sprint();
        }
        return sprintSelected;
    }
     public Tarjeta getTarjetaSelected() {
          if(tarjetaSelected== null){         
               tarjetaSelected = new Tarjeta();
        }
        return tarjetaSelected;
    }
     public Proyecto getProyectoSelected() {
          if(proyectoSelected== null){         
               proyectoSelected = new Proyecto();
        }
        return proyectoSelected;
    }
     
     
     
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">
    private LazyDataModel<Tarjeta> tarjetaLazyDataModel;
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
            if (JmoordbCoreContext.get("DashboardFaces.isPropietario") != null) {

                isPropietario = (Boolean) JmoordbCoreContext.get("DashboardFaces.isPropietario");
            }
            if (JmoordbCoreContext.get("DashboardFaces.isColaborador") != null) {
                isColaborador = (Boolean) JmoordbCoreContext.get("DashboardFaces.isColaborador");
            }

            if (JmoordbCoreContext.get("DashboardFaces.metodoFiltrarTarjetas") == null) {
                metodoFiltrarTarjetas = "findByProyectoAndSprint()";
            } else {
                metodoFiltrarTarjetas = (String) JmoordbCoreContext.get("DashboardFaces.metodoFiltrarTarjetas");
            }

            if (JmoordbCoreContext.get("DashboardFaces.sprintSelected") == null) {

            } else {
                sprintSelected = (Sprint) JmoordbCoreContext.get("DashboardFaces.sprintSelected");
            }

            if (JmoordbCoreContext.get("DashboardFaces.isEditable") != null) {
                isEditable = (Boolean) JmoordbCoreContext.get("DashboardFaces.isEditable");

            }
            if (JmoordbCoreContext.get("DashboardFaces.callerLevel0") != null) {
                callerLevel0 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel0");

            }
//            if (callerLevel0.equals("proyecto")) {
//                callerLevel1 = "proyecto";
//
//            } else {
            if (JmoordbCoreContext.get("DashboardFaces.callerLevel1") != null) {
                callerLevel1 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel1");

            }
//            }

            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            if (metodoFiltrarTarjetas.equals("findByProyectoAndSprint()")) {

                findByProyectoAndSprint();
            } else {
                if (metodoFiltrarTarjetas.equals("findByProyecto()")) {

                    findByProyecto();
                }

            }

            this.tarjetaLazyDataModel = new LazyDataModel<Tarjeta>() {
                @Override
                public List<Tarjeta> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

                    switch (paginator.getName()) {
                        case "findByProyectoAndSprint":

                            totalRecords = tarjetaServices.count(paginator.getFilter(),
                                    paginator.getSort(), 0, 0, proyectoSelected.getIdproyecto()).intValue();
                            break;
                        case "findByProyecto":

                            totalRecords = tarjetaServices.count(paginator.getFilter(),
                                    paginator.getSort(), 0, 0, proyectoSelected.getIdproyecto()).intValue();
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

                    List<Tarjeta> result = new ArrayList<>();
                    switch ((paginator.getName())) {
                        case "findByProyectoAndSprint":

                            result = tarjetaServices.lookup(paginator.getFilter(),
                                    paginator.getSort(), paginator.getPage(), rowPageSmall.get(),proyectoSelected.getIdproyecto());

                            break;
                        case "findByProyecto":

                            result = tarjetaServices.lookup(paginator.getFilter(),
                                    paginator.getSort(), paginator.getPage(), rowPageSmall.get(),proyectoSelected.getIdproyecto());

                            break;
                        default:

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
                    if (object == null || object.getIdtarjeta()== null) {
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

    @PreDestroy
    @Override
    public void preDestroy() {
        
    }

    // </editor-fold>
    

    // <editor-fold defaultstate="collapsed" desc="String findByIdProyectoAndSprint()">
    public String findByProyectoAndSprint() {
        try {

            Bson filter = and(
                    eq("idproyecto", proyectoSelected.getIdproyecto()),
                    eq("idsprint", sprintSelected.getIdsprint()),
                    eq("active", Boolean.TRUE),                           
 and (
                            or(
                                    eq("impedimento.0.active",Boolean.TRUE),
                            eq("impedimento.0.active",Boolean.TRUE))
                    )
             
            );

            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            }
            Document sort = new Document("idtarjeta", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idtarjeta", -1)))
                            .title("Todos")
                            .name("findByProyectoAndSprint")
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
    // <editor-fold defaultstate="collapsed" desc="String findByProyecto()">

    public String findByProyecto() {
        try {

            Bson filter = and(
                    eq("idproyecto", proyectoSelected.getIdproyecto()),
                    eq("active", Boolean.TRUE),
                    and (
                            or(
                                    eq("impedimento.0.active",Boolean.TRUE),
                            eq("impedimento.0.active",Boolean.TRUE))
                    )
        

            );
            /**
             * Filtra por roles
             */
            if (profileLogged.getRole().getRole().equals("COLABORADOR")) {
                filter = and(filter, eq("userView.iduser", userLogged.getIduser()));
            }
            Document sort = new Document("idtarjeta", -1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("idtarjeta", -1)))
                            .title("Todos")
                            .name("findByProyecto")
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
if(dataTable!= null){
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

            tarjetaList = new ArrayList<>();
            if (metodoFiltrarTarjetas.equals("findByProyectoAndSprint()")) {
                findByProyectoAndSprint();
            } else {
                if (metodoFiltrarTarjetas.equals("findByProyecto()")) {
                    findByProyecto();
                }

            }
            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String printTarjeta(">
    public String printTarjeta() {

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            if (metodoFiltrarTarjetas.equals("findByProyectoAndSprint()")) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.titlestarjetasporprintconimpedimentos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

            } else {
                if (metodoFiltrarTarjetas.equals("findByProyecto()")) {

                    document.add(
                            ReportUtils.paragraph(
                                    rf.fromMessage("print.titlestarjetasdelproyectoconimpedimentos"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

                }

            }

            Date currentDate = new Date();

            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.proyecto") + " : " + proyectoSelected.getProyecto(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.prefijo") + " : " + proyectoSelected.getPrefijo(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            if (metodoFiltrarTarjetas.equals("findByProyectoAndSprint()")) {

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.sprint") + " : " + sprintSelected.getSprint(), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

                document.add(
                        ReportUtils.paragraph(
                                rf.fromMessage("print.desde") + " : " + JmoordbCoreDateUtil.showDate(sprintSelected.getFechainicial()) + " " + rf.fromMessage("print.hasta") + " : " + JmoordbCoreDateUtil.showDate(sprintSelected.getFechafinal()), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            }

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

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.desde"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

//            table.addCell(
//                    ReportUtils.PdfCell(
//                            rf.fromMessage("print.hasta"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
//            
            //Invoca todos los registros con paginacion para imprimir
//            //Carga los registros por paginacion
//            for (int i = 1; i <= totalPage; i++) {
//                pageActual = i;
//                
//              List<Sprint>    list = sprintServices.lookup(paginator.getFilter(),
//                                    paginator.getSort(),  pageActual, rowPageSmall.get());
//                           
            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            //Carga los registros por paginacion
            for (int i = 1; i <= totalPage; i++) {

                pageActual = i;

                List<Tarjeta> list = tarjetaServices.lookup(paginator.getFilter(),
                        paginator.getSort(), pageActual, rowPageSmall.get(),proyectoSelected.getIdproyecto());

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
                                ReportUtils.PdfCell(colaboradores, FontFactory.getFont("arial", 10, Font.NORMAL)));
//                        table.addCell(
//                                ReportUtils.PdfCell(c.getActive() ? "si" : "no", FontFactory.getFont("arial", 10, Font.NORMAL)));

                        if (c.getIdsprint().equals(0L)) {
                            table.addCell(
                                    ReportUtils.PdfCell(rf.fromMessage("column.backlog"), FontFactory.getFont("arial", 10, Font.NORMAL)));

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
    
     // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }
    // </editor-fold>
}
