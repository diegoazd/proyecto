package com.ayuda.ciudadana

import com.fasterxml.jackson.annotation.JsonProperty
import com.yammer.dropwizard.config.Configuration
import com.yammer.dropwizard.db.DatabaseConfiguration

import javax.validation.Valid
import javax.validation.constraints.NotNull

class AyudaCiudadanaConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration()
}
