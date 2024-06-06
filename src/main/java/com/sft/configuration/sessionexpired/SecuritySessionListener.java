/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sft.configuration.sessionexpired;

import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author avbravo
 */
public class SecuritySessionListener implements HttpSessionListener, Serializable {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("********************************************************************");
        System.out.println("Session created : " + se.getSession().getId() + " at " + new Date());
        System.out.println("********************************************************************");
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
    
        System.out.println("********************************************************************");
        System.out.println("session destroyed :" + session.getId() + " Logging out user... at  " + new Date());
        System.out.println("********************************************************************");
    }
}
