/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.jmoordb.core.annotation.date.DateFormat;
import com.sft.model.Proyecto;
import com.sft.model.Sprint;
import com.sft.model.Tarjeta;
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
public interface SprintServices {
    
    public List<Sprint> openSprintList(Proyecto proyecto);
    public Boolean haveOpenSprint(Proyecto proyecto);
    public Boolean haveOpenSprintAndDateIsLessOrEquals(Proyecto proyecto);
    public Boolean isOpenSprintBetweenDateNow(Sprint sprint);
    public Optional<Sprint> sprintOpenAndDateNowIsLessOrEquals(Proyecto proyecto);
    public Optional<Sprint> save(Sprint sprint);
  
    public Boolean update(Sprint sprint);
   
     public Optional<Sprint> findByIdsprint(Long idsprint);
    
    public List<Sprint> lookup( Bson filter, Document sort, Integer page, Integer size);
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    
    public Long totalSprintOpen(Proyecto proyecto, Boolean open);
    
    public Long generateNumberForSprint(Proyecto proyecto);
    
    public Boolean existsBySprintAndProject(Proyecto proyecto, Sprint sprint);
    
    Boolean exitsBetweenDates(Proyecto proyecto,  Date fechaInicial, Date fechaFinal);
    Boolean exitsBetweenDatesExcludeSprint(Proyecto proyecto,  Date fechaInicial, Date fechaFinal, Sprint sprint);
    
     public List<Sprint> findByFechaGreaterThanEqualAndFechaLessThanEqual(@QueryParam("fechainicial") @DateFormat("dd-MM-yyyy") final Date fechainicial, @QueryParam("fechafinal") @DateFormat("dd-MM-yyyy") final Date fechafinal);
}
