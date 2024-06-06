/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Flujo;
import com.sft.services.FlujoServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.FlujoRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class FlujoServicesImpl implements FlujoServices {
// <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    FlujoRestClient flujoRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Flujo flujo)">
    @Override
    public Boolean update(Flujo flujo) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = flujoRestClient.update(flujo).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Flujo> findByIdflujo(Long idflujo)">
    @Override
    public Optional<Flujo> findByIdflujo(Long idflujo) {
        try {
         Flujo result = flujoRestClient.findByIdflujo(idflujo);
            if (result == null || result.getIdflujo()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Flujo> lookup(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public List<Flujo> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Flujo> flujoList = new ArrayList<>();
        try {
            flujoList = flujoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return flujoList;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = flujoRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Flujo>(Flujo flujo)">
    @Override
    public Optional<Flujo> save(Flujo flujo) {
        try {

            Response response = flujoRestClient.save(flujo);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Flujo result = (Flujo) (response.readEntity(Flujo.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean flujoExist(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public Boolean flujoExistInSprint(String flujoName, Long idproyecto, Long idsprint) {
        Boolean result = Boolean.FALSE;
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("idproyecto", idproyecto),
                    eq("idsprint", idsprint),
                    eq("active", true),
                    eq("flujo", flujoName)
            );

            Document sort = new Document("idflujo", 1);
            if (count(filter, sort, page, size) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" List<Flujo> flujoConIgualNombreInSprint(String flujoName, Long idproyecto, Long idsprint)">
    @Override
    public Optional<Flujo> flujoConIgualNombreInSprint(String flujoName, Long idproyecto, Long idsprint) {
        Optional<Flujo> result = Optional.empty();
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("idproyecto", idproyecto),
                    eq("idsprint", idsprint),
                    eq("active", true),
                    eq("flujo", flujoName)
            );

            Document sort = new Document("idflujo", 1);
            List<Flujo> list = lookup(filter, sort, page, size);
            if (list == null || list.isEmpty()) {
                return Optional.empty();
            }
            result = Optional.of(list.get(0));
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>







    
   
}
