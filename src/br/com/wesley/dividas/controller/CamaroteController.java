package br.com.wesley.dividas.controller;

import br.com.wesley.dividas.dao.CamaroteDao;
import br.com.wesley.dividas.dao.LoteDao;
import br.com.wesley.dividas.dao.UsuarioDao;
import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.model.carnaval.Camarote;
import br.com.wesley.dividas.model.carnaval.Lote;
import br.com.wesley.dividas.model.carnaval.StatusCamaroteEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CamaroteController {

    DecimalFormat formato = new DecimalFormat("R$###.##");

    @RequestMapping("exibirCadastrarCamarote")
    public String exibirCadastrarCamarote(Model model){

        LoteDao loteDao = new LoteDao();

        List<Lote> lotesCadastrados = loteDao.getAllLote();

        model.addAttribute("lotes", lotesCadastrados);

        return "sistema/camarote/cadastrarCamarote";
    }

    @RequestMapping("cadastraCamarote")
    public String cadastraCamarote(Model model, @RequestParam("descricao") String descricao
            ,@RequestParam("localizacao") String localizacao
            ,@RequestParam("valor") double valor
            ,@RequestParam("idLote") int lote) throws ParseException {

        CamaroteDao camaroteDao = new CamaroteDao();
        LoteDao loteDao = new LoteDao();

        //tratando camarote

        Camarote c = new Camarote();
        c.setDescricao(descricao);
        c.setValor(valor);
        c.setLocalizacao(localizacao);
        c.setStatus(StatusCamaroteEnum.CADASTRADO.getCodigo());

        Lote l = loteDao.getLoteById(lote);
        l.setId(lote);

        c.setLote(l);

        camaroteDao.saveCamarote(c);

        model.addAttribute("msg", "Camarote Cadastrado Com Sucesso");

        return "forward:listarCamarotes";

    }

    @RequestMapping("editarCamarote")
    public String editarCamarote(Model model, Camarote c, @RequestParam("idLote") int idLote) {

        CamaroteDao camaroteDao = new CamaroteDao();

        LoteDao loteDao = new LoteDao();

        Lote novoLote = loteDao.getLoteById(idLote);

        c.setLote(novoLote);

        camaroteDao.saveCamarote(c);

        model.addAttribute("msg", "Camarote Salvo Com Sucesso");

        return "forward:listarCamarotes";

    }

    @RequestMapping("cadastrarLote")
    public String cadastrarLote(Model model, Lote lote,
                                @RequestParam("idCamarote") int idCamarote){
        return "";
    }

    @RequestMapping("listarCamarotes")
    public String listarCamarotes(Model model, HttpSession session){

        CamaroteDao dao = new CamaroteDao();

        List<Camarote> camarotes = dao.getAllCamarotes();

        double valorTotal = 0;

        for (Camarote c:
                camarotes) {

            valorTotal += c.getValor();

        }

        model.addAttribute("valorTotalCamarotes", formato.format(valorTotal));

        model.addAttribute("camarotes", camarotes);

        LoteDao loteDao = new LoteDao();

        List<Lote> lotesCadastrados = loteDao.getAllLote();

        model.addAttribute("lotes", lotesCadastrados);

        return "sistema/camarote/listarCamarote";
    }

    @RequestMapping("exibirEditarCamarote")
    public String visualizarEditarCamarote(@RequestParam("id") int id, Model model){

        CamaroteDao camaroteDao = new CamaroteDao();

        LoteDao loteDao = new LoteDao();

        List<Lote> lotesCadastrados = loteDao.getAllLote();

        Camarote c = camaroteDao.getById(id);

        List<StatusCamaroteEnum> listaStatus = StatusCamaroteEnum.listaTodos();

        model.addAttribute("camarote", c);

        model.addAttribute("lotes", lotesCadastrados);

        model.addAttribute("listaStatus", listaStatus);


        return "sistema/camarote/editarCamarote";

    }

    @RequestMapping("removerCamarote")
    public String removerCamarote(@RequestParam("id") int id, Model model){

        CamaroteDao camaroteDao = new CamaroteDao();

        camaroteDao.delete(id);

        model.addAttribute("msg", "Camarote removido com sucesso");

        return "forward:listarCamarotes";

    }

}
