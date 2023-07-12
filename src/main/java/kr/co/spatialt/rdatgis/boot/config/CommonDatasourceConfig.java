package kr.co.spatialt.rdatgis.boot.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonDatasourceConfig {

    @Bean(name = "commonHikariConfig")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig commonHikariConfig() {
        return new HikariConfig();
    }
}
