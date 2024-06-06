/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.converter.services;

import com.sft.jcache.*;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.UserView;
import com.sft.model.Tipotarjeta;
import com.sft.services.UserViewServices;
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
public class UserViewConverterServices implements Serializable {

    @Inject
    UserViewServices userViewServices;

    List<UserView> userViews = new ArrayList<>();

    public List<UserView> getUserViews() {
        return userViews;
    }

    public void setUserViews(List<UserView> userViews) {
        this.userViews = userViews;
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<UserView> get(Long id)">
    public Optional<UserView> get(Long id) {
        Optional<UserView> result;

        try {
            result = userViews.stream().filter(x -> x.getIduser().equals(id)).findFirst();
            if (!result.isPresent()) {
                Optional<UserView> userView = userViewServices.findByIduser(id);
                if (userView.isPresent()) {
                    userViews.add(userView.get());
                    return userView;
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
    // <editor-fold defaultstate="collapsed" desc="void add(List<UserView> userViews)">

    public void add(List<UserView> userViews) {
        try {
            destroyed();
            this.userViews = userViews;
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="void destroyed()">
    public void destroyed() {
        try {
            this.userViews = new ArrayList<>();
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

}
