/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import org.primefaces.event.CloseEvent;

/**
 *
 * @author avbravo
 */
public interface FacesServices {
    
    public String refresh();


    public void handleCloseDialogRefresh(CloseEvent event);
}
