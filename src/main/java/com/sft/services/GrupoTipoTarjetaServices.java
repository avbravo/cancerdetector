/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.GrupoTipoTarjeta;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface GrupoTipoTarjetaServices {

    public List<GrupoTipoTarjeta> findAll();

    public Optional<GrupoTipoTarjeta> findByIdgrupoTipoTarjeta(Long idgrupoTipoTarjeta);

    public GrupoTipoTarjeta findByGrupoTipoTarjeta(String grupoTipoTarjeta);

    public Optional<GrupoTipoTarjeta> save(GrupoTipoTarjeta grupoTipoTarjeta);

    public Boolean update(GrupoTipoTarjeta grupoTipoTarjeta);

    public Boolean delete(Long idgrupoTipoTarjeta);

    public List<GrupoTipoTarjeta> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);
    public Boolean existsGrupoTipoTarjeta(GrupoTipoTarjeta grupoTipoTarjeta);
    
     public Long countLikeByGrupoTipoTarjeta(String grupoTipoTarjeta);
    

    public List<GrupoTipoTarjeta> likeByGrupoTipoTarjeta( String grupoTipoTarjeta);

}
