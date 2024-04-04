package br.com.api.model;

import br.com.api.dtos.medico.DadosAtualizacaoMedico;
import br.com.api.dtos.consulta.DadosPostConsulta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_consulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    @JsonIgnore
    private Medico medico;

    private Boolean ativo;

    public Consulta(Date data_consulta, Medico medico) {
        this.ativo = true;
        this.data_consulta = data_consulta;
        this.medico = medico;
    }

    public void atualizarInfos(DadosAtualizacaoMedico dados) {
//        if(dados.telefone() != null) {
//            this.telefone = dados.telefone();
//        }
//        if(dados.endereco() != null) {
//            this.endereco.atualizarInfos(dados.endereco());
//        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
