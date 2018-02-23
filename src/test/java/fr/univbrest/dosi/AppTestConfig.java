package fr.univbrest.dosi;

import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "fr.univbrest.dosi.repository")
@Import({ EmbeddedDataSourceConfiguration.class, HibernateJpaAutoConfiguration.class })
public class AppTestConfig {

}