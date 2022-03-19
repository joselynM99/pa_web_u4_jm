package ec.edu.uce.hilos;

import java.util.List;

public class Cajero {
	private String nombre;
	private List<Integer> clientes;

	/**
	 * @param nombre
	 * @param clientes
	 */
	public Cajero(String nombre, List<Integer> clientes) {
		super();
		this.nombre = nombre;
		this.clientes = clientes;
	}

	// Metodos set y get
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Integer> getClientes() {
		return clientes;
	}

	public void setClientes(List<Integer> clientes) {
		this.clientes = clientes;
	}

}
