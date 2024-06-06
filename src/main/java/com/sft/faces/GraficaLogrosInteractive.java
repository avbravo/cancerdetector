/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.sft.faces.services.FacesServices;

import com.sft.model.Icono;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
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
import com.sft.model.Tarea;
import org.primefaces.PrimeFaces;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.StreamedContent;

import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.file.UploadedFile;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.services.ProyectoEstadisticaServices;
import jakarta.annotation.PreDestroy;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ReorderEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.optionconfig.tooltip.Tooltip;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class GraficaLogrosInteractive implements Serializable, JmoordbCoreXHTMLUtil, TableroFacesServices, FacesServices {

    private StreamedContent fileDownload;
    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;

    private BarChartModel stackedBarModel;
    private List<Sprint> sprintList;

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

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private String callerLevel1 = "";

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
    private Tarjeta tarjetaColaboradorSelected = new Tarjeta();
    private Tarjeta tarjetaEtiquetaSelected = new Tarjeta();
    private Tarjeta tarjetaTareaSelected = new Tarjeta();
    private Tarjeta tarjetaImpedimentoSelected = new Tarjeta();
    private Tarjeta tarjetaArchivoSelected = new Tarjeta();
    private Tarjeta tarjetaDB = new Tarjeta();

    private ProyectoEstadistica proyectoEstadisticaResumen = new ProyectoEstadistica();

    private Icono iconoSelected = new Icono();

    private UserView userViewForaneo = new UserView();

    private List<UserView> userViewSelectedList = new ArrayList<>();

    private List<Proyecto> proyectoList = new ArrayList<>();
    private List<ResponsiveOption> responsiveOptions;
    private List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();

    private List<Tarjeta> tarjetaListDataTable = new ArrayList<>();
    private List<Tarjeta> tarjetaPendienteList = new ArrayList<>();

    private List<Tarjeta> tarjetaProgresoList = new ArrayList<>();

    private List<Tarjeta> tarjetaFinalizadoList = new ArrayList<>();

    private Boolean haveSprintOpen = Boolean.FALSE;

    ColorManagement colorKnob = new ColorManagementImpl();

    private BarChartModel barModelTarjetas;

    private ScheduleModel eventModel;

    private ScheduleModel lazyEventModel;
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

    public Tarjeta getTarjetaArchivoSelected() {
        if (tarjetaArchivoSelected == null) {
            tarjetaArchivoSelected = new Tarjeta();
        }
        return tarjetaArchivoSelected;
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
    ProyectoEstadisticaServices proyectoEstadisticaServices;
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
            sprintList = new ArrayList<>();
            haveSprintOpen = Boolean.FALSE;
            message = "";
            isPropietario = Boolean.FALSE;
            isColaborador = Boolean.FALSE;
            isProyectoForaneo = Boolean.FALSE;
            isOverlayPanelOpen = Boolean.FALSE;
            isButtonSavePressed = Boolean.TRUE;

            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
            if (JmoordbCoreContext.get("DashboardFaces.proyectoSelected") == null) {
                //  ConsoleUtil.info("proyectoSelected es null");
            } else {
                proyectoSelected = (Proyecto) JmoordbCoreContext.get("DashboardFaces.proyectoSelected");

                if (JmoordbCoreContext.get("DashboardFaces.isPropietario") != null) {

                    isPropietario = (Boolean) JmoordbCoreContext.get("DashboardFaces.isPropietario");
                }
                if (JmoordbCoreContext.get("DashboardFaces.isColaborador") != null) {
                    isColaborador = (Boolean) JmoordbCoreContext.get("DashboardFaces.isColaborador");
                }
                if (JmoordbCoreContext.get("DashboardFaces.isProyectoForeano") != null) {
                    isProyectoForaneo = (Boolean) JmoordbCoreContext.get("DashboardFaces.isProyectoForeano");

                }
                if (JmoordbCoreContext.get("DashboardFaces.isEditable") != null) {
                    isEditable = (Boolean) JmoordbCoreContext.get("DashboardFaces.isEditable");

                }
                if (JmoordbCoreContext.get("DashboardFaces.callerLevel0") != null) {
                    callerLevel0 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel0");

                }
                if (JmoordbCoreContext.get("DashboardFaces.callerLevel1") != null) {
                    callerLevel1 = (String) JmoordbCoreContext.get("DashboardFaces.callerLevel1");

                }
                if (isPropietario) {
                    perfil = rf.fromMessage("label.propietario");
                } else {
                    perfil = rf.fromMessage("label.colaborador");
                }

            }

            //Cargar el media type
            saveToMediaContext(userLogged.getPhoto());
            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());

//            createStackedBarModel();
            createBarModel2();
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

    // <editor-fold defaultstate="collapsed" desc="void closeOverlayPanel(String panel) ">
    private void closeOverlayPanel(String panel) {
        try {
            PrimeFaces.current().executeScript(panel);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    public void createStackedBarModel() {
        stackedBarModel = new BarChartModel();
        try {

            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyectoSelected.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.FALSE);
            Document sort = new Document("idsprint", 1);
            message = "";

            sprintList = sprintServices.lookup(
                    filter,
                    sort,
                    page, size);

            if (sprintList == null || sprintList.isEmpty()) {
                // FacesUtil.warningDialog(rf.fromMessage("waring.nohaysprintcerrados"));
                message = rf.fromMessage("waring.nohaysprintcerrados");
                return;
            }

            ChartData data = new ChartData();

            BarChartDataSet barDataSet = new BarChartDataSet();
            barDataSet.setLabel(rf.fromMessage("label.pendiente"));
            barDataSet.setBackgroundColor("rgb(255, 99, 132)");
            List<Object> dataValPendiente = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValPendiente.add(sp.getEstadisticaCierre().getPendiente());
            }

            barDataSet.setData(dataValPendiente);

            BarChartDataSet barDataSet2 = new BarChartDataSet();
            barDataSet2.setLabel(rf.fromMessage("label.progreso"));
            barDataSet2.setBackgroundColor("rgb(54, 162, 235)");
            List<Object> dataValProgreso = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValProgreso.add(sp.getEstadisticaCierre().getProgreso());
            }

            barDataSet2.setData(dataValProgreso);

            BarChartDataSet barDataSet3 = new BarChartDataSet();
            barDataSet3.setLabel(rf.fromMessage("label.finalizado"));
            barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
            List<Object> dataValFinalizado = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValFinalizado.add(sp.getEstadisticaCierre().getFinalizado());
            }

            barDataSet3.setData(dataValFinalizado);

            data.addChartDataSet(barDataSet);
            data.addChartDataSet(barDataSet2);
            data.addChartDataSet(barDataSet3);

            List<String> labels = new ArrayList<>();

            for (Sprint sp : sprintList) {

                labels.add(sp.getSprint() + " [" + FacesUtil.redondear(sp.getEstadisticaCierre().getAvance(), 2) + "%]");
            }

            data.setLabels(labels);
            stackedBarModel.setData(data);

            //Options
            BarChartOptions options = new BarChartOptions();
            options.setMaintainAspectRatio(false);
            CartesianScales cScales = new CartesianScales();
            CartesianLinearAxes linearAxes = new CartesianLinearAxes();
            linearAxes.setStacked(true);
            linearAxes.setOffset(true);
            CartesianLinearTicks ticks = new CartesianLinearTicks();
            linearAxes.setTicks(ticks);
            cScales.addXAxesData(linearAxes);
//            cScales.addYAxesData(linearAxes);
            options.setScales(cScales);

            Title title = new Title();
            title.setDisplay(true);
            title.setText(rf.fromMessage("graph.logrostitle"));
            options.setTitle(title);

            Tooltip tooltip = new Tooltip();
            tooltip.setMode("index");
            tooltip.setIntersect(false);
            options.setTooltip(tooltip);

            stackedBarModel.setOptions(options);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    public void createBarModel2() {
        stackedBarModel = new BarChartModel();
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyectoSelected.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.FALSE);
            Document sort = new Document("idsprint", 1);
            message = "";

            sprintList = sprintServices.lookup(
                    filter,
                    sort,
                    page, size);

            if (sprintList == null || sprintList.isEmpty()) {
                // FacesUtil.warningDialog(rf.fromMessage("waring.nohaysprintcerrados"));
                message = rf.fromMessage("waring.nohaysprintcerrados");
                return;
            }

            ChartData data = new ChartData();

            BarChartDataSet barDataSet = new BarChartDataSet();
            barDataSet.setLabel(rf.fromMessage("label.pendiente"));
            barDataSet.setBackgroundColor("rgb(255, 99, 132)");
//            barDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
            barDataSet.setBorderColor("rgb(255, 99, 132)");
            barDataSet.setBorderWidth(1);
            List<Object> dataValPendiente = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValPendiente.add(sp.getEstadisticaCierre().getPendiente());
            }
            barDataSet.setData(dataValPendiente);

            BarChartDataSet barDataSet2 = new BarChartDataSet();
            barDataSet2.setLabel(rf.fromMessage("label.progreso"));
            barDataSet2.setBackgroundColor("rgb(54, 162, 235)");
//            barDataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
            barDataSet2.setBorderColor("rgb(255, 159, 64)");
            barDataSet2.setBorderWidth(1);
           List<Object> dataValProgreso = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValProgreso.add(sp.getEstadisticaCierre().getProgreso());
            }

            barDataSet2.setData(dataValProgreso);

            
            BarChartDataSet barDataSet3 = new BarChartDataSet();
            barDataSet3.setLabel(rf.fromMessage("label.finalizado"));
            barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
//            barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
            barDataSet3.setBorderColor("rgb(255, 159, 64)");
            barDataSet3.setBorderWidth(1);
             List<Object> dataValFinalizado = new ArrayList<>();
            for (Sprint sp : sprintList) {
                dataValFinalizado.add(sp.getEstadisticaCierre().getFinalizado());
            }

            barDataSet3.setData(dataValFinalizado);

            barDataSet3.setData(dataValFinalizado);

            data.addChartDataSet(barDataSet);
            data.addChartDataSet(barDataSet2);
            data.addChartDataSet(barDataSet3);
 List<String> labels = new ArrayList<>();

            for (Sprint sp : sprintList) {

                labels.add(sp.getSprint() + " [" + FacesUtil.redondear(sp.getEstadisticaCierre().getAvance(), 2) + "%]");
            }

            data.setLabels(labels);
            stackedBarModel.setData(data);

            //Options
            BarChartOptions options = new BarChartOptions();
            options.setMaintainAspectRatio(false);
            CartesianScales cScales = new CartesianScales();
            CartesianLinearAxes linearAxes = new CartesianLinearAxes();
            linearAxes.setOffset(true);
            linearAxes.setBeginAtZero(true);
            CartesianLinearTicks ticks = new CartesianLinearTicks();
            linearAxes.setTicks(ticks);
            cScales.addYAxesData(linearAxes);
            options.setScales(cScales);

            Title title = new Title();
            title.setDisplay(true);
            title.setText("Bar Chart");
            options.setTitle(title);

            stackedBarModel.setOptions(options);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    public void createBarModel2X() {
        stackedBarModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel(rf.fromMessage("label.pendiente"));
        barDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        barDataSet.setBorderColor("rgb(255, 99, 132)");
        barDataSet.setBorderWidth(1);
        List<Object> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        barDataSet.setData(values);

        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel(rf.fromMessage("label.progreso"));
        barDataSet2.setBackgroundColor("rgba(255, 159, 64, 0.2)");
        barDataSet2.setBorderColor("rgb(255, 159, 64)");
        barDataSet2.setBorderWidth(1);
        List<Object> values2 = new ArrayList<>();
        values2.add(85);
        values2.add(69);
        values2.add(20);
        values2.add(51);
        values2.add(76);
        values2.add(75);
        values2.add(10);
        barDataSet2.setData(values2);

        BarChartDataSet barDataSet3 = new BarChartDataSet();
        barDataSet3.setLabel(rf.fromMessage("label.finalizado"));
        barDataSet3.setBackgroundColor("rgb(75, 192, 192)");
        barDataSet3.setBorderColor("rgb(255, 159, 64)");
        barDataSet3.setBorderWidth(1);
        List<Object> values3 = new ArrayList<>();
        values3.add(85);
        values3.add(69);
        values3.add(20);
        values3.add(51);
        values3.add(76);
        values3.add(75);
        values3.add(10);
        barDataSet3.setData(values3);

        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        data.addChartDataSet(barDataSet3);

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        stackedBarModel.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        stackedBarModel.setOptions(options);
    }

    @Override
    public void onRowReorderTarea(ReorderEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRowReorderComentario(ReorderEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRowReorderImpedimento(ReorderEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRowReorderEtiqueta(ReorderEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onRowReorderArchivo(ReorderEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String refreshCache(Tarjeta tarjeta, String command) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeAddComentario(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeAddEtiqueta(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeAddArchivo(Tarjeta tarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // <editor-fold defaultstate="collapsed" desc="handleCloseDialogComentario(CloseEvent event)">

    @Override
    public void handleCloseDialogComentario(CloseEvent event) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

    @Override
    public void handleCloseDialogTarea(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCloseDialogImpedimento(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCloseDialogEtiqueta(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCloseDialogArchivo(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCloseDialogColaborador(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void handleCloseDialogEditar(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // <editor-fold defaultstate="collapsed" desc="void handleCloseDialogRefresh(CloseEvent event)">

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // </editor-fold>

    @Override
    public String refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
