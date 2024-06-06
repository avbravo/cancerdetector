/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Township;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface TownshipFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelTownship(RowEditEvent<Township> event)">
    public default void onRowCancelTownship(RowEditEvent<Township> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Township> townshipFindFirst(List<Township> townshipList, String search)">
    public default Optional<Township> townshipFindFirst(List<Township> townshipList, String search) {
        try {
          return townshipList.stream().filter(x -> x.getTownship().equals(search)).findFirst();

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

