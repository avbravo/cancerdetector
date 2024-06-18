/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Etiquetadoimagen;
import com.sft.model.Tipotarjeta;
import com.sft.services.EtiquetadoimagenServices;
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
public class EtiquetadoimagenConverterServices implements Serializable {

    @Inject
    EtiquetadoimagenServices etiquetadoimagenServices;

    List<Etiquetadoimagen> etiquetadoimagens = new ArrayList<>();

    public List<Etiquetadoimagen> getEtiquetadoimagens() {
        return etiquetadoimagens;
    }

    public void setEtiquetadoimagens(List<Etiquetadoimagen> etiquetadoimagens) {
        this.etiquetadoimagens = etiquetadoimagens;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Etiquetadoimagen> get(Long id)">
    public Optional<Etiquetadoimagen> get(Long id) {
        Optional<Etiquetadoimagen> result;

        try {
            result = etiquetadoimagens.stream().filter(x -> x.getIdetiquetadoimagen().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Etiquetadoimagen> etiquetadoimagen = etiquetadoimagenServices.findByIdetiquetadoimagen(id);
                if (etiquetadoimagen.isPresent()) {
                    etiquetadoimagens.add(etiquetadoimagen.get());
                    return etiquetadoimagen;
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
    // <editor-fold defaultstate="collapsed" desc="Optional<Etiquetadoimagen> get(String id)">
    public Optional<Etiquetadoimagen> get(String id) {
        Optional<Etiquetadoimagen> result;

        try {
            result = etiquetadoimagens.stream().filter(x -> x.getEtiquetadoimagen().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Etiquetadoimagen> etiquetadoimagen = etiquetadoimagenServices.findByEtiquetadoimagen(id);
                if (etiquetadoimagen.isPresent()) {
                    etiquetadoimagens.add(etiquetadoimagen.get());
                    return etiquetadoimagen;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Etiquetadoimagen> etiquetadoimagens)">

    public void add(List<Etiquetadoimagen> etiquetadoimagens) {
        try {
            destroyed();
            this.etiquetadoimagens = etiquetadoimagens;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.etiquetadoimagens = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
