/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.UserViewConverterServices;
import com.sft.model.UserView;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
//@RequestScoped
@Named
@FacesConverter(forClass = UserView.class, managed = true)
public class UserViewConverter implements Converter<UserView> {

    @Inject
    UserViewConverterServices userViewConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, UserView t) {
        try {
            if (t == null) {
                return "";
            }
            if (t.getIduser() != null) {
                return t.getIduser().toString();
            } else {
            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public UserView getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        UserView a = new UserView();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {

            Integer id = Integer.parseInt(submittedValue);

            Long idUserView = id.longValue();
           
            Optional<UserView> optional = userViewConverterServices.get(idUserView);
            if (optional.isPresent()) {
                
                a = optional.get();
            }
           
            return a;
        } catch (Exception e) {
            System.out.println("====================");
            System.out.println(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
    }

}
