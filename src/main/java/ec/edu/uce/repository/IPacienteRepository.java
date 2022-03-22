package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepository {

	void insertar(Paciente paciente);

	Paciente buscar(Integer id);

	List<Paciente> buscarTodos();

	void actualizar(Paciente paciente);

	void eliminar(Integer id);

}
