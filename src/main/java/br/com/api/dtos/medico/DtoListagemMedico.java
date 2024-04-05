package br.com.api.dtos.medico;

import br.com.api.enums.Especialidade;
import br.com.api.model.Medico;

public record DtoListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DtoListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
