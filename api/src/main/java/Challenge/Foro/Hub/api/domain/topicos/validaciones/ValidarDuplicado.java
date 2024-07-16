package Challenge.Foro.Hub.api.domain.topicos.validaciones;

import Challenge.Foro.Hub.api.domain.topicos.TopicoRepository;
import Challenge.Foro.Hub.api.domain.topicos.dto.DatosRegistroTopico;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidarDuplicado implements Validadores {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validarDatos(DatosRegistroTopico datosRegistroTopico) {
        var titulo = datosRegistroTopico.titulo();
        var mensaje = datosRegistroTopico.mensaje();

        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(titulo, mensaje);
        if (topicoDuplicado) {
            throw new ValidationException("Ya existe un topico con este titulo/mensaje");
        }
    }
}
