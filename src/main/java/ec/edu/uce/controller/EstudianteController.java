package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@RequestMapping("/buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		Estudiante estu = this.estudianteService.buscar(idEstudiante);
//		estu.setId(idEstudiante);
//		estu.setNombre("Joss");
//		estu.setApellido("Moncayo");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

}
