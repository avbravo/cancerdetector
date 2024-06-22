/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import static com.mongodb.client.model.Filters.eq;
import com.sft.converter.services.DiagnosticoConverterServices;
import com.sft.converter.services.EtiquetadoimagenConverterServices;
import com.sft.converter.services.MotivoConverterServices;
import com.sft.converter.services.PcritsConverterServices;
import com.sft.converter.services.ResultadocultivoConverterServices;
import com.sft.faces.services.FacesServices;
import com.sft.faces.services.implementation.AnalisisFacesServices;
import com.sft.model.Analisis;
import com.sft.model.Diagnostico;
import com.sft.model.Etiquetadoimagen;
import com.sft.model.Motivo;
import com.sft.model.Pcrits;
import com.sft.model.PresenciaEpitales;
import com.sft.model.PresenciaLeucocitos;
import com.sft.model.PresenciaLevaduras;
import com.sft.model.Resultadocultivo;
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
import jakarta.faces.event.ValueChangeEvent;
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
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SlideEndEvent;

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
            prepareNew();

            otroMotivo = "";
            findAllMotivo();         
            findAllDiagnostico();
            findAllPcrits();
            findAllEtiquetadoimagen();
            findAllResultadocultivo();
             motivoSelectedString=motivos.getFirst().getMotivo();
             diagnosticoSelectedString=diagnosticos.getFirst().getDiagnostico();
             pcritssSelectedString.add(pcritss.getFirst().getPcrits());
             etiquetadoimagenSelectedString.add(etiquetadoimagens.getFirst().getEtiquetadoimagen());
             resultadocultivoSelectedString.add(resultadocultivos.getFirst().getResultadocultivo());
            
            prepareNew();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="String prepareNew()">
    public String prepareNew() {
        try {
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
            ConsoleUtil.test("\t{motivoSelectedString~{} "+motivoSelectedString);
            var motivo = motivoConverterServices.get(motivoSelectedString);
            analisis.setMotivo(motivo.get());
            
            var diagnostico = diagnosticoConverterServices.get(diagnosticoSelectedString); 
            analisis.setDiagnostico(diagnostico.get());
            
            List<Pcrits> pcriptsList = new ArrayList<>();
            for(String s:pcritssSelectedString){
                var pcrits =pcritsConverterServices.get(s); 
                pcriptsList.add(pcrits.get());
                
            }   
            analisis.setPcrits(pcriptsList);
            
            List<Etiquetadoimagen> etiquetadoimagenList = new ArrayList<>();
            for(String s:etiquetadoimagenSelectedString){
                var etiquetadoimagen =etiquetadoimagenConverterServices.get(s); 
               etiquetadoimagenList.add(etiquetadoimagen.get());
                
            }
            
            
            analisis.setEtiquetadoimagen(etiquetadoimagenList);
            
            
            List<Resultadocultivo> resultadocultivoList = new ArrayList<>();
            for(String s:resultadocultivoSelectedString){
                var resultadocultivo =resultadocultivoConverterServices.get(s); 
              resultadocultivoList.add(resultadocultivo.get());
                
            }
            
            
            analisis.setResultadocultivo(resultadocultivoList);
            
            
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
}
