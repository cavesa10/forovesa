package com.cavesa10.forovesa.controller;

import com.cavesa10.forovesa.domain.usuario.DatosAutenticacionUsuario;
import com.cavesa10.forovesa.domain.usuario.Usuario;
import com.cavesa10.forovesa.infra.security.DatosJWTToken;
import com.cavesa10.forovesa.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionControlller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication AuthenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.usuario(),datosAutenticacionUsuario.clave());
        var usuarioAutenticado = authenticationManager.authenticate(AuthenticationToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
