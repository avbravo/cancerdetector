/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Tipotarjeta;
import com.sft.services.TipotarjetaServices;
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
public class TipoTarjetaConverterServices implements Serializable {

    @Inject
    TipotarjetaServices tipotarjetaServices;

    List<Tipotarjeta> tipotarjetas = new ArrayList<>();

    public List<Tipotarjeta> getTipotarjetas() {
        return tipotarjetas;
    }

    public void setTipotarjetas(List<Tipotarjeta> tipotarjetas) {
        this.tipotarjetas = tipotarjetas;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Tipotarjeta> get(Long id)">
    public Optional<Tipotarjeta> get(Long id) {
        Optional<Tipotarjeta> result;

        try {
        
            result = tipotarjetas.stream().filter(x -> x.getIdtipotarjeta().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Tipotarjeta> tipotarjeta = tipotarjetaServices.findByIdtipotarjeta(id);
                if (tipotarjeta.isPresent()) {
                    tipotarjetas.add(tipotarjeta.get());
                    return tipotarjeta;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Tipotarjeta> tipotarjetas)">

    public void add(List<Tipotarjeta> tipotarjetas) {
        try {
            destroyed();
            this.tipotarjetas = tipotarjetas;
           
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.tipotarjetas = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
