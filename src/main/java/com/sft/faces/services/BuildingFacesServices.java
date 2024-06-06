/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Building;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface BuildingFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelBuilding(RowEditEvent<Building> event)">
    public default void onRowCancelBuilding(RowEditEvent<Building> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Building> buildingFindFirst(List<Building> buildingList, String search)">
    public default Optional<Building> buildingFindFirst(List<Building> buildingList, String search) {
        try {
          return buildingList.stream().filter(x -> x.getBuilding().equals(search)).findFirst();

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

