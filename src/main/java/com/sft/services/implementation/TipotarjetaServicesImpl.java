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
import com.sft.model.GrupoTipoTarjeta;
import com.sft.model.Proyecto;
import com.sft.model.Tarea;
import com.sft.model.Tipotarjeta;
import com.sft.services.TipotarjetaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.TipotarjetaRestClient;
import java.util.Comparator;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class TipotarjetaServicesImpl implements TipotarjetaServices {
    // <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    TipotarjetaRestClient tipotarjetaRestClient;
// </editor-fold>

    @Override
    public List<Tipotarjeta> findAll() {
        return tipotarjetaRestClient.findAll();
    }

    @Override
   public Optional<Tipotarjeta> findByIdtipotarjeta(Long idtipotarjeta) {

        try {
           Tipotarjeta result =tipotarjetaRestClient.findByIdtipotarjeta(idtipotarjeta);
            if (result == null || result.getIdtipotarjeta()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
    }

    @Override
    public List<Tipotarjeta> findByTipotarjeta(String tipotarjeta) {
        return tipotarjetaRestClient.findByTipotarjeta(tipotarjeta);
    }

    // <editor-fold defaultstate="collapsed" desc="Optional<Tipotarjeta> save(Tipotarjeta tipotarjeta)">
    @Override
    public Optional<Tipotarjeta> save(Tipotarjeta tipotarjeta) {

        try {

            Response response = tipotarjetaRestClient.save(tipotarjeta);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Tipotarjeta result = (Tipotarjeta) (response.readEntity(Tipotarjeta.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean update(Tipotarjeta tipotarjeta)">
    @Override
    public Boolean update(Tipotarjeta tipotarjeta) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = tipotarjetaRestClient.update(tipotarjeta).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idtipotarjeta)">
    @Override
    public Boolean delete(Long idtipotarjeta) {
        Boolean result = Boolean.FALSE;
        try {

            Integer status = tipotarjetaRestClient.delete(idtipotarjeta).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tipotarjeta> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Tipotarjeta> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Tipotarjeta> tipotarjetaList = new ArrayList<>();
        try {
            tipotarjetaList = tipotarjetaRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tipotarjetaList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = tipotarjetaRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean existsTipotarjeta(Tipotarjeta tipotarjeta)">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsTipotarjeta(Tipotarjeta tipotarjeta) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("tipotarjeta", tipotarjeta.getTipotarjeta()),
                    eq("grupoTipoTarjeta.idgrupotipotarjeta", tipotarjeta.getGrupoTipoTarjeta().getIdgrupotipotarjeta())
            );
            Document sort = new Document("idtipotarjeta", -1);
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
    // <editor-fold defaultstate="collapsed" desc="Boolean existsTipotarjetaWithDiferentId(Tipotarjeta tipotarjeta)">
    /**
     *
     * @param tipotarjeta
     * @return Verifica que no exista otro tipo y grupo generalmente para editar
     */
    @Override
    public Boolean existsTipotarjetaWithDiferentId(Tipotarjeta tipotarjeta) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter = and(
                    eq("tipotarjeta", tipotarjeta.getTipotarjeta()),
                    eq("grupoTipoTarjeta.idgrupotipotarjeta", tipotarjeta.getGrupoTipoTarjeta().getIdgrupotipotarjeta()),
                    ne("idtipotarjeta", tipotarjeta.getIdtipotarjeta())
            );
            Document sort = new Document("idtipotarjeta", -1);
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

    // <editor-fold defaultstate="collapsed" desc="Long countLikeByTipotarjeta( String tipotarjeta)">
    @Override
    public Long countLikeByTipotarjeta(String tipotarjeta) {
        Long result = 0L;
        try {
            result = tipotarjetaRestClient.countLikeByTipotarjeta(tipotarjeta);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tipotarjeta> likeByTipotarjeta(String tipotarjeta)">
    @Override
    public List<Tipotarjeta> likeByTipotarjeta(String tipotarjeta) {
        return tipotarjetaRestClient.likeByTipotarjeta(tipotarjeta);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tipotarjeta> loadTipotarjetaByProyecto(Proyecto proyecto) ">
    public List<Tipotarjeta> loadTipotarjetaByProyecto(Proyecto proyecto) {
        List<Tipotarjeta> tipotarjetaList = new ArrayList<>();
        try {

            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("active", Boolean.TRUE);

            Document sort = new Document("tipotarjeta", 1);

            if (proyecto.getGrupoTipoTarjeta() == null || proyecto.getGrupoTipoTarjeta().size() == 0) {

            } else {
                List<Tipotarjeta> tipoTarjetaListTemp = new ArrayList<>();

                for (GrupoTipoTarjeta gtt : proyecto.getGrupoTipoTarjeta()) {
                    Bson filter1 = and(filter,
                            eq("grupoTipoTarjeta.idgrupotipotarjeta", gtt.getIdgrupotipotarjeta())
                    );
                    tipoTarjetaListTemp = lookup(
                            filter1,
                            sort,
                            page, size);
                    if (tipoTarjetaListTemp == null || tipoTarjetaListTemp.isEmpty()) {

                    } else {
                        for (Tipotarjeta tp : tipoTarjetaListTemp) {
                            tipotarjetaList.add(tp);
                        }
                    }
                }

                if (tipotarjetaList == null || tipotarjetaList.isEmpty()) {

                } else {
                    Comparator<Tipotarjeta> comparator
                            = (c1, c2) -> c1.getTipotarjeta().compareTo(c2.getTipotarjeta());

                    tipotarjetaList.sort(comparator);
                }
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tipotarjetaList;
    }
// </editor-fold>

}
