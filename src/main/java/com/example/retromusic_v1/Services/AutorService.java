package com.example.retromusic_v1.Services;

import com.example.retromusic_v1.Entities.Autor;
import com.example.retromusic_v1.InterfacesServices.AutorServiceInterface;
import com.example.retromusic_v1.Repositories.AutorRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements AutorServiceInterface {
    private AutorRepository Arepository;
    private final Logger log = LoggerFactory.getLogger(AutorService.class);

    public AutorService(AutorRepository Arepository){
        this.Arepository = Arepository;
    }
    @Override
    public ResponseEntity<Autor> saveAutor(Autor autor) {
        if (autor.getIdAutor() != null) {
            log.warn("Trying create a Autor with Id");
            return ResponseEntity.badRequest().build();
        } else {
            Autor result = Arepository.save(autor);
            return ResponseEntity.ok(result);
        }
        
    }

    @Override
    public List<Autor> listarAutores() {
        return Arepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Autor>> findAutorById(Long idAutor) {
        Optional<Autor> OptAutor = Arepository.findById(idAutor);
        if (OptAutor.isPresent()) {
            return ResponseEntity.ok(OptAutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Autor>updateAutor(Autor autor) {
        if(autor.getIdAutor() != null){
            if (Arepository.existsById(autor.getIdAutor())) {
                Autor result = Arepository.save(autor);
                return ResponseEntity.ok(result);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.badRequest().build();
        }
        
    }

    @Override
    public ResponseEntity<Autor> deleteAutorById(Long idAutor) {
        if(Arepository.existsById(idAutor)){
            Arepository.deleteById(idAutor);
            return ResponseEntity.noContent().build();
        }
        else{
            log.warn("Autor non existing");
            return ResponseEntity.notFound().build();
        }
    }

    
}
