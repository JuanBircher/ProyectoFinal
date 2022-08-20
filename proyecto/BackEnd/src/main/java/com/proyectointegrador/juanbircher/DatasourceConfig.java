package com.proyectointegrador.juanbircher;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    //LOCAL
    private final String DB_HOST_URI = "jdbc:mysql:mysql://ubtpdf9rnevkim2s:OLFrBzQjImAYr3nuand5@btqo9pspy889pu5qcpfp-mysql.services.clever-cloud.com:3306/btqo9pspy889pu5qcpfp";
    private final String DB_PASSWORD="OLFrBzQjImAYr3nuand5";
    private final String DB_USER="ubtpdf9rnevkim2s";

    /*Productive
    private final String DB_HOST_URI = "jdbc:mysql://btqo9pspy889pu5qcpfp-mysql.services.clever-cloud.com:3306/btqo9pspy889pu5qcpfp" +
    private final String DB_PASSWORD="OLFrBzQjImAYr3nuand5";
    private final String DB_USER="ubtpdf9rnevkim2s";
   */
@Bean
    public DataSource datasource(){
    return DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url(DB_HOST_URI)
            .username(DB_USER)
            .password(DB_PASSWORD)
            .build();
    }
}
