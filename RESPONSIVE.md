rows="#{item.tarea.length() le 70?1:(item.tarea.length()/70)+1}"

```
 <p:column class="columnInputTextArea43" headerText="#{msg['field.tarea']}" >


                            <p:cellEditor >
                                <f:facet name="output">
                                  <p:inputTextarea  rows="#{item.tarea.length() le 70?1:(item.tarea.length()/70)+1}" style="width: 100% !important; float:left;text-decoration: line-through" autoResize="false" readonly="true" value="#{item.tarea}"  rendered="#{item.completado eq true}"/>
                                  <p:inputTextarea  rows="#{item.tarea.length() le 70?1:(item.tarea.length()/70)+1}" style="width: 100% !important;" autoResize="false" readonly="true" value="#{item.tarea}" rendered="#{item.completado eq false}" />

                                </f:facet>
                                <f:facet name="input" >
                                     <p:inputTextarea  rows="#{item.tarea.length() le 70?1:(item.tarea.length()/70)+1}" style="width: 100% !important;" autoResize="false"  value="#{item.tarea}"  />
                                </f:facet>
                            </p:cellEditor>

                        </p:column>

```



()paneltrabajo
()papelerareciclaje
---
+ <p:dialog
 width="50vw" 
                  responsive="true"
                  showEffect="fade" 
                  modal="true" 
                  closable="true"
                  resizable="true"
                  maximizable="true"
                  minimizable="true">
    <p:ajax event="close" update=":form:growl" listener="#{backlogFaces.handleCloseDialogRefresh}" />
--------------------------------------------------------
+ Agregar a TableroFacesServices.java
  public void handleCloseDialogComentario(CloseEvent event);
 (*)Comentario
  ()Impedimento
  ()Tarea
  ()Etiqueta
  ()Archivo
------------------------------------------------------------
[]TableroFaces, []BacklogFaces []PanelTrabajo []Papelera Reciclaje
  (*)Comentario
  ()Impedimento
  ()Tarea
  ()Etiqueta
  ()Archivo
---------------------------------------------------------------
() Comentarios
  <p:ajax event="close" update=":form:growl" listener="#{tableroFaces.handleCloseDialogComentario}" />
  
   // <editor-fold defaultstate="collapsed" desc="handleCloseDialogComentario(CloseEvent event)">

    public void handleCloseDialogComentario(CloseEvent event) {
        try {
            if(isEditable){
                addComentario(tarjetaComentarioSelected);
            }else{
                closeAddComentario(tarjetaComentarioSelected);  
            }
          
        } catch (Exception e) {
              FacesUtil.errorMessage(FacesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
    }
    // </editor-fold>

-------------------------------------------------------------------
+ eliminar
<p:scrollPane
----------------------------------------------------------------
+ datatable
paginator="true"
 rows="#{tableroFaces.rowPageDialog.get()}"
                                 paginatorTemplate="{RowsPerPageDropdown} {FirstPageLink} {PreviousPageLink} {CurrentPageReport} {NextPageLink} {LastPageLink}"
                                 draggableRows="true"
                                 
                                 
-------------------------------------------------                                 
+ Textos usar inputTextArea como en comentarios

-----------------------------------------------------

## tarjetacomentario.xhtml ..> tablero ver el dialogo y usar en todos los dialogos esa configuracion
usar como en asistencia un boton que expande el comentario

```
        <p:dialog header="#{msg['dialog.tarjetacomentario']}" widgetVar="overlayPanelTarjetaComentario"
                  width="60vw" responsive="true"
                showEffect="fade" modal="true" closable="false">
```
