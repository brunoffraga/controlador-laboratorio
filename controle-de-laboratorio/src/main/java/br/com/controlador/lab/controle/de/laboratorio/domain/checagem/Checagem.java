package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional.ChecagemListAdicional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    
    @ManyToOne()
    @JoinColumn(name = "checagem_list_adicional_id")
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