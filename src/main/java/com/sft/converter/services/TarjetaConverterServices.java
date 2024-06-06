/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Tarjeta;
import com.sft.services.TarjetaServices;
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
public class TarjetaConverterServices implements Serializable {

    @Inject
    TarjetaServices tarjetaServices;


    
    List<Tarjeta> tarjetas = new ArrayList<>();

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Tarjeta> get(Long id)">
    public Optional<Tarjeta> get(Long id) {
        Optional<Tarjeta> result;

        try {
            result = tarjetas.stream().filter(x -> x.getIdtarjeta().equals(id)).findFirst();
            if (!result.isPresent()) {
                         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " Falta identificar un proyecto en TarjetaConverterServices");
//                Optional<Tarjeta> tarjeta = tarjetaServices.findByIdtarjeta(id);
//                if (tarjeta.isPresent()) {
//                    tarjetas.add(tarjeta.get());
//                    return tarjeta;
//                }
                result = Optional.empty();
            }
            return result;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void add(List<Tarjeta> tarjetas)">

    public void add(List<Tarjeta> tarjetas) {
        try {
            destroyed();
            this.tarjetas = tarjetas;
            /**
             * Caso especial porque se necesita conocer el id de proyectos para buscar las tarjetas
             */
          
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.tarjetas = new ArrayList<>();

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
