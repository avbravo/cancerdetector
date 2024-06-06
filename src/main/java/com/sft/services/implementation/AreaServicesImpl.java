/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Area;
import com.sft.services.AreaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import com.sft.restclient.AreaRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class AreaServicesImpl implements AreaServices{ 
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
   AreaRestClient areaRestClient;
// </editor-fold>
  
// <editor-fold defaultstate="collapsed" desc="findAll">
      public List<Area> findAll() {
          return areaRestClient.findAll();
      }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Area> findByIdarea(Long idarea)">
     public Optional<Area> findByIdarea( @Parameter(description = "El idarea", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idarea") Long idarea){
         
         
          try {
          Area area = areaRestClient.findByIdarea(idarea);
            if(area == null || area.getIdarea()== null){
                
            }else{
                return Optional.of(area);
            }
        } catch (Exception e) {
             FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
     }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">

    @Override
   public Optional<Area> save( Area area){
        try {

            Response response = areaRestClient.save(area);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

          Area result = (Area) (response.readEntity(Area.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
   }
    
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    public Boolean update( Area area){
         Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = areaRestClient.update(area).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idarea)">
       public Boolean delete(Long idarea) {
           Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = areaRestClient.delete(idarea).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
       }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Area> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @Override
    public List<Area> lookup( Bson filter, Document sort,  Integer page,  Integer size){
    List<Area> areaList = new ArrayList<>();
        try {
            areaList = areaRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return areaList;
}
        

    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    public Long count(Bson filter, Document sort, Integer page, Integer size) {
         Long result = 0L;
        try {
             result = areaRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="List<Area> likeByArea( String area)">

    public List<Area> likeByArea( String area){
             return areaRestClient.likeByArea(area);
    }
    // </editor-fold>
    

}
