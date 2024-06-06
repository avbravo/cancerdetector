/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;


import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.ApplicativeConverterServices;
import com.sft.model.Applicative;
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
@FacesConverter(forClass = Applicative.class, managed = true)
public class ApplicativeConverter implements Converter<Applicative> {
    @Inject
    ApplicativeConverterServices  applicativeConverterServices;
  @Override
    public String getAsString(FacesContext fc, UIComponent uic, Applicative t) {
        try {
              
           if (t == null) {

                return "";
            }

            if (t.getIdapplicative()!= null) {

                return t.getIdapplicative().toString();
            } else {

            }
      } catch (Exception e) {

            new FacesMessage("Error en converter  "+e.getLocalizedMessage());
      }

 return "";
    }

    @Override
    public Applicative getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
      Applicative a = new Applicative();
     if (submittedValue == null || submittedValue.isEmpty()) {
                return null;
            }


        try {
           // String idUser =submittedValue;
          
            Integer id=Integer.parseInt(submittedValue);
          
           Long idApplicative= id.longValue();
          
         Optional<Applicative> optional =applicativeConverterServices.get(idApplicative);
          
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

