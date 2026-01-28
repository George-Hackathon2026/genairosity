package com.genairosity.genairositybackend.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.dialect.JdbcArrayColumns;
import org.springframework.data.jdbc.core.dialect.JdbcDialect;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.*;
import org.springframework.data.relational.core.sql.IdentifierProcessing;
import org.springframework.data.relational.core.sql.render.SelectRenderContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJdbcRepositories(basePackages = "com.genairosity.genairositybackend.repository")
public class DatabricksConfig extends AbstractJdbcConfiguration {

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

    @Override
    public JdbcDialect jdbcDialect(NamedParameterJdbcOperations operations) {
        return new JdbcDialect() {
            private final Dialect delegate = AnsiDialect.INSTANCE;

            @Override
            public LimitClause limit() {
                return delegate.limit();
            }

            @Override
            public LockClause lock() {
                return delegate.lock();
            }

            @Override
            public JdbcArrayColumns getArraySupport() {
                return JdbcArrayColumns.Unsupported.INSTANCE;
            }

            @Override
            public IdentifierProcessing getIdentifierProcessing() {
                return IdentifierProcessing.NONE;
            }

            @Override
            public SelectRenderContext getSelectContext() {
                return delegate.getSelectContext();
            }

        };
    }
}