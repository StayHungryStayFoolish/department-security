package io.github.stayhungrystayfoolish.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by bonismo@hotmail.com on 2018/9/3 下午9:30
 *
 * @Version: V1.0.0
 * <p>
 * Description:
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "io.github.stayhungrystayfoolish.bean")
@MapperScan(basePackages = "org.inklabsfoundation.inkapps.mapper", sqlSessionTemplateRef = "partnerSqlSessionTemplate")
public class ThreeDatabaseConfiguration {

    @Bean
    @ConfigurationProperties("three.datasource")
    public DataSourceProperties threeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "threeDataSource")
    @ConfigurationProperties("three.datasource")
    public DataSource threeDataSource() {
        return threeDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "threeTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(threeDataSource());
    }

    @Bean(name = "threeSqlSessionFactory")
    public SqlSessionFactory partnerSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(threeDataSource());
        String localMapper = "classpath:mappers/*.xml";
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
            getResources(localMapper));
        return sessionFactory.getObject();
    }

    @Bean(name = "partnerSqlSessionTemplate")
    public SqlSessionTemplate buildSqlSessionTemplate(@Qualifier("threeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "threeTransaction")
    public PlatformTransactionManager threeTransactionManager(@Qualifier("threeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
