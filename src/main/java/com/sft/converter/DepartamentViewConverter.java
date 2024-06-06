/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;


import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.DepartamentViewConverterServices;
import com.sft.model.DepartamentView;
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
@FacesConverter(forClass = DepartamentView.class, managed = true)
public class DepartamentViewConverter implements Converter<DepartamentView> {
    @Inject
    DepartamentViewConverterServices  departamentViewConverterServices;
  @Override
    public String getAsString(FacesContext fc, UIComponent uic, DepartamentView t) {
        try {
              
           if (t == null) {

                return "";
            }

            if (t.getIddepartament()!= null) {

                return t.getIddepartament().toString();
            } else {

            }
      } catch (Exception e) {

            new FacesMessage("Error en converter  "+e.getLocalizedMessage());
      }

 return "";
    }

    @Override
    public DepartamentView getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
      DepartamentView a = new DepartamentView();
     if (submittedValue == null || submittedValue.isEmpty()) {
                return null;
            }


        try {
           // String idUser =submittedValue;
          
            Integer id=Integer.parseInt(submittedValue);
          
           Long idDepartamentView= id.longValue();
          
         Optional<DepartamentView> optional =departamentViewConverterServices.get(idDepartamentView);
          
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

