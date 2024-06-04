package br.com.api.controller;

import br.com.api.model.Medico;
import br.com.api.model.dtos.medico.DtoAtualizacaoMedico;
import br.com.api.model.dtos.medico.DtoCadastroMedico;
import br.com.api.model.dtos.medico.DtoListagemMedico;
import br.com.api.model.repository.MedicoRepository;
import br.com.api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoService service;

    @PostMapping
    public Medico cadastrar(@RequestBody @Valid DtoCadastroMedico dados) {
        return service.cadastrar(dados);
    }

//    @GetMapping
//    public List<DtoListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
//        return service.listarMedicos(paginacao);
//        return repository.findAllByAtivoTrue(paginacao).map(DtoListagemMedico::new);
//    }
    @GetMapping
    public ResponseEntity<List<DtoListagemMedico>> listar(){
        List<DtoListagemMedico> result = service.listarMedicos();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody @Valid DtoAtualizacaoMedico dados) {
        return service.atualizar(id, dados);

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        service.excluir(id);

    }
}
