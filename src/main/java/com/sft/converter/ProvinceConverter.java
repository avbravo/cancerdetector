/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.ProvinceConverterServices;
import com.sft.model.Province;
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
@FacesConverter(forClass = Province.class, managed = true)
public class ProvinceConverter implements Converter<Province> {

    @Inject
    ProvinceConverterServices provinceConverterServices;

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Province t) {
        try {
            
            if (t == null) {
   
                return "";
            }

            if (t.getIdprovince() != null) {

                return t.getIdprovince().toString();
            } else {

            }
        } catch (Exception e) {

            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }

        return "";
    }

    @Override
    public Province getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
   
        Province a = new Province();
        try {
            if (submittedValue == null || submittedValue.isEmpty()) {
               
                return null;
            }
       
            // String idUser =submittedValue;
            Integer id = Integer.parseInt(submittedValue);

            Long idProvince = id.longValue();
        
            Optional<Province> optional = provinceConverterServices.get(idProvince);

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
