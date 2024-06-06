/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Central;
import com.sft.model.Departament;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */

public interface  DepartamentServices {


    
  
  

    // <editor-fold defaultstate="collapsed" desc="findAll">
 
       public List<Departament> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Departament> findByIddepartament">
    public Optional<Departament> findByIddepartament( Long iddepartament) ;
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Departament> lookup(Bson filter, Document sort,  Integer page,  Integer size)">

    public List<Departament> lookup(Bson filter, Document sort,  Integer page,  Integer size);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Departament> save(Departament departament)">
     public Optional<Departament> save(Departament departament) ;


// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update( Departament departament)">
     public Boolean update( Departament departament) ;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iddepartament)">

    public Boolean delete(Long iddepartament);
    // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size)">

    public Long count(Bson filter, Document sort,  Integer page,  Integer size);

    // </editor-fold>
   
       public Long countLikeByDepartament(String departament); 
       
    // <editor-fold defaultstate="collapsed" desc="List<Departament> likeByDepartament( String departament)">
   public List<Departament> likeByDepartament( String departament);
    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Boolean existsDepartament(Departament departament, Central central)">

        public Boolean existsDepartament(Departament departament, Central central);
        // </editor-fold>
}
