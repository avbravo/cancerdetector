/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Institution;
import com.sft.services.InstitutionServices;
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
public class InstitutionConverterServices implements Serializable {

    @Inject
    InstitutionServices institutionServices;

    List<Institution> institutions = new ArrayList<>();

    public List<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Institution> get(Long id)">
    public Optional<Institution> get(Long id) {
        Optional<Institution> result;

        try {
            result = institutions.stream().filter(x -> x.getIdinstitution().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Institution> institution = institutionServices.findByIdinstitution(id);
                if (institution.isPresent()) {
                    institutions.add(institution.get());
                    return institution;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Institution> institutions)">

    public void add(List<Institution> institutions) {
        try {
            destroyed();
            this.institutions = institutions;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.institutions = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
