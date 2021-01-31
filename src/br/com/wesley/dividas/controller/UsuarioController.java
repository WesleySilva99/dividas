package br.com.wesley.dividas.controller;


import br.com.wesley.dividas.dao.UsuarioDao;
import br.com.wesley.dividas.model.Renda;
import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.util.Functions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsuarioController {

    Functions biblioteca = new Functions();

    @RequestMapping("exibirInserirUsuario")
    public String exibirInserir() {

        return "/usuario/inserir";

    }

    @RequestMapping("inserirUsuario")
    public String inserir(Usuario u, Model model,
                          @RequestParam(name = "valor") String[] valores, @RequestParam(name = "isSalario") String[] isSalario) {

        String caminho = "";

        List<Renda> rendas = biblioteca.trataRenda(valores, isSalario);

        u.setRendas(rendas);

        if (!biblioteca.verificaLoginExistente(u.getLogin())) {

            model.addAttribute("msg", "Login já cadastrado.");
            model.addAttribute("user", u);

            caminho = "forward:exibirInserirUsuario";


        } else if (!biblioteca.verificaEmailExistente(u.getEmail())) {

            model.addAttribute("msg", "Email já cadastrado.");
            model.addAttribute("user", u);

            caminho = "forward:exibirInserirUsuario";

        } else {

            UsuarioDao dao = new UsuarioDao();

            u.setSenha(biblioteca.criptografarSenha(u.getSenha()));

            dao.inserir(u);

            model.addAttribute("msg", "Cadastro Efetuado com sucesso");

            caminho = "index";

        }

        return caminho;

    }

    @RequestMapping("logar")
    public String efetuarLogin(Model model, Usuario u, HttpSession session) {

        UsuarioDao dao = new UsuarioDao();

        String caminho = "";

        try {

            u.setSenha(biblioteca.criptografarSenha(u.getSenha().isEmpty() ? "" : u.getSenha()));

            Usuario usuarioLogado = dao.logar(u);

            if (usuarioLogado != null) {

                usuarioLogado.setRendas(dao.listaRedas(u));

                session.setAttribute("usuarioLogado", usuarioLogado);
                session.setAttribute("usuario", usuarioLogado.getLogin());
                session.setAttribute("totalLiquido", biblioteca.calculaTotalLiquido(usuarioLogado.getRendas()));
                session.setAttribute("totalBruto", biblioteca.calculaTotalBruto(usuarioLogado.getRendas()));

                caminho = "/sistema/index";

            } else {

                model.addAttribute("msg", "Credenciais não encontradas");

                caminho = "/index";

            }

        } catch (NullPointerException e) {

            model.addAttribute("msg", "Tente novamente!");

            caminho = "/index";

        }

        return caminho;
    }

}
