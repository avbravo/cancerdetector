/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Icono;
import com.sft.model.Tipotarjeta;
import com.sft.services.IconoServices;
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
public class IconoConverterServices implements Serializable {

    @Inject
    IconoServices iconoServices;

    List<Icono> iconos = new ArrayList<>();

    public List<Icono> getIconos() {
        return iconos;
    }

    public void setIconos(List<Icono> iconos) {
        this.iconos = iconos;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Icono> get(Long id)">
    public Optional<Icono> get(Long id) {
        Optional<Icono> result;

        try {
            result = iconos.stream().filter(x -> x.getIdicono().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Icono> icono = iconoServices.findByIdicono(id);
                if (icono.isPresent()) {
                    iconos.add(icono.get());
                    return icono;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Icono> iconos)">

    public void add(List<Icono> iconos) {
        try {
            destroyed();
            this.iconos = iconos;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.iconos = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
