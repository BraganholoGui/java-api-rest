package br.com.api.controller;

import br.com.api.dtos.medico.DadosAtualizacaoMedico;
import br.com.api.dtos.medico.DadosCadastroMedico;
import br.com.api.dtos.medico.DadosListagemMedico;
import br.com.api.model.Medico;
import br.com.api.repository.MedicoRepository;
import br.com.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        service.cadastrar(dados);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        service.atualizar(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        service.excluir(id);

    }
}
