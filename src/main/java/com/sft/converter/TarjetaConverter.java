/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.TarjetaConverterServices;
import com.sft.model.Tarjeta;
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
@FacesConverter(forClass = Tarjeta.class, managed = true)
public class TarjetaConverter implements Converter<Tarjeta> {

    @Inject
    TarjetaConverterServices tarjetaConverterServices;
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Tarjeta t) {
        try {
            if (t == null) {
                return "";
            }
            if (t.getIdtarjeta()!= null) {
                return t.getIdtarjeta().toString();
            } else {
            }
        } catch (Exception e) {
            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public Tarjeta getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Tarjeta tarjeta = new Tarjeta();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.parseInt(submittedValue);
            Long idTarjeta= id.longValue();
         Optional<Tarjeta> optional = tarjetaConverterServices.get(idTarjeta);
            if(optional.isPresent()){
          
         tarjeta = optional.get();
            }
        } catch (Exception e) {
            System.out.println("====================");
          System.out.println(FacesUtil.nameOfClassAndMethod()+" " +e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
        return tarjeta;
    }
}
