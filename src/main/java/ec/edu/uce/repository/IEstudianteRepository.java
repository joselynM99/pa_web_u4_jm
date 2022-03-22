package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IEstudianteRepository {
	
	void insertar(Estudiante estudiante);

	Estudiante buscar(Integer id);

	List<Estudiante> buscarTodos();

	void actualizar(Estudiante estudiante);
	
	void eliminar(Integer id);
}
