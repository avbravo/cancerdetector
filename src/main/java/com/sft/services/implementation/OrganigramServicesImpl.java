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
import com.sft.restclient.OrganigramRestClient;
import com.sft.model.Central;
import com.sft.model.Departament;
import com.sft.model.DepartamentView;
import com.sft.model.Organigram;
import com.sft.services.OrganigramServices;
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
public class OrganigramServicesImpl implements OrganigramServices {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    OrganigramRestClient organigramRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findAll">
    @Override
    public List<Organigram> findAll() {
        return organigramRestClient.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Organigram> findByIdorganigram">
    @Override
    public Optional<Organigram> findByIdorganigram(Long idorganigram) {
         
          try {
           Organigram result = organigramRestClient.findByIdorganigram(idorganigram);
            if (result == null || result.getIdorganigram()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
          
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Organigram> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
    public List<Organigram> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Organigram> result = new ArrayList<>();
        try {
            result = organigramRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Organigram> save(Organigram organigram)">
    @Override
    public Optional<Organigram> save(Organigram organigram) {
        try {

            Response response = organigramRestClient.save(organigram);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Organigram result = (Organigram) (response.readEntity(Organigram.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update( Organigram organigram)">
    @Override
    public Boolean update(Organigram organigram) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = organigramRestClient.update(organigram).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idorganigram)">
    @Override
    public Boolean delete(Long idorganigram) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = organigramRestClient.delete(idorganigram).getStatus();

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
            result = organigramRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
  
    
    
        // <editor-fold defaultstate="collapsed" desc="Boolean existsDepartamentView(DepartamentView departamentView)">
  
    @Override
    public Boolean existsDepartamentView(DepartamentView departamentView) {
        Boolean result = Boolean.FALSE;
        try {
            
  
            
            Bson filter = and(eq("departament.iddepartament", departamentView.getIddepartament())
            ) ;
            Document sort = new Document("idorganigram", -1);
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
        // <editor-fold defaultstate="collapsed" desc=" Boolean existsDepartamentViewInEmbedded(DepartamentView departamentView)">
  
    @Override
    public Boolean existsDepartamentViewInEmbedded(DepartamentView departamentView){
        Boolean result = Boolean.FALSE;
        try {
            
  
            
            Bson filter = and(eq("organigramDepartament.departament.iddepartament", departamentView.getIddepartament())
            ) ;
            Document sort = new Document("idorganigram", -1);
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
