package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;
import jakarta.validation.constraints.*;

public record DadosAtualizacaoCadastroC(

    @Null
    Long id,

    @NotBlank
    String checagem,

    @NotNull
    ChecagemListAdicional checagemListAdicional

){

}