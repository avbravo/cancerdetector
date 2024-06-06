/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Proyecto;
import com.sft.model.NotificacionProyecto;
import com.sft.model.User;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface NotificacionProyectoServices {
    
   
    public List<NotificacionProyecto> lookup( Bson filter, Document sort, Integer page, Integer size);
    public List<NotificacionProyecto> findByUserAndProyectoAndVisto( User user, Proyecto proyecto, Boolean visto);
    public List<NotificacionProyecto> findByUserAndVisto( User user,  Boolean visto);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
   
    
}
