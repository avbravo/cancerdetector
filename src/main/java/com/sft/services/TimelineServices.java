/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Proyecto;
import com.sft.model.Timeline;
import com.sft.model.domain.ProyectoSprintOpen;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface TimelineServices {
    
   
    public List<Timeline> lookup( Bson filter, Document sort, Integer page, Integer size);
    public List<Timeline> findByProyectoAndActive( Proyecto proyecto, Boolean active);
    public List<Timeline> findByProyectoAndActive( List<Proyecto> proyectoList, Boolean active);
    public List<Timeline> findByProyectoAndActiveSprintOpen( List<ProyectoSprintOpen> proyectoSprintOpenList, Boolean active);
    public List<Timeline> findByActive( Boolean active);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
   
    
}
