package com.ayuda.ciudadana.dao.mapper

import com.ayuda.ciudadana.representation.Usuario
import java.sql.SQLException

import org.skife.jdbi.v2.tweak.ResultSetMapper
import org.skife.jdbi.v2.StatementContext

import java.sql.ResultSet
import java.sql.SQLException

class UsuarioMapper implements ResultSetMapper<Usuario>{
    Usuario map (int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Usuario (r.getLong ('id'),
                r.getString ('firstName'),
                r.getString ('lastName'),
                r.getString ('phone'),
                r.getString('email'))
    }
}
