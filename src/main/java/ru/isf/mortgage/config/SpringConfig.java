package ru.isf.mortgage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import ru.isf.mortgage.repo.RepozitoryConfig;
import ru.isf.mortgage.service.ServiceConfig;

@Component
@ComponentScan("ru.isf.mortgage")
//@Import({RepozitoryConfig.class, ServiceConfig.class})
public class SpringConfig {
}
