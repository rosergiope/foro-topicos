package com.alura.challenge_foro.controller;

import com.alura.challenge_foro.dto.topico.TopicoActualizaDTO;
import com.alura.challenge_foro.dto.topico.TopicoListaDTO;
import com.alura.challenge_foro.dto.topico.TopicoRegistraDTO;
import com.alura.challenge_foro.dto.topico.TopicoRespuestaDTO;
import com.alura.challenge_foro.model.Topico;
import com.alura.challenge_foro.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoRespuestaDTO> registrarTopico(@RequestBody @Valid TopicoRegistraDTO topicoRegistraDTO) {
        Topico topico = topicoService.registrarTopico(topicoRegistraDTO);

        TopicoRespuestaDTO topicoRespuestaDTO = new TopicoRespuestaDTO(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getCursoNombre(), topico.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoRespuestaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoRespuestaDTO> buscarTopico(@PathVariable Long id) {
        Topico topico = topicoService.buscarTopico(id);

        TopicoRespuestaDTO topicoRespuestaDTO = new TopicoRespuestaDTO(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getCursoNombre(), topico.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(topicoRespuestaDTO);
    }

    @GetMapping
    public ResponseEntity<List<TopicoListaDTO>> listarTopicos() {
        return ResponseEntity.status(HttpStatus.OK).body(topicoService.listarTopicos().stream().map(TopicoListaDTO::new).toList());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> actualizarTopicos(@RequestBody @Valid TopicoActualizaDTO topicoActualizaDTO) {
        Topico topico = topicoService.actualizarTopico(topicoActualizaDTO);
        TopicoRespuestaDTO topicoRespuestaDTO = new TopicoRespuestaDTO(
                topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getCursoNombre(), topico.getStatus());
        return ResponseEntity.status(HttpStatus.OK).body(topicoRespuestaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopicos(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
