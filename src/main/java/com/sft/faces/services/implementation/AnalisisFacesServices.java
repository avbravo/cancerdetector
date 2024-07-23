/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Analisis;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface AnalisisFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelAnalisis(RowEditEvent<Analisis> event)">
    public default void onRowCancelAnalisis(RowEditEvent<Analisis> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Analisis> analisisFindFirst(List<Analisis> analisisList, String search)">
    public default Optional<Analisis> analisisFindFirst(List<Analisis> analisisList, String search) {
        try {
          return analisisList.stream().filter(x -> x.getId().equals(search)).findFirst();

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

