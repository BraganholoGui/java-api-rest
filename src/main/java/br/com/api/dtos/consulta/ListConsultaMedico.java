package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;

import java.util.Date;

public record ListConsultaMedico (Date data_consulta, String medico_nome, String especialidade) {
    public ListConsultaMedico(Consulta consulta){
        this(consulta.getData_consulta(), consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade().toString());
    }
}