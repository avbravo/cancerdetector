/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.PcritsConverterServices;
import com.sft.model.Pcrits;
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
@FacesConverter(forClass = Pcrits.class, managed = true)
public class PcritsConverter implements Converter<Pcrits> {

    @Inject
    PcritsConverterServices pcritsConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Pcrits t) {
        try {
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[Pcrits ] "+t.toString());
            if (t == null) {

                ConsoleUtil.test("\t{t == null}");
                return "";
            }

            if (t.getIdpcrits() != null) {
       ConsoleUtil.test("\t{ t.getIdpcrits() != null } "+t.toString());
                return t.getIdpcrits().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Pcrits getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Pcrits a = new Pcrits();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[submittedValue] "+submittedValue);
//            Integer id = Integer.parseInt(submittedValue);

//            Long idPcrits = id.longValue();

//            Optional<Pcrits> optional = pcritsConverterServices.get(idPcrits);
            Optional<Pcrits> optional = pcritsConverterServices.get(submittedValue.trim());
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
