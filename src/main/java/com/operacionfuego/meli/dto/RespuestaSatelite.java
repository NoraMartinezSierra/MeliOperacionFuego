package com.operacionfuego.meli.dto;

public class RespuestaSatelite {

    private String mensaje;
    private PosicionDto posicionDto;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PosicionDto getPosicionDto() {
        return posicionDto;
    }

    public void setPosicionDto(PosicionDto posicionDto) {
        this.posicionDto = posicionDto;
    }
}
