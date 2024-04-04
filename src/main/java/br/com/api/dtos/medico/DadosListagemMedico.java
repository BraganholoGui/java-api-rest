package br.com.api.dtos.medico;

import br.com.api.enums.Especialidade;
import br.com.api.model.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
