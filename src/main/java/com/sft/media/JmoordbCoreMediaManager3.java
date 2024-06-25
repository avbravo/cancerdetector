
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.media;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class JmoordbCoreMediaManager3 implements Serializable {
// <editor-fold defaultstate="collapsed" desc="field">

    private static final long serialVersionUID = 1L;
    private StreamedContent media;
    
    InputStream is = null;
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="set/get">
    public InputStream getIs() {
        return is;
    }
    
    public void setIs(InputStream is) {
        this.is = is;
    }
    
    public StreamedContent getMedia() {
        return media;
    }
    
    public void setMedia(StreamedContent media) {
        this.media = media;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        try {
                  ConsoleUtil.test("\t "+FacesUtil.nameOfClassAndMethod() + " " );
            String fileDownloadPath = (String) JmoordbCoreMediaContext.get("pathOfFile3");
            String nameFileDownloadPath = (String) JmoordbCoreMediaContext.get("nameOfFile3");
            
            if (fileDownloadPath == null || fileDownloadPath.equals("")) {
//                System.out.println("Es null en el context");
            } else {
                generate(fileDownloadPath,nameFileDownloadPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="StreamedContent generate(String pathFile, String nameFile))">
    public StreamedContent generate(String pathFile, String nameFile) {
        StreamedContent result;
        try {
            ConsoleUtil.test("\t***********************************"+FacesUtil.nameOfClassAndMethod());
         //   String name = nameOfFileInPath(pathFile);
            String pathOfFile = pathOfFile(pathFile);
            String extensionOfFileInPath = extensionOfFileInPath(pathFile);
            
            File filet = new File(pathFile);
//          if(filet.isDirectory()){
//             
//              return result;
//          }
            if(!filet.exists()){
          
            }else{
             
            is = new FileInputStream(filet);
            if(nameFile == null || nameFile.equals("")){
                String name = nameOfFileInPath(pathFile);
                   result = DefaultStreamedContent.builder()
                    .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                    .name(name + "." + extensionOfFileInPath)
                    .stream(() -> is)
                    .build();
            }else{
                  result = DefaultStreamedContent.builder()
                    .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                    .name(nameFile + "." + extensionOfFileInPath)
                    .stream(() -> is)
                    .build();
            }
          return result;
//         
        }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        
        return null;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="StreamedContent generateAgregateUserHome(String pathFile)">
    public StreamedContent generateAgregateUserHome(String pathFile) {
        try {
      
        
            String name = nameOfFileInPath(pathFile);
            String pathOfFile = pathOfFile(pathFile);
            String extensionOfFileInPath = extensionOfFileInPath(pathFile);
            
            File filet = new File(pathFile);
            if(!filet.exists()){
                
            }else{
                
           
            is = new FileInputStream(filet);
            
            media = DefaultStreamedContent.builder()
                    .contentType(typeOfMimeTypeForDownload(extensionOfFileInPath))
                    .name(name + "." + extensionOfFileInPath)
                    .stream(() -> is)
                    .build();
             }
            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        
        return media;
    }
    // </editor-fold>
    
    
    

    // <editor-fold defaultstate="collapsed" desc="String typeOfMimeTypeForDownload(String extension)">
    public static String typeOfMimeTypeForDownload(String extension) {
        String text = "";
        try {
            
            switch (extension) {
                case "jpg":
                    text = "image/jpg";
                    break;
                case "jpeg":
                    text = "image/jpeg";
                    break;
                case "gif":
                    text = "image/gif";
                    break;
                case "png":
                    text = "image/png";
                    break;
                case "webp":
                    text = "image/webp";
                    break;
                case "pdf":
                    text = "application/pdf";
                    break;
                case "plain":
                    text = "text/plain";
                case "cvs":
                    text = "text/csv";
                    
                    break;
                case "html":
                    text = "text/html";                    
                    break;
                
                case "txt":
                    text = "application/txt";                    
                    break;
                case "zip":
                    text = "application/zip";                    
                    break;
                case "webm":
                    text = "video/webm";                    
                    break;
           
                default:
                    System.out.println("Esta extesnsion" + extension + " no es soportada...");
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return text;
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
            if(filenamePath == null || filenamePath.isEmpty() || filenamePath.isBlank()){
                return name;
            }
            
            if(filenamePath.lastIndexOf('.')==-1){
            
            }else{
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

    // <editor-fold defaultstate="collapsed" desc=" Boolean isImage(String... filenamePath))">
    /**
     *
     * @param Verifica si es una imagen
     * @return devuelve la extension de un archivo en un path
     */
    public Boolean isImage(String... filenamePath) {
        String path = "";
        String extension = "";        
        Boolean valid = false;
        
        try {
            if (filenamePath.length != 0) {
                path = filenamePath[0];
                
            } else {
                path = (String) JmoordbCoreMediaContext.get("pathOfFile");
                
                if (path == null || path.equals("")) {
                    path = "";
                }
            }
            if (!path.equals("")) {
                extension = path.substring(path.lastIndexOf('.') + 1, path.length());
                
                if (extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg") || extension.equals("gif")) {
                    valid = true;
                }
            }
            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return valid;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Boolean Boolean isImageAndExists(String... filenamePath)">
    /**
     *
     * @param Verifica si es una imagen
     * @return devuelve la extension de un archivo en un path
     */
    public Boolean isImageAndExists(String... filenamePath) {
        String path = "";
        String extension = "";        
        Boolean valid = false;
        
        try {
           
            if (filenamePath.length != 0) {
                path = filenamePath[0];
                
            } else {
                path = (String) JmoordbCoreMediaContext.get("pathOfFile");
                
                if (path == null || path.equals("")) {
                    path = "";
                }
            }
            if(path == null || path.isEmpty()){
                return valid;
            }
            if (!path.equals("")) {
                
                extension = path.substring(path.lastIndexOf('.') + 1, path.length());
                
                if (extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg") || extension.equals("gif")) {
                
                        valid = existsFile( path); 
                  
                }
                 
               
                
            }
            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return valid;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Boolean isPDF(String... filenamePath)">
    /**
     *
     * @param Verifica si es una imagen
     * @return devuelve la extension de un archivo en un path
     */
    public Boolean isPDF(String... filenamePath) {
        String path = "";
        String extension = "";        
        Boolean valid = false;
        
        try {
            if (filenamePath.length != 0) {
                path = filenamePath[0];
                
            } else {
                path = (String) JmoordbCoreMediaContext.get("pathOfFile");
                
                if (path == null || path.equals("")) {
                    path = "";
                }
            }
            if (!path.equals("")) {
                extension = path.substring(path.lastIndexOf('.') + 1, path.length());
                
                if (extension.equals("pdf")) {
                    valid = true;
                }
            }
            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return valid;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Boolean isValid()">
    /**
     * Veririca si el media es un StreamContext valid
     *
     * @return
     */
    public Boolean isValid() {
        try {
            if (media != null || media.getStream() == null || media.getName() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean existsFile(String path)">
    /**
     * Verifica si existe el archivo
     *
     * @param path
     * @return
     */
    public Boolean existsFile(String path) {
        try {
            
            if (path == null || path.isBlank() || path.isEmpty()) {
            
                return false;
            }
            if (Files.exists(Paths.get(path))) {
            
                return true;
            }
            
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return false;
    }
    // </editor-fold>
    

    
    
    
}
