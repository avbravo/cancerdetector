/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.model.Township;
import com.sft.restclient.TownshipRestClient;
import com.sft.services.TownshipServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class TownshipServicesImpl implements TownshipServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  TownshipRestClient  townshipRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Township> findAll(){  return  townshipRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Township> findById(Long idtownship)">
  
    @Override
    public Optional<Township> findByIdtownship(Long idtownship) {
            
    try {
            Township result = townshipRestClient.findByIdtownship(idtownship) ;  
            if (result == null || result.getIdtownship()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    
      @Override
    public Township findByTownship(String  township) {
       return  townshipRestClient.findByTownship( township);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Township> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Township> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Township>  townshipList = new ArrayList<>();
        try {
             townshipList =  townshipRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  townshipList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Township> save( Township  townshipview) ">
  
    @Override
    public Optional<Township> save( Township  townshipview) { 
    try {

            Response response =   townshipRestClient.save( townshipview);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Township result = (Township) (response.readEntity(Township.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Township  townshipview)>

    @PUT
    @Override
    public Boolean update(Township  townshipview) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  townshipRestClient.update( townshipview).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idtownship)">
    @Override
      public Boolean delete( Long idtownship){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  townshipRestClient.delete(idtownship).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE; 
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
      }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    @Override
    public Long count(Bson filter, Document sort,  Integer page,  Integer size){
       Long result = 0L;
        try {
             result =  townshipRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByTownship(@QueryParam("township") String township)">
    @Override
    public Long countLikeByTownship( String township) {
        Long result = 0L;
        try {
           result = townshipRestClient.countLikeByTownship(township);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Township> likeByTownship( String  townshipview)">
    @Override
    public List<Township> likeByTownship( String  township){return  townshipRestClient.likeByTownship( township);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsTownship(Township township)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsTownship(Township township) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("township", township.getTownship() );
            Document sort = new Document("idtownship", -1);
            Integer total = count(filter, sort, 1, 1).intValue();

            if (total >= 1) {

                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
    
    
// <editor-fold defaultstate="collapsed" desc="Boolean existsTownshipWithDiferentId(Township township)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsTownshipWithDiferentId(Township township) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("township", township.getTownship()),
                    eq("district.iddistrict", township.getDistrict().getIddistrict()),
                    ne("idtownship", township.getIdtownship())
            );
            Document sort = new Document("idtownship", -1);
            Integer total = count(filter, sort, 1, 1).intValue();

            if (total >= 1) {

                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
}
