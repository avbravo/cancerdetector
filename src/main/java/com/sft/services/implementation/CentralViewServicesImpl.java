/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.CentralView;
import com.sft.services.CentralViewServices;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.CentralViewRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class CentralViewServicesImpl implements CentralViewServices {
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
   CentralViewRestClient centralViewRestClient;
// </editor-fold>
    


    @Override
    public List<CentralView> findAll() {
       return centralViewRestClient.findAll();
    }

    @Override
    public Optional<CentralView> findByIdcentral(Long idcentral) {

        try {
          CentralView result = centralViewRestClient.findByIdcentral(idcentral);
            if (result == null || result.getIdcentral() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public CentralView findByCentral(String central) {
       return centralViewRestClient.findByCentral(central);
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<CentralView> save(CentralView central)">

    @Override
    public Optional<CentralView> save(CentralView central) {
        
          try {

            Response response = centralViewRestClient.save(central);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

          CentralView result = (CentralView) (response.readEntity(CentralView.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(CentralView central)">

    @Override
    public Boolean update(CentralView central) {
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = centralViewRestClient.update(central).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idcentral)">

    @Override
    public Boolean delete(Long idcentral) {
       Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = centralViewRestClient.delete(idcentral).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<CentralView> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<CentralView> lookup(Bson filter, Document sort, Integer page, Integer size) {
      List<CentralView> centralList = new ArrayList<>();
        try {
            centralList = centralViewRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return centralList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

  
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
     Long result = 0L;
        try {
             result = centralViewRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    
    // </editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="List<CentralView> likeByCentral(String central))">

    @Override
    public List<CentralView> likeByCentral(String central) {
       
        return centralViewRestClient.likeByCentral(central);
        
    }
// </editor-fold>

  
}
