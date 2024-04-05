package br.com.api.dtos.consulta;

import br.com.api.validations.MedicoExists;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoAtualizacaoConsulta(
        @NotNull @Valid @MedicoExists
        Long medico_id,
        Date data_consulta) {
}
