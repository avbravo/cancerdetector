/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author avbravo
 */
@Entity
public class Especialista {

    @Id(strategy = GenerationType.AUTO)
    private Long idespecialista;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String cellphone;
    @Column
    private String sex;
    @Column
    private String photo;
    @Column
    private String active;
    @Column
    private String identificationcard;
    @Column
    private String socialsecuritynumber;
    @Column
    private String centromedico;
    @Column
    private String theme;
    @Column
    private Boolean recibirNotificacion;

    public Especialista() {
    }

    public Especialista(Long idespecialista, String username, String password, String name, String email, String cellphone, String sex, String photo, String active, String identificationcard, String socialsecuritynumber, String centromedico, String theme, Boolean recibirNotificacion) {
        this.idespecialista = idespecialista;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.sex = sex;
        this.photo = photo;
        this.active = active;
        this.identificationcard = identificationcard;
        this.socialsecuritynumber = socialsecuritynumber;
        this.centromedico = centromedico;
        this.theme = theme;
        this.recibirNotificacion = recibirNotificacion;
    }

    public Long getIdespecialista() {
        return idespecialista;
    }

    public void setIdespecialista(Long idespecialista) {
        this.idespecialista = idespecialista;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIdentificationcard() {
        return identificationcard;
    }

    public void setIdentificationcard(String identificationcard) {
        this.identificationcard = identificationcard;
    }

    public String getSocialsecuritynumber() {
        return socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public String getCentromedico() {
        return centromedico;
    }

    public void setCentromedico(String centromedico) {
        this.centromedico = centromedico;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Boolean getRecibirNotificacion() {
        return recibirNotificacion;
    }

    public void setRecibirNotificacion(Boolean recibirNotificacion) {
        this.recibirNotificacion = recibirNotificacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idespecialista);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.cellphone);
        hash = 59 * hash + Objects.hashCode(this.sex);
        hash = 59 * hash + Objects.hashCode(this.photo);
        hash = 59 * hash + Objects.hashCode(this.active);
        hash = 59 * hash + Objects.hashCode(this.identificationcard);
        hash = 59 * hash + Objects.hashCode(this.socialsecuritynumber);
        hash = 59 * hash + Objects.hashCode(this.centromedico);
        hash = 59 * hash + Objects.hashCode(this.theme);
        hash = 59 * hash + Objects.hashCode(this.recibirNotificacion);
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
        final Especialista other = (Especialista) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.cellphone, other.cellphone)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        if (!Objects.equals(this.identificationcard, other.identificationcard)) {
            return false;
        }
        if (!Objects.equals(this.socialsecuritynumber, other.socialsecuritynumber)) {
            return false;
        }
        if (!Objects.equals(this.centromedico, other.centromedico)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        if (!Objects.equals(this.idespecialista, other.idespecialista)) {
            return false;
        }
        return Objects.equals(this.recibirNotificacion, other.recibirNotificacion);
    }

    @Override
    public String toString() {
        return "Especialista{" + "idespecialista=" + idespecialista + ", username=" + username + ", password=" + password + ", name=" + name + ", email=" + email + ", cellphone=" + cellphone + ", sex=" + sex + ", photo=" + photo + ", active=" + active + ", identificationcard=" + identificationcard + ", socialsecuritynumber=" + socialsecuritynumber + ", centromedico=" + centromedico + ", theme=" + theme + ", recibirNotificacion=" + recibirNotificacion + '}';
    }
   

    
    

}
