/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Building;
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

public interface BuildingServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Building> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Building> findByIdbuilding ">
  
    public Optional<Building> findByIdbuilding(Long idbuilding) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Building findByBuilding(@Parameter(description = "El building ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("building") String building)">

     public Building findByBuilding(@Parameter(description = "El building ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("building") String building) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Building> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Building> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Building> save( Building building ) ">
  
    public Optional<Building> save( Building building ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Building building )>

   
    public Boolean update(Building building ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idbuilding )">
      public Boolean delete( Long idbuilding );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByBuilding(String building);
    
    // <editor-fold defaultstate="collapsed" desc="List<Building> likeByBuilding( String building )">
    public List<Building> likeByBuilding( String building);
    // </editor-fold>
    
    
      public Boolean existsBuilding(Building building);
        public Boolean existsBuildingWithDiferentId(Building building); 
}
