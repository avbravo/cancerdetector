/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Building;
import com.sft.model.Province;
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

public interface ProvinceServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Province> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Province> findByIdprovince ">
  
    public Optional<Province> findByIdprovince(Long idprovince) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Province findByProvince(@Parameter(description = "El province ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("province") String province)">

     public Province findByProvince(@Parameter(description = "El province ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("province") String province) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Province> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Province> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Province> save( Province province ) ">
  
    public Optional<Province> save( Province province ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Province province )>

   
    public Boolean update(Province province ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idprovince )">
      public Boolean delete( Long idprovince );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByProvince(String province);
    
    // <editor-fold defaultstate="collapsed" desc="List<Province> likeByProvince( String province )">
    public List<Province> likeByProvince( String province);
    // </editor-fold>
    
    
     public Boolean existsProvince(Province province);
      
     public Boolean existsProvinceWithDiferentId(Province province); 
}
