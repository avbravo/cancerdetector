/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Province;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface ProvinceFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelProvince(RowEditEvent<Province> event)">
    public default void onRowCancelProvince(RowEditEvent<Province> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Province> provinceFindFirst(List<Province> provinceList, String search)">
    public default Optional<Province> provinceFindFirst(List<Province> provinceList, String search) {
        try {
          return provinceList.stream().filter(x -> x.getProvince().equals(search)).findFirst();

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

