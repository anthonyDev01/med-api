package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosConsulta(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotBlank
        @Future
        LocalDateTime data
) {

}
