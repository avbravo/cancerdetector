/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Zone;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface ZoneFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelZone(RowEditEvent<Zone> event)">
    public default void onRowCancelZone(RowEditEvent<Zone> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Zone> zoneFindFirst(List<Zone> zoneList, String search)">
    public default Optional<Zone> zoneFindFirst(List<Zone> zoneList, String search) {
        try {
          return zoneList.stream().filter(x -> x.getZone().equals(search)).findFirst();

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

