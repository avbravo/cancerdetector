/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.sft.model.UserView;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface DashboardFacesServices {

    public List<UserView> loadUserViewHowPropietarioNewOrEdit(String query, List<UserView> userViewList);
    public List<UserView> loadUserViewHowColaboradoresNewOrEdit(String query, List<UserView> userViewList);
}
