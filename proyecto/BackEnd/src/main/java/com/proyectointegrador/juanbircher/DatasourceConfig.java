package com.proyectointegrador.juanbircher;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
@Bean
    public DataSource datasource(){
    return DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://btqo9pspy889pu5qcpfp-mysql.services.clever-cloud.com:3306/btqo9pspy889pu5qcpfp")
            .username("ubtpdf9rnevkim2s")
            .password("OLFrBzQjImAYr3nuand5")
            .build();
    }
}
