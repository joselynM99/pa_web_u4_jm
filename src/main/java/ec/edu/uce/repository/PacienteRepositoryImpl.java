package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public List<Paciente> buscarTodos() {
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("select p from Paciente", Paciente.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		Paciente pacienteABorrar = this.buscar(id);
		this.entityManager.remove(pacienteABorrar);
	}

}
