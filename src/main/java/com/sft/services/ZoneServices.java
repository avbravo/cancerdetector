/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Zone;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

/**
 *
 * @author avbravo
 */

public interface ZoneServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Zone> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Zone> findByIdzone ">
  
    public Optional<Zone> findByIdzone(Long idzone) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Zone findByZone(@Parameter(description = "El zone ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("zone") String zone)">

     public Zone findByZone(@Parameter(description = "El zone ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("zone") String zone) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Zone> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Zone> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Zone> save( Zone zone ) ">
  
    public Optional<Zone> save( Zone zone ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Zone zone )>

   
    public Boolean update(Zone zone ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idzone )">
      public Boolean delete( Long idzone );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByZone(String zone);
    
    // <editor-fold defaultstate="collapsed" desc="List<Zone> likeByZone( String zone )">
    public List<Zone> likeByZone( String zone);
    // </editor-fold>
    
    
      public Boolean existsZone(Zone zone);
      
        public Boolean existsZoneWithDiferentId(Zone zone); 
}
