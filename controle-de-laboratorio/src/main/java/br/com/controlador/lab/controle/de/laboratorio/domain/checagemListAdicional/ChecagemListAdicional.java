package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.checagem.Checagem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "checagemListAdicional")
@Entity(name = "CheckListAdicional")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ChecagemListAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy =  "checagem")
    private List<Checagem> checagem;

    private boolean ativo;


    public ChecagemListAdicional(DadosCadatroCLA dados){
        this.checagem = dados.checagem();
        this.ativo = true;
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