package com.operacionfuego.meli.excepciones;

import org.springframework.http.HttpStatus;

public class OperacionFuegoExcepcion extends Exception {

    public int status;
    public String mensaje;

    public OperacionFuegoExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public OperacionFuegoExcepcion(HttpStatus status, String mensaje) {
        this.status = status.value();
        this.mensaje = mensaje;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
