package acc.br.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import acc.br.login.entity.LoginEntity;
import acc.br.login.repository.LoginRepository;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

/**
 * Controller for handling home and login routes.
 */
@Controller
public class HomeController {
	
	@Autowired
	private LoginRepository loginRepo;

	
	@RequestMapping(value="/registrar", method=RequestMethod.GET)
	public String formL() {
		return "registrar";
	}
	
	@RequestMapping(value="/registrar", method=RequestMethod.POST)
	public String formL(LoginEntity login) {
		loginRepo.save(login);
		return "redirect:/registrar";
	}
	
	//TEMPORARIO PARA TESTE
	@RequestMapping("/lista2")
	public ModelAndView listaLogin() {
		ModelAndView model = new ModelAndView("lista2");
		Iterable<LoginEntity> login = loginRepo.findAll();
		model.addObject("logins", login); //"logins" se refere ao ${logins} da lista2.html.
		return model;
	}

    /**
     * Handle GET requests to /login.
     * @return View name for login page
     */
    @GetMapping("/login")
    public String login() {
        return "login"; // Maps to login.html
    }
    
    
    /* 
    @PostMapping("/logar")
    public String loginUsuario(LoginEntity login, Model model, HttpServletResponse response) {
    	LoginEntity usuarioLog = this.loginRepo.login(login.getUsername(), login.getPassword());
    	if (usuarioLog != null) {
    		return "redirect:/registrar";
    	}
    	return "login";
    }
    */
    
   
}