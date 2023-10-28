package br.com.wesley.dividas.controller;

import br.com.wesley.dividas.dao.LoteDao;
import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.model.carnaval.Lote;
import br.com.wesley.dividas.util.Functions;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
public class SistemaController {

	int segundo = 1000;

	int minuto = segundo * 60;

	int hora = minuto * 60;

	int dia = hora * 24;

	int ano = 365 * dia;

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

	private TaskScheduler scheduler = new ConcurrentTaskScheduler();

	@PostConstruct
	private void cadastraLotes(){


		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				LoteDao dao = new LoteDao();

				List<Lote> lotes = dao.getAllLote();

				if(lotes == null  || lotes.isEmpty()){

					Lote l1 = new Lote();
					l1.setDescricao("Primeiro Lote");

					Lote l2 = new Lote();
					l2.setDescricao("Segundo Lote");

					Lote l3 = new Lote();
					l3.setDescricao("Terceiro Lote");

					Lote l4 = new Lote();
					l4.setDescricao("Ultimo Lote");

					dao.inserir(l1);
					dao.inserir(l2);
					dao.inserir(l3);
					dao.inserir(l4);

				}
			}
		}, 10 * ano);

	}

}
