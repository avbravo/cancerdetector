/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Sprint;
import com.sft.services.SprintServices;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@ViewScoped
@Named
public class SprintConverterServices implements Serializable {

    @Inject
    SprintServices sprintServices;


    
    List<Sprint> sprints = new ArrayList<>();

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Sprint> get(Long id)">
    public Optional<Sprint> get(Long id) {
        Optional<Sprint> result;

        try {
               
            result = sprints.stream().filter(x -> x.getIdsprint().equals(id)).findFirst();
            if (!result.isPresent()) {
                         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " Falta identificar un proyecto en SprintConverterServices");
//                Optional<Sprint> sprint = sprintServices.findByIdsprint(id);
//                if (sprint.isPresent()) {
//                    sprints.add(sprint.get());
//                    return sprint;
//                }
                result = Optional.empty();
            }
            return result;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void add(List<Sprint> sprints)">

    public void add(List<Sprint> sprints) {
        try {
            destroyed();
            this.sprints = sprints;
            /**
             * Caso especial porque se necesita conocer el id de proyectos para buscar las sprints
             */
          
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.sprints = new ArrayList<>();

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
