/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.jmoordb.core.annotation.date.DateFormat;
import com.sft.model.Area;
import com.sft.model.DepartamentView;
import com.sft.model.Proyecto;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.ProyectoEstadistica;
import com.sft.model.domain.ProyectoSprintOpen;
import jakarta.ws.rs.QueryParam;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface ProyectoServices {

    public List<Proyecto> lookup(User user);

    public List<Proyecto> lookup(Bson filter, Document sort, Integer page, Integer size);
    
    public List<ProyectoSprintOpen>  proyectoConSprintAbierto(Bson filter, Document sort, Integer page, Integer size);

    Long count(Bson filter, Document sort, Integer page, Integer size);

    public Optional<Proyecto> findByIdproyecto(Long idproyecto);


    public List<ProyectoSprintOpen> cargarProyectosPrivadosConSprintAbierto(User user);


    public List<ProyectoSprintOpen> cargarProyectosPublicosNoAsignadosConSprintAbierto(User user);

    public List<ProyectoEstadistica> cargarProyectoEstadistica(List<Proyecto> proyectoList);
    
    public List<ProyectoEstadistica> cargarProyectoEstadisticaSprintOpen(List<ProyectoSprintOpen> proyectoSprintOpenList);


    public ProyectoEstadistica calcularEstadistica(Proyecto proyecto);

    public Optional<Proyecto> save(Proyecto proyecto);

    public Boolean update(Proyecto proyecto);

    public List<Proyecto> findByFechaGreaterThanEqualAndFechaLessThanEqual(@QueryParam("fechainicial") @DateFormat("dd-MM-yyyy") final Date fechainicial, @QueryParam("fechafinal") @DateFormat("dd-MM-yyyy") final Date fechafinal);

    public Boolean isColaborador(Proyecto proyecto, Long iduser);

    public Boolean isPropietario(Proyecto proyecto, Long iduser);

    public List<UserView> generateUserViewPropietarioList(Proyecto proyecto, List<UserView> userViewList);

    public List<UserView> generateUserViewColaboradorList(Proyecto proyecto, List<UserView> userViewList);

    public Boolean nombreProyectoExiste(String proyectoName);

    public Optional<Proyecto> proyectoConIgualNombre(String proyectoName);

    public Optional<Proyecto> proyectoConIgualPrefijo(String prefijo);

    public Boolean prefijoExiste(String prefijo);

    public String sugerirPrefijo(Proyecto proyecto);

    public String genererNumeroPrefijo(Proyecto proyecto, JmoordbResourcesFiles rf);

    public Boolean isValidProyecto(Proyecto proyecto, List<DepartamentView> departamentViewList, List<Area> areaList, List<UserView> userViewPropietarioSelectedList, JmoordbResourcesFiles rf);

//    public DiasLaborable procesarDiasLaborable(String[] diasLaborableSelected, JmoordbResourcesFiles rf);

    public Boolean isPropietarioDelProyecto(Proyecto proyecto, User userLogged);

    public Boolean isMiembroDelProyecto(Proyecto proyecto, User userLogged);
    public String colorProyecto(Proyecto proyecto, Boolean foraneo);
    
    public Long countLikeByProyecto(String proyecto);

    public List<Proyecto> likeByProyecto( String proyecto);
}
