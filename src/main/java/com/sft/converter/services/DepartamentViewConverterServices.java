/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.DepartamentView;
import com.sft.services.DepartamentViewServices;
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
public class DepartamentViewConverterServices implements Serializable {

    @Inject
    DepartamentViewServices departamentViewServices;

    List<DepartamentView> departamentViews = new ArrayList<>();

    public List<DepartamentView> getDepartamentViews() {
        return departamentViews;
    }

    public void setDepartamentViews(List<DepartamentView> departamentViews) {
        this.departamentViews = departamentViews;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<DepartamentView> get(Long id)">
    public Optional<DepartamentView> get(Long id) {
        Optional<DepartamentView> result;

        try {
            result = departamentViews.stream().filter(x -> x.getIddepartament().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<DepartamentView> departamentView = departamentViewServices.findByIddepartament(id);
                if (departamentView.isPresent()) {
                    departamentViews.add(departamentView.get());
                    return departamentView;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<DepartamentView> departamentViews)">

    public void add(List<DepartamentView> departamentViews) {
        try {
            destroyed();
            this.departamentViews = departamentViews;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.departamentViews = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
