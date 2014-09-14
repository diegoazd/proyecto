package com.ayuda.ciudadana.dao

import com.ayuda.ciudadana.representation.Usuario
import com.ayuda.ciudadana.dao.mapper.UsuarioMapper

import org.skife.jdbi.v2.sqlobject.*
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

interface UsuarioDAO {
    @RegisterMapper(UsuarioMapper)
    @SqlQuery ("select id,firstName,lastName,phone,email from usuario where id = :id")
    Usuario getUsuarioById (@Bind ('id') long id)

    @GetGeneratedKeys
    @SqlUpdate ("""insert into usuario (id, firstName, lastName, phone, password, email)
            values (NULL, :firstName, :lastName, :phone, :password, :email)""")
    long creaUsuario (@Bind ("firstName") String firstName, @Bind ("lastName") lastName,
                       @Bind ("phone") String phone, @Bind("password") String password,
                       @Bind("email") String email)
}
