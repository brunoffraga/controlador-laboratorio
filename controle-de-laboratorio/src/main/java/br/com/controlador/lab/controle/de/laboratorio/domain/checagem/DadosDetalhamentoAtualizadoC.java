package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;

public record DadosDetalhamentoAtualizadoC(Long id, String checagem, ChecagemListAdicional checagemListAdicional) {

    public DadosDetalhamentoAtualizadoC(Checagem checagem){
        this(checagem.getId(), checagem.getChecagem(), checagem.getChecagemListAdicional());
    }
}