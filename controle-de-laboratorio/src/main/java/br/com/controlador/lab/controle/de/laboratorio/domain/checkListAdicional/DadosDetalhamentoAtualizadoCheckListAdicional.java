package br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.check.Check;

public record DadosDetalhamentoAtualizadoCheckListAdicional (Long id, List<Check> check) {

    public DadosDetalhamentoAtualizadoCheckListAdicional(CheckListAdicional checkListAdicional){
        this(checkListAdicional.getId(), checkListAdicional.getCheck());
    }
    
}
