/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.IconoConverterServices;
import com.sft.model.Icono;
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
@FacesConverter(forClass = Icono.class, managed = true)
public class IconoConverter implements Converter<Icono> {

    @Inject
    IconoConverterServices iconoConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Icono t) {
        try {

            if (t == null) {

                return "";
            }

            if (t.getIdicono() != null) {

                return t.getIdicono().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Icono getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Icono a = new Icono();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;

            Integer id = Integer.parseInt(submittedValue);

            Long idIcono = id.longValue();

            Optional<Icono> optional = iconoConverterServices.get(idIcono);

            if (!optional.isEmpty()) {

               return optional.get();
            }
            
        } catch (Exception e) {

            
            ConsoleUtil.error("\t " + FacesUtil.nameOfClassAndMethod() + " submittedValue " + submittedValue);
            
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
        return a;
    }

}
