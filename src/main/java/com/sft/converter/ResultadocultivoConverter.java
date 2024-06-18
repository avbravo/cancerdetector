/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.ResultadocultivoConverterServices;
import com.sft.model.Resultadocultivo;
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
@FacesConverter(forClass = Resultadocultivo.class, managed = true)
public class ResultadocultivoConverter implements Converter<Resultadocultivo> {

    @Inject
    ResultadocultivoConverterServices resultadocultivoConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Resultadocultivo t) {
        try {
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[Resultadocultivo ] "+t.toString());
            if (t == null) {

                ConsoleUtil.test("\t{t == null}");
                return "";
            }

            if (t.getIdresultadocultivo() != null) {
       ConsoleUtil.test("\t{ t.getIdresultadocultivo() != null } "+t.toString());
                return t.getIdresultadocultivo().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Resultadocultivo getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Resultadocultivo a = new Resultadocultivo();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;
ConsoleUtil.test(FacesUtil.nameOfClassAndMethod()+"\t[submittedValue] "+submittedValue);
//            Integer id = Integer.parseInt(submittedValue);

//            Long idResultadocultivo = id.longValue();

//            Optional<Resultadocultivo> optional = resultadocultivoConverterServices.get(idResultadocultivo);
            Optional<Resultadocultivo> optional = resultadocultivoConverterServices.get(submittedValue.trim());
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
