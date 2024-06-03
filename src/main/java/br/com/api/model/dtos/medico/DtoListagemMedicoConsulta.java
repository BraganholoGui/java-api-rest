package br.com.api.model.dtos.medico;

import br.com.api.model.Medico;
import br.com.api.model.enums.Especialidade;

public record DtoListagemMedicoConsulta(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DtoListagemMedicoConsulta(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
