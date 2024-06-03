package br.com.api.model.dtos.consulta;

import br.com.api.model.validations.MedicoExists;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoAtualizacaoConsulta(
        @NotNull @Valid @MedicoExists
        Long medico_id,
        Date data_consulta) {
}
