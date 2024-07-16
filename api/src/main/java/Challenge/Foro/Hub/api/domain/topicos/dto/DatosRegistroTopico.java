package Challenge.Foro.Hub.api.domain.topicos.dto;

import Challenge.Foro.Hub.api.domain.topicos.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Estado status,
        @NotNull
        Long autorId,
        @NotBlank
        String nombreCurso
) {
}
