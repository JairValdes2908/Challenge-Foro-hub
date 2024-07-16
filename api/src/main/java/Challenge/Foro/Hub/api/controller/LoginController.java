package Challenge.Foro.Hub.api.controller;

import Challenge.Foro.Hub.api.domain.autores.Autor;
import Challenge.Foro.Hub.api.domain.autores.DatosAutenticacionAutor;
import Challenge.Foro.Hub.api.infra.security.DatosJWTtOKEN;
import Challenge.Foro.Hub.api.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Tag(name = "post", description = "Metodos POST de API de topicos")
    @Operation(
            summary = "Autenticar usuario",
            description = "Autenticar usuario y obtener su JWT. Se requiere enviar el campo login y clave para poder autenticarse"
    )
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionAutor datosAutenticacionAutor) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionAutor.login(), datosAutenticacionAutor.clave());
        var authentication = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarJWT((Autor) authentication.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtOKEN(JWTtoken));
    }
}
