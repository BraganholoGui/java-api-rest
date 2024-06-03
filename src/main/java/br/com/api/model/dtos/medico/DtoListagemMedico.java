package br.com.api.model.dtos.medico;

import br.com.api.model.Consulta;
import br.com.api.model.dtos.consulta.DtoListConsulta;
import br.com.api.model.enums.Especialidade;
import br.com.api.model.Medico;

import java.util.List;
import java.util.stream.Collectors;

public record DtoListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade, List<DtoListConsulta> consultas) {
    public DtoListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getConsultas().stream().map(DtoListConsulta::new).collect(Collectors.toList()));
    }
}
