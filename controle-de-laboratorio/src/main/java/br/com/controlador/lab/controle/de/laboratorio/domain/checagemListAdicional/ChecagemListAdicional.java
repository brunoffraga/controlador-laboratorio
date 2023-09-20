package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "checagemListAdicional")
@Entity(name = "CheckListAdicional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ChecagemListAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checkListAdicional")
    private List<Checagem> checagem;


    public ChecagemListAdicional(DadosCadatroCLA dados){
        this.ativo = true;
        this.checagem = dados.checagem();
    }

    public void atualizacaoInfomacaoChekListAdicional(DadosAtualizacaoCLA dados){
        this.ativo = true;
        this.checagem = dados.checagem();
    }
    
    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
}