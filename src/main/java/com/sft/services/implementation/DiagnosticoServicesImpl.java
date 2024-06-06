/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Diagnostico;
import com.sft.restclient.DiagnosticoRestClient;
import com.sft.services.DiagnosticoServices;
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
public class DiagnosticoServicesImpl implements DiagnosticoServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    DiagnosticoRestClient diagnosticoRestClient;
// </editor-fold>

    @Override
    public List<Diagnostico> findAll() {
        return diagnosticoRestClient.findAll();
    }

    @Override
    public Optional<Diagnostico> findByIddiagnostico(Long iddiagnostico) {
        try {
            Diagnostico result = diagnosticoRestClient.findByIddiagnostico(iddiagnostico);
            if (result == null || result.getIddiagnostico() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Diagnostico> findByDiagnostico(String diagnostico) {
        try {
            Diagnostico result = diagnosticoRestClient.findByDiagnostico(diagnostico);
            if (result == null || result.getIddiagnostico() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Optional<Diagnostico> save(Diagnostico diagnostico)">
    @Override
    public Optional<Diagnostico> save(Diagnostico diagnostico) {

        try {

            Response response = diagnosticoRestClient.save(diagnostico);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Diagnostico result = (Diagnostico) (response.readEntity(Diagnostico.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Diagnostico diagnostico)">
    @Override
    public Boolean update(Diagnostico diagnostico) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = diagnosticoRestClient.update(diagnostico).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iddiagnostico)">
    @Override
    public Boolean delete(Long iddiagnostico) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = diagnosticoRestClient.delete(iddiagnostico).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Diagnostico> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Diagnostico> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Diagnostico> diagnosticoList = new ArrayList<>();
        try {
            diagnosticoList = diagnosticoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return diagnosticoList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = diagnosticoRestClient.count(
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
