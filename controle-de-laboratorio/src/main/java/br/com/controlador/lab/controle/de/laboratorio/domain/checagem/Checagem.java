package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "checagem")
@Entity(name = "Checagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Checagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String checagem;
    private boolean ativo;
    
    @ManyToOne
    private ChecagemListAdicional checagemListAdicional;

    public Checagem(DadosAtualizacaoCadastroC dados) {
        this.ativo = true;
        this.checagem = dados.checagem();
        this.checagemListAdicional = dados.checagemListAdicional();
    }

    public void atualizacaoInfomacaoChecagem(DadosAtualizacaoCadastroC dados) {
        this.checagem = dados.checagem();
    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }
}