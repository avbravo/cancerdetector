/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.configuration;


import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordb.core.util.ConsoleUtil;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@Stateless
public class ApplicationScheduler implements Serializable{
    
    // <editor-fold defaultstate="collapsed" desc="fields">

    private static final long serialVersionUID = 1L;
     // </editor-fold>

   
    /**
     * Creates a new instance of ApplicationStart
     */
    public ApplicationScheduler() {
    }
      // <editor-fold defaultstate="collapsed" desc="init">
//   @Schedule(minute = "53", hour = "23",dayOfMonth="28", persistent = false)
//   @Schedule(minute = "*", hour = "*",dayOfMonth="*", second = "0,10,20,30,40,50",persistent = false)
   @Schedule(minute = "40", hour = "23",dayOfMonth="*",persistent = false)


    public void verify() {
        try {
            ConsoleUtil.info("*************************************************");
           ConsoleUtil.info(FacesUtil.nameOfClassAndMethod() + " at "+new Date());
               ConsoleUtil.info("*************************************************");
            // Boletas boletas = (Boletas) JmoordbContext.get("jmoordb_boletas");
          
       } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }

}
