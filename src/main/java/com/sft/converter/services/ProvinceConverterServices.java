/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Province;
import com.sft.services.ProvinceServices;
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
public class ProvinceConverterServices implements Serializable {

    @Inject
    ProvinceServices provinceServices;

    List<Province> provinces = new ArrayList<>();

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Province> get(Long id)">
    public Optional<Province> get(Long id) {
        Optional<Province> result;
 
        try {
        
            
            result = provinces.stream().filter(x -> x.getIdprovince().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Province> province = provinceServices.findByIdprovince(id);
                if (province.isPresent()) {
                    provinces.add(province.get());
                    return province;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Province> provinces)">

    public void add(List<Province> provinces) {
        try {
         
            destroyed();
            this.provinces = provinces;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.provinces = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
