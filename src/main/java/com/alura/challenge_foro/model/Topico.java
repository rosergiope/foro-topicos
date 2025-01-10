package com.alura.challenge_foro.model;

import com.alura.challenge_foro.dto.topico.TopicoActualizaDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String cursoNombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;



    public Topico() {
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Boolean status, String cursoNombre, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.cursoNombre = cursoNombre;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void actualizarDatos(@Valid TopicoActualizaDTO topicoActualizaDTO) {
        if(topicoActualizaDTO.titulo() != null){
            this.titulo = topicoActualizaDTO.titulo();
        }
        if(topicoActualizaDTO.mensaje() != null){
            this.mensaje = topicoActualizaDTO.mensaje();
        }
        if(topicoActualizaDTO.status() != null){
            this.status = topicoActualizaDTO.status();
        }
    }
}
