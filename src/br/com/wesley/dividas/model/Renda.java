package br.com.wesley.dividas.model;

import javax.persistence.*;

@Entity
@Table(name = "renda")
public class Renda {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "valor_bruto", columnDefinition = "decimal(10,2)")
    private double valorBruto;

    @Column(name = "valor_liquido", columnDefinition = "decimal(10,2)")
    private double valorLiquido;

    @Column(columnDefinition = "decimal(10,2)")
    private double descontos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }
}
