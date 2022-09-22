package com.example.retromusic_v1.InterfacesServices;

import com.example.retromusic_v1.Entities.Autor;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;


public interface AutorServiceInterface {
    public ResponseEntity<Autor> saveAutor(Autor autor);
    public List<Autor> listarAutores();
    public ResponseEntity<Optional<Autor>> findAutorById(Long idAutor);
    public ResponseEntity<Autor> updateAutor(Autor autor);
    public ResponseEntity<Autor> deleteAutorById(Long idAutor);
    
}
