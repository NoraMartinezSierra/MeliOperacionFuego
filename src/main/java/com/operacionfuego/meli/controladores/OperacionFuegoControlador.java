package com.operacionfuego.meli.controladores;

import com.operacionfuego.meli.dto.Respuesta;
import com.operacionfuego.meli.dto.SatelitesDto;
import com.operacionfuego.meli.excepciones.OperacionFuegoExcepcion;
import com.operacionfuego.meli.negocio.OperacionFuegoNegocio;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topsecret")
public class OperacionFuegoControlador {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionFuegoControlador.class);

    private OperacionFuegoNegocio operacionFuegoNegocio;

    @Autowired
    public void setOperacionFuegoNegocio(OperacionFuegoNegocio operacionFuegoNegocio) {
        this.operacionFuegoNegocio = operacionFuegoNegocio;
    }

    /* Servicio que recibe la lista de satelites y crea el mensaje y calcula la posicion
     * Autor: Nora Martinez
     * Fecha: febrero 2023*/
    @ApiOperation(value = "Determina el mensaje y la ubicacion",
            responseContainer = "Object"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error server")
    })
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Respuesta> postSatelites(@RequestBody List<SatelitesDto> listaSatelites)
            throws OperacionFuegoExcepcion {
        Respuesta respuesta = operacionFuegoNegocio.postMensajeSecreto(listaSatelites);
        return ResponseEntity.ok(respuesta);
    }

    /* Servicio que recibe un solo satelite y crea el mensaje y lo retorna
     * Autor: Nora Martinez
     * Fecha: febrero 2023*/
    @ApiOperation(value = "Determina el mensaje y la ubicacion de un solo satelite",
            responseContainer = "Object"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal error server")
    })
    @PostMapping(
            path = "/topsecret_split",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Respuesta> mensajeUnSatelite(@RequestBody List<SatelitesDto> listaSatelites,
                                                       @RequestParam String name) throws OperacionFuegoExcepcion {
        Respuesta respuesta = operacionFuegoNegocio.postMensajeSecretoUnSatelite(listaSatelites);
        return ResponseEntity.ok(respuesta);
    }
}
