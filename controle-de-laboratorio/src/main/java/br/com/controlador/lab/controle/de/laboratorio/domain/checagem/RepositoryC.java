package br.com.controlador.lab.controle.de.laboratorio.domain.checagem;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryC extends JpaRepository<Checagem, Long>{
    
    Page<Checagem> findAllByAtivoTrue(Pageable pageable);

    Page<Checagem> findAllByAtivoFalse(Pageable pageable);

}
