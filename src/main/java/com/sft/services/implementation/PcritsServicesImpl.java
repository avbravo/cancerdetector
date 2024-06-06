/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Pcrits;
import com.sft.restclient.PcritsRestClient;
import com.sft.services.PcritsServices;
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
public class PcritsServicesImpl implements PcritsServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    PcritsRestClient pcritsRestClient;
// </editor-fold>

    @Override
    public List<Pcrits> findAll() {
        return pcritsRestClient.findAll();
    }

    @Override
    public Optional<Pcrits> findByIdpcrits(Long idpcrits) {
        try {
            Pcrits result = pcritsRestClient.findByIdpcrits(idpcrits);
            if (result == null || result.getIdpcrits() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Pcrits> findByPcrits(String pcrits) {
        try {
            Pcrits result = pcritsRestClient.findByPcrits(pcrits);
            if (result == null || result.getIdpcrits() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Optional<Pcrits> save(Pcrits pcrits)">
    @Override
    public Optional<Pcrits> save(Pcrits pcrits) {

        try {

            Response response = pcritsRestClient.save(pcrits);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Pcrits result = (Pcrits) (response.readEntity(Pcrits.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Pcrits pcrits)">
    @Override
    public Boolean update(Pcrits pcrits) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = pcritsRestClient.update(pcrits).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idpcrits)">
    @Override
    public Boolean delete(Long idpcrits) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = pcritsRestClient.delete(idpcrits).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Pcrits> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Pcrits> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Pcrits> pcritsList = new ArrayList<>();
        try {
            pcritsList = pcritsRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return pcritsList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = pcritsRestClient.count(
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
