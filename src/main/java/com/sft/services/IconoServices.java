/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Icono;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface IconoServices {
        public List<Icono> findAll();
        public Optional<Icono> findByIdicono( Long idicono);
        public List<Icono> findByIcono(String icono);
  
    public Optional<Icono> save( Icono icono);

   

    public Boolean update(Icono icono);


   

    public Boolean delete(Long idicono);

   
    public List<Icono> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
    
     public Long countLikeByIcono(String icono);
    
    // <editor-fold defaultstate="collapsed" desc="List<Icono> likeByIcono( String iconoview)">
    public List<Icono> likeByIcono( String icono);
    // </editor-fold>
    
      public Boolean existsIcono(Icono icono);
}
