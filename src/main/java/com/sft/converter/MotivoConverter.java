/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.MotivoConverterServices;
import com.sft.model.Motivo;
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
@FacesConverter(forClass = Motivo.class, managed = true)
public class MotivoConverter implements Converter<Motivo> {

    @Inject
    MotivoConverterServices motivoConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Motivo t) {
        try {

            if (t == null) {

                return "";
            }

            if (t.getIdmotivo() != null) {

                return t.getIdmotivo().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Motivo getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Motivo a = new Motivo();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            // String idUser =submittedValue;

            Integer id = Integer.parseInt(submittedValue);

            Long idMotivo = id.longValue();

            Optional<Motivo> optional = motivoConverterServices.get(idMotivo);

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
