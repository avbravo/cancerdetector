/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.DepartamentView;
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

public interface DepartamentViewServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<DepartamentView> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<DepartamentView> findByIddepartamentView">
  
    public Optional<DepartamentView> findByIddepartament(Long iddepartament) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="DepartamentView findByDepartament(@Parameter(description = "El departamentView", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("departament") String departament)">

     public DepartamentView findByDepartament(@Parameter(description = "El departamentView", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("departament") String departament) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<DepartamentView> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<DepartamentView> save( DepartamentView departamentview) ">
  
    public Optional<DepartamentView> save( DepartamentView departamentview) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(DepartamentView departamentview)">

   
    public Boolean update(DepartamentView departamentview) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long iddepartamentview)">
      public Boolean delete( Long iddepartamentview);
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    public Long countLikeByDepartament(String departament); 
    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> likeByDepartament( String departamentview)">
    public List<DepartamentView> likeByDepartament( String departament);
    // </editor-fold>
    
   public List<DepartamentView> loadDepartamentView(String query, List<DepartamentView> departamentViewSelectedList);
}
