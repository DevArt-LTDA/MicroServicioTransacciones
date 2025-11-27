package com.DevArt.Transacciones.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "trabajadores-service", url = "http://localhost:8090/api/v1/trabajadores")
public interface TrabajadorClient {

    @GetMapping("/existe/{rut}")
    Boolean existeTrabajador(@PathVariable("rut") String rut);

}
