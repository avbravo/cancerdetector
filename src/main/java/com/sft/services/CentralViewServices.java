/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.CentralView;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

/**
 *
 * @author avbravo
 */
public interface CentralViewServices {

    public List<CentralView> findAll();

    public Optional<CentralView> findByIdcentral(
            @Parameter(description = "El idcentral", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idcentral") Long idcentral);

    // <editor-fold defaultstate="collapsed" desc="CentralView findByCentral">
    public CentralView findByCentral(@Parameter(description = "El central", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("central") final String central);

    public Optional<CentralView> save(CentralView centralView);

    public Boolean update(CentralView centralView);

    public Boolean delete(Long idcentral);

    public List<CentralView> likeByCentral(@QueryParam("central") String central);



    public List<CentralView> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);

}
