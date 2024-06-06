/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Proyecto;
import com.sft.services.ProyectoServices;
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
public class ProyectoConverterServices implements Serializable {

    @Inject
    ProyectoServices proyectoServices;

    List<Proyecto> proyectos = new ArrayList<>();

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Proyecto> get(Long id)">
    public Optional<Proyecto> get(Long id) {
        Optional<Proyecto> result;

        try {
            result = proyectos.stream().filter(x -> x.getIdproyecto().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Proyecto> proyecto = proyectoServices.findByIdproyecto(id);
                if (proyecto.isPresent()) {
                    proyectos.add(proyecto.get());
                    return proyecto;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Proyecto> proyectos)">

    public void add(List<Proyecto> proyectos) {
        try {
            destroyed();
            this.proyectos = proyectos;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.proyectos = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
