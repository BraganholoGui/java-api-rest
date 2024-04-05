package br.com.api.model;

import br.com.api.dtos.consulta.DtoAtualizacaoConsulta;
import br.com.api.repository.MedicoRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private Boolean ativo;

    public Consulta(Date data_consulta, Medico medico) {
        this.ativo = true;
        this.data_consulta = data_consulta;
        this.medico = medico;
    }

    public void excluir() {
        this.ativo = false;
    }
}
