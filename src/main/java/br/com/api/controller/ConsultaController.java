package br.com.api.controller;

import br.com.api.model.dtos.consulta.DtoListConsulta;
import br.com.api.model.dtos.consulta.DtoPostConsulta;
import br.com.api.model.dtos.consulta.DtoListConsultaMedico;
import br.com.api.model.Consulta;
import br.com.api.model.repository.ConsultaRepository;
import br.com.api.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private ConsultasService servico;

    @GetMapping
    public Page<DtoListConsulta> listConsultas(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DtoListConsulta::new);
    }

    @GetMapping("/lista")
    public List<DtoListConsultaMedico> listConsultas(){
        return servico.listarConsultas();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DtoListConsultaMedico> cadastrar(@RequestBody DtoPostConsulta dados) {
        Consulta consulta =  servico.cadastrarConsulta(dados);
        return ResponseEntity.ok(new DtoListConsultaMedico(consulta));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DtoListConsultaMedico> atualizar(@RequestBody DtoPostConsulta dados, @PathVariable Long id) {
        Consulta consulta =  servico.atualizarInfos(id, dados);
        return ResponseEntity.ok(new DtoListConsultaMedico(consulta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id){
        servico.excluir(id);
        return ResponseEntity.ok().build();

    }
}
