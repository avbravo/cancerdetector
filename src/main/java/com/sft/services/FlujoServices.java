/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Flujo;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface FlujoServices {

    public Optional<Flujo> save(Flujo flujo);

    public Boolean update(Flujo flujo);

    public Optional<Flujo> findByIdflujo(Long idflujo);

    public List<Flujo> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Boolean flujoExistInSprint(String flujoName, Long idproyecto, Long idsprint);

    public Optional<Flujo> flujoConIgualNombreInSprint(String flujoName, Long idproyecto, Long idsprint);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
 

}
