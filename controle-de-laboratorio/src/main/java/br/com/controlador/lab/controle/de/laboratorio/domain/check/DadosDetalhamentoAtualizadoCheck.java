package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.CheckListAdicional;

public record DadosDetalhamentoAtualizadoCheck(Long id, String check, CheckListAdicional checkListAdicional) {

    public DadosDetalhamentoAtualizadoCheck(Check check){
        this(check.getId(), check.getCheck(), check.getCheckListAdicional());
    }
}