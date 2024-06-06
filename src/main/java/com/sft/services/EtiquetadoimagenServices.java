/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Etiquetadoimagen;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface EtiquetadoimagenServices {
        public List<Etiquetadoimagen> findAll();
        public Optional<Etiquetadoimagen> findByIdetiquetadoimagen( Long idetiquetadoimagen);
       public Optional<Etiquetadoimagen> findByEtiquetadoimagen(String etiquetadoimagen) ;
  
    public Optional<Etiquetadoimagen> save( Etiquetadoimagen etiquetadoimagen);

   

    public Boolean update(Etiquetadoimagen etiquetadoimagen);


   

    public Boolean delete(Long idetiquetadoimagen);

   
    public List<Etiquetadoimagen> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
//    
//     public Long countLikeByEtiquetadoimagen(String etiquetadoimagen);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Etiquetadoimagen> likeByEtiquetadoimagen( String etiquetadoimagenview)">
//    public List<Etiquetadoimagen> likeByEtiquetadoimagen( String etiquetadoimagen);
//    // </editor-fold>
//    
//      public Boolean existsEtiquetadoimagen(Etiquetadoimagen etiquetadoimagen);
}
