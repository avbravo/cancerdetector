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
import com.sft.model.Zone;
import com.sft.restclient.ZoneRestClient;
import com.sft.services.ZoneServices;
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
public class ZoneServicesImpl implements ZoneServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  ZoneRestClient  zoneRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Zone> findAll(){  return  zoneRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Zone> findById(Long idzone)">
  
    @Override
    public Optional<Zone> findByIdzone(Long idzone) {
            
    try {
            Zone result = zoneRestClient.findByIdzone(idzone) ;  
            if (result == null || result.getIdzone()== null) {

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
    public Zone findByZone(String  zone) {
       return  zoneRestClient.findByZone( zone);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Zone> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Zone> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Zone>  zoneList = new ArrayList<>();
        try {
             zoneList =  zoneRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  zoneList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Zone> save( Zone  zone ) ">
  
    @Override
    public Optional<Zone> save( Zone  zone ) { 
    try {

            Response response =   zoneRestClient.save( zone );

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Zone result = (Zone) (response.readEntity(Zone.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Zone  zone )>

    @PUT
    @Override
    public Boolean update(Zone  zone ) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  zoneRestClient.update( zone ).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idzone)">
    @Override
      public Boolean delete( Long idzone){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  zoneRestClient.delete(idzone).getStatus();
        
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
             result =  zoneRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByZone(@QueryParam("zone") String zone)">
    @Override
    public Long countLikeByZone( String zone) {
        Long result = 0L;
        try {
           result = zoneRestClient.countLikeByZone(zone);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Zone> likeByZone( String  zone )">
    @Override
    public List<Zone> likeByZone( String  zone){return  zoneRestClient.likeByZone( zone);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsZone(Zone zone)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsZone(Zone zone) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("zone", zone.getZone() );
            Document sort = new Document("idzone", -1);
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
    
// <editor-fold defaultstate="collapsed" desc="Boolean existsZonelWithDiferentId(Zone zone)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsZoneWithDiferentId(Zone zone) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("zone", zone.getZone()),
                    eq("building.idbuilding", zone.getBuilding().getIdbuilding()),
                    ne("idzone", zone.getIdzone())
            );
            Document sort = new Document("idcentral", -1);
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
