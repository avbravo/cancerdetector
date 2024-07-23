/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Analisis;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface AnalisisServices {
        public List<Analisis> findAll();
        public Optional<Analisis> findByIdanalisis( String id);
       public Optional<Analisis> findByNhc(String nhc) ;
  
    public Optional<Analisis> save( Analisis analisis);

   

    public Boolean update(Analisis analisis);


   

    public Boolean delete(String id);

   
    public List<Analisis> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
//    
//     public Long countLikeByAnalisis(String analisis);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Analisis> likeByAnalisis( String analisisview)">
//    public List<Analisis> likeByAnalisis( String analisis);
//    // </editor-fold>
//    
//      public Boolean existsAnalisis(Analisis analisis);
}
