/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;


import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.DistrictConverterServices;
import com.sft.model.District;
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
@FacesConverter(forClass = District.class, managed = true)
public class DistrictConverter implements Converter<District> {
    @Inject
    DistrictConverterServices  districtConverterServices;
  @Override
    public String getAsString(FacesContext fc, UIComponent uic, District t) {
        try {
              
           if (t == null) {

                return "";
            }

            if (t.getIddistrict()!= null) {

                return t.getIddistrict().toString();
            } else {

            }
      } catch (Exception e) {

            new FacesMessage("Error en converter  "+e.getLocalizedMessage());
      }

 return "";
    }

    @Override
    public District getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
      District a = new District();
     if (submittedValue == null || submittedValue.isEmpty()) {
                return null;
            }


        try {
           // String idUser =submittedValue;
//          
           Integer id=Integer.parseInt(submittedValue);
//          
           Long idDistrict= id.longValue();
//          
         Optional<District> optional =districtConverterServices.get(idDistrict);
          
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

