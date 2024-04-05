package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;

import java.util.Date;

public record DtoListConsulta(Medico medico, Date data_consulta) {
    public DtoListConsulta(Consulta consulta){
        this(consulta.getMedico() , consulta.getData_consulta());
    }
}