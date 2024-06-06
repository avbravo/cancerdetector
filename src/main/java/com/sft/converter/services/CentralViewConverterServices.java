/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.CentralView;
import com.sft.services.CentralViewServices;
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
public class CentralViewConverterServices implements Serializable {

    @Inject
    CentralViewServices centralViewServices;

    List<CentralView> centralViews = new ArrayList<>();

    public List<CentralView> getCentralViews() {
        return centralViews;
    }

    public void setCentralViews(List<CentralView> centralViews) {
        this.centralViews = centralViews;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<CentralView> get(Long id)">
    public Optional<CentralView> get(Long id) {
        Optional<CentralView> result;

        try {
            result = centralViews.stream().filter(x -> x.getIdcentral().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<CentralView> centralView = centralViewServices.findByIdcentral(id);
                if (centralView.isPresent()) {
                    centralViews.add(centralView.get());
                    return centralView;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<CentralView> centralViews)">

    public void add(List<CentralView> centralViews) {
        try {
            destroyed();
            this.centralViews = centralViews;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.centralViews = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
