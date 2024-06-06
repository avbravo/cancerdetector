/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Proyecto;
import com.sft.model.NotificacionProyecto;
import com.sft.model.User;
import com.sft.services.ProyectoViewServices;
import com.sft.services.NotificacionProyectoServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.NotificacionProyectoRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class NotificacionProyectoServicesImpl implements NotificacionProyectoServices {
    
    
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    NotificacionProyectoRestClient notificacionProyectoRestClient;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    ProyectoViewServices proyectoViewServices;
// </editor-fold>

    


   

   
    // <editor-fold defaultstate="collapsed" desc="List<NotificacionProyecto> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<NotificacionProyecto> lookup(Bson filter, Document sort, Integer page, Integer size) {
      List<NotificacionProyecto> notificacionProyectoList = new ArrayList<>();
        try {
             notificacionProyectoList = notificacionProyectoRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return notificacionProyectoList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

  
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
     Long result = 0L;
        try {
             result = notificacionProyectoRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<NotificacionProyecto> findByUserAndProyectoAndVisto(User user, Proyecto proyecto, Boolean visto)">

    @Override
    public List<NotificacionProyecto> findByUserAndProyectoAndVisto(User user, Proyecto proyecto, Boolean visto) {
       List<NotificacionProyecto>  result = new ArrayList<>();
        try {
             Bson filter = and(eq("idproyecto", proyecto.getIdproyecto()),
                    eq("iduser", user.getIduser()),
                            eq("visto",visto)
            );
            Document sort = new Document("idnotificacion", -1);
            Integer page=0;
            Integer size=0;
            
           
            
          result  = notificacionProyectoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);


                    
         
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
  
    // <editor-fold defaultstate="collapsed" desc="List<NotificacionProyecto> findByUserAndVisto(User user,Boolean visto)">

    @Override
    public List<NotificacionProyecto> findByUserAndVisto(User user,  Boolean visto) {
       List<NotificacionProyecto>  result = new ArrayList<>();
        try {
            

          
             Bson filter = and(eq("iduser", user.getIduser()),
                            eq("visto",visto)
            );
            Document sort = new Document("idnotificacion", -1);
            Integer page=0;
            Integer size=0;
            
     
          
          result  = notificacionProyectoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);


                  
         
        } catch (Exception e) {
            
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
  
}

