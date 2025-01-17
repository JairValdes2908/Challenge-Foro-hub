package Challenge.Foro.Hub.api.domain.topicos.dto;

import Challenge.Foro.Hub.api.domain.topicos.Estado;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autor,
        String nombreCurso,
        LocalDateTime fecha
) {
}
