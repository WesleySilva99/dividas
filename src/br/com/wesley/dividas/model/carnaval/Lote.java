package br.com.wesley.dividas.model.carnaval;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lote")
@Data
public class Lote {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String descricao;

}
