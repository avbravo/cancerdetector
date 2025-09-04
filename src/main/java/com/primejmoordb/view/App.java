/*
   Copyright 2009-2021 PrimeTek.

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.primejmoordb.view;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.sft.model.User;
import com.sft.services.UserServices;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.ProjectStage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.util.EscapeUtils;

import java.io.Serializable;

@Named
@SessionScoped
public class App implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="fields">
    private final boolean productionEnvironment = FacesContext.getCurrentInstance().isProjectStage(ProjectStage.Production);
   //   private String theme = "saga";
    private String theme = "vela";
//    private String theme = "arya";
    private boolean darkMode = false;
    private String inputStyle = "outlined";
    private User userLogged = new User();

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    UserServices userServices;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        try {

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
// </editor-fold>

    public void copyCode(String code) {
        PrimeFaces.current().executeScript("navigator.clipboard.writeText('" + EscapeUtils.forJavaScript(code) + "')");
    }

    public boolean isProductionEnvironment() {
        return productionEnvironment;
    }

    public String getInputStyleClass() {
        return this.inputStyle.equals("filled") ? "ui-input-filled" : "";
    }

    public String getInputStyle() {
        return inputStyle;
    }

    public void setInputStyle(String inputStyle) {
        this.inputStyle = inputStyle;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    // <editor-fold defaultstate="collapsed" desc="void changeTheme(String theme, boolean darkMode)">
    public void changeTheme(String theme, boolean darkMode) {

        try {
            this.theme = theme;
            this.darkMode = darkMode;
          

            if (JmoordbCoreContext.get("LoginFaces.userLogged") != null) {
                userLogged = (User) JmoordbCoreContext.get("LoginFaces.userLogged");
                userLogged.setTheme(theme);
             
                if(userServices.update(userLogged)){
                  
                }else{
               
                }
           
            } else {
              
            }

//            Optional<User> userOptional = userServices.findByUsername(username);
//            if (!userOptional.isPresent()) {
//                FacesUtil.warningMessage(rf.fromCore("login.usernamenotvalid"));
//                return "";
//
//            }
//            
//            userLogged = userOptional.get();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

    }
    // </editor-fold>
}
