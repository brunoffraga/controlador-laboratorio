package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.CheckListAdicional;

public record DadosListagemCheck(Long id, String check, CheckListAdicional checkListAdicionalheckListAdicional) {

    public DadosListagemCheck(Check check){
        this(check.getId(), check.getCheck(), check.getCheckListAdicional());
    }
    
}
