/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;


import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.sft.model.Applicative;
import com.sft.model.Applicativerole;
import com.sft.model.Profile;
import com.sft.model.User;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface LoginValidateServices {

    // <editor-fold defaultstate="collapsed" desc="Boolean validateProfileUser(List<Profile> profileListLogged, User userLogged, JmoordbResourcesFiles rf, Applicative applicative)">
    default Boolean validateProfileUser(List<Profile> profileListLogged, User userLogged, JmoordbResourcesFiles rf, Applicative applicative) {
        Boolean result = Boolean.FALSE;

        try {
            if (userLogged == null || userLogged.getIduser() == null) {

                FacesUtil.warningMessage(rf.fromCore("login.usernamenotvalid"));
                return result;
            } else {
                if (!userLogged.getActive()) {
                    FacesUtil.warningMessage(rf.fromCore("login.userinactive"));
                    return result;
                }
                if (userLogged.getProfile() == null || userLogged.getProfile().isEmpty()) {
                    FacesUtil.warningMessage(rf.fromCore("login.nothaveprofile"));
                    return result;
                }

                /**
                 * Recorrer el profile y asignarle un valor secuencial a id
                 */
                Long counter = 0L;

                for (Applicativerole applicativerole : applicative.getApplicativerole()) {

                    if (applicativerole.getActive()) {
                        for (Profile p : userLogged.getProfile()) {

                            if (p.getApplicativeView().getIdapplicative().equals(applicative.getIdapplicative())) {

                                if (p.getRole().getIdrole().equals(applicativerole.getIdrole())) {
                                    counter++;
                                    p.setId(counter);
                                    profileListLogged.add(p);
                                }
                            }
                        }
                    }
                }

                if (profileListLogged == null || profileListLogged.isEmpty()) {
                    FacesUtil.warningMessage(rf.fromCore("login.usernohaveprofileforthisapplicative"));
                    return result;
                }
                result = Boolean.TRUE;

            }
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean validateRoles()">
    /**
     * Valida los roles del applicativo
     *
     * @return
     */
    default Boolean validateRoles(JmoordbResourcesFiles rf, Applicative applicativeLogged) {
        Boolean result = Boolean.FALSE;
        try {

            if (applicativeLogged.getApplicativerole() == null || applicativeLogged.getApplicativerole().isEmpty()) {
                FacesUtil.warningMessage(rf.fromCore("applicative.nohaverole"));
                return Boolean.FALSE;
            }

            for (Applicativerole applicativerole : applicativeLogged.getApplicativerole()) {

                if (applicativerole.getActive()) {
                    result = Boolean.TRUE;
                    break;
                }
            }

            if (!result) {
                FacesUtil.warningMessage(rf.fromCore("applicative.nohaveactiverole"));
                return Boolean.FALSE;
            }

        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }
        return result;
    }

    // </editor-fold>
    
}
