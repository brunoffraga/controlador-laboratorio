package br.com.controlador.lab.controle.de.laboratorio.domain.checkListAdicional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCheckListAdicional extends JpaRepository<CheckListAdicional, Long>{

    Page<CheckListAdicional> findAllByAtivoTrue(Pageable pageable);

    Page<CheckListAdicional> findAllByAtivoFalse(Pageable pageable);

}
