/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.GrupoTipoTarjeta;
import com.sft.services.GrupoTipoTarjetaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.GrupoTipoTarjetaRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class GrupoTipoTarjetaServicesImpl implements GrupoTipoTarjetaServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
 // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
   GrupoTipoTarjetaRestClient grupoTipoTarjetaRestClient;
// </editor-fold>
    
    
    
    
    @Override
    public List<GrupoTipoTarjeta> findAll() {
       return grupoTipoTarjetaRestClient.findAll();
    }

    @Override
    public Optional<GrupoTipoTarjeta> findByIdgrupoTipoTarjeta(Long idgrupoTipoTarjeta) {

       
        try {
           GrupoTipoTarjeta result = grupoTipoTarjetaRestClient.findByIdgrupoTipoTarjeta(idgrupoTipoTarjeta);
            if (result == null || result.getIdgrupotipotarjeta()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
    }

    @Override
    public GrupoTipoTarjeta findByGrupoTipoTarjeta(String grupoTipoTarjeta) {
       return grupoTipoTarjetaRestClient.findByGrupoTipoTarjeta(grupoTipoTarjeta);
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<GrupoTipoTarjeta> save(GrupoTipoTarjeta grupoTipoTarjeta)">

    @Override
    public Optional<GrupoTipoTarjeta> save(GrupoTipoTarjeta grupoTipoTarjeta) {
        
          try {

            Response response = grupoTipoTarjetaRestClient.save(grupoTipoTarjeta);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

          GrupoTipoTarjeta result = (GrupoTipoTarjeta) (response.readEntity(GrupoTipoTarjeta.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(GrupoTipoTarjeta grupoTipoTarjeta)">

    @Override
    public Boolean update(GrupoTipoTarjeta grupoTipoTarjeta) {
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = grupoTipoTarjetaRestClient.update(grupoTipoTarjeta).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idgrupoTipoTarjeta)">

    @Override
    public Boolean delete(Long idgrupoTipoTarjeta) {
       Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = grupoTipoTarjetaRestClient.delete(idgrupoTipoTarjeta).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<GrupoTipoTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size) {
      List<GrupoTipoTarjeta> grupoTipoTarjetaList = new ArrayList<>();
        try {
            grupoTipoTarjetaList = grupoTipoTarjetaRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return grupoTipoTarjetaList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

  
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
     Long result = 0L;
        try {
             result = grupoTipoTarjetaRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    
    // </editor-fold>
    
    
    
    
        // <editor-fold defaultstate="collapsed" desc="Boolean existsGrupoTipoTarjeta(GrupoTipoTarjeta grupoTipoTarjeta)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsGrupoTipoTarjeta(GrupoTipoTarjeta grupoTipoTarjeta) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("grupoTipoTarjeta", grupoTipoTarjeta.getGrupoTipoTarjeta() );
            Document sort = new Document("idgrupoTipoTarjeta", -1);
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
    
    
    // <editor-fold defaultstate="collapsed" desc="Long countLikeByGrupoTipoTarjeta( String grupoTipoTarjeta)">
    @Override
    public Long countLikeByGrupoTipoTarjeta( String grupoTipoTarjeta) {
        Long result = 0L;
        try {
           result = grupoTipoTarjetaRestClient.countLikeByGrupoTipoTarjeta(grupoTipoTarjeta);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    
        // <editor-fold defaultstate="collapsed" desc="List<GrupoTipoTarjeta> likeByGrupoTipoTarjeta(String grupoTipoTarjeta)">
    @Override
    public List<GrupoTipoTarjeta> likeByGrupoTipoTarjeta(String grupoTipoTarjeta) {
        return grupoTipoTarjetaRestClient.likeByGrupoTipoTarjeta(grupoTipoTarjeta);
    }
// </editor-fold>

    
}
