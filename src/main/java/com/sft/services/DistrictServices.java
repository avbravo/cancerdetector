/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.District;
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
public interface DistrictServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">   
    public List<District> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Optional<District> findByIddistrict(Long iddistrict)">
    public Optional<District> findByIddistrict(Long iddistrict);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="District findByDistrict(@Parameter(description = "El district ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("district") String district)">
    public District findByDistrict(@Parameter(description = "El district ", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("district") String district);

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<District> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    public List<District> lookup(Bson filter, Document sort, Integer page, Integer size);

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<District> save( District district ) ">
    public Optional<District> save(District district);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update(District district )>

    public Boolean update(District district);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete( Long iddistrict )">
    public Boolean delete(Long iddistrict);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size">
    public Long count(Bson filter, Document sort, Integer page, Integer size);
    // </editor-fold>

    public Long countLikeByDistrict(String district);

    // <editor-fold defaultstate="collapsed" desc="List<District> likeByDistrict( String district )">
    public List<District> likeByDistrict(String district);
    // </editor-fold>

    public Boolean existsDistrict(District district);

    public Boolean existsDistrictWithDiferentId(District district);
}
