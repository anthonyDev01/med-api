package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosConsulta(
        @NotBlank
        Medico medico,

        @NotBlank
        Paciente paciente,

        @NotBlank
        @Future
        LocalDateTime data
) {

}
