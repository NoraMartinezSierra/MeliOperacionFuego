package com.operacionfuego.meli.dto;

public class Respuesta {

    private Boolean exitosa;
    private Integer estado;
    private String mensaje;
    private Documentos documentos;

    public Boolean getExitosa() {
        return exitosa;
    }

    public void setExitosa(Boolean exitosa) {
        this.exitosa = exitosa;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }
}
