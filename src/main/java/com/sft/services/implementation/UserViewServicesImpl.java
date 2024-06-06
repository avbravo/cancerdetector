/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.restclient.UserViewRestClient;
import com.sft.services.UserViewServices;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class UserViewServicesImpl implements UserViewServices {
  // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
   // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
   UserViewRestClient userViewRestClient;
// </editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="List<UserView> generateUserViewAllList(List<Proyecto> proyectoList, List<UserView> userViewList) ">
    /**
     *
     * @param proyectoList
     * @param userViewList
     * @return List<UserView> de los usuarios en los proyectos
     */
    @Override
    public List<UserView> generateUserViewAllList(List<Proyecto> proyectoList, List<UserView> userViewList) {
        List<UserView> result = new ArrayList<>();
        try {
            for (Proyecto p: proyectoList) {
               
                
                for (ProyectoMiembro pm : p.getProyectoMiembro()) {

                    Optional<UserView> userViewOptional = result.stream()
                            .filter(u -> u.getIduser() == pm.getUserView().getIduser())
                            .findFirst();
                    if (!userViewOptional.isPresent()) {
                        result.add(pm.getUserView());
                    }

                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<UserView> generateUserViewAllListSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList, List<UserView> userViewList) ">
    /**
     *
     * @param proyectoList
     * @param userViewList
     * @return List<UserView> de los usuarios en los proyectos
     */
    @Override
    public List<UserView> generateUserViewAllListSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList, List<UserView> userViewList) {
        List<UserView> result = new ArrayList<>();
        try {
            for (ProyectoSprintOpen pos : proyectoSprintOpenList) {
               
                
                for (ProyectoMiembro pm : pos.getProyecto().getProyectoMiembro()) {

                    Optional<UserView> userViewOptional = result.stream()
                            .filter(u -> u.getIduser() == pm.getUserView().getIduser())
                            .findFirst();
                    if (!userViewOptional.isPresent()) {
                        result.add(pm.getUserView());
                    }

                }

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
    
    
    
    

    @Override
    public List<UserView> findAll() {
       return userViewRestClient.findAll();
    }

    @Override
    public Optional<UserView> findByIduser(Long iduser) {

          try {
           UserView userView = userViewRestClient.findByIduser(iduser);
            if(userView == null || userView.getIduser() == null){
                
            }else{
                return Optional.of(userView);
            }
        } catch (Exception e) {
             FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
        
    }

    @Override
    public Optional<UserView> findByUserViewname(String username) {
       try {
           UserView userView = userViewRestClient.findByUsername(username);
            if(userView == null || userView.getIduser() == null){
                
            }else{
                return Optional.of(userView);
            }
        } catch (Exception e) {
             FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<UserView> save(UserView user)">

    @Override
    public Optional<UserView> save(UserView user) {
        
          try {

            Response response = userViewRestClient.save(user);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

          UserView result = (UserView) (response.readEntity(UserView.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(UserView user)">

    @Override
    public Boolean update(UserView user) {
        Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = userViewRestClient.update(user).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iduser)">

    @Override
    public Boolean delete(Long iduser) {
       Boolean result = Boolean.FALSE;
         try {
             
        
        Integer status = userViewRestClient.delete(iduser).getStatus();
        
        if(status == 201){
            result = Boolean.TRUE;
        }
             
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<UserView> lookup(Bson filter, Document sort, Integer page, Integer size) {
      List<UserView> userList = new ArrayList<>();
        try {
            userList = userViewRestClient.lookup(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return userList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

  
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
     Long result = 0L;
        try {
             result = userViewRestClient.count(
                        EncodeUtil.encodeBson(filter),
                        EncodeUtil.encodeBson(sort),
                        page, size);
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    
    // </editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="List<UserView> likeByName(String name)">

    @Override
    public List<UserView> likeByName(String name) {
        return userViewRestClient.likeByName(name);
    }
// </editor-fold>
}
