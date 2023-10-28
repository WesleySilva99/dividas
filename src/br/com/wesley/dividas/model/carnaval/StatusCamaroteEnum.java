package br.com.wesley.dividas.model.carnaval;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum StatusCamaroteEnum {

    CADASTRADO(1, "Cadastrado"),
    COMPRADO(2, "Compra feita"),
    DESISTENCIA(3, "Desistiu da compra");

    private Integer codigo;
    private String descricao;

    StatusCamaroteEnum(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static List<StatusCamaroteEnum> listaTodos(){

        return Arrays.asList(StatusCamaroteEnum.values());

    }

}
