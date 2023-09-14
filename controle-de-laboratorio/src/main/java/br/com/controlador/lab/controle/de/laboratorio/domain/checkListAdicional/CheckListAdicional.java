package br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional;

import java.util.List;

import br.com.controlador.lab.controle.de.laboratorio.domain.check.Check;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "checkListlAdicional")
@Entity(name = "CheckListAdicional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CheckListAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_id")
    private List<Check> check;

    private boolean ativo;

    public CheckListAdicional(DadosCadatroCheckListAdicional dados){
        this.ativo = true;
    }

    public void atualizacaoInfomacaoChekListAdicional(DadosAtualizacaoCheckListAdicional dados){
    }
    
    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
}