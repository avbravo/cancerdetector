/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.GrupoTipoTarjeta;
import com.sft.model.PlantillaTarjeta;
import com.sft.model.User;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface PlantillaTarjetaServices {


    
    public Boolean existsPlantilla(User user, String plantilla, Boolean active);
//    public Boolean existsPlantilla(User user, String plantilla,GrupoTipoTarjeta grupoTipoTarjeta);
 public List<PlantillaTarjeta> lookup(User user);

    public List<PlantillaTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size);

    Long count(Bson filter, Document sort, Integer page, Integer size);

    public Optional<PlantillaTarjeta> findByIdplantillaTarjeta(Long idplantillaTarjeta);

    
    public Optional<PlantillaTarjeta> save(PlantillaTarjeta plantillaTarjeta);

    public Boolean update(PlantillaTarjeta plantillaTarjeta);

    
    public Long countLikeByPlantillaTarjeta(String plantilla);

    public List<PlantillaTarjeta> likeByPlantillaTarjeta( String plantilla);
}
