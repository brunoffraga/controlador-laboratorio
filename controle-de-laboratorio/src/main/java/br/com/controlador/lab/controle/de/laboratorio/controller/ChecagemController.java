package br.com.controlador.lab.controle.de.laboratorio.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.DadosAtualizacaoCadastroC;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.DadosDetalhamentoAtualizadoC;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.DadosListagemC;
import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.RepositoryC;


@RestController
@RequestMapping("/Checagem")
public class ChecagemController {

    @Autowired
    private RepositoryC repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAtualizacaoCadastroC dados, UriComponentsBuilder uriComponentsBuilder){
        var c = new Checagem(dados);
        repository.save(c);

        var uri = uriComponentsBuilder.path("/checagem/{id}").buildAndExpand(c.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoC(c));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemC>> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemC::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/ListaDeletada")
    public ResponseEntity<Page<DadosListagemC>> listaExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemC::new);
        
        return ResponseEntity.ok(page);
    }
 
    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCadastroC dados){
        var checagem = repository.getReferenceById(dados.id());
        checagem.atualizacaoInfomacaoChecagem(dados);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var checagem = repository.getReferenceById(id);
        checagem.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoC(checagem));
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var checagem = repository.getReferenceById(id);
        checagem.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoC(checagem));
    }

}
