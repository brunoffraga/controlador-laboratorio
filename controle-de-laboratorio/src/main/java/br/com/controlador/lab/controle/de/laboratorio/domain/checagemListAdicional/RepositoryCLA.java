package br.com.controlador.lab.controle.de.laboratorio.domain.checagemListAdicional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCLA extends JpaRepository<ChecagemListAdicional, Long>{

    Page<ChecagemListAdicional> findAllByAtivoTrue(Pageable pageable);

    Page<ChecagemListAdicional> findAllByAtivoFalse(Pageable pageable);

}
