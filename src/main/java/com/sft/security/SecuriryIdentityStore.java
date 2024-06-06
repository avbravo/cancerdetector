/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.security;

import com.avbravo.jmoordbutils.ConsoleUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.sft.model.Profile;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author avbravo
 */
//@Named(value = "customInMemoryIdentityStore")
@Named()
@ApplicationScoped
public class SecuriryIdentityStore implements IdentityStore {

    private String roleForWebSecurity = " ";
    @Inject
    JmoordbResourcesFiles rf;

    @Override
    public CredentialValidationResult validate(Credential credential) {
      
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;

   
      

        String username = login.getCaller();
        String password = login.getPasswordAsString();

        if (!isValidData(username, password)) {

            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
        /**
         * Obtiene el rol que se obtuvo en el login
         */
        Profile profile = (Profile) JmoordbCoreContext.get("LoginFaces.profileLogged");
        if (profile == null || profile.getId() == null) {
       
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
        roleForWebSecurity = profile.getRole().getRole();

        return new CredentialValidationResult(username, new HashSet<>(Arrays.asList(roleForWebSecurity)));

    }
//

    // <editor-fold defaultstate="collapsed" desc="Boolean isValidData(String username, String password)">
    private Boolean isValidData(String username, String password) {
        try {
            if (username.isEmpty() || username.equals("") || username == null) {
                FacesUtil.warningMessage(rf.fromCore("warning.usernameisempty"));
                return false;
            }
            if (password.isEmpty() || password.equals("") || password == null) {
                FacesUtil.warningMessage(rf.fromCore("warning.passwordisempty"));
                return false;
            }
            return true;
        } catch (Exception e) {
         FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return false;
    }
    // </editor-fold>

}
