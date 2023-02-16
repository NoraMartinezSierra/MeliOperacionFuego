package com.operacionfuego.meli.negocio;

import com.operacionfuego.meli.dto.Respuesta;
import com.operacionfuego.meli.dto.Satelites;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacionFuegoNegocio {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionFuegoNegocio.class);


    public Respuesta postSecret(List<Satelites> listaSatelites){
        LOGGER.info("Satelites: {}",listaSatelites);
        Respuesta respuesta ;
        respuesta = respuestaEstandar(200,"Post success");

        return respuesta;
    }

    public Respuesta respuestaEstandar(Integer status, String message) {
        Respuesta res = new Respuesta();
        res.setEstado(status);
        res.setMensaje(message);
        res.setExitosa(true);
        return res;
    }
}
