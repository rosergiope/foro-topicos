package com.alura.challenge_foro.dto.topico;

import java.time.LocalDateTime;

public record TopicoRespuestaDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String cursoNombre,
        Boolean status
) {
}
