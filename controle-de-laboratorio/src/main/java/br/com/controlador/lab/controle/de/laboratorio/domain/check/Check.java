package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional.CheckListAdicional;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "`check`")
@Entity(name = "Check")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String check;
    private boolean ativo;
    
    @ManyToOne
    private CheckListAdicional checkListAdicional;

    public Check(DadosAtualizacaoCadastroCheck dados) {
        this.ativo = true;
        this.check = dados.check();
        this.checkListAdicional = dados.checkListAdicional();
    }

    public void atualizacaoInfomacaoCheck(DadosAtualizacaoCadastroCheck dados) {
        this.check = dados.check();
    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }
}