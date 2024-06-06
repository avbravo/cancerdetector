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
import com.sft.model.Province;
import com.sft.restclient.ProvinceRestClient;
import com.sft.services.ProvinceServices;
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
public class ProvinceServicesImpl implements ProvinceServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  ProvinceRestClient  provinceRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Province> findAll(){  return  provinceRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Province> findById(Long idprovince)">
  
    @Override
    public Optional<Province> findByIdprovince(Long idprovince) {
            
    try {
            Province result = provinceRestClient.findByIdprovince(idprovince) ;  
            if (result == null || result.getIdprovince()== null) {

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
    public Province findByProvince(String  province) {
       return  provinceRestClient.findByProvince( province);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Province> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Province> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Province>  provinceList = new ArrayList<>();
        try {
             provinceList =  provinceRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  provinceList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Province> save( Province  province ) ">
  
    @Override
    public Optional<Province> save( Province  province ) { 
    try {

            Response response =   provinceRestClient.save( province );

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Province result = (Province) (response.readEntity(Province.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Province  province )">

    @PUT
    @Override
    public Boolean update(Province  province ) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  provinceRestClient.update( province ).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idprovince)">
    @Override
      public Boolean delete( Long idprovince){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  provinceRestClient.delete(idprovince).getStatus();
        
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
             result =  provinceRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByProvince(@QueryParam("province") String province)">
    @Override
    public Long countLikeByProvince( String province) {
        Long result = 0L;
        try {
           result = provinceRestClient.countLikeByProvince(province);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Province> likeByProvince( String  province )">
    @Override
    public List<Province> likeByProvince( String  province){return  provinceRestClient.likeByProvince( province);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsProvince(Province province)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsProvince(Province province) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("province", province.getProvince() );
            Document sort = new Document("idprovince", -1);
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
    
    
          // <editor-fold defaultstate="collapsed" desc="Boolean existsProvinceWithDiferentId(Province province)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsProvinceWithDiferentId(Province province) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("province", province.getProvince()),
                    eq("country.idcountry", province.getCountry().getIdcountry()),
                    ne("idprovince", province.getIdprovince())
            );
            Document sort = new Document("idprovince", -1);
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
