/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.util.JmoordbCoreUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.converter.services.DiagnosticoConverterServices;
import com.sft.converter.services.EtiquetadoimagenConverterServices;
import com.sft.converter.services.MotivoConverterServices;
import com.sft.converter.services.PcritsConverterServices;
import com.sft.converter.services.ResultadocultivoConverterServices;
import com.sft.faces.services.FacesServices;
import com.sft.faces.services.implementation.AnalisisFacesServices;
import com.sft.media.JmoordbCoreMediaManagerX;
import com.sft.model.Analisis;
import com.sft.model.Archivo;
import com.sft.model.Diagnostico;
import com.sft.model.Etiquetadoimagen;
import com.sft.model.Motivo;
import com.sft.model.Pcrits;
import com.sft.model.PresenciaEpitales;
import com.sft.model.PresenciaLeucocitos;
import com.sft.model.PresenciaLevaduras;
import com.sft.model.Profile;
import com.sft.model.Resultadocultivo;
import com.sft.model.User;
import com.sft.services.AnalisisServices;
import com.sft.services.DiagnosticoServices;
import com.sft.services.EtiquetadoimagenServices;
import com.sft.services.MotivoServices;
import com.sft.services.PcritsServices;
import com.sft.services.ResultadocultivoServices;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SlideEndEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class AnalisisFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, AnalisisFacesServices, FacesServices {

    private static final long serialVersionUID = 1L;
// <editor-fold defaultstate="collapsed" desc="ConverterServices">

    @Inject
    MotivoConverterServices motivoConverterServices;
    @Inject
    DiagnosticoConverterServices diagnosticoConverterServices;
    @Inject
    PcritsConverterServices pcritsConverterServices;
    @Inject
    EtiquetadoimagenConverterServices etiquetadoimagenConverterServices;

    @Inject
    ResultadocultivoConverterServices resultadocultivoConverterServices;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaManagerX jmoordbCoreMediaManagerX;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;

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

// #Websocket    
    @Inject
    @ConfigProperty(name = "websocket.minimums.seconds.for.update")
    private Provider<Integer> websocketMinimumsSecondsForUpdate;

    // # Converter
    @Inject
    @ConfigProperty(name = "converter.max.number.of.elements")
    private Provider<Integer> converterMaxNumberOfElements;

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

    // TableroForm
    @Inject
    @ConfigProperty(name = "showMessagesOfActionInFormTablero", defaultValue = "false")
    private Provider<Boolean> showMessagesOfActionInFormTablero;

    @Inject
    @ConfigProperty(name = "minimoCarecteresDialogoObservacion", defaultValue = "0")
    private Provider<Integer> minimoCarecteresDialogoObservacion;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    AnalisisServices analisisServices;

    @Inject
    DiagnosticoServices diagnosticoServices;

    @Inject
    EtiquetadoimagenServices etiquetadoimagenServices;

    @Inject
    MotivoServices motivoServices;

    @Inject
    PcritsServices pcritsServices;

    @Inject
    ResultadocultivoServices resultadocultivoServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="fields()">
    
    private User userLogged = new User();
        private Profile profileLogged = new Profile();
    private Analisis analisisSelected = new Analisis();

    private List<Motivo> motivos = new ArrayList<>();
    private Motivo motivoSelected = new Motivo();
    private String motivoSelectedString = new String("");
    private String otroMotivo = "";

    private List<Diagnostico> diagnosticos = new ArrayList<>();
    private Diagnostico diagnosticoSelected = new Diagnostico();
    private String diagnosticoSelectedString = new String("");

    private List<Pcrits> pcritss = new ArrayList<>();

    private List<Pcrits> pcritsSelected = new ArrayList<>();
    private List<String> pcritssSelectedString = new ArrayList<>();
    private List<Etiquetadoimagen> etiquetadoimagens = new ArrayList<>();
    private List<Etiquetadoimagen> etiquetadoimagenSelected = new ArrayList<>();
    private List<String> etiquetadoimagenSelectedString = new ArrayList<>();

    private List<Resultadocultivo> resultadocultivos = new ArrayList<>();
    private List<Resultadocultivo> resultadocultivoSelected = new ArrayList<>();
    private List<String> resultadocultivoSelectedString = new ArrayList<>();

    private String fileRepositoryDirectory = "";
    private UploadedFile file;
    private Boolean fileWasUploaded = false;

    private Boolean isFileImagen = Boolean.FALSE;

    /**
     * Descargar y visualizar imagenes
     */
    StreamedContent media = null;

    InputStream is = null;

    private StreamedContent fileDownload;
    Archivo archivo1 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo2 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo3 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo4 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo5 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo6 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo7 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo8 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo9 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo10 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
    Archivo archivo11 = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);

    private String selectOneRadioEpitales = "0";
    private String selectOneRadioLevaduras = "0";
    private String selectOneRadioLeucocitos = "0";
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">

    public Analisis getAnalisisSelected() {
        if (analisisSelected == null) {
            analisisSelected = new Analisis();
        }
        return analisisSelected;
    }

    // </editor-fold>
    @PostConstruct
    public void init() {
        try {
        userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
            otroMotivo = "";
            findAllMotivo();
            findAllDiagnostico();
            findAllPcrits();
            findAllEtiquetadoimagen();
            findAllResultadocultivo();
            motivoSelectedString = motivos.getFirst().getMotivo();
            diagnosticoSelectedString = diagnosticos.getFirst().getDiagnostico();
            pcritssSelectedString.add(pcritss.getFirst().getPcrits());
            etiquetadoimagenSelectedString.add(etiquetadoimagens.getFirst().getEtiquetadoimagen());
            resultadocultivoSelectedString.add(resultadocultivos.getFirst().getResultadocultivo());

            prepareNew();
            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="String prepareNew()">
    public String prepareNew() {
        try {
            selectOneRadioEpitales = "0";
            selectOneRadioLevaduras = "0";
            selectOneRadioLeucocitos = "0";

            analisisSelected = new Analisis();
            analisisSelected.setEdad(0.0);
            analisisSelected.setNumeromuestra(0L);
            analisisSelected.setCtpcrpositiva(0.0);
            PresenciaLeucocitos presenciaLeucocitos = new PresenciaLeucocitos(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, 0.0);
            PresenciaEpitales presenciaEpitales = new PresenciaEpitales(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, 0.0);
            PresenciaLevaduras presenciaLevaduras = new PresenciaLevaduras(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, 0.0);
            analisisSelected.setPresenciaLeucocitos(presenciaLeucocitos);
            analisisSelected.setPresenciaEpitales(presenciaEpitales);
            analisisSelected.setPresenciaLevaduras(presenciaLevaduras);
            analisisSelected.setEscalanuggetobservador(2);
            analisisSelected.setFecha(JmoordbCoreDateUtil.fechaHoraActual());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAllMotivo()">
    public String findAllMotivo() {
        try {

            Bson filter = eq("activo", Boolean.TRUE);

            Document sort = new Document("idmotivo", 1);

            motivos = motivoServices.lookup(filter, sort, 0, 0);

            motivoConverterServices.add(motivos.subList(0,
                    calcularConverterMaxNumberOfElements(motivos.size(), motivos.size()))
            );

        } catch (Exception e) {
            // FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAllDiagnostico()">

    public String findAllDiagnostico() {
        try {

            Bson filter = eq("activo", Boolean.TRUE);

            Document sort = new Document("iddiagnostico", 1);

            diagnosticos = diagnosticoServices.lookup(filter, sort, 0, 0);

            diagnosticoConverterServices.add(diagnosticos.subList(0,
                    calcularConverterMaxNumberOfElements(diagnosticos.size(), diagnosticos.size()))
            );

        } catch (Exception e) {
            // FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAllPcrits()">

    public String findAllPcrits() {
        try {

            Bson filter = eq("activo", Boolean.TRUE);

            Document sort = new Document("idpcrits", 1);

            pcritss = pcritsServices.lookup(filter, sort, 0, 0);
            pcritsConverterServices.add(pcritss.subList(0,
                    calcularConverterMaxNumberOfElements(pcritss.size(), pcritss.size()))
            );
        } catch (Exception e) {
            // FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAllEtiquetadoimagen()">

    public String findAllEtiquetadoimagen() {
        try {

            Bson filter = eq("activo", Boolean.TRUE);

            Document sort = new Document("idetiquetadoimagen", 1);

            etiquetadoimagens = etiquetadoimagenServices.lookup(filter, sort, 0, 0);

            etiquetadoimagenConverterServices.add(etiquetadoimagens.subList(0,
                    calcularConverterMaxNumberOfElements(etiquetadoimagens.size(), etiquetadoimagens.size()))
            );
        } catch (Exception e) {
            // FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String findAllResultadocultivo()">

    public String findAllResultadocultivo() {
        try {

            Bson filter = eq("activo", Boolean.TRUE);

            Document sort = new Document("idresultadocultivo", 1);

            resultadocultivos = resultadocultivoServices.lookup(filter, sort, 0, 0);

            etiquetadoimagenConverterServices.add(etiquetadoimagens.subList(0,
                    calcularConverterMaxNumberOfElements(etiquetadoimagens.size(), etiquetadoimagens.size()))
            );
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    @PreDestroy
    @Override
    public void preDestroy() {
        motivoConverterServices.destroyed();
    }

    @Override
    public String refresh() {
        try {

            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public void handleCloseDialogRefresh(CloseEvent event) {
        refresh();
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
        int n = (int) event.getValue();
        if (n < 1 || n > 10) {
            analisisSelected.setEscalanuggetobservador(2);
            FacesUtil.errorMessage("Valores deben estar entre 1 y 10");
        }

    }

    public String save(Analisis analisis) {
        try {
           
            if(analisis.getNhc()== null){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.ingresenhc"));
                return "";
            }
            if(analisis.getNumeromuestra()== null){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.ingresenumeromuestra"));
                return "";
            }
            if(analisis.getEdad()== null){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.ingreseedad"));
                return "";
            }
            if(motivoSelectedString == null || motivoSelectedString.equals("")){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.seleccionemotivo"));
                return "";
            }
            if(diagnosticoSelectedString == null || diagnosticoSelectedString.equals("")){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.seleccionediagnostico"));
                return "";
            }
            if(analisis.getCultivoorina() == null || analisis.getCultivoorina().equals("")){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.seleccionecultivoorina"));
                return "";
            }
           
            if(analisis.getImagencondiscrepancia()== null || analisis.getImagencondiscrepancia().equals("")){
                FacesUtil.warningDialog(rf.fromMessage("warning.warning"), rf.fromMessage("warning.seleccioneimagencondiscrepancia"));
                return "";
            }
            
            
            analisis.setUser(userLogged);
            
            var motivo = motivoConverterServices.get(motivoSelectedString);
            analisis.setMotivo(motivo.get());

            var diagnostico = diagnosticoConverterServices.get(diagnosticoSelectedString);
            analisis.setDiagnostico(diagnostico.get());

            List<Pcrits> pcriptsList = new ArrayList<>();
            for (String s : pcritssSelectedString) {
                var pcrits = pcritsConverterServices.get(s);
                pcriptsList.add(pcrits.get());

            }
            analisis.setPcrits(pcriptsList);

            List<Etiquetadoimagen> etiquetadoimagenList = new ArrayList<>();
            for (String s : etiquetadoimagenSelectedString) {
                var etiquetadoimagen = etiquetadoimagenConverterServices.get(s);
                etiquetadoimagenList.add(etiquetadoimagen.get());

            }

            analisis.setEtiquetadoimagen(etiquetadoimagenList);

            List<Resultadocultivo> resultadocultivoList = new ArrayList<>();
            for (String s : resultadocultivoSelectedString) {
                var resultadocultivo = resultadocultivoConverterServices.get(s);
                resultadocultivoList.add(resultadocultivo.get());

            }

            analisis.setResultadocultivo(resultadocultivoList);

            /**
             * Archivo
             */
            List<Archivo> archivos = Arrays.asList(archivo1, archivo2, archivo3, archivo4, archivo5, archivo6, archivo7, archivo8, archivo9, archivo10, archivo11);
            analisis.setArchivo(archivos);
            if (!analisisServices.save(analisis).isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.save"));
                ConsoleUtil.test("\tNo se guardo.");

            } else {
                FacesUtil.successMessage(rf.fromCore("info.save"));
                ConsoleUtil.test("\t Guardado existosamente");
            }
            prepareNew();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    public void onInputChanged(ValueChangeEvent event) {
//        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
//        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener1(FileUploadEvent event)">
    public String fileUploadListener1(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo1, fileUploadListenerGeneric(event, 1));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener2(FileUploadEvent event)">
    public String fileUploadListener2(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo2, fileUploadListenerGeneric(event, 2));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener3(FileUploadEvent event)">
    public String fileUploadListener3(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo3, fileUploadListenerGeneric(event, 3));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener4(FileUploadEvent event)">
    public String fileUploadListener4(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo4, fileUploadListenerGeneric(event, 4));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener5(FileUploadEvent event)">
    public String fileUploadListener5(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo5, fileUploadListenerGeneric(event, 5));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener6(FileUploadEvent event)">
    public String fileUploadListener6(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo6, fileUploadListenerGeneric(event, 6));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener7(FileUploadEvent event)">
    public String fileUploadListener7(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo7, fileUploadListenerGeneric(event, 7));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener8(FileUploadEvent event)">

    public String fileUploadListener8(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo8, fileUploadListenerGeneric(event, 8));
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener9(FileUploadEvent event)">

    public String fileUploadListener9(FileUploadEvent event) {
        try {

            JmoordbCoreUtil.copyBeans(archivo9, fileUploadListenerGeneric(event, 9));

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener10(FileUploadEvent event)">

    public String fileUploadListener10(FileUploadEvent event) {
        try {
//archivo10
            JmoordbCoreUtil.copyBeans(archivo10, fileUploadListenerGeneric(event, 10));

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener11(FileUploadEvent event)">
    public String fileUploadListener11(FileUploadEvent event) {
        try {
//archivo10
            JmoordbCoreUtil.copyBeans(archivo11, fileUploadListenerGeneric(event, 11));

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener10(FileUploadEvent event, Integer imagePosition))">
    public Archivo fileUploadListenerGeneric(FileUploadEvent event, Integer imagePosition) {
        Archivo result = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
        try {

            fileWasUploaded = false;
            isFileImagen = Boolean.FALSE;
            file = event.getFile();
            result = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
            if (file != null) {

                String description = file.getFileName().substring(0, file.getFileName().indexOf("."));
                result.setDescripcion(description);
                String fileExt = FacesUtil.getFileExt(file);
                result.setExtension(fileExt);

                if (fileExt.equals(".gif")
                        || fileExt.equals(".jpg")
                        || fileExt.equals(".jpeg")
                        || fileExt.equals(".png")) {

                    if (!FacesUtil.checkImage(file)) {
                        FacesUtil.errorMessage(rf.fromCore("field.noimagen"));

                        return result;
                    } else {

                        isFileImagen = Boolean.TRUE;
                    }
                }

                fileWasUploaded = Boolean.TRUE;

                // isFileImagen = Boolean.TRUE;
                if (isFileImagen) {

                    result.setPath(FacesUtil.saveImage(file, result.getPath(), fileRepositoryDirectory));
                    if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                        result.setPath(result.getPath().replaceAll(FacesUtil.userHome(), ""));
                    } else {

                    }

                    //  agregarRowArchivo(archivo);
                } else {

                    createFile(file, result);

                    if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {

                        result.setPath(result.getPath().replaceAll(FacesUtil.userHome(), ""));

                    } else {

                    }

                    //agregarRowArchivo(archivo);
                }

                if (fileWasUploaded) {

                    saveToMediaContext(result.getPath(), result.getDescripcion(), imagePosition);
                    FacesUtil.successMessage(rf.fromMessage("info.archivosubido"));
                } else {
//                    ConsoleUtil.test("\t no fue subido.");
                }
            }
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void createFile(UploadedFile file) ">
    private void createFile(UploadedFile file, Archivo archivo) {
        try {
            ConsoleUtil.test("\t\t....................................................." + FacesUtil.nameOfClassAndMethod());
            ConsoleUtil.test("\t\t...paso 1");
            archivo.setDescripcion(file.getFileName());
            ConsoleUtil.test("\t\t...paso 2 " + archivo.getDescripcion());
            String nombre = FacesUtil.generarNombre();
            ConsoleUtil.test("\t\t...paso 3 " + nombre);
            if (FacesUtil.copyFile(nombre + FacesUtil.getFileExt(file), file.getInputStream(), fileRepositoryDirectory)) {
                ConsoleUtil.test("\t\t...paso 4");
                String archivoPath = fileRepositoryDirectory + nombre + FacesUtil.getFileExt(file);
                ConsoleUtil.test("\t\t...paso 4.a archivoPath " + archivoPath);
                archivo.setPath(archivoPath);

            } else {
                ConsoleUtil.test("\t\t...paso 5 ");
            }
        } catch (Exception e) {
            ConsoleUtil.test("\t\t...paso 6 ");
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
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
            ConsoleUtil.test("\t pathOfFile " + pathOfFile);
            ConsoleUtil.test("\t nameOfFile " + nameOfFile);

            jmoordbCoreMediaContext.put("pathOfFile", pathOfFile);
            jmoordbCoreMediaContext.put("nameOfFile", name);
            jmoordbCoreMediaManager.init();
            PrimeFaces.current().ajax().update("file1");
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String saveToMediaContext(String pathOfFile, String... nameOfFile)">
    public String saveToMediaContext(String pathOfFile, String nameOfFile, Integer positionOfImage) {
        try {

            if (!pathBaseLinuxAddUserHomeStoreInCollections.get()) {
                pathOfFile = FacesUtil.userHome() + pathOfFile;

            }

            JmoordbCoreContext.put("pathOfFile" + positionOfImage, pathOfFile);
            JmoordbCoreContext.put("nameOfFile" + positionOfImage, nameOfFile);

            PrimeFaces.current().ajax().update("file" + positionOfImage);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void inputTextLeucocitos(AjaxBehaviorEvent event)">
    public void inputTextLeucocitos(AjaxBehaviorEvent event) {
        try {
            var valor = analisisSelected.getPresenciaLeucocitos().getValor();
            selectOneRadioLeucocitos = "0";

            analisisSelected.getPresenciaLeucocitos().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaLeucocitos().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setZero(Boolean.FALSE);

            if (valor.equals(0)) {
                analisisSelected.getPresenciaLeucocitos().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {
                    selectOneRadioLeucocitos = "1";
                    analisisSelected.getPresenciaLeucocitos().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5 && valor <= 29) {
                        selectOneRadioLeucocitos = "5-29";
                        analisisSelected.getPresenciaLeucocitos().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {
                            selectOneRadioLeucocitos = ">30";
                            analisisSelected.getPresenciaLeucocitos().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void inputTextLevadura(AjaxBehaviorEvent event)">

    public void inputTextLevaduras(AjaxBehaviorEvent event) {
        try {
            var valor = analisisSelected.getPresenciaLevaduras().getValor();
            analisisSelected.getPresenciaLevaduras().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaLevaduras().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setZero(Boolean.FALSE);
            selectOneRadioLevaduras = "0";

            ConsoleUtil.test("\t[[valor de veladuras]]" +analisisSelected.getPresenciaLevaduras().getValor());
            if (valor.equals(0)) {
                analisisSelected.getPresenciaLevaduras().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {
                    selectOneRadioLevaduras = "1";
                    analisisSelected.getPresenciaLevaduras().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5.0 && valor <= 29.0) {
                        selectOneRadioLevaduras = "5-29";
                        analisisSelected.getPresenciaLevaduras().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {
                            selectOneRadioLevaduras = ">30";
                            analisisSelected.getPresenciaLevaduras().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void inputTextEpitales(AjaxBehaviorEvent event)">

    public void inputTextEpitales(AjaxBehaviorEvent event) {
        try {
            var valor = analisisSelected.getPresenciaEpitales().getValor();
            selectOneRadioEpitales = "0";
            analisisSelected.getPresenciaEpitales().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaEpitales().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setZero(Boolean.FALSE);

            if (valor.equals(0)) {
                analisisSelected.getPresenciaEpitales().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {
                    selectOneRadioEpitales = "1";
                    analisisSelected.getPresenciaEpitales().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5 && valor <= 29) {
                        selectOneRadioEpitales = "5-29";
                        analisisSelected.getPresenciaEpitales().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {
                            selectOneRadioEpitales = ">30";
                            analisisSelected.getPresenciaEpitales().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="changeSelectOneRadioLeucocitos(AjaxBehaviorEvent event)">
    public void changeSelectOneRadioLeucocitos(AjaxBehaviorEvent event) {
        try {
            analisisSelected.getPresenciaLeucocitos().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaLeucocitos().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaLeucocitos().setZero(Boolean.FALSE);
            Double valor = 0.0;
            if (selectOneRadioLeucocitos.equals(">30")) {
                valor = 30.0;
            } else {
                if (selectOneRadioLeucocitos.equals("5-29")) {
                    valor = 5.0;
                } else {
                    valor = Double.parseDouble(selectOneRadioLeucocitos);
                }

            }

            analisisSelected.getPresenciaLeucocitos().setValor(valor);
            if (valor.equals(0)) {
                analisisSelected.getPresenciaLeucocitos().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {

                    analisisSelected.getPresenciaLeucocitos().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5 && valor <= 29) {

                        analisisSelected.getPresenciaLeucocitos().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {

                            analisisSelected.getPresenciaLeucocitos().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="changeSelectOneRadioLevaduras(AjaxBehaviorEvent event)">

    public void changeSelectOneRadioLevaduras(AjaxBehaviorEvent event) {
        try {
            analisisSelected.getPresenciaLevaduras().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaLevaduras().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaLevaduras().setZero(Boolean.FALSE);
            Double valor = 0.0;
            if (selectOneRadioLevaduras.equals(">30")) {
                valor = 30.0;
            } else {
                if (selectOneRadioLevaduras.equals("5-29")) {
                    valor = 5.0;
                } else {
                    valor = Double.parseDouble(selectOneRadioLevaduras);
                }

            }

            analisisSelected.getPresenciaLevaduras().setValor(valor);
            if (valor.equals(0)) {
                analisisSelected.getPresenciaLevaduras().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {

                    analisisSelected.getPresenciaLevaduras().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5 && valor <= 29) {

                        analisisSelected.getPresenciaLevaduras().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {
                            selectOneRadioLevaduras = ">30";
                            analisisSelected.getPresenciaLevaduras().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="changeSelectOneRadioLevaduras(AjaxBehaviorEvent event)">

    public void changeSelectOneRadioEpitales(AjaxBehaviorEvent event) {
        try {
            analisisSelected.getPresenciaEpitales().setActivo(Boolean.TRUE);
            analisisSelected.getPresenciaEpitales().setFivetwentynine(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setTwofour(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setGreaterthan30(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setOne(Boolean.FALSE);
            analisisSelected.getPresenciaEpitales().setZero(Boolean.FALSE);
            Double valor = 0.0;
            
            ConsoleUtil.test("\t{selectOneRadioEpitales}"+selectOneRadioEpitales);
            if (selectOneRadioEpitales.equals(">30")) {
                valor = 30.0;
            } else {
                if (selectOneRadioEpitales.equals("5-29")) {
                    valor = 5.0;
                } else {
                    valor = Double.parseDouble(selectOneRadioEpitales);
                }

            }
            ConsoleUtil.test("\t:::>>>>{valor }"+valor);
            analisisSelected.getPresenciaEpitales().setValor(valor);
            if (valor.equals(0)) {
                analisisSelected.getPresenciaEpitales().setZero(Boolean.TRUE);
            } else {
                if (valor.equals(1.0)) {

                    analisisSelected.getPresenciaEpitales().setOne(Boolean.TRUE);
                } else {
                    if (valor >= 5 && valor <= 29) {

                        analisisSelected.getPresenciaLevaduras().setFivetwentynine(Boolean.TRUE);
                    } else {
                        if (valor >= 30) {

                            analisisSelected.getPresenciaEpitales().setGreaterthan30(Boolean.TRUE);
                        }
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
}
