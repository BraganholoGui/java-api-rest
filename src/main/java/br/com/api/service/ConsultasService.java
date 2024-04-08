package br.com.api.service;

import br.com.api.dtos.consulta.DtoAtualizacaoConsulta;
import br.com.api.dtos.consulta.DtoPostConsulta;
import br.com.api.dtos.consulta.DtoListConsultaMedico;
import br.com.api.model.Consulta;
import br.com.api.model.Medico;
import br.com.api.repository.ConsultaRepository;
import br.com.api.repository.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultasService {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<DtoListConsultaMedico> listarConsultas() {
        List<Consulta> consultas = repository.findAllWithMedico();
        return consultas.stream()
                .map(consulta -> new DtoListConsultaMedico(
                        consulta.getData_consulta(),
                        consulta.getMedico().getNome(),
                        consulta.getMedico().getEspecialidade().toString()
                ))
                .collect(Collectors.toList());
    }

    public void cadastrarConsulta(DtoPostConsulta dados) {
        Consulta consulta = dados.converter(medicoRepository );
        repository.save(consulta);
    }

    public void atualizarInfos(Long id, DtoPostConsulta dados) {
        Optional<Consulta> optionalConsulta = repository.findById(id);

        Consulta consultaAtualizada = dados.converter(medicoRepository );

        if (optionalConsulta.isPresent() && optionalConsulta.get() instanceof Consulta) {
            Consulta consultaExistente = (Consulta) optionalConsulta.get();
            Medico medico = medicoRepository.findByid(dados.medico_id());
            consultaExistente.setData_consulta(new Date());
            consultaExistente.setMedico(medico);
            repository.save(consultaExistente);
        } else {
            throw new RuntimeException("Paciente não encontrado para o ID fornecido: " + id);
        }
    }
}
