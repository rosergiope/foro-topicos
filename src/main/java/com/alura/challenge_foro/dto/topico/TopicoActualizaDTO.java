package com.alura.challenge_foro.dto.topico;

import jakarta.validation.constraints.NotNull;

public record TopicoActualizaDTO(
        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Boolean status
) {
}
