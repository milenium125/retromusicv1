package com.example.retromusic_v1.Repositories;

import com.example.retromusic_v1.Entities.Cancion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByDisco(String disco);
    List<Cancion> findByFecha(String fecha);
    List<Cancion> findByIdAutor(Long idAutor);
    List<Cancion> findByGenero(String genero);
}
