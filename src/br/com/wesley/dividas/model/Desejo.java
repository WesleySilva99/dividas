package br.com.wesley.dividas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "desejo")
public class Desejo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String descricao;

    @Column(columnDefinition = "decimal(10,2)")
    private Double valor;

    @Column(name = "data_de_compra")
    private String dataDeCompra;


    @Column(columnDefinition = "boolean default false")
    private boolean status;

}
