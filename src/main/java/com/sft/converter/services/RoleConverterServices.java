/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Role;
import com.sft.model.Tipotarjeta;
import com.sft.services.RoleServices;
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
public class RoleConverterServices implements Serializable {

    @Inject
    RoleServices roleServices;

    List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Role> get(Long id)">
    public Optional<Role> get(Long id) {
        Optional<Role> result;

        try {
            result = roles.stream().filter(x -> x.getIdrole().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<Role> role = roleServices.findByIdrole(id);
                if (role.isPresent()) {
                    roles.add(role.get());
                    return role;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<Role> roles)">

    public void add(List<Role> roles) {
        try {
            destroyed();
            this.roles = roles;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.roles = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
