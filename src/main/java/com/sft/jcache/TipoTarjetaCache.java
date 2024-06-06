/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.jcache;

import com.sft.model.Tipotarjeta;
import com.sft.services.TipotarjetaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import javax.cache.Cache;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
@Named
public class TipoTarjetaCache implements Serializable {

    @Inject
    TipotarjetaServices tipotarjetaServices;

    @Inject
    Cache<Long, Tipotarjeta> cachedTipotarjetas;

    public Tipotarjeta getTipotarjeta(Long id) {
        cachedTipotarjetas.putIfAbsent(id, tipotarjetaServices.findByIdtipotarjeta(id).get());
        return cachedTipotarjetas.get(id);
//          if (!cachedTipotarjetas.containsKey(id)) {
//            cachedTipotarjetas.put(id, tipotarjetaServices.findByIdtipotarjeta(id));
//        }
//
//        return cachedTipotarjetas.get(id);
    }

}
