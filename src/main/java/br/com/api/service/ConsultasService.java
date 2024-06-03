package br.com.api.service;

import br.com.api.model.dtos.consulta.DtoListConsultaMedico;
import br.com.api.model.dtos.consulta.DtoPostConsulta;
import br.com.api.model.Consulta;
import br.com.api.model.Medico;
import br.com.api.model.repository.ConsultaRepository;
import br.com.api.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Consulta cadastrarConsulta(DtoPostConsulta dados) {
        Consulta consulta = dados.converter(medicoRepository );
        repository.save(consulta);
        return consulta;
    }

    public Consulta atualizarInfos(Long id, DtoPostConsulta dados) {
        Optional<Consulta> optionalConsulta = repository.findById(id);

        if (optionalConsulta.isPresent() && optionalConsulta.get() instanceof Consulta) {
            Consulta consultaExistente = (Consulta) optionalConsulta.get();
            Medico medico = medicoRepository.findByid(dados.medico_id());
            if(medico == null){
                throw new RuntimeException("Medico não encontrado para o ID fornecido: " + id);
            }
            consultaExistente.setData_consulta(dados.data_consulta());
            consultaExistente.setMedico(medico);
            repository.save(consultaExistente);
            return consultaExistente;
        } else {
            throw new RuntimeException("Paciente não encontrado para o ID fornecido: " + id);
        }
    }

    public void excluir(Long id) {
        //repository.deleteById(id);
        var consulta = repository.getReferenceById(id);
        consulta.excluir();
    }

}
