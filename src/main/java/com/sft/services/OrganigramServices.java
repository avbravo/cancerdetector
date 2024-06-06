/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.services;

import com.sft.model.Departament;
import com.sft.model.DepartamentView;
import com.sft.model.Organigram;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface OrganigramServices {

    // <editor-fold defaultstate="collapsed" desc="findAll">
    public List<Organigram> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Organigram> findByIdorganigram">
    public Optional<Organigram> findByIdorganigram(Long idorganigram);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Organigram> lookup(Bson filter, Document sort,  Integer page,  Integer size)">
    public List<Organigram> lookup(Bson filter, Document sort, Integer page, Integer size);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Organigram> save(Organigram organigram)">
    public Optional<Organigram> save(Organigram organigram);

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean update( Organigram organigram)">
    public Boolean update(Organigram organigram);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean delete(Long idorganigram)">
    public Boolean delete(Long idorganigram);
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Long count(Bson filter, Document sort,  Integer page,  Integer size)">
    public Long count(Bson filter, Document sort, Integer page, Integer size);

    // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Boolean existsDepartamentView(DepartamentView departamentView)">

        public Boolean existsDepartamentView(DepartamentView departamentView);
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Boolean existsDepartamentViewInEmbedded(DepartamentView departamentView)">

        public Boolean existsDepartamentViewInEmbedded(DepartamentView departamentView);
        // </editor-fold>
}
