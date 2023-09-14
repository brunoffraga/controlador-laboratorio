package br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.check.Check;

public record DadosListagemCheckListAdicional(Long id, List<Check> check) {
    
    public DadosListagemCheckListAdicional(CheckListAdicional checkListAdicional){
        this(checkListAdicional.getId(), checkListAdicional.getCheck());
    }
}
