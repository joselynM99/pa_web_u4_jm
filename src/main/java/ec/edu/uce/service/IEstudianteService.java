package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IEstudianteService {

	void insertar(Estudiante estudiante);

	Estudiante buscar(Integer id);

	List<Estudiante> buscarTodos();

	void actualizar(Estudiante estudiante);

	void eliminar(Integer id);
}
