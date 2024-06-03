package br.com.api.model.dtos.medico;

import br.com.api.model.dtos.endereco.DtoEndereco;
import jakarta.validation.constraints.NotNull;

public record DtoAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DtoEndereco endereco) {
}
