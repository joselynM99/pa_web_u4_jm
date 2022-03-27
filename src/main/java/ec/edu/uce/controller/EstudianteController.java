package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes/")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("buscar/{idEstudiante}")
//	@RequestMapping(path="/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		Estudiante estu = this.estudianteService.buscar(idEstudiante);
//		estu.setId(idEstudiante);
//		estu.setNombre("Joss");
//		estu.setApellido("Moncayo");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

	@GetMapping("todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiante = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiante);
		return "lista";
	}

	@GetMapping("estudianteNuevo")
	public String obtenerPaginaIngresoDatos(Estudiante estudiante) {

		return "estudianteNuevo";
	}

	@PostMapping("insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {

		this.estudianteService.insertar(estudiante);
		return "redirect:todos";
	}

	@GetMapping("estudianteActualiza/{idEstudiante}")
	public String obtenerPaginaActualizarDAtos(@PathVariable("idEstudiante") Integer idEstudiante,
			Estudiante estudiante, Model modelo) {
		Estudiante estu = this.estudianteService.buscar(idEstudiante);
		modelo.addAttribute("estu", estu);
		return "estudianteActualiza";
	}

	@PutMapping("actualizar/{idEstudiante}")
	public String actualizarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante, Model modelo) {
		estudiante.setId(idEstudiante);
		this.estudianteService.actualizar(estudiante);

		List<Estudiante> listaEstudiante = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiante);
		return "redirect:/estudiantes/todos";
	}

	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		this.estudianteService.eliminar(idEstudiante);
		
		List<Estudiante> listaEstudiante = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiante);

		return "redirect:/estudiantes/todos"; 
	}

}
