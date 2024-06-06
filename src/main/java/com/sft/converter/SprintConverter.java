/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.SprintConverterServices;
import com.sft.model.Sprint;
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
@FacesConverter(forClass = Sprint.class, managed = true)
public class SprintConverter implements Converter<Sprint> {

    @Inject
    SprintConverterServices sprintConverterServices;
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Sprint t) {
        try {
            if (t == null) {
                return "";
            }
            if (t.getIdsprint()!= null) {
                return t.getIdsprint().toString();
            } else {
            }
        } catch (Exception e) {
            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public Sprint getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Sprint sprint = new Sprint();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.parseInt(submittedValue);
      
            
            Long idSprint= id.longValue();
            
         Optional<Sprint> optional = sprintConverterServices.get(idSprint);
            if(optional.isPresent()){
          
         sprint = optional.get();
            }
        } catch (Exception e) {
            System.out.println("====================");
          System.out.println(FacesUtil.nameOfClassAndMethod()+" " +e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
        return sprint;
    }
}
