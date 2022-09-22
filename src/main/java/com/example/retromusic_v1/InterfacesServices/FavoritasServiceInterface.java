package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.Favoritas;

public interface FavoritasServiceInterface {
    public ResponseEntity<Favoritas> saveFavoritas(Favoritas favorita);
    public List<Favoritas> listarFavoritas();
    public ResponseEntity<Optional<Favoritas>> findfavoritaById(Long idCancion);
    public ResponseEntity<Favoritas> updateFavorita(Favoritas cancion);
    public ResponseEntity<Favoritas> deleteFavoritaById(Long idCancion);
}
