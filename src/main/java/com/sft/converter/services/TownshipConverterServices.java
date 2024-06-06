/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Township;
import com.sft.services.TownshipServices;
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
public class TownshipConverterServices implements Serializable {

    @Inject
    TownshipServices townshipServices;

    List<Township> townships = new ArrayList<>();

    public List<Township> getTownships() {
        return townships;
    }

    public void setTownships(List<Township> townships) {
        this.townships = townships;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Township> get(Long id)">
    public Optional<Township> get(Long id) {
        Optional<Township> result;

        try {
            result = townships.stream().filter(x -> x.getIdtownship().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Township> township = townshipServices.findByIdtownship(id);
                if (township.isPresent()) {
                    townships.add(township.get());
                    return township;
                }
                result = Optional.empty();
            }
            return result;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void add(List<Township> townships)">

    public void add(List<Township> townships) {
        try {
            destroyed();
            this.townships = townships;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.townships = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
