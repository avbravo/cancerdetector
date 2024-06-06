/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;


import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.CentralViewConverterServices;
import com.sft.model.CentralView;
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
@FacesConverter(forClass = CentralView.class, managed = true)
public class CentralViewConverter implements Converter<CentralView> {
    @Inject
    CentralViewConverterServices  centralViewConverterServices;
  @Override
    public String getAsString(FacesContext fc, UIComponent uic, CentralView t) {
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
    public CentralView getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
  
      CentralView a = new CentralView();
     if (submittedValue == null || submittedValue.isEmpty()) {
                return null;
            }


        try {
          
            Integer id=Integer.parseInt(submittedValue);
            
           Long idCentralView= id.longValue();
           
         Optional<CentralView> optional =centralViewConverterServices.get(idCentralView);
          
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

