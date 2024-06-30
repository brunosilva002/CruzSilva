package br.cruzsilva.CruzSilva.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.cruzsilva.CruzSilva.repository.masterDataBase",
        entityManagerFactoryRef = "masterDataBaseEntityManagerFactory",
        transactionManagerRef = "masterDataBaseTransactionManager"
)
public class MasterDataBaseConfiguration {

    @Bean(name = "masterDataBase")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "masterDataBaseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("masterDataBase") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("br.cruzsilva.CruzSilva.model.masterDataBase");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Configuração adicional do Hibernate
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
        properties.put("hibernate.use_sql_comments", "true");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "masterDataBaseTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("masterDataBaseEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        return new JpaTransactionManager(mysqlEntityManagerFactory.getObject());
    }
}
