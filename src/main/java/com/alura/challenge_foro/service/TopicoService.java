package com.alura.challenge_foro.service;

import com.alura.challenge_foro.dto.topico.TopicoActualizaDTO;
import com.alura.challenge_foro.dto.topico.TopicoRegistraDTO;
import com.alura.challenge_foro.infra.errores.ValidacionException;
import com.alura.challenge_foro.model.Topico;
import com.alura.challenge_foro.model.Usuario;
import com.alura.challenge_foro.repository.TopicoRepository;
import com.alura.challenge_foro.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico registrarTopico(TopicoRegistraDTO topicoRegistraDTO) {
        if (!usuarioRepository.existsById(topicoRegistraDTO.idUsuario())) {
            throw new ValidacionException("No existe un usuario con el id " + topicoRegistraDTO.idUsuario());
        }
        Optional<Usuario> usuario = usuarioRepository.findById(topicoRegistraDTO.idUsuario());
        if (usuario.isPresent()) {
            Topico topico = topicoRepository.save(
                    new Topico(null, topicoRegistraDTO.titulo(),
                            topicoRegistraDTO.mensaje(), null, null,
                            topicoRegistraDTO.cursoNombre(),
                            usuario.get()));
            return topico;
        }
        return null;
    }

    public Topico buscarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id " + id);
        }
        return topicoRepository.getReferenceById(id);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico actualizarTopico(@Valid TopicoActualizaDTO topicoActualizaDTO) {
        if (!topicoRepository.existsById(topicoActualizaDTO.id())) {
            throw new ValidacionException("No existe un topico con el id " + topicoActualizaDTO.id());
        }
        Topico topico = topicoRepository.getReferenceById(topicoActualizaDTO.id());
        topico.actualizarDatos(topicoActualizaDTO);
        return topico;
    }

    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id " + id);
        }
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
