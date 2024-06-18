/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Resultadocultivo;
import com.sft.services.ResultadocultivoServices;
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
public class ResultadocultivoConverterServices implements Serializable {

    @Inject
    ResultadocultivoServices resultadocultivoServices;

    List<Resultadocultivo> resultadocultivos = new ArrayList<>();

    public List<Resultadocultivo> getResultadocultivos() {
        return resultadocultivos;
    }

    public void setResultadocultivos(List<Resultadocultivo> resultadocultivos) {
        this.resultadocultivos = resultadocultivos;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Resultadocultivo> get(Long id)">
    public Optional<Resultadocultivo> get(Long id) {
        Optional<Resultadocultivo> result;

        try {
            result = resultadocultivos.stream().filter(x -> x.getIdresultadocultivo().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Resultadocultivo> resultadocultivo = resultadocultivoServices.findByIdresultadocultivo(id);
                if (resultadocultivo.isPresent()) {
                    resultadocultivos.add(resultadocultivo.get());
                    return resultadocultivo;
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
    // <editor-fold defaultstate="collapsed" desc="Optional<Resultadocultivo> get(String id)">
    public Optional<Resultadocultivo> get(String id) {
        Optional<Resultadocultivo> result;

        try {
            result = resultadocultivos.stream().filter(x -> x.getResultadocultivo().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Resultadocultivo> resultadocultivo = resultadocultivoServices.findByResultadocultivo(id);
                if (resultadocultivo.isPresent()) {
                    resultadocultivos.add(resultadocultivo.get());
                    return resultadocultivo;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Resultadocultivo> resultadocultivos)">

    public void add(List<Resultadocultivo> resultadocultivos) {
        try {
            destroyed();
            this.resultadocultivos = resultadocultivos;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.resultadocultivos = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
