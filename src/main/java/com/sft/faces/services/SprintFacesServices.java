/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.Tarea;
import com.sft.model.User;
import com.sft.model.UserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author avbravo
 */
public interface SprintFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelSprint(RowEditEvent<Sprint> event)">
    public default void onRowCancelSprint(RowEditEvent<Sprint> event) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Optional<Sprint> sprintFindFirst(List<Sprint> sprintList, String search)">
    public default Optional<Sprint> sprintFindFirst(List<Sprint> sprintList, String search) {
        try {
            return sprintList.stream().filter(x -> x.getSprint().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="updateClientId(String clientId)">
    public default void updateClientId(String clientId) {

        PrimeFaces.current().ajax().update(clientId);

    }
// </editor-fold>

    
}
