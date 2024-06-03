package br.com.api.service;

import br.com.api.model.Consulta;
import br.com.api.model.dtos.consulta.DtoListConsulta;
import br.com.api.model.dtos.medico.DtoAtualizacaoMedico;
import br.com.api.model.dtos.medico.DtoCadastroMedico;
import br.com.api.model.Medico;
import br.com.api.model.dtos.medico.DtoListagemMedico;
import br.com.api.model.repository.ConsultaRepository;
import br.com.api.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;
    @Autowired
    private ConsultaRepository consultaRepository;

    public List<DtoListagemMedico> listarMedicos() {
        List<Medico> medicos = repository.findAllByAtivoTrue();
        return medicos.stream()
                .map(medico -> new DtoListagemMedico(
                        medico.getId(),
                        medico.getNome(),
                        medico.getEmail(),
                        medico.getCrm(),
                        medico.getEspecialidade(),
                        medico.getConsultas().stream().map(DtoListConsulta::new).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @Transactional

    public void cadastrar(DtoCadastroMedico dados) {
        repository.save(new Medico(dados));

    }
    @Transactional

    public void atualizar(DtoAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfos(dados);
    }

//    public void excluir(Long id) {
//        //repository.deleteById(id);
//        var medico = repository.getReferenceById(id);
//        medico.excluir();
//    }
    public void excluir(Long id) {
        Medico medico = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado com o ID: " + id));

        medico.excluir();
        repository.save(medico);

        List<Consulta> consultas = consultaRepository.findByMedicoIdAndAtivoTrue(id);
        for (Consulta consulta : consultas) {
            consulta.excluir();
            consultaRepository.save(consulta);
        }
    }
}
