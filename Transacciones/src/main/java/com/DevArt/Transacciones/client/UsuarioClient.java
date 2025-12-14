package com.DevArt.Transacciones.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-service", url = "https://microserviciousuarios-production.up.railway.app/api/v1/usuarios")
public interface UsuarioClient {

    @GetMapping("/existe/{rut}")
    Boolean existeUsuario(@PathVariable("rut") String rut);
}