/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Etiquetadoimagen;
import com.sft.restclient.EtiquetadoimagenRestClient;
import com.sft.services.EtiquetadoimagenServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class EtiquetadoimagenServicesImpl implements EtiquetadoimagenServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    EtiquetadoimagenRestClient etiquetadoimagenRestClient;
// </editor-fold>

    @Override
    public List<Etiquetadoimagen> findAll() {
        return etiquetadoimagenRestClient.findAll();
    }

    @Override
    public Optional<Etiquetadoimagen> findByIdetiquetadoimagen(Long idetiquetadoimagen) {
        try {
            Etiquetadoimagen result = etiquetadoimagenRestClient.findByIdetiquetadoimagen(idetiquetadoimagen);
            if (result == null || result.getIdetiquetadoimagen() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Etiquetadoimagen> findByEtiquetadoimagen(String etiquetadoimagen) {
        try {
            Etiquetadoimagen result = etiquetadoimagenRestClient.findByEtiquetadoimagen(etiquetadoimagen);
            if (result == null || result.getIdetiquetadoimagen() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Optional<Etiquetadoimagen> save(Etiquetadoimagen etiquetadoimagen)">
    @Override
    public Optional<Etiquetadoimagen> save(Etiquetadoimagen etiquetadoimagen) {

        try {

            Response response = etiquetadoimagenRestClient.save(etiquetadoimagen);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Etiquetadoimagen result = (Etiquetadoimagen) (response.readEntity(Etiquetadoimagen.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Etiquetadoimagen etiquetadoimagen)">
    @Override
    public Boolean update(Etiquetadoimagen etiquetadoimagen) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = etiquetadoimagenRestClient.update(etiquetadoimagen).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idetiquetadoimagen)">
    @Override
    public Boolean delete(Long idetiquetadoimagen) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = etiquetadoimagenRestClient.delete(idetiquetadoimagen).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Etiquetadoimagen> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Etiquetadoimagen> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Etiquetadoimagen> etiquetadoimagenList = new ArrayList<>();
        try {
            etiquetadoimagenList = etiquetadoimagenRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return etiquetadoimagenList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = etiquetadoimagenRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
 

   
}
