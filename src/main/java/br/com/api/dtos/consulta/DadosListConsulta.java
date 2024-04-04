package br.com.api.dtos.consulta;

import br.com.api.model.Consulta;
import br.com.api.model.Medico;

import java.util.Date;

public record DadosListConsulta(Medico medico, Date data_consulta) {
    public DadosListConsulta(Consulta consulta){
        this(consulta.getMedico() , consulta.getData_consulta());
    }
}