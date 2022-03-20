package ec.edu.uce.hilos.paralelo;

import java.util.Arrays;

public class MainHilo {
	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();

		CajeroHilo cajero1 = new CajeroHilo("Delia", Arrays.asList(2, 2, 3, 4, 5));
		CajeroHilo cajero2 = new CajeroHilo("Carlos", Arrays.asList(1, 2, 2, 3));
		CajeroHilo cajero3 = new CajeroHilo("Juan", Arrays.asList(1, 2, 3, 5, 6));
		System.out.println("Hilo principal " + Thread.currentThread().getName());

		GestorAtencionHilo gestor1 = new GestorAtencionHilo(cajero1, tiempoInicial);
		GestorAtencionHilo gestor2 = new GestorAtencionHilo(cajero2, tiempoInicial);
		GestorAtencionHilo gestor3 = new GestorAtencionHilo(cajero3, tiempoInicial);

		gestor1.start();
		gestor2.start();
		gestor3.start();
		System.out.println("Hilo principal " + Thread.currentThread().getName());
		long tiempoFinal = System.currentTimeMillis();

		long timepoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(timepoTranscurrido + " seg");
	}
}
