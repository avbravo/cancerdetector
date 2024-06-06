/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.DocumentUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.services.ProyectoViewServices;
import com.sft.services.SprintServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.sft.restclient.SprintRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class SprintServicesImpl implements SprintServices {

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    JmoordbResourcesFiles rf;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    SprintRestClient sprintRestClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Services">
    @Inject
    ProyectoViewServices proyectoViewServices;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Optional<Sprint> findByIdsprint(Long idsprint)">

    @Override
    public Optional<Sprint> findByIdsprint(Long idsprint) {
      
        
        try {
            Sprint result = sprintRestClient.findByIdsprint(idsprint);
            if (result == null || result.getIdsprint() == null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc=" Boolean update(Sprint sprint) ">
    @Override
    public Boolean update(Sprint sprint) {
        Boolean result = Boolean.FALSE;
        try {
            Integer status = sprintRestClient.update(sprint).getStatus();
            if (status == 201) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Sprint> openSprintList(Proyecto proyecto) ">
    @Override
    public List<Sprint> openSprintList(Proyecto proyecto) {
        List<Sprint> sprintList = new ArrayList<>();
        try {
            /**
             * Cargo los Sprint
             */
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyecto.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

            sprintList = sprintRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return sprintList;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSpint(Proyecto proyecto) ">
    @Override
    public Boolean haveOpenSprint(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {
            if (proyecto == null) {
                return result;
            }
            Integer page = 0;
            Integer size = 0;

            Bson filter = new Document("proyecto.idproyecto", proyecto.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

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
    // <editor-fold defaultstate="collapsed" desc="Boolean haveOpenSpintAndDateIsLessOrEquals(Proyecto proyecto) ">
    /**
     * Verifica que el Sprint este abierto en fechas validas
     *
     * @param proyecto
     * @param date
     * @return
     */
    @Override
    public Boolean haveOpenSprintAndDateIsLessOrEquals(Proyecto proyecto) {
        var result = Boolean.FALSE;
        try {

            if (proyecto == null) {
                return result;
            }
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyecto.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

            var sprintList = sprintRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

            if (sprintList == null || sprintList.isEmpty()) {

            } else {

                if ((JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechainicial())
                        || JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechainicial()))
                        && (JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechafinal())
                        || JmoordbCoreDateUtil.fechaMenor(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechafinal()))) {

                    result = Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            
            
            //   FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<Sprint> sprintOpenAndDateNowIsLessOrEquals(Proyecto proyecto) ">
    /**
     *
     *
     * @param proyecto
     * @param date
     * @return El Sprint siempre y cuando sea valido entre las fechas
     */
    @Override
    public Optional<Sprint> sprintOpenAndDateNowIsLessOrEquals(Proyecto proyecto) {
        var result = Boolean.FALSE;
        try {

            if (proyecto == null) {
                return Optional.empty();
            }
            Integer page = 0;
            Integer size = 0;
            Bson filter = new Document("proyecto.idproyecto", proyecto.getIdproyecto()).append("active", Boolean.TRUE)
                    .append("open", Boolean.TRUE);
            Document sort = new Document("proyecto.idproyecto", 1);

            var sprintList = sprintRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

            if (sprintList == null || sprintList.isEmpty()) {

            } else {

                if ((JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechainicial())
                        || JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechainicial()))
                        && (JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechafinal())
                        || JmoordbCoreDateUtil.fechaMenor(JmoordbCoreDateUtil.getFechaHoraActual(), sprintList.getFirst().getFechafinal()))) {

                    return Optional.of(sprintList.getFirst());
                }
            }
        } catch (Exception e) {
            ConsoleUtil.error("\t¨¨¨¨¨¨¨¨¨¨¨ " + FacesUtil.nameOfClassAndMethod() + " error: " + e.getLocalizedMessage());

            //   FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean isOpenSprintBetweenDateNow(Sprint sprint)">
    /**
     *
     *
     * @param proyecto
     * @param date
     * @return El Sprint siempre y cuando sea valido entre las fechas
     */
    @Override
    public Boolean isOpenSprintBetweenDateNow(Sprint sprint) {
        var result = Boolean.FALSE;
        try {

            if (sprint == null) {
                return result;
            }

            if ((JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprint.getFechainicial())
                    || JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.getFechaHoraActual(), sprint.getFechainicial()))
                    && (JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), sprint.getFechafinal())
                    || JmoordbCoreDateUtil.fechaMenor(JmoordbCoreDateUtil.getFechaHoraActual(), sprint.getFechafinal()))) {

                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            ConsoleUtil.error("\t¨¨¨¨¨¨¨¨¨¨¨ " + FacesUtil.nameOfClassAndMethod() + " error: " + e.getLocalizedMessage());
            
            //   FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Optional<Sprint> save(Sprint sprint)">
    @Override
    public Optional<Sprint> save(Sprint sprint
    ) {

        try {

            Response response = sprintRestClient.save(sprint);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class
                ));

                return Optional.empty();

            }

            Sprint result = (Sprint) (response.readEntity(Sprint.class
            ));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Sprint> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Sprint> lookup(Bson filter, Document sort,
            Integer page, Integer size
    ) {
        List<Sprint> sprintList = new ArrayList<>();
        try {
            sprintList = sprintRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return sprintList;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">

    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {

            result = sprintRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            ConsoleUtil.error("\t¨¨¨¨¨¨¨¨¨¨¨ " + FacesUtil.nameOfClassAndMethod() + " error: " + e.getStackTrace());
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean existsBySprintAndProjectBySprintAndProject(Proyecto proyecto, Sprint sprint) ">
    /**
     * Verifica si tiene un Sprint con ese nombre para el proyecto
     *
     * @param proyecto
     * @param sprint
     * @return
     */
    @Override
    public Boolean existsBySprintAndProject(Proyecto proyecto, Sprint sprint
    ) {
        Boolean result = Boolean.FALSE;
        try {
            Bson filter = and(eq("proyecto.idproyecto", proyecto.getIdproyecto()),
                    eq("sprint", sprint.getSprint())
            );
            Document sort = new Document("idsprint", -1);
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
    // <editor-fold defaultstate="collapsed" desc="Boolean exitsBetweenDates(Proyecto proyecto,Date fechaInicial, Date fechaFinal) ">

    /**
     * V
     *
     * @param proyecto
     * @param sprint
     * @return Verifica si existe si existe un sprinte entre esas fechas para el
     * proyecto
     */
    @Override
    public Boolean exitsBetweenDates(Proyecto proyecto, Date fechaInicial,
            Date fechaFinal
    ) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter0
                    = DocumentUtil.createBsonBetweenDateWithoutHours(
                            "fechainicial", fechaInicial, "fechafinal", fechaFinal);
            Bson filter = and(filter0, eq("proyecto.idproyecto", proyecto.getIdproyecto()));
          
            Document sort = new Document("idsprint", -1);
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
    // <editor-fold defaultstate="collapsed" desc="Boolean exitsBetweenDatesExcludeSprint(Proyecto proyecto, Date fechaInicial, Date fechaFinal, Sprint sprint)">

    /**
     * V
     *
     * @param proyecto
     * @param sprint
     * @return Verifica si existe si existe un sprinte entre esas fechas para el
     * proyecto
     */
    @Override
    public Boolean exitsBetweenDatesExcludeSprint(Proyecto proyecto, Date fechaInicial,
            Date fechaFinal, Sprint sprint
    ) {
        Boolean result = Boolean.FALSE;
        try {

            Bson filter0
                    = DocumentUtil.createBsonBetweenDateWithoutHours(
                            "fechainicial", fechaInicial, "fechafinal", fechaFinal);
            Bson filter1 = and(filter0, eq("proyecto.idproyecto", proyecto.getIdproyecto()));
            Bson filter = and(filter0, filter1, ne("idsprint", sprint.getIdsprint()));

            Document sort = new Document("idsprint", -1);
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

    // <editor-fold defaultstate="collapsed" desc="Long generateNumberForSprint(Proyecto proyecto)">
    /**
     * Genera un numero para el sprint del proyecto
     *
     * @param proyecto
     * @return
     */
    @Override
    public Long generateNumberForSprint(Proyecto proyecto
    ) {
        Long result = 0L;
        try {
            Bson filter = and(eq("proyecto.idproyecto", proyecto.getIdproyecto())
            );
            Document sort = new Document("idsprint", -1);
            Integer total = count(filter, sort, 1, 1).intValue() + 1;

            result = total.longValue();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Sprint> findByFechaGreaterThanEqualAndFechaLessThanEqual(Date fechainicial, Date fechafinal)">
    @Override
    public List<Sprint> findByFechaGreaterThanEqualAndFechaLessThanEqual(Date fechainicial, Date fechafinal
    ) {
        return sprintRestClient.findByFechaGreaterThanEqualAndFechaLessThanEqual(fechainicial, fechafinal);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="code()">
    /**
     * *
     *
     * @param proyecto
     * @param open
     * @return Cuenta el total de sprint en base a open
     */
    @Override
    public Long totalSprintOpen(Proyecto proyecto, Boolean open
    ) {
        Long result = 0L;

        try {
            Integer page = 0;
            Integer size = 0;
            Document sort = new Document("idsprint", 1);
            /**
             * CargarTarjetas
             */

            Bson filter0 = eq("proyecto.idproyecto", proyecto.getIdproyecto());
            Bson filter = and(filter0, eq("active", Boolean.TRUE),
                    eq("open", open));
            result = count(filter, sort, page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

}
