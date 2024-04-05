package br.com.api.service;

import br.com.api.dtos.medico.DadosAtualizacaoMedico;
import br.com.api.dtos.medico.DadosCadastroMedico;
import br.com.api.model.Medico;
import br.com.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Transactional

    public void cadastrar(DadosCadastroMedico dados) {
        repository.save(new Medico(dados));

    }
    @Transactional

    public void atualizar(DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfos(dados);
    }

    public void excluir(Long id) {
        //repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
