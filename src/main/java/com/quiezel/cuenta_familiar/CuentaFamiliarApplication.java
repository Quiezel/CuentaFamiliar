package com.quiezel.cuenta_familiar;

import com.quiezel.cuenta_familiar.controller.Inicio;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CuentaFamiliarApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CuentaFamiliarApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        Inicio base = context.getBean(Inicio.class);
        base.load();
    }

}
