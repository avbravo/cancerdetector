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
import static com.mongodb.client.model.Filters.ne;
import com.sft.model.Central;
import com.sft.restclient.CentralRestClient;
import com.sft.services.CentralServices;

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
public class CentralServicesImpl implements CentralServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    CentralRestClient centralRestClient;
// </editor-fold>

    @Override
    public List<Central> findAll() {
        return centralRestClient.findAll();
    }

    @Override
    public Optional<Central> findByIdcentral(Long idcentral) {
        try {
            Central result = centralRestClient.findByIdcentral(idcentral);
            if (result == null || result.getIdcentral() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    @Override
    public Central findByCentral(String central) {
        return centralRestClient.findByCentral(central);
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Central > save(Central  central)">
    @Override
    public Optional<Central> save(Central central) {

        try {

            Response response = centralRestClient.save(central);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Central result = (Central) (response.readEntity(Central.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Central  central)">
    @Override
    public Boolean update(Central central) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = centralRestClient.update(central).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idcentral)">
    @Override
    public Boolean delete(Long idcentral) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = centralRestClient.delete(idcentral).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Central > lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Central> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Central> centralList = new ArrayList<>();
        try {
            centralList = centralRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return centralList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = centralRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Central > likeByCentral(String central)">
    @Override
    public List<Central> likeByCentral(String central) {

        return centralRestClient.likeByCentral(central);

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public Long countLikeByCentral(@QueryParam("central") String central)">
    @Override
    public Long countLikeByCentral(String central) {
        Long result = 0L;
        try {
            result = centralRestClient.countLikeByCentral(central);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    

    // <editor-fold defaultstate="collapsed" desc="Boolean existsCentral(Central central)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsCentral(Central central) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("central", central.getCentral());
            Document sort = new Document("idcentral", -1);
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

    
 
// <editor-fold defaultstate="collapsed" desc="Boolean existsCentralWithDiferentId(Central central)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsCentralWithDiferentId(Central central) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("central", central.getCentral()),
                    eq("institution.idinstitution", central.getInstitution().getIdinstitution()),
                    ne("idcentral", central.getIdcentral())
            );
            Document sort = new Document("idcentral", -1);
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
