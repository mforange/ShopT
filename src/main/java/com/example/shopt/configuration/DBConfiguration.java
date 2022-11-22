package com.example.shopt.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari") // внедряет все настройки из application.properties которые начинаются на spring.datasource.hikari
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource();
    }

    @Bean
    @Primary // внедряет этот бин по умолчанию везде где можно внедрить бин ProxyDataSource
    public ProxyDataSource dataSource(HikariDataSource hikariDataSource,
                                      ProxyConfig proxyConfig) {
        ProxyDataSource proxyDataSource = new ProxyDataSource(hikariDataSource);
        proxyDataSource.setProxyConfig(proxyConfig);
        return proxyDataSource;
    }

    @Bean
    @Primary // внедряет этот бин по умолчанию везде где можно внедрить бин NamedParameterJdbcTemplate
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @Primary // внедряет этот бин по умолчанию везде где можно внедрить бин JdbcTemplate
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary // внедряет этот бин по умолчанию везде где можно внедрить бин DataSourceTransactionManager
    public DataSourceTransactionManager transactionManager(DataSource dataSource) { // для транзакций
        return new DataSourceTransactionManager(dataSource);
    }

    // все бины ниже - нужны для логирования обращений к бд в консоли
    @Bean
    public ProxyConfigSpringXmlSupport proxyConfigSupport(ChainListener queryListener) {
        ProxyConfigSpringXmlSupport proxyConfigSpringXmlSupport = new ProxyConfigSpringXmlSupport();
        proxyConfigSpringXmlSupport.setDataSourceName("dataSource");
        proxyConfigSpringXmlSupport.setQueryListener(queryListener);
        return proxyConfigSpringXmlSupport;
    }

    @Bean
    public ProxyConfig proxyConfig(ProxyConfigSpringXmlSupport proxyConfigSupport) {
        return proxyConfigSupport.create();
    }

    @Bean
    public ChainListener chainListener(ConnectionLoggingListener connectionLoggingListener) {
        ChainListener chainListener = new ChainListener();
        chainListener.addListener(connectionLoggingListener);
        return chainListener;
    }

    @Bean
    public ConnectionLoggingListener connectionLoggingListener() {
        return new ConnectionLoggingListener(new DefaultQueryLogEntryCreator());
    }

}
