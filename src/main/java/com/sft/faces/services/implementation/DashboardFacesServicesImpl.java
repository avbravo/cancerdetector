/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.faces.services.implementation;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.faces.services.DashboardFacesServices;
import com.sft.model.UserView;
import com.sft.model.domain.UserViewDomain;
import com.sft.services.UserViewServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class DashboardFacesServicesImpl implements DashboardFacesServices{
    // <editor-fold defaultstate="collapsed" desc=" @Inject">
    @Inject
    UserViewServices userViewServices;
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="List<UserView> loadUserViewComoPropietarioNewOrEdit(String query, List<UserView> userViewList)">
   
    @Override
    public List<UserView> loadUserViewHowPropietarioNewOrEdit(String query, List<UserView> userViewList) {
      List<UserView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

           var userViewListVar = userViewServices.likeByName(query);
            if (userViewList.isEmpty()) {

                return userViewListVar;
            } else {

                for (UserView uvDB : userViewListVar) {
                    found = Boolean.FALSE;
                    for (UserView uv : userViewList) {
                        if (uvDB.getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }
                    /**
                     * Busca para ver si esta como colaborador
                     */
                    for (UserView uv : userViewList) {
                        if (uvDB.getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }

                    if (!found) {
                        result.add(uvDB);
                    }
                }

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
     // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<UserView> loadUserViewHowColaboradoresNewOrEdit(String query, List<UserView> userViewListx">
     public List<UserView> loadUserViewHowColaboradoresNewOrEdit(String query, List<UserView> userViewList){
       List<UserView> result = new ArrayList<>();

        Boolean found = Boolean.FALSE;
        try {

          var userViewListVar = userViewServices.likeByName(query);
            if (userViewList.isEmpty()) {

                return userViewListVar;
            } else {

                for (UserView uvDB : userViewListVar) {
                    found = Boolean.FALSE;
                    /**
                     * Busca en colaborador
                     */
                    for (UserView uv : userViewList) {
                        if (uvDB.getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }
                    /**
                     * Busca en propietario
                     */
                    for (UserView uv : userViewList) {
                        if (uvDB.getIduser().equals(uv.getIduser())) {
                            found = Boolean.TRUE;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(uvDB);
                    }
                }

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;    
     }
    // </editor-fold>
     
     
   

}
