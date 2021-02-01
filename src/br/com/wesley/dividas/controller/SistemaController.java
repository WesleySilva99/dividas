package br.com.wesley.dividas.controller;

import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.util.Functions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SistemaController {
	
	@RequestMapping("/")
	public String inicio() {
		
		return "index";
		
	}

	@RequestMapping("inicioSistema")
	public String inicioLogado(HttpSession session, Model model) {

		Usuario u = (Usuario) session.getAttribute("usuarioLogado");

		Functions.carregar(u, model);

		return "sistema/index";

	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "index";

	}
	

}
