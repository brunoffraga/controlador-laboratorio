package br.com.controlador.lab.controle.de.laboratorio.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.*;

@RestController
@RequestMapping("/CheckListAdicional")
public class CheckListController {
 
    @Autowired
    private RepositoryCheckListAdicional repository;
 
    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadatroCheckListAdicional dados, UriComponentsBuilder uriComponentsBuilder){
        var checkListAdicional = new CheckListAdicional(dados);
        repository.save(checkListAdicional);

        var uri = uriComponentsBuilder.path("/check/{id}").buildAndExpand(checkListAdicional.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCheckListAdicional(checkListAdicional));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCheckListAdicional>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosListagemCheckListAdicional::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/listaEx")
    public ResponseEntity<Page<DadosListagemCheckListAdicional>> listaExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(null).map(DadosListagemCheckListAdicional::new);

        return ResponseEntity.ok(page);
    }

    
    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCheckListAdicional dados){
        var checkListAdicional = repository.getReferenceById(dados.id());
        checkListAdicional.atualizacaoInfomacaoChekListAdicional(dados);
    }
    
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var checkListAdicional = repository.getReferenceById(id);
        checkListAdicional.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheckListAdicional(checkListAdicional));
    }


    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var checkListAdicional = repository.getReferenceById(id);
        checkListAdicional.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheckListAdicional(checkListAdicional));
    }
    
}
