package br.com.api.dtos.medico;

import br.com.api.dtos.endereco.DadosEndereco;
import br.com.api.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosPostRelacaoMedico(
        @NotBlank
        String nome
        
       ) {
}
