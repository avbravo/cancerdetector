/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;
// <editor-fold defaultstate="collapsed" desc=" import">

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.pojos.Tiempo;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.commons.emails.EmailSender;
import com.sft.commons.emails.EmailSenderEvent;

import com.sft.model.ActionHistory;
import com.sft.model.DepartamentView;
import com.sft.services.implementation.ColorManagementImpl;
import com.sft.model.Profile;
import com.sft.model.Role;
import com.sft.model.User;
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
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.ResponsiveOption;
import com.sft.services.ColorManagement;
import com.sft.faces.services.SprintFacesServices;
import com.sft.model.Applicative;
import com.sft.model.Otp;
import java.util.Optional;
import com.sft.restclient.UserRestClient;
import com.sft.restclient.ProyectoRestClient;
import com.sft.security.LoginFaces;
import com.sft.services.ApplicativeServices;
import com.sft.services.OtpServices;
import com.sft.services.UserServices;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Event;
import jakarta.faces.event.AjaxBehaviorEvent;
import static java.util.Arrays.asList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.primefaces.model.file.UploadedFile;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class OlvidoPasswordFaces implements Serializable, JmoordbCoreXHTMLUtil, IPaginator, SprintFacesServices {

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
    private Integer totalMinutesForExpired = 0;

    private String tokenSelected = "";
    private Integer contadorIntentos = 0;

    private String email;

    private Boolean isEnvioToken = Boolean.FALSE;
    private Boolean isTokenValido = Boolean.FALSE;

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

    private Applicative applicativeLogged = new Applicative();
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
    // <editor-fold defaultstate="collapsed" desc="@Event">
    @Inject
    Event<EmailSenderEvent> emailSenderEvent;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SecretKey()">
    private String secretKey = "SCox1jmWrkma$*opne2Amwz";
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
    ApplicativeServices applicativeServices;
    @Inject
    OtpServices otpServices;

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

    // Otp 
    @Inject
    @ConfigProperty(name = "hoursForExpiredOtp", defaultValue = "0")
    private Provider<Integer> hoursForExpiredOtp;
    @Inject
    @ConfigProperty(name = "minutesForExpiredOtp", defaultValue = "0")
    private Provider<Integer> minutesForExpiredOtp;
    @Inject
    @ConfigProperty(name = "secondsForExpiredOtp", defaultValue = "0")
    private Provider<Integer> secondsForExpiredOtp;

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

            responsiveOptions = new ArrayList<>();
            responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
            responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
            responsiveOptions.add(new ResponsiveOption("560px", 1, 1));

            fileRepositoryDirectory = FacesUtil.pathOfMicroprofileConfig(pathBaseLinuxAddUserHome.get(), pathLinuxFileRepository.get(), pathWindowsFileRepository.get());

            totalMinutesForExpired = (hoursForExpiredOtp.get() * 60) + minutesForExpiredOtp.get();
            if (searchApplicative()) {
                JmoordbCoreContext.put("LoginFaces.applicative", applicativeLogged);
            }
            this.tokenSelected = "";
            contadorIntentos = 0;
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

    // <editor-fold defaultstate="collapsed" desc="String sendToken()">
    public String sendToken() {
        try {
            this.tokenSelected = "";
            contadorIntentos = 0;
            if (!email.contains("@")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.emailnotvalid"));
                return "";
            }

            /**
             * Buscar usario por email que este activo
             */
            Optional<User> userEmail = userServices.findByEmail(email);
            if (!userEmail.isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.emailnoasociadoausuarios"));
                return "";
            }

            var tokenGenerado = FacesUtil.otp(6);
            Otp otp = new Otp();
            otp.setExpirationdate(JmoordbCoreDateUtil.fechaHoraActual());
            otp.setIdapplicative(idapplicative.get().longValue());
            otp.setIduser(userEmail.get().getIduser());
            otp.setIsexpired(Boolean.FALSE);
            otp.setOtp(tokenGenerado);
            otp.setUsed(Boolean.FALSE);
            otp.setEmail(email);
            ActionHistory actionHistory = new ActionHistory.Builder()
                    .iduser(userEmail.get().getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("generar otp")
                    .clase(FacesUtil.nameOfClass())
                    .metodo(FacesUtil.nameOfMethod())
                    .build();
            List<ActionHistory> actionHistoryList = new ArrayList<>();
            actionHistoryList.add(actionHistory);

            otp.setActionHistory(actionHistoryList);

            Optional<Otp> otpOptional = otpServices.save(otp);
            if (!otpOptional.isPresent()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.saveotp"));
            } else {
                sendEmail(otp);
                FacesUtil.successMessage(rf.fromCore("info.optenviado"));
                this.isEnvioToken = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String validateToken()">

    public String validateToken() {
        Integer page = 0;
        Integer size = 0;
        Document sort = new Document("idotp", -1);
        try {
            this.isTokenValido = Boolean.FALSE;
            if (contadorIntentos >= 3) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.demasiadosintentosfallidosgenereotrotoken"));
                Bson filter0 = eq("email", email);
                Bson filter = and(filter0, eq("used", Boolean.FALSE),
                        eq("isexpired", Boolean.FALSE)
                );

                List<Otp> list = otpServices.lookup(filter, sort, page, size);
                if (list == null || list.isEmpty()) {
                } else {
                    for (Otp otp : list) {
                        otp.setIsexpired(Boolean.TRUE);
                        otpServices.update(otp);
                    }
                }
                isEnvioToken = Boolean.FALSE;
                return "";
            }
            contadorIntentos++;

            Bson filter0 = eq("otp", this.tokenSelected);
            Bson filter = and(filter0, eq("email", email), eq("idapplicative", idapplicative.get()),
                    eq("used", Boolean.FALSE),
                    eq("isexpired", Boolean.FALSE)
            );

            List<Otp> list = otpServices.lookup(filter, sort, page, size);
            if (list.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.tokennoesvalidosoliciteotro"));
                return "";
            } else {
                var otp = list.get(0);
                Tiempo tiempo = DateUtil.diferenciaEntreFechas(DateUtil.getFechaHoraActual(), otp.getExpirationdate());
                Integer total = (tiempo.getDias() * 1440) + (tiempo.getHoras() * 60) + (tiempo.getMinutos());

                if (total > totalMinutesForExpired) {
                    otp.setIsexpired(Boolean.TRUE);
                    otpServices.update(otp);
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.tokenexpirado"));
                    return "";
                }

                otp.setUsed(Boolean.TRUE);
                otpServices.update(otp);

                Optional<User> userOptional = userServices.findByIduser(otp.getIduser());
                if (!userOptional.isPresent()) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.noexisteusuarioasociadoaestetoken"));
                    return "";
                }
                if(!userOptional.get().getActive()){
                  FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.usuariotokennoactivo"));
                    return "";   
                }
                if(!userOptional.get().getEmail().equals(email)){
                  FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.usuariotokenemaildiferente"));
                    return "";   
                }

                JmoordbCoreUtil.copyBeans(userSelected, userOptional.get());
                JmoordbCoreUtil.copyBeans(userDB, userOptional.get());
                userSelected.setPassword("");

                //userSelected
                this.isTokenValido = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String back()">
    public String back() {
        this.isEnvioToken = Boolean.FALSE;
        this.isTokenValido = Boolean.FALSE;
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void sendEmail(Otp otp)">
    public void sendEmail(Otp otp) {
        try {

            List<String> emailList = asList(email);

            String tituloEmail = "";
            String mensajeEmail = "";

            if (emailList == null || emailList.isEmpty()) {

            } else {

                tituloEmail = rf.fromCore("emailtitulo.token");

                mensajeEmail = "<strong>" + rf.fromCore("email.mensaje") + ": </strong>" + rf.fromCore("email.tokenparacambiarcontrasena") + "<br>"
                        + "<strong>" + rf.fromCore("email.token") + ":</strong> " + otp.getOtp() + " <br>"
                        + "<strong>" + rf.fromCore("email.generadoel") + "</strong> " + otpServices.showDate(otp.getExpirationdate()) + " : " + otpServices.showHour(otp.getExpirationdate()) + "<br>"
                        + "<strong>" + rf.fromCore("email.expiraen") + "</strong> " + totalMinutesForExpired + " " + rf.fromCore("email.minutosapartirgeneracion") + "<br><br>";

                tituloEmail += " " + rf.fromConfiguration("application.shorttitle");
                EmailSender emailSender = new EmailSender.Builder()
                        .header(tituloEmail)
                        .messages(mensajeEmail)
                        .pathFile("")
                        .nameFile("")
                        .emailList(emailList)
                        .build();

                emailSenderEvent.fire(new EmailSenderEvent(emailSender));
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean searchApplicative()">
    /**
     * Consulta medoante un Search
     *
     * @return
     */
    public Boolean searchApplicative() {
        Boolean result = Boolean.FALSE;
        try {

            applicativeLogged = applicativeServices.findByIdapplicative(idapplicative.get().longValue()).get();
            if (applicativeLogged == null || applicativeLogged.getIdapplicative() == null) {

                applicativeLogged = new Applicative();
            } else {

                result = Boolean.TRUE;
            }

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

    // <editor-fold defaultstate="collapsed" desc="editUser(User user)">
    public String editUser(User user) {
        try {

            Optional<User> userDBNow = userServices.findByIduser(user.getIduser());
            if (!userDBNow.isPresent()) {
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
                    .iduser(userSelected.getIduser())
                    .fecha(JmoordbCoreDateUtil.fechaHoraActual())
                    .evento("cambio password")
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

                return "home.xhtml";
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
}
