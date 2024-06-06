/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.District;
import com.sft.services.DistrictServices;
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
public class DistrictConverterServices implements Serializable {

    @Inject
    DistrictServices districtServices;

    List<District> districts = new ArrayList<>();

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<District> get(Long id)">
    public Optional<District> get(Long id) {
        Optional<District> result;

        try {
            result = districts.stream().filter(x -> x.getIddistrict().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<District> district = districtServices.findByIddistrict(id);
                if (district.isPresent()) {
                    districts.add(district.get());
                    return district;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<District> districts)">

    public void add(List<District> districts) {
        try {
            destroyed();
            this.districts = districts;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.districts = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
