/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Zone;
import com.sft.services.ZoneServices;
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
public class ZoneConverterServices implements Serializable {

    @Inject
    ZoneServices zoneServices;

    List<Zone> zones = new ArrayList<>();

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Zone> get(Long id)">
    public Optional<Zone> get(Long id) {
        Optional<Zone> result;

        try {
            result = zones.stream().filter(x -> x.getIdzone().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Zone> zone = zoneServices.findByIdzone(id);
                if (zone.isPresent()) {
                    zones.add(zone.get());
                    return zone;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Zone> zones)">

    public void add(List<Zone> zones) {
        try {
            destroyed();
            this.zones = zones;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.zones = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
