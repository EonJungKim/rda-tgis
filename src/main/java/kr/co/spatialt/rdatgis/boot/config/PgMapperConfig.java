package kr.co.spatialt.rdatgis.boot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "kr.co.spatialt.rdatgis.*.mapper.pg", sqlSessionFactoryRef = "pgSqlSessionFactory")
@EnableTransactionManagement
public class PgMapperConfig {

    @Autowired
    @Qualifier(value = "pgDataSource")
    private DataSource pgDataSource;

    @Bean
    @Primary
    public SqlSessionFactory pgSqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource(pgDataSource);
        ssfb.setMapperLocations(applicationContext.getResources("classpath:/egovframework/sqlmap/pg/mappers/*/*.xml"));
        ssfb.setConfigLocation(applicationContext.getResource("classpath:/egovframework/sqlmap/pg/config/sql-mapper-config.xml"));
        return ssfb.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate pgSqlSessionTemplate(SqlSessionFactory pgSessionFactory) throws Exception {
        return new SqlSessionTemplate(pgSessionFactory);
    }

}
