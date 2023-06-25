package com.soroksorokk.soroksorokk.common;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@Configuration
public class MysqlContainerTest {
    private static final MySQLContainer mySQLContainer = new MySQLContainer(DockerImageName.parse("mysql:8.0"))
            .withDatabaseName("test")
            .withUsername("user")
            .withPassword("password");

    static {
        mySQLContainer.start();
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(mySQLContainer.getDriverClassName())
                .url(mySQLContainer.getJdbcUrl())
                .username(mySQLContainer.getUsername())
                .password(mySQLContainer.getPassword())
                .build();
    }
}
