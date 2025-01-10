package com.alura.challenge_foro.infra.errores;

public class ValidacionException  extends RuntimeException {
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
