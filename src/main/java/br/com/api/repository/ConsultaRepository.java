package br.com.api.repository;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT c FROM Consulta c JOIN FETCH c.medico")
    List<Consulta> findAllWithMedico();

}
