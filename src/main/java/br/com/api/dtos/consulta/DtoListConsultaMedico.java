package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;

import java.util.Date;

public record DtoListConsultaMedico(Date data_consulta, String medico_nome, String especialidade) {
    public DtoListConsultaMedico(Consulta consulta){
        this(consulta.getData_consulta(), consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade().toString());
    }
}