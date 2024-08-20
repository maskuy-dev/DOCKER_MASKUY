/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author magnaadmin
 */
@Configuration
@EnableScheduling
@PropertySource({"classpath:database.properties"})
public class WebConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driver}")
    private String driver;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        try {
//            String realPass = CryptoSecurity.decrypt(password);
            dataSource.setPassword(password);
        } catch (Exception ex) {
            Logger.getLogger(WebConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        String[] packageToScan = new String[]{
            "msiwms.model"
        };
        sessionFactory.setPackagesToScan(packageToScan);
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
//                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            }
        };
    }

}
