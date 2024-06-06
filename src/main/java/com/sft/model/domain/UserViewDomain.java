/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model.domain;

import com.jmoordb.core.annotation.Domain;
import com.sft.model.UserView;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Domain(commentary = "Se usa para administrar los usuarios de la tarjeta")
public class UserViewDomain {
    
    private Boolean selected;
    private UserView userView;

    public UserViewDomain() {
    }

    public UserViewDomain(Boolean selected, UserView userView) {
        this.selected = selected;
        this.userView = userView;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    @Override
    public String toString() {
        return "UserViewDomain{" + "selected=" + selected + ", userView=" + userView + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.selected);
        hash = 17 * hash + Objects.hashCode(this.userView);
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
        final UserViewDomain other = (UserViewDomain) obj;
        if (!Objects.equals(this.selected, other.selected)) {
            return false;
        }
        return Objects.equals(this.userView, other.userView);
    }
    
    
    
    
}
