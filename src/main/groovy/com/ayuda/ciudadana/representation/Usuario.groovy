package com.ayuda.ciudadana.representation

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import com.fasterxml.jackson.annotation.JsonIgnore


/**
 * Created by diegorlz on 14/09/14.
 */
class Usuario {
    final int id

    @NotBlank
    @Length (min=2, max=255)
    final String firstName

    @NotBlank
    @Length (min=2, max=255)
    final String lastName

    @NotBlank
    @Length (min=7, max=15)
    final String phone

    @NotBlank
    @Length (min=2, max=100)
    final String password

    @NotBlank
    @Length (min=2, max=100)
    final String email

    Usuario(id,firstName, lastName, phone, password, email){
        this.id = id
        this.lastName = lastName
        this.firstName = firstName
        this.phone = phone
        this.password = password
        this.email = email
    }

    Usuario(id,firstName, lastName, phone, email){
      this.id = id
      this.lastName = lastName
      this.firstName = firstName
      this.phone = phone
      this.email = email
    }

    Usuario(){
        this.id = 0
        this.lastName = null
        this.firstName = null
        this.phone = null
        this.email = null
    }
}
