package Challenge.Foro.Hub.api.domain.topicos.dto;

import Challenge.Foro.Hub.api.domain.topicos.Estado;
import Challenge.Foro.Hub.api.domain.topicos.Topico;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Estado status,
        Long autorId,
        String nombreCurso
) {
    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getNombreCurso()
        );
    }
}
