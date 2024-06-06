/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Area;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */

public interface AreaServices {

  
// <editor-fold defaultstate="collapsed" desc="findAll">
      public List<Area> findAll() ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Area> findByIdarea(Long idarea)">
     public Optional<Area> findByIdarea(Long idarea);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Area> save(Area area)">

   public Optional<Area> save(Area area);
    
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(  Area area)">

    public Boolean update(  Area area);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
       public Boolean delete( Long idarea) ;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Area> lookup( Bson filter, Document sort,  Integer page,  Integer size">
        public List<Area> lookup( Bson filter, Document sort,  Integer page,  Integer size);
        

    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Long count( Bson filter, Document sort, Integer page,  Integer size)">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size) ;

    // </editor-fold>
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="List<Area> likeByArea( String area)">

    public List<Area> likeByArea(String area);
    // </editor-fold>
    
  
  
}
