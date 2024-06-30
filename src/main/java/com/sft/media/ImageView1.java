/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.media;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import static com.sft.media.JmoordbCoreMediaManagerX.typeOfMimeTypeForDownload;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped

//https://primefaces.github.io/primefaces/11_0_0/#/core/dynamiccontent?id=dynamic-content-rendering-via-data-uri-streamfalse-currently-only-supported-by-pgraphicimage
public class ImageView1 {

    private StreamedContent image;
    InputStream is = null;
       String position = "1";
       
    public ImageView1() {
        StreamedContent result;
        try {

     
            String pathOfFile = (String) JmoordbCoreContext.get("pathOfFile" + position);
            String nameFile = (String) JmoordbCoreContext.get("nameOfFile" + position);
            String extensionOfFileInPath = extensionOfFileInPath(pathOfFile);

            File filet = new File(pathOfFile);

            if (!filet.exists()) {

            } else {

                is = new FileInputStream(filet);
                if (nameFile == null || nameFile.equals("")) {
                    String name = nameOfFileInPath(pathOfFile);
                    image = DefaultStreamedContent.builder()
                            .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                            .name(name + "." + extensionOfFileInPath)
                            .stream(() -> is)
                            .build();
                } else {
                    image = DefaultStreamedContent.builder()
                            .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                            .name(nameFile + "." + extensionOfFileInPath)
                            .stream(() -> is)
                            .build();
                }

//         
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

    public StreamedContent getImage() {
        image =generate();
        return image;
    }

    
      public StreamedContent generate() {
        StreamedContent result;
        try {

     
            String pathOfFile = (String) JmoordbCoreContext.get("pathOfFile" + position);
            String nameFile = (String) JmoordbCoreContext.get("nameOfFile" + position);
            String extensionOfFileInPath = extensionOfFileInPath(pathOfFile);

            File filet = new File(pathOfFile);
//          if(filet.isDirectory()){
//             
//              return result;
//          }
            if (!filet.exists()) {

            } else {

                is = new FileInputStream(filet);
                if (nameFile == null || nameFile.equals("")) {
                    String name = nameOfFileInPath(pathOfFile);
                    image = DefaultStreamedContent.builder()
                            .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                            .name(name + "." + extensionOfFileInPath)
                            .stream(() -> is)
                            .build();
                } else {
                    image = DefaultStreamedContent.builder()
                            .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                            .name(nameFile + "." + extensionOfFileInPath)
                            .stream(() -> is)
                            .build();
                }

//         
            }
            return image;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
return null;
    }
    // <editor-fold defaultstate="collapsed" desc="String extensionOfFileInPath(String filenamePath)">
    /**
     *
     * @param filenamePath
     * @return devuelve la extension de un archivo en un path
     */
    public String extensionOfFileInPath(String filenamePath) {
        String extension = "";
        try {
            extension = filenamePath.substring(filenamePath.lastIndexOf('.') + 1, filenamePath.length());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return extension;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String nameOfFileInPath(String filenamePath)">
    /**
     *
     * @param filenamePath
     * @return el nombre del archivo que esta en un path
     */
    public String nameOfFileInPath(String filenamePath) {
        String name = "";
        try {
            if (filenamePath == null || filenamePath.isEmpty() || filenamePath.isBlank()) {
                return name;
            }

            if (filenamePath.lastIndexOf('.') == -1) {

            } else {
                name = filenamePath.substring(filenamePath.lastIndexOf(System.getProperty("file.separator")) + 1,
                        filenamePath.lastIndexOf('.'));
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return name;

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String pathOfFile(String filenamePath)" >
    /**
     *
     * @param filenamePath
     * @return el path de un archivo
     */
    public String pathOfFile(String filenamePath) {
        String path = "";
        try {
            path = filenamePath.substring(0, filenamePath.lastIndexOf(System.getProperty("file.separator")));
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return path;
    }
    // </editor-fold>

}
