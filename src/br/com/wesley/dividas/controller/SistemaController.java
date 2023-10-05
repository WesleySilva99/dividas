package br.com.wesley.dividas.controller;

import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.util.Functions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class SistemaController {

	Functions biblioteca = new Functions();

	@RequestMapping("/")
	public String inicio() {
		
		return "index";
		
	}

	@RequestMapping("inicioSistema")
	public String inicioLogado(HttpSession session, Model model) throws ParseException {

		Usuario u = (Usuario) session.getAttribute("usuarioLogado");

		biblioteca.carregar(u, model);

		return "sistema/index";

	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "index";

	}
	

}
