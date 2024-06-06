/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.websocket.fire;

import com.avbravo.jmoordbutils.FacesUtil;
import com.sft.model.Proyecto;
import com.sft.model.User;
import com.sft.model.UserView;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author avbravo
 */
@ViewScoped
@Named
public class WebSocketController implements Serializable, WebSocketPlantilla {

    @Inject
    @Push
    private PushContext proyectoChannel;
    
    @Inject
    @Push
    private PushContext proyChannel;

    @Inject
    @Push
    private PushContext sprintChannel;

    @Inject
    @Push
    private PushContext tableroChannel;

    @Inject
    @Push
    private PushContext backlogChannel;
  
    @Inject
    @Push
    private PushContext panelTrabajoChannel;
    
    @Inject
    @Push
    private PushContext papeleraReciclajeChannel;

    @Inject
    @Push
    PushContext allChannel;

    /**
     *
     * @param message
     * @param user
     */
    @Override
    public void sendMessageProyecto(String message, User user) {
        proyectoChannel.send(message, user.getIduser());

    }

    /**
     * *
     * Envia mensaje a muchos usuarios
     *
     * @param message
     * @param userViewList
     */
    @Override
    public void sendMessageProyectoMultiple(String message, List<UserView> userViewList) {
        proyectoChannel.send(message, collectionOfUserList(userViewList));
    }
    
    /**
     *
     * @param message
     * @param user
     */
    @Override
    public void sendMessageSprint(String message, User user) {
        sprintChannel.send(message, user.getIduser());

    }

    /**
     * *
     * Envia mensaje a muchos usuarios
     *
     * @param message
     * @param userViewList
     */
    @Override
    public void sendMessageSprintMultiple(String message, List<UserView> userViewList) {

        sprintChannel.send(message, collectionOfUserList(userViewList));
    }

    /**
     *
     * @param message
     * @param user
     */
    @Override
    public void sendMessageTablero(String message, User user) {

        tableroChannel.send(message, user.getIduser());

    }

    /**
     * *
     * Envia mensaje a muchos usuarios
     *
     * @param message
     * @param userViewList
     */
    @Override
    public void sendMessageTableroMultiple(String message, List<UserView> userViewList) {

        tableroChannel.send(message, collectionOfUserList(userViewList));
    }

    @Override
    public void sendMessageAll(String message, String scoped) {
        allChannel.send(message, "user");
    }

   

    @Override
    public void sendMessageBacklog(String message, User user) {
    backlogChannel.send(message, user.getIduser());
    }

    @Override
    public void sendMessageBacklogMultiple(String message, List<UserView> userViewList) {
    backlogChannel.send(message, collectionOfUserList(userViewList));
    }

    @Override
    public void sendMessagePapeleraReciclaje(String message, User user) {
         papeleraReciclajeChannel.send(message, user.getIduser());
    }

    @Override
    public void sendMessagePapeleraReciclajeMultiple(String message, List<UserView> userViewList) {
     papeleraReciclajeChannel.send(message, collectionOfUserList(userViewList));
    }
    
    @Override
    public void sendMessagePanelTrabajo(String message, User user) {
         panelTrabajoChannel.send(message, user.getIduser());
    }

    @Override
    public void sendMessagePanelTrabajoMultiple(String message, List<UserView> userViewList) {
     panelTrabajoChannel.send(message, collectionOfUserList(userViewList));
    }

    
    
     @Override
    public Collection<Long> collectionOfUserList(List<UserView> userViewList) {
        Collection<Long> result = new ArrayList<>();
        try {
            userViewList.forEach(u -> {
                result.add(u.getIduser());
            });
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    
    public Collection<Long> collectionOfProyectoList(List<Proyecto> proyectoList) {
        Collection<Long> result = new ArrayList<>();
        try {
            proyectoList.forEach(u -> {
                result.add(u.getIdproyecto());
            });
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
}
