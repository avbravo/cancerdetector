/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Pcrits;
import com.sft.model.Tipotarjeta;
import com.sft.services.PcritsServices;
import jakarta.enterprise.context.SessionScoped;
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
public class PcritsConverterServices implements Serializable {

    @Inject
    PcritsServices pcritsServices;

    List<Pcrits> pcritss = new ArrayList<>();

    public List<Pcrits> getPcritss() {
        return pcritss;
    }

    public void setPcritss(List<Pcrits> pcritss) {
        this.pcritss = pcritss;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Pcrits> get(Long id)">
    public Optional<Pcrits> get(Long id) {
        Optional<Pcrits> result;

        try {
            result = pcritss.stream().filter(x -> x.getIdpcrits().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Pcrits> pcrits = pcritsServices.findByIdpcrits(id);
                if (pcrits.isPresent()) {
                    pcritss.add(pcrits.get());
                    return pcrits;
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
    // <editor-fold defaultstate="collapsed" desc="Optional<Pcrits> get(String id)">
    public Optional<Pcrits> get(String id) {
        Optional<Pcrits> result;

        try {
            result = pcritss.stream().filter(x -> x.getPcrits().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Pcrits> pcrits = pcritsServices.findByPcrits(id);
                if (pcrits.isPresent()) {
                    pcritss.add(pcrits.get());
                    return pcrits;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Pcrits> pcritss)">

    public void add(List<Pcrits> pcritss) {
        try {
            destroyed();
            this.pcritss = pcritss;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.pcritss = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
