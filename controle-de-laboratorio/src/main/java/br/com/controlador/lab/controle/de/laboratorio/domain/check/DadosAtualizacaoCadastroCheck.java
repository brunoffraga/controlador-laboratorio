package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.CheckListAdicional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCadastroCheck(

    @NotNull
    Long id,

    @NotBlank
    String check,

    @NotNull
    CheckListAdicional checkListAdicional

){

}
