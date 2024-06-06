/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.eq;
import com.sft.model.Applicative;
import com.sft.services.ApplicativeServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.ApplicativeRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ApplicativeServicesImpl implements ApplicativeServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ApplicativeRestClient applicativeRestClient;
// </editor-fold>

    @Override
    public List<Applicative> findAll() {
        return applicativeRestClient.findAll();
    }

    @Override
    public Optional<Applicative> findByIdapplicative(Long idapplicative) {

        try {
            Applicative applicative = applicativeRestClient.findByIdapplicative(idapplicative);
            if (applicative == null || applicative.getIdapplicative() == null) {

            } else {
                return Optional.of(applicative);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Applicative> save(Applicative applicative)">
    @Override
    public Optional<Applicative> save(Applicative applicative) {

        try {

            Response response = applicativeRestClient.save(applicative);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Applicative result = (Applicative) (response.readEntity(Applicative.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Applicative applicative)">
    @Override
    public Boolean update(Applicative applicative) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = applicativeRestClient.update(applicative).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idapplicative)">
    @Override
    public Boolean delete(Long idapplicative) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = applicativeRestClient.delete(idapplicative).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Applicative> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Applicative> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Applicative> applicativeList = new ArrayList<>();
        try {
            applicativeList = applicativeRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return applicativeList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = applicativeRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="public Long countLikeByApplicative(@QueryParam("applicative") String applicative)">
    @Override
    public Long countLikeByApplicative(String applicative) {
        Long result = 0L;
        try {
            result = applicativeRestClient.countLikeByApplicative(applicative);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Applicative> likeByApplicative( String  applicative )">
    @Override
    public List<Applicative> likeByApplicative(String applicative) {
        return applicativeRestClient.likeByApplicative(applicative);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean existsApplicative(Applicative applicative)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsApplicative(Applicative applicative) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = eq("applicative", applicative.getApplicative());
            Document sort = new Document("idapplicative", -1);
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
