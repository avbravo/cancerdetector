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
import com.sft.model.Proyecto;
import com.sft.model.Timeline;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.services.ProyectoViewServices;
import com.sft.services.TimelineServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.TimelineRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class TimelineServicesImpl implements TimelineServices {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    TimelineRestClient timelineRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    ProyectoViewServices proyectoViewServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Timeline> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Timeline> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Timeline> timelineList = new ArrayList<>();
        try {
            timelineList = timelineRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return timelineList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = timelineRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Timeline> findByProyectoAndActive( Proyecto proyecto, Boolean active)">
    @Override
    public List<Timeline> findByProyectoAndActive(Proyecto proyecto, Boolean active) {
        List<Timeline> result = new ArrayList<>();
        try {
            Bson filter = and(eq("proyecto.idproyecto", proyecto.getIdproyecto()),
                    eq("active", active)
            );
            Document sort = new Document("idtimeline", -1);
            Integer page = 0;
            Integer size = 0;

            result = timelineRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Timeline> findByProyectoAndActive( List<Proyecto> proyectoList, Boolean active)">

    @Override
    public List<Timeline> findByProyectoAndActive(List<Proyecto> proyectoList, Boolean active) {
        List<Timeline> result = new ArrayList<>();

        try {
            if (proyectoList == null || proyectoList.isEmpty()) {
            } else {
                for (Proyecto p : proyectoList) {
                    Bson filter = and(eq("proyecto.idproyecto", p.getIdproyecto()),
                            eq("active", active)
                    );
                    Document sort = new Document("idtimeline", -1);
                    Integer page = 1;
                    Integer size = 1;

                    List<Timeline> timelineList = timelineRestClient.lookup(
                            EncodeUtil.encodeBson(filter),
                            EncodeUtil.encodeBson(sort),
                            page, size);
                    if (timelineList == null || timelineList.isEmpty()) {

                    } else {
                        timelineList.forEach(tl -> {
                            result.add(tl);
                        });
                    }

                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Timeline> findByProyectoAndActiveSprintOpen( List<ProyectoSprintOpen> proyectoSprintOpenList, Boolean active)">

    @Override
    public List<Timeline> findByProyectoAndActiveSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList, Boolean active) {
        List<Timeline> result = new ArrayList<>();

        try {
            if (proyectoSprintOpenList == null || proyectoSprintOpenList.isEmpty()) {
            } else {
                for (ProyectoSprintOpen pso : proyectoSprintOpenList) {
                    Bson filter = and(eq("proyecto.idproyecto", pso.getProyecto().getIdproyecto()),
                            eq("active", active)
                    );
                    Document sort = new Document("idtimeline", -1);
                    Integer page = 1;
                    Integer size = 1;

                    List<Timeline> timelineList = timelineRestClient.lookup(
                            EncodeUtil.encodeBson(filter),
                            EncodeUtil.encodeBson(sort),
                            page, size);
                    if (timelineList == null || timelineList.isEmpty()) {

                    } else {
                        timelineList.forEach(tl -> {
                            result.add(tl);
                        });
                    }

                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Timeline> findByActive(Boolean active)">
    @Override
    public List<Timeline> findByActive(Boolean active) {
        List<Timeline> result = new ArrayList<>();
        try {
            Bson filter = and(
                    eq("active", active)
            );
            Document sort = new Document("idtimeline", -1);
            Integer page = 0;
            Integer size = 0;

            result = timelineRestClient.lookup(
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
