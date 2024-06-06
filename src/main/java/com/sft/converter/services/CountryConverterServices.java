/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Country;
import com.sft.services.CountryServices;
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
public class CountryConverterServices implements Serializable {

    @Inject
    CountryServices countryServices;

    List<Country> countrys = new ArrayList<>();

    public List<Country> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<Country> countrys) {
        this.countrys = countrys;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Country> get(Long id)">
    public Optional<Country> get(String id) {
        Optional<Country> result;

        try {
            result = countrys.stream().filter(x -> x.getIdcountry().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Country> country = countryServices.findByIdcountry(id);
                if (country.isPresent()) {
                    countrys.add(country.get());
                    return country;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Country> countrys)">

    public void add(List<Country> countrys) {
        try {
            destroyed();
            this.countrys = countrys;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.countrys = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
