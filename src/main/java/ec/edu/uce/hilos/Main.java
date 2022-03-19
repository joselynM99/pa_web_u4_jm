package ec.edu.uce.hilos;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("Delia", Arrays.asList(2, 2, 3, 4, 5));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList(1, 2, 2, 3));
		Cajero cajero3 = new Cajero("Juan", Arrays.asList(1, 2, 3, 5, 6));

		GestorAtencion gestor1 = new GestorAtencion();
		GestorAtencion gestor2 = new GestorAtencion();
		GestorAtencion gestor3 = new GestorAtencion();

		gestor1.procesar(cajero1, tiempoInicial);
		gestor2.procesar(cajero2,tiempoInicial);
		gestor3.procesar(cajero3,tiempoInicial);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long timepoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(timepoTranscurrido + " seg");
	}

}
