/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.TipoTarjetaConverterServices;
import com.sft.model.Tipotarjeta;
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
@FacesConverter(forClass = Tipotarjeta.class, managed = true)
public class TipotarjetaConverter implements Converter<Tipotarjeta> {

    @Inject
    TipoTarjetaConverterServices tipoTarjetaConverterServices;

    // <editor-fold defaultstate="collapsed" desc="String getAsString(FacesContext fc, UIComponent uic, Tipotarjeta t)">
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Tipotarjeta t) {
        try {
            if (t == null) {
                return "";
           }
            if (t.getIdtipotarjeta() != null) {
                return t.getIdtipotarjeta().toString();
            }
        } catch (Exception e) {
            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Tipotarjeta getAsObject(FacesContext fc, UIComponent uic, String submittedValue)">

    @Override
    public Tipotarjeta getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Tipotarjeta result = new Tipotarjeta();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            Integer id = Integer.parseInt(submittedValue);
            Long idTipotarjeta = id.longValue();
            Optional<Tipotarjeta> optional = tipoTarjetaConverterServices.get(idTipotarjeta);
            if (optional.isPresent()) {
                result = optional.get();
            }
            return result;
        } catch (Exception e) {

            
            ConsoleUtil.error("\t " + FacesUtil.nameOfClassAndMethod() + " submittedValue " + submittedValue);
                        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
    }
// </editor-fold>
}
