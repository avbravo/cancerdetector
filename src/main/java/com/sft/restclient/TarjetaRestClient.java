/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.restclient;

import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.sft.model.Tarjeta;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.ConfigValue;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author avbravo
 */
@RegisterRestClient()
@Path("/tarjeta")
@ClientHeaderParam(name = "Authorization", value = "{lookupAuth}")
//@ApplicationScoped
public interface TarjetaRestClient {

     // <editor-fold defaultstate="collapsed" desc="lookupAuth()">
    default String lookupAuth() {
        /**
         * *
         * Leer las configuraciones del archivo microprofile-config.properties
         */

        String secretKey = "SCox1jmWrkma$*opne2Amwz";

        Config config = ConfigProvider.getConfig();

        String userSecurity = config.getValue("userSecurity", String.class);

        // or
        ConfigValue passwordSecurity = config.getConfigValue("passwordSecurity");

           //        String userDecrypted = Encryptor.decrypt(userSecurity, secretKey,FacesUtil.nameOfClassAndMethod());ç
//String passwordDecrypted = Encryptor.decrypt(passwordSecurity.getValue(), secretKey,FacesUtil.nameOfClassAndMethod());
        String userDecrypted = userSecurity;
        String passwordDecrypted = passwordSecurity.getValue();
        return "Basic "
                + Base64.getEncoder().encodeToString((userDecrypted + ":" + passwordDecrypted).getBytes());
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Tarjeta> findAll();
// </editor-fold>


      @GET
    @Path("idtarjetaidproyecto")
    public Tarjeta findByIdtarjetaIdproyecto(@QueryParam("idtarjeta") Long idtarjeta, @QueryParam("idproyecto") Long idproyecto);



    

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST

    public Response save(@RequestBody(description = "Crea un nuevo tarjeta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Tarjeta.class))) Tarjeta tarjeta);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT

    public Response update(@RequestBody(description = "Actualiza la tarjeta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Tarjeta.class))) Tarjeta tarjeta);

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("idtarjetaidproyecto")

       public Response delete(@QueryParam("idtarjeta") Long idtarjeta, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc=Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idproyecto") Long idproyecto)">
     @DELETE
     @Path("deletemany")
  public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idproyecto") Long idproyecto);
  // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort,  @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idproyecto") Long idproyecto)">
    @GET
    @Path("lookup")
    public List<Tarjeta> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>    
    
    
 // <editor-fold defaultstate="collapsed" desc="public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idproyecto") Long idproyecto);">
    @GET
    @Path("count")
    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Long countLikeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("idproyecto") Long idproyecto)">
    @GET
   @Path("countlikebytarjeta")
     public Long countLikeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>    
 
    // <editor-fold defaultstate="collapsed" desc="Long countLikeByDescripcion(@QueryParam("descripcion") String descripcion, @QueryParam("idproyecto") Long idproyecto)">
    @GET
   @Path("countlikebydescripcion")
     public Long countLikeByDescripcion(@QueryParam("descripcion") String descripcion, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>    
 

// <editor-fold defaultstate="collapsed" desc="public List<Tarjeta> likeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("idproyecto") Long idproyecto)">

    @GET
    @Path("likebytarjeta")
    public List<Tarjeta> likeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="public List<Tarjeta> likeByTarjetaPagination(@QueryParam("tarjeta") String tarjeta, @QueryParam("pagination") Pagination pagination,@QueryParam("idproyecto") Long idproyecto)">

    @GET
    @Path("likebytarjetapagination")
    public List<Tarjeta> likeByTarjetaPagination(@QueryParam("tarjeta") String tarjeta, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>


// <editor-fold defaultstate="collapsed" desc="List<Tarjeta> likeByDescripcion(@QueryParam("descripcion") String descripcion,@QueryParam("idproyecto") Long idproyecto)">

    @GET
    @Path("likebydescripcion")
    public List<Tarjeta> likeByDescripcion(@QueryParam("descripcion") String descripcion,@QueryParam("idproyecto") Long idproyecto);
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Tarjeta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal,@QueryParam("idproyecto") Long idproyecto)">
      @GET
    @Path("betweendate")
    public List<Tarjeta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal,@QueryParam("idproyecto") Long idproyecto) ;
    // </editor-fold>
    
    
    
    @GET
    @Path("likebytarjetasearch")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Tarjeta> searchLikeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idproyecto") Long idproyecto);
    
   
    @GET
    @Path("searchcountlikebytarjeta")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public  Long searchCountLikeByTarjeta(@QueryParam("tarjeta") String tarjeta, @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idproyecto") Long idproyecto);

   
    @GET
    @Path("likebydescripcionsearch")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Tarjeta> searchLikeByDescripcion(@QueryParam("descripcion") String descripcion, @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idproyecto") Long idproyecto);
    
    
    @GET
    @Path("searchcountlikebydescripcion")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public  Long searchCountLikeByDescripcion(@QueryParam("descripcion") String descripcion, @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idproyecto") Long idproyecto);
}
