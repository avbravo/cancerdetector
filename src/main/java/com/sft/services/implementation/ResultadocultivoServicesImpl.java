/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Resultadocultivo;
import com.sft.restclient.ResultadocultivoRestClient;
import com.sft.services.ResultadocultivoServices;
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
public class ResultadocultivoServicesImpl implements ResultadocultivoServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ResultadocultivoRestClient resultadocultivoRestClient;
// </editor-fold>

    @Override
    public List<Resultadocultivo> findAll() {
        return resultadocultivoRestClient.findAll();
    }

    @Override
    public Optional<Resultadocultivo> findByIdresultadocultivo(Long idresultadocultivo) {
        try {
            Resultadocultivo result = resultadocultivoRestClient.findByIdresultadocultivo(idresultadocultivo);
            if (result == null || result.getIdresultadocultivo() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Resultadocultivo> findByResultadocultivo(String resultadocultivo) {
        try {
            Resultadocultivo result = resultadocultivoRestClient.findByResultadocultivo(resultadocultivo);
            if (result == null || result.getIdresultadocultivo() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Optional<Resultadocultivo> save(Resultadocultivo resultadocultivo)">
    @Override
    public Optional<Resultadocultivo> save(Resultadocultivo resultadocultivo) {

        try {

            Response response = resultadocultivoRestClient.save(resultadocultivo);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Resultadocultivo result = (Resultadocultivo) (response.readEntity(Resultadocultivo.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Resultadocultivo resultadocultivo)">
    @Override
    public Boolean update(Resultadocultivo resultadocultivo) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = resultadocultivoRestClient.update(resultadocultivo).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idresultadocultivo)">
    @Override
    public Boolean delete(Long idresultadocultivo) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = resultadocultivoRestClient.delete(idresultadocultivo).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Resultadocultivo> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Resultadocultivo> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Resultadocultivo> resultadocultivoList = new ArrayList<>();
        try {
            resultadocultivoList = resultadocultivoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return resultadocultivoList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = resultadocultivoRestClient.count(
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
