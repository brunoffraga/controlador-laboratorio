package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;

public record DadosListagemC(Long id, String checagem, ChecagemListAdicional checagemListAdicionalheckListAdicional) {

    public DadosListagemC(Checagem checagem){
        this(checagem.getId(), checagem.getChecagem(), checagem.getChecagemListAdicional());
    }
    
}
