package com.ayuda.ciudadana.resources

import com.ayuda.ciudadana.dao.UsuarioDAO

import javax.ws.rs.*
import javax.ws.rs.core.*
import org.skife.jdbi.v2.DBI
import javax.validation.Valid
import com.ayuda.ciudadana.representation.Usuario

@Path('/usuario')
@Produces(MediaType.APPLICATION_JSON)
class UsuarioResource {
    private final UsuarioDAO usuarioDao

    public UsuarioResource (DBI jdbi){
        usuarioDao = jdbi.onDemand (UsuarioDAO.class)
    }

    @GET
    @Path('/{id}')
    Response getContact(@PathParam ('id') long id){
      Usuario usuario = usuarioDao.getUsuarioById(id)
      return Response.ok(usuario).build()
    }

    @POST
    Response createContact (@Valid Usuario usuario) throws URISyntaxException {
        long usuarioId  = usuarioDao.creaUsuario (usuario.firstName, usuario.lastName, usuario.phone,
                usuario.password, usuario.email)
        return Response.created (
                UriBuilder.fromResource(UsuarioResource.class)
                        .build(usuarioId)
        ).build ()
    }
}
