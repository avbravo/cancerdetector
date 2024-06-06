/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.UserConverterServices;
import com.sft.model.User;
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
@FacesConverter(forClass = User.class, managed = true)
public class UserConverter implements Converter<User> {

    @Inject
    UserConverterServices userConverterServices;
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, User t) {
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
    public User getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        User a = new User();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.parseInt(submittedValue);
            Long idUser = id.longValue();
            Optional<User> optional = userConverterServices.get(idUser);
            if(optional.isPresent()){
                   a = optional.get();
            }

            return a;
        } catch (Exception e) {
          
              ConsoleUtil.error("\t "+FacesUtil.nameOfClassAndMethod()+" submittedValue " +submittedValue);
                        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
    }
}
