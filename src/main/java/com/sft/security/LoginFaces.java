/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.sft.security;

// <editor-fold defaultstate="collapsed" desc="import">
import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbCoreTiempo;
import com.avbravo.jmoordbutils.JmoordbCoreXHTMLUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.primejmoordb.view.App;
import com.sft.model.Applicative;
import com.sft.model.Applicativerole;
import com.sft.model.Profile;
import com.sft.model.User;
import com.sft.services.ApplicativeServices;
import com.sft.services.LoginValidateServices;
import com.sft.services.UserServices;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
//import org.graalvm.polyglot.Context;
//import org.graalvm.polyglot.Value;
// </editor-fold>

/**
 *
 * @author avbravo
 */
@Named
@SessionScoped
@Data
public class LoginFaces implements Serializable, LoginValidateServices, JmoordbCoreXHTMLUtil {

//     @Inject
//    @Push
//    PushContext userChannel;
//     
    private Session sessionWebSocket;
    // <editor-fold defaultstate="collapsed" desc=" fields">

    private static final long serialVersionUID = 1L;
    private Integer startSecond = 9000;
    private Integer endSecond = 1000;
    private String username = "";
    private String password = "";
    private Integer intervalForPoll = 0;
    private Integer intervalSecondForPoll = 0;
    private Boolean isLogged = Boolean.FALSE;
    private Boolean isValidApplicative = Boolean.FALSE;
    private Boolean isValidRoles = Boolean.FALSE;
    private Integer contadorIntentos = 0;
    private Boolean isShowDialogSessionTimeOut = Boolean.FALSE;
    private Boolean isShowDialogSessionTimeOutTwo = Boolean.FALSE;
    private Integer countVerificacionExpiracion = 0;
    private Boolean isValidUser = Boolean.FALSE;
    private Applicative applicativeLogged = new Applicative();
    private Applicativerole applicativeroleLogged = new Applicativerole();
    private Profile profileLogged = new Profile();
    private List<Profile> profileListLogged = new ArrayList<>();
    private User userLogged = new User();
    private List<Feature> featureList;
    private String loginPage = "loginximple.xhtml";
    private Date timeStart = new Date();
    private Date timeForExpired = new Date();
    private JmoordbCoreTiempo timeRemainder = new JmoordbCoreTiempo(0, 0, 0, 0);
    private String timeForExpiredColor = "ui-button-success";

    private String timeForSession = "00:00";

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="selected For Dialog()">
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
    @ConfigProperty(name = "maximuNumberOfCharacterForShowApplyCut")
    private Provider<Integer> maximuNumberOfCharacterForShowApplyCut;

    @Inject
    @ConfigProperty(name = "websocket.minimums.seconds.for.update")
    private Provider<Integer> websocketMinimumsSecondsForUpdate;

    @Inject
    @ConfigProperty(name = "applicativePath", defaultValue = " ")
    private Provider<String> applicativePath;

    /*
    Template
     */
    @Inject
    @ConfigProperty(name = "showTopBarInTemplate", defaultValue = " ")
    private Provider<Boolean> showTopBarInTemplate;

    @Inject
    @ConfigProperty(name = "showTextLeftMenu", defaultValue = "false")
    private Provider<Boolean> showTextLeftMenu;
    @Inject
    @ConfigProperty(name = "screen.resolution", defaultValue = "100%")
    private Provider<String> screenResolution;
    @Inject
    @ConfigProperty(name = "screen.resolutionScreenHigth", defaultValue = "90%")
    private Provider<String> screenResolutionScreenHigth;

   

    @Inject
    @ConfigProperty(name = "screen.resolutionMobile", defaultValue = "50%")
    private Provider<String> screenResolutionMobile;

    public String getResolutionMobile() {
        return this.screenResolutionMobile.get();
    }

    /**
     * Text
     */
    @Inject
    @ConfigProperty(name = "smallSizeOfTextForCut")
    private Provider<Integer> smallSizeOfTextForCut;
    @Inject
    @ConfigProperty(name = "mediumSizeOfTextForCut")
    private Provider<Integer> mediumSizeOfTextForCut;
    @Inject
    @ConfigProperty(name = "largeSizeOfTextForCut")
    private Provider<Integer> largeSizeOfTextForCut;

    @Inject
    @ConfigProperty(name = "minutosParaDesplegarDialogoAdvertenciaExpiracion")
    private Provider<Integer> minutosParaDesplegarDialogoAdvertenciaExpiracion;

    @Inject
    @ConfigProperty(name = "minutosParaDesplegarSegundoDialogoAdvertenciaExpiracion")
    private Provider<Integer> minutosParaDesplegarSegundoDialogoAdvertenciaExpiracion;
    @Inject
    @ConfigProperty(name = "minutosSessionTimeoutInWebXML")
    private Provider<Integer> minutosSessionTimeoutInWebXML;

    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeStoreInCollections", defaultValue = "false")
    private Provider<Boolean> pathBaseLinuxAddUserHomeStoreInCollections;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SecretKey()">
    private String secretKey = "SCox1jmWrkma$*opne2Amwz";
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">

//    @Inject
//    ApplicativeClient applicativeClient;
//    @Inject
//    UserClient userClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Services">
    @Inject
    ApplicativeServices applicativeServices;
    @Inject
    UserServices userServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    App app;
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;
    @Inject
    private SecurityContext securityContext;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private FacesContext facesContext;
// </editor-fold>

    /**
     * Creates a new instance of LoginFaces
     */
    public LoginFaces() {
    }

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
    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {

        /**
         * Tiempo de Finalizacion de sesion
         */
        intervalForPoll = 0;
        timeRemainder = new JmoordbCoreTiempo(0, 0, 0, 0);
        countVerificacionExpiracion = 0;

        var minutos = minutosSessionTimeoutInWebXML.get() - minutosParaDesplegarDialogoAdvertenciaExpiracion.get();
        intervalForPoll = (minutos * 60);
        intervalSecondForPoll = minutosParaDesplegarSegundoDialogoAdvertenciaExpiracion.get() * 60;

        isShowDialogSessionTimeOut = Boolean.FALSE;
        isShowDialogSessionTimeOutTwo = Boolean.FALSE;
        timeStart = JmoordbCoreDateUtil.fechaHoraActual();

        timeForExpiredColor = "ui-button-success";

        var seconds = Long.parseLong(String.valueOf(facesContext.getExternalContext().getSessionMaxInactiveInterval()));
        var endTime = JmoordbCoreDateUtil.secondsToHourMinuteSecondsTiempo(seconds);
        timeForExpired = JmoordbCoreDateUtil.sumarHorasMinutosToFecha(timeStart, endTime.getHoras(), endTime.getMinutos());

        /**
         *
         *
         */
        startSecond = minutosSessionTimeoutInWebXML.get() * 60;

        //        Context   context = Context.newBuilder().allowAllAccess(true).build();
//        Value array = context.eval("python", "[1,2,42,4]");
//        int result = array.getArrayElement(2).asInt();
//        System.out.println("Desde Phyton"+result);
        contadorIntentos = 0;
        isLogged = Boolean.FALSE;
        isValidRoles = Boolean.FALSE;

        isValidUser = Boolean.FALSE;
        featureList = new ArrayList<>();
        profileListLogged = new ArrayList<>();
        profileLogged = new Profile();

        featureList.add(new Feature(rf.fromConfiguration("loginfeature.tite1"), rf.fromConfiguration("loginfeature.image1"), rf.fromConfiguration("loginfeature.text1")));
        featureList.add(new Feature(rf.fromConfiguration("loginfeature.tite2"), rf.fromConfiguration("loginfeature.image2"), rf.fromConfiguration("loginfeature.text2")));
        featureList.add(new Feature(rf.fromConfiguration("loginfeature.tite3"), rf.fromConfiguration("loginfeature.image3"), rf.fromConfiguration("loginfeature.text3")));
        /**
         * Verifica la pagina de login que se este usando.
         */
        switch (loginStyle.get()) {
            case "simple":
            case "split":
            case "feature":
            case "carousel":
            case "glass":
                break;
            default:

                FacesUtil.warningMessage(rf.fromCore("styleLogin.notvalid"));

        }
        if (loginPage == null || loginPage.equals("")) {
            loginPage = "/login/carousel.xhtml";
        } else {
            loginPage = "/login/" + loginStyle.get() + ".xhtml";
        }

//        
        /**
         * Cambia password de ususarios
         */
//       String emailPassword =Encryptor.encrypt("14Centroa20", secretKey,FacesUtil.nameOfClassAndMethod());
//        System.out.println(" [emailPassword ] "+emailPassword );
//        String passw= Encryptor.encrypt("demo", secretKey,FacesUtil.nameOfClassAndMethod());
//        User user = userClient.findByIduser(8L);
//        user.setPassword(Encryptor.encrypt("Coxip180denver$aka5", secretKey,FacesUtil.nameOfClassAndMethod()));
//        userClient.update(user);
//        System.out.println("Password actualizado...");
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="void preDestroy()">

    @PreDestroy
    @Override
    public void preDestroy() {

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="next()">
    public String next() {
        try {
            contadorIntentos = 0;
            isLogged = Boolean.FALSE;
            profileLogged = new Profile();
            profileListLogged = new ArrayList<>();
            /**
             * Busca applicative
             */
            isValidApplicative = searchApplicative();
            if (!isValidApplicative) {
                FacesUtil.warningMessage(rf.fromCore("applicativeconfiguration.restrictivelogin"));
                return "";
            }
            /**
             * Carga el app configuration
             */
            isValidRoles = validateRoles(rf, applicativeLogged);

            if (!isValidRoles) {

                return "";
            }

            if (username == null || username.equals("")) {
                FacesUtil.warningMessage(rf.fromCore("warning.usernameisempty"));
                return "";
            }
            Optional<User> userOptional = userServices.findByUsername(username);
            if (!userOptional.isPresent()) {
                FacesUtil.warningMessage(rf.fromCore("login.usernamenotvalid"));
                return "";

            }
//            
            userLogged = userOptional.get();
            if (!userLogged.getActive()) {
                FacesUtil.warningMessage(rf.fromCore("login.inactive"));
                return "";
            }

            isValidUser = validateProfileUser(profileListLogged, userLogged, rf, applicativeLogged);

            if (!isValidUser) {
                return "";
            }

            /**
             * Guarda el contexto de la lista de Profiles
             */
            JmoordbCoreContext.put("profileListLogged", profileListLogged);
            profileLogged = profileListLogged.get(0);

            return loginPage;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String login()">
    public String login() {
        try {

            if (isLogged) {
                //FacesUtil.warningMessage("Usted ya ha iniciado sesión en este aplicativo");
                JmoordbCoreContext.put("pageInView", "home.xhtml");
                return "/" + applicativeroleLogged.getPath() + "/" + "dashboard.xhmtl";
            }

            isLogged = Boolean.FALSE;
            if (password == null || password.equals("")) {
                FacesUtil.warningMessage(rf.fromCore("warning.passwordisempty"));
                return "";
            }

            if (profileLogged == null || profileLogged.getRole() == null) {
                FacesUtil.warningMessage(rf.fromCore("warning.profilenotselected"));
                return "";
            }

            /**
             * Validar el password
             */
            // Desencriptar el password de la base de datos
            String encripter = Encryptor.encrypt(password, secretKey);

            String passwordDecrypter = Encryptor.decrypt(userLogged.getPassword(), secretKey, FacesUtil.nameOfClassAndMethod());

            if (passwordDecrypter.equals(password)) {
                //AplicarIdentityStore
            } else {
                FacesUtil.warningMessage(rf.fromCore("warning.passwordnotmatch"));
                if (contadorIntentos >= 3) {
                    FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromCore("warning.demasiadosintentosfallidoscambiepassword"));

                    return "/olvidopassword.xhtml";
                }
                contadorIntentos++;
                return "";
            }

            /**
             * Guarda el role en el Conext
             */
            if (!validateApplicativeRole(rf, applicativeLogged, profileLogged)) {
                return "";
            }
            JmoordbCoreContext.put("LoginFaces.profileLogged", profileLogged);
            JmoordbCoreContext.put("LoginFaces.applicativeroleLogged", applicativeroleLogged);
            JmoordbCoreContext.put("LoginFaces.applicative", applicativeLogged);

            /**
             * Verificar la Seguridad de la sesion
             */
//---Injectarlo en el Session
            switch (continueAuthentication()) {
                case SEND_CONTINUE:

                    facesContext.responseComplete();
                    break;
                case SEND_FAILURE:

                    facesContext.addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
                    break;
                case SUCCESS:
                    //Aplica el tema del usuario
                    app.changeTheme(userLogged.getTheme(), true);

                    isLogged = Boolean.TRUE;
                    JmoordbCoreContext.put("LoginFaces.userLogged", userLogged);

                    /**
                     * Security
                     */
//
//                    //Guarda el registro del acceso
//                    String ip = JsfUtil.getIp() == null ? "" : JsfUtil.getIp();
//                    Access access = new Access.Builder()
//                            .idaccess(0)
//                            .date(DateUtil.getFechaHoraActual())
//                            .ip(ip)
//                            .username(username)
//                            .idapplicative(applicativeId.get())
//                            .event("login")
//                            .iddepartament(profile.getIddepartament())
//                            .idprofile(profile.getIdprofile())
//                            .idrole(profile.getIdrole())
//                            .build();
//
//                    accessEvent.fire(new AccessEvent(access));
//
//            
                    //Veririco si tiene notificaciones
//                    if (verificarNotifications(user.getUsername())) {
//
//                        JsfUtil.successMessage(rf.getAppMessage("login.welcome") + " " + user.getName() + " " + rf.getAppMessage("login.havenotifications"));
//
//                    } else {
//
//                        JsfUtil.successMessage(rf.getAppMessage("login.welcome") + " " + user.getName());
//                    }
//                    //  JsfUtil.successMessage(rf.getAppMessage("login.welcome") + " " + user.getName());
//
////                    if ( profile.getIdrole().equals(rolColaborador.get())) {
////                        return "/faces/index.xhtml?faces-redirect=true";
////                    }
//         switch(profileLogged.getRole().getIdrole()){
//             case 1L:
//                 break;
//             case 2L:
//                 
//         }
                    JmoordbCoreContext.put("pageInView", "home.xhtml");
//                      System.out.println("Test-->login() /faces/index.xhtml");
                    // return "/faces/index.xhtml?faces-redirect=true";
                    // return "/faces/index.xhtml";
                    // FacesUtil.successMessage(rf.fromCore("login.welcome") + " " + userLogged.getName());
                    return "/" + applicativeroleLogged.getPath() + "/" + "dashboard.xhmtl";
                case NOT_DONE:

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String back()">
    public String back() {
        try {
            System.out.println(":::::::::::: llego a loginFaces");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "/home.xhtml";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="AuthenticationStatus continueAuthentication()()">
    private AuthenticationStatus continueAuthentication() {

        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams()
                        .credential(new UsernamePasswordCredential(username, password))
        );
    }

    private void getRequestURI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="class Feature ">
    public class Feature {

        private String title;
        private String image;
        private String text;

        public Feature(String title, String image, String text) {
            this.title = title;
            this.image = image;
            this.text = text;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" onProfileChange()">
    public void onProfileChange() {
        try {

            if (profileLogged == null || profileLogged.getDepartamentView() == null) {
                //No se ha seleccionado departamemto
                profileLogged = new Profile();
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

    // <editor-fold defaultstate="collapsed" desc="Boolean validateApplicativeRole(JmoordbResourcesFiles rf, Applicativerole  applicativeroleLogged, Applicative applicativeLogged, Profile profileLogged)">
    /**
     * Valida el applicative role
     *
     * @param rf
     * @param applicativeroleLogged
     * @param applicativeLogged
     * @param profileLogged
     * @return
     */
    public Boolean validateApplicativeRole(JmoordbResourcesFiles rf, Applicative applicativeLogged, Profile profileLogged) {
        Boolean result = Boolean.FALSE;
        try {

            for (Applicativerole a : applicativeLogged.getApplicativerole()) {
                if (a.getIdrole().equals(profileLogged.getRole().getIdrole())) {

                    if (a.getActive() && profileLogged.getActive()) {
                        applicativeroleLogged = a;

                        result = Boolean.TRUE;

                        break;
                    }
                }
            }
            if (result) {
                if (applicativeLogged.getPath() == null || applicativeLogged.getPath().equals("")) {
                    FacesUtil.warningMessage(rf.fromCore("warning.roleapplicativepathempty"));
                    result = Boolean.FALSE;
                }
            } else {
                FacesUtil.warningMessage(rf.fromCore("warning.roleapplicativenotvalido"));

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String logout()">
    public String logout() {
        String path = applicativePath.get();
        isLogged = Boolean.FALSE;

        return logout(path + "/home.xhtml?faces-redirect=true");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String logout(String path)">
    public String logout(String path) {
        Boolean loggedIn = false;
        try {

            String ip = FacesUtil.getIp() == null ? "" : FacesUtil.getIp();

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.invalidate();
            }
            String url = (path);
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(url);
            return path;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String go( String path) ">
    /**
     *
     * @param proyecto
     * @param path
     * @param isProyectoForaneo
     * @param editable
     * @return
     */
    public String go(String path) {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String expired()">
    public String expired() {

        return "error/expired.xhtml?faces-redirect=true";

    }// </editor-fold>

//    // <editor-fold defaultstate="collapsed" desc="Date tiempoRestante(Long secondsSession)">
//    public Date tiempoRestante(Long secondsSession) {
//        var result = new Date();
//
//        try {
//            timeForExpiredColor = "ui-button-success";
////            var endTime = JmoordbCoreDateUtil.secondsToHourMinuteSecondsTiempo(secondsSession);
////            timeForExpired = JmoordbCoreDateUtil.sumarHorasMinutosToFecha(timeStart, endTime.getHoras(), endTime.getMinutos());
////            result = timeForExpired;
//            if (JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.fechaHoraActual(), timeForExpired)) {
//                timeForExpiredColor = "ui-button-danger";
//            } else {
//                var r = JmoordbCoreDateUtil.diferenciaEntreFechas(timeForExpired, JmoordbCoreDateUtil.fechaHoraActual());
//
//                if (r.getMinutos() <= 2) {
//                    timeForExpiredColor = "ui-button-danger";
//                }
//            }
//
//        } catch (Exception e) {
//
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return result;
//    }
//    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String calculateExpired(Long secondsSession)">
    public String calculateExpired(Long secondsSession) {
        try {

            countVerificacionExpiracion++;

//            tiempoRestante(secondsSession);
            timeRemainder = JmoordbCoreDateUtil.diferenciaEntreFechas(timeForExpired, JmoordbCoreDateUtil.fechaHoraActual());

            if (!isShowDialogSessionTimeOut) {
                if (timeRemainder.getMinutos() <= minutosParaDesplegarDialogoAdvertenciaExpiracion.get()) {

                    timeForExpiredColor = "ui-button-danger";
                    closeOverlayPanel("PF('dialogTemplateExpiracionSesion').show()");
                    PrimeFaces.current().ajax().update("outputLabelTiempoFinalSesionText");
                    PrimeFaces.current().ajax().update("commandButtonStopWatch");

                    isShowDialogSessionTimeOut = Boolean.TRUE;

                }

            }
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String calculateExpiredTow(Long secondsSession)">
    /**
     * Segundo dialogo de expiracion
     *
     * @param secondsSession
     * @return
     */
    public String calculateExpiredTwo(Long secondsSession) {
        try {
            countVerificacionExpiracion++;

//            tiempoRestante(secondsSession);
            timeRemainder = JmoordbCoreDateUtil.diferenciaEntreFechas(timeForExpired, JmoordbCoreDateUtil.fechaHoraActual());

            if (!isShowDialogSessionTimeOutTwo) {
                if (timeRemainder.getMinutos() <= minutosParaDesplegarSegundoDialogoAdvertenciaExpiracion.get()) {

                    timeForExpiredColor = "ui-button-danger";
                    closeOverlayPanel("PF('dialogTemplateExpiracionSesion').show()");
                    PrimeFaces.current().ajax().update("outputLabelTiempoFinalSesionText");
                    PrimeFaces.current().ajax().update("commandButtonStopWatch");

                    isShowDialogSessionTimeOutTwo = Boolean.TRUE;

                }

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
    // <editor-fold defaultstate="collapsed" desc="void openOverlayPanel(String panel) ">

    private void openOverlayPanel(String panel) {
        try {
            PrimeFaces.current().executeScript(panel);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void startListener(final SelectEvent<Double> event)">
    public void startListener(final SelectEvent<Double> event) {
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Start fired",
                "Value: " + event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        PrimeFaces.current().ajax().update("template_growl_timesession");

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void endListener(final SelectEvent<Double> event)">
    public void endListener(final SelectEvent<Double> event) {
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "End fired",
                "Value: " + event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        PrimeFaces.current().ajax().update("template_growl_timesession");
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String inicializa()">
    public String inicializa() {
        contadorIntentos = 0;
        isLogged = Boolean.FALSE;
        isValidRoles = Boolean.FALSE;

        isValidUser = Boolean.FALSE;
        featureList = new ArrayList<>();
        profileListLogged = new ArrayList<>();
        profileLogged = new Profile();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String websocketListenerMethod()">

    public String webSocketListenerMethod() {
        try {

            FacesUtil.successMessage("desde el websocket");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>   
}
