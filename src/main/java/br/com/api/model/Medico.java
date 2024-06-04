package br.com.api.model;

import br.com.api.model.dtos.consulta.DtoListConsulta;
import br.com.api.model.dtos.medico.DtoAtualizacaoMedico;
import br.com.api.model.dtos.medico.DtoCadastroMedico;
import br.com.api.model.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public Medico(DtoCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }


    public void excluir() {
        this.ativo = false;
    }
}
