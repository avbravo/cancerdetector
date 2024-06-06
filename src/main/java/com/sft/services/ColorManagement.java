/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.avbravo.jmoordbutils.FacesUtil;

/**
 *
 * @author avbravo
 */
public interface ColorManagement {
    
 public String color(Double value);
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String color(Double value)">

    /**
     * Devuelve el color para usar con <p:knob>
     * @param value
     * @return 
     */
 public String color(Integer value);
 
 public String colorBarClassDashboard(Double value);
 public String colorBarClassDashboard(Integer value);
 
 public String colorTimeLineDashboard(Double value);
      
}
