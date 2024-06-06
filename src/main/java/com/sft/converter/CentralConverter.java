/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;


import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.CentralConverterServices;
import com.sft.model.Central;
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
@FacesConverter(forClass = Central.class, managed = true)
public class CentralConverter implements Converter<Central> {
    @Inject
    CentralConverterServices  centralConverterServices;
  @Override
    public String getAsString(FacesContext fc, UIComponent uic, Central t) {
        try {
              
           if (t == null) {

                return "";
            }

            if (t.getIdcentral()!= null) {

                return t.getIdcentral().toString();
            } else {

            }
      } catch (Exception e) {

            new FacesMessage("Error en converter  "+e.getLocalizedMessage());
      }

 return "";
    }

    @Override
    public Central getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
      Central a = new Central();
     if (submittedValue == null || submittedValue.isEmpty()) {
                return null;
            }


        try {
           // String idUser =submittedValue;
          
            Integer id=Integer.parseInt(submittedValue);
          
           Long idCentral= id.longValue();
          
         Optional<Central> optional =centralConverterServices.get(idCentral);
          
            if (optional.isPresent()) {
          
                a = optional.get();
            }
            return a;
        } catch (Exception e) {

            System.out.println("====================");
            System.out.println(FacesUtil.nameOfClassAndMethod()+" " +e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
    }

}

