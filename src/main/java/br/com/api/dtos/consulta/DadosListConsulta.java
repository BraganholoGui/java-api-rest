package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;

import java.util.Date;

public record DadosListConsulta(Long medico_id, Date data_consulta) {
    public DadosListConsulta(Consulta consulta){
        this(consulta.getMedico_id(), consulta.getData_consulta());
    }
}