/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Departament;
import com.sft.services.DepartamentServices;
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
public class DepartamentConverterServices implements Serializable {

    @Inject
    DepartamentServices departamentServices;

    List<Departament> departaments = new ArrayList<>();

    public List<Departament> getDepartaments() {
        return departaments;
    }

    public void setDepartaments(List<Departament> departaments) {
        this.departaments = departaments;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Departament> get(Long id)">
    public Optional<Departament> get(Long id) {
        Optional<Departament> result;

        try {
            result = departaments.stream().filter(x -> x.getIddepartament().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Departament> departament = departamentServices.findByIddepartament(id);
                if (departament.isPresent()) {
                    departaments.add(departament.get());
                    return departament;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Departament> departaments)">

    public void add(List<Departament> departaments) {
        try {
            destroyed();
            this.departaments = departaments;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.departaments = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
