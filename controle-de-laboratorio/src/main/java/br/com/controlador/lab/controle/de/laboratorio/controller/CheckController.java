package br.com.controlador.lab.controle.de.laboratorio.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controlador.lab.controle.de.laboratorio.domain.check.*;


@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private RepositoryCheck repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAtualizacaoCadastroCheck dados, UriComponentsBuilder uriComponentsBuilder){
        var check = new Check(dados);
        repository.save(check);

        var uri = uriComponentsBuilder.path("/check/{id}").buildAndExpand(check.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCheck(check));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCheck>> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosListagemCheck::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/listaExcluida")
    public ResponseEntity<Page<DadosListagemCheck>> listaExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(null).map(DadosListagemCheck::new);
        
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCadastroCheck dados){
        var check = repository.getReferenceById(dados.id());
        check.atualizacaoInfomacaoCheck(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var check = repository.getReferenceById(id);
        check.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheck(check));
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var check = repository.getReferenceById(id);
        check.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheck(check));
    }

}
