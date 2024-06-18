/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Motivo;
import com.sft.model.Tipotarjeta;
import com.sft.services.MotivoServices;
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
public class MotivoConverterServices implements Serializable {

    @Inject
    MotivoServices motivoServices;

    List<Motivo> motivos = new ArrayList<>();

    public List<Motivo> getMotivos() {
        return motivos;
    }

    public void setMotivos(List<Motivo> motivos) {
        this.motivos = motivos;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Motivo> get(Long id)">
    public Optional<Motivo> get(Long id) {
        Optional<Motivo> result;

        try {
            result = motivos.stream().filter(x -> x.getIdmotivo().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Motivo> motivo = motivoServices.findByIdmotivo(id);
                if (motivo.isPresent()) {
                    motivos.add(motivo.get());
                    return motivo;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Motivo> motivos)">

    public void add(List<Motivo> motivos) {
        try {
            destroyed();
            this.motivos = motivos;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.motivos = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
