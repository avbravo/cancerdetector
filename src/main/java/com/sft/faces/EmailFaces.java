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
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.sft.commons.emails.EmailSenderEvent;
import com.sft.model.DepartamentView;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Role;
import com.sft.model.User;
import com.sft.services.ProyectoServices;
import com.sft.services.ProyectoViewServices;
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
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.ResponsiveOption;
import com.sft.services.ColorManagement;
import com.sft.faces.services.SprintFacesServices;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.domain.UserViewDomain;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.security.LoginFaces;
import com.sft.services.CentralViewServices;
import com.sft.services.DepartamentViewServices;
import com.sft.services.RoleServices;
import com.sft.services.UserServices;
import com.sft.commons.emails.EmailServices;
import jakarta.enterprise.event.Event;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.file.UploadedFile;
import com.sft.commons.emails.EmailSender;
import com.sft.model.Archivo;
import jakarta.annotation.PreDestroy;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class EmailFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices {

    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;

    private String tituloEmail = "";
    private String mensajeEmail = "";
    private User userLogged = new User();
    private String message = "";
    private String tituloDialogo = "";
    private String fileRepositoryDirectory = "";
    private String passwordRepetido = "";
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;
    List<UserViewDomain> userViewDomainList = new ArrayList<>();

    private UploadedFile file;
    private Boolean fileWasUploaded = false;
    private Boolean isFileImagen = Boolean.FALSE;
    private String pathFile = "";
    private String nameFile = "";

    private Proyecto proyectoSelected = new Proyecto();

    private Boolean buttonNewPressed = Boolean.TRUE;
    private Boolean showDialogContent = Boolean.TRUE;
    private DepartamentView departamentViewSelected = new DepartamentView();
    private Role roleSelected = new Role();

    // Invocados desde otro fomulario
    private Boolean isEditable = Boolean.TRUE;
    private String callerLevel0 = "";
    private Profile profileLogged = new Profile();
    private Boolean isChangeInRowDatatableProfile = Boolean.FALSE;

    private User userSelected = new User();
    private User userDB = new User();

    private List<ResponsiveOption> responsiveOptions;
    List<Profile> profileApplicativeList = new ArrayList<>();
    List<Profile> otrosProfileList = new ArrayList<>();
    List<Profile> profileList = new ArrayList<>();
    List<Profile> profileOldList = new ArrayList<>();
    List<DepartamentView> departamentViewList = new ArrayList<>();
    List<Role> roleList = new ArrayList<>();

    private List<User> userList = new ArrayList<>();
    private List<User> userDataTableList = new ArrayList<>();

    private Boolean isRowPageSmall = Boolean.TRUE;

    ColorManagement colorKnob = new ColorManagementImpl();
    private DataTable dataTable;
    Integer totalRecords = 0;
    /**
     * Password
     */
    Boolean alMenos9Caracteres = Boolean.FALSE;
    Boolean alMenosLetraMinuscula = Boolean.FALSE;
    Boolean alMenosLetraMayuscula = Boolean.FALSE;
    Boolean alMenosUnNumero = Boolean.FALSE;
    Boolean alMenosCaracterEspecial = Boolean.FALSE;
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
    
 
     public User getUserSelected() {
          if(userSelected == null){         
            userSelected = new User();
        }
        return userSelected ;
    }
     public DepartamentView getDepartamentViewSelected() {
          if(departamentViewSelected== null){         
            departamentViewSelected = new DepartamentView();
        }
        return departamentViewSelected ;
    }
     public Role getRoleSelected () {
          if(roleSelected== null){         
               roleSelected = new Role();
        }
        return roleSelected;
    }
     public Proyecto getProyectoSelected() {
          if(proyectoSelected== null){         
               proyectoSelected = new Proyecto();
        }
        return proyectoSelected;
    }
     
     
     
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel">

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SecretKey()">
    private String secretKey = "SCox1jmWrkma$*opne2Amwz";
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
    EmailServices emailServices;
    @Inject
    LoginFaces loginFaces;
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
    CentralViewServices centralViewServices;
    @Inject
    DepartamentViewServices departamentViewServices;
    @Inject
    ProyectoServices proyectoServices;

    @Inject
    ProyectoViewServices proyectoViewServices;
    @Inject
    RoleServices roleServices;
    @Inject
    UserServices userServices;

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
            pathFile = "";
            nameFile = "";
            tituloEmail=""; 
            mensajeEmail="";
            message = "";
fileWasUploaded= Boolean.FALSE;
            userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
            profileLogged = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");

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

            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());
            if (JmoordbCoreContext.get("DashboardFaces.proyectoSelected") == null) {
                //  ConsoleUtil.info("proyectoSelected es null");
            } else {
                proyectoSelected = (Proyecto) JmoordbCoreContext.get("DashboardFaces.proyectoSelected");

            }

            prepararDestinatario();

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

    // <editor-fold defaultstate="collapsed" desc="String prepararDestinatario()">
    public String prepararDestinatario() {
        try {

            /**
             * Carga la lista de userViewDomain
             */
            userViewDomainList = new ArrayList<>();
            Boolean found = Boolean.TRUE;
            for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {

                UserViewDomain userViewDomain = new UserViewDomain(found, pm.getUserView());
                userViewDomainList.add(userViewDomain);
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void sendEmail()">

    public void sendEmail() {
        try {

            if (tituloEmail == null || tituloEmail.equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.tituloemail"));
                return;
            }
            if (mensajeEmail == null || mensajeEmail.equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.mensajeemail"));
                return;
            }
            mensajeEmail =  rf.fromMessage("email.proyecto")+ " <strong>"+proyectoSelected.getProyecto() + " </strong> <br>" +rf.fromMessage("email.enviadopor") + "" + userLogged.getName() + "<br>" + mensajeEmail + "<br><br>";
            if (userViewDomainList == null || userViewDomainList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nohaydestinatariosemail"));
                return;
            }
            List<String> emailList = new ArrayList<>();
            for (UserViewDomain uvd : userViewDomainList) {

                emailList.add(uvd.getUserView().getEmail());
            }
            if (emailList == null || emailList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nohaydestinatariosemail"));
                return;
            }
            
tituloEmail +=  " "+rf.fromConfiguration("application.shorttitle");
            
            EmailSender emailSender = new EmailSender.Builder()
                    .header(tituloEmail)
                    .messages(mensajeEmail)
                    .pathFile(pathFile)
                    .nameFile(nameFile)
                    .emailList(emailList)
                    .build();

            emailSenderEvent.fire(new EmailSenderEvent(emailSender));
            FacesUtil.successMessage(rf.fromMessage("info.emailexitoso"));


            tituloEmail = "";
            mensajeEmail = "";
            pathFile = "";
            nameFile = "";
            fileWasUploaded= Boolean.FALSE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void onCellEditColaborador(CellEditEvent event)">
    public void onCellEditColaborador(CellEditEvent event) {

        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {

        }
        //    PrimeFaces.current().ajax().update("datatableTareaFooter");

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener(FileUploadEvent event)">
    public String fileUploadListener(FileUploadEvent event) {
        try {
            pathFile = "";
            nameFile = "";
            fileWasUploaded = false;
            isFileImagen = Boolean.FALSE;
         
            file = event.getFile();
            Archivo archivo = new Archivo("", JmoordbCoreDateUtil.fechaHoraActual(), "", "", Boolean.FALSE);
            if (file != null) {
            
      
                String description =file.getFileName().substring(0, file.getFileName().indexOf("."));
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
                     
//                        pathFile = (archivo.getPath().replaceAll(FacesUtil.userHome(), ""));
                         pathFile = archivo.getPath();
                        nameFile =  archivo.getDescripcion();
                    
                    } else {
                                pathFile = archivo.getPath();
                        nameFile =  archivo.getDescripcion();
                    }

             

                } else {
                    //  archivo.setPath(FacesUtil.saveImage(file, archivo.getPath(), fileRepositoryDirectory));
          
                    createFile(file, archivo);
            
                    pathFile = archivo.getPath();
                    nameFile =  archivo.getDescripcion();

                }
            }
         
               if (fileWasUploaded) {
            
                FacesUtil.successMessage(rf.fromMessage("info.archivosubido"));
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
    
// <editor-fold defaultstate="collapsed" desc="String deleteFile()">

    public String deleteFile(){
        try {
            nameFile="";
            pathFile="";
            fileWasUploaded= Boolean.FALSE;
         } catch (Exception e) {
         
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
    // </editor-fold>
}
