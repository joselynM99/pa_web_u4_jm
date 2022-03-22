package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void insertar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);

	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.buscar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		return this.estudianteRepository.buscarTodos();
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

}
