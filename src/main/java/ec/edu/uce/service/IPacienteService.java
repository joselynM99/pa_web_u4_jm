package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {
	
	void insertar(Paciente paciente);

	Paciente buscar(Integer id);

	List<Paciente> buscarTodos();

	void actualizar(Paciente paciente);

	void eliminar(Integer id);

}
