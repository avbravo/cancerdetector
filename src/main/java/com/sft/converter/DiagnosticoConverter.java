/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.DiagnosticoConverterServices;
import com.sft.model.Diagnostico;
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
@FacesConverter(forClass = Diagnostico.class, managed = true)
public class DiagnosticoConverter implements Converter<Diagnostico> {

    @Inject
    DiagnosticoConverterServices diagnosticoConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Diagnostico t) {
        try {
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[Diagnostico ] "+t.toString());
            if (t == null) {

                ConsoleUtil.test("\t{t == null}");
                return "";
            }

            if (t.getIddiagnostico() != null) {
       ConsoleUtil.test("\t{ t.getIddiagnostico() != null } "+t.toString());
                return t.getIddiagnostico().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Diagnostico getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Diagnostico a = new Diagnostico();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[submittedValue] "+submittedValue);
//            Integer id = Integer.parseInt(submittedValue);

//            Long idiagnostico = id.longValue();

//            Optional<Diagnostico> optional = diagnosticoConverterServices.get(idiagnostico);
            Optional<Diagnostico> optional = diagnosticoConverterServices.get(submittedValue.trim());
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
