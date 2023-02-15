package com.operacionfuego.meli.controladores;

import com.operacionfuego.meli.dto.Respuesta;
import com.operacionfuego.meli.dto.Satelites;
import com.operacionfuego.meli.negocio.OperacionFuegoNegocio;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/topsecret")
public class OperacionFuegoControlador {

    private OperacionFuegoNegocio operacionFuegoNegocio;

    @Autowired
    public void setOperacionFuegoNegocio(OperacionFuegoNegocio operacionFuegoNegocio) {
        this.operacionFuegoNegocio = operacionFuegoNegocio;
    }

    /*
     * Autor: Nora Martinez
     * Fecha: febrero 2023*/
    @ApiOperation(value = "Abstract all app",
            responseContainer = "Object"
    )
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Respuesta> abstractMovements(@RequestBody Satelites satelites) {
        Respuesta respuesta = operacionFuegoNegocio.postSecret(satelites);
        return ResponseEntity.ok(respuesta);
    }
}
