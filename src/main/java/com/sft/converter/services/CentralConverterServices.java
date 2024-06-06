/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Central;
import com.sft.services.CentralServices;
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
public class CentralConverterServices implements Serializable {

    @Inject
    CentralServices centralServices;

    List<Central> centrals = new ArrayList<>();

    public List<Central> getCentrals() {
        return centrals;
    }

    public void setCentrals(List<Central> centrals) {
        this.centrals = centrals;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Central> get(Long id)">
    public Optional<Central> get(Long id) {
        Optional<Central> result;

        try {
            result = centrals.stream().filter(x -> x.getIdcentral().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Central> central = centralServices.findByIdcentral(id);
                if (central.isPresent()) {
                    centrals.add(central.get());
                    return central;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Central> centrals)">

    public void add(List<Central> centrals) {
        try {
            destroyed();
            this.centrals = centrals;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.centrals = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
