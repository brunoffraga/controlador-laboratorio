package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import io.micrometer.common.lang.NonNull;

public record DadosCadatroCLA(
    
    @NonNull
    List<Checagem> checagem
    
) {

}
