package ec.edu.uce.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreams {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		List<Integer> lista = new ArrayList<>();

		for (int i = 1; i < 1000; i++) {
			lista.add(i);
		}

		List<String> listaS = lista.stream().map(numero -> convertirNumero(numero)).collect(Collectors.toList());
		listaS.forEach(System.out::println);
		long fin = System.currentTimeMillis();
		
		long tiempo =(fin-inicio)/1000;
		System.out.println("Tiempo total: "+tiempo+" seg");
	}

	private static String convertirNumero(Integer numero) {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "N: " + numero.toString();
	}

}
