/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.sft.model.DepartamentView;
import com.sft.services.DepartamentViewServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.DepartamentViewRestClient;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class DepartamentViewServicesImpl implements DepartamentViewServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    DepartamentViewRestClient departamentViewRestClient;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">   

    @Override
    public List<DepartamentView> findAll() {
        return departamentViewRestClient.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<DepartamentView> findByIddepartamentView">
    @Override
    public Optional<DepartamentView> findByIddepartament(Long iddepartament) {
      
        
        try {
          DepartamentView result =departamentViewRestClient.findByIddepartament(iddepartament);
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

    @Override
    public DepartamentView findByDepartament(String departament) {
        return departamentViewRestClient.findByDepartament(departament);
    }

    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    @Override
    public List<DepartamentView> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<DepartamentView> departamentViewList = new ArrayList<>();
        try {
            departamentViewList = departamentViewRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return departamentViewList;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<DepartamentView> save( DepartamentView departamentview) ">
    @Override
    public Optional<DepartamentView> save(DepartamentView departamentview) {
        try {

            Response response = departamentViewRestClient.save(departamentview);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            DepartamentView result = (DepartamentView) (response.readEntity(DepartamentView.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(DepartamentView departamentview)">

    @PUT
    @Override
    public Boolean update(DepartamentView departamentview) {

        Boolean result = Boolean.FALSE;
        try {

            Integer status = departamentViewRestClient.update(departamentview).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long iddepartamentview)">
    @Override
    public Boolean delete(Long iddepartamentview) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = departamentViewRestClient.delete(iddepartamentview).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = departamentViewRestClient.count(
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
           result = departamentViewRestClient.countLikeByDepartament(departament);
               
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> likeByDepartament( String departamentview)">
    @Override
    public List<DepartamentView> likeByDepartament(String departament) {
        return departamentViewRestClient.likeByDepartament(departament);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<DepartamentView> loadDepartamentView(String query, List<DepartamentView> departamentViewSelectedList)">
    @Override
    public List<DepartamentView> loadDepartamentView(String query, List<DepartamentView> departamentViewSelectedList) {
        List<DepartamentView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

            List<DepartamentView> list = likeByDepartament(query);
            if (list != null || list.isEmpty()) {

            }
            if (departamentViewSelectedList.isEmpty()) {

                return list;
            } else {

                for (DepartamentView dvDB : list) {
                    found = Boolean.FALSE;
                    for (DepartamentView dv : departamentViewSelectedList) {

                        if (dvDB.getIddepartament().equals(dv.getIddepartament())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(dvDB);
                    }
                }

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
}
