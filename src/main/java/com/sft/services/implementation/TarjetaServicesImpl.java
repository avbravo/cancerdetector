/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.util.MessagesUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.model.Comentario;
import com.sft.model.Impedimento;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.model.Tarea;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.model.domain.TotalesTarjetasEstadistica;
import com.sft.services.TarjetaServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.TarjetaRestClient;
import jakarta.ws.rs.QueryParam;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class TarjetaServicesImpl implements TarjetaServices {
// <editor-fold defaultstate="collapsed" desc="@Inject">

    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    TarjetaRestClient tarjetaRestClient;
    @Inject
    TarjetaServices tarjetaServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> findAll()">
    @Override
    public List<Tarjeta> findAll() {
        return tarjetaRestClient.findAll();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Tarjeta tarjeta)">

    @Override
    public Boolean update(Tarjeta tarjeta) {
        Boolean result = Boolean.FALSE;
        try {
       

            Integer status = tarjetaRestClient.update(tarjeta).getStatus();

            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Tarjeta> findByIdtarjeta(Long idtarjeta)">
    @Override
    public Optional<Tarjeta> findByIdtarjeta(Long idtarjeta, @QueryParam("idproyecto") Long idproyecto) {

        try {
            Tarjeta result = tarjetaRestClient.findByIdtarjetaIdproyecto(idtarjeta, idproyecto);
            if (result == null || result.getIdtarjeta() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();

    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> lookup(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyect)">

    @Override
    public List<Tarjeta> lookup(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyecto) {
        List<Tarjeta> tarjetaList = new ArrayList<>();
        try {

            tarjetaList = tarjetaRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size, idproyecto);

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return tarjetaList;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean deleteMany(Bson filter, Long idproyecto) ">

    @Override
    public Boolean deleteMany(Bson filter ,Long idproyecto) {
        Boolean result = Boolean.FALSE;
        try {
            Integer status = tarjetaRestClient.deleteMany(EncodeUtil.encodeBson(filter),idproyecto).getStatus();
            if (status == 201) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyecto)">
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyecto) {
        Long result = 0L;
        try {
            result = tarjetaRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size, idproyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Tarjeta>(Tarjeta tarjeta)">
    @Override
    public Optional<Tarjeta> save(Tarjeta tarjeta) {
        try {

            Response response = tarjetaRestClient.save(tarjeta);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Tarjeta result = (Tarjeta) (response.readEntity(Tarjeta.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean tarjetaExist(String tarjetaName, Long idproyecto, Long idsprint)">
    @Override
    public Boolean tarjetaExistInSprint(String tarjetaName, Long idproyecto, Long idsprint) {
        Boolean result = Boolean.FALSE;
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("idproyecto", idproyecto),
                    eq("idsprint", idsprint),
                    eq("active", true),
                    eq("tarjeta", tarjetaName)
            );

            Document sort = new Document("idtarjeta", 1);
            if (count(filter, sort, page, size, idproyecto) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean tarjetaExist(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public Boolean tarjetaExistInBacklog(String tarjetaName, Long idproyecto, Long idsprint) {
        Boolean result = Boolean.FALSE;
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("idproyecto", idproyecto),
                    eq("idsprint", 0L),
                    eq("active", true),
                    eq("tarjeta", tarjetaName)
            );

            Document sort = new Document("idtarjeta", 1);
            if (count(filter, sort, page, size, idproyecto) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" List<Tarjeta> tarjetaConIgualNombreInSprint(String tarjetaName, Long idproyecto, Long idsprint)">
    @Override
    public Optional<Tarjeta> tarjetaConIgualNombreInSprint(String tarjetaName, Long idproyecto, Long idsprint) {
        Optional<Tarjeta> result = Optional.empty();
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("idproyecto", idproyecto),
                    eq("idsprint", idsprint),
                    eq("active", true),
                    eq("tarjeta", tarjetaName)
            );

            Document sort = new Document("idtarjeta", 1);
            List<Tarjeta> list = lookup(filter, sort, page, size, idproyecto);
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
    // <editor-fold defaultstate="collapsed" desc="List<Comentario> ordenarComentario(Tarjeta tarjeta) ">
    /**
     * Ordena los comentarios por fecha
     *
     * @param tarjeta
     * @return
     */
    @Override
    public List<Comentario> ordenarComentarioPorFechaDescendente(Tarjeta tarjeta) {
        List<Comentario> result = new ArrayList<>();
        try {

            if (tarjeta.getComentario() == null || tarjeta.getComentario().isEmpty()) {
                return result;
            }
            Comparator<Comentario> comparator
                    = (c1, c2) -> c1.getFecha().compareTo(c2.getFecha());

            tarjeta.getComentario().sort(comparator.reversed());

        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjeta.getComentario();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean isMiembroAutorizedInTarjetaForanea(Tarjeta tarjeta, User userLogged, UserView userViewForaneo)">
    @Override
    public Boolean isMiembroAutorizedInTarjetaForanea(Tarjeta tarjeta, User userLogged, UserView userViewForaneo) {
        Boolean result = Boolean.FALSE;
        try {
            if (tarjeta.getForeaneo()) {
                if (userViewForaneo.getIduser().equals(userLogged.getIduser())) {

                } else {
                    result = Boolean.TRUE;
                }
            } else {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Comentario> ordenarTareaPorCompletadoDescendente(Tarjeta tarjeta) ">
    @Override
    public List<Tarea> ordenarTareaPorCompletadoDescendente(Tarjeta tarjeta) {
        List<Tarea> result = new ArrayList<>();
        try {

            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {
                return result;
            }
            Comparator<Tarea> comparator
                    = (c1, c2) -> c1.getCompletado().compareTo(c2.getCompletado());

            tarjeta.getTarea().sort(comparator);
//           tarjeta.getTarea().sort(comparator.reversed());

        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjeta.getTarea();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarea> ordenarTareaPorOrden(Tarjeta tarjeta)">
    @Override
    public List<Tarea> ordenarTareaPorOrden(Tarjeta tarjeta) {
        List<Tarea> result = new ArrayList<>();
        try {
            if (tarjeta.getTarea() == null || tarjeta.getTarea().isEmpty()) {
                return result;
            }
            Comparator<Tarea> comparator
                    = (c1, c2) -> c1.getOrden().compareTo(c2.getOrden());

            tarjeta.getTarea().sort(comparator);

        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjeta.getTarea();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Impedimento> ordenarImpedimentoDescendente(Tarjeta tarjeta) ">
    @Override
    public List<Impedimento> ordenarImpedimentoDescendente(Tarjeta tarjeta) {
        List<Impedimento> result = new ArrayList<>();
        try {

            if (tarjeta.getImpedimento() == null || tarjeta.getImpedimento().isEmpty()) {
                return result;
            }
            Comparator<Impedimento> comparator
                    = (c1, c2) -> c1.getImpedimento().compareTo(c2.getImpedimento());

            tarjeta.getImpedimento().sort(comparator.reversed());

        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjeta.getImpedimento();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long totalPorColumna(Proyecto proyecto, String columna,Boolean storeInBacklog) ">
    /**
     * *
     *
     * @param proyecto
     * @param columna
     * @param storeInBacklog
     * @return devuelve el total de columnas
     */
    @Override
    public Long totalPorColumna(Proyecto proyecto, String columna, Boolean storeInBacklog) {
        Long result = 0L;

        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            /**
             * CargarTarjetas
             */

            if (!storeInBacklog) {
                Bson filter0 = eq("idproyecto", proyecto.getIdproyecto());
                Bson filter = and(filter0, eq("active", Boolean.TRUE),
                        eq("columna", columna));
                result = count(filter, sortTarjeta, page, size, proyecto.getIdproyecto());
            } else {
                Bson filter0 = eq("idproyecto", proyecto.getIdproyecto());
                Bson filter = and(filter0, eq("active", Boolean.TRUE),
                        eq("columna", columna),
                        eq("backlog", storeInBacklog));
                result = count(filter, sortTarjeta, page, size, proyecto.getIdproyecto());
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean equalsExcludedNameOfTarjeta(Tarjeta tarjeta, Tarjeta other) ">
    @Override
    public Boolean equalsExcludedNameOfTarjeta(Tarjeta tarjeta, Tarjeta other) {
        Boolean result = Boolean.FALSE;
        try {
            if (tarjeta == null) {
                return false;
            }

            if (!Objects.equals(tarjeta.getDescripcion(), other.getDescripcion())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getPrioridad(), other.getPrioridad())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getEstimacion(), other.getEstimacion())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getColumna(), other.getColumna())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getIdtarjeta(), other.getIdtarjeta())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getUserView(), other.getUserView())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getFechainicial(), other.getFechainicial())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getFechafinal(), other.getFechafinal())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getIcono(), other.getIcono())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getTipotarjeta(), other.getTipotarjeta())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getIdsprint(), other.getIdsprint())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getIdproyecto(), other.getIdproyecto())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getBacklog(), other.getBacklog())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getActive(), other.getActive())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getTarea(), other.getTarea())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getComentario(), other.getComentario())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getEtiqueta(), other.getEtiqueta())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getArchivo(), other.getArchivo())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getImpedimento(), other.getImpedimento())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getForeaneo(), other.getForeaneo())) {
                return false;
            }
            if (!Objects.equals(tarjeta.getActionHistory(), other.getActionHistory())) {
                return false;
            }
            result = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isEstimacionValida(Tarjeta tarjeta)">
    @Override
    public Boolean isEstimacionValida(Tarjeta tarjeta) {
        Boolean result = Boolean.TRUE;
        try {

            if (tarjeta.getEstimacion() == null || tarjeta.getEstimacion().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingreseestimacionformato"));
                return Boolean.FALSE;
            }

            if (tarjeta.getEstimacion().indexOf(":") == -1) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingreseestimacionformato"));
                return Boolean.FALSE;
            }

            if (tarjeta.getEstimacion().indexOf("-") != -1) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingreseestimacionformato"));
                return Boolean.FALSE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String colorTarjeta(Tarjeta tarjeta)">
    /**
     * Listado de colores https://tailwindcss.com/docs/background-color
     *
     * @param tarjeta
     * @return
     */
    @Override
    public String colorTarjeta(Tarjeta tarjeta) {
        String color = "";
        try {
            switch (tarjeta.getPrioridad().toLowerCase()) {

                case "urgente":
                    color = "bg-orange-900";
                    break;

                case "alta":
                    color = "bg-purple-900";
                    break;
                case "baja":
////color ="bg-green-950";
//color ="bg-teal-600";
////color ="bg-green-600";
//                    color = "bg-indigo-900";
//                    color = "bg-indigo-700";
                    color = "bg-teal-900";
                    break;

                case "media":
                    color = "";
                    break;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return color;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public Long countLikeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("idproyecto") Long idproyecto)">
    @Override
    public Long countLikeByTarjeta(String tarjeta, @QueryParam("idproyecto") Long idproyecto) {
        Long result = 0L;
        try {
            result = tarjetaRestClient.countLikeByTarjeta(tarjeta,idproyecto);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Long countLikeByDescripcion( String descripcion, @QueryParam("idproyecto") Long idproyecto)">
    @Override
    public Long countLikeByDescripcion(String descripcion, @QueryParam("idproyecto") Long idproyecto) {
        Long result = 0L;
        try {
            result = tarjetaRestClient.countLikeByDescripcion(descripcion,idproyecto);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public List<Tarjeta> likeByTarjeta(String tarjeta, @QueryParam("idproyecto") Long idproyecto)">
    @Override
    public List<Tarjeta> likeByTarjeta(String tarjeta, @QueryParam("idproyecto") Long idproyecto) {
        return tarjetaRestClient.likeByTarjeta(tarjeta,idproyecto);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="public List<Tarjeta> likeByTarjetaPagination(String tarjeta, Pagination pagination,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public List<Tarjeta> likeByTarjetaPagination(String tarjeta, Pagination pagination,@QueryParam("idproyecto") Long idproyecto) {

        return tarjetaRestClient.likeByTarjetaPagination(tarjeta, pagination.getPage(), pagination.getSize(), idproyecto);

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> likeByDescripcion(String descripcion,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public List<Tarjeta> likeByDescripcion(String descripcion,@QueryParam("idproyecto") Long idproyecto) {
        return tarjetaRestClient.likeByDescripcion(descripcion,idproyecto);
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal,@QueryParam("idproyecto") Long idproyecto) ">
    public List<Tarjeta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal,@QueryParam("idproyecto") Long idproyecto) {
        return tarjetaRestClient.betweenDate(fechainicial, fechafinal,idproyecto);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> searchLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public List<Tarjeta> searchLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto) {
        List<Tarjeta> tarjetaList = new ArrayList<>();
        try {
            tarjetaList = tarjetaRestClient.searchLikeByTarjeta(tarjeta,
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size,idproyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjetaList;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long searchCountLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public Long searchCountLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto) {
        Long result = 0L;
        try {
            result = tarjetaRestClient.searchCountLikeByTarjeta(tarjeta,
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size,idproyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="List<Tarjeta> searchLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public List<Tarjeta> searchLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto) {
        List<Tarjeta> tarjetaList = new ArrayList<>();
        try {
            tarjetaList = tarjetaRestClient.searchLikeByDescripcion(descripcion,
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size,idproyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return tarjetaList;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long searchCountLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto)">
    @Override
    public Long searchCountLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto) {
        Long result = 0L;
        try {
            result = tarjetaRestClient.searchCountLikeByDescripcion(descripcion,
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size,idproyecto);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> validarFechaFinalEsteSprintActual(List<Tarjeta> list, Sprint sprint)">

    /**
     * Valida y garantiza que la ultima fecha de la tarjeta este en el sprint
     * actual
     *
     * @param list
     * @param sprint
     * @return
     */
    @Override
    public List<Tarjeta> validarFechaFinalEsteSprintActual(List<Tarjeta> list, Sprint sprint) {
        List<Tarjeta> result = new ArrayList<>();
        try {
            if (list == null || list.isEmpty()) {
                return result;
            } else {
                /**
                 * Verifica que la fecha final de la tarjeta no sea menor que la
                 * fecha inicial del sprint si ocurre actualiza con la fecha y
                 * hora actual
                 */
                Integer count = 0;
                for (Tarjeta t : list) {

                    if (DateUtil.fechaMenor(t.getFechafinal(), sprint.getFechainicial())) {
                        t.setFechafinal(sprint.getFechafinal());
                        update(t);
                        list.get(0).setFechafinal(t.getFechafinal());
                    }
                    count++;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return list;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> validarFechaFinalSprintPlanTrabajo(List<Tarjeta> list, Sprint sprint)">
    /**
     * Valida y garantiza que la ultima fecha de la tarjeta en el sprint del
     * plan de trabajo actual
     *
     * @param list
     * @param sprint
     * @return
     */
    @Override
    public List<Tarjeta> validarFechaFinalSprintPlanTrabajo(List<Tarjeta> list, Sprint sprint) {
        List<Tarjeta> result = new ArrayList<>();
        try {
            if (list == null || list.isEmpty()) {
                return result;
            } else {
                /**
                 * Verifica que la fecha final de la tarjeta no sea menor que la
                 * fecha inicial del sprint si ocurre actualiza con la fecha y
                 * hora actual
                 */
                Integer count = 0;
                for (Tarjeta t : list) {
                    if (t.getIdproyecto().equals(sprint.getProyectoView().getIdproyecto())) {
                        if (DateUtil.fechaMenor(t.getFechafinal(), sprint.getFechainicial())) {
                            t.setFechafinal(sprint.getFechafinal());
                            t.setLastModification(t.getActionHistory().getLast().getFecha());
                            update(t);
                            list.get(count).setFechafinal(t.getFechafinal());
                        } else {
                            //  t.setLastModification(t.getActionHistory().getLast().getFecha());
                            //   list.get(count).setLastModification(t.getActionHistory().getLast().getFecha());
                        }

                    }
                    count++;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return list;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> orderListForIdTarjetaReserve(List<Tarjeta> list)">
    /**
     *
     * @param list
     * @return lista de tarjeta ordenada por idtarjeta en orden inverso
     */
    @Override
    public List<Tarjeta> orderListForIdTarjetaReserve(List<Tarjeta> list) {
        try {
            list = list.stream().sorted(Comparator.comparing(Tarjeta::getIdtarjeta).reversed()).collect(Collectors.toList());

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return list;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Integer positionOfTarjeta(Tarjeta tarjeta, List<Tarjeta> tarjetas)">
    @Override
    public Integer positionOfTarjeta(Tarjeta tarjeta, List<Tarjeta> tarjetas) {
        Integer result = -1;
        try {

            Integer c = 0;
            for (Tarjeta t : tarjetas) {
                if (t.getIdtarjeta().equals(tarjeta.getIdtarjeta())) {
                    result = c;
                    break;
                }
                c++;

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    @Override
    public TotalesTarjetasEstadistica calcularTotalesTarjetasEstadistica(Long iduser, List<ProyectoSprintOpen> proyectoSprintOpenList) {
        TotalesTarjetasEstadistica result = new TotalesTarjetasEstadistica(0L, 0L, 0L, 0L, iduser);
        try {
            Integer page = 0;
            Integer size = 0;
            Document sortTarjeta = new Document("idtarjeta", 1);
            Document sortSprint = new Document("idtarjeta", 1);
            /**
             * CargarTarjetas
             */
            Bson filter0 = eq("userView.iduser", iduser);
            
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "pendiente"),
                    ne("idsprint", 0L));

            Bson filterProgreso = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "progreso"));
            Bson filterFinalizado = and(filter0, eq("active", Boolean.TRUE),
                    eq("columna", "finalizado"));

            Bson filterBacklog = and(filter0, eq("active", Boolean.TRUE),
                    eq("backlog", true),
                    eq("idsprint", 0L));
            Long pendiente = 0L;

            Long progreso = 0L;

            Long finalizado = 0L;

            Long backlog = 0L;
            for (ProyectoSprintOpen pso : proyectoSprintOpenList) {

                pendiente += tarjetaServices.count(filter, sortTarjeta, page, size, pso.getProyecto().getIdproyecto());

                progreso += tarjetaServices.count(filterProgreso, sortTarjeta, page, size, pso.getProyecto().getIdproyecto());

                finalizado += tarjetaServices.count(filterFinalizado, sortTarjeta, page, size, pso.getProyecto().getIdproyecto());

                backlog += tarjetaServices.count(filterBacklog, sortTarjeta, page, size, pso.getProyecto().getIdproyecto());
            }

            result.setTotalTarjetasBacklog(backlog);
            result.setTotalTarjetasFinalizado(finalizado);
            result.setTotalTarjetasPendiente(pendiente);
            result.setTotalTarjetasProgreso(progreso);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

}
