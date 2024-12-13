package acc.br.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import acc.br.login.entity.EstudanteEntity;
import acc.br.login.repository.EstudanteRepository;


@Controller
public class EstudanteController {
	
	@Autowired
	private EstudanteRepository estudanteRepo;
	
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String form() {
		return "formEstudante";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String form(EstudanteEntity estudante) {
		estudanteRepo.save(estudante);
		return "redirect:/cadastrar";
	}
	
	@RequestMapping("/lista")
	public ModelAndView listaEstudantes() {
		ModelAndView model = new ModelAndView("lista");
		Iterable<EstudanteEntity> estudante = estudanteRepo.findAll();
		model.addObject("estudantes", estudante); //"estudantes" se refere ao ${estudantes} da lista.html.
		return model;
	}

}
