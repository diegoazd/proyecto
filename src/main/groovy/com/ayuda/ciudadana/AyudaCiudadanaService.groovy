package com.ayuda.ciudadana

import com.ayuda.ciudadana.resources.UsuarioResource
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle
import com.yammer.dropwizard.migrations.MigrationsBundle

import org.skife.jdbi.v2.DBI
import com.yammer.dropwizard.jdbi.DBIFactory

class AyudaCiudadanaService extends Service<AyudaCiudadanaConfiguration> {
    public static void main(String[] args) throws Exception {
        new AyudaCiudadanaService().run(args)
    }

    HibernateBundle<AyudaCiudadanaConfiguration> hibernateBundle =
        new HibernateBundle<AyudaCiudadanaConfiguration>([]) {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(AyudaCiudadanaConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    MigrationsBundle<AyudaCiudadanaConfiguration> migrationsBundle =
        new MigrationsBundle<AyudaCiudadanaConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(AyudaCiudadanaConfiguration configuration) {
                return configuration.databaseConfiguration
            }
        }

    AssetsBundle assetsBundle = new AssetsBundle()

    @Override
    public void initialize(Bootstrap<AyudaCiudadanaConfiguration> bootstrap) {
        bootstrap.with {
            name = 'AyudaCiudadana'
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }

    @Override
    public void run(AyudaCiudadanaConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory ()
        final DBI jdbi = factory.build (environment,configuration.databaseConfiguration, "mysql")
        UsuarioResource usuarioResource = new UsuarioResource (jdbi)
        environment.addResource (usuarioResource)
    }
}
