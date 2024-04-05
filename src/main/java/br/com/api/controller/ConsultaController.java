package br.com.api.controller;

import br.com.api.dtos.consulta.DadosListConsulta;
import br.com.api.dtos.consulta.DadosPostConsulta;
import br.com.api.dtos.consulta.ListConsultaMedico;
import br.com.api.model.Consulta;
import br.com.api.model.Medico;
import br.com.api.repository.ConsultaRepository;
import br.com.api.repository.MedicoRepository;
import br.com.api.service.ConsultasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultasService servico;

    @GetMapping
    public Page<DadosListConsulta> listConsultas(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListConsulta::new);
    }

    @GetMapping("/lista")
    public List<ListConsultaMedico> listConsultas(){
        return servico.listarConsultas();
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosPostConsulta dados) {
        servico.cadastrarConsulta(dados);
    }
}
