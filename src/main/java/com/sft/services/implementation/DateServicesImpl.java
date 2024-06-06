/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaContext;
import com.avbravo.jmoordbutils.media.JmoordbCoreMediaManager;
import com.sft.services.DateServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class DateServicesImpl implements DateServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    @Inject
    JmoordbCoreMediaManager jmoordbCoreMediaManager;
    @Inject
    JmoordbCoreMediaContext jmoordbCoreMediaContext;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean fechaMayor(Date fechainicial, Date fechafinal)">

    @Override
    public Boolean fechaMayor(Date fechainicial, Date fechafinal) {
        Boolean result = Boolean.FALSE;
       try{
           if(DateUtil.fechaMayor(fechainicial, fechainicial)){
       FacesUtil.warningDialog(rf.fromCore("warning.save"),rf.fromCore("warning.fechainicialmayorfechafinal"));
           }else{
               
           }
       } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
       return result;
    }
    // </editor-fold>
    
}
