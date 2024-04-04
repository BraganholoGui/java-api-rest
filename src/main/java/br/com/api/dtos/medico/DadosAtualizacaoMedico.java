package br.com.api.dtos.medico;

import jakarta.validation.constraints.NotNull;
import br.com.api.dtos.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
