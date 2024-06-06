/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Institution;
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

public interface InstitutionServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Institution> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Institution> findByIdinstitution ">
  
    public Optional<Institution> findByIdinstitution(Long idinstitution) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Institution findByInstitution(@Parameter(description = "El institution ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("institution") String institution)">

     public Institution findByInstitution(@Parameter(description = "El institution ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("institution") String institution) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Institution> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Institution> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Institution> save( Institution institution ) ">
  
    public Optional<Institution> save( Institution institution ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Institution institution )>

   
    public Boolean update(Institution institution ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idinstitution )">
      public Boolean delete( Long idinstitution );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByInstitution(String institution);
    
    // <editor-fold defaultstate="collapsed" desc="List<Institution> likeByInstitution( String institution )">
    public List<Institution> likeByInstitution( String institution);
    // </editor-fold>
    
    
      public Boolean existsInstitution(Institution institution);
}
