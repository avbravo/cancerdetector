/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.jmoordb.core.model.Pagination;
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
public interface TarjetaServices {
     public List<Tarjeta> findAll();
    public Optional<Tarjeta> save(Tarjeta tarjeta);

    public Boolean update(Tarjeta tarjeta);

    public Boolean deleteMany(Bson filter, Long idproyecto);

    public Optional<Tarjeta> findByIdtarjeta(Long idtarjeta, @QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> lookup(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyecto);

    public Boolean tarjetaExistInSprint(String tarjetaName, Long idproyecto, Long idsprint);

    public Boolean tarjetaExistInBacklog(String tarjetaName, Long idproyecto, Long idsprint);

    public Optional<Tarjeta> tarjetaConIgualNombreInSprint(String tarjetaName, Long idproyecto, Long idsprint);

    public Long count(Bson filter, Document sort, Integer page, Integer size, @QueryParam("idproyecto") Long idproyecto);

    public Long totalPorColumna(Proyecto proyecto, String columna, Boolean storeInBacklog);

    public List<Comentario> ordenarComentarioPorFechaDescendente(Tarjeta tarjeta);

    public List<Tarea> ordenarTareaPorCompletadoDescendente(Tarjeta tarjeta);
    public List<Tarea> ordenarTareaPorOrden(Tarjeta tarjeta);

    public List<Impedimento> ordenarImpedimentoDescendente(Tarjeta tarjeta);

    public Boolean isMiembroAutorizedInTarjetaForanea(Tarjeta tarjeta, User userLogged, UserView userViewForaneo);

    public Boolean equalsExcludedNameOfTarjeta(Tarjeta tarjeta, Tarjeta other);

    public Boolean isEstimacionValida(Tarjeta tarjeta);

    public String colorTarjeta(Tarjeta tarjeta);

    public Long countLikeByTarjeta(String tarjeta, @QueryParam("idproyecto") Long idproyecto);

    public Long countLikeByDescripcion(String descripcion, @QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> likeByTarjeta(String tarjeta, @QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> likeByTarjetaPagination(String tarjeta, Pagination pagination,@QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> likeByDescripcion(String descripcion,@QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal,@QueryParam("idproyecto") Long idproyecto);

    public List<Tarjeta> searchLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto);
    public Long searchCountLikeByTarjeta(String tarjeta, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto);
    
    public List<Tarjeta> searchLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto);
        public Long searchCountLikeByDescripcion(String descripcion, Bson filter, Document sort, Integer page, Integer size,@QueryParam("idproyecto") Long idproyecto);
    

    public List<Tarjeta> validarFechaFinalEsteSprintActual(List<Tarjeta> list, Sprint sprint);
    public List<Tarjeta> validarFechaFinalSprintPlanTrabajo(List<Tarjeta> list, Sprint sprint);
    
    public List<Tarjeta> orderListForIdTarjetaReserve(List<Tarjeta> list);
    
    public Integer positionOfTarjeta(Tarjeta tarjeta, List<Tarjeta> tarjetas);
    
    public TotalesTarjetasEstadistica calcularTotalesTarjetasEstadistica(Long iduser, List<ProyectoSprintOpen> proyectoSprintOpenList);
    
            
   
}
