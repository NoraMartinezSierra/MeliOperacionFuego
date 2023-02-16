package com.operacionfuego.meli.negocio;

import com.lemmingapex.trilateration.LinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.operacionfuego.meli.dto.Documentos;
import com.operacionfuego.meli.dto.PosicionDto;
import com.operacionfuego.meli.dto.Respuesta;
import com.operacionfuego.meli.dto.RespuestaSatelite;
import com.operacionfuego.meli.dto.SatelitesDto;
import com.operacionfuego.meli.excepciones.OperacionFuegoExcepcion;
import com.operacionfuego.meli.util.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class OperacionFuegoNegocio {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperacionFuegoNegocio.class);

    /**
     * Servicio que organiza el mensaje y calcula la posición
     * Autor : Nora Martinez
     * Fecha : febrero 2023
     *
     * @param listaSatelites
     * @return
     */
    public Respuesta postMensajeSecreto(List<SatelitesDto> listaSatelites) throws OperacionFuegoExcepcion {
        LOGGER.info("Satelites enviados: {}", listaSatelites);
        Respuesta respuesta;
        RespuestaSatelite respuestaSatelite = new RespuestaSatelite();
        respuestaSatelite.setMensaje(obtenerMensaje(listaSatelites));
        respuestaSatelite.setPosicionDto(obtenerUbicacion(listaSatelites));
        respuesta = respuestaEstandar(200, "Post exitoso", respuestaSatelite);

        return respuesta;
    }

    /**
     * Método que valida el tamaño del array de string de cada objeto, y con programacion funcional
     * unifica los mensajes y luego los filtra para quitar las palabras repetidas o nulas
     * Autor : Nora Martinez
     * Fecha : febrero 2023
     *
     * @param listaSatelistes
     * @return
     */
    public String obtenerMensaje(List<SatelitesDto> listaSatelistes) throws OperacionFuegoExcepcion {

        Integer numero = listaSatelistes.stream().map(x -> x.getMessage().size()).mapToInt(z -> z).max().getAsInt();
        if (numero <= 0) {
            throw new OperacionFuegoExcepcion(HttpStatus.NOT_FOUND, "El tamaño del mensaje es invalido.");
        }
        AtomicInteger atomicMaxSize = new AtomicInteger(numero);
        listaSatelistes.stream().map(x -> x.getMessage()).forEach(x -> {
            if (x.size() < atomicMaxSize.get()) {
                Integer stop = atomicMaxSize.get() - x.size();
                for (Integer i = 0; i < stop; i++) {
                    x.add(i, "");
                }
            }
        });
        String[] listMessage = new String[numero];
        // merge arrays, reverse mode
        for (int i = (numero - 1); i >= 0; i--) {
            AtomicInteger j = new AtomicInteger(i);
            listaSatelistes.stream().map(x -> x.getMessage()).forEach(x -> {
                if (Objects.nonNull(x.get(j.get())) && !x.get(j.get()).trim().isEmpty()) {
                    listMessage[j.get()] = (x.get(j.get()));
                }
            });
        }
        return Arrays.stream(listMessage).filter(x -> Objects.nonNull(x) && !x.trim().isEmpty()).collect(Collectors.joining(" "));
    }

    /**
     * Calcula la posicion para la lista de satelites con una funcion
     *
     * @param dataSatellites data
     * @return
     * @throws OperacionFuegoExcepcion
     */
    public PosicionDto obtenerUbicacion(List<SatelitesDto> dataSatellites) throws OperacionFuegoExcepcion {
        double[] distances = dataSatellites.stream().mapToDouble(x -> x.getDistance().doubleValue()).toArray();
        LinearLeastSquaresSolver linearLeastSquaresSolver = new LinearLeastSquaresSolver(new TrilaterationFunction(Constantes.SATELLITES_POSITIONS, distances));
        double[] xy = linearLeastSquaresSolver.solve().toArray();
        PosicionDto positionDTO = new PosicionDto();
        if (Objects.nonNull(xy) && xy.length == 2) {
            positionDTO.setX(xy[0]);
            positionDTO.setY(xy[1]);
            return positionDTO;
        }
        throw new OperacionFuegoExcepcion("Fallo al calcular la posición.");
    }


    /**
     * Crea una respuesta generica con los datos que recibe y retorna un objeto generico
     *
     * @param estado
     * @param mensage
     * @param objeto
     * @return
     */
    public Respuesta respuestaEstandar(Integer estado, String mensage, Object objeto) {
        Respuesta res = new Respuesta();
        res.setEstado(estado);
        res.setMensaje(mensage);
        res.setExitosa(true);
        Documentos documentos = new Documentos();
        documentos.setData(objeto);
        res.setDocumentos(documentos);
        return res;
    }

    public Respuesta postMensajeSecretoUnSatelite(List<SatelitesDto> listaSatelites) throws OperacionFuegoExcepcion {
        LOGGER.info("Satelites enviados: {}", listaSatelites);
        Respuesta respuesta;
        RespuestaSatelite respuestaSatelite = new RespuestaSatelite();
        respuestaSatelite.setMensaje(obtenerMensaje(listaSatelites));
        respuesta = respuestaEstandar(200, "Post exitoso", respuestaSatelite);

        return respuesta;
    }
}
