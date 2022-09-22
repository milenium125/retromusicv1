package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.Reproducidas;
import com.example.retromusic_v1.InterfacesServices.ReproducidasServiceInterface;
import com.example.retromusic_v1.Repositories.ReproducidasRepository;

@Service
public class ReproducidasServices implements ReproducidasServiceInterface{
    private ReproducidasRepository rRepository;
    private final Logger log = LoggerFactory.getLogger(ReproducidasServices.class);
    
    public ReproducidasServices(ReproducidasRepository rRepository){
        this.rRepository = rRepository;
    }

    @Override
    public ResponseEntity<Reproducidas> saveLista(Reproducidas cancion) {
        if(cancion.getIdReproducidas() == null){
            Reproducidas result = rRepository.save(cancion);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<Reproducidas> listarListas() {
        return rRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Reproducidas>> findListaById(Long idCancion) {
        if(rRepository.existsById(idCancion)){
            Optional<Reproducidas> result = rRepository.findById(idCancion);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Reproducidas> updateLista(Reproducidas cancion) {
        if(cancion.getIdReproducidas() != null){
            if (rRepository.existsById(cancion.getIdReproducidas())) {
                Reproducidas result = rRepository.save(cancion);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Reproducidas> deleteListaById(Long idCancion) {
        if(rRepository.existsById(idCancion)){
            rRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    
}