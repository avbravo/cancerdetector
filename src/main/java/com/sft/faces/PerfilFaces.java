/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;
// <editor-fold defaultstate="collapsed" desc="import">

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
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
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

import com.sft.model.ActionHistory;
import com.sft.model.Archivo;
import com.sft.model.CentralView;
import com.sft.model.DepartamentView;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Role;
import com.sft.model.User;
import com.sft.model.UserView;
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
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.ResponsiveOption;
import com.sft.services.ColorManagement;
import com.sft.faces.services.SprintFacesServices;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Optional;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.security.LoginFaces;
import com.sft.services.CentralViewServices;
import com.sft.services.DepartamentViewServices;
import com.sft.services.RoleServices;
import com.sft.services.UserServices;
import jakarta.annotation.PreDestroy;
import jakarta.faces.component.UIColumn;
import jakarta.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.file.UploadedFile;
// </editor-fold>
/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class PerfilFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices , FacesServices{

    // <editor-fold defaultstate="collapsed" desc=" fields">
    private static final long serialVersionUID = 1L;
    private User userLogged = new User();
    private String message = "";
    private String tituloDialogo = "";
    private String fileRepositoryDirectory = "";
    private String passwordRepetido = "";
    private Boolean isOverlayPanelOpen = Boolean.FALSE;
    private Boolean isButtonSavePressed = Boolean.TRUE;
    private Boolean fueCambiadoPorOtroUsuario = Boolean.FALSE;

    private UploadedFile file;
    private Boolean fileWasUploaded = false;
    private Boolean isFileImagen = Boolean.FALSE;

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
          if(userSelected== null){         
               userSelected = new User();
        }
        return userSelected;
    }
     public Role getRoleSelected() {
          if(roleSelected== null){         
               roleSelected= new Role();
        }
        return roleSelected;
    }
     public DepartamentView getDepartamentViewSelected() {
          if(departamentViewSelected== null){         
               departamentViewSelected = new DepartamentView();
        }
        return departamentViewSelected;
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
    
    // <editor-fold defaultstate="collapsed" desc="set/get()">
    public User getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(User userLogged) {
        this.userLogged = userLogged;
    }
// </editor-fold>

    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    
    @Inject
    LoginFaces loginFaces;
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;

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

            message = "";

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
            
            
//               userSelected = userServices.findByIduser(userLogged.getIduser());
               prepareUser(userLogged);
               
         
            
//            loadDepartamentView();
//            loadRole();
//   userDataTableList = userServices.lookup(paginator.getFilter(),
//                    paginator.getSort(), paginator.getPage(), rowPageSmall.get());

     

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
    // <editor-fold defaultstate="collapsed" desc="String findAll()">
    public String findAll() {
        try {

            Bson filter = and(eq("iduser", userLogged.getIduser()),
                    eq("active", Boolean.TRUE)
            );
            Document sort = new Document("name", 1);

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .filter(filter)
                            .sort(sort)
                            .sorted(new Sorted(new Document("name", -1)))
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

    // <editor-fold defaultstate="collapsed" desc="loadDepartamentView()">
    public void loadDepartamentView() {
        try {
            Bson filter = and(eq("active", Boolean.TRUE),
                    eq("central.idcentral", userLogged.getCentralView().getIdcentral())
            );
            Document sort = new Document("departament", 1);
            departamentViewList = departamentViewServices.lookup(filter, sort, 0, 0);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void loadRole()">

    public void loadRole() {
        try {
            Bson filter = or(eq("active", Boolean.TRUE)
            );
            Document sort = new Document("role", 1);
            roleList = roleServices.lookup(filter, sort, 0, 0);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
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

    // <editor-fold defaultstate="collapsed" desc="saveUser(User user)">
    public void saveUser(User user) {
        try {

            userSelected = user;
            if (!userServices.validUser(user, passwordRepetido)) {
                return;
            }

            if (profileList == null || profileList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.agregueprofileuser"));
                return;
            }
            userSelected.setProfile(profileList);
            /**
             *
             */
            String encripter = Encryptor.encrypt(userSelected.getPassword(), secretKey);
            userSelected.setPassword(encripter);
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("crear")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            userSelected.setActionHistory(actionHistoryList);

            Optional<User> userOptional = userServices.save(userSelected);
            if (!userOptional.isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.save"), rf.fromCore("warning.save"));
            } else {
                userSelected = userOptional.get();

                FacesUtil.successMessage(rf.fromCore("info.save"));

                /**
                 * Actualiza las tarjetas
                 */
                PrimeFaces.current().ajax().update("dataTable");

                closeOverlayPanel("PF('overlayPanelUser').hide()");
                refresh();
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="editUser(User user)">

    public String editUser(User user) {
        try {

            Optional<User> userDBNow = userServices.findByIduser(user.getIduser());
            if(!userDBNow.isPresent()){
                  FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.idnotexist"));
                return "";
                
            }
            if (!userDBNow.get().equals(userDB)) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.otrousuarioactualizodocumentosincronicesusdatosprimero"));
                return "";
            }
            userSelected = user;
            
            if (!userServices.validUser(user, passwordRepetido)) {
                return "";
            }
            if (profileList == null || profileList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.agregueprofileuser"));
                return "";
            }

            otrosProfileList.addAll(profileList);
            userSelected.setProfile(otrosProfileList);

               Optional<User> userCedula = userServices.findByIdentificationcard(user.getIdentificationcard());
            if (userCedula.isPresent()) {
            
                if (!userCedula.get().getIduser().equals(user.getIduser())) {                    
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.useexistwithsameidentificationcar"));
                    return "";
                } 
            } 

            Optional<User> userEmail = userServices.findByEmail(user.getEmail());
            if (userEmail.isPresent()) {
                if (!userEmail.get().getIduser().equals(user.getIduser())) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.useexistwithsameemail"));
                    return "";
                }
            }
            
            
            String encripter = Encryptor.encrypt(userSelected.getPassword(), secretKey);
            userSelected.setPassword(encripter);

            if (DateUtil.fechaMayor(userSelected.getDateofbirth(), JmoordbCoreDateUtil.fechaHoraActual())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.fechacumpleanosnovalida"));
                return "";
            }

            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userLogged.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("editar")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
             actionHistoryList.addAll(user.getActionHistory());
            actionHistoryList.add(actionHistory);

            userSelected.setActionHistory(actionHistoryList);

            Boolean isUpdate = userServices.update(userSelected);
            if (!isUpdate) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.update"));
            } else {
JmoordbCoreUtil.copyBeans(userDB, userSelected);
//                JmoordbCoreContext.put("SprintFaces.sprintSelected", sprintSelected);
//                FacesUtil.infoDialog(rf.fromCore("info.update"), rf.fromCore("info.update"));
          //     FacesUtil.successMessage(rf.fromCore("info.update"));

                /**
                 * Actualiza las tarjetas
                 */
                //  sprintList.add(sprintSelected);
                //  PrimeFaces.current().ajax().update("dataTable");
                /**
                 * Actualiza el objeto en el Session
                 */
                loginFaces.setUserLogged(userSelected);
                
                  String passwordDecrypter = Encryptor.decrypt(userSelected.getPassword(), secretKey,FacesUtil.nameOfClassAndMethod() );
            userSelected.setPassword(passwordDecrypter);
            passwordRepetido = passwordDecrypter;
                 JmoordbCoreContext.put("LoginFaces.userLogged",userSelected);
                closeOverlayPanel("PF('overlayPanelUser').hide()");
                refresh();
 return "dashboard.xhtml";
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
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

    // <editor-fold defaultstate="collapsed" desc="void agregarRowUser()">
    public void agregarRowUser() {
        try {

            buttonNewPressed = Boolean.TRUE;
            showDialogContent = Boolean.TRUE;
            passwordRepetido = "";
            profileApplicativeList = new ArrayList<>();

            userSelected = new User();
            userSelected.setActive(Boolean.TRUE);
            userSelected.setPassword("change12A@*x");

            passwordRepetido = "change12A@*x";
            userSelected.setDateofbirth(JmoordbCoreDateUtil.fechaHoraActual());

            userSelected.setCentralView(userLogged.getCentralView());

            isButtonSavePressed = Boolean.FALSE;

            verificarTextoPassword();
            tituloDialogo = rf.fromMessage("dialog.useragregar");
            profileList = new ArrayList<>();
            profileOldList = new ArrayList<>();
            otrosProfileList = new ArrayList<>();

            PrimeFaces.current().ajax().update("outputPanelUser,form");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String refresh()">
    @Override
    public String refresh() {
        try {

            userList = new ArrayList<>();
            findAll();
            PrimeFaces.current().ajax().update("form");
            PrimeFaces.current().ajax().update("dataTable");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String prepareUser(User user)">
    public String prepareUser(User user) {
        try {
            userSelected = new User();
            showDialogContent = Boolean.TRUE;
               isOverlayPanelOpen = Boolean.TRUE;
            isButtonSavePressed = Boolean.TRUE;
            buttonNewPressed = Boolean.FALSE; 
                   
            userSelected = validarSiCambioUser(user);
        
            tituloDialogo = rf.fromMessage("dialog.usereditar");
            String passwordDecrypter = Encryptor.decrypt(userSelected.getPassword(), secretKey,FacesUtil.nameOfClassAndMethod() );
            userSelected.setPassword(passwordDecrypter);
            passwordRepetido = passwordDecrypter;
            verificarTextoPassword();
            profileList = new ArrayList<>();
            profileOldList = new ArrayList<>();
            otrosProfileList = new ArrayList<>();
            loadProfileByApplicative(userSelected);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="User validarSiCambioUser(User user)">
    private User validarSiCambioUser(User user) {
        User result = new User();
        try {
            message = "";
            fueCambiadoPorOtroUsuario = Boolean.FALSE;
           Optional<User>userDBOptional = userServices.findByIduser(user.getIduser());
            
             if(!userDBOptional.isPresent()){
                  FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.idnotexist"));
                       showDialogContent = Boolean.FALSE;
                return result;
                
            }
            this.userDB = userDBOptional.get();
            if (userDB.equals(user)) {
                result = user;
            } else {
                fueCambiadoPorOtroUsuario = Boolean.TRUE;
                message = rf.fromMessage("warning.otrousuarioactualizouserincronizeeltablero");
               JmoordbCoreUtil.copyBeans(result, userDB);
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
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titleuserall"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

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
            PdfPTable table = new PdfPTable(4);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{60, 70, 150, 60});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.iduser"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.username"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.identificationcard"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            //Invoca todos los registros con paginacion para imprimir
            Integer pageActual = 1;
            Integer totalPage = paginator.getNumberOfPage();
            //Carga los registros por paginacion
            for (int i = 1; i <= totalPage; i++) {

                pageActual = i;

                List<User> list = userServices.lookup(paginator.getFilter(),
                        paginator.getSort(), pageActual, rowPageSmall.get());

                if (list == null || list.isEmpty()) {

                } else {
                    list.forEach(c -> {

                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getIduser().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                        table.addCell(
                                ReportUtils.PdfCell(
                                        c.getUsername(), FontFactory.getFont("arial", 9, Font.NORMAL)));

                        table.addCell(
                                ReportUtils.PdfCell(c.getName(), FontFactory.getFont("arial", 10, Font.NORMAL)));
                        table.addCell(
                                ReportUtils.PdfCell(c.getIdentificationcard(), FontFactory.getFont("arial", 10, Font.NORMAL)));

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
    // <editor-fold defaultstate="collapsed" desc="String printTarjetaByUser(User user)">
    public String printTarjetaByUser(User user) {

//        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.A4.rotate());
        com.lowagie.text.Document document = new com.lowagie.text.Document(PageSize.LETTER.rotate());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            // METADATA

            document.open();
            document.add(
                    ReportUtils.paragraph(
                            rf.fromMessage("print.titlesuser"), FontFactory.getFont("arial", 12, Font.BOLD), Element.ALIGN_CENTER));

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
            PdfPTable table = new PdfPTable(4);

            // Aqui indicamos el tamaño de cada columna
            table.setTotalWidth(new float[]{60, 70, 150, 60});

            table.setLockedWidth(true);

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.iduser"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.username"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));
            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.name"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            rf.fromMessage("print.identificationcard"), FontFactory.getFont("arial", 11, Font.BOLD), Element.ALIGN_CENTER));

            table.addCell(
                    ReportUtils.PdfCell(
                            user.getIduser().toString(), FontFactory.getFont("arial", 10, Font.NORMAL)));
            table.addCell(
                    ReportUtils.PdfCell(
                            user.getUsername(), FontFactory.getFont("arial", 9, Font.NORMAL)));

            table.addCell(
                    ReportUtils.PdfCell(user.getName(), FontFactory.getFont("arial", 10, Font.NORMAL)));
            table.addCell(
                    ReportUtils.PdfCell(user.getIdentificationcard(), FontFactory.getFont("arial", 10, Font.NORMAL)));

            document.add(table);
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        document.close();

        ReportUtils.printPDF(baos);
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void sugerirEmail(AjaxBehaviorEvent event)">
    public void sugerirEmail(AjaxBehaviorEvent event) {
        try {

            
            userSelected.setEmail(userSelected.getUsername().trim() + "@utp.ac.pa");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Profile> loadProfileByApplicative(User user) ">
    public List<Profile> loadProfileByApplicative(User user) {
        profileApplicativeList = new ArrayList<>();
        try {

            Long id = 0L;
            Long idOtros = 0L;
            for (Profile p : user.getProfile()) {

                if (p.getApplicativeView().getIdapplicative().equals(idapplicative.get().longValue())) {
                    Profile profile = new Profile(id++, p.getApplicativeView(), p.getRole(), p.getDepartamentView(), p.getActive());
                    profileApplicativeList.add(profile);
                    profileList.add(profile);
                    profileOldList.add(profile);

                } else {
                    Profile profile = new Profile(idOtros++, p.getApplicativeView(), p.getRole(), p.getDepartamentView(), p.getActive());
                    otrosProfileList.add(p);
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return profileApplicativeList;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String String fileUploadListener(FileUploadEvent event)">

    public String fileUploadListener(FileUploadEvent event) {
        try {

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
                    if(!pathBaseLinuxAddUserHomeStoreInCollections.get()){
                        userSelected.setPhoto(archivo.getPath().replaceAll(FacesUtil.userHome(), "")); 
                    }else{
                         userSelected.setPhoto(archivo.getPath()); 
                    }
                    
                  

                } else {
                    //  archivo.setPath(FacesUtil.saveImage(file, archivo.getPath(), fileRepositoryDirectory));

                    createFile(file, archivo);

                    userSelected.setPhoto(archivo.getPath());

                }
                    if (fileWasUploaded) {
            
                FacesUtil.successMessage(rf.fromMessage("info.archivosubido"));
            }
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

    // <editor-fold defaultstate="collapsed" desc="List<CentralView> completeCentralView(String query)">
    public List<CentralView> completeCentralView(String query) {

        List<CentralView> result = new ArrayList<>();
        try {
            query = query.trim();
            result = cargarCentralView(query);

            //result = userViewList.stream().filter(t -> t.getName().toLowerCase().contains(query)).collect(Collectors.toList());
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<CentralView> cargarCentralView(String query)">
    private List<CentralView> cargarCentralView(String query) {

        List<CentralView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

            result = centralViewServices.likeByCentral(query);

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="verificarPassword(AjaxBehaviorEvent event)">
    public void verificarPassword(AjaxBehaviorEvent event) {
        try {

            verificarTextoPassword();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void verificarTextoPassword()">

    public void verificarTextoPassword() {
        try {

            alMenos9Caracteres = Boolean.FALSE;
            alMenosUnNumero = Boolean.FALSE;
            alMenosLetraMinuscula = Boolean.FALSE;
            alMenosLetraMayuscula = Boolean.FALSE;

            alMenosCaracterEspecial = Boolean.FALSE;
            char[] ch = userSelected.getPassword().toCharArray();
            int letter = 0;
            int space = 0;
            int num = 0;
            int other = 0;
            int lowercase = 0;
            int uppercase = 0;
            for (int i = 0; i < userSelected.getPassword().length(); i++) {
                if (Character.isLetter(ch[i])) {
                    letter++;
                    if (Character.isLowerCase(ch[i])) {
                        lowercase++;
                    } else if (Character.isUpperCase(ch[i])) {
                        uppercase++;
                    }

                } else if (Character.isDigit(ch[i])) {
                    num++;
                } else if (Character.isSpaceChar(ch[i])) {
                    space++;
                } else {
                    other++;
                }

                switch (ch[i]) {
                    case '@':
                    case '#':
                    case '$':
                    case '%':
                    case '*':
                    case '_':
                    case '?':
                    case '!':
                    case '.':
                        alMenosCaracterEspecial = Boolean.TRUE;

                        break;

                }

            }

            if (userSelected.getPassword().length() >= 9) {
                alMenos9Caracteres = Boolean.TRUE;
            }
            if (num > 0) {
                alMenosUnNumero = Boolean.TRUE;
            }
            if (lowercase > 0) {
                alMenosLetraMinuscula = Boolean.TRUE;
            }
            if (uppercase > 0) {
                alMenosLetraMayuscula = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void onCellEditProfile(CellEditEvent event)">
    public void onCellEditProfile(CellEditEvent event) {
        
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        UIColumn col = (UIColumn) event.getColumn();
        int alteredRow = event.getRowIndex();

        if (newValue != null && !newValue.equals(oldValue)) {

            isChangeInRowDatatableProfile = Boolean.TRUE;
        }

        
        if (col.getId().equals(rf.fromMessage("label.departament"))) {
            profileList.get(alteredRow).setDepartamentView((DepartamentView) newValue);
            

        } 

        //    PrimeFaces.current().ajax().update("datatableTareaFooter");
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="onItemSelect(SelectEvent event)">
    public void onItemSelect(SelectEvent event) {

//        FacesUtil.successMessage(((DepartamentView) event.getObject()).getDepartament());
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void deleteProfile(Profile profile)">
    public void deleteProfile(Profile profile) {
        try {
            profileList.remove(profile);
            isButtonSavePressed = Boolean.FALSE;

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void agregarRowProfile()">
    public void agregarRowProfile() {
        try {
            Integer size = profileList.size();
            Profile profile = new Profile(size.longValue(), profileLogged.getApplicativeView(),
                    roleSelected, departamentViewSelected, Boolean.TRUE);
            if (profileList == null || profileList.isEmpty()) {

            } else {
                Boolean found = Boolean.FALSE;
                for (Profile p : profileList) {
                    if (p.getDepartamentView().getIddepartament().equals(departamentViewSelected.getIddepartament())) {
                        if (p.getRole().getIdrole().equals(roleSelected.getIdrole())) {
                            found = Boolean.TRUE;
                        }
                    }
                }
                if (found) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.profilerepetido"));
                    return;
                }
            }

            profileList.add(profile);

            isButtonSavePressed = Boolean.FALSE;

            PrimeFaces.current().ajax().update("dataTableProfile");

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
