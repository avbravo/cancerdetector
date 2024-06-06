/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Icono;
import com.sft.services.IconoServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.IconoRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class IconoServicesImpl implements IconoServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    IconoRestClient iconoRestClient;
// </editor-fold>

    @Override
    public List<Icono> findAll() {
        return iconoRestClient.findAll();
    }

    @Override
    public Optional<Icono> findByIdicono(Long idicono) {
        try {
            Icono result = iconoRestClient.findByIdicono(idicono);
            if (result == null || result.getIdicono() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Icono> findByIcono(String icono) {
        return iconoRestClient.findByIcono(icono);
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Icono> save(Icono icono)">
    @Override
    public Optional<Icono> save(Icono icono) {

        try {

            Response response = iconoRestClient.save(icono);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Icono result = (Icono) (response.readEntity(Icono.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Icono icono)">
    @Override
    public Boolean update(Icono icono) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = iconoRestClient.update(icono).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idicono)">
    @Override
    public Boolean delete(Long idicono) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = iconoRestClient.delete(idicono).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Icono> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Icono> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Icono> iconoList = new ArrayList<>();
        try {
            iconoList = iconoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return iconoList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = iconoRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public Long countLikeByIcono(@QueryParam("icono") String icono)">
    @Override
    public Long countLikeByIcono(String icono) {
        Long result = 0L;
        try {
            result = iconoRestClient.countLikeByIcono(icono);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Icono> likeByIcono( String  iconoview)">
    @Override
    public List<Icono> likeByIcono(String icono) {
        return iconoRestClient.likeByIcono(icono);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean existsIcono(Icono icono)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsIcono(Icono icono) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("icono", icono.getIcono());
            Document sort = new Document("idicono", -1);
            Integer total = count(filter, sort, 1, 1).intValue();

            if (total >= 1) {

                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>
}
