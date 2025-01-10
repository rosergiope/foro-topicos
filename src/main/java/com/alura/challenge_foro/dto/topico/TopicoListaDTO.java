package com.alura.challenge_foro.dto.topico;

import com.alura.challenge_foro.model.Topico;

import java.time.LocalDateTime;

public record TopicoListaDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String cursoNombre,
        Boolean status
) {
    public TopicoListaDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getCursoNombre(), topico.getStatus());
    }
}
