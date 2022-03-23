package ec.edu.uce.controller;

import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("/buscar/{idEstudiante}")
//	@RequestMapping(path="/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		Estudiante estu = this.estudianteService.buscar(idEstudiante);
//		estu.setId(idEstudiante);
//		estu.setNombre("Joss");
//		estu.setApellido("Moncayo");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

	@GetMapping("/buscar/todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiante = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiante);
		return "lista";
	}

	@GetMapping("/estudianteNuevo")
	public String obtenerPaginaIngresoDatos() {

		return "estudianteNuevo";
	}

	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo) {

		this.estudianteService.insertar(estudiante);
		return "lista";
	}

}
