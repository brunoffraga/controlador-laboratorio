package br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.check.Check;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCheckListAdicional(

    @NotNull
    long id,

    List<Check> check

) {

}
