package br.com.wesley.dividas.controller;


import br.com.wesley.dividas.dao.UsuarioDao;
import br.com.wesley.dividas.model.Desejo;
import br.com.wesley.dividas.model.Divida;
import br.com.wesley.dividas.model.Renda;
import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.util.Functions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UsuarioController {

    Functions biblioteca = new Functions();

    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("exibirInserirUsuario")
    public String exibirInserir() {

        return "/usuario/inserir";

    }

    @RequestMapping("inserirUsuario")
    public String inserirUsuario(Usuario u, Model model,
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

                usuarioLogado.setDividas(dao.listaDividas(u));

                usuarioLogado.setDesejos(dao.listaDesejos(u));

                double totalDividas = 0;

                if (u.getDividas() != null){
                    for (Divida d:
                            u.getDividas()) {
                        totalDividas += d.getValor();
                    }
                }

                session.setAttribute("usuarioLogado", usuarioLogado);
                session.setAttribute("usuario", usuarioLogado.getLogin());
                session.setAttribute("totalLiquido", biblioteca.calculaTotalLiquido(usuarioLogado.getRendas()));
                session.setAttribute("totalBruto", biblioteca.calculaTotalBruto(usuarioLogado.getRendas()));

                biblioteca.carregar(usuarioLogado, model);

                caminho = "/sistema/index";

            } else {

                model.addAttribute("msg", "Credenciais não encontradas");

                caminho = "/index";

            }

        } catch (NullPointerException | ParseException e) {

            model.addAttribute("msg", "Tente novamente!");

            caminho = "/index";

        }

        return caminho;
    }

    @RequestMapping("cadastraDivida")
    public String cadastraDivida(HttpSession session, Model model, Divida d) throws ParseException {

        UsuarioDao dao = new UsuarioDao();

        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        List<Divida> dividas = dao.listaDividas(usuarioLogado);

        d.setData(new Date(System.currentTimeMillis()));

        dividas.add(d);

        usuarioLogado.setDividas(dividas);

        dao.saveUsuario(usuarioLogado);

        model.addAttribute("msg", "Divida Cadastrada Com Sucesso");

        biblioteca.carregar(usuarioLogado, model);

        return "/sistema/index";

    }

    @RequestMapping("cadastraRenda")
    public String cadastraRenda(HttpSession session, Model model,
                                @RequestParam(name = "valor") String[] valor, @RequestParam(name = "isSalario") String[] isSalario) throws ParseException {

        UsuarioDao dao = new UsuarioDao();

        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        List<Renda> todasrendas = dao.listaRedas(usuarioLogado);

        List<Renda> rendaAtualTratada = biblioteca.trataRenda(valor, isSalario);

        todasrendas.add(rendaAtualTratada.get(0));

        usuarioLogado.setRendas(todasrendas);

        dao.saveUsuario(usuarioLogado);

        model.addAttribute("msg", "Renda Cadastrada Com Sucesso");

        biblioteca.carregar(usuarioLogado, model);

        return "/sistema/index";

    }

    @RequestMapping("cadastraDesejo")
    public String cadastraDesejo(HttpSession session, Model model, Desejo d) throws ParseException {

        UsuarioDao dao = new UsuarioDao();

        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if(d.getDataDeCompra() != null){
            java.util.Date dataFormatada = formato.parse(d.getDataDeCompra());

            java.util.Date hoje = new java.util.Date(System.currentTimeMillis());

            if(dataFormatada.compareTo(hoje) == -1){

                model.addAttribute("msg", "Data de desejo inferior a data de hoje... insira uma data valida");

                biblioteca.carregar(usuarioLogado, model);

                return "/sistema/index";

            }

        }

        List<Desejo> desejos = dao.listaDesejos(usuarioLogado);

        desejos.add(d);

        usuarioLogado.setDesejos(desejos);

        dao.saveUsuario(usuarioLogado);

        model.addAttribute("msg", "Desejo Cadastrado Com Sucesso");

        biblioteca.carregar(usuarioLogado, model);

        return "/sistema/index";

    }

}
