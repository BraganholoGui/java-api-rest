package br.com.api.service;

import br.com.api.dtos.consulta.DadosPostConsulta;
import br.com.api.dtos.consulta.ListConsultaMedico;
import br.com.api.model.Consulta;
import br.com.api.repository.ConsultaRepository;
import br.com.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultasService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ListConsultaMedico> listarConsultas() {
        List<Consulta> consultas = repository.findAllWithMedico();
        return consultas.stream()
                .map(consulta -> new ListConsultaMedico(
                        consulta.getData_consulta(),
                        consulta.getMedico().getNome(),
                        consulta.getMedico().getEspecialidade().toString()
                ))
                .collect(Collectors.toList());
    }

    public void cadastrarConsulta(DadosPostConsulta dados) {
        Consulta consulta = dados.converter(medicoRepository );
        repository.save(consulta);
    }
}
