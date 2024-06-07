/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.Motivo;
import com.sft.restclient.MotivoRestClient;
import com.sft.services.MotivoServices;
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
public class MotivoServicesImpl implements MotivoServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    MotivoRestClient motivoRestClient;
// </editor-fold>

    @Override
    public List<Motivo> findAll() {
        return motivoRestClient.findAll();
    }

    @Override
    public Optional<Motivo> findByIdmotivo(Long idmotivo) {
        try {
            Motivo result = motivoRestClient.findByIdmotivo(idmotivo);
            if (result == null || result.getIdmotivo() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Motivo> findByMotivo(String motivo) {
        try {
            Motivo result = motivoRestClient.findByMotivo(motivo);
            if (result == null || result.getIdmotivo() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

  

    // <editor-fold defaultstate="collapsed" desc="Optional<Motivo> save(Motivo motivo)">
    @Override
    public Optional<Motivo> save(Motivo motivo) {

        try {

            Response response = motivoRestClient.save(motivo);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Motivo result = (Motivo) (response.readEntity(Motivo.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Motivo motivo)">
    @Override
    public Boolean update(Motivo motivo) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = motivoRestClient.update(motivo).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idmotivo)">
    @Override
    public Boolean delete(Long idmotivo) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = motivoRestClient.delete(idmotivo).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Motivo> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Motivo> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Motivo> motivoList = new ArrayList<>();
        try {
          
            motivoList = motivoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return motivoList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = motivoRestClient.count(
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
