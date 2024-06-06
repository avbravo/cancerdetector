/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.GrupoTipoTarjeta;
import com.sft.services.GrupoTipoTarjetaServices;
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
public class GrupoTipoTarjetaConverterServices implements Serializable {

    @Inject
    GrupoTipoTarjetaServices grupoTipoTarjetaServices;

    List<GrupoTipoTarjeta> grupoTipoTarjetas = new ArrayList<>();

    public List<GrupoTipoTarjeta> getGrupoTipoTarjetas() {
        return grupoTipoTarjetas;
    }

    public void setGrupoTipoTarjetas(List<GrupoTipoTarjeta> grupoTipoTarjetas) {
        this.grupoTipoTarjetas = grupoTipoTarjetas;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<GrupoTipoTarjeta> get(Long id)">
    public Optional<GrupoTipoTarjeta> get(Long id) {
        Optional<GrupoTipoTarjeta> result;

        try {
            result = grupoTipoTarjetas.stream().filter(x -> x.getIdgrupotipotarjeta().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<GrupoTipoTarjeta> grupoTipoTarjeta = grupoTipoTarjetaServices.findByIdgrupoTipoTarjeta(id);
                if (grupoTipoTarjeta.isPresent()) {
                    grupoTipoTarjetas.add(grupoTipoTarjeta.get());
                    return grupoTipoTarjeta;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<GrupoTipoTarjeta> grupoTipoTarjetas)">

    public void add(List<GrupoTipoTarjeta> grupoTipoTarjetas) {
        try {
            destroyed();
            this.grupoTipoTarjetas = grupoTipoTarjetas;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.grupoTipoTarjetas = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
