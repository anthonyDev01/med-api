package med.voll.api.domain.consulta;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "consultas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    public Consulta(DadosConsulta dados){
        this.medico = dados.medico();
        this.paciente = dados.paciente();
        this.data = dados.data();
    }
}
