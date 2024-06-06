/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Applicative;
import com.sft.model.Applicative;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface ApplicativeServices {

    public Optional<Applicative> findByIdapplicative(Long idapplicative);


    public List<Applicative> findAll();

    public Optional<Applicative> save(Applicative applicative);
    
     public Boolean update( Applicative applicative) ;
     
     public Boolean delete( Long idapplicative);


    

    public List<Applicative> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
      public Long countLikeByApplicative(String applicative);
    
    // <editor-fold defaultstate="collapsed" desc="List<Applicative> likeByApplicative( String applicative )">
    public List<Applicative> likeByApplicative( String applicative);
    // </editor-fold>
    
    
      public Boolean existsApplicative(Applicative applicative);
}
