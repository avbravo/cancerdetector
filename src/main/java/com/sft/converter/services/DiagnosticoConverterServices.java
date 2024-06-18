/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Diagnostico;
import com.sft.model.Tipotarjeta;
import com.sft.services.DiagnosticoServices;
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
public class DiagnosticoConverterServices implements Serializable {

    @Inject
    DiagnosticoServices diagnosticoServices;

    List<Diagnostico> diagnosticos = new ArrayList<>();

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Diagnostico> get(Long id)">
    public Optional<Diagnostico> get(Long id) {
        Optional<Diagnostico> result;

        try {
            result = diagnosticos.stream().filter(x -> x.getIddiagnostico().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Diagnostico> diagnostico = diagnosticoServices.findByIddiagnostico(id);
                if (diagnostico.isPresent()) {
                    diagnosticos.add(diagnostico.get());
                    return diagnostico;
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
    // <editor-fold defaultstate="collapsed" desc="Optional<Diagnostico> get(String id)">
    public Optional<Diagnostico> get(String id) {
        Optional<Diagnostico> result;

        try {
            result = diagnosticos.stream().filter(x -> x.getDiagnostico().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Diagnostico> diagnostico = diagnosticoServices.findByDiagnostico(id);
                if (diagnostico.isPresent()) {
                    diagnosticos.add(diagnostico.get());
                    return diagnostico;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Diagnostico> diagnosticos)">

    public void add(List<Diagnostico> diagnosticos) {
        try {
            destroyed();
            this.diagnosticos = diagnosticos;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.diagnosticos = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
