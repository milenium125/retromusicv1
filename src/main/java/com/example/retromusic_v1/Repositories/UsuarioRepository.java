package com.example.retromusic_v1.Repositories;

import com.example.retromusic_v1.Entities.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreUsuario(String nombreUsuario);
}
