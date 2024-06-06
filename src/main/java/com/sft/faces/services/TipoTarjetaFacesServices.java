/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Tipotarjeta;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface TipoTarjetaFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelTipotarjeta(RowEditEvent<Tipotarjeta> event)">
    public default void onRowCancelTipotarjeta(RowEditEvent<Tipotarjeta> event) {
    }

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc=" Optional<Tipotarjeta> sprintFindFirst(List<Tipotarjeta> sprintList, String search)">
    public default Optional<Tipotarjeta> tipotarjetaFindFirst(List<Tipotarjeta> tipotarjetaList, String search) {
        try {
          return tipotarjetaList.stream().filter(x -> x.getTipotarjeta().equals(search)).findFirst();

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

