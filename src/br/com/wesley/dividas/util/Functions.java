package br.com.wesley.dividas.util;

import br.com.wesley.dividas.dao.UsuarioDao;
import br.com.wesley.dividas.model.Divida;
import br.com.wesley.dividas.model.Renda;
import br.com.wesley.dividas.model.Usuario;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Functions {

    public boolean verificaLoginExistente(String login) {

        UsuarioDao dao = new UsuarioDao();

        return dao.verificaLoginExistente(login);
    }

    public boolean verificaEmailExistente(String email) {

        UsuarioDao dao = new UsuarioDao();

        return dao.verificaEmailExistente(email);
    }

    public String criptografarSenha(String senha) {

        String retorno = Encription.getMD5(senha);

        return retorno;
    }

    public Renda calculaRendaLiquidaSalario(Renda r) {

        Renda retorno = r;

        double salario = r.getValorBruto();

        double inss = 0.14 * salario;

        double irrf = 0.10 * salario;

        retorno.setValorBruto(salario);

        retorno.setValorLiquido(salario - inss - irrf);

        retorno.setDescontos(inss + irrf);

        return retorno;

    }

    public static void carregar(Usuario u, Model model) {

        double totalDividas = 0;

        double totalRendas = 0;

        for (Divida d:
             u.getDividas()) {
            totalDividas += d.getValor();
        }

        for (Renda r:
             u.getRendas()) {

            totalRendas += r.getValorLiquido();

        }

        double sobraMensal = totalRendas - totalDividas;

        model.addAttribute("dividasDoMes", u.getDividas());

        model.addAttribute("totalDividas", totalDividas);

        model.addAttribute("rendas", u.getRendas());

        model.addAttribute("rendaTotal", totalRendas);

        model.addAttribute("sobraMensal", sobraMensal);

        model.addAttribute("porcentagemSobra", descobrePorcentagem(totalRendas, sobraMensal).toString());

    }

    public double calculaTotalLiquido(List<Renda> rendas) {

        double retorno = 0;

        for (Renda r : rendas) {

            retorno += r.getValorLiquido();

        }

        return retorno;

    }

    public double calculaTotalBruto(List<Renda> rendas) {

        double retorno = 0;

        for (Renda r :
                rendas) {

            retorno += r.getValorBruto();

        }

        return retorno;

    }

    public List<Renda> trataRenda(String[] rendas, String[] isSalario) {

        ArrayList<Renda> retorno = new ArrayList<>();


        for (int i = 0; i < rendas.length; i++) {

            Renda r = new Renda();

            if (isSalario[i].equals("1")) {

                r.setValorBruto(Double.parseDouble(rendas[i]));

                r = calculaRendaLiquidaSalario(r);

            } else {

                r.setValorBruto(Double.parseDouble(rendas[i]));
                r.setValorLiquido(Double.parseDouble(rendas[i]));
                r.setDescontos(0);

            }

            retorno.add(r);

        }

        return retorno;
    }

    public static Double descobrePorcentagem(double rendaLiquida, double sobraMensal){
        double retorno = 0;

        sobraMensal = sobraMensal * 100;

        retorno = sobraMensal / rendaLiquida;

        return retorno;
    }

}
