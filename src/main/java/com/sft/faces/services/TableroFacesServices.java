/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sft.faces.services;

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.avbravo.jmoordbutils.JmoordbCoreContext;
import com.avbravo.jmoordbutils.JmoordbResourcesFiles;
import com.sft.model.Archivo;
import com.sft.model.Comentario;
import com.sft.model.Etiqueta;
import com.sft.model.Impedimento;
import com.sft.model.PlantillaTarjeta;
import com.sft.model.Proyecto;
import com.sft.model.ProyectoMiembro;
import com.sft.model.Sprint;
import com.sft.model.Tarea;
import com.sft.model.Tarjeta;
import com.sft.model.User;
import com.sft.model.UserView;
import com.sft.model.domain.UserViewDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ReorderEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author avbravo
 */
public interface TableroFacesServices {

    // <editor-fold defaultstate="collapsed" desc="void onRowCancelTarea(RowEditEvent<Tarea> event)">
    public default void onRowCancelTarea(RowEditEvent<Tarea> event) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowCancelArchivo(RowEditEvent<Archivo> event)">
    public default void onRowCancelArchivo(RowEditEvent<Archivo> event) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowCancelComentario(RowEditEvent<Comentario> event)">
    public default void onRowCancelComentario(RowEditEvent<Comentario> event) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowCancelImpedimento(RowEditEvent<Impedimento> event)">
    public default void onRowCancelImpedimento(RowEditEvent<Impedimento> event) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="void onRowCancelEtiqueta(RowEditEvent<Etiqueta> event)">
    public default void onRowCancelEtiqueta(RowEditEvent<Etiqueta> event) {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BarChartModel createBarModel(Long totalTarjetasPendiente, Long totalTarjetasProgreso, Long totalTarjetasFinalizado ,JmoordbResourcesFiles rf)">
    public default BarChartModel createBarModel(Long totalTarjetasPendiente, Long totalTarjetasProgreso, Long totalTarjetasFinalizado, JmoordbResourcesFiles rf) {
        BarChartModel barModelTarjetas = new BarChartModel();
        try {

            ChartData data = new ChartData();

            BarChartDataSet barDataSet = new BarChartDataSet();
            barDataSet.setLabel(rf.fromMessage("barratitle.tarjetas"));

            List<Object> values = new ArrayList<>();

            values.add(totalTarjetasPendiente);
            values.add(totalTarjetasProgreso);
            values.add(totalTarjetasFinalizado);

            barDataSet.setData(values);

            List<String> bgColor = new ArrayList<>();
            bgColor.add("rgba(255, 99, 132, 0.2)");
            bgColor.add("rgba(255, 159, 64, 0.2)");

            bgColor.add("rgba(54, 162, 235, 0.2)");
            barDataSet.setBackgroundColor(bgColor);

            List<String> borderColor = new ArrayList<>();
            borderColor.add("rgb(255, 99, 132)");
            borderColor.add("rgb(255, 159, 64)");
            borderColor.add("rgb(255, 205, 86)");

            barDataSet.setBorderColor(borderColor);
            barDataSet.setBorderWidth(1);

            data.addChartDataSet(barDataSet);

            List<String> labels = new ArrayList<>();
            labels.add(rf.fromMessage("barralabel.pendiente"));
            labels.add(rf.fromMessage("barralabel.progreso"));
            labels.add(rf.fromMessage("barralabel.finalizado"));

            data.setLabels(labels);
            barModelTarjetas.setData(data);

            //Options
            BarChartOptions options = new BarChartOptions();
            CartesianScales cScales = new CartesianScales();
            CartesianLinearAxes linearAxes = new CartesianLinearAxes();
            linearAxes.setOffset(true);
            linearAxes.setBeginAtZero(true);
            CartesianLinearTicks ticks = new CartesianLinearTicks();
            linearAxes.setTicks(ticks);
            cScales.addYAxesData(linearAxes);
            options.setScales(cScales);

            Title title = new Title();
            title.setDisplay(true);
            title.setText(rf.fromMessage("barratitle.estado"));
            options.setTitle(title);

            Legend legend = new Legend();
            legend.setDisplay(true);
            legend.setPosition("top");
            LegendLabel legendLabels = new LegendLabel();
            legendLabels.setFontStyle("italic");
            legendLabels.setFontColor("#2980B9");
            legendLabels.setFontSize(24);
            legend.setLabels(legendLabels);
            options.setLegend(legend);

            // disable animation
            Animation animation = new Animation();
            animation.setDuration(0);
            options.setAnimation(animation);

            barModelTarjetas.setOptions(options);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return barModelTarjetas;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String goScheduleAction(Proyecto proyecto, Sprint sprint)">
    public default String goScheduleAction(Proyecto proyecto, Sprint sprint) {
        try {

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyecto);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprint);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "scheduletablero.xhtml";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String goTimeLineAction(Proyecto proyecto, Sprint sprint)">

    public default String goTimeLineAction(Proyecto proyecto, Sprint sprint) {
        try {

            JmoordbCoreContext.put("DashboardFaces.proyectoSelected", proyecto);
            JmoordbCoreContext.put("DashboardFaces.sprintSelected", sprint);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "timelinetablero.xhtml";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="void ajaxDeleteEventDatatable(String message, String widgetDataTable)">
    public default void ajaxDeleteEventDatatable(String message, String widgetDataTable) {
        try {
            FacesUtil.successMessage(message);

            PrimeFaces.current().ajax().update("form:growl");

            PrimeFaces.current().ajax().update(widgetDataTable);
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Optional<Etiqueta> eqiquetaFindFirst(List<Etiqueta> etiquetaList, String search)">
    public default Optional<Etiqueta> eqiquetaFindFirst(List<Etiqueta> etiquetaList, String search) {
        try {
            return etiquetaList.stream().filter(x -> x.getEtiqueta().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<Archivo> archivoFindFirst(List<Archivo> archivoList, String search)">

    public default Optional<Archivo> archivoFindFirst(List<Archivo> archivoList, String search) {
        try {
            return archivoList.stream().filter(x -> x.getPath().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Optional<Comentario> comentarioFindFirst(List<Comentario> comentarioList, String search) ">

    public default Optional<Comentario> comentarioFindFirst(List<Comentario> comentarioList, String search) {
        try {
            return comentarioList.stream().filter(x -> x.getComentario().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Optional<Tarea> tareaFindFirst(List<Tarea> tareaList, String search) ">

    public default Optional<Tarea> tareaFindFirst(List<Tarea> tareaList, String search) {
        try {
            return tareaList.stream().filter(x -> x.getTarea().equals(search)).findFirst();

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return Optional.empty();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<UserViewDomain> loadUserForCreateTarjeta(Proyecto proyecto, User userLogged)">
    public default List<UserViewDomain> loadUserForCreateTarjeta(Proyecto proyecto, User userLogged) {
        List<UserViewDomain> userViewDomainForCreateList = new ArrayList<>();
        try {

            Boolean found = Boolean.FALSE;
            for (ProyectoMiembro pm : proyecto.getProyectoMiembro()) {
                found = Boolean.FALSE;

                if (pm.getUserView().getIduser().equals(userLogged.getIduser())) {
                    found = Boolean.TRUE;
                }
                UserViewDomain userViewDomain = new UserViewDomain(found, pm.getUserView());

                userViewDomainForCreateList.add(userViewDomain);
            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return userViewDomainForCreateList;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean esMiembroDeTarjeta(Tarjeta tarjeta, User user)">
    /**
     *
     * @param tarjeta
     * @param user
     * @return True si encuentra el usuario en la tarjeta
     */
    public default Boolean esMiembroDeTarjeta(Tarjeta tarjeta, User user, Boolean isPropietario, Boolean isProyectoForaneo) {
        var result = Boolean.FALSE;
        try {

            if (isProyectoForaneo) {
                return result;
            }
            if (isPropietario) {
                return Boolean.TRUE;
            }
            if (tarjeta.getUserView() == null || tarjeta.getUserView().isEmpty()) {

            } else {

                for (UserView u : tarjeta.getUserView()) {

                    if (user.getIduser().equals(u.getIduser())) {
                        result = Boolean.TRUE;
                        break;
                    }
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean puedeVerDetallesTarjeta(Tarjeta tarjeta, User user)">

    /**
     *
     * @param tarjeta
     * @param user
     * @return True si encuentra el usuario en la tarjeta
     */
    public default Boolean puedeVerDetallesTarjeta(Tarjeta tarjeta, User user, Boolean isPropietario, Boolean isProyectoForaneo, List<UserView> userViewForWebSocketList) {
        var result = Boolean.FALSE;
        try {

            if (isProyectoForaneo) {
                return result;
            }
            if (isPropietario) {
                return Boolean.TRUE;
            }

            if (tarjeta.getUserView() == null || tarjeta.getUserView().isEmpty()) {

            } else {

                for (UserView u : userViewForWebSocketList) {

                    if (user.getIduser().equals(u.getIduser())) {
                        result = Boolean.TRUE;
                        break;
                    }
                }

            }

        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean Boolean esMiembroDeTarjetaComentarioArchivo(Tarjeta tarjeta, User user, Boolean  isPropietario, Boolean isProyectoForaneo)">

    /**
     *
     * @param tarjeta
     * @param user
     * @return True si encuentra el usuario en la tarjeta
     */
    public default Boolean esMiembroDeTarjetaComentarioArchivo(Tarjeta tarjeta, User user, Boolean isPropietario, Boolean isProyectoForaneo) {
        var result = Boolean.FALSE;
        try {

            if (isPropietario) {
                return Boolean.TRUE;
            }
            if (tarjeta.getUserView() == null || tarjeta.getUserView().isEmpty()) {

            } else {

                for (UserView u : tarjeta.getUserView()) {

                    if (user.getIduser().equals(u.getIduser())) {
                        result = Boolean.TRUE;
                        break;
                    }
                }

            }
            if (isProyectoForaneo && result) {
                return result;
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> completeTarjeta(String query, List<Tarjeta> tarjetaPendienteList,  List<Tarjeta> tarjetaProgresoList, List<Tarjeta> tarjetaFinalizadoList)">
    public default List<Tarjeta> completeTarjeta(String query, List<Tarjeta> tarjetaPendienteList, List<Tarjeta> tarjetaProgresoList, List<Tarjeta> tarjetaFinalizadoList) {

        List<Tarjeta> result = new ArrayList<>();
        var findText = query.toLowerCase();
        try {
            query = query.trim();
            if (query == null || query.isBlank() || query.isEmpty()) {
                if (tarjetaPendienteList == null || tarjetaPendienteList.isEmpty()) {

                } else {
                    result.addAll(tarjetaPendienteList);
                }
                if (tarjetaProgresoList == null || tarjetaProgresoList.isEmpty()) {

                } else {
                    result.addAll(tarjetaProgresoList);
                }
                if (tarjetaFinalizadoList == null || tarjetaFinalizadoList.isEmpty()) {

                } else {
                    result.addAll(tarjetaFinalizadoList);
                }

            } else {

                List<Tarjeta> resultPendiente = new ArrayList<>();
                List<Tarjeta> resultProgreso = new ArrayList<>();
                List<Tarjeta> resultFinalizado = new ArrayList<>();
                if (tarjetaPendienteList == null || tarjetaPendienteList.isEmpty()) {

                } else {
                    resultPendiente = tarjetaPendienteList.stream()
                            .filter(line -> line.getTarjeta().toLowerCase().contains(findText))
                            .collect(Collectors.toList());
                }

                if (tarjetaProgresoList == null || tarjetaProgresoList.isEmpty()) {

                } else {
                    resultProgreso = tarjetaProgresoList.stream()
                            .filter(line -> line.getTarjeta().toLowerCase().contains(findText))
                            .collect(Collectors.toList());

                }
                if (tarjetaFinalizadoList == null || tarjetaFinalizadoList.isEmpty()) {

                } else {
                    resultFinalizado = tarjetaProgresoList.stream() // convert list to stream
                            .filter(line -> line.getTarjeta().toLowerCase().contains(findText)) // we dont like mkyong
                            .collect(Collectors.toList());
                }
                result.addAll(resultPendiente);
                result.addAll(resultProgreso);
                result.addAll(resultFinalizado);

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> filterTarjeta(String query, List<Tarjeta> list)">

    public default List<Tarjeta> filterTarjeta(String query, List<Tarjeta> list) {

        List<Tarjeta> result = new ArrayList<>();
        var findText = query.toLowerCase();
        try {
            query = query.trim();
            if (query == null || query.isBlank() || query.isEmpty()) {
                if (list == null || list.isEmpty()) {

                } else {
                    result.addAll(list);
                }

            } else {

                List<Tarjeta> resultPendiente = new ArrayList<>();

                if (list == null || list.isEmpty()) {

                } else {
                    resultPendiente = list.stream()
                            .filter(line -> line.getTarjeta().toLowerCase().contains(findText))
                            .collect(Collectors.toList());
                }

                result.addAll(resultPendiente);

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> filterPlantillaTarjeta(String query, List<PlantillaTarjeta> list)">

    public default List<PlantillaTarjeta> filterPlantillaTarjeta(String query, List<PlantillaTarjeta> list) {

        List<PlantillaTarjeta> result = new ArrayList<>();
        var findText = query.toLowerCase();
        try {
            query = query.trim();
            if (query == null || query.isBlank() || query.isEmpty()) {
                if (list == null || list.isEmpty()) {

                } else {
                    result.addAll(list);
                }

            } else {

                List<PlantillaTarjeta> resultPendiente = new ArrayList<>();

                if (list == null || list.isEmpty()) {

                } else {
                    resultPendiente = list.stream()
                            .filter(line -> line.getPlantilla().toLowerCase().contains(findText))
                            .collect(Collectors.toList());
                }

                result.addAll(resultPendiente);

            }

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Integer  viewCantidadArchivo(Tarjeta tarjeta)">
    public default Integer viewCantidadArchivo(Tarjeta tarjeta) {
        Integer result = 0;
        try {
            for (Archivo a : tarjeta.getArchivo()) {
                if (a.getActive()) {
                    result++;
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Integer  diasPendientes(Tarjeta tarjeta) ">
    public default Integer diasPendientes(Tarjeta tarjeta) {
        Integer result = 0;
        try {
//            result = DateUtil.diasEntreFechas(DateUtil.fechaActual(), tarjeta.getFechafinal());
            result = DateUtil.diasEntreFechas(tarjeta.getFechafinal(), DateUtil.fechaActual());
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
// </editor-fold>

    public void onRowReorderTarea(ReorderEvent event);

    public void onRowReorderComentario(ReorderEvent event);

    public void onRowReorderImpedimento(ReorderEvent event);

    public void onRowReorderEtiqueta(ReorderEvent event);

    public void onRowReorderArchivo(ReorderEvent event);

    // <editor-fold defaultstate="collapsed" desc="String visualizarIcono()">
    public default String visualizarIcono() {
        try {

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String visualizarColumna()">
    public default String visualizarColumna() {
        try {

        } catch (Exception e) {

            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    public String refreshCache(Tarjeta tarjeta, String command);

    void closeAddComentario(Tarjeta tarjeta);

    public void closeAddEtiqueta(Tarjeta tarjeta);

    public void closeAddArchivo(Tarjeta tarjeta);

    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> restablecerDesdeOld(List<Tarjeta> tarjetasOld)">
    public default List<Tarjeta> restablecerDesdeOld(List<Tarjeta> tarjetasOld) {

        List<Tarjeta> result = new ArrayList<>();
        try {
            if (tarjetasOld == null || tarjetasOld.isEmpty()) {
            } else {
                for (Tarjeta t : tarjetasOld) {
                    result.add(t);
                }
            }
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
     public void handleCloseDialogRefresh(CloseEvent event);
    public void handleCloseDialogComentario(CloseEvent event);
    public void handleCloseDialogTarea(CloseEvent event);
    public void handleCloseDialogImpedimento(CloseEvent event);
    public void handleCloseDialogEtiqueta(CloseEvent event);
    public void handleCloseDialogArchivo(CloseEvent event);
    public void handleCloseDialogColaborador(CloseEvent event);
    public void handleCloseDialogEditar(CloseEvent event);
   

   
}
