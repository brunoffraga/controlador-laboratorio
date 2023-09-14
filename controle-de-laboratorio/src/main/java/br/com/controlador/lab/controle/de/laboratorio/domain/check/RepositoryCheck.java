package br.com.controlador.lab.controle.de.laboratorio.domain.check;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCheck extends JpaRepository<Check, Long>{
    
    Page<Check> findAllByAtivoTrue(Pageable pageable);

    Page<Check> findAllByAtivoFalse(Pageable pageable);

}
