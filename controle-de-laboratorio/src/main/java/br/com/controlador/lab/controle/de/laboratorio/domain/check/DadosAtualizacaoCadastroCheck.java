package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.CheckListAdicional;
import jakarta.validation.constraints.*;

public record DadosAtualizacaoCadastroCheck(

    @NotBlank
    String check,

    @NotNull
    CheckListAdicional checkListAdicional

){

}
