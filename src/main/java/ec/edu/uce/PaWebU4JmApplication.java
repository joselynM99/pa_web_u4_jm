package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadService;

@SpringBootApplication
@EnableAsync
public class PaWebU4JmApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(PaWebU4JmApplication.class);
     
	@Autowired
	private IProcesamientoFacultadService facultadService;

	public static void main(String[] args) {
		SpringApplication.run(PaWebU4JmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long inicio = System.currentTimeMillis();
		//Procesamiento asincrono pero sin manejo de respuesta por cada hilo
//		Integer valor1 = this.facultadService.calcularDeuda("5841121", 4);
//		Integer valor2 = this.facultadService.calcularDeuda("54512", 4);
//		Integer valor3 = this.facultadService.calcularDeuda("87512", 4);
//		Integer valor4 = this.facultadService.calcularDeuda("54554", 4);

//		LOG.info("Valor 1: "+valor1);
		
		//Procesamiento asincrono pero CON manejo de respuesta por cada hilo

		CompletableFuture<Integer> valor1 = this.facultadService.calcularDeudaFuture("5841121", 4);
		CompletableFuture<Integer> valor2 = this.facultadService.calcularDeudaFuture("54512", 4);
		CompletableFuture<Integer> valor3 = this.facultadService.calcularDeudaFuture("87512", 4);
		CompletableFuture<Integer> valor4 = this.facultadService.calcularDeudaFuture("54554", 4);

		//Sentencia que espera que terminen de procesar todos los hilos
		CompletableFuture.allOf(valor1, valor2, valor3, valor4);
		
		LOG.info("Total: " + (valor1.get() + valor2.get() + valor3.get() + valor4.get()));
		long tFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tFinal - inicio) / 1000;

		LOG.info(tiempoTranscurrido + " seg");

	}

}
