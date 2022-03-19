package ec.edu.uce.hilos;

import java.util.concurrent.TimeUnit;

public class GestorAtencion {

	public void procesar(Cajero cajero, long tiempoInicial) {
		System.out.println("Inicia atender cajero: " + cajero.getNombre());
		for (Integer tiempo : cajero.getClientes()) {
			this.atenderCliente(tiempo);

		}
		System.out.println("Termina atender cajero: " + cajero.getNombre());
		long timepoTranscurrido = (System.currentTimeMillis() - tiempoInicial) / 1000;
		System.out.println(timepoTranscurrido + " seg de atencion por: " + cajero.getNombre());
	}

	public void atenderCliente(Integer tiempo) {
		System.out.println("Atendiendo a cliente: " + tiempo);
		System.out.println("Hilo: "+Thread.currentThread().getName());
		try {
			// Se demora en la atencion
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
