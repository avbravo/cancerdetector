/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Proyecto;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoSprintOpen;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface UserViewServices {

    public List<UserView> generateUserViewAllList(List<Proyecto> proyectoList, List<UserView> userViewList);
    public List<UserView> generateUserViewAllListSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList, List<UserView> userViewList);
    

    public Optional<UserView> findByIduser(Long iduser);

    public Optional<UserView> findByUserViewname(String username);

    public List<UserView> findAll();

    public Optional<UserView> save(UserView user);

    public Boolean update(UserView user);

    public Boolean delete(Long iduser);

    public List<UserView> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);

    public List<UserView> likeByName(@QueryParam("name") String name);
}
