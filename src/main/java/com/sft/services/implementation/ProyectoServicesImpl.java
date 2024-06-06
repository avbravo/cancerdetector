/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.encode.EncodeUtil;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.ne;
import static com.mongodb.client.model.Filters.or;
import com.sft.model.Area;
import com.sft.model.DepartamentView;
import com.sft.services.ProyectoServices;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.model.domain.ProyectoSprintOpen;
import com.sft.services.ProyectoEstadisticaServices;
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
import com.sft.restclient.ProyectoEstadisticaRestClient;
import com.sft.restclient.ProyectoRestClient;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class ProyectoServicesImpl implements ProyectoServices {
// <editor-fold defaultstate="collapsed" desc="Services">

    @Inject
    ProyectoEstadisticaServices proyectoEstadisticaServices;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
    @Inject
    ProyectoRestClient proyectoRestClient;
    @Inject
    SprintRestClient sprintRestClient;

    @Inject
    ProyectoEstadisticaRestClient proyectoEstadisticaClient;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Proyecto> save(Proyecto proyecto)">
    @Override
    public Optional<Proyecto> save(Proyecto proyecto) {

        try {

            Response response = proyectoRestClient.save(proyecto);

            if (response.getStatus() == 400) {

                String error = (response.readEntity(String.class));

                return Optional.empty();
            }

            Proyecto result = (Proyecto) (response.readEntity(Proyecto.class));

            return Optional.of(result);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="cargarProyectoEstadistica(List<Proyecto> proyectoList)">
    /**
     * Carga las estadisitcas del proyecto
     *
     * @param proyectoList
     * @return
     */
    @Override
    public List<ProyectoEstadistica> cargarProyectoEstadistica(List<Proyecto> proyectoList) {
        List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();
        try {

            if (proyectoList == null || proyectoList.isEmpty()) {

            } else {
                for (Proyecto p : proyectoList) {

                    ProyectoEstadistica proyectoEstadistica = calcularEstadistica(p);

                    proyectoEstadisticaList.add(proyectoEstadistica);

                    Double avance = proyectoEstadisticaServices.calcularAvance(proyectoEstadistica);

                    /**
                     * Si son diferentes los valores del avance del proyecto con
                     * el calculado lo actualiza.
                     */
                    if (!p.getAvance().equals(avance)) {
                        p.setAvance(avance);
                        update(p);
                    }

                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }
        return proyectoEstadisticaList;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="cargarProyectoEstadisticaSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList)">
    /**
     * Carga las estadisitcas del proyecto
     *
     * @param proyectoList
     * @return
     */
    @Override
    public List<ProyectoEstadistica> cargarProyectoEstadisticaSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList) {
        List<ProyectoEstadistica> proyectoEstadisticaList = new ArrayList<>();
        try {

            if (proyectoSprintOpenList == null || proyectoSprintOpenList.isEmpty()) {

            } else {
                for (ProyectoSprintOpen pso : proyectoSprintOpenList) {

                    
                    ProyectoEstadistica proyectoEstadistica = calcularEstadistica(pso.getProyecto());

                    proyectoEstadisticaList.add(proyectoEstadistica);

                    Double avance = proyectoEstadisticaServices.calcularAvance(proyectoEstadistica);

                    /**
                     * Si son diferentes los valores del avance del proyecto con
                     * el calculado lo actualiza.
                     */
                    if (!pso.getProyecto().getAvance().equals(avance)) {
                        pso.getProyecto().setAvance(avance);
                        update(pso.getProyecto());
                    }

                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());

        }
        return proyectoEstadisticaList;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="ProyectoEstadistica calcularEstadistica(Proyecto proyecto) ">
    public ProyectoEstadistica calcularEstadistica(Proyecto proyecto) {
        ProyectoEstadistica proyectoEstadistica = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());
        try {

            proyectoEstadistica = proyectoEstadisticaClient.findByIdproyecto(proyecto.getIdproyecto());
            if (proyectoEstadistica == null || proyectoEstadistica.getIdproyecto() == null) {
             
                proyectoEstadistica = new ProyectoEstadistica(0, 0, 0, 0, 0, proyecto.getIdproyecto());
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoEstadistica;
    }
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Proyecto lookup(User user) ">
    public List<Proyecto> lookup(User user) {
        List<Proyecto> proyectoList = new ArrayList<>();
        try {

            Integer page = 0;
            Integer size = 0;

            Bson filter = and(eq("proyectoMiembro.user.iduser", user.getIduser()),
                    eq("active", Boolean.TRUE),
                    ne("estado", "finalizado")
            );

            Document sort = new Document("proyecto.idproyecto", 1);

            proyectoList = proyectoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoList;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Proyecto proyecto)">
    @Override
    public Boolean update(Proyecto proyecto) {
        Boolean result = Boolean.FALSE;
        try {
            Response response = proyectoRestClient.update(proyecto);
            if (response.getStatus() == 201) {
                result = Boolean.TRUE;
            }
        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Proyecto> findByFechaGreaterThanEqualAndFechaLessThanEqual(Date fechainicial, Date fechafinal)">
    @Override
    public List<Proyecto> findByFechaGreaterThanEqualAndFechaLessThanEqual(Date fechainicial, Date fechafinal) {
        return proyectoRestClient.findByFechaGreaterThanEqualAndFechaLessThanEqual(fechainicial, fechafinal);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isPropietario(Proyecto proyecto,Long iduser)">
    /**
     *
     * @param proyectoList
     * @param userViewList
     * @return List<UserView> de los usuarios en los proyectos
     */
    @Override
    public Boolean isPropietario(Proyecto proyecto, Long iduser) {
        Boolean result = Boolean.FALSE;
        try {

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(iduser)) {
                    if (pm.getPropietario()) {
                        result = Boolean.TRUE;
                        break;
                    }

                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean isColaborador(List<Proyecto> proyectoList,Long iduser)">
    /**
     *
     * @param proyectoList
     * @param userViewList
     * @return List<UserView> de los usuarios en los proyectos
     */
    @Override
    public Boolean isColaborador(Proyecto proyecto, Long iduser) {
        Boolean result = Boolean.FALSE;
        try {

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(iduser)) {
                    if (!pm.getPropietario()) {
                        result = Boolean.TRUE;
                        break;
                    }

                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<UserView> generateUserViewPropietarioList(Proyecto proyecto, List<UserView> userViewList)">
    /**
     *
     * @param proyectoList
     * @param userViewList
     * @return List<UserView> de los usuarios en los proyectos
     */
    @Override
    public List<UserView> generateUserViewPropietarioList(Proyecto proyecto, List<UserView> userViewList) {
        List<UserView> result = new ArrayList<>();
        try {

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getPropietario()) {
                    Optional<UserView> userViewOptional = result.stream()
                            .filter(u -> u.getIduser() == pm.getUserView().getIduser())
                            .findFirst();
                    if (!userViewOptional.isPresent()) {
                        result.add(pm.getUserView());
                    }
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<UserView> generateUserViewColaboradorList(Proyecto proyecto, List<UserView> userViewList)">
    @Override
    public List<UserView> generateUserViewColaboradorList(Proyecto proyecto, List<UserView> userViewList) {
        List<UserView> result = new ArrayList<>();
        try {

            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (!pm.getPropietario()) {
                    Optional<UserView> userViewOptional = result.stream()
                            .filter(u -> u.getIduser() == pm.getUserView().getIduser())
                            .findFirst();
                    if (!userViewOptional.isPresent()) {
                        result.add(pm.getUserView());
                    }
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="List<Proyecto> cargarProyectosPrivados(User user)">

//    /**
//     *
//     * @param user
//     * @return List<Proyecto> que son publicos y no esta asignado el usuario
//     */
//
//    @Override
//    public List<Proyecto> cargarProyectosPrivados(User user) {
//        List<Proyecto> proyectoList = new ArrayList<>();
//        try {
//
//            Integer page = 0;
//            Integer size = 0;
//
//            Bson filter = and(eq("proyectoMiembro.user.iduser", user.getIduser()),
//                    eq("active", Boolean.TRUE),
//                    ne("estado", "finalizado")
//            );
//
//            Document sort = new Document("proyecto.idproyecto", 1);
//
//            proyectoList = proyectoRestClient.lookup(
//                    EncodeUtil.encodeBson(filter),
//                    EncodeUtil.encodeBson(sort),
//                    page, size);
//
//        } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return proyectoList;
//    }
//    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="List<Proyecto> cargarProyectosPrivadosConSprintAbierto(User user) ">

    /**
     *
     * @param user
     * @return List<Proyecto> que son publicos y no esta asignado el usuario
     */

    @Override
    public List<ProyectoSprintOpen> cargarProyectosPrivadosConSprintAbierto(User user) {
        List<ProyectoSprintOpen> proyectoSprintOpenList = new ArrayList<>();
        try {

            Integer page = 0;
            Integer size = 0;

//            Bson filter = and(eq("proyectoMiembro.user.iduser", user.getIduser()),
//                    eq("active", Boolean.TRUE),
//                    ne("estado", "finalizado")
//            );
            Bson filter = and(eq("proyectoMiembro.user.iduser", user.getIduser()),
                    eq("active", Boolean.TRUE),
                    and(
                            or(
                             eq("estado", "iniciado"),
                             eq("estado","detenido"))
                            
            )
            );

            Document sort = new Document("proyecto.idproyecto", 1);

            proyectoSprintOpenList = proyectoConSprintAbierto(filter, sort, page, size);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoSprintOpenList;
    }
    // </editor-fold>
    

    
// <editor-fold defaultstate="collapsed" desc="List<Proyecto> cargarProyectosPublicosNoAsignadosConSprintAbierto(User user)">

    /**
     *
     * @param user
     * @return List<Proyecto> que son publicos y no esta asignado el usuario
     */

    @Override
    public List<ProyectoSprintOpen> cargarProyectosPublicosNoAsignadosConSprintAbierto(User user) {
        List<ProyectoSprintOpen> proyectoSprintOpenList = new ArrayList<>();
        try {

            Integer page = 0;
            Integer size = 0;

//            Bson filter = and(ne("proyectoMiembro.user.iduser", user.getIduser()),
//                    eq("active", Boolean.TRUE),
//                    ne("estado", "finalizado"),
//                    eq("privado", Boolean.FALSE)
//            );
            Bson filter = and(ne("proyectoMiembro.user.iduser", user.getIduser()),
                    eq("active", Boolean.TRUE),
                    and(
                            or(
                             eq("estado", "iniciado"),
                             eq("estado","detenido"))
                            
            ),
                    eq("privado", Boolean.FALSE)
            );

            Document sort = new Document("proyecto.idproyecto", 1);

          

            proyectoSprintOpenList = proyectoConSprintAbierto(filter, sort, page, size);
           
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoSprintOpenList;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean nombreProyectoExist(String proyectoName) ">
    @Override
    public Boolean nombreProyectoExiste(String proyectoName) {
        Boolean result = Boolean.FALSE;
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("proyecto", proyectoName)
            );

            Document sort = new Document("idproyecto", 1);
            if (count(filter, sort, page, size) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean prefijoExiste(String prefijo)">
    @Override
    public Boolean prefijoExiste(String prefijo) {
        Boolean result = Boolean.FALSE;
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("prefijo", prefijo)
            );

            Document sort = new Document("idproyecto", 1);
            if (count(filter, sort, page, size) > 0) {
                result = Boolean.TRUE;
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Proyecto> lookup(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<Proyecto> lookup(Bson filter, Document sort, Integer page, Integer size) {
        List<Proyecto> proyectoList = new ArrayList<>();
        try {
            proyectoList = proyectoRestClient.lookup(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoList;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Proyecto> proyectoConSprintAbierto(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public List<ProyectoSprintOpen> proyectoConSprintAbierto(Bson filter, Document sort, Integer page, Integer size) {
        List<ProyectoSprintOpen> proyectoSprintOpenList = new ArrayList<>();
        try {
            proyectoSprintOpenList = proyectoRestClient.proyectoConSprintAbierto(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyectoSprintOpenList;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort, Integer page, Integer size)">
    @Override
    public Long count(Bson filter, Document sort, Integer page, Integer size) {
        Long result = 0L;
        try {
            result = proyectoRestClient.count(
                    EncodeUtil.encodeBson(filter),
                    EncodeUtil.encodeBson(sort),
                    page, size);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="sugerirPrefijo(Proyecto proyecto)">
    /**
     * Genera el prefijo solo de las siglas sin numero secuencial
     *
     * @param proyecto
     * @return
     */
    @Override
    public String sugerirPrefijo(Proyecto proyecto) {
        try {

            String prefijo = "";
            Integer limit = 0;
            String[] result = proyecto.getProyecto().split("\\s");

            if (result.length <= 1) {

                if (proyecto.getProyecto().length() < 4) {
                    limit = proyecto.getProyecto().length();
                } else {
                    limit = 4;
                }
                prefijo = result[0].substring(0, limit);
            } else {

                for (int x = 0; x < result.length; x++) {
                    if (result[x].length() <= 2) {
                        limit = result[x].length();
                    } else {
                        limit = 2;
                    }

                    prefijo += result[x].substring(0, limit);
                }
            }
            proyecto.setPrefijo(prefijo + "-");

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyecto.getPrefijo();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String genererNumeroPrefijo(Proyecto proyecto,JmoordbResourcesFiles rf)">
    /**
     *
     * @param proyecto
     * @return Devuelve el prefijo con el numero secuencial
     */
    @Override
    public String genererNumeroPrefijo(Proyecto proyecto, JmoordbResourcesFiles rf) {
        try {
            if (proyecto.getPrefijo() == null || proyecto.getPrefijo().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresenumeroprefijo"));
                return "";
            } else {
                Integer page = 0;
                Integer size = 0;
                Bson filter = eq("active", Boolean.TRUE);
                Document sort = new Document("idproyecto", 1);
                Long row = count(filter, sort, page, size);

                Integer index = 0;
                if (row.intValue() == 0) {

                    proyecto.setPrefijo(proyecto.getPrefijo() + "1");
                } else {

                    index = 0;
                    String prefijo = proyecto.getPrefijo();
                    Boolean found = Boolean.FALSE;
                    for (int i = 0; i < row.intValue(); i++) {
                        index++;
                        proyecto.setPrefijo(prefijo + index);

                        if (prefijoExiste(proyecto.getPrefijo())) {

                            found = Boolean.TRUE;
                        } else {

                            found = Boolean.FALSE;
                            break;
                        }

                    }
                    if (found) {
                        proyecto.setPrefijo(prefijo + (index + 1));
                    }

                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return proyecto.getPrefijo();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Proyecto>findByIdproyecto findByIdproyecto(Long idproyecto) ">
    @Override
    public Optional<Proyecto>findByIdproyecto(Long idproyecto) {
        try {
            Proyecto result = proyectoRestClient.findByIdproyecto(idproyecto);
            if (result == null || result.getIdproyecto()== null) {

            } else {
                return Optional.of(result);
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Proyecto> proyectoConIgualNombre(String proyectoName)">
    @Override
    public Optional<Proyecto> proyectoConIgualNombre(String proyectoName) {
        Optional<Proyecto> result = Optional.empty();
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("proyecto", proyectoName)
            );

            Document sort = new Document("idproyecto", 1);
            List<Proyecto> list = lookup(filter, sort, page, size);
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
    // <editor-fold defaultstate="collapsed" desc="Optional<Proyecto> proyectoConIgualPrefijo(String prefijo)">
    @Override
    public Optional<Proyecto> proyectoConIgualPrefijo(String prefijo) {
        Optional<Proyecto> result = Optional.empty();
        try {
            Integer page = 0;
            Integer size = 0;
            Bson filter = and(
                    eq("prefijo", prefijo)
            );

            Document sort = new Document("idproyecto", 1);
            List<Proyecto> list = lookup(filter, sort, page, size);
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
    // <editor-fold defaultstate="collapsed" desc="Boolean isValidProyecto(Proyecto proyecto,String[] diasLaborableSelected, JmoordbResourcesFiles rf)">
    @Override
    public Boolean isValidProyecto(Proyecto proyecto, List<DepartamentView> departamentViewList, List<Area> areaList, List<UserView> userViewPropietarioSelectedList, JmoordbResourcesFiles rf) {
        Boolean result = Boolean.FALSE;
        try {
            if (proyecto.getProyecto() == null || proyecto.getProyecto().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.nombreproyecto"));
                return result;
            }
            if (proyecto.getPrefijo() == null || proyecto.getPrefijo().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.prefijoproyecto"));
                return result;
            }
            if (proyecto.getDescripcion() == null || proyecto.getDescripcion().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.descripcion"));
                return result;
            }
            if (proyecto.getIcono() == null || proyecto.getIcono().equals("")) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.iconoproyecto"));
                return result;
            }
            if (proyecto.getFechainicial() == null || proyecto.getFechainicial().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechainicial"));
                return result;
            }
            if (proyecto.getFechafinal() == null || proyecto.getFechafinal().equals("")) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresefechafinal"));
                return result;
            }
            if (JmoordbCoreDateUtil.fechaMayor(proyecto.getFechainicial(), proyecto.getFechafinal())) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.fechainicialmayorfechafinal"));
                return result;
            }
            if (proyecto.getGrupoTipoTarjeta() == null || proyecto.getGrupoTipoTarjeta().isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.indiqueelgrupotipotarjeta"));
                return result;

            }
if (proyecto.getDiasAlertaVencimiento()== null || proyecto.getDiasAlertaVencimiento() <0) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.ingresediasalertavencimiento"));
                return result;
            }
            if (departamentViewList == null || departamentViewList.isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.departamentoproyecto"));
                return result;
            }

            if (areaList == null || areaList.isEmpty()) {

                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.areaproyecto"));
                return result;
            }
            if (userViewPropietarioSelectedList == null || userViewPropietarioSelectedList.isEmpty()) {
                FacesUtil.warningDialog(rf.fromCore("warning.warning"), rf.fromMessage("warning.propietarioproyecto"));
                return result;
            }

            result = Boolean.TRUE;
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DiasLaborable procesarDias(String[] diasLaborableSelected, JmoordbResourcesFiles rf) ">
//
//    @Override
//    
//    public DiasLaborable procesarDiasLaborable(String[] diasLaborableSelected, JmoordbResourcesFiles rf) {
//        DiasLaborable diasLaborable = new DiasLaborable(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
//        try {
//             
//
//            for (String s : diasLaborableSelected) {
//                if (s.equals(rf.fromMessage("field.lunes"))) {
//                    diasLaborable.setLunes(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.martes"))) {
//                    diasLaborable.setMartes(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.miercoles"))) {
//                    diasLaborable.setMiercoles(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.jueves"))) {
//                    diasLaborable.setJueves(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.viernes"))) {
//                    diasLaborable.setViernes(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.sabado"))) {
//                    diasLaborable.setSabado(Boolean.TRUE);
//                }
//                if (s.equals(rf.fromMessage("field.domingo"))) {
//                    diasLaborable.setDomingo(Boolean.TRUE);
//                }
//            }
//
//       } catch (Exception e) {
//            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
//        }
//        return diasLaborable;
//    }
//    
//    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean isPropietarioDelProyecto(Proyecto proyecto, User userLogged)">
    public Boolean isPropietarioDelProyecto(Proyecto proyecto, User userLogged) {
        Boolean result = Boolean.FALSE;
        try {
            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    if (pm.getPropietario()) {
                        result = Boolean.TRUE;
                        break;
                    }

                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isMiembroDelProyecto(Proyecto proyecto, User userLogged)">
    public Boolean isMiembroDelProyecto(Proyecto proyecto, User userLogged) {
        Boolean result = Boolean.FALSE;
        try {
            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    if (!pm.getPropietario()) {
                        result = Boolean.TRUE;
                        break;
                    }

                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String colorProyecto(Proyecto proyecto, Boolean foraneo)">
    @Override
    public String colorProyecto(Proyecto proyecto, Boolean foraneo) {
        String color = "surface-card";
        try {
            if(proyecto.getEstado().equals("detenido")){
                color="bg-pink-900";
            }else{
                 if (foraneo) {
                color = "bg-indigo-900";
            } else {
                if (!proyecto.getPrivado()) {
                    color = "bg-purple-900";
                }
            }
            }
           

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return color;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long countLikeByProyecto( String proyecto)">
    @Override
    public Long countLikeByProyecto(String proyecto) {
        Long result = 0L;
        try {
//            result = tarjetaRestClient.countLikeByTarjeta(tarjeta);

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Proyecto> likeByProyecto(String proyecto)">
    @Override
    public List<Proyecto> likeByProyecto(String proyecto) {
        return proyectoRestClient.likeByProyecto(proyecto);
    }
// </editor-fold>
}
