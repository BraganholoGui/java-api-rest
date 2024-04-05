package br.com.api.dtos.medico;

import jakarta.validation.constraints.NotNull;
import br.com.api.dtos.endereco.DtoEndereco;

public record DtoAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DtoEndereco endereco) {
}