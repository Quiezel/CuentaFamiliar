package com.quiezel.cuenta_familiar;

import com.quiezel.cuenta_familiar.controller.Inicio;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CuentaFamiliarApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CuentaFamiliarApplication.class);
        builder.headless(false);
        context = builder.run(args);
    }

    @Bean
    public Inicio inicio() {
        return new Inicio(context);
    }

//        @Bean
//        public CommandLineRunner demo(MovimientoRepo repo){
//            return (args) -> {
//                repo.save(new Movimiento("Sueldo", new BigDecimal("3000.00")));
//                repo.save(new Movimiento("Sueldo", new BigDecimal("3500.00")));
//                repo.save(new Movimiento("ahorro", new BigDecimal("-2000.00")));
//                repo.save(new Movimiento("Peque", new BigDecimal("-700.00")));
//                repo.save(new Movimiento("Gasolina", new BigDecimal("-400.00")));
//                repo.save(new Movimiento("Internet", new BigDecimal("-200.00")));
//                
//                System.out.println("Ver movimientos");
//                List<Movimiento> movimientos = new ArrayList<>();
//                for (Movimiento movimiento : repo.findAll()) {
//                    movimientos.add(movimiento);
//                    System.out.println(movimiento);
//                }
//                
//                System.out.println();
//                System.out.println("");
//                System.out.println("suma: " + 
//                        movimientos.stream()
//                .mapToDouble(m -> m.getMonto().doubleValue())
//                .sum());
//            };
//        }
}
