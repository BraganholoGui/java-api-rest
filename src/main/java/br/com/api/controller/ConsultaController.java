package br.com.api.controller;

import br.com.api.dtos.consulta.DadosListConsulta;
import br.com.api.dtos.consulta.DadosPostConsulta;
import br.com.api.model.Consulta;
import br.com.api.repository.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @GetMapping
    public Page<DadosListConsulta> listar(@PageableDefault(size=10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListConsulta::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosPostConsulta dados) {
        System.out.println(dados);
        repository.save(new Consulta(dados));
    }
}
