/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Role;
import com.sft.restclient.RoleRestClient;
import com.sft.services.RoleServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class RoleServicesImpl implements RoleServices{
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
  RoleRestClient  roleRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   
    @Override
    public List<Role> findAll(){  return  roleRestClient.findAll(); }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Role> findById(Long idrole)">
  
    @Override
    public Optional<Role> findByIdrole(Long idrole) {
            
    try {
            Role result = roleRestClient.findByIdrole(idrole) ;  
            if (result == null || result.getIdrole()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    
      @Override
    public Role findByRole(String  role) {
       return  roleRestClient.findByRole( role);
    }
    
    // <editor-fold defaultstate="collapsed" desc="List<Role> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
     public List<Role> lookup(Bson filter, Document sort,  Integer page,  Integer size){ 
      List<Role>  roleList = new ArrayList<>();
        try {
             roleList =  roleRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return  roleList;
     }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Role> save( Role  roleview) ">
  
    @Override
    public Optional<Role> save( Role  roleview) { 
    try {

            Response response =   roleRestClient.save( roleview);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

  Role result = (Role) (response.readEntity(Role.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Role  roleview)>

    @PUT
    @Override
    public Boolean update(Role  roleview) { 
    
    Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  roleRestClient.update( roleview).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idrole)">
    @Override
      public Boolean delete( Long idrole){ 
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status =  roleRestClient.delete(idrole).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE; 
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
      }
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">

    @Override
    public Long count(Bson filter, Document sort,  Integer page,  Integer size){
       Long result = 0L;
        try {
             result =  roleRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="public Long countLikeByRole(@QueryParam("role") String role)">
    @Override
    public Long countLikeByRole( String role) {
        Long result = 0L;
        try {
           result = roleRestClient.countLikeByRole(role);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Role> likeByRole( String  roleview)">
    @Override
    public List<Role> likeByRole( String  role){return  roleRestClient.likeByRole( role);   }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Boolean existsRole(Role role)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsRole(Role role) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("role", role.getRole() );
            Document sort = new Document("idrole", -1);
            Integer total = count(filter, sort, 1, 1).intValue();

            if (total >= 1) {

                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
}
