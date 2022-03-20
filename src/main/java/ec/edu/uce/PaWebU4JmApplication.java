package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultadService;

@SpringBootApplication
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
		Integer valor1 = this.facultadService.calcularDeuda("5841121", 4);
		Integer valor2 = this.facultadService.calcularDeuda("54512", 4);
		Integer valor3 = this.facultadService.calcularDeuda("87512", 4);
		Integer valor4 = this.facultadService.calcularDeuda("54554", 4);

		LOG.info("Total: " + (valor1 + valor2 + valor3 + valor4));
		long tFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tFinal-inicio)/1000;
		
		LOG.info(tiempoTranscurrido+" seg");
		
	}

}
