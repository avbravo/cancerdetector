/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Embedded;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.ViewReferenced;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Organigram {
   @Id(strategy = GenerationType.AUTO)
   private Long idorganigram;

    @ViewReferenced(from = "departament", localField = "iddepartament")
    private DepartamentView departamentView;
    
    @Embedded
    List<OrganigramDepartament> organigramDepartament;

      @Column
    private Boolean active;
     @Embedded
    List<ActionHistory> actionHistory;
     
     
    public Organigram() {
    }

    public Organigram(Long idorganigram, DepartamentView departamentView, List<OrganigramDepartament> organigramDepartament, Boolean active, List<ActionHistory> actionHistory) {
        this.idorganigram = idorganigram;
        this.departamentView = departamentView;
        this.organigramDepartament = organigramDepartament;
        this.active = active;
        this.actionHistory = actionHistory;
    }

    public Long getIdorganigram() {
        return idorganigram;
    }

    public void setIdorganigram(Long idorganigram) {
        this.idorganigram = idorganigram;
    }

    public DepartamentView getDepartamentView() {
        return departamentView;
    }

    public void setDepartamentView(DepartamentView departamentView) {
        this.departamentView = departamentView;
    }

    public List<OrganigramDepartament> getOrganigramDepartament() {
        return organigramDepartament;
    }

    public void setOrganigramDepartament(List<OrganigramDepartament> organigramDepartament) {
        this.organigramDepartament = organigramDepartament;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ActionHistory> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(List<ActionHistory> actionHistory) {
        this.actionHistory = actionHistory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idorganigram);
        hash = 37 * hash + Objects.hashCode(this.departamentView);
        hash = 37 * hash + Objects.hashCode(this.organigramDepartament);
        hash = 37 * hash + Objects.hashCode(this.active);
        hash = 37 * hash + Objects.hashCode(this.actionHistory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organigram other = (Organigram) obj;
        if (!Objects.equals(this.idorganigram, other.idorganigram)) {
            return false;
        }
        if (!Objects.equals(this.departamentView, other.departamentView)) {
            return false;
        }
        if (!Objects.equals(this.organigramDepartament, other.organigramDepartament)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return Objects.equals(this.actionHistory, other.actionHistory);
    }

    @Override
    public String toString() {
        return "Organigram{" + "idorganigram=" + idorganigram + ", departamentView=" + departamentView + ", organigramDepartament=" + organigramDepartament + ", active=" + active + ", actionHistory=" + actionHistory + '}';
    }

    
   
   
   
}
