package br.com.controlador.lab.controle.de.laboratorio.domain.check;

public record DadosDetalhamentoAtualizadoCheck(Long id, String check) {

    public DadosDetalhamentoAtualizadoCheck(Check check){
        this(check.getId(), check.getCheck());
    }
}