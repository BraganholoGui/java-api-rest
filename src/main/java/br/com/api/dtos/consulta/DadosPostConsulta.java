package br.com.api.dtos.consulta;

import br.com.api.dtos.endereco.DadosEndereco;
import br.com.api.dtos.medico.DadosPostRelacaoMedico;
import br.com.api.validations.MedicoExists;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosPostConsulta(
        @NotNull @Valid @MedicoExists
        Long medico_id,
        Date data_consulta
       ) {
}
