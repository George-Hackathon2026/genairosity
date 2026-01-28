package com.genairosity.genairositybackend.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabricksConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${databricks.http.path}")
    private String httpPath;

    @Value("${databricks.token}")
    private String token;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setDriverClassName("com.databricks.client.jdbc.Driver");

        Properties props = new Properties();
        props.setProperty("httpPath", httpPath);
        props.setProperty("AuthMech", "3");
        props.setProperty("UID", "token");
        props.setProperty("PWD", token);

        config.setDataSourceProperties(props);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}