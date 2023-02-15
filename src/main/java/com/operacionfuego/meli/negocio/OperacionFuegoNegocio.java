package com.operacionfuego.meli.negocio;

import com.operacionfuego.meli.dto.Respuesta;
import com.operacionfuego.meli.dto.Satelites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OperacionFuegoNegocio {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionFuegoNegocio.class);


    public Respuesta postSecret(Satelites satelites){
        Respuesta respuesta = new Respuesta();
        LOGGER.info("Satelites: {}",satelites);
        return respuesta;
    }
}
