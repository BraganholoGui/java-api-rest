package br.com.api.model;

import br.com.api.dtos.medico.DadosAtualizacaoMedico;
import br.com.api.dtos.consulta.DadosPostConsulta;
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

    @Column(name = "medico_id")
    private Long medico_id;

    private Date data_consulta;

    private Boolean ativo;

    public Consulta(DadosPostConsulta dados) {
        this.ativo = true;
        this.medico_id = dados.medico_id();
        this.data_consulta = dados.data_consulta();
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
