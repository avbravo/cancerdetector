/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.websocket.fire;

import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreDateUtil;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.avbravo.jmoordbutils.websocket.MessageWebSocket;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface FacesWebSocket {

    public String refreshFromWebsocket();

    public String updateForRemoteWebsocket();

    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Tarjeta tarjeta, Boolean exclude, Boolean deleteEvent);

    public void sendMensajesWebsocket(MessageWebSocket messageWebSocket, Boolean exclude);

    public void onCompleteWebSocket();

    // <editor-fold defaultstate="collapsed" desc="List<UserView> filterUserViewListForWebSocket(List<UserView> userViewProjectoSelectedForWebSocketList, Tarjeta tarjeta,Boolean exclude, User... excludeUser)">
    /**
     *
     * @param userViewProjectoSelectedForWebSocketList
     * @param tarjeta
     * @return La lista de userView para ser usada en el envio de WebSocket.
     * Verifica si es una tarjeta foranea y agrega el usuario.
     */
    public default List<UserView> filterUserViewListForWebSocket(List<UserView> userViewProjectoSelectedForWebSocketList, Tarjeta tarjeta, Boolean exclude, User... excludeUser) {
        List<UserView> result = new ArrayList<>();
        List<UserView> resultSwag = new ArrayList<>();
        try {
            Long iduser = 0l;
            if (excludeUser.length != 0) {
                iduser = excludeUser[0].getIduser();

            }

            resultSwag.addAll(userViewProjectoSelectedForWebSocketList);
            /**
             * si es una tarjeta foranea agrega el usuario
             */
            if (tarjeta.getForeaneo()) {
                UserView uv = tarjeta.getUserView().get(0);

                Optional<UserView> userViewOptional = resultSwag.stream().filter(x -> x.getIduser().equals(uv.getIduser())).findFirst();
                if (!userViewOptional.isPresent()) {

                    resultSwag.add(uv);
                }
            }
            /**
             * Excluye al usuario indicado
             */
            if (exclude) {
                for (UserView uv : resultSwag) {
                    if (!iduser.equals(uv.getIduser())) {
                        result.add(uv);
                    }
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView> filterUserViewListForWebSocket(List<UserView> userViewProjectoSelectedForWebSocketList,Boolean exclude, User... excludeUser) {">
    public default List<UserView> filterUserViewListForWebSocket(List<UserView> userViewProjectoSelectedForWebSocketList, Boolean exclude, User... excludeUser) {
        List<UserView> result = new ArrayList<>();

        try {
            Long iduser = 0l;
            if (excludeUser.length != 0) {
                iduser = excludeUser[0].getIduser();

            }
            if (!exclude) {
                result.addAll(userViewProjectoSelectedForWebSocketList);
            } else {
                for (UserView uv : userViewProjectoSelectedForWebSocketList) {
                    if (!uv.getIduser().equals(iduser)) {
                        result.add(uv);
                    }
                }
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserView> userViewFromProjectExclude(Proyecto proyectoSelected, Boolean exclude, User... excludeUser)">
    /**
     *
     * @param proyectoSelected
     * @return Obtiene la lista de userView del proyecto
     */
    public default List<UserView> userViewFromProjectExclude(Proyecto proyectoSelected, Boolean exclude, User... excludeUser) {
        List<UserView> result = new ArrayList<>();
        try {
            Long iduser = 0l;
            if (excludeUser.length != 0) {
                iduser = excludeUser[0].getIduser();
                for (ProyectoMiembro pm : proyectoSelected.getProyectoMiembro()) {
                    if (exclude) {
                        if (iduser.equals(pm.getUserView().getIduser())) {
                        } else {
                            result.add(pm.getUserView());
                        }
                    } else {
                        result.add(pm.getUserView());
                    }

                }
            } else {
                proyectoSelected.getProyectoMiembro().forEach(pm -> {
                    result.add(pm.getUserView());
                });
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>   
    // <editor-fold defaultstate="collapsed" desc="List<UserView> userViewFromProjectExcludeIncludeOldUser(Proyecto proyectoSelected, List<ProyectoMiembro> proyectoMiembroOldList, Boolean exclude, User... excludeUser)">
    /**
     *
     * @param proyectoSelected
     * @return Obtiene la lista de userView del proyecto
     */
    public default List<UserView> userViewFromProjectExcludeIncludeOldUser(Proyecto proyectoSelected, List<ProyectoMiembro> proyectoMiembroOldList, Boolean exclude, User... excludeUser) {
        List<UserView> result = new ArrayList<>();
        try {
            List<ProyectoMiembro> proyectoMiembroList = new ArrayList<>();
            proyectoMiembroList.addAll(proyectoSelected.getProyectoMiembro());

            proyectoMiembroOldList.forEach(pm -> {
                Optional<ProyectoMiembro> proyectoMiembroOptional = proyectoSelected.getProyectoMiembro().stream().filter(x -> x.getUserView().getIduser().equals(pm.getUserView().getIduser())).findFirst();
                if (!proyectoMiembroOptional.isPresent()) {
                    proyectoMiembroList.add(pm);
                }
            });
            /*
             */

            Long iduser = 0l;
            if (excludeUser.length != 0) {
                iduser = excludeUser[0].getIduser();
                for (ProyectoMiembro pm : proyectoMiembroList) {
                    if (exclude) {
                        if (iduser.equals(pm.getUserView().getIduser())) {
                        } else {
                            result.add(pm.getUserView());
                        }
                    } else {
                        result.add(pm.getUserView());
                    }

                }
            } else {
                proyectoMiembroList.forEach(pm -> {
                    result.add(pm.getUserView());
                });
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }

    // </editor-fold>   
    // <editor-fold defaultstate="collapsed" desc="List<UserView> userViewForWebSocketListFromProjectOfTarjeta(Tarjeta tarjeta, List<Proyecto> proyectoPorColaboradorList, User userLogged)">
    public default List<UserView> userViewForWebSocketListFromProjectOfTarjeta(Tarjeta tarjeta, List<Proyecto> proyectoPorColaboradorList, User userLogged) {
        List<UserView> result = new ArrayList<>();
        try {
            Proyecto proyectoWebSocket = new Proyecto();
            Boolean found = Boolean.FALSE;
            for (Proyecto p : proyectoPorColaboradorList) {
                if (p.getIdproyecto().equals(tarjeta.getIdproyecto())) {
                    proyectoWebSocket = p;
                    found = Boolean.TRUE;
                    break;
                }
            }
            if (found) {
                result = userViewFromProjectExclude(proyectoWebSocket, Boolean.FALSE, userLogged);
            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="String validarEstadoIniciadoYFechaProyecto(Proyecto proyecto, JmoordbResourcesFiles rf)">   
    public default String validarEstadoIniciadoYFechaProyecto(Proyecto proyecto, JmoordbResourcesFiles rf) {
        String result = "";
        try {

//            if (!proyecto.getEstado().equals("iniciado")) {
//                result = rf.fromMessage("warning.proyectoestadonoiniciado");
//
//            }
          

            if ((JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechainicial())
                    || JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechainicial()))
                    && (JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechafinal())
                    || JmoordbCoreDateUtil.fechaMenor(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechafinal()))) {

            } else {
                result = rf.fromMessage("warning.fechasfuerarangoproyecto");

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="String validarEstadoIniciadoYFechaProyecto(Proyecto proyecto, JmoordbResourcesFiles rf, Boolean includeProyectoDetenido)">   
    public default String validarEstadoIniciadoYFechaProyecto(Proyecto proyecto, JmoordbResourcesFiles rf, Boolean includeProyectoDetenido) {
        String result = "";
        try {
            if (includeProyectoDetenido) {
                if (proyecto.getEstado().equals("iniciado") || proyecto.getEstado().equals("detenido")) {

                } else {
                    result = rf.fromMessage("warning.proyectoestadofinalizado");
                }
            } else {
                if (!proyecto.getEstado().equals("iniciado")) {
                    result = rf.fromMessage("warning.proyectoestadonoiniciado");

                }
            }

            if ((JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechainicial())
                    || JmoordbCoreDateUtil.fechaMayor(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechainicial()))
                    && (JmoordbCoreDateUtil.fechaIgual(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechafinal())
                    || JmoordbCoreDateUtil.fechaMenor(JmoordbCoreDateUtil.getFechaHoraActual(), proyecto.getFechafinal()))) {

            } else {
                result = rf.fromMessage("warning.fechasfuerarangoproyecto");

            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>    
    
   
}
