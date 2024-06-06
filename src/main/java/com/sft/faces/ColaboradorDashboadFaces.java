/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import com.sft.restclient.UserRestClient;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Data
public class ColaboradorDashboadFaces implements Serializable{
    
      // <editor-fold defaultstate="collapsed" desc=" fields">
       private static final long serialVersionUID = 1L;
       private String name;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    UserRestClient userClient;
// </editor-fold>
    
    
       // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
    name="Wecome to "+new Date();
    }
// </editor-fold>
}
