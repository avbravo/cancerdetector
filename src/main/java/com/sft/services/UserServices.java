/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.User;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface UserServices {

    public Optional<User> findByIduser(Long iduser);

    public Optional<User> findByUsername(String username);
    
    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByIdentificationcard(String identificationcard);
    

    public List<User> findAll();

    public Optional<User> save(User user);
    
     public Boolean update( User user) ;
     
     public Boolean delete( Long iduser);


    

    public List<User> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
       public List<User> likeByName(@QueryParam("name") String name);
       
       public Boolean validEmail(String email);
       public Boolean validPassword(String password);
       
       public Boolean validUser(User userSelected, String passwordRepetido);
}
