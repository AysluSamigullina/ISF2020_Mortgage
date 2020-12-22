package ru.isf.mortgage.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;


@Component
@ComponentScan("ru.isf.mortgage")
@EnableAsync
public class SpringConfig {
}
