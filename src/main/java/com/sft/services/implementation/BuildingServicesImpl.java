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
import com.sft.model.Building;
import com.sft.restclient.BuildingRestClient;
import com.sft.services.BuildingServices;
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
public class BuildingServicesImpl implements BuildingServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  BuildingRestClient  buildingRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Building> findAll(){  return  buildingRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Building> findById(Long idbuilding)">
  
    @Override
    public Optional<Building> findByIdbuilding(Long idbuilding) {
            
    try {
            Building result = buildingRestClient.findByIdbuilding(idbuilding) ;  
            if (result == null || result.getIdbuilding()== null) {

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
    public Building findByBuilding(String  building) {
       return  buildingRestClient.findByBuilding( building);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Building> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Building> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Building>  buildingList = new ArrayList<>();
        try {
             buildingList =  buildingRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  buildingList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Building> save( Building  building ) ">
  
    @Override
    public Optional<Building> save( Building  building ) { 
    try {

            Response response =   buildingRestClient.save( building );

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Building result = (Building) (response.readEntity(Building.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Building  building )>

    @PUT
    @Override
    public Boolean update(Building  building ) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  buildingRestClient.update( building ).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idbuilding)">
    @Override
      public Boolean delete( Long idbuilding){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  buildingRestClient.delete(idbuilding).getStatus();
        
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
             result =  buildingRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByBuilding(@QueryParam("building") String building)">
    @Override
    public Long countLikeByBuilding( String building) {
        Long result = 0L;
        try {
           result = buildingRestClient.countLikeByBuilding(building);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Building> likeByBuilding( String  building )">
    @Override
    public List<Building> likeByBuilding( String  building){return  buildingRestClient.likeByBuilding( building);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsBuilding(Building building)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsBuilding(Building building) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("building", building.getBuilding() );
            Document sort = new Document("idbuilding", -1);
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
    
    
            // <editor-fold defaultstate="collapsed" desc="Boolean existsBuildingWithDiferentId(Building building)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsBuildingWithDiferentId(Building building) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("building", building.getBuilding()),
                    eq("central.idcentral", building.getCentral().getIdcentral()),
                    ne("idbuilding", building.getIdbuilding())
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
