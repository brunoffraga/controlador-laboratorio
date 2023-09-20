package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;

public record DadosCadatroCLA(
    
    List<Checagem> checagem
    
) {

}
