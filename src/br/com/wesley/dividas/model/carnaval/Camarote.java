package br.com.wesley.dividas.model.carnaval;

import br.com.wesley.dividas.model.Desejo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "camarote")
@Data
public class Camarote {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String descricao;

    @Column
    private String localizacao;

    @Column(columnDefinition = "tinyint default 1")
    private Integer status;

    @ManyToOne(targetEntity = Lote.class)
    private Lote lote;

    @Column(columnDefinition = "decimal(10,2)")
    private Double valor;

}
