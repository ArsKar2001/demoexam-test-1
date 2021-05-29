package karmanchik.demoexam.uijfx.config;

import karmanchik.demoexam.dbservice.config.DataSourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {DataSourceConfig.class})
public class AppConfig {
}
