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

    @Transactional
    public void cadastrarConsulta(DtoPostConsulta dados) {
        Consulta consulta = dados.converter(medicoRepository );
        repository.save(consulta);
    }

    @Transactional
    public void atualizarInfos(Long id, DtoPostConsulta dados) {
        Optional<Consulta> optionalConsulta = repository.findById(id);

        Consulta consultaAtualizada = dados.converter(medicoRepository );
        System.out.println(optionalConsulta);
        System.out.println(dados);
        System.out.println(consultaAtualizada);

//        if (optionalConsulta.isPresent() && optionalConsulta.get() instanceof Consulta) {
//            Consulta consultaExistente = (Consulta) optionalConsulta.get();
//            BeanUtils.copyProperties(consultaAtualizada, consultaExistente, "id");
//            System.out.println(consultaExistente.getData_consulta() );
//            System.out.println(consultaExistente.getMedico().getId() );
////            repository.save(consultaExistente);
//        } else {
//            throw new RuntimeException("Paciente não encontrado para o ID fornecido: " + id);
//        }

//        repository.
//        if(dados.data_consulta() != null) {
//            this.data_consulta = dados.data_consulta();
//        }
//        Medico medico = medicoRepository .findByid(medico_id);
//        if(dados.medico_id() != null) {
//            this. = dados.medico_id();
//        }
    }
}
