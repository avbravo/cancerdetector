/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.resolver;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import jakarta.el.ELContext;
import jakarta.el.ELResolver;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author avbravo
 */
@SuppressWarnings("deprecation")
public final class PropertyResolverImpl extends ELResolver {

    @Override
    public Object getValue(ELContext elc, Object base, Object property) {
        
        if (base == null) {

        
            return null;
        }
        
        if (property == null) {
        
            return null;
        }
        
        Object res = null;
        try {
            Class<?> classType = PropertyUtils.getPropertyType(base, property.toString());
            
            res = PropertyUtils.getProperty(base, property.toString());
            
            if (res == null) {
            
                BeanUtils.copyProperties(res, classType);
            
                //res = BeanUtils.instantiate(classType);
                PropertyUtils.setProperty(base, property.toString(), res);
            
                elc.setPropertyResolved(true);
            
                return res;
            }
        } catch (Exception e) {
            
               FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
            // do nothing
        }
        
        elc.setPropertyResolved(false);
        return null;
    }

    @Override
    public Class<?> getType(ELContext elc, Object o, Object o1) {
        
        elc.setPropertyResolved(false);
        return null;
    }

    @Override
    public void setValue(ELContext elc, Object o, Object o1, Object o2) {
        
        elc.setPropertyResolved(false);
    }

    @Override
    public boolean isReadOnly(ELContext elc, Object o, Object o1) {
           
        elc.setPropertyResolved(false);
        return false;
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext elc, Object o) {
               
        elc.setPropertyResolved(false);
        return null;

    }

}
