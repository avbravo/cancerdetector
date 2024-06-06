/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Icono;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface IconoFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelIcono(RowEditEvent<Icono> event)">
    public default void onRowCancelIcono(RowEditEvent<Icono> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Icono> iconoFindFirst(List<Icono> iconoList, String search)">
    public default Optional<Icono> iconoFindFirst(List<Icono> iconoList, String search) {
        try {
          return iconoList.stream().filter(x -> x.getIcono().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="updateClientId(String clientId)">
    public default void updateClientId(String clientId){

            PrimeFaces.current().ajax().update(clientId);
          
    }
// </editor-fold>
    
}

