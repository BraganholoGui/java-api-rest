package br.com.api.model.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;

import java.util.Date;

public record DtoListConsulta(Long id, Date data_consulta) {
    public DtoListConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getData_consulta());
    }
}