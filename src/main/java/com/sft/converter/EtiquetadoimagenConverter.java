/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.EtiquetadoimagenConverterServices;
import com.sft.model.Etiquetadoimagen;
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
@FacesConverter(forClass = Etiquetadoimagen.class, managed = true)
public class EtiquetadoimagenConverter implements Converter<Etiquetadoimagen> {

    @Inject
    EtiquetadoimagenConverterServices etiquetadoimagenConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Etiquetadoimagen t) {
        try {
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[Etiquetadoimagen ] "+t.toString());
            if (t == null) {

                ConsoleUtil.test("\t{t == null}");
                return "";
            }

            if (t.getIdetiquetadoimagen() != null) {
       ConsoleUtil.test("\t{ t.getIdetiquetadoimagen() != null } "+t.toString());
                return t.getIdetiquetadoimagen().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Etiquetadoimagen getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Etiquetadoimagen a = new Etiquetadoimagen();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[submittedValue] "+submittedValue);
//            Integer id = Integer.parseInt(submittedValue);

//            Long idEtiquetadoimagen = id.longValue();

//            Optional<Etiquetadoimagen> optional = etiquetadoimagenConverterServices.get(idEtiquetadoimagen);
            Optional<Etiquetadoimagen> optional = etiquetadoimagenConverterServices.get(submittedValue.trim());
            ConsoleUtil.test("\toptional.get( "+optional.get());
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
