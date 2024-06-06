/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.sft.model.Profile;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Named
@FacesConverter(forClass = Profile.class, managed = true)
public class ProfileConverter implements Converter<Profile> {

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Profile t) {
        try {

            if (t == null) {

                return "";
            }

            if (t.getId() != null) {

                return t.getId().toString();
            } else {

            }

        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public Profile getAsObject(FacesContext fc, UIComponent uic, String string) {
        Profile profile = new Profile();
        try {

            if (string == null || string.isEmpty()) {
                return null;
            }

            Long id = Long.parseLong(string);

            List<Profile> profileList = (List<Profile>) JmoordbCoreContext.get("profileListLogged");

            for (Profile p : profileList) {

                if (p.getId() == id) {
                    profile = p;
                    break;
                }
            }

            return profile;
        } catch (NumberFormatException e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         System.out.println(FacesUtil.nameOfClassAndMethod()+" " +e.getLocalizedMessage());
        }
        return profile;
    }

}
