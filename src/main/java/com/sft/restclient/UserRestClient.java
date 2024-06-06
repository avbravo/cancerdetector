/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sft.restclient;

import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordbcoreencripter.jmoordbencripter.Encryptor;
import com.sft.model.User;
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
@Path("/user")
@ClientHeaderParam(name = "Authorization", value = "{lookupAuth}")
//@ApplicationScoped
public interface UserRestClient {

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

    public List<User> findAll();
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="User findByIduser(@PathParam("iduser") Long iduser)">
    @GET
    @Path("{iduser}")
    public User findByIduser(@Parameter(description = "El iduser", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("iduser") Long iduser);
// </editor-fold>

//    // <editor-fold defaultstate="collapsed" desc="User findByUsername(final String username)">
    @GET
    @Path("username")
    public User findByUsername(@Parameter(description = "El username", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @QueryParam("username") final String username);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="User findByEmail(@QueryParam("email") final String email)">
    @GET
    @Path("email")
    public User findByEmail(@QueryParam("email") final String email);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="User findByIdentificationcard(@QueryParam("identificationcard") final String identificationcard)">
    @GET
    @Path("identificationcard")
    public User findByIdentificationcard(@QueryParam("identificationcard") final String identificationcard);
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST

    public Response save(@RequestBody(description = "Crea un nuevo user.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) User user);
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT

    public Response update(@RequestBody(description = "Crea un nuevo user.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) User user);

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{iduser}")

    public Response delete(@Parameter(description = "El elemento iduser", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("iduser") Long iduser);

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<User> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort,  @QueryParam("page") Integer page, @QueryParam("size") Integer size)">
    @GET
    @Path("lookup")
    public List<User> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size);

    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size);">
    @GET
    @Path("count")
    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size);
    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="List<User> likeByName(@QueryParam("name") String name)">

    @GET
    @RolesAllowed({"admin"})
    @Path("likebyname")
    public List<User> likeByName(@QueryParam("name") String name);
    // </editor-fold>
}
