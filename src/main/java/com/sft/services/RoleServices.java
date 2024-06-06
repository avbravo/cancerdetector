/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Role;
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

public interface RoleServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Role> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Role> findByIdrole">
  
    public Optional<Role> findByIdrole(Long idrole) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Role findByRole(@Parameter(description = "El role ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("role") String role)">

     public Role findByRole(@Parameter(description = "El role ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("role") String role) ;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Role> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
     public List<Role> lookup(Bson filter, Document sort,  Integer page,  Integer size);
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Role> save( Role role ) ">
  
    public Optional<Role> save( Role role ) ;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Role role )>

   
    public Boolean update(Role role ) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idrole )">
      public Boolean delete( Long idrole );
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>
    
    
      public Long countLikeByRole(String role);
    
    // <editor-fold defaultstate="collapsed" desc="List<Role> likeByRole( String role )">
    public List<Role> likeByRole( String role);
    // </editor-fold>
    
    
      public Boolean existsRole(Role role);
}
