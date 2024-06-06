/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Pcrits;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface PcritsServices {
        public List<Pcrits> findAll();
        public Optional<Pcrits> findByIdpcrits( Long idpcrits);
       public Optional<Pcrits> findByPcrits(String pcrits) ;
  
    public Optional<Pcrits> save( Pcrits pcrits);

   

    public Boolean update(Pcrits pcrits);


   

    public Boolean delete(Long idpcrits);

   
    public List<Pcrits> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
//    
//     public Long countLikeByPcrits(String pcrits);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Pcrits> likeByPcrits( String pcritsview)">
//    public List<Pcrits> likeByPcrits( String pcrits);
//    // </editor-fold>
//    
//      public Boolean existsPcrits(Pcrits pcrits);
}
