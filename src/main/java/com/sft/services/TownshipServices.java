/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Township;
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

public interface TownshipServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Township> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Township> findByIdtownship ">
  
    public Optional<Township> findByIdtownship(Long idtownship) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Township findByTownship(@Parameter(description = "El township ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("township") String township)">

     public Township findByTownship(@Parameter(description = "El township ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("township") String township) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Township> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Township> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Township> save( Township township ) ">
  
    public Optional<Township> save( Township township ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Township township )>

   
    public Boolean update(Township township ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idtownship )">
      public Boolean delete( Long idtownship );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByTownship(String township);
    
    // <editor-fold defaultstate="collapsed" desc="List<Township> likeByTownship( String township )">
    public List<Township> likeByTownship( String township);
    // </editor-fold>
    
    
      public Boolean existsTownship(Township township);
      
         public Boolean existsTownshipWithDiferentId(Township township); 
}
