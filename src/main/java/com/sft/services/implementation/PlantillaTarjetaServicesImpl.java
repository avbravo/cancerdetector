/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.services.PlantillaTarjetaServices;
import com.sft.model.PlantillaTarjeta;
import com.sft.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.PlantillaTarjetaRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class PlantillaTarjetaServicesImpl implements PlantillaTarjetaServices {
// <editor-fold defaultstate="collapsed" desc="Services">

  
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    PlantillaTarjetaRestClient plantillaTarjetaRestClient;
    
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<PlantillaTarjeta> save(PlantillaTarjeta plantillaTarjeta)">
    @Override
    public Optional<PlantillaTarjeta> save(PlantillaTarjeta plantillaTarjeta) {
   
        try {

            Response response = plantillaTarjetaRestClient.save(plantillaTarjeta);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

          PlantillaTarjeta result = (PlantillaTarjeta) (response.readEntity(PlantillaTarjeta.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    
  
  
// <editor-fold defaultstate="collapsed" desc="PlantillaTarjeta lookup(User user) ">

    public List<PlantillaTarjeta> lookup(User user) {
        List<PlantillaTarjeta> plantillaTarjetaList = new ArrayList<>();
        try {

            Integer page = 0;
            Integer size = 0;
           
            

            Bson filter = and(eq("plantillaTarjetaMiembro.user.iduser", user.getIduser()),
                    eq("active", Boolean.TRUE),
                    ne("estado", "finalizado")
            );

            Document sort = new Document("plantillaTarjeta.idplantillaTarjeta", 1);

            
                        
            plantillaTarjetaList = plantillaTarjetaRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
           

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return plantillaTarjetaList;
    }

    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean update(PlantillaTarjeta plantillaTarjeta)">
    @Override
    public Boolean update(PlantillaTarjeta plantillaTarjeta) {
        Boolean result = Boolean.FALSE;
        try {
            Response response = plantillaTarjetaRestClient.update(plantillaTarjeta);
            if (response.getStatus() == 201) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
          

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

   
    
    
        
      // <editor-fold defaultstate="collapsed" desc="List<PlantillaTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<PlantillaTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<PlantillaTarjeta> plantillaTarjetaList = new ArrayList<>();
        try {
           plantillaTarjetaList = plantillaTarjetaRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return plantillaTarjetaList;
    }
// </editor-fold>
    
      // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = plantillaTarjetaRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Optional<PlantillaTarjeta> findByIdplantillaTarjeta(Long idplantillaTarjeta) ">

    @Override
    public Optional<PlantillaTarjeta> findByIdplantillaTarjeta(Long idplantillaTarjeta) {
            
      try {
            PlantillaTarjeta result = plantillaTarjetaRestClient.findByIdplantillaTarjeta(idplantillaTarjeta);
            if (result == null || result.getIdplantillaterjeta()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    // </editor-fold>

     
    
     
    
        // <editor-fold defaultstate="collapsed" desc="Long countLikeByPlantillaTarjeta( String plantillaTarjeta)">
    @Override
    public Long countLikeByPlantillaTarjeta( String plantillaTarjeta) {
        Long result = 0L;
        try {
//            result = tarjetaRestClient.countLikeByTarjeta(tarjeta);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    
        // <editor-fold defaultstate="collapsed" desc="List<PlantillaTarjeta> likeByPlantillaTarjeta(String plantillaTarjeta)">
    @Override
    public List<PlantillaTarjeta> likeByPlantillaTarjeta(String plantilla) {
        return plantillaTarjetaRestClient.likyByPlantillaTarjeta(plantilla);
    }
// </editor-fold>

    
// <editor-fold defaultstate="collapsed" desc="Boolean existsPlantilla(User user, String plantilla, Boolean active)">

    @Override
    public Boolean existsPlantilla(User user, String plantilla, Boolean active) {
        Boolean result = Boolean.FALSE;
        try {
            
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("iduser", user.getIduser()),
                    eq("active",active),
                    eq("plantilla", plantilla)
            );

            Document sort = new Document("plantilla", 1);
            if (count(filter, sort, page, size) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
}
