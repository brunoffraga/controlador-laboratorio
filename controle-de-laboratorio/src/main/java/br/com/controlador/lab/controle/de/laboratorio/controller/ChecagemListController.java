package br.com.controlador.lab.controle.de.laboratorio.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.*;

@RestController
@RequestMapping("/ChecagemListAdicional")
public class ChecagemListController {
 
    @Autowired
    private RepositoryCLA repository;
 
    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadatroCLA dados, UriComponentsBuilder uriComponentsBuilder){
        var checagemListAdicional = new ChecagemListAdicional(dados);
        repository.save(checagemListAdicional);

        var uri = uriComponentsBuilder.path("/checagem/{id}").buildAndExpand(checagemListAdicional.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCLA(checagemListAdicional));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCLA>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemCLA::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/listaEx")
    public ResponseEntity<Page<DadosListagemCLA>> listaExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemCLA::new);

        return ResponseEntity.ok(page);
    }

    
    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCLA dados){
        var checagemListAdicional = repository.getReferenceById(dados.id());
        checagemListAdicional.atualizacaoInfomacaoChekListAdicional(dados);
    }
    
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var checagemListAdicional = repository.getReferenceById(id);
        checagemListAdicional.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCLA(checagemListAdicional));
    }


    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var checagemListAdicional = repository.getReferenceById(id);
        checagemListAdicional.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCLA(checagemListAdicional));
    }
    
}
