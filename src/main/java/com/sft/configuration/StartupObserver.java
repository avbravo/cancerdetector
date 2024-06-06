/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.configuration;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.sft.services.UserServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Shutdown;
import jakarta.enterprise.event.Startup;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class StartupObserver {

    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;
    @Inject
    @ConfigProperty(name = "idapplicative")
    private Provider<Integer> idapplicative;
    @Inject
    @ConfigProperty(name = "loginStyle")
    private Provider<String> loginStyle;
    // -----------------------------------------------------
    //     CREAR DIRECTORIOS DE IMAGENES Y LOGGER
    //------------------------------------------------------
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
    @ConfigProperty(name = "pathLinuxPhotoUser", defaultValue = " ")
    private Provider<String> pathLinuxPhotoUser;
    @Inject
    @ConfigProperty(name = "pathLinuxPhotoGeneral", defaultValue = " ")
    private Provider<String> pathLinuxPhotoGeneral;
    @Inject
    @ConfigProperty(name = "pathLinuxFileRepository", defaultValue = " ")
    private Provider<String> pathLinuxFileRepository;
    @Inject
    @ConfigProperty(name = "pathWindows", defaultValue = " ")
    private Provider<String> pathWindows;
    @Inject
    @ConfigProperty(name = "pathWindowsPhotoUser", defaultValue = " ")
    private Provider<String> pathWindowsPhotoUser;
    @Inject
    @ConfigProperty(name = "pathWindowsPhotoGeneral", defaultValue = " ")
    private Provider<String> pathWindowsPhotoGeneral;
    @Inject
    @ConfigProperty(name = "pathWindowsFileRepository", defaultValue = " ")
    private Provider<String> pathWindowsFileRepository;

    @Inject
    @ConfigProperty(name = "pathBaseLinuxAddUserHomeLogger", defaultValue = "true")
    private Provider<Boolean> pathBaseLinuxAddUserHomeLogger;
    @Inject
    @ConfigProperty(name = "pathLinuxLogger", defaultValue = " ")
    private Provider<String> pathLinuxLogger;
    @Inject
    @ConfigProperty(name = "pathWindowsLogger", defaultValue = " ")
    private Provider<String> pathWindowsLogger;

// </editor-fold>
    public void observeStartup(@Observes Startup startupEvent) {

        System.out.println("CDI Container is starting");
        ConsoleUtil.warning("____________________________________________________");
        ConsoleUtil.warning("\t\t[" + FacesUtil.nameOfClassAndMethod() + "]");

        ConsoleUtil.info("Revisar las carpetas para imagenes aqui() ");
        ConsoleUtil.info("Leer la configuración de la aplicacion aqui() ");
        ConsoleUtil.info("Applicative es " + idapplicative.get());
        ConsoleUtil.warning("____________________________________________________");

        String path = "";
        String pathImage = "";
        String pathImagePhotoUser = "";
        String pathImagePhotoGeneral = "";
        String pathFileRepository = "";
        try {
            /**
             * images
             */
            pathImage = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinux.get() : pathLinux.get())
                    : pathWindows.get()) + "file.json";
            String directory = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinux.get() : pathLinux.get())
                    : pathWindows.get());

            /**
             * images/photouser
             */
            pathImagePhotoUser = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxPhotoUser.get() : pathLinuxPhotoUser.get())
                    : pathWindowsPhotoUser.get()) + "file.json";

            String directoryPhotoUser = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxPhotoUser.get() : pathLinuxPhotoUser.get())
                    : pathWindowsPhotoUser.get());

            /**
             * images/photouser
             */
            pathImagePhotoGeneral = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxPhotoGeneral.get() : pathLinuxPhotoGeneral.get())
                    : pathWindowsPhotoGeneral.get()) + "file.json";

            String directoryPhotoGeneral = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxPhotoGeneral.get() : pathLinuxPhotoGeneral.get())
                    : pathWindowsPhotoGeneral.get());

            /**
             * file/Repository
             */
            pathFileRepository = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxFileRepository.get() : pathLinuxFileRepository.get())
                    : pathWindowsFileRepository.get()) + "file.json";

            String directoryFileRepository = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHome.get() ? JmoordbCoreUtil.userHome() + pathLinuxFileRepository.get() : pathLinuxFileRepository.get())
                    : pathWindowsFileRepository.get());

            /**
             * Logger
             */
            path = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHomeLogger.get() ? JmoordbCoreUtil.userHome() + pathLinuxLogger.get() : pathLinuxLogger.get())
                    : pathWindowsLogger.get()) + "looger.json";
            String directoryLogger = (JmoordbCoreUtil.isLinux()
                    ? (pathBaseLinuxAddUserHomeLogger.get() ? JmoordbCoreUtil.userHome() + pathLinuxLogger.get() : pathLinuxLogger.get())
                    : pathWindowsLogger.get());

            /**
             * Directorio Image
             */
            Path searchImage = Paths.get(directory);
            if (!Files.exists(searchImage)) {
                File directorio = new File(directory);
                if (directorio.mkdirs()) {

                } else {

                }
            }
            /**
             * Directorio images/user
             */

            Path searchImagePhotoUser = Paths.get(directoryPhotoUser);
            if (!Files.exists(searchImagePhotoUser)) {
                File directorio = new File(directoryPhotoUser);
                if (directorio.mkdirs()) {

                } else {

                }
            }
            /**
             * Directorio images/general
             */

            Path searchImagePhotoGeneral = Paths.get(directoryPhotoGeneral);
            if (!Files.exists(searchImagePhotoGeneral)) {
                File directorio = new File(directoryPhotoGeneral);
                if (directorio.mkdirs()) {

                } else {

                }
            }
            /**
             * Directorio file/Repository
             */

            Path searchImageFileRepository = Paths.get(directoryFileRepository);
            if (!Files.exists(searchImageFileRepository)) {
                File directorio = new File(directoryFileRepository);
                if (directorio.mkdirs()) {

                } else {

                }
            }

            /**
             * Directorio Logger
             */
            Path search = Paths.get(directoryLogger);
            if (!Files.exists(search)) {
                File directorio = new File(directoryLogger);
                if (directorio.mkdirs()) {

                } else {

                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    public void observeShutdown(@Observes Shutdown shutdownEvent) {
        System.out.println("CDI Container is stopping");
    }
}
