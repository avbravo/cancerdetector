/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Motivo;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface MotivoServices {

    public List<Motivo> findAll();

    public Optional<Motivo> findByIdmotivo(Long idmotivo);

    public Optional<Motivo> findByMotivo(String motivo);

    public Optional<Motivo> save(Motivo motivo);

    public Boolean update(Motivo motivo);

    public Boolean delete(Long idmotivo);

    public List<Motivo> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);

//    
//     public Long countLikeByMotivo(String motivo);
//    
//    // <editor-fold defaultstate="collapsed" desc="List<Motivo> likeByMotivo( String motivoview)">
//    public List<Motivo> likeByMotivo( String motivo);
//    // </editor-fold>
//    
//      public Boolean existsMotivo(Motivo motivo);
}
