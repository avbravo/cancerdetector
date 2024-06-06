/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.services.ColorManagement;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ColorManagementImpl implements ColorManagement {
    // <editor-fold defaultstate="collapsed" desc="String color(Double value)">

    /**
     * Devuelve el color para usar con <p:knob>
     * @param value
     * @return 
     */
 public String color(Double value){
        String result ="black";
        try {
            if(value <=50){
                result="red";
            }else{
                if(value>51 && value<=70){
                    result="orange";
                }else{
                    if(value >71&& value <=90){
                        result ="blue";
                    }else{
                         result ="green";
                    }
                }
            }
       } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String color(Double value)">

    /**
     * Devuelve el color para usar con <p:knob>
     * @param value
     * @return 
     */
  public String color(Integer value){
        String result ="black";
          try {
            if(value <=50){
                result="red";
            }else{
                if(value>51 && value<=70){
                    result="orange";
                }else{
                    if(value >71&& value <=90){
                        result ="blue";
                    }else{
                         result ="green";
                    }
                }
            }
       } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String colorClassDashboard(Double value) ">

    @Override
    public String colorBarClassDashboard(Double value) {
        String result ="flex-1 bg-black-500 mr-2";
         
        try {
            if(value <=50){
                result="flex-1 bg-purple-50 mr-2";
            }else{
                if(value>51 && value<=70){
                    result="flex-1 bg-orange-500 mr-2";
                }else{
                    if(value >71&& value <=90){
                        result ="flex-1 bg-blue-500 mr-2";
                    }else{
                         result ="flex-1 bg-green-500 mr-2";
                    }
                }
            }
       } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="String colorClassDashboard(Integer value)>

    @Override
    public String colorBarClassDashboard(Integer value) {
    String result ="flex-1 bg-black-500 mr-2";

        try {
            if(value <=50){
                result="flex-1 bg-purple-50 mr-2";
            }else{
                if(value>51 && value<=70){
                    result="flex-1 bg-orange-500 mr-2";
                }else{
                    if(value >71&& value <=90){
                        result ="flex-1 bg-blue-500 mr-2";
                    }else{
                         result ="flex-1 bg-green-500 mr-2";
                    }
                }
            }
             } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String colorTimeLineDashboard(Double value) ">

    @Override
    public String colorTimeLineDashboard(Double value) {
       String result ="h-full bg-orange-500";

        try {
            if(value <=50){
                result="h-full bg-purple-500";
            }else{
                if(value>51 && value<=70){
                    result="h-full bg-orange-500";
                }else{
                    if(value >71&& value <=90){
                        result ="h-full bg-blue-500";
                    }else{
                         result ="h-full bg-green-500";
                    }
                }
            }
             } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
}
