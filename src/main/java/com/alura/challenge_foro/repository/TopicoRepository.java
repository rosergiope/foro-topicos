package com.alura.challenge_foro.repository;

import com.alura.challenge_foro.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
