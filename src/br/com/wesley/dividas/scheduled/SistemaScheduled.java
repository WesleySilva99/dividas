package br.com.wesley.dividas.scheduled;

import br.com.wesley.dividas.dao.LoteDao;
import br.com.wesley.dividas.model.carnaval.Lote;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SistemaScheduled {

    @Scheduled(fixedDelay = 500)
    private void cadastraLotes(){

        LoteDao dao = new LoteDao();

        List<Lote> lotes = dao.getAllLote();

        if(lotes == null  || lotes.isEmpty()){

            Lote l1 = new Lote();
            l1.setDescricao("Primeiro Lote");

            Lote l2 = new Lote();
            l1.setDescricao("Segundo Lote");

            Lote l3 = new Lote();
            l1.setDescricao("Terceiro Lote");

            Lote l4 = new Lote();
            l1.setDescricao("Ultimo Lote");

            dao.inserir(l1);
            dao.inserir(l2);
            dao.inserir(l3);
            dao.inserir(l4);

        }

    }

}
