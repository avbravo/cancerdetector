/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.restclient;

import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.sft.model.Applicative;
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
@Path("/applicative")
@ClientHeaderParam(name = "Authorization", value = "{lookupAuth}")
//@ApplicationScoped
public interface ApplicativeRestClient {

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
    public List<Applicative> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Applicative findByIdapplicative">
    @GET

    @Path("{idapplicative}")

    public Applicative findByIdapplicative(@Parameter(description = "El idapplicative", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idapplicative") Long idapplicative);

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST

    public Response save(
            @RequestBody(description = "Crea un nuevo applicative.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Applicative.class))) Applicative applicative);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT

    public Response update(
            @RequestBody(description = "Crea un nuevo applicative.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Applicative.class))) Applicative applicative) ;
// </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Response delete">
        @DELETE
           @Path("{idapplicative}")
        public Response delete ( @PathParam("idapplicative") Long idapplicative ) ;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="List<Applicative> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size)">

    @GET
        @Path("lookup")

        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

        public List<Applicative> lookup
        (@QueryParam("filter")
        String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size
    

) ;
      

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size);">
    @GET
    @Path("count")
    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size);
    // </editor-fold>    
    
    
    
       // <editor-fold defaultstate="collapsed" desc="Long countLikeByApplicative(@QueryParam("applicative") String applicative)">
    @GET
    @Path("countlikebyapplicative")
    public Long countLikeByApplicative(@QueryParam("applicative") String applicative);
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Applicative> likeByApplicative(@QueryParam("applicative") String applicative)">

    @GET
    @Path("likebyapplicative")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Applicative> likeByApplicative(@QueryParam("applicative") String applicative);
    // </editor-fold>
    }
