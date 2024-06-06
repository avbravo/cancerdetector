/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Country;
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
public interface CountryServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<Country> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Country> findByIdcountry ">
    public Optional<Country> findByIdcountry(String idcountry);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Country findByCountry(@Parameter(description = "El country ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("country") String country)">
    public Country findByCountry(@Parameter(description = "El country ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("country") String country);

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Country> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    public List<Country> lookup(Bson filter, Document sort, Integer page, Integer size);

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<Country> save( Country country ) ">
    public Optional<Country> save(Country country );
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(Country country )>

    public Boolean update(Country country );
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long idcountry )">
    public Boolean delete(String idcountry );
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    // </editor-fold>

    public Long countLikeByCountry(String country);

    // <editor-fold defaultstate="collapsed" desc="List<Country> likeByCountry( String country )">
    public List<Country> likeByCountry(String country);
    // </editor-fold>

    public Boolean existsCountry(Country country);
}
