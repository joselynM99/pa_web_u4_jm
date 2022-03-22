package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepository;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepository pacienteRepository;

	@Override
	public void insertar(Paciente paciente) {
		this.pacienteRepository.insertar(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.pacienteRepository.buscar(id);
	}

	@Override
	public List<Paciente> buscarTodos() {
		return this.pacienteRepository.buscarTodos();
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		this.pacienteRepository.eliminar(id);
	}

}
