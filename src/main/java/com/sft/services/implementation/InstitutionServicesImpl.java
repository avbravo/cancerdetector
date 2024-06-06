/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Institution;
import com.sft.restclient.InstitutionRestClient;
import com.sft.services.InstitutionServices;
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
public class InstitutionServicesImpl implements InstitutionServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  InstitutionRestClient  institutionRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Institution> findAll(){  return  institutionRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Institution> findById(Long idinstitution)">
  
    @Override
    public Optional<Institution> findByIdinstitution(Long idinstitution) {
            
    try {
            Institution result = institutionRestClient.findByIdinstitution(idinstitution) ;  
            if (result == null || result.getIdinstitution()== null) {

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
    public Institution findByInstitution(String  institution) {
       return  institutionRestClient.findByInstitution( institution);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Institution> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Institution> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Institution>  institutionList = new ArrayList<>();
        try {
             institutionList =  institutionRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  institutionList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Institution> save( Institution  institution ) ">
  
    @Override
    public Optional<Institution> save( Institution  institution ) { 
    try {

            Response response =   institutionRestClient.save( institution );

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Institution result = (Institution) (response.readEntity(Institution.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Institution  institution )>

    @PUT
    @Override
    public Boolean update(Institution  institution ) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  institutionRestClient.update( institution ).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idinstitution)">
    @Override
      public Boolean delete( Long idinstitution){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  institutionRestClient.delete(idinstitution).getStatus();
        
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
             result =  institutionRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByInstitution(@QueryParam("institution") String institution)">
    @Override
    public Long countLikeByInstitution( String institution) {
        Long result = 0L;
        try {
           result = institutionRestClient.countLikeByInstitution(institution);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Institution> likeByInstitution( String  institution )">
    @Override
    public List<Institution> likeByInstitution( String  institution){return  institutionRestClient.likeByInstitution( institution);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsInstitution(Institution institution)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsInstitution(Institution institution) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("institution", institution.getInstitution() );
            Document sort = new Document("idinstitution", -1);
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
