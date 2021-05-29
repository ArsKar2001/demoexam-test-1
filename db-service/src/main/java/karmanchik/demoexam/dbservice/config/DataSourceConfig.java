package karmanchik.demoexam.dbservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "karmanchik/demoexam/dbservice/models")
@EnableJpaRepositories(basePackages = "karmanchik.demoexam.dbservice.daos")
public class DataSourceConfig {
}
