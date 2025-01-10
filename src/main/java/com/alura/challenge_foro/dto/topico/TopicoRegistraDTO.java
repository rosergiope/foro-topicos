package com.alura.challenge_foro.dto.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRegistraDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String cursoNombre,
        @NotNull
        Long idUsuario
) {
}
