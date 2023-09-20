package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;

public record DadosDetalhamentoAtualizadoCLA (Long id, List<Checagem> checagem) {

    public DadosDetalhamentoAtualizadoCLA(ChecagemListAdicional checagemListAdicional){
        this(checagemListAdicional.getId(), checagemListAdicional.getChecagem());
    }
    
}
