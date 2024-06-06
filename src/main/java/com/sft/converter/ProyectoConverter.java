/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.converter;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.converter.services.ProyectoConverterServices;
import com.sft.model.Proyecto;
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
@FacesConverter(forClass = Proyecto.class, managed = true)
public class ProyectoConverter implements Converter<Proyecto> {

    @Inject
    ProyectoConverterServices proyectoConverterServices;
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Proyecto t) {
        try {
            if (t == null) {
                return "";
            }
            if (t.getIdproyecto()!= null) {
                return t.getIdproyecto().toString();
            } else {
            }
        } catch (Exception e) {
            new FacesMessage("Error en converter  " + e.getLocalizedMessage());
        }
        return "";
    }

    @Override
    public Proyecto getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        Proyecto proyecto = new Proyecto();
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.parseInt(submittedValue);
            Long idProyecto= id.longValue();
           Optional<Proyecto> optional = proyectoConverterServices.get(idProyecto);
            if(optional.isPresent()){
          
            return optional.get();
            }
        } catch (Exception e) {
            System.out.println("====================");
     System.out.println(FacesUtil.nameOfClassAndMethod()+" " +e.getLocalizedMessage());
            System.out.println("====================");
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid selecction from Converter"), e);
        }
        return proyecto;
    }
}
