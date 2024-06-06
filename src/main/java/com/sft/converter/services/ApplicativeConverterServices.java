/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Applicative;
import com.sft.services.ApplicativeServices;
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
public class ApplicativeConverterServices implements Serializable {

    @Inject
    ApplicativeServices applicativeServices;

    List<Applicative> applicatives = new ArrayList<>();

    public List<Applicative> getApplicatives() {
        return applicatives;
    }

    public void setApplicatives(List<Applicative> applicatives) {
        this.applicatives = applicatives;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Applicative> get(Long id)">
    public Optional<Applicative> get(Long id) {
        Optional<Applicative> result;

        try {
            result = applicatives.stream().filter(x -> x.getIdapplicative().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Applicative> applicative = applicativeServices.findByIdapplicative(id);
                if (applicative.isPresent()) {
                    applicatives.add(applicative.get());
                    return applicative;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Applicative> applicatives)">

    public void add(List<Applicative> applicatives) {
        try {
            destroyed();
            this.applicatives = applicatives;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.applicatives = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
