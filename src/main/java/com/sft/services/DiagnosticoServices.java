/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Diagnostico;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface DiagnosticoServices {
        public List<Diagnostico> findAll();
        public Optional<Diagnostico> findByIddiagnostico( Long iddiagnostico);
       public Optional<Diagnostico> findByDiagnostico(String diagnostico) ;
  
    public Optional<Diagnostico> save( Diagnostico diagnostico);

   

    public Boolean update(Diagnostico diagnostico);


   

    public Boolean delete(Long iddiagnostico);

   
    public List<Diagnostico> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
//    
//     public Long countLikeByDiagnostico(String diagnostico);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Diagnostico> likeByDiagnostico( String diagnosticoview)">
//    public List<Diagnostico> likeByDiagnostico( String diagnostico);
//    // </editor-fold>
//    
//      public Boolean existsDiagnostico(Diagnostico diagnostico);
}
