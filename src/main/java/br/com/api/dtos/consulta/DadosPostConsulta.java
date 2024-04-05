package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;
import br.com.api.repository.MedicoRepository;
import br.com.api.validations.MedicoExists;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosPostConsulta(
        @NotNull @Valid @MedicoExists
        Long medico_id,
        Date data_consulta
       ) {
    public Consulta converter(MedicoRepository medicoRepository ) {
        Medico medico = medicoRepository.findByid(medico_id);
        return new Consulta(data_consulta, medico);
    }
}
