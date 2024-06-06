/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.configuration;

import com.avbravo.jmoordbutils.FacesUtil;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author avbravo
 */
   @Named
@ViewScoped
public class NavigatorFaces implements Serializable {

// <editor-fold defaultstate="collapsed" desc="fiedls">
        private static final long serialVersionUID = 1L;
// </editor-fold>
    /**
     * Creates a new instance of NavigatorController
     */
    public NavigatorFaces() {
    }
    
       // <editor-fold defaultstate="collapsed" desc="String go(String pathPage)">    

    public String go(String pathPage){

        try {

//              JmoordbContext.put("pageInView", pathPage);
      
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + " "+e.getLocalizedMessage());
        }
       
        
      
        return pathPage;
    }
    // </editor-fold>
    
    


}
