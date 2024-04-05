package br.com.api.controller;

import br.com.api.dtos.consulta.DtoListConsulta;
import br.com.api.dtos.consulta.DtoPostConsulta;
import br.com.api.dtos.consulta.DtoListConsultaMedico;
import br.com.api.repository.ConsultaRepository;
import br.com.api.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public void cadastrar(@RequestBody DtoPostConsulta dados) {
        servico.cadastrarConsulta(dados);
    }

    @PutMapping("{id}")
    public void atualizar(@RequestBody DtoPostConsulta dados, @PathVariable Long id) {
        servico.atualizarInfos(id, dados);
    }
}
