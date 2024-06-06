/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Proyecto;
import com.sft.model.Tipotarjeta;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface TipotarjetaServices {

    public List<Tipotarjeta> findAll();

    public Optional<Tipotarjeta> findByIdtipotarjeta(Long idtipotarjeta);

    public List<Tipotarjeta> findByTipotarjeta(String tipotarjeta);

    public Optional<Tipotarjeta> save(Tipotarjeta tipotarjeta);

    public Boolean update(Tipotarjeta tipotarjeta);

    public Boolean delete(Long idtipotarjeta);

    public List<Tipotarjeta> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    public Boolean existsTipotarjeta(Tipotarjeta tipotarjeta);
    public Boolean existsTipotarjetaWithDiferentId(Tipotarjeta tipotarjeta); 
    
     public Long countLikeByTipotarjeta(String tipotarjeta);
    

    public List<Tipotarjeta> likeByTipotarjeta( String tipotarjeta);
    
    public List<Tipotarjeta> loadTipotarjetaByProyecto(Proyecto proyecto);

}
