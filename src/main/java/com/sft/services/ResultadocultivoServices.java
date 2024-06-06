/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Resultadocultivo;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface ResultadocultivoServices {
        public List<Resultadocultivo> findAll();
        public Optional<Resultadocultivo> findByIdresultadocultivo( Long idresultadocultivo);
       public Optional<Resultadocultivo> findByResultadocultivo(String resultadocultivo) ;
  
    public Optional<Resultadocultivo> save( Resultadocultivo resultadocultivo);

   

    public Boolean update(Resultadocultivo resultadocultivo);


   

    public Boolean delete(Long idresultadocultivo);

   
    public List<Resultadocultivo> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
//    
//     public Long countLikeByResultadocultivo(String resultadocultivo);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Resultadocultivo> likeByResultadocultivo( String resultadocultivoview)">
//    public List<Resultadocultivo> likeByResultadocultivo( String resultadocultivo);
//    // </editor-fold>
//    
//      public Boolean existsResultadocultivo(Resultadocultivo resultadocultivo);
}
