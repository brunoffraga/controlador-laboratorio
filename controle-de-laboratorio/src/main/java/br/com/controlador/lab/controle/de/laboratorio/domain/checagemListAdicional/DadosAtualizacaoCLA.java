package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;


import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCLA(

    @NotNull
    long id,

    @NotNull
    List<Checagem> checagem

) {

}
