/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.services;

import com.sft.model.Central;
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
public interface CentralServices {

    public List<Central> findAll();

    public Optional<Central> findByIdcentral(
            @Parameter(description = "El idcentral", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idcentral") Long idcentral);

    // <editor-fold defaultstate="collapsed" desc="Central  findByCentral">
    public Central findByCentral(@Parameter(description = "El central", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("central") final String central);

    public Optional<Central> save(Central central);

    public Boolean update(Central central);

    public Boolean delete(Long idcentral);

    public List<Central> likeByCentral(@QueryParam("central") String central);

    public List<Central> lookup(Bson filter, Document sort, Integer page, Integer size);

    public Long count(Bson filter, Document sort, Integer page, Integer size);

    public Long countLikeByCentral(String central);

    public Boolean existsCentral(Central central);
   public Boolean existsCentralWithDiferentId(Central central); 
}
