package br.com.controlador.lab.controle.de.laboratorio.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.RepositoryC;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;

public class CadastroChecagem {

    @Autowired
    private Checagem checagem;

    @Autowired
    private ChecagemListAdicional checagemListAdicional;

    @Autowired
    private RepositoryC repositoryC;

    // private void cadastrando(DadosCadatroCLA dados){
    //     var checagemList = this.repositoryC.findById(dados.checagem());

    //     ChecagemListAdicional novaChecagemListAdicional = new ChecagemListAdicional();
    //     novaChecagemListAdicional.setListChecagem(checagemList);
    // }
}
