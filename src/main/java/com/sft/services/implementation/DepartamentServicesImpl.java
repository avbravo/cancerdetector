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
import com.sft.restclient.DepartamentRestClient;
import com.sft.model.Central;
import com.sft.model.Departament;
import com.sft.services.DepartamentServices;
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
public class DepartamentServicesImpl implements DepartamentServices {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    DepartamentRestClient departamentRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findAll">
    @Override
    public List<Departament> findAll() {
        return departamentRestClient.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Departament findByIddepartament">
    @Override
    public Optional<Departament> findByIddepartament(Long iddepartament) {

        
        try {
           Departament result = departamentRestClient.findByIddepartament(iddepartament);
            if (result == null || result.getIddepartament()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Departament> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
    public List<Departament> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Departament> result = new ArrayList<>();
        try {
            result = departamentRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Departament> save(Departament departament)">
    @Override
    public Optional<Departament> save(Departament departament) {
        try {

            Response response = departamentRestClient.save(departament);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Departament result = (Departament) (response.readEntity(Departament.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update( Departament departament)">
    @Override
    public Boolean update(Departament departament) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = departamentRestClient.update(departament).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long iddepartament)">
    @Override
    public Boolean delete(Long iddepartament) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = departamentRestClient.delete(iddepartament).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size)">
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = departamentRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    
      // <editor-fold defaultstate="collapsed" desc="Long countLikeByDepartament( String departament)">
    @Override
    public Long countLikeByDepartament( String departament) {
        Long result = 0L;
        try {
           result = departamentRestClient.countLikeByDepartament(departament);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Departament> likeByDepartament( String departament)">
    public List<Departament> likeByDepartament(String departament) {
        return departamentRestClient.likeByDepartament(departament);
    }
    // </editor-fold>
    
    
        // <editor-fold defaultstate="collapsed" desc="Boolean existsDepartament(Departament departament)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsDepartament(Departament departament, Central central) {
        Boolean result = Boolean.FALSE;
        try {
            
  
            
            Bson filter = and(eq("departament", departament.getDepartament()),
                    eq("central.idcentral",central.getIdcentral())
            )
                    ;
            Document sort = new Document("iddepartament", -1);
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
