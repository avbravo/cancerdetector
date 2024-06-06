# RELEASE

Project Code: SFT

accreditation
sft
sftalert

## JSF PERFORMANCE
https://stackoverflow.com/questions/2090033/why-jsf-calls-getters-multiple-times

https://itecnote.com/tecnote/r-jsf-performance-improvement/




---







*Fecha:xx/03/2024
- [] Utilizar en todos los columns @Column(generateQuery = true) que se desea que generen consultas
- [] Crear una clase de tipo Scheduler para enviar notificaciones a los administradores de proyecto indicando cuando esta a punto de vencer el plan.
- [] Cambiar los inputTextArea por label mas largos
- [] Crear formulario de administración de applicative
- [] Modificar el logo del sistema de flujo de tarjetas
- [] Implementar búsquedas de tarea y comentarios de las tarjetas en el tablero
- [] Implementar búsquedas de tarea y comentarios de las tarjetas en el backlog
- [] Implementar búsquedas de tarea y comentarios de las tarjetas en el panel de trabajo
- [] Implementar búsquedas de tarea y comentarios de las tarjetas en el papelera de reciclaje
- [] Implementar búsquedas de tarea y comentarios de las tarjetas en el buscador de tarjetas
- [] Evaluar una alternativa para cuando se esta trabajando en otra tarjeta y un usuario la modifica.
- [] Ajustar el contador de tarjetas que no incluya las foraneas y el primer colaborador, ya que es quien las solicita y no actua en ellas.
## Buscar Tarjetas
- [] Modificar el formulario de buscar tarjetas e incluir búsquedas por: 
- [] Buscar tarjetas por idtarjeta
- [] Buscar comentarios en las tarjetas
- [] Buscar tareas en las tarjetas
- [] Cambiar buscartarjetas los comentarios por datatable, en rowExpansion y en el formulario tarjetas.


## Integraciones
- [] Integrarlo con GitHub Issues asi se puede pasar tarjetas a github para ello el proyecto debe tener credenciales
- [] Office 365, Calendar
- [] Slack
- [] Google Calendar
- [] Microsoft Planner
---
- [] Descargar todos los archivos en un solo proceso
- [] Implementar testing con Microsoft Playwright
- [] Implementar Twailwing css

## Diseño

- [] Agregar un espacio en el icono de notificaciones del tablero
- [] Modificar el envio de emails colocandole un logo y el diseño similar al de solicita
- [] Pasarlo a Helidon y generar una imagen docker y nativa con GraalVM
-[] Datatable responsive
() Considerar usar inputTextarea  para los textos que muestran el nombre de tarjeta similar a descripcion  que todas deben llevar inputTextArea
() Considerar usar inputTextarea  para los textos que muestran el nombre del proyecto similar a descripcion  que todas deben llevar inputTextArea
- [] Ampliar la pantalla de continuar usar un estilo landingpage de login
- [] Ampliar la pantalla de continuar usar un estilo landingpage de continuar en el sistema
- [] Aplicar responsive desing en proyecto, sprint, reportes, usuarios, formularios de configuracion
 ()datatable
() dialogos
- [] Ajustar los datatable para que se muestren bien en los moviles
- [] Cuando crea un nuevo registro el datatable no se desplaza con paginacion al final de la tabla.
- [] Ver soho sprint para sugerencias
- [] Mejorar el diseño de los datatable revisar el primefacesblock que usan list
- [] Mejorar el diseño de los dialog revisar el primefacesblock que usan list
- [] Verificar que cuando se de clic en el <p:menuButton y muestre las opciones no actualice el formulario con el websocket mis reportes, reporte departammental, reporte x colaborador
- [] Revisar el tiempo de vida del growl disminuirlo en el tablero
- [] Revisar todos los mensajes de que se ha cambiado por otro usuario como los despliega
- [] Los autocomplete no se visualizan de manera adecuada


## Notificaciones
- [] Guardar las notificaciones en una base de datos para que se muestre en el panel del dashboard al colaborador
 {iduser, mensaje, id, tipoid,evento}
- [] Verificar la alerta de envio de correos en que momento se debe ejecutar
- [] Ajustar las notificaciones que se muestran en el dashboard
- [] Generar listado de notificaciones en el dashboard del sistema de flujo T.
- [] Modificar los websocket que las notificaciones en los tableros sean por idusuario y idproyecto


## Apache

- [] Implementar notificaciones con Apache Flink
- [] Revisar que al agregar un nuevo documento el datatable no se muestra adecuadamente con el nuevo registro en la paginación.

# Diagrama
- [] Diagram Basic https://www.primefaces.org/showcase/ui/data/diagram/basic.xhtml?jfwid=c0360
- [] Crear imagen nativa con Helidon Graalvm
- [] Envio de notificacion de tarjetas en Reserva que deben ser pasadas al tablero o panel de trabajo cuando se esta acercando la fecha.

--------------------------------------------------------------------------------

- [] Documentar el uso del tablero con figuras
- [] Usar [https://tailwindcss.com/](https://tailwindcss.com/)
- [] Cronologia del proyecto
- [] Notificaciones que se muestran en el dashboard principal
- [] Agregar un ScrollPanel al formulario de logros
- [] Revisar el tamaño de letra que antes estaba al 80%
- [] Hacer pruebas de edición y ordenación de tareas con usuarios simultaneos.
- [] Revisar que cierra el dialogo de agregar tareas con websocket desde otro usuario en el formulario backlog muestra la advertencia
- [] Agregar un colaborador que no este en el proyecto cuando se trate de un proyecto que es publico porque puede ser que el colaborador reporte la situación y no tiene acceso al sistema para registarlo.
- [] Robot framework for test web site Java Server Faces
- [] Mejorar la programación de la clase DashboardFaces.java eliminar atributos declarados y no usados.
- [] Verificar el cierre de sesion con el Websocket
- [] Scheduler que verifique los Sprint que estan por vencer y envie Websocket al tablero,sprint, reserva, indicando que estan proximo a vencer.
- [] Scheduler que verifique cuando un proyecto esta proximo a vencer y envie las notificaciones.
- [] Scheduler que verifique cuando una tarjeta esta proxima a vencer y envie las notificaciones.
- [] Verificar cuando el jefe de unidad cierra un Sprint y un colaborador esta creando una tarjeta que ocurre.
- [] Agregar el websocket para los reportes y validar cuando se debe refrescar o no.
-------------------------------------------------------------------------
- [] Implementar Apache Kafka + Apache Flink
- [] Implementar Apache Pulsar + Apache Spark

# Apache

- [] Apache Iceberg
¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
## Dashboard
- [] Crear Filtro en el dashboard principal que permita mostrar un dashboard simple, avanzado , personalizado

## Tablero


## General
- [] Implementar TinyLog
- [] Apache Pulsar
- [] Pasarlo a Helidon
- [] Convertir imagenes con GraalVM
- [] Usar docker con Kubernetes
- [] Ver los proyectos de apache para balanceo de carga
- [] Eclipse Store
- [] Revisar los dialogos
- [] PrimeVue
() Engine Reverse Proxy Ngnigx
() Load Balancer

---
## Kubernetes
-- () Cluster k3s

## Errores Javascript
- [] Pasive events usar
<script type="text/javascript" src="https://unpkg.com/default-passive-events"></script>

## Responsive

## Reportes
- [] Reporte de proyectos por Area
- [] Reporte de estadisticas globales del colaborador

## Exportar
- [] Exportar a Excel
- [] Exportar a Word
- [] Exportar a JSON

## General
- [] Revisar primeblocks para los componentes
- [] Corregir errores ortograficos en properties correspondientes a los botones
- [] Quitar el codigo de test para autocomplete con tarjeta
- [] Crear una opción de anuncios que estará disponible en el panel principal del sistema de flujo de tarjetas
- [] Implementar TimeLine para mostrar las tarjetas del sistema FT.
- [] Crear indices MongoDB
- [] Implementar la verificación del usuario logeado para impedir acceso simultaneo con la misma cuenta
- [] Solicitar acceso desde fuera de la universidad
- [] Validar entorno de desarrolo [https://www.primefaces.org/showcase/ui/misc/importEnum.xhtml?jfwid=6eac8](https://www.primefaces.org/showcase/ui/misc/importEnum.xhtml?jfwid=6eac8)

## Reglas
- [] Crear un modulo de automatización mediante reglas personalizables

## Eventos
- [] Registrar eventos ocurridos cuando se envia un correo como notificaciones del sistema.
- [] Registrar eventos ocurridos cuando se envía un correo como notificaciones del sistema.
     * Estos eventos seran procesados luegos como websocket
     * usar el proyecto asistencia
     * NotificacionProyecto .java es una clase en autentification que gestiona las notificaciones
- [] Pasarlo a Helidon

## IA
- [] Hacer estimaciones con Weka tiempo que demora en hacer algo
- [] ETL con Spark

## Flujo
- [] Crear fomulario de flujo de tarjeta con graficos estilo Plaky


## Email
- [] Incluir imagenes y texto mejorado en los emails

## Schedule
- [] Crear un schedule que envie notificaciones sobre el cierre de los Sprint de manera automatica.
- [] Implementar el cierre y creación automatica de Sprint validando si el proyecto permite la creación automatica.




## Modulo Applicative en Administracion
- [] configuracion del aplicative y email
- [] Modulo Email en Administracion

## Componente autocomplete con paginacion
- [] crear el componente con paginación

## Aplicar primefaces selenium
- [] [https://codenotfound.com/jsf-primefaces-automated-unit-testing-selenium.html](https://codenotfound.com/jsf-primefaces-automated-unit-testing-selenium.html)


## Super user
- [] Crear formulario de administración de email para rol super usuario del sistema de flujo de tarjetas
- [] Crear formulario administración de aplicativo para rol super usuario del sistema de flujo de tarjetas
- [] Implementar TimeLine para mostrar las tarjetas del sistema FT.
- [] Registrar Accesos del sistema

## Java
- [] dode use isPresent usar java lambda stream para simplificar la lista devuelva sin usar el stream
- [] Mejorar el codigo de los controller con lambda Stream filter
- [] usar Java Records, Records Builders
- [] Eclipse Collection
- [] Supplier/ Consumer/ predicate

## Clonar Proyectos


- [] Clonar proyectos especificando las tarjetas y planes

---
## Release: 1.0.b-40
**Fecha:xx/05/2024





# Planes (nuevo estado)
- [] Actualizar formulario de Planes deben estar asociados a objetivos del POA/PDI
- [] Configurar los sprint a colecciones dinámicas para mejorar el desempeño de la aplicación
- [x] Actualizar planes para permitir crear planes sin que sea las fechas validas , es decir para planes en el futuro.
- [x] Agregar un nuevo estado a los planes llamado **programado** de manera que se puedan crear muchos planes con este estado para ser usados en el futuro


## General
- [] Crear videos del uso del sistema

- [] Mejorar el diseño de los datatable 

- [] Crear un hipervínculo desde la ayuda a los formularios

- [] Usar un Thread al enviar los correos o un CompleteFuture

- [] Soporte para archivos con extension HEIC

- [] Bloquear el botón Atras del navegador, Jakarta Faces control retorno a pagina anterior

- [] Iconos colocar un listado en un dialogo asi el usuario los puede ver mejor y seleccionar el que desee en lugar de un selectOneMenu

- [] Agregar un campo nuevo al proyecto llamado Fecha de Reinicio y esta se activa cuando el proyecto se coloca en estado detenido, y se envia una notificacion al usuario 15 antes del reinicio


- [] Corregir el  encabezado del template falta el formulario timeline

- [] Corregir el  encabezado del template falta el formulario notificaciones

- [] Modificar el formulario de buscar tarjetas e incluir búsquedas por iddtarjeta,comentarios en las tarjetas,tareas en las tarjetas

- [] Cambiar el nombre del sistema Sistema para la planeación y el seguimiento del trabajo en equipo C.R.AZUERO
- [x] Actualizar la versión del sistema a primefaces a v14.0
- [x] Agregar texto al botón cerrar la edición de una tarjeta
- [x] Modificar el dashboard principal con los proyectos privados y publicos mejorando el diseño
- [x] Cambiar el repeat de miembros de equipos por un datatable en el dashboard principal.



## Proyectos
- [] Clonar un proyecto mostrar las opciones () pasar todas las tarjetas a reserva () pasar todas las tarjetas a fechas incrementando aoy validando que sea de lunes a viernes
- [] Revisar el websocket proyecto no esta actualizando el tablero
- [x] Crear Nueva opcion de eliminar proyectos, estos proyectos seran enviados a una papelera de reciclaje de proyectos
- [x] Quitar los botones de los proyectos y dejarlos solo con los menus 
- [x] Crear formulario de Papelera de reciclaje de proyectos
- [x] Agregar la opción para crear tarjetas programadas al colaborador si tiene los permisos en el proyecto


# Tablero
- [x] Modificar el tablero para que muestre de manera predeterminada las tarjetas del colaborador en el tablero 
- [x] Revisar que no funciona seleccionar colaborador en el formulario  tablero
- [x] Cambiar el componente de selección de tareas a <p:toggleSwitch
- [x] Cambiar el componente de selección de impedimentos a <p:toggleSwitch

# Papelera Reciclaje
- [x] Mejorar el diseño del formulario de papelera de reciclaje
- [x] Permitir mover tarjeta desde la papelera a un plan programado

# Programación
- [x] Revisar que no funciona seleccionar colaborador en el formulario  tablero
- [x] Permitir que al crear una tarjeta en la programación se pueda mover al tablero
- [x] Permitir que al crear una tarjeta en la programación se indique el plan a que va a pertenecer(debe mostrar solo plan abierto y en programación)
- [x] Mejorar el diseño del formulario de programación
- [x] Revisar que no funciona el filtro de tarjetas en el formulario programacion
- [x] Agregar opción de eliminar tarjeta de un plan programado


# Reserva
- [x] Revisar que no funciona seleccionar colaborador en el formulario reserva
- [x] Agregar opción de eliminar tarjeta de la reserva
- [x] Permitir que al crear una tarjeta en la reserva se indique el plan a que va a pertenecer(debe mostrar solo plan abierto y en estado detenido)
- [x] Quitar el botón tablero cuando no hay plan activo en la esquina superior derecha
- [x] Pasar de manera automatica las reservas a un plan abierto
- [x] Mejorar el diseño del formulario de reserva
- [x] Revisar que no funciona el filtro de tarjetas en el formulario reserva

# Panel de trabajo
- [x] Revisar que no carga el panel de trabajo aparece vacio.


## Reportes
- [x] Modificar reportes para mostrar proyectos con estado eliminado con color diferente
- [x] Crear formulario de Papelera de reciclaje de proyectos
- [x] Modificar los reportes de proyectos colocando de color rojo las filas de proyectos eliminados

## Menu Izquierdo
- [x] Agregar opcion Retornar proyecto archivado al dashboard principal
- [x] Crear la opción de Papelera de reciclaje de proyectos en el menu



---
## Release: 1.0.b-39
**Fecha:22/05/2024

- [x] Configurar la creación de colecciones dinamicas para almacenar las tarjetas y Sprint por proyecto

- [x] Ajustar el programa sftalert para enviar notificaciones establecimiento el uso de sleep() para evitar bloqueo

- [x] Eliminar el menú de configuración para otros usuarios que no sean superuser o developers

- [x] Mostrar siempre el botón de reserva aunque el proyecto este detenido.

- [x] Habilitar la reserva que este en un intervalo de fechas del proyecto y no del Sprint actual.

- [x] Crear modulo de migración para el sistema sft con colecciones dinamicas 

- [x] Mejorar el formulario de Login del sistema

- [x] Corregir el error que con el esquema nuevo no muestra el calendario

- [x] Corregir error en reporte estadísticas no muestra el formulario al se llamado desde los reportes

- [x] Crear nueva versión del sistema sft

- [x] Reporte de tarjetas en el buscador

- [x] Mejorar el diseño del formulario login y solicitar Tokens

- [x] Realizar mejoras en el formulario de búsquedas de tarjetas

- [x] Corregir el error que no imprime las tarjetas desde el formulario de búsqueda de tarjetas



----
## Release: 1.0.b-38
**Fecha:26/03/2024
- [x] Ajustar el panel de trabajo que inicialmente no muestra ordenado las tarjetas por la ultima acción efectuada
- [x] Modificar el formulario de perfil ajustando los iconos en los botones para un mejor diseño
- [x] Mejorar el procedimiento de ordenación de tarjetas en base a la ultima modificación realizada.
- [x] Verificar tarjetas que quedan fuera del sprint, no estan en reserva ni eliminadas por la fecha final, analizar tarjeta 968 creada por Israel.
- [x] Ejecutar formulario setup version1_0_b_38 para crear atributo lastModification



## Release: 1.0.b-37
**Fecha:25/03/2024
- [x] Modificar la visualización de proyectos privados eliminando la opción de Mi Resumen, ya que esta se muestra en la tarjeta principal.
- [x] Corregir en el dashboard principal que el total de tarjetas por cada proyecto que se muestra en la tarjeta de proyectos foraneos.
- [x] Modificar la opción de descarga de archivo que coloque el nombre de la descripcion del documento.
- [x] Modificar las clases Java que generan una descripción del archivo para eliminar la extensión
- [x] Agregar al dashboard principal diálogos que se activan mediante un coomandlinK y muestran las tarjetas pendientes, progreso, finalizado y reserva y con un link al tablero si esta disponible.
- [x] Modificar el formulario de creación y edición de proyectos para agregar el atributo generación automática de Sprint, para permitir el cierre y creación automática de plan.
- [x] Realizar ajustes en el dashboard principal para una mejor visualización de los totales por tarjetas en cada proyecto.
- [x] Eliminar el mensaje que debe actualizar el tablero cuando recibe un Websocket con las notificaciones.



----
## Release: 1.0.b-36
**Fecha:19/03/2024
- [x] Realizar mejoras en el diseño del dashboard principal
- [x] Verificar el cerrar un Sprint y crear uno nuevo que envia un mensaje de error
- [x] Mejorar el dashboard principal colocando información de las totales de las tarjetas
- [x] Corregir error al cerrar Sprint  


----
## Release: 1.0.b-35
**Fecha:19/03/2024
- [x] Ajustar el formulario de perfil quitar los otros botones que no son necesarios.
- [x] Eliminar el borde de los datatable de los formularios.
- [x] Modificar el formulario de crear y actualizar usuarios agregando la opción para recibir notificaciones
- [x] Agregar nueva opción de ordenación de tarjetas por ultima modificacion 
- [x] Corregir la clase en el microservicio que calcula estadisticas por proyecto
- [x] Realizar eliminación del metodo refreshCache() y en su lugar realizar invocaciones al método refresh() para la carga de datos
- [x] Revisar el calculo de estimación de la duración de la tarjeta
- [x] Modificar la opcion de crear una tarjeta desde una plantilla que se le ha cambiado el nombre ya que muestra el nombre original y no el de la plantilla.
- [x] Mejorar el login de usuario colocando el perfil de usuario. (foto).
- [x] Mejorar el dashboard colocando los totales de los proyectos y mostrar por cada proyecto
- [x] En el dashboard principal colocar un boton para colapsar el proyecto
- [x] Crear aplicacion para envio de notificación de que las tareas están pendientes o progreso o ya llegaron a su fin

----
## Release: 1.0.b-34
**Fecha:xx/03/2024
- [x] Crear atributo en la tabla usuario, que indique si desea recibir un resumen de las tarjetas todos los dias.
- [x] Corregir el error en el dashboard principal que no muestra la imagen del propietario del proyecto
- [x] Envio de resumen de tarjetas todas las noches a las 9:30:25 am
- [x] Error el tablero falla no muestra colaboradores puede ser con la nueva version de jmoordb-core
- [x] Crear aplicacion para envio de notificación de que las tareas están pendientes o progreso o ya llegaron a su fin

----
## Release: 1.0.b-33
**Fecha:11/03/2024
- [x] Agregar un nuevo tipo de graficas logros en el dashboard principal
- [x] Modificar todos los formularios que utilicen rowExpansion y cambiar el componente carousel por datatable
- [x] Revisar el detalle de tarjetas que muestra el contador de etiquetas incorrecto


----
## Release: 1.0.b-32
**Fecha:11/03/2024

- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en buscador de tarjetas
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en applicative
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en mis proyectos
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en propietario agregar
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en reporte colaborador departamental
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en reporte  departamental
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en tarjetas
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en tarjetas foraneas
- [x] Cambiar los row expasion con <div class='card'> como se muestra en applicative.xhtml en tarjetasimpedimentos
- [x] Cambiar todos los textos y propierties  dialog.x por dialog.x para estandarizar la sintaxis de uso
- [x] Agregar un border a todos los elementos datatable de los formularios y expandir a 12 columnas
- [x] Ajustar el tamaño del sistema al 100% para una mejor visualizacion
- [x] Ajustar en el dashoard colocar el nombre del proyecto en lugar de las siglas en los proyectos privados y publicos
- [x] Corregir el error en el toptip de los botones de la columna finalizado que mostraban el mensaje por error de progreso
- [x] Corregir en el panel de vista de tarjetas que no muestra el boton para visualizar un archivo
- [x] Crear un dialogo para el historial de la tarjeta en el formulario panel de trabajo
- [x] Implementar la validación de tres rangos de resoluciones
- [x] Implementar el uso del boton maximizar para dispositivos moviles los dialogos.
- [x] Realizar ajustes en todos los diálogos comentarios para una mejor visualización (formulario Tablero, Reserva, Panel trabajo, Papelera de reciclaje)
- [x] Realizar ajustes en todos los diálogos tareas para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos impedimentos para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos etiquetas para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos archivos para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos colaborador para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos agregar a plantilla para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos agregar desde plantilla para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos clonar para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos remover para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos view detalle para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos agregar tarjeta para una mejor visualización (formulario Tablero)
- [x] Realizar ajustes en todos los diálogos editar tarjeta para una mejor visualización (formulario Tablero)
- [x] Corregir el error en el dialogo de impedimiento en el Panel de Trabajo
- [x] Implementar el uso   public void handleCloseDialogTarea(CloseEvent event); para manejar los cierres de los dialogos
- [x] Implementar el uso   public void handleCloseDialogImpedimento(CloseEvent event); para manejar los cierres de los dialogos
- [x] Implementar el uso   public void handleCloseDialogEtiqueta(CloseEvent event); para manejar los cierres de los dialogos
- [x] Implementar el uso   public void handleCloseDialogArchivo(CloseEvent event); para manejar los cierres de los dialogos
- [x] Implementar el uso   public void handleCloseDialogColaborador(CloseEvent event); para manejar los cierres de los dialogos
- [x] Implementar el uso   public void handleCloseDialogEditar(CloseEvent event); para manejar los cierres de los dialogos
- [x] Revisar los comentarios muy extensos convertirlo en inputTextArea en los datatable 
- [x] Revisar las tareas muy extensos convertirlo en inputTextArea en los datatable 
- [x] Revisar los impedimentos muy extensos convertirlo en inputTextArea en los datatable  
- [x] Revisar los etiquetas  muy extensos convertirlo en inputTextArea en los datatable 
- [x] Mejorar el detalle de tarjetas agregando botones para invocar etiquetas y colaborador
- [x] Revisar los nombres de archivos  muy extensos convertirlo en inputTextArea en los datatable 
- [x] Implementar dialogos responsivos en crear proyecto y editar proyectos del dashboard principal
- [x] Implementar dialogos responsivos en archivar proyecto del dashboard principal
- [x] Implementar dialogos responsivos en clonar proyecto y editar proyectos del dashboard principal
- [x] Implementar dialogos responsivos en crear y editar sprint
- [x] Realizar mejoras en el dialogo de cerrar sprint 
- [x] Implementar dialogos responsivos en calendario schedulesprint.xhtml
- [x] Implementar dialogos responsivos en calendario scheduledashboard.xhtml
- [x] Implementar dialogos responsivos en calendario scheduletablero.xhtml
- [x] Implementar dialogos responsivos en calendario schedulebylogged.xhtml
- [x] Implementar dialogos responsivos en grupotipotarjeta.xhtml
- [x] Implementar dialogos responsivos en tarjeta.xhtml
- [x] Implementar dialogos responsivos en user.xhtml
- [x] Implementar dialogos responsivos en role.xhtml
- [x] Implementar dialogos responsivos en icono.xhtml
- [x] Implementar dialogos responsivos en institution.xhtml
- [x] Implementar dialogos responsivos en central.xhtml
- [x] Implementar dialogos responsivos en departament.xhtml
- [x] Implementar dialogos responsivos en country.xhtml
- [x] Implementar dialogos responsivos en province.xhtml
- [x] Implementar dialogos responsivos en district.xhtml
- [x] Implementar dialogos responsivos en township.xhtml
- [x] Implementar dialogos responsivos en zone.xhtml
- [x] Implementar dialogos responsivos en clonar proyecto en misproyectos.xhtml
- [x] Implementar dialogos responsivos en clonar proyecto en reportedcolaboradordepartamental.xhtml
- [x] Implementar dialogos responsivos en clonar proyecto en reportedepartamental.xhtml




----
## Release: 1.0.b-31
**Fecha:01/03/2024
- [x] Crear formulario de administración de province
- [x] Crear formulario de administración de district
- [x] Modificar el logo del sistema sft
- [x] Crear formulario de administración de township
- [x] Crear formulario de administración de zone
- [x] Corregir reporte de edificios no lo muestra ,envía una pagina vacía
- [x] Editar los registros de district de la base de datos
- [x] Editar los registros de corregimientos de la base de datos

----
## Release: 1.0.b-30
**Fecha:26/02/2024
- [x] Crear un formulario en que el super usuario vea todos los proyectos y desde alli poder asignar propietario
- [x] Mostrar los usuarios de un proyecto por categorias, propietario y colaborador en el dashboard principal
- [x] Cambiar el logo del sistema adaptarlo a las nuevas funcionalidades
- [x] Modificar el formulario de login con panel estilo carrousel
- [x] Actualizar la versión de Payara  Micro a 6.2024.2
- [x] Crear formulario administrativo para manejo de Institución
- [x] Subir versión 1.0.b-30 del sistema
- [x] Crear formulario de administración de iconos
- [x] Crear formulario de administración de paises
- [x] Crear formulario de administración de central
- [x] Configurar los repositorios y controler de las entidades usadas para administrar la aplicación
- [x] se cambio en los dialogos styleClass="jmoordbcore-dialog-responsive" por styleClass="jmoordbcore-dialog-responsive40x450"
- [x] Crear formulario de administración de building

## Release: 1.0.b-29
**Fecha:19/02/2024

- [x] Ampliar el ancho de los formularios para aprovechar el maximo tamaño de las pantallas
- [x] Verificar que en el formulario de tablero al agregar una tarjeta nueva y se trata de mover a progreso genera una excepción
- [x] Verificar que en el formulario de reserva al agregar una tarjeta nueva y se trata de mover a progreso genera una excepción
- [x] Validar las opciones que tiene en Mis reportes si el usuario no es propietario del proyecto.
- [x] Crear opción para para reabrir proyectos cerrados desde la opción mis proyectos.
- [x] Se mejoro el diseño de los formularios mis reportes, reporte departamental y reporte colaborador
- [x] Implementar WebSocket en los formulario mis reportes, reporte por colaborador, reporte departamental



---
## Release: 1.0.b-28
**Fecha:15/02/2024
- [x] Modificar tablero para utilizar datos de cache y reducir peticiones al microservicios.
- [x] Modificar panel de control para utilizar datos de cache y reducir peticiones al microservicios.
- [x] Modificar papelera de reciclaje para utilizar datos de cache y reducir peticiones al microservicios.
- [x] Modificar backlog para utilizar datos de cache y reducir peticiones al microservicios.
- [x] Modificar el formulario de proyectos para permitir que el super usuario podria agregar propietarios a los proyectos
- [x] Corregir que no muestra el timeLine desde el tablero.
- [x] Modificar el formulario de tablero para que no mensajes de las operaciones realizadas
- [x] Actualizar los proyectos a Microprofile 6.0
------------------------------------------------------------------------------------




---
## Release: 1.0.b-27
**Fecha:08/02/2024
- [x] Modificar las tarjetas que no se esta asignado que permita ver los detalles de la misma a cualquier colaborador del proyecto.
- [x] Organizar la pagina de documentación y preguntas frecuentes
- [x] Eliminar en los datatable el uso de  reflow="true"  styleClass="mt-2" y cambiarlos por  resizableColumns="true" liveResize="true"
- [x] Crear opción para mostrar los iconos en las tarjetas para agilizar la carga de las tarjetas en el tablero, reserva, panel de trabajo, papelera de reciclaje
- [x] Modificar el formulario de papelera de reciclaje para mostrar adecuadamente las tarjetas
- [x] Modificar el formulario de reserva para mostrar adecuadamente las tarjetas
- [x]  Realizar ajustes en la visualización de las tarjetas para que el menu contextual se despliegue a la derecha
- [x]  Realizar ajustes en la visualización del dashboard principal para que el menu contextual se despliegue a la derecha
- [x]Modificar el formulario de tablero proyectos foraneos que permita agregar una tarjeta a la plantilla
----
## Release: 1.0.b-26
**Fecha:07/02/2024
- [x] Verificar que el formulario Organigrama implemente el uso de Cache en los autocomplete y selectOneMenu
- [x] Verificar reporte departamental que implemente el uso de Cache en los autocomplete y selectOneMenu
- [x] Verificar reporte x colaborador que implemente el uso de Cache en los autocomplete y selectOneMenu
- [x] Mejorar los dialogos de los formularios de departamento, rol, grupotarjeta 
- [x] Agregar a la entidad Tarea {UserView, ordenado} y aplicarle funcionalidad similar a comentarios en tablero, panel de control y reserva
- [x] Crear un programa que actualice todas las tarjetas con el nombre del usuario en la tarjeta en el tablero
- [x] Crear un programa que actualice todas las tarjetas con el nombre del usuario en la tarjeta en el panel de control
- [x] Crear un programa que actualice todas las tarjetas con el nombre del usuario en la tarjeta en el backlog
- [x] Ajustar el dialogo de tareas , permitiendo ordenación en el tablero y en el panel de control y en la reserva.
- [x] Agregar la columna fecha en  los diálogos que muestran los impedimentos de las tarjetas
- [x] Ajustar el dialogo de archivos, permitiendo ordenación en el tablero y en el panel de control y en la reserva.
- [x] Ajustar el dialogo de etiquetas, permitiendo ordenación en el tablero y en el panel de control y en la reserva.
- [x] Agregar la columna usuario  en  los diálogos que muestran los impedimentos de las tarjetas para determinar el usuario que realiza la operación
- [x] Agregar la columna activo de manera que el usuario puede marcarla para indicar si fue o no resuelto el impedimiento.
- [x] Realizar ajustes en el diseño responsivo del tablero
- [x] Realizar ajustes en el diseño responsivo panel de trabajo
- [x] Realizar ajustes en el diseño responsivo reserva
- [x] Realizar ajustes en el diseño responsivo papelera de reciclaje
- [x] Controlar que no envié notificaciones al websocket de papelera de reciclaje, si no ha ocurrido una eliminación de una tarjeta en el tablero
- [x] Controlar que no envié notificaciones al websocket de papelera de reciclaje, si no ha ocurrido una eliminación de una tarjeta en el reserva
- [x] Controlar que no envié notificaciones al websocket de papelera de reciclaje, si no ha ocurrido una eliminación de una tarjeta en el panel trabajo
- [x] Modificar el formulario de ayuda, agregando nuevas funcionalidades.
- [x] Mejorar el diseño del dashboard principal
- [x] Ejecutar el setup para que cargue los user a las tareas dentro de las tarjetas
- [x] Crear y subir versión 1.0,b-26

----
## Release: 1.0.b-25
**Fecha:01/01/2024

- [x] Actualizar la versión de payaramicro a 6.2024.1
- [x] Verificar el formulario perfil que implemente el uso de Cache en los autocomplete y selectOneMenu
- [x] Corregir el código que muestra la advertencia de dias pendientes en el tablero y panel de control
- [x] Verificar en buscador de tarjetas que implemente el uso de Cache en los autocomplete y selectOneMenu


----
## Release: 1.0.b-24
**Fecha:29/01/2024
-[x] Modificar la opción de cambio de temas, no actualiza el usuario.
-[x] Cambiar todos los findById que devuelvan Optional<>() como userView en Rest Implementation
-[x] Modificar cuando crea un nuevo plan, verificar los dias del plan anterior y colocar ese tiempo como la fecha final del plan
-[x] Modificar el envio de Websocket para que no envie al mismo usuario que la genera
-[X] Verificar que al cerrar un Sprint pasa las tarjetas a la reserva
-[x]  Cambiar el color de las tarjetas que estan próxima a vencer o agregarle un indicativo de advertencia en el tablero
-[x]  Cambiar el color de las tarjetas que estan próxima a vencer o agregarle un indicativo de advertencia en el panel de control
-[x] Agregar el atributo dias para advertencia en el entity proyecto y actulizar el formulario donde se crea y edita el proyecto
-[x] Mejorar el formulario de creación y edición de proyectos agregar la propiedad diasparaadvertencia
-[x] En el tablero y panel de control tomar el valor del atributo dias de adevertencia para las tarjetas



---

## Release: 1.0.b-23
**Fecha:24/01/2023


## Websocket

- [x] Sincronizar tarjetas mediante Websocket y validar cambios Tablero
- [x] Sincronizar tarjetas mediante Websocket y validar cambios Backlog
- [x] Sincronizar tarjetas mediante Websocket y validar cambios Papelera de Reciclaje
- [X] Crear websocket para el dashboard que envie notificaciones cuando se cambia un proyecto
- [x] Sincronizar con websocket el tablero cuando cambia un proyecto
- [x] Sincronizar con websocket el backlog cuando cambia un proyecto
- [x] Sincronizar con websocket la papelera de reciclaje cambia un proyecto
- [x] Verificar con proyectos foraneos si actualiza el tablero del usuario foraneo.
- [x] Modificar todos los converter y controller para soportar el uso de Cache para reducir peticiones a los microservicios
 -[x] Implementar websocket con contador de actualizaciones en el tablero
 -[x] Implementar websocket con contador de actualizaciones en el backlog
 -[x] Implementar websocket con contador de actualizaciones en la papelera de reciclaje
 -[x] Implementar websocket con contador de actualizaciones en la panel de trabajo
 -[x] Implementar websocket con contador de actualizaciones en el sprint
 -[x] Implementar websocket con contador de actualizaciones en el dashboard
 -[x] Probar cambio el estado o fechas proyecto como afecta el formulario de Reserva, Papelera de reciclaje, Panel de trabajo, Tablero
 -[x] Probar cambio el estado o fechas sprint como afecta el formulario de Reserva, Papelera de reciclaje, Panel de Trabajo, Tablero
 -[x] Remover el encripter de los microservicios
# Dashboard

- [x] Revisar que desde el Dashboard principal muestra el boton <Tablero> que no valida que la fecha inicial sea mayor que la actual.

# Tablero 
- [x] Revisar que Tablero que no valida que la fecha inicial sea mayor que la actual al cambiar el websocket


## General

- [x] Remover bordes de las columnas donde se visualizan las tarjetas tablero, reserva, panel de trabajo, papelera de reciclaje
- [x] Modificar la entidad proyecto y colocar información del Sprint abierto de manera que reduzca las peticiones al endpoint para obtener informacion del sprint del proyecto.
- [x] Agregar a cada proyecto información del ultimo plan disponible, tal como fecha de inicio y fecha de fin esto ayuda al usuario.
- [X] Validar que al crear un Sprint la fecha final del proyecto sea mayor que la actual.
- [x] Ajustar el formulario de edición de proyectos que envia un mensaje que otro usuario lo modifico.
- [x] Guardar la fecha hora actual en el campo fechafinal del sprint al momento de cerrar un sprint.
- [x] Al crear proyecto validar que se indique el tipo de tarjetas para el proyecto
- [x] Botón de advertencia en el dialogo de comentarios que no se ha dado clic en el botón (+) para agregarlo a la tarjeta.
- [x] Modificar el formulario de editar proyectos eliminando la opción finalizado del menu de selección
- [x] Crear formulario de cerrar proyecto validar un proyecto que queda con tarjetas pendientes o en progreso y no hay sprint abierto.
- [x] Desabilitar el uso de <p:inplace> para que no afecte la implementación de WebSocket en Tablero
- [x] Desabilitar el uso de <p:inplace> para que no afecte la implementación de WebSocket en Backlog
- [x] Implementar el uso de ConverterServices para mejorar el desempeño de la aplicación al reducir la cantidad de peticiones al microservicio en tablero
- [x] Implementar el uso de ConverterServices para mejorar el desempeño de la aplicación al reducir la cantidad de peticiones al microservicio en backlog
- [x] Implementar el uso de ConverterServices para mejorar el desempeño de la aplicación al reducir la cantidad de peticiones al microservicio en papelera
- [x] Implementar el uso de ConverterServices para mejorar el desempeño de la aplicación al reducir la cantidad de peticiones al microservicio en panel  de trabajo


---


## Release: 1.0.b-22
**Fecha:04/12/2023

## General
- [x] Ajustar el formulario de login el panel es muy grande
- [x] Agregar soporte para el evento Enter al ingresar elementos a los componentes de las tarjetas en el tablero
- [x] Agregar soporte para el evento Enter al ingresar elementos a los componentes de las tarjetas en el Bakclog


---
## Release: 1.0.b-21
**Fecha:1/12/2023
- [x] Corregir el dialogo de visualizar archivos , para que se mantenga en el area disponible


---
## Release: 1.0.b-20
**Fecha:1/12/2023

## Plantillas de Tarjeta
- [x] Mejorar el diseño de ver las tarjetas mediante un rowexpasion como aparece en el formulario de tarjetas


### Documentación

## Visualizar Archivos
- [x] Crear opción para visualizar archivos en el tablero

- [x] Crear opción para visualizar archivos en el backlog

- [x] Crear opción para visualizar archivos en formulario busqueda

- [x] Crear opción para visualizar archivos en formulario tarjetas

- [x] Crear opción para visualizar archivos en formulario Foraneas

- [x] Crear opción para visualizar archivos en formulario Impedimentos

- [x] Ajustar la resolución de pantalla de la plantilla

- [x] Mejorar el tablero y colocar de manera predeterminada la visualización individual de tarjetas

- [x] Modificar los rowExpansion de los datatable para ampliar el tamaño responsivo


### Nuevas Funcionalidades

- [x] Agregar estilo de reportes como se muestra en la opción de buscar tarjetas


---
## Release: 1.0.b-19
**Fecha:27/11/2023

## General
- [x] Ampliar el tiempo de sesion cuando el usuario presiona una tecla
- [x] Elimina el reloj y el commandButton del tiempo del servidor
- [x] Corregir el error de que se quedaba sin mostrar elementos del dashboard al logearse
- [x] Verificar comportamiento al presionar botón actualizar del navegador
- [x] Modificar ubicación del formulario login
- [x] Actualizar servidor de payaramicro a versión 6.2023.11
- [x] Muestra el tablero combinado para el perfil colaborador
- [x] Modificar la visualización de elementos en las columnas para que se justifiquen a la izquierda

## Buscador Tarjetas
- [x] Implementar mejoras en el formulario de busqueda de tarjetas similar a la de los tablero
- *[x] Implementar múltiplos filtros en los auto complete con regex en el formulario de buscar tarjetas
    * crear metodos searchLikeByName(String name, Search search)
    * crear metodos countSearchLikeByName(String name, Search search), 
- [x] Agregar en el formulario Buscar tarjeta una opción que lo diriga al Tablero
- [x] Mejorar el buscador de tarjetas mostrar en los autocomplete información mas corta y usar el nuevo autocomplete con paginación.
- [x] Implementar múltiplos filtros en los auto complete con regex en el formulario de buscar tarjetas

## Papelera de Reciclaje
- [x] Crear un formulario papelera de reciclaje donde estan las tarjetas borradas y se puede restaurar similar a un backlog a un proyecto activo


## Responsive
- [x] Revisar todos los dialogos responsive en moviles para una mejor visualización

## Modulo Plantillas de Tarjeta
-[x] Crear modulo de administración de plantillas en  base a tarjetas
-[x] Crear opcion que permita generar una tarjeta en base a una plantilla

- [x] Crear la opción para guardar una tarjeta como plantilla
la plantilla es una opción de menú de cada tarjeta que al darle click en la opción guardar plantilla la almacena en la colección plantilla 
     {Almacena,una copia de la tarjeta que sirve para crear una nueva.
      ,Se identifica por tipo de grupo de tarjeta para asociarlo a los proyectos que tienen esos grupos de tipo de tarjeta
      ,Se identifican por colaborador
      ,Al seleccionar la opción crear tarjeta de plantilla que se coloca en el profile de la tarjeta , se crea una nueva en un proceso similar a una clonacion
      se asginan las fechas del dia de hoy y la fecha final el final del sprint     
}


## General
- [x] Corregir el despliege de horas del reloj de 24 horas a formato 12 horas
- [x] Actualizar la versión de Payara-micro a 6.2023.11

---
## Release: 1.0.b-18
**Fecha:16/10/2023



## Tablero
- [x] Corregir el dialogo de comentario en el tablero que no habilita eliminar comentarios
- [x] Calcular la estimación de manera automática al ingresar las fechas de inicio y fin  en tablero

### Nuevas Funcionalidades

- [x] Eliminar el panel Atention de todos los formularios
- [x] Subir el tiempo de sesion a 4 horas

## Backlog
- [x] Corregir el dialogo de comentario en el backlog que no habilita eliminar comentarios
- [x] Validar que solo el colaborador asignado pueda mover, editar, archivar la tarjeta
- [x] Calcular la estimación de manera automatica al ingresar las fechas de inicio y finalizacion 


## Dashboard
- [x] Crear una opción de resumen de las tarjetas del colaborador en el dashboard
- [x] Crear un formulario Panel del trabajo que muestre todas las tarjetas de todos los proyectos que se invoque desde el Dashboard.
- [] Calcular la estimación de manera automática al ingresar las fechas de inicio y fin  en backlog



## General
- [x] Ajustar el cierre de sesion e indicar cuanto tiempo hace falta para que expire.


---
## Release: 1.0.b-17
**Fecha:05/10/2023

### Documentación
- [x] Documentar que se puede crear una tarjeta a partir de una tarea, es útil para dividir una actividad compleja en tarjeta.

## Reportes
- [x] Verificar, en reportes, el espacio entre comentario y el nombre del usuario
- [x] Verificar, en reportes, el tamaño del label de comentario
- [x] Ajustar las columnas de los formularios de reportes para hacer visible los botones de impresion

## Tablero
- [x] Ajustar el tablero cuando se ingresa desde un reporte al tablero y muestra los dialogos de tarjeta no se muestra el boton cerrar
- [x] Verificar que cuando se intenta agregar etiquetas, comentarios otareas y esta vacio el lis no agreagr nada.
- [x] Validar en el formulario de comentario que al dar enter no ejecute eventos o envie a guardar
- [x] Crear una tarjeta a partir de una tarea asignando los mismos colaboradores
- [x] Agregar opción de buscar tarjetas en el tablero



## Sprint
- [x] Crear una tarjeta a partir de una tarea asignando los mismos colaboradores
- [x] Agregar opción de buscar tarjetas en el backlog


## Backlog
- [x] Agregar opción de buscar tarjetas en el backlog


## General
- [x] Ajustar todos los formularios con rowexpansion aplicarles scrollPane para una mejor renderización


---
## Release: 1.0.b-16
**Fecha:21/09/2023

## Tablero
- [x] Mostrar siempre el botón de tareas en la barra inferior de la tarjeta para facilitar su uso
- [X] Cambiar el mensaje de Vista por detalles de tarjetas en el boton que muestra los detalles
- [x] Mostrar el boton editar desde el footer de la tarjeta
- [x] Agregar tabs al dialogo de edición de tarjetas para que se muestre de tamaño adecuado
- [x] Validar que solo el colaborador asignado pueda mover, editar, archivar la tarjeta


## Backlog
- [x] Cambiar el mensaje de Vista por detalles de tarjetas en el boton que muestra los detalles
- [x] Mostrar siempre el botón de tareas en la barra inferior de la tarjeta para facilitar su uso
- [x] Mostrar el boton editar desde el footer de la tarjeta
- [x] Agregar tabs al dialogo de edición de tarjetas para que se muestre de tamaño adecuado
- [x] Validar que solo el colaborador asignado pueda mover, editar, archivar la tarjeta

## General
- [x] Corregir el formulario documentation.xhtml que no se despliega



---
## Release: 1.0.b-15
**Fecha:20/09/2023

## Proyecto
 - [x] Modificar el inputText para ingresar el nombre del proyecto en el dialogo crear
 - [x] Modificar el inputText para ingresar el nombre del proyecto en el dialogo editar

## Tablero

- [x] Agregar un botón que muestre detalles de las tarjetas en el tablero
- [x] Aumentar el tamaño de la grafica que se muestra desde el tablero
- [x] Modificar el dialogo de editar tarjeta del tablero no se muestran los botones en el movil
- [x] Modificar el header de la tarjeta que se muestra en los dialogos del tablero
- [x] Modificar dialogo de clonar tarjetas
- [x] Modificar los dialogos que usan datatable colocando el inputText fuera de la tabla

## Backlog
 
- [x] Agregar un botón que muestre detalles de las tarjetas en el backlog
- [x] Modificar el dialogo de editar tarjeta del backlog no se muestran los botones en el movil
- [x] Modificar el header de la tarjeta que se muestra en los dialogos del tablero
- [x] Modificar dialogo de clonar tarjetas
- [x] Modificar los dialogos que usan datatable colocando el inputText fuera de la tabla
- [x] Verificar el formulario de reserva con fecha menor que el plan actual y verificar si permite moverlo y las fecha que coloca y mostrar boton de pasar al tablero


---
## Release: 1.0.b-14
**Fecha:19/09/2023

## Tablero
- [x] Ajustar el tamaño del dialogo agregar con descripción muy larga no muestra el botón guardar.
- [x] Modificar el formulario de crear tarjeta para que permita enviar email cuando se crea desde el mismo tablero.
- [x] Verificar la creación de tarjetas foráneas (Pide seleccionar el colaborador) y no la muestra en el tablero
- [x] Agregar de manera predeterminada la prioridad de las tarjeta a media
- [x] Cambiar el color de las tarjetas en base a la prioridad en el tablero


## Sprint
- [x] Verificar condición que al cerrar un Sprint no envía el mensaje que se proceso correctamente

## Backlog
-[x] Corregir el error que envía *Fecha final del Plan es menor que la fecha actual* cuando no hay sprint abierto- [x] Cambiar el color de las tarjetas en base a la prioridad en el tablero



---
## Release: 1.0.b-13
**Fecha:15/09/2023

### Nuevas Funcionalidades

## Tipo Tarjeta
- [x] Corregir que al editar un tipo de tarjeta siempre lo regresa a la primera pagina

## Tablero
- [x] Modificar el formulario de tablero para que cuando se desplacen las tarjetas a otra columna mantenga el orden descendente
- [x] Verificar el error que no muestra el calendario cuando se invoca desde el tablero
- [x] Verificar el error que no muestra la cronologia cuando se invoca desde el tablero
- [x] Modificar el tablero para que muestre el # de tarjeta aunque se oculten los detalles
- [x] Permitir ordenar las tarjeta en el tablero por varios atributos

## Backlog
- [x] Modificar el backlog para que muestre el # de tarjeta aunque se oculten los detalles
- [x] Permitir ordenar las tarjeta en el backlog por varios atributos

## General
- [x] Corregir los formularios que utilicen datatable con dialogos de edición para que al editarlo se mantenga en la  misma pagina
- [x] Agregar función al momento de crear tarjeta que elimina las comillas en el nombre de la tarjeta


---
## Release: 1.0.b-12
**Fecha:12/09/2023

### Nuevas Funcionalidades
- [x] Agregar a informacion.xhtml los pasos para grupo de tipo de tarjeta, como asignarlo a un proyecto y como se muestra en el tablero.


### Correcciones

## Cerrar Plan
- [] Revisar que se queda al cerrar el plan

## Proyectos
- [x] Modificar la entiad proyecto y agregar un list<> de GrupoTipoTarjeta y modificar los formularios de crear y editar proyecto
- [x] Agregar la opcion que permita indicar si permite o no duplicar tarjetas y validar en tablero y reserva
- [x] Mejorar dialogo de crear proyecto el tab otros se muestra distorcionado
- [x] Mejorar dialogo de editar proyecto el tab otros se muestra distorcionado
- [x] Ajustar al crear un proyecto colocar la fecha final por defecto con hora 11:59 pm del ultimo dia del año y la fecha inicial con hora 8:00 am
- [x] Ajustar el dialogo que muestra los permisos del proyecto



## Grupo tipo de tarjeta
-[x] Agregar grupo de tipo de tarjeta (entidad, repository, services, restclient)

## Tipo de tarjeta
 -[x] Modificar el entity Tipo de tarjeta y agregar referencia a GrupoTipoTarjeta
- [x] Agregar al formulario de tipo de tarjeta el grupo (modificar la entidad y agregar referencia)
- [x] En el proyecto el propietario selecciona los grupos de tipo de tarjeta que se usaran en ese proyecto
- [x] En el tablero mostrar solo los tipo de tarjeta filtrados por los grupos establecido en el proyecto


## Tablero
- [] Agregar al left menu la opción de crear tarjeta o actulizar un submenu cuando esta en el tablero. Para que no sea necesario desplazarse al inicio
- [x] Corregir el error que no permite guardar nuevas tarjetas
- [x] Agregar la opción que permita indicar si permite o no duplicar tarjetas y validar en tablero y reserva
- [x] Modificar el tablero para que solo muestre las tarjetas del grupo asignado al proyecto
- [x] Agregar colaboradores al crear tarjetas en el tablero

## Sprint
- [x] Ajustar al crear un Sprint colocar la fecha final por defecto con hora 11:59 pm del ultimo dia del año y la fecha inicial con hora 8:00 am


## Backlog
-[x] Modificar el backlog para que solo muestre las tarjetas del grupo asignado al proyecto
-[x] Agregar colaboradores al crear tarjetas en la reserva



---
## Release: 1.0.b-11
**Fecha:6/09/2023

### Nuevas Funcionalidades

### Correcciones
- [x] Verificar el formulario de cierre de Sprint que permite cerrarlo sin ingresar comentario.
- [x] Verificar el formulario de reserva con fecha menor que el plan actual y verificar si permite moverlo y las fecha que coloca y mostrar boton de pasar al tablero
- [x] Verificar el formulario de logros se queda congelado Fecha final del Plan es menor que la fecha actual
- [x] Modificar el formulario de cierre de sprint se queda congelado
- [x] Corregir el error que al cerrar el Sprint se queda congelado.
- [x] Ajustar el formulario login quitando el buscador de roles, para simplificar la vista
- [x] Modificar todos los datatable para hacerlos responsivos en móviles
- [x] Modificar los dialogos del formulario de Sprint con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Tablero con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Proyectos con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Tipo tarjetas con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Perfil con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Usuarios con scrollPanel para adaptación movil
- [x] Modificar los dialogos del formulario de Reportes con scrollPanel para adaptación movil
- [x] Cambiar todos los dialogos con scrollPane de todos los formularios del sistema
- [x] Probar todos los dialogos con scrollPane

## Tablero
- [x] Agregar la opcion de pasar del tablero a la reserva una tarjeta
- [x] Validar el envio de email al mover una tarjeta del tablero al backlog
- [x] Agregar un boton en el profile del tablero que lo lleve a la reserva


## Backlog
- [x] Agregar un boton en el profile de la reserva que lo lleve al tablero


---

## Release: 1.0.b-10
**Fecha:04/09/2023

### Nuevas Funcionalidades
- [x] Sincronizar automaticamente cuando se envia el mensaje que fue editado por otro usuario en el tablero
- [x] Sincronizar automaticamente cuando se envia el mensaje que fue editado por otro usuario en el sprint
- [x] Sincronizar automaticamente cuando se envia el mensaje que fue editado por otro usuario en el proyecto
- [x] Mostrar el detalle de las tarjetas sin colapsar al ingresar al tablero

### Correcciones
- [x] Ajustar el dashboard principal y no mostrar el mensaje de Otras Unidades si no existen proyectos de otras unidades disponibles
- [x] Cambiar el logo svg principal del sistema
- [x] Aplicar cambios en privilegios de la opción organigrama 
- [x] Corregir el error en el tablero en Mis tarjetas muestra en la columna finalizado lo de otros colaboradores
- [x] Corregir en envio de correo Proyecto: <b>. Enviado por: <b>.
- [x] Cuando la misma persona se remueve de la tarjeta no enviar el correo en el tablero.
- [x] Ajustar el formulario de Sprint quitando los objetivos dentro del componente
- [x] Ajustar el formulario de Tipo de tarjeta quitando los objetivos dentro del componente
- [x] Ajustar el formulario de tarjeta en el datatable comentario mejorando la vista de comentarios en columnas
- [x] Cambiar el texto del boton Archivo y Archivar en la tarjeta por Adjunto y Remover
- [x] Modificar el datatable comentario agregando el botón a la tarjeta
- [x] Modificar el datatable tarea agregando el botón a la tarjeta
- [x] Modificar el tablero validando la fecha final de la tarjeta si es menor que la del sprint actual, debe actualizarse a la fecha final del sprint.
- [x] Ampliar el rango de estimaciones para no restringuir el tiempo de las tarjetas
- [x] Mejorar el dialogo de edición de tarjetas simplificando el diseño
- [x] Ajustar el formato de fechas para incluir horas en todos los formularios
- [x] Modificar el formulario de reserva y quitar del repeat en detalletarjeta.xhtml los  <backlogdialogo:tarjetaclonar id="outputPanelTarjetaClonar"/> y demàs y colocarlos antes de la invocación
- [x] Revisar en proyectos foraneos y proyectos privados si usa el repeat y dentro de el esta los dialogos, quitarlos de alli y ponerlos en nivel superior
- [x] Verificar el tiempo de respuesta del sistema 
- [x] Validar que la fecha inicial no sea mayor que la fecha final al crear o editar tarjeta en tablero
- [x] Validar que la fecha inicial no sea mayor que la fecha final al crear o editar tarjeta en reserva
- [x] Validar que la fecha inicial no sea mayor que la fecha final al crear o editar proyecto
- [x] Validar que la fecha inicial no sea mayor que la fecha final al crear o editar sprint
- [x] Corregir el error que al presionar F5 lo envia a la pantalla de inicio
- [x] Modificar formulario crear y editar proyecto permitir la selección de horas
- [x] Modificar formulario crear y editar sprint permitir la selección de horas
- [x] Modificar la opción de agregar tarjeta en el tablero incluir "Descripcion/fechahorainicio /fechahorafin
- [x] Modificar la opción de agregar tarjeta en Reserva incluir "Descripcion/fechahorainicio /fechahorafin
- [x] Agregrar botones de desplazamiento a la tarjeta pendiente hasta finalizado y de finalizado hasta pendiente
- [x] Al enviar un email con la tarjeta agregar la descripción de la misma
- [x] Enviar email cuando se edita la tarjeta junto con la descripción
- [x] Colocar un mensaje que indique que se realizaron cambios por otro usuario y que debe sincronizar el tablero
- [x] Agregar el mensaje indicando el tiempo de sesion que queda para expirar.
- [x] Tablero al editar verificar que la fecha inicial puede ser menor del inicio del sprint
- [x] Editar el tablero de proyecto foraneo asignar automaticamente la fecha y hora y la estimación
- [x] Editar el formulario de  tablero para asignación automaticamente la fecha y hora y la estimación
- [x] Modificar el formulario de Tablero al agregar etiquetas si se agrega una y se elimina y se da clic en el botón Guardar no lo almacena 
- [x] Modificar el formulario de Backlog al agregar etiquetas si se agrega una y se elimina y se da clic en el botón Guardar no lo almacena 


---
## Release: 1.0.b-9
**Fecha:23/08/2023

### Nuevas Funcionalidades
- [x] Agregar nuevos iconos personalizados para identificar elementos
- [x] Agregar filtro para solo visualizar "Mis Tarjetas" en el tablero de trabajo

### Correcciones
- [x] Ajustar en el dashboard principal el espacio de texto antes de los proyectos
- [x] Agregar al dashoard en los proyectos privados y públicos un mensaje que indique no hay planes habilitados
- [x] Agregar en el menú superior un espacio entre los botones a la derecha en el sistema de flujo de tarjetas
- [x] Mejorar el formulario de login eliminando elementos de la barra derecha
- [x] Mejorar el diseño los elementos de la barra superior principal para una mejor disposición de los elementos
- [x] Corregir el formulario Impediementos que no lo despliega
- [x] Se muestra la fecha final del proyecto en el dashboard principal
- [x] Se mejoro el diseño del formulario de sesión expirada
- [x] Mejorar el diseño de la interfaz del sistema de flujo de tarjeta
- [x] Configurar nuevo email del sistema de flujo de tarjeta
- [x] Realizar cambios en la imagen SVG principal del sistema F.T.
- [x] Ajustar el tablero permitiendo el desplazamiento de las columnas


---
## Release: 1.0.b-8
**Fecha:18/08/2023

### Nuevas Funcionalidades
- [x] Actualizar el soporte para payara-micro:6.2023.8



### Correcciones
- [x] Corregir el error que se genera cuando un plan ya ha vencido su fecha final y se mantiene abierto
- [x] Corregir el error que se genera cuando un plan ya ha vencido su fecha final y se mantiene abierto y se ingresa a reserva




---
## Release: 1.0.b-7
**Fecha:17/08/2023

### Nuevas Funcionalidades
-[x] Agregar informaciòn de ayuda a los usuarios del sistema en la opción información.xhtml
-[x] Mejorar el diseño del tablero del sistema de flujo de tarjetas
-[x] Simplificar la barra de la plantilla permitiendo ocultarla/mostrarla. SFT
-[x] Mejorar el diseño de la barra de breadcrumb con las opciones de pagina
-[x] Agregar informaciòn de ayuda a los usuarios del sistema en la opción información.xhtml

### Correcciones
- [x] Aumentar el tamaño del nombre del proyecto en el tablero para que se muestre completo

---
## Release: 1.0.b-6
**Fecha:11/08/2023

### Nuevas Funcionalidades
- [x] Crear formulario Mi Calendario que permite ver al usuario logeado todos las tarjetas de todos los proyectos en que este trabajando
- [x] Implementar el control de sesión expirada en el sistema de flujo de tarjetas
- [x] Implementar el control de sesión expirada en el sistema de flujo de tarjetas
- [x] Crear formulario de información del sistema de flujo de tarjetas
- [x] Crear formulario de documentación del sistema de f.t


### Correcciones
- [x] Corregir el error al tratar de agregar un nuevo rol de usuario en el sistema s.f.
- [x] Revisar el Contador de reserva en dashboard que no esta mostrando la cantidad exacta de tarjetas en reserva
- [x] Realizar ajustes en el tablero de proyectos públicos el usuario foráneo no debe visualizar los iconos en la barra superior del tablero, solo se permite actualizar y crear tarjetas.
- [x] Corregir error en la opción de buscar tarjetas, muestra a un colaborador todas las tarjetas.
- [x] Corregir error .TableroFaces.sendEmailTarjeta Cannot invoke "String.equals(Object)" because "x" is null al mover una tarjeta foranea en el tablero

---
## Release: 1.0.b-5
**Fecha:**7/08/2023

### Nuevas Funcionalidades

- [x] Formulario mis tarjetas visualiza las tarjetas del usuario conectado con filtro
- [x] Formulario buscador de tarjetas visualiza las tarjetas por departamento usando cronograma
- [x] Modificar el formulario de proyectos y colecciones para agregar un atributo que indique si los colaboradores pueden ver tarjetas de otros colaboradores en proyectos privados.
- [x] Se actualizó el formulario de Reserva corrigiendo unos errores con el estado en reserva o no. Se eliminó la validación de plan cerrado en el formulario de reserva
- [x] Se actualizó primefaces a la versión v 13.0
- [x] Se cambiaron los componentes <p:repeat> por <ui:repeat>
- [x] Se actualizó a payara-micro-6.2023.7
- [x] Se implementó ajustes en los componentes dataTable
- [x] Se corrigió un error en el diseño que mostraba un símbolo > en el footer
- [x] Implementar filtro por usuarios en el formulario de administración de usuarios del sistema de flujo de tarjetas
- [x] Implementar filtro por tipo de tarjeta en el formulario de administración de tipo de tarjeta del sistema de flujo de tarjetas
- [x] Implementar filtro por rol en el formulario de administración de rol del sistema de flujo de tarjetas
- [x] Implementar filtro por departamento en el formulario de administración de departamento del sistema de flujo de tarjetas
- [x] Revisar los datatable soporte para lazyload con getRow() en el sistema de flujo de tarjetas. En el formulario Estadística Cierre por Colaborador
- [x] Revisar el evento de actualizar las tablas a la fila 0 de todos los formularios. S.F.T.
- [x] Crear Reporte de tarjetas creadas por usuarios foráneo en el sistema de flujo de tarjetas en Mis Reportes
- [x] Crear Reporte de tarjetas creadas por usuarios foráneo en el sistema de flujo de tarjetas en Reportes x Departamentos
- [x] Crear Reporte de tarjetas creadas por usuarios foráneo en el sistema de flujo de tarjetas en Reportes x Colaborador
- [x] Crear Reporte de tarjetas con impedimentos  en el sistema de Flujo de tarjetas modulo Mis Reportes
- [x] Crear Reporte de tarjetas con impedimentos  en el sistema de Flujo de tarjetas módulo  Reportes x Departamentos
- [x] Crear Reporte de tarjetas con impedimentos  en el sistema de Flujo de tarjetas módulo Reportes x Colaborador
- [x] Implementar opción de calendario en el tablero del sistema de flujo de trabajo
- [x] Implementar opción de calendario en el dashboard principal .s.f.t
- [x] Implementar opción de calendario de sprint dashboard principal .s.f.t
- [x] Agregar nueva funcionalidad en los proyectos que permita indicar si el colaborador puede ver todas las reservas
- [x] Realizar validacion en el calendario por sprint que no permita avanzar o retrocer en fechas despues del sprint.

### Correcciones
- [x] Mejora el formulario de tarjetas ajustando los tamaños de columnas
- [x] Se cambió el profile del tablero indicando en la parte superior el nombre del proyecto y en la parte inferior el prefijo.
- [x] Editar todos los diálogos e implementar un process="" del diálogo principal
- [x] Formulario de tarjetas se agregó rowExpansion y se incluyo información detallada de la tarjeta
- [x] Formulario de tarjetas foráneas se agregó rowExpansion y se incluyo información detallada de la tarjeta
- [x] Corregir error en el formulario Reserva después de migrar a la versión 13 de primefaces
- [x] Se valido que al quitar un colabordor de un proyecto y este tenia tarjetas asignadas, estas se muestran sin colaborador para permitir que otro colaborador las tome
- [x] Agregar  atributo descripción al formulario de cerrar sprint para dar mayor información al usuario y se permite mostrar los impedimentos encontrados
- [x] Implementar ajuste en el ancho de los componentes que se muestran en los formularios del sistema F.T.
- [x] Ajustar diseño del formulario de login sistema de flujo de tarjetas
- [x] Ajustar el tamaño con grid max de los formularios principales del sistema de flujo de tarjetas
- [x] Realizar corrección en el formulario de crear tarjetas de reserva para generar la estimación de manera automática.


---
## Release: 1.0.b-4
**Fecha:** 3/07/2023

### Nuevas Funcionalidades


- [x] Se creó el formulario **Olvido password**, que permite el cambio de password mediante el envío de un token al correo
- [x] Se creó una nueva colección llamada Organigrama que gestiona los departamentos y los departamentos que dependen del mismo, se utiliza para los reportes departamentales.
- [x] se actualizó el servidor a Payara-6.2023.6 
- [x] se creó el formulario para administrar el organigrama
- [x] Se generó el reporte mis proyectos para mostrar los proyectos del usuario registrado.
- [x] Se creó el reporte departamental que permite filtrar por los departamentos del organigrama
- [x] Se creó el reporte de colaborador departamental que permite filtrar por los departamentos del organigrama
- [x] Se creó el manual de usuario de Jefe de Unidad
- [x] Se creó el manual de usuario de Colaborador


### Correcciones
- [x] Se mejoró la interface UserServices y UserView Services usando Optional<> 
- [x] Se ajustó los Converter UserConverter/UserViewConverter para usar Optional<>
- [x] Se ajustó el formulario LoginController Los Converter UserConverter
- [x] En el formulario de crear/editar usuarios se valida que no se repita email y cédula del usuario,
- [x] En el formulario de perfil se valida que no se repita email y cédula del usuario,
- [x] En la barra principal se muestra el texto de Login o Salir dependiendo de si se ha iniciado sesión o no el usuario
- [x] Al realizarse tres intentos fallidos de acceso se redirecciona al formulario de cambiar el password
- [x] Se ajustó el menú de reportes con base en los perfiles de los usuarios
- [x] En el formulario de reportes de proyectos se valida los roles permitidos para otras acciones de los reportes
- [x] Se verifica que tenga registros para habilitar el botón de imprimir todos los registros en los formularios con datatable
- [x] En el formulario de Cronología, si es un colaborador se filtran los registros de ese usuario
- [x] En el dashboard principal se quitó el botón menú de Reserva para colaboradores, es una acción que solo el propietario del proyecto puede ejecutar
- [x] En el reporte de estadísticas de cierre por colaborador se agregó el filtro de resultados por el colaborador conectado excluyendo otros colaboradores.
- [x] Se revisó las opciones de menú con base en los perfiles del usuario conectado
- [x] Verificar que el total en reserva no coincide con el mostrado desde el menú reportes->proyectos opción Resumen
- [x] Se corrigió la opción de Resumen en el reporte de proyectos, y en el dashboard.
- [x] Se verificó el reporte de tarjetas en la sección columna, se muestra el texto Reserva cuando la tarjeta está en Reserva.
- [x] Se ajustaron los datatable para colocar el tamaño de columna a <p:column> style="width:10rem"> para columnas con contenido extenso
- [x] Se realizó una corrección en el framework jmoordb-core para generación de implementaciones de repositorios
- [x] Se verificó  los autocompletados múltiples que al quitar un elemento e intentar de seleccionarlo en la misma operación no mostraba si se había removido. En los formularios usuarios, proyectos
- [x] Se corrigió en formulario Perfil cambiando él autocompletado de Sede por un label
- [x] Se corrigió la opción de mostrar imágenes y archivos
- [x] Se corrigió el uso de imágenes con componentes <p:avatar>
- [x] Se modificó el formulario de Cronología, se ajustó la representación visual.
- [x] En el formulario organigrama al editarlo se deshabilita el departamento principal


---
## Release: 1.0.b-3

**Fecha:** 2/06/2023

### Nuevas Funcionalidades
- [x] Se creó el formulario de administración de roles
- [x]Se agregó un nuevo rol de SUPER-USER del sistema
- [x] Se creó el formulario de administración departamentos
- [x] Se agregaron nuevos perfiles para usuarios
- [x] Se agregó la opción Perfil para que el usuario pueda editar sus datos y cambiar su contraseña, cambiar su foto.
- [x] En la barra superior el usuario puede invocar el formulario de cambio de perfil al hacer clic en el avatar.
- [x] Se modificó el manejo de archivos, se soporta la migración a otros servidores de manera sencilla
- [x] Se modificó las opciones para subir y descargar archivos y se envía notificaciones sobre el proceso
- [x] Se actualizó la versión del servidor a Payara micro 6.2023.5
- [x] Se cambió el término Requisito por Reserva para especificar los componentes de Backlog con la finalidad de ser un término más entendible para los usuarios
- [x] Al crear una tarjeta de manera predeterminada se muestra la fecha final y la estimación de 05:30 hh:mm

#### Envió de Emails

- [x] Se creó un formulario que permite el envió de emails con archivos adjuntos a los colaboradores del proyecto que el emisor seleccione de la lista.
- [x] Cuando se asigna o remueve un colaborador de una tarjeta del *tablero* este recibe un email con la notificación correspondiente.
- [x] Cuando se asigna o remueve un colaborador de una tarjeta de la *Reserva* este recibe un email con la notificación correspondiente.
- [x] Al crear/editar un proyecto se envía correo a los colaboradores
- [x] Al agregar/eliminar un colaborador del proyecto se envía correo informando al respecto
- [x] Al crear, editar y cerrar un plan se envía email a todos los colaboradores del proyecto

#### Tarjetas foráneas
- [x] Cuando un colaborador genera una tarjeta en un proyecto foráneo al que él no pertenece, se le envía un correo al propietario del proyecto.
- [x] Cuando un usuario edita la tarjeta se envía un email a todos los colaboradores de la misma
- [x] Cuando un usuario agrega comentarios a la tarjeta se envía un email a todos los colaboradores de la misma
- [x]] Cuando un usuario mueve la tarjeta se envía un email a todos los colaboradores de la misma
- [x] Cuando un colaborador archiva la tarjeta se envía el email informando
- [x]  Cuando un colaborador sube un archivo a la tarjeta se envía el email informando


### Correcciones
- [x] Se corrigió en el formulario de proyectos el texto que especificaba colaborador, propietario, departamento y área que se mostraba dentro del mismo componente y no se visualizaba adecuadamente.
- [x] Se eliminó la imagen del usuario en el pie de página para que la carga inicial sea más rápida
- [x] En la sección inicial de miembros del equipo se omitió mostrar la foto y se muestra un Gravatar con el nombre

---
## Release: 1.0.beta-2

**Fecha:** 18/05/2023

### Nuevas Funcionalidades
- [x] Se cambió el menú izquierdo para reducir el tamaño que ocupaba el menú anterior
- [x] Se cambiaron los iconos de cierre de diálogos
- [x] En el panel principal se ajustó el borde de las tarjetas de proyectos
- [x] Se crearon componentes de los formularios para simplificar el diseño
- [x] Se mejoro el diseño del panel de mensaje cuando otro usuario ha realizado cambios sobre la misma tarjeta en que se está trabajando simultaneamente.
- [x] Las tareas finalizadas se muestran de color verde
- [x] Se colocaron títulos en las tarjetas con comentarios, impedimentos y etiquetas en el tablero y en el formulario de requisitos
- [x] Se creó el formulario para administración de usuarios
- [x] Se mejoró el diseño del formulario de creación de proyectos
- [x] Se actualizaron los videos con la nueva interface
### Correcciones
- [x] Se mejoró las opciones para centrar diálogos

---
## Release: 1.0.beta-1
**Fecha:** 8/05/2023

### Nuevas Funcionalidades

- [x] Creación, edición, clonación, reportes de proyectos
- [x] Creación, edición, clonación, cierres, reportes de planes
- [x] Administración del tablero
- [x] Creación, edición de tarjetas
- [x] Gestión de colaboradores, etiquetas, archivos, comentarios, impedimentos de las tarjetas
- [x] Administración de requisitos del proyecto
- [x] Gráficos estadísticos por plan y colaboradores
- [x] Reportes de proyectos, planes
- [x] Cronología del tablero
