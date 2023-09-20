package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "hecagemListAdicional")
@Entity(name = "CheckListAdicional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ChecagemListAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "checagem_id")
    private List<Checagem> checagem;

    private boolean ativo;

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