package kr.co.spatialt.rdatgis.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.*;

import javax.sql.DataSource;

@Configuration
public class EgovConfigTransaction {

    @Primary
    @Bean("pgTxMgr")
    public DataSourceTransactionManager pgTxMgr(@Autowired @Qualifier(value = "pgDataSource") DataSource pgDataSource) {
        return new DataSourceTransactionManager(pgDataSource);
    }
}
