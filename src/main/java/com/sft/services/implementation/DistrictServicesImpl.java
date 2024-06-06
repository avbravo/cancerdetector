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
import com.sft.model.District;
import com.sft.restclient.DistrictRestClient;
import com.sft.services.DistrictServices;
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
public class DistrictServicesImpl implements DistrictServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  DistrictRestClient  districtRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<District> findAll(){  return  districtRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<District> findById(Long iddistrict)">
  
    @Override
    public Optional<District> findByIddistrict(Long iddistrict) {
            
    try {
            District result = districtRestClient.findByIddistrict(iddistrict) ;  
            if (result == null || result.getIddistrict()== null) {

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
    public District findByDistrict(String  district) {
       return  districtRestClient.findByDistrict( district);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<District> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<District> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<District>  districtList = new ArrayList<>();
        try {
             districtList =  districtRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  districtList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<District> save( District  districtview) ">
  
    @Override
    public Optional<District> save( District  districtview) { 
    try {

            Response response =   districtRestClient.save( districtview);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  District result = (District) (response.readEntity(District.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(District  districtview)>

    @PUT
    @Override
    public Boolean update(District  districtview) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  districtRestClient.update( districtview).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iddistrict)">
    @Override
      public Boolean delete(Long iddistrict){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  districtRestClient.delete(iddistrict).getStatus();
        
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
             result =  districtRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByDistrict(@QueryParam("district") String district)">
    @Override
    public Long countLikeByDistrict( String district) {
        Long result = 0L;
        try {
           result = districtRestClient.countLikeByDistrict(district);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<District> likeByDistrict( String  districtview)">
    @Override
    public List<District> likeByDistrict( String  district){return  districtRestClient.likeByDistrict( district);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsDistrict(District district)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsDistrict(District district) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("district", district.getDistrict() );
            Document sort = new Document("iddistrict", -1);
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
    
    
    
// <editor-fold defaultstate="collapsed" desc="Boolean existsDistrictWithDiferentId(District district)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsDistrictWithDiferentId(District district) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("district", district.getDistrict()),
                    eq("province.idprovince", district.getProvince().getIdprovince()),
                    ne("iddistrict", district.getIddistrict())
            );
            Document sort = new Document("iddistrict", -1);
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
